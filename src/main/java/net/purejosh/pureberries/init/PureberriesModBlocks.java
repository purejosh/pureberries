
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.purejosh.pureberries.init;

import net.purejosh.pureberries.block.GojiBerryBushStage7Block;
import net.purejosh.pureberries.block.GojiBerryBushStage6Block;
import net.purejosh.pureberries.block.GojiBerryBushStage5Block;
import net.purejosh.pureberries.block.GojiBerryBushStage4Block;
import net.purejosh.pureberries.block.GojiBerryBushStage3Block;
import net.purejosh.pureberries.block.GojiBerryBushStage2Block;
import net.purejosh.pureberries.block.GojiBerryBushStage1Block;
import net.purejosh.pureberries.block.GojiBerryBushStage0Block;
import net.purejosh.pureberries.block.CloudberryPlantStage3Block;
import net.purejosh.pureberries.block.CloudberryPlantStage2Block;
import net.purejosh.pureberries.block.CloudberryPlantStage1Block;
import net.purejosh.pureberries.block.CloudberryPlantStage0Block;
import net.purejosh.pureberries.block.BlueberryBushStage3Block;
import net.purejosh.pureberries.block.BlueberryBushStage2Block;
import net.purejosh.pureberries.block.BlueberryBushStage1Block;
import net.purejosh.pureberries.block.BlueberryBushStage0Block;
import net.purejosh.pureberries.block.BlueberryBushPlantStage3Block;
import net.purejosh.pureberries.block.BlueberryBushPlantStage2Block;
import net.purejosh.pureberries.block.BlueberryBushPlantStage1Block;
import net.purejosh.pureberries.block.BlueberryBushPlantStage0Block;
import net.purejosh.pureberries.PureberriesMod;

import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

public class PureberriesModBlocks {
	public static Block BLUEBERRY_BUSH_PLANT_STAGE_0;
	public static Block BLUEBERRY_BUSH_PLANT_STAGE_1;
	public static Block BLUEBERRY_BUSH_PLANT_STAGE_2;
	public static Block BLUEBERRY_BUSH_PLANT_STAGE_3;
	public static Block GOJI_BERRY_BUSH_STAGE_0;
	public static Block GOJI_BERRY_BUSH_STAGE_1;
	public static Block GOJI_BERRY_BUSH_STAGE_2;
	public static Block GOJI_BERRY_BUSH_STAGE_3;
	public static Block GOJI_BERRY_BUSH_STAGE_4;
	public static Block GOJI_BERRY_BUSH_STAGE_5;
	public static Block GOJI_BERRY_BUSH_STAGE_6;
	public static Block GOJI_BERRY_BUSH_STAGE_7;
	public static Block CLOUDBERRY_PLANT_STAGE_0;
	public static Block CLOUDBERRY_PLANT_STAGE_1;
	public static Block CLOUDBERRY_PLANT_STAGE_2;
	public static Block CLOUDBERRY_PLANT_STAGE_3;
	public static Block BLUEBERRY_BUSH_STAGE_0;
	public static Block BLUEBERRY_BUSH_STAGE_1;
	public static Block BLUEBERRY_BUSH_STAGE_2;
	public static Block BLUEBERRY_BUSH_STAGE_3;

	public static void load() {
		BLUEBERRY_BUSH_PLANT_STAGE_0 = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(PureberriesMod.MODID, "blueberry_bush_plant_stage_0"), new BlueberryBushPlantStage0Block());
		BLUEBERRY_BUSH_PLANT_STAGE_1 = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(PureberriesMod.MODID, "blueberry_bush_plant_stage_1"), new BlueberryBushPlantStage1Block());
		BLUEBERRY_BUSH_PLANT_STAGE_2 = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(PureberriesMod.MODID, "blueberry_bush_plant_stage_2"), new BlueberryBushPlantStage2Block());
		BLUEBERRY_BUSH_PLANT_STAGE_3 = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(PureberriesMod.MODID, "blueberry_bush_plant_stage_3"), new BlueberryBushPlantStage3Block());
		GOJI_BERRY_BUSH_STAGE_0 = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(PureberriesMod.MODID, "goji_berry_bush_stage_0"), new GojiBerryBushStage0Block());
		GOJI_BERRY_BUSH_STAGE_1 = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(PureberriesMod.MODID, "goji_berry_bush_stage_1"), new GojiBerryBushStage1Block());
		GOJI_BERRY_BUSH_STAGE_2 = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(PureberriesMod.MODID, "goji_berry_bush_stage_2"), new GojiBerryBushStage2Block());
		GOJI_BERRY_BUSH_STAGE_3 = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(PureberriesMod.MODID, "goji_berry_bush_stage_3"), new GojiBerryBushStage3Block());
		GOJI_BERRY_BUSH_STAGE_4 = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(PureberriesMod.MODID, "goji_berry_bush_stage_4"), new GojiBerryBushStage4Block());
		GOJI_BERRY_BUSH_STAGE_5 = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(PureberriesMod.MODID, "goji_berry_bush_stage_5"), new GojiBerryBushStage5Block());
		GOJI_BERRY_BUSH_STAGE_6 = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(PureberriesMod.MODID, "goji_berry_bush_stage_6"), new GojiBerryBushStage6Block());
		GOJI_BERRY_BUSH_STAGE_7 = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(PureberriesMod.MODID, "goji_berry_bush_stage_7"), new GojiBerryBushStage7Block());
		CLOUDBERRY_PLANT_STAGE_0 = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(PureberriesMod.MODID, "cloudberry_plant_stage_0"), new CloudberryPlantStage0Block());
		CLOUDBERRY_PLANT_STAGE_1 = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(PureberriesMod.MODID, "cloudberry_plant_stage_1"), new CloudberryPlantStage1Block());
		CLOUDBERRY_PLANT_STAGE_2 = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(PureberriesMod.MODID, "cloudberry_plant_stage_2"), new CloudberryPlantStage2Block());
		CLOUDBERRY_PLANT_STAGE_3 = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(PureberriesMod.MODID, "cloudberry_plant_stage_3"), new CloudberryPlantStage3Block());
		BLUEBERRY_BUSH_STAGE_0 = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(PureberriesMod.MODID, "blueberry_bush_stage_0"), new BlueberryBushStage0Block());
		BLUEBERRY_BUSH_STAGE_1 = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(PureberriesMod.MODID, "blueberry_bush_stage_1"), new BlueberryBushStage1Block());
		BLUEBERRY_BUSH_STAGE_2 = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(PureberriesMod.MODID, "blueberry_bush_stage_2"), new BlueberryBushStage2Block());
		BLUEBERRY_BUSH_STAGE_3 = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(PureberriesMod.MODID, "blueberry_bush_stage_3"), new BlueberryBushStage3Block());
	}

	public static void clientLoad() {
		BlueberryBushPlantStage0Block.clientInit();
		BlueberryBushPlantStage1Block.clientInit();
		BlueberryBushPlantStage2Block.clientInit();
		BlueberryBushPlantStage3Block.clientInit();
		GojiBerryBushStage0Block.clientInit();
		GojiBerryBushStage1Block.clientInit();
		GojiBerryBushStage2Block.clientInit();
		GojiBerryBushStage3Block.clientInit();
		GojiBerryBushStage4Block.clientInit();
		GojiBerryBushStage5Block.clientInit();
		GojiBerryBushStage6Block.clientInit();
		GojiBerryBushStage7Block.clientInit();
		CloudberryPlantStage0Block.clientInit();
		CloudberryPlantStage1Block.clientInit();
		CloudberryPlantStage2Block.clientInit();
		CloudberryPlantStage3Block.clientInit();
		BlueberryBushStage0Block.clientInit();
		BlueberryBushStage1Block.clientInit();
		BlueberryBushStage2Block.clientInit();
		BlueberryBushStage3Block.clientInit();
	}
}
