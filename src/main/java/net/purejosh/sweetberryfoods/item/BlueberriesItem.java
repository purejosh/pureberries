
package net.purejosh.sweetberryfoods.item;

import net.purejosh.sweetberryfoods.procedures.BlueberriesRightclickedOnBlockProcedure;
import net.purejosh.sweetberryfoods.procedures.BlueberriesPlayerFinishesUsingItemProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResult;

public class BlueberriesItem extends Item {
	public BlueberriesItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(64).rarity(Rarity.COMMON)
				.food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.12f)

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

		BlueberriesPlayerFinishesUsingItemProcedure
				.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("entity", entity).build());
		return retval;
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
