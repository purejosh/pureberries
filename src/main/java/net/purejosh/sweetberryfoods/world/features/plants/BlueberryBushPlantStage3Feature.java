
package net.purejosh.sweetberryfoods.world.features.plants;

import net.purejosh.sweetberryfoods.init.SweetberryfoodsModBlocks;

import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.RandomPatchFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.core.Registry;
import net.minecraft.core.Holder;

import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;

import java.util.function.Predicate;
import java.util.Set;
import java.util.List;

public class BlueberryBushPlantStage3Feature extends RandomPatchFeature {
	public static BlueberryBushPlantStage3Feature FEATURE = null;
	public static Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> CONFIGURED_FEATURE = null;
	public static Holder<PlacedFeature> PLACED_FEATURE = null;

	public static Feature<?> feature() {
		FEATURE = new BlueberryBushPlantStage3Feature();
		CONFIGURED_FEATURE = FeatureUtils.register("sweetberryfoods:blueberry_bush_plant_stage_3", FEATURE,
				FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
						new SimpleBlockConfiguration(
								BlockStateProvider.simple(SweetberryfoodsModBlocks.BLUEBERRY_BUSH_PLANT_STAGE_3.defaultBlockState())),
						List.of(), 12));
		PLACED_FEATURE = PlacementUtils.register("sweetberryfoods:blueberry_bush_plant_stage_3", CONFIGURED_FEATURE, List.of(CountPlacement.of(1),
				RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
		return FEATURE;
	}

	public static final Predicate<BiomeSelectionContext> GENERATE_BIOMES = BiomeSelectors.includeByKey(
			ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("taiga")),
			ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("taiga")),
			ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("old_growth_pine_taiga")),
			ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("old_growth_pine_taiga")),
			ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("old_growth_spruce_taiga")),
			ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("old_growth_spruce_taiga")),
			ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("snowy_taiga")),
			ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("snowy_taiga")),
			ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("snowy_taiga")),
			ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("taiga")));
	private final Set<ResourceKey<Level>> generate_dimensions = Set.of(Level.OVERWORLD);

	public BlueberryBushPlantStage3Feature() {
		super(RandomPatchConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<RandomPatchConfiguration> context) {
		WorldGenLevel world = context.level();
		if (!generate_dimensions.contains(world.getLevel().dimension()))
			return false;
		return super.place(context);
	}
}
