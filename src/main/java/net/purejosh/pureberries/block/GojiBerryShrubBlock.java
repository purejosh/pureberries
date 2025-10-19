package net.purejosh.pureberries.block;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;
import net.purejosh.pureberries.item.ModItems;

public class GojiBerryShrubBlock extends SweetBerryBushBlock {
    public static final int MAX_AGE = 3;
    private static final VoxelShape STAGE0_SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 7.0, 15.0);
    private static final VoxelShape STAGE1_SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 12.0, 15.0);
    private static final VoxelShape STAGE2_SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 16.0, 15.0);

    public GojiBerryShrubBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(AGE, 0));
    }

    @Override
    public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
        return new ItemStack(ModItems.GOJI_BERRIES);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(AGE) == 0) {
            return STAGE0_SHAPE;
        } else if (state.get(AGE) == 1) {
            return STAGE1_SHAPE;
        } else if (state.get(AGE) == 2) {
            return STAGE2_SHAPE;
        } else {
            return super.getOutlineShape(state, world, pos, context);
        }
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity && entity.getType() != EntityType.FOX && entity.getType() != EntityType.BEE) {
            double entityY = entity.getBoundingBox().minY; // Get the bottom of the entity's bounding box
            double blockY = pos.getY(); // Get the block's Y position

            // Check if the entity is within the bottom 5 pixels of the block
            if (entityY <= blockY + 0.625) {
                entity.slowMovement(state, new Vec3d(0.99F, 0.99F, 0.99F));
            }
        }
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        int i = state.get(AGE);
        boolean bl = i == 3;
        if (i > 1) {
            int j = 1 + world.random.nextInt(2);
            dropStack(world, pos, new ItemStack(ModItems.GOJI_BERRIES, j + (bl ? 1 : 0)));
            world.playSound(null, pos, SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);
            BlockState blockState = state.with(AGE, 1);
            world.setBlockState(pos, blockState, Block.NOTIFY_LISTENERS);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, blockState));
            return ActionResult.success(world.isClient);
        } else {
            return super.onUse(state, world, pos, player, hit);
        }
    }
}
