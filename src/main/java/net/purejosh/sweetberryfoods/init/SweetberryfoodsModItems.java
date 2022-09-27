
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.purejosh.sweetberryfoods.init;

import net.purejosh.sweetberryfoods.item.SweetBerryTartItem;
import net.purejosh.sweetberryfoods.item.SweetBerryMuffinItem;
import net.purejosh.sweetberryfoods.item.SweetBerryJuiceItem;
import net.purejosh.sweetberryfoods.item.CookedSweetBerriesItem;
import net.purejosh.sweetberryfoods.item.CookedBlueberriesItem;
import net.purejosh.sweetberryfoods.item.BlueberryTartItem;
import net.purejosh.sweetberryfoods.item.BlueberryMuffinItem;
import net.purejosh.sweetberryfoods.item.BlueberryJuiceItem;
import net.purejosh.sweetberryfoods.item.BlueberriesItem;
import net.purejosh.sweetberryfoods.SweetberryfoodsMod;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

public class SweetberryfoodsModItems {
	public static Item COOKED_SWEET_BERRIES;
	public static Item SWEET_BERRY_TART;
	public static Item SWEET_BERRY_MUFFIN;
	public static Item SWEET_BERRY_JUICE;
	public static Item BLUEBERRIES;
	public static Item COOKED_BLUEBERRIES;
	public static Item BLUEBERRY_TART;
	public static Item BLUEBERRY_MUFFIN;
	public static Item BLUEBERRY_JUICE;
	public static Item BLUEBERRY_BUSH_PLANT_STAGE_0;
	public static Item BLUEBERRY_BUSH_PLANT_STAGE_1;
	public static Item BLUEBERRY_BUSH_PLANT_STAGE_2;
	public static Item BLUEBERRY_BUSH_PLANT_STAGE_3;

	public static void load() {
		COOKED_SWEET_BERRIES = Registry.register(Registry.ITEM, new ResourceLocation(SweetberryfoodsMod.MODID, "cooked_sweet_berries"),
				new CookedSweetBerriesItem());
		SWEET_BERRY_TART = Registry.register(Registry.ITEM, new ResourceLocation(SweetberryfoodsMod.MODID, "sweet_berry_tart"),
				new SweetBerryTartItem());
		SWEET_BERRY_MUFFIN = Registry.register(Registry.ITEM, new ResourceLocation(SweetberryfoodsMod.MODID, "sweet_berry_muffin"),
				new SweetBerryMuffinItem());
		SWEET_BERRY_JUICE = Registry.register(Registry.ITEM, new ResourceLocation(SweetberryfoodsMod.MODID, "sweet_berry_juice"),
				new SweetBerryJuiceItem());
		BLUEBERRIES = Registry.register(Registry.ITEM, new ResourceLocation(SweetberryfoodsMod.MODID, "blueberries"), new BlueberriesItem());
		COOKED_BLUEBERRIES = Registry.register(Registry.ITEM, new ResourceLocation(SweetberryfoodsMod.MODID, "cooked_blueberries"),
				new CookedBlueberriesItem());
		BLUEBERRY_TART = Registry.register(Registry.ITEM, new ResourceLocation(SweetberryfoodsMod.MODID, "blueberry_tart"), new BlueberryTartItem());
		BLUEBERRY_MUFFIN = Registry.register(Registry.ITEM, new ResourceLocation(SweetberryfoodsMod.MODID, "blueberry_muffin"),
				new BlueberryMuffinItem());
		BLUEBERRY_JUICE = Registry.register(Registry.ITEM, new ResourceLocation(SweetberryfoodsMod.MODID, "blueberry_juice"),
				new BlueberryJuiceItem());
		BLUEBERRY_BUSH_PLANT_STAGE_0 = Registry.register(Registry.ITEM,
				new ResourceLocation(SweetberryfoodsMod.MODID, "blueberry_bush_plant_stage_0"),
				new BlockItem(SweetberryfoodsModBlocks.BLUEBERRY_BUSH_PLANT_STAGE_0, new Item.Properties().tab(null)));
		BLUEBERRY_BUSH_PLANT_STAGE_1 = Registry.register(Registry.ITEM,
				new ResourceLocation(SweetberryfoodsMod.MODID, "blueberry_bush_plant_stage_1"),
				new BlockItem(SweetberryfoodsModBlocks.BLUEBERRY_BUSH_PLANT_STAGE_1, new Item.Properties().tab(null)));
		BLUEBERRY_BUSH_PLANT_STAGE_2 = Registry.register(Registry.ITEM,
				new ResourceLocation(SweetberryfoodsMod.MODID, "blueberry_bush_plant_stage_2"),
				new BlockItem(SweetberryfoodsModBlocks.BLUEBERRY_BUSH_PLANT_STAGE_2, new Item.Properties().tab(null)));
		BLUEBERRY_BUSH_PLANT_STAGE_3 = Registry.register(Registry.ITEM,
				new ResourceLocation(SweetberryfoodsMod.MODID, "blueberry_bush_plant_stage_3"),
				new BlockItem(SweetberryfoodsModBlocks.BLUEBERRY_BUSH_PLANT_STAGE_3, new Item.Properties().tab(null)));
	}
}
