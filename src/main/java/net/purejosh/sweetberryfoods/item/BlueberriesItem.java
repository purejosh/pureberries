
package net.purejosh.sweetberryfoods.item;

import net.purejosh.sweetberryfoods.procedures.BlueberriesRightclickedOnBlockProcedure;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.InteractionResult;

public class BlueberriesItem extends Item {
	public BlueberriesItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(64).rarity(Rarity.COMMON)
				.food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.4f)

						.build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 32;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		InteractionResult retval = super.useOn(context);
		BlueberriesRightclickedOnBlockProcedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder()
				.put("world", context.getLevel()).put("x", context.getClickedPos().getX()).put("y", context.getClickedPos().getY())
				.put("z", context.getClickedPos().getZ()).put("entity", context.getPlayer()).build());
		return retval;
	}
}
