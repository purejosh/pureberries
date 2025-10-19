package net.purejosh.pureberries.world.gen.feature;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.purejosh.pureberries.PureBerries;
import net.purejosh.pureberries.block.*;

public class ModVegetationConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_BLUEBERRY = registerKey("patch_blueberry");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_CLOUDBERRY = registerKey("patch_cloudberry");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_GOJI_BERRY = registerKey("patch_goji_berry");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_REDCURRANT = registerKey("patch_redcurrant");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_BLACKCURRANT = registerKey("patch_blackcurrant");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_GOOSEBERRY = registerKey("patch_gooseberry");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_CAPE_GOOSEBERRY = registerKey("patch_cape_gooseberry");

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(PureBerries.MOD_ID, name));
    }

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        registerBush(context, "patch_blueberry", ModBlocks.BLUEBERRY_BUSH, BlueberryBushBlock.AGE, BlueberryBushBlock.MAX_AGE, 88, 7, 3);
        registerBush(context, "patch_cloudberry", ModBlocks.CLOUDBERRY_PATCH, CloudberryPatchBlock.AGE, CloudberryPatchBlock.MAX_AGE, 48, 9, 4);
        registerBush(context, "patch_goji_berry", ModBlocks.GOJI_BERRY_SHRUB, GojiBerryShrubBlock.AGE, GojiBerryShrubBlock.MAX_AGE, 72, 6, 3);
        registerBush(context, "patch_redcurrant", ModBlocks.REDCURRANT_SHRUB, RedcurrantShrubBlock.AGE, RedcurrantShrubBlock.MAX_AGE, 76, 6, 2);
        registerBush(context, "patch_blackcurrant", ModBlocks.BLACKCURRANT_SHRUB, BlackcurrantShrubBlock.AGE, BlackcurrantShrubBlock.MAX_AGE, 72, 6, 3);
        registerBush(context, "patch_gooseberry", ModBlocks.GOOSEBERRY_SHRUB, GooseberryShrubBlock.AGE, GooseberryShrubBlock.MAX_AGE, 74, 6, 2);
        registerBush(context, "patch_cape_gooseberry", ModBlocks.CAPE_GOOSEBERRY_SHRUB, CapeGooseberryShrubBlock.AGE, CapeGooseberryShrubBlock.MAX_AGE, 56, 8, 3);
    }

    private static void registerBush(Registerable<ConfiguredFeature<?, ?>> context, String keyName, Block block, IntProperty ageProperty, int ageValue, int tries, int xzSpread, int ySpread) {
        RegistryKey<ConfiguredFeature<?, ?>> key = registerKey(keyName);
        BlockState state = block.getDefaultState().with(ageProperty, ageValue);
        ConfiguredFeature<?, ?> feature = new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchFeatureConfig(tries, xzSpread, ySpread,
                        PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(state)))));
        context.register(key, feature);
    }
}
