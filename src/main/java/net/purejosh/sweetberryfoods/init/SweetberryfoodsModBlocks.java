
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.purejosh.sweetberryfoods.init;

import net.purejosh.sweetberryfoods.block.BlueberryBushPlantStage3Block;
import net.purejosh.sweetberryfoods.block.BlueberryBushPlantStage2Block;
import net.purejosh.sweetberryfoods.block.BlueberryBushPlantStage1Block;
import net.purejosh.sweetberryfoods.block.BlueberryBushPlantStage0Block;
import net.purejosh.sweetberryfoods.SweetberryfoodsMod;

import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

public class SweetberryfoodsModBlocks {
	public static Block BLUEBERRY_BUSH_PLANT_STAGE_0;
	public static Block BLUEBERRY_BUSH_PLANT_STAGE_1;
	public static Block BLUEBERRY_BUSH_PLANT_STAGE_2;
	public static Block BLUEBERRY_BUSH_PLANT_STAGE_3;

	public static void load() {
		BLUEBERRY_BUSH_PLANT_STAGE_0 = Registry.register(Registry.BLOCK, new ResourceLocation(SweetberryfoodsMod.MODID, "blueberry_bush_plant_stage_0"), new BlueberryBushPlantStage0Block());
		BLUEBERRY_BUSH_PLANT_STAGE_1 = Registry.register(Registry.BLOCK, new ResourceLocation(SweetberryfoodsMod.MODID, "blueberry_bush_plant_stage_1"), new BlueberryBushPlantStage1Block());
		BLUEBERRY_BUSH_PLANT_STAGE_2 = Registry.register(Registry.BLOCK, new ResourceLocation(SweetberryfoodsMod.MODID, "blueberry_bush_plant_stage_2"), new BlueberryBushPlantStage2Block());
		BLUEBERRY_BUSH_PLANT_STAGE_3 = Registry.register(Registry.BLOCK, new ResourceLocation(SweetberryfoodsMod.MODID, "blueberry_bush_plant_stage_3"), new BlueberryBushPlantStage3Block());
	}

	public static void clientLoad() {
		BlueberryBushPlantStage0Block.clientInit();
		BlueberryBushPlantStage1Block.clientInit();
		BlueberryBushPlantStage2Block.clientInit();
		BlueberryBushPlantStage3Block.clientInit();
	}
}
