
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.purejosh.sweetberryfoods.init;

import net.purejosh.sweetberryfoods.item.SweetBerryTartItem;
import net.purejosh.sweetberryfoods.item.SweetBerryMuffinItem;
import net.purejosh.sweetberryfoods.item.SweetBerryJuiceItem;
import net.purejosh.sweetberryfoods.item.CookedSweetBerriesItem;
import net.purejosh.sweetberryfoods.SweetberryfoodsMod;

import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

public class SweetberryfoodsModItems {
	public static Item COOKED_SWEET_BERRIES;
	public static Item SWEET_BERRY_TART;
	public static Item SWEET_BERRY_MUFFIN;
	public static Item SWEET_BERRY_JUICE;

	public static void load() {
		COOKED_SWEET_BERRIES = Registry.register(Registry.ITEM, new ResourceLocation(SweetberryfoodsMod.MODID, "cooked_sweet_berries"),
				new CookedSweetBerriesItem());
		SWEET_BERRY_TART = Registry.register(Registry.ITEM, new ResourceLocation(SweetberryfoodsMod.MODID, "sweet_berry_tart"),
				new SweetBerryTartItem());
		SWEET_BERRY_MUFFIN = Registry.register(Registry.ITEM, new ResourceLocation(SweetberryfoodsMod.MODID, "sweet_berry_muffin"),
				new SweetBerryMuffinItem());
		SWEET_BERRY_JUICE = Registry.register(Registry.ITEM, new ResourceLocation(SweetberryfoodsMod.MODID, "sweet_berry_juice"),
				new SweetBerryJuiceItem());
	}
}
