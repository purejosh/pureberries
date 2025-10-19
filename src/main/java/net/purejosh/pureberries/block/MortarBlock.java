package net.purejosh.pureberries.block;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;
import net.purejosh.pureberries.block.entity.MortarBlockEntity;
import net.purejosh.pureberries.recipe.MortarRecipeManager;
import net.purejosh.pureberries.sound.ModSoundEvents;
import net.purejosh.pureberries.world.ModGameRules;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MortarBlock extends Block implements BlockEntityProvider {
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    private static final VoxelShape SHAPE = Block.createCuboidShape(4, 0, 4, 12, 5, 12);
    private final int maxDurability;

    public MortarBlock(Settings settings, int maxDurability) {
        super(settings);
        this.maxDurability = maxDurability;
        setDefaultState(getStateManager().getDefaultState().with(FACING, Direction.NORTH));
    }

    public int getMaxDurability() {
        return maxDurability;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        // Set default rotation
        BlockState state = this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());

        if (!canPlaceAt(state, ctx.getWorld(), ctx.getBlockPos())) {
            return null;
        }
        return state;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        // Allow placement if the block below has a complete solid top face
        BlockPos below = pos.down();
        if (!world.getBlockState(below)
                .isSideSolidFullSquare(world, below, Direction.UP)) {
            return false;
        }
        return super.canPlaceAt(state, world, pos);
    }

    @Override
    protected BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        // Only care when the support below changes
        if (direction == Direction.DOWN && !state.canPlaceAt(world, pos)) {
            // Return AIR → triggers onStateReplaced → drops with durability logic
            return Blocks.AIR.getDefaultState();
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new MortarBlockEntity(pos, state);
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) {
            return ItemActionResult.success(false);
        }

        ItemStack held = player.getStackInHand(hand);
        List<ItemStack> outputs = MortarRecipeManager.getOutputsFor(held.getItem());
        if (outputs.isEmpty()) {
            return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
        }

        grind(world, pos, player, held, outputs);
        return ItemActionResult.success(true);
    }

    private void grind(World world, BlockPos pos, PlayerEntity player, ItemStack held, List<ItemStack> outputs) {
        if (!player.isCreative()) {
            held.decrement(1);
        }

        for (ItemStack drop : outputs) {
            if (drop.isEmpty()) continue;
            double x = pos.getX() + 0.5;
            double y = pos.getY() + 0.33;
            double z = pos.getZ() + 0.5;
            ItemEntity entity = new ItemEntity(world, x, y, z, drop.copy());
            double speed = 0.05;
            entity.setVelocity(
                    (world.random.nextDouble() - 0.5) * speed,
                    world.random.nextDouble() * 0.15,
                    (world.random.nextDouble() - 0.5) * speed
            );
            entity.setPickupDelay(10);
            world.spawnEntity(entity);
        }

        if (player.getWorld() instanceof ServerWorld s) {
            s.playSound(null, pos, ModSoundEvents.MORTAR_USE, SoundCategory.BLOCKS, 0.3f, 1.3f);
            s.playSound(null, pos, ModSoundEvents.MORTAR_PLANT, SoundCategory.BLOCKS, 1.0f, 0.5f);
            s.spawnParticles(ParticleTypes.COMPOSTER, pos.getX() + 0.5, pos.getY() + 0.35, pos.getZ() + 0.5,
                    3, 0.1, 0.02, 0.1, 1);
        }

        world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, world.getBlockState(pos)));
        player.incrementStat(Stats.USED.getOrCreateStat(held.getItem()));

        BlockEntity be = world.getBlockEntity(pos);
        if (be instanceof MortarBlockEntity mortar && world.getGameRules().getBoolean(ModGameRules.MORTAR_DURABILITY)) {
            mortar.decrementDurability();
            mortar.markDirty();
        }
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isClient && player.isCreative()) {
            world.removeBlockEntity(pos);
        }

        super.onBreak(world, pos, state, player);
        return state;
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity be = world.getBlockEntity(pos);
            if (be instanceof MortarBlockEntity mortar) {
                // Prevent dropping a broken mortar
                if (mortar.getDurability() > 0) {
                    // Map the block id to an item in the registry
                    Identifier id = Registries.BLOCK.getId(state.getBlock());
                    Item mortarItem = Registries.ITEM.get(id);
                    ItemStack drop = new ItemStack(mortarItem);
                    // Inverse the durability to damage, and drop.
                    int damage = maxDurability - mortar.getDurability();
                    drop.setDamage(damage);

                    ItemEntity entity = new ItemEntity(world, pos.getX() + .5, pos.getY() + .5, pos.getZ() + .5, drop);
                    entity.setPickupDelay(10);
                    world.spawnEntity(entity);
                }
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        super.onPlaced(world, pos, state, placer, stack);

        if (world.isClient) return;

        BlockEntity be = world.getBlockEntity(pos);
        if (!(be instanceof MortarBlockEntity mortar)) return;

        // Clamp damage read from the stack so it never goes below 0 or above maxDurability
        int used = MathHelper.clamp(stack.getDamage(), 0, this.maxDurability);

        // Apply durability to the placed mortar
        mortar.setDurability(this.maxDurability - used);
        mortar.markDirty();
        world.updateListeners(pos, state, state, Block.NOTIFY_LISTENERS);
    }
}