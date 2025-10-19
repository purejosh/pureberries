package net.purejosh.pureberries.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.state.property.IntProperty;
import net.purejosh.pureberries.block.*;
import net.purejosh.pureberries.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);

        // One-liner to create loot tables, using the helper methods below.
        addBushLootTables(ModBlocks.BLUEBERRY_BUSH, ModItems.BLUEBERRIES, BlueberryBushBlock.AGE, 3, impl);
        addBushLootTables(ModBlocks.CLOUDBERRY_PATCH, ModItems.CLOUDBERRIES, CloudberryPatchBlock.AGE, 3, impl);
        addBushLootTables(ModBlocks.GOJI_BERRY_SHRUB, ModItems.GOJI_BERRIES, GojiBerryShrubBlock.AGE, 7, impl);
        addBushLootTables(ModBlocks.REDCURRANT_SHRUB, ModItems.REDCURRANTS, RedcurrantShrubBlock.AGE, 3, impl);
        addBushLootTables(ModBlocks.BLACKCURRANT_SHRUB, ModItems.BLACKCURRANTS, BlackcurrantShrubBlock.AGE, 3, impl);
        addBushLootTables(ModBlocks.GOOSEBERRY_SHRUB, ModItems.GOOSEBERRIES, GooseberryShrubBlock.AGE, 3, impl);
        addBushLootTables(ModBlocks.CAPE_GOOSEBERRY_SHRUB, ModItems.CAPE_GOOSEBERRIES, CapeGooseberryShrubBlock.AGE, 3, impl);
    }

    private void addBushLootTables(Block block, Item item, IntProperty ageProperty, int maxAge, RegistryWrapper.Impl<Enchantment> impl) {
        addDrop(block, b -> this.applyExplosionDecay(b, LootTable.builder()
                .pool(createLootPool(block, item, ageProperty, maxAge, 2.0F, 3.0F, impl))
                .pool(createLootPool(block, item, ageProperty, maxAge - 1, 1.0F, 2.0F, impl))));
    }

    private LootPool.Builder createLootPool(Block block, Item item, IntProperty ageProperty, int age, float min, float max, RegistryWrapper.Impl<Enchantment> impl) {
        return LootPool.builder()
                .conditionally(BlockStatePropertyLootCondition.builder(block)
                        .properties(StatePredicate.Builder.create().exactMatch(ageProperty, age)))
                        .with(ItemEntry.builder(item))
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(min, max)))
                .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)));
    }
}
