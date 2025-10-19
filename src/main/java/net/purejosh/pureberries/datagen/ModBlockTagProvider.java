package net.purejosh.pureberries.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.purejosh.pureberries.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.ANDESITE_MORTAR)
                .add(ModBlocks.BASALT_MORTAR)
                .add(ModBlocks.BLACKSTONE_MORTAR)
                .add(ModBlocks.CALCITE_MORTAR)
                .add(ModBlocks.DEEPSLATE_MORTAR)
                .add(ModBlocks.DIAMOND_MORTAR)
                .add(ModBlocks.NETHER_BRICK_MORTAR)
                .add(ModBlocks.NETHERITE_MORTAR)
                .add(ModBlocks.QUARTZ_MORTAR)
                .add(ModBlocks.SANDSTONE_MORTAR)
                .add(ModBlocks.SMOOTH_STONE_MORTAR)
                .add(ModBlocks.STONE_MORTAR)
                .add(ModBlocks.TUFF_MORTAR);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.BLUEBERRY_BUSH)
                .add(ModBlocks.CLOUDBERRY_PATCH)
                .add(ModBlocks.GOJI_BERRY_SHRUB)
                .add(ModBlocks.REDCURRANT_SHRUB)
                .add(ModBlocks.BLACKCURRANT_SHRUB)
                .add(ModBlocks.GOOSEBERRY_SHRUB)
                .add(ModBlocks.CAPE_GOOSEBERRY_SHRUB);

        getOrCreateTagBuilder(BlockTags.SWORD_EFFICIENT)
                .add(ModBlocks.BLUEBERRY_BUSH)
                .add(ModBlocks.CLOUDBERRY_PATCH)
                .add(ModBlocks.GOJI_BERRY_SHRUB)
                .add(ModBlocks.REDCURRANT_SHRUB)
                .add(ModBlocks.BLACKCURRANT_SHRUB)
                .add(ModBlocks.GOOSEBERRY_SHRUB)
                .add(ModBlocks.CAPE_GOOSEBERRY_SHRUB);

        getOrCreateTagBuilder(BlockTags.BEE_GROWABLES)
                .add(ModBlocks.BLUEBERRY_BUSH)
                .add(ModBlocks.CLOUDBERRY_PATCH)
                .add(ModBlocks.GOJI_BERRY_SHRUB)
                .add(ModBlocks.REDCURRANT_SHRUB)
                .add(ModBlocks.BLACKCURRANT_SHRUB)
                .add(ModBlocks.GOOSEBERRY_SHRUB)
                .add(ModBlocks.CAPE_GOOSEBERRY_SHRUB);

        getOrCreateTagBuilder(BlockTags.FALL_DAMAGE_RESETTING)
                .add(ModBlocks.BLUEBERRY_BUSH)
                .add(ModBlocks.CLOUDBERRY_PATCH)
                .add(ModBlocks.GOJI_BERRY_SHRUB)
                .add(ModBlocks.REDCURRANT_SHRUB)
                .add(ModBlocks.BLACKCURRANT_SHRUB)
                .add(ModBlocks.GOOSEBERRY_SHRUB)
                .add(ModBlocks.CAPE_GOOSEBERRY_SHRUB);
    }
}
