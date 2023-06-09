
package net.purejosh.sweetberryfoods.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.food.FoodProperties;

public class CocoaCoveredSweetBerriesItem extends Item {
	public CocoaCoveredSweetBerriesItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.15f)

				.build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 32;
	}
}
