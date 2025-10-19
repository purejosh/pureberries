package net.purejosh.pureberries.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;
import net.minecraft.block.CandleBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ModCakeBlock extends CakeBlock {

    public ModCakeBlock(Settings settings) {
        super(settings);
    }

    // Unfortunately, I don't feel like spending time refactoring the CandleCakeBlock logic for a feature people likely won't use.
    // For now, this code simply interrupts candle placement logic and presents a message to the player.
    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        Item item = stack.getItem();
        if (stack.isIn(ItemTags.CANDLES) && state.get(BITES) == 0 && Block.getBlockFromItem(item) instanceof CandleBlock) {
            if (player instanceof ServerPlayerEntity serverPlayer) {
                serverPlayer.sendMessage(Text.translatable("block.pureberries.cake.candle_disabled").formatted(Formatting.WHITE), true);
            }
            return ItemActionResult.SUCCESS; // Prevents the candle from being placed by passing early success.
        } else {
            return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }
    }

}
