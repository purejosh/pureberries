package net.purejosh.pureberries.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.purejosh.pureberries.item.ModItems;
import net.purejosh.pureberries.registry.tag.ModItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModItemTags.BERRIES)
                .add(Items.SWEET_BERRIES)
                .add(Items.GLOW_BERRIES)
                .add(ModItems.BLUEBERRIES)
                .add(ModItems.CLOUDBERRIES)
                .add(ModItems.GOJI_BERRIES)
                .add(ModItems.REDCURRANTS)
                .add(ModItems.BLACKCURRANTS)
                .add(ModItems.GOOSEBERRIES)
                .add(ModItems.CAPE_GOOSEBERRIES);
    }
}
