package net.purejosh.pureberries.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.purejosh.pureberries.world.gen.feature.ModVegetationPlacedFeatures;

import java.util.List;
import java.util.function.Predicate;

public class ModBiomeModification {

    public static void addBerryBiome(RegistryKey<PlacedFeature> placedFeature, java.util.List<TagKey<Biome>> tags) {
        Predicate<BiomeSelectionContext> predicate = ctx -> tags.stream().anyMatch(ctx::hasTag);
        BiomeModifications.addFeature(predicate, GenerationStep.Feature.VEGETAL_DECORATION, placedFeature);
    }

    public static void generateBerries() {

        // Blueberry: cool/montane woodlands
        addBerryBiome(ModVegetationPlacedFeatures.PATCH_BLUEBERRY,
                List.of(BiomeTags.IS_FOREST, BiomeTags.IS_TAIGA, BiomeTags.IS_MOUNTAIN));

        // Cloudberry: cold/alpine biomes (snow-fox spawn tag)
        addBerryBiome(ModVegetationPlacedFeatures.PATCH_CLOUDBERRY,
                List.of(BiomeTags.SPAWNS_SNOW_FOXES));

        // Goji: warm, hilly and forest-edge habitats
        addBerryBiome(ModVegetationPlacedFeatures.PATCH_GOJI_BERRY,
                List.of(BiomeTags.IS_SAVANNA, BiomeTags.IS_HILL, BiomeTags.IS_FOREST));

        // Redcurrant: temperate edges and plains village qualified biomes
        addBerryBiome(ModVegetationPlacedFeatures.PATCH_REDCURRANT,
                List.of(BiomeTags.IS_FOREST, BiomeTags.IS_HILL, BiomeTags.VILLAGE_PLAINS_HAS_STRUCTURE));

        // Blackcurrant: cool, moist woods and montane pockets
        addBerryBiome(ModVegetationPlacedFeatures.PATCH_BLACKCURRANT,
                List.of(BiomeTags.IS_FOREST, BiomeTags.IS_TAIGA, BiomeTags.IS_MOUNTAIN));

        // Gooseberry: understory and hedgerow presence
        addBerryBiome(ModVegetationPlacedFeatures.PATCH_GOOSEBERRY,
                List.of(BiomeTags.IS_FOREST, BiomeTags.VILLAGE_PLAINS_HAS_STRUCTURE));

        // Cape gooseberry: subtropical/wet lowlands (swamp spawn tag)
        addBerryBiome(ModVegetationPlacedFeatures.PATCH_CAPE_GOOSEBERRY,
                List.of(BiomeTags.IS_JUNGLE, BiomeTags.IS_SAVANNA, BiomeTags.RUINED_PORTAL_SWAMP_HAS_STRUCTURE));
    }
}

// Previous method without helper: BiomeModifications.addFeature(context -> context.hasTag(BiomeTags.IS_TAIGA) || context.hasTag(BiomeTags.IS_FOREST) || context.hasTag(BiomeTags.IS_MOUNTAIN), VEGETAL_DECORATION, ModVegetationPlacedFeatures.PATCH_BLUEBERRY);