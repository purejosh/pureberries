
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.purejosh.pureberries.init;

import net.purejosh.pureberries.world.features.plants.GojiBerryBushStage7Feature;
import net.purejosh.pureberries.world.features.plants.CloudberryPlantStage3Feature;
import net.purejosh.pureberries.world.features.plants.BlueberryBushStage3Feature;
import net.purejosh.pureberries.PureberriesMod;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;

import java.util.function.Predicate;

public class PureberriesModFeatures {
	public static void load() {
		register("goji_berry_bush_stage_7", new GojiBerryBushStage7Feature(), GojiBerryBushStage7Feature.GENERATE_BIOMES, GenerationStep.Decoration.VEGETAL_DECORATION);
		register("cloudberry_plant_stage_3", new CloudberryPlantStage3Feature(), CloudberryPlantStage3Feature.GENERATE_BIOMES, GenerationStep.Decoration.VEGETAL_DECORATION);
		register("blueberry_bush_stage_3", new BlueberryBushStage3Feature(), BlueberryBushStage3Feature.GENERATE_BIOMES, GenerationStep.Decoration.VEGETAL_DECORATION);
	}

	private static void register(String registryName, Feature feature, Predicate<BiomeSelectionContext> biomes, GenerationStep.Decoration genStep) {
		Registry.register(BuiltInRegistries.FEATURE, new ResourceLocation(PureberriesMod.MODID, registryName), feature);
		BiomeModifications.addFeature(biomes, genStep, ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(PureberriesMod.MODID, registryName)));
	}
}
