package net.purejosh.pureberries.block;

import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.purejosh.pureberries.PureBerries;

public class ModBlocks {
    // Natural Blocks
    public static final Block BLUEBERRY_BUSH = register("blueberry_bush", new BlueberryBushBlock(Settings.copy(Blocks.SWEET_BERRY_BUSH)), false);
    public static final Block CLOUDBERRY_PATCH = register("cloudberry_patch", new CloudberryPatchBlock(Settings.copy(Blocks.SWEET_BERRY_BUSH)), false);
    public static final Block GOJI_BERRY_SHRUB = register("goji_berry_shrub", new GojiBerryShrubBlock(Settings.copy(Blocks.SWEET_BERRY_BUSH)), false);
    public static final Block REDCURRANT_SHRUB = register("redcurrant_shrub", new RedcurrantShrubBlock(Settings.copy(Blocks.SWEET_BERRY_BUSH)), false);
    public static final Block BLACKCURRANT_SHRUB = register("blackcurrant_shrub", new BlackcurrantShrubBlock(Settings.copy(Blocks.SWEET_BERRY_BUSH)), false);
    public static final Block GOOSEBERRY_SHRUB = register("gooseberry_shrub", new GooseberryShrubBlock(Settings.copy(Blocks.SWEET_BERRY_BUSH)), false);
    public static final Block CAPE_GOOSEBERRY_SHRUB = register("cape_gooseberry_shrub", new CapeGooseberryShrubBlock(Settings.copy(Blocks.SWEET_BERRY_BUSH)), false);

    // Cakes
    public static final Block SWEET_BERRY_CAKE = register("sweet_berry_cake", new ModCakeBlock(Settings.copy(Blocks.CAKE)), false);
    public static final Block GLOW_BERRY_CAKE = register("glow_berry_cake", new ModCakeBlock(Settings.copy(Blocks.CAKE)), false);
    public static final Block BLUEBERRY_CAKE = register("blueberry_cake", new ModCakeBlock(Settings.copy(Blocks.CAKE)), false);
    public static final Block CLOUDBERRY_CAKE = register("cloudberry_cake", new ModCakeBlock(Settings.copy(Blocks.CAKE)), false);
    public static final Block GOJI_BERRY_CAKE = register("goji_berry_cake", new ModCakeBlock(Settings.copy(Blocks.CAKE)), false);
    public static final Block REDCURRANT_CAKE = register("redcurrant_cake", new ModCakeBlock(Settings.copy(Blocks.CAKE)), false);
    public static final Block BLACKCURRANT_CAKE = register("blackcurrant_cake", new ModCakeBlock(Settings.copy(Blocks.CAKE)), false);
    public static final Block GOOSEBERRY_CAKE = register("gooseberry_cake", new ModCakeBlock(Settings.copy(Blocks.CAKE)), false);
    public static final Block CAPE_GOOSEBERRY_CAKE = register("cape_gooseberry_cake", new ModCakeBlock(Settings.copy(Blocks.CAKE)), false);

    // Functional Blocks
    public static final MortarBlock ANDESITE_MORTAR = registerMortarBlock("andesite_mortar", new MortarBlock(Settings.copy(Blocks.ANDESITE), 547));
    public static final MortarBlock BASALT_MORTAR = registerMortarBlock("basalt_mortar", new MortarBlock(Settings.copy(Blocks.BASALT), 443));
    public static final MortarBlock BLACKSTONE_MORTAR = registerMortarBlock("blackstone_mortar", new MortarBlock(Settings.copy(Blocks.BLACKSTONE), 443));
    public static final MortarBlock CALCITE_MORTAR = registerMortarBlock("calcite_mortar", new MortarBlock(Settings.copy(Blocks.CALCITE), 59));
    public static final MortarBlock DEEPSLATE_MORTAR = registerMortarBlock("deepslate_mortar", new MortarBlock(Settings.copy(Blocks.DEEPSLATE), 443));
    public static final MortarBlock DIAMOND_MORTAR = registerMortarBlock("diamond_mortar", new MortarBlock(Settings.copy(Blocks.DIAMOND_BLOCK), 1561));
    public static final MortarBlock NETHER_BRICK_MORTAR = registerMortarBlock("nether_brick_mortar", new MortarBlock(Settings.copy(Blocks.NETHER_BRICKS), 443));
    public static final MortarBlock NETHERITE_MORTAR = registerMortarBlock("netherite_mortar", new MortarBlock(Settings.copy(Blocks.NETHERITE_BLOCK), 2031));
    public static final MortarBlock QUARTZ_MORTAR = registerMortarBlock("quartz_mortar", new MortarBlock(Settings.copy(Blocks.QUARTZ_BLOCK), 620));
    public static final MortarBlock SANDSTONE_MORTAR = registerMortarBlock("sandstone_mortar", new MortarBlock(Settings.copy(Blocks.SANDSTONE), 547));
    public static final MortarBlock SMOOTH_STONE_MORTAR = registerMortarBlock("smooth_stone_mortar", new MortarBlock(Settings.copy(Blocks.SMOOTH_STONE), 443));
    public static final MortarBlock STONE_MORTAR = registerMortarBlock("stone_mortar", new MortarBlock(Settings.copy(Blocks.STONE), 443));
    public static final MortarBlock TUFF_MORTAR = registerMortarBlock("tuff_mortar", new MortarBlock(Settings.copy(Blocks.TUFF), 59));


    // Helper methods
    // Block registration with optional item registration boolean
    public static Block register(String name, Block block, boolean shouldRegisterItem) {
        Identifier id = Identifier.of(PureBerries.MOD_ID, name);

        // Some blocks may not have an item version of them, such as bushes. Use this boolean to control that.
        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }
        return Registry.register(Registries.BLOCK, id, block);
    }

    // Mortar block registration, no item registration involved
    public static MortarBlock registerMortarBlock(String name, MortarBlock block) {
        Identifier id = Identifier.of(PureBerries.MOD_ID, name);
        return Registry.register(Registries.BLOCK, id, block);
    }

    // Class initializer.
    public static void init() {
    }
}