
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.purejosh.sweetberryfoods.init;

import net.purejosh.sweetberryfoods.item.SweetBerryTartItem;
import net.purejosh.sweetberryfoods.item.SweetBerryMuffinItem;
import net.purejosh.sweetberryfoods.item.SweetBerryJuiceItem;
import net.purejosh.sweetberryfoods.item.SweetBerryJamSandwichItem;
import net.purejosh.sweetberryfoods.item.SweetBerryJamItem;
import net.purejosh.sweetberryfoods.item.SweetBerryBiscuitItem;
import net.purejosh.sweetberryfoods.item.HoneyDippedSweetBerriesItem;
import net.purejosh.sweetberryfoods.item.HoneyDippedBlueberriesItem;
import net.purejosh.sweetberryfoods.item.CookedSweetBerriesItem;
import net.purejosh.sweetberryfoods.item.CookedBlueberriesItem;
import net.purejosh.sweetberryfoods.item.CocoaCoveredSweetBerriesItem;
import net.purejosh.sweetberryfoods.item.CocoaCoveredBlueberriesItem;
import net.purejosh.sweetberryfoods.item.BlueberryTartItem;
import net.purejosh.sweetberryfoods.item.BlueberryMuffinItem;
import net.purejosh.sweetberryfoods.item.BlueberryJuiceItem;
import net.purejosh.sweetberryfoods.item.BlueberryJamSandwichItem;
import net.purejosh.sweetberryfoods.item.BlueberryJamItem;
import net.purejosh.sweetberryfoods.item.BlueberryBiscuitItem;
import net.purejosh.sweetberryfoods.item.BlueberriesItem;
import net.purejosh.sweetberryfoods.SweetberryfoodsMod;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

public class SweetberryfoodsModItems {
	public static Item BLUEBERRIES;
	public static Item COOKED_SWEET_BERRIES;
	public static Item COOKED_BLUEBERRIES;
	public static Item HONEY_DIPPED_SWEET_BERRIES;
	public static Item HONEY_DIPPED_BLUEBERRIES;
	public static Item COCOA_COVERED_SWEET_BERRIES;
	public static Item COCOA_COVERED_BLUEBERRIES;
	public static Item SWEET_BERRY_JUICE;
	public static Item BLUEBERRY_JUICE;
	public static Item SWEET_BERRY_MUFFIN;
	public static Item BLUEBERRY_MUFFIN;
	public static Item SWEET_BERRY_TART;
	public static Item BLUEBERRY_TART;
	public static Item SWEET_BERRY_JAM;
	public static Item BLUEBERRY_JAM;
	public static Item SWEET_BERRY_JAM_SANDWICH;
	public static Item BLUEBERRY_JAM_SANDWICH;
	public static Item BLUEBERRY_BUSH_PLANT_STAGE_0;
	public static Item BLUEBERRY_BUSH_PLANT_STAGE_1;
	public static Item BLUEBERRY_BUSH_PLANT_STAGE_2;
	public static Item BLUEBERRY_BUSH_PLANT_STAGE_3;
	public static Item SWEET_BERRY_BISCUIT;
	public static Item BLUEBERRY_BISCUIT;

	public static void load() {
		BLUEBERRIES = Registry.register(Registry.ITEM, new ResourceLocation(SweetberryfoodsMod.MODID, "blueberries"), new BlueberriesItem());
		COOKED_SWEET_BERRIES = Registry.register(Registry.ITEM, new ResourceLocation(SweetberryfoodsMod.MODID, "cooked_sweet_berries"),
				new CookedSweetBerriesItem());
		COOKED_BLUEBERRIES = Registry.register(Registry.ITEM, new ResourceLocation(SweetberryfoodsMod.MODID, "cooked_blueberries"),
				new CookedBlueberriesItem());
		HONEY_DIPPED_SWEET_BERRIES = Registry.register(Registry.ITEM, new ResourceLocation(SweetberryfoodsMod.MODID, "honey_dipped_sweet_berries"),
				new HoneyDippedSweetBerriesItem());
		HONEY_DIPPED_BLUEBERRIES = Registry.register(Registry.ITEM, new ResourceLocation(SweetberryfoodsMod.MODID, "honey_dipped_blueberries"),
				new HoneyDippedBlueberriesItem());
		COCOA_COVERED_SWEET_BERRIES = Registry.register(Registry.ITEM, new ResourceLocation(SweetberryfoodsMod.MODID, "cocoa_covered_sweet_berries"),
				new CocoaCoveredSweetBerriesItem());
		COCOA_COVERED_BLUEBERRIES = Registry.register(Registry.ITEM, new ResourceLocation(SweetberryfoodsMod.MODID, "cocoa_covered_blueberries"),
				new CocoaCoveredBlueberriesItem());
		SWEET_BERRY_JUICE = Registry.register(Registry.ITEM, new ResourceLocation(SweetberryfoodsMod.MODID, "sweet_berry_juice"),
				new SweetBerryJuiceItem());
		BLUEBERRY_JUICE = Registry.register(Registry.ITEM, new ResourceLocation(SweetberryfoodsMod.MODID, "blueberry_juice"),
				new BlueberryJuiceItem());
		SWEET_BERRY_MUFFIN = Registry.register(Registry.ITEM, new ResourceLocation(SweetberryfoodsMod.MODID, "sweet_berry_muffin"),
				new SweetBerryMuffinItem());
		BLUEBERRY_MUFFIN = Registry.register(Registry.ITEM, new ResourceLocation(SweetberryfoodsMod.MODID, "blueberry_muffin"),
				new BlueberryMuffinItem());
		SWEET_BERRY_TART = Registry.register(Registry.ITEM, new ResourceLocation(SweetberryfoodsMod.MODID, "sweet_berry_tart"),
				new SweetBerryTartItem());
		BLUEBERRY_TART = Registry.register(Registry.ITEM, new ResourceLocation(SweetberryfoodsMod.MODID, "blueberry_tart"), new BlueberryTartItem());
		SWEET_BERRY_JAM = Registry.register(Registry.ITEM, new ResourceLocation(SweetberryfoodsMod.MODID, "sweet_berry_jam"),
				new SweetBerryJamItem());
		BLUEBERRY_JAM = Registry.register(Registry.ITEM, new ResourceLocation(SweetberryfoodsMod.MODID, "blueberry_jam"), new BlueberryJamItem());
		SWEET_BERRY_JAM_SANDWICH = Registry.register(Registry.ITEM, new ResourceLocation(SweetberryfoodsMod.MODID, "sweet_berry_jam_sandwich"),
				new SweetBerryJamSandwichItem());
		BLUEBERRY_JAM_SANDWICH = Registry.register(Registry.ITEM, new ResourceLocation(SweetberryfoodsMod.MODID, "blueberry_jam_sandwich"),
				new BlueberryJamSandwichItem());
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
		SWEET_BERRY_BISCUIT = Registry.register(Registry.ITEM, new ResourceLocation(SweetberryfoodsMod.MODID, "sweet_berry_biscuit"),
				new SweetBerryBiscuitItem());
		BLUEBERRY_BISCUIT = Registry.register(Registry.ITEM, new ResourceLocation(SweetberryfoodsMod.MODID, "blueberry_biscuit"),
				new BlueberryBiscuitItem());
	}
}
