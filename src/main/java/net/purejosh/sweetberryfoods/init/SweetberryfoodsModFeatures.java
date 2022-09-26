
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.purejosh.sweetberryfoods.init;

import net.purejosh.sweetberryfoods.world.features.plants.BlueberryBushPlantStage3Feature;
import net.purejosh.sweetberryfoods.SweetberryfoodsMod;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.Registry;

import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;

import java.util.function.Predicate;

public class SweetberryfoodsModFeatures {
	public static void load() {
		register("blueberry_bush_plant_stage_3", BlueberryBushPlantStage3Feature.feature(), BlueberryBushPlantStage3Feature.GENERATE_BIOMES,
				GenerationStep.Decoration.VEGETAL_DECORATION);
	}

	private static void register(String registryName, Feature feature, Predicate<BiomeSelectionContext> biomes, GenerationStep.Decoration genStep) {
		Registry.register(Registry.FEATURE, new ResourceLocation(SweetberryfoodsMod.MODID, registryName), feature);
		BiomeModifications.addFeature(biomes, genStep,
				ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY, new ResourceLocation(SweetberryfoodsMod.MODID, registryName)));
	}
}
