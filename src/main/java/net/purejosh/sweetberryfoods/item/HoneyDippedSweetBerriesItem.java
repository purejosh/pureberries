
package net.purejosh.sweetberryfoods.item;

import net.purejosh.sweetberryfoods.procedures.HoneyDippedSweetBerriesPlayerFinishesUsingItemProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

public class HoneyDippedSweetBerriesItem extends Item {
	public HoneyDippedSweetBerriesItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(64).rarity(Rarity.COMMON)
				.food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.15f).alwaysEat()

						.build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 32;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		HoneyDippedSweetBerriesPlayerFinishesUsingItemProcedure
				.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("entity", entity).build());
		return retval;
	}
}
