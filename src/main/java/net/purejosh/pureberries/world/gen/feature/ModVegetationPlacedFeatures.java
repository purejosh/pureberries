package net.purejosh.pureberries.world.gen.feature;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.purejosh.pureberries.PureBerries;

import java.util.List;

public class ModVegetationPlacedFeatures {
    public static final RegistryKey<PlacedFeature> PATCH_BLUEBERRY = registerKey("patch_blueberry");
    public static final RegistryKey<PlacedFeature> PATCH_CLOUDBERRY = registerKey("patch_cloudberry");
    public static final RegistryKey<PlacedFeature> PATCH_GOJI_BERRY = registerKey("patch_goji_berry");
    public static final RegistryKey<PlacedFeature> PATCH_REDCURRANT = registerKey("patch_redcurrant");
    public static final RegistryKey<PlacedFeature> PATCH_BLACKCURRANT = registerKey("patch_blackcurrant");
    public static final RegistryKey<PlacedFeature> PATCH_GOOSEBERRY = registerKey("patch_gooseberry");
    public static final RegistryKey<PlacedFeature> PATCH_CAPE_GOOSEBERRY = registerKey("patch_cape_gooseberry");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var registryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        RegistryEntry<ConfiguredFeature<?, ?>> registryEntry01 = registryEntryLookup.getOrThrow(ModVegetationConfiguredFeatures.PATCH_BLUEBERRY);
        RegistryEntry<ConfiguredFeature<?, ?>> registryEntry02 = registryEntryLookup.getOrThrow(ModVegetationConfiguredFeatures.PATCH_CLOUDBERRY);
        RegistryEntry<ConfiguredFeature<?, ?>> registryEntry03 = registryEntryLookup.getOrThrow(ModVegetationConfiguredFeatures.PATCH_GOJI_BERRY);
        RegistryEntry<ConfiguredFeature<?, ?>> registryEntry04 = registryEntryLookup.getOrThrow(ModVegetationConfiguredFeatures.PATCH_REDCURRANT);
        RegistryEntry<ConfiguredFeature<?, ?>> registryEntry05 = registryEntryLookup.getOrThrow(ModVegetationConfiguredFeatures.PATCH_BLACKCURRANT);
        RegistryEntry<ConfiguredFeature<?, ?>> registryEntry06 = registryEntryLookup.getOrThrow(ModVegetationConfiguredFeatures.PATCH_GOOSEBERRY);
        RegistryEntry<ConfiguredFeature<?, ?>> registryEntry07 = registryEntryLookup.getOrThrow(ModVegetationConfiguredFeatures.PATCH_CAPE_GOOSEBERRY);

        register(context, PATCH_BLUEBERRY, registryEntry01, RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PATCH_CLOUDBERRY, registryEntry02, RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PATCH_GOJI_BERRY, registryEntry03, RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PATCH_REDCURRANT, registryEntry04, RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PATCH_BLACKCURRANT, registryEntry05, RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PATCH_GOOSEBERRY, registryEntry06, RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PATCH_CAPE_GOOSEBERRY, registryEntry07, RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(PureBerries.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
