package net.purejosh.pureberries.item;

import net.minecraft.block.Block;
import net.minecraft.block.ComposterBlock;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.purejosh.pureberries.PureBerries;
import net.purejosh.pureberries.block.ModBlocks;
import net.purejosh.pureberries.component.type.ModFoodComponents;
import net.purejosh.pureberries.entity.effect.ModStatusEffects;
import net.purejosh.pureberries.world.ModGameRules;

public class ModItems {
    // Food & Drinks

    // Sweet Berries
    public static final Item SWEET_BERRIES_COOKED = register("sweet_berries_cooked", new Item(new Item.Settings().food(ModFoodComponents.COOKED)));
    public static final Item SWEET_BERRIES_COCOA_COVERED = register("sweet_berries_cocoa_covered", new Item(new Item.Settings().food(ModFoodComponents.COVERED_DIPPED)));
    public static final Item SWEET_BERRIES_HONEY_DIPPED = register("sweet_berries_honey_dipped", new Item(new Item.Settings().food(ModFoodComponents.COVERED_DIPPED)));
    public static final Item SWEET_BERRIES_GOLDEN = register("sweet_berries_golden", new GoldenBerryItem(new Item.Settings().food(ModFoodComponents.GOLDEN), ModStatusEffects.SUSTENANCE, ModGameRules.SUSTENANCE_STRENGTH, 1600, 2));
    public static final Item SWEET_BERRY_CAKE = register("sweet_berry_cake", new BlockItem(ModBlocks.SWEET_BERRY_CAKE, new Item.Settings().maxCount(1)));
    public static final Item SWEET_BERRY_COOKIE = register("sweet_berry_cookie", new Item(new Item.Settings().food(FoodComponents.COOKIE)));
    public static final Item SWEET_BERRY_JAM_SANDWICH = register("sweet_berry_jam_sandwich", new Item(new Item.Settings().food(ModFoodComponents.JAM_SANDWICH)));
    public static final Item SWEET_BERRY_MUFFIN = register("sweet_berry_muffin", new Item(new Item.Settings().food(ModFoodComponents.MUFFIN)));
    public static final Item SWEET_BERRY_PIE = register("sweet_berry_pie", new Item(new Item.Settings().food(FoodComponents.PUMPKIN_PIE)));
    public static final Item SWEET_BERRY_JUICE = register("sweet_berry_juice", new JuiceItem(new Item.Settings().food(ModFoodComponents.JUICE).maxCount(16)));
    public static final Item SWEET_BERRY_JAM = register("sweet_berry_jam", new HoneyBottleItem(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).food(ModFoodComponents.JAM).maxCount(16)));

    // Glow Berries
    public static final Item GLOW_BERRIES_COOKED = register("glow_berries_cooked", new Item(new Item.Settings().food(ModFoodComponents.COOKED)));
    public static final Item GLOW_BERRIES_COCOA_COVERED = register("glow_berries_cocoa_covered", new Item(new Item.Settings().food(ModFoodComponents.COVERED_DIPPED)));
    public static final Item GLOW_BERRIES_HONEY_DIPPED = register("glow_berries_honey_dipped", new Item(new Item.Settings().food(ModFoodComponents.COVERED_DIPPED)));
    public static final Item GLOW_BERRIES_GOLDEN = register("glow_berries_golden", new GoldenBerryItem(new Item.Settings().food(ModFoodComponents.GOLDEN), ModStatusEffects.LUMINANCE, ModGameRules.LUMINANCE_RADIUS, 480, 2));
    public static final Item GLOW_BERRY_CAKE = register("glow_berry_cake", new BlockItem(ModBlocks.GLOW_BERRY_CAKE, new Item.Settings().maxCount(1)));
    public static final Item GLOW_BERRY_COOKIE = register("glow_berry_cookie", new Item(new Item.Settings().food(FoodComponents.COOKIE)));
    public static final Item GLOW_BERRY_JAM_SANDWICH = register("glow_berry_jam_sandwich", new Item(new Item.Settings().food(ModFoodComponents.JAM_SANDWICH)));
    public static final Item GLOW_BERRY_MUFFIN = register("glow_berry_muffin", new Item(new Item.Settings().food(ModFoodComponents.MUFFIN)));
    public static final Item GLOW_BERRY_PIE = register("glow_berry_pie", new Item(new Item.Settings().food(FoodComponents.PUMPKIN_PIE)));
    public static final Item GLOW_BERRY_JUICE = register("glow_berry_juice", new JuiceItem(new Item.Settings().food(ModFoodComponents.JUICE).maxCount(16)));
    public static final Item GLOW_BERRY_JAM = register("glow_berry_jam", new HoneyBottleItem(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).food(ModFoodComponents.JAM).maxCount(16)));
    public static final Item GLOW_DYE = register("glow_dye", new GlowInkSacItem(new Item.Settings()));

    // Blueberries
    public static final Item BLUEBERRIES = register("blueberries", new AliasedBlockItem(ModBlocks.BLUEBERRY_BUSH, (new Item.Settings().food(FoodComponents.SWEET_BERRIES))));
    public static final Item BLUEBERRIES_COOKED = register("blueberries_cooked", new Item(new Item.Settings().food(ModFoodComponents.COOKED)));
    public static final Item BLUEBERRIES_COCOA_COVERED = register("blueberries_cocoa_covered", new Item(new Item.Settings().food(ModFoodComponents.COVERED_DIPPED)));
    public static final Item BLUEBERRIES_HONEY_DIPPED = register("blueberries_honey_dipped", new Item(new Item.Settings().food(ModFoodComponents.COVERED_DIPPED)));
    public static final Item BLUEBERRIES_GOLDEN = register("blueberries_golden", new GoldenBerryItem(new Item.Settings().food(ModFoodComponents.GOLDEN), ModStatusEffects.SUSTENANCE, ModGameRules.SUSTENANCE_STRENGTH, 1600, 2));
    public static final Item BLUEBERRY_CAKE = register("blueberry_cake", new BlockItem(ModBlocks.BLUEBERRY_CAKE, new Item.Settings().maxCount(1)));
    public static final Item BLUEBERRY_COOKIE = register("blueberry_cookie", new Item(new Item.Settings().food(FoodComponents.COOKIE)));
    public static final Item BLUEBERRY_JAM_SANDWICH = register("blueberry_jam_sandwich", new Item(new Item.Settings().food(ModFoodComponents.JAM_SANDWICH)));
    public static final Item BLUEBERRY_MUFFIN = register("blueberry_muffin", new Item(new Item.Settings().food(ModFoodComponents.MUFFIN)));
    public static final Item BLUEBERRY_PIE = register("blueberry_pie", new Item(new Item.Settings().food(FoodComponents.PUMPKIN_PIE)));
    public static final Item BLUEBERRY_JUICE = register("blueberry_juice", new JuiceItem(new Item.Settings().food(ModFoodComponents.JUICE).maxCount(16)));
    public static final Item BLUEBERRY_JAM = register("blueberry_jam", new HoneyBottleItem(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).food(ModFoodComponents.JAM).maxCount(16)));

    // Cloudberries
    public static final Item CLOUDBERRIES = register("cloudberries", new AliasedBlockItem(ModBlocks.CLOUDBERRY_PATCH, (new Item.Settings().food(FoodComponents.SWEET_BERRIES))));
    public static final Item CLOUDBERRIES_COOKED = register("cloudberries_cooked", new Item(new Item.Settings().food(ModFoodComponents.COOKED)));
    public static final Item CLOUDBERRIES_COCOA_COVERED = register("cloudberries_cocoa_covered", new Item(new Item.Settings().food(ModFoodComponents.COVERED_DIPPED)));
    public static final Item CLOUDBERRIES_HONEY_DIPPED = register("cloudberries_honey_dipped", new Item(new Item.Settings().food(ModFoodComponents.COVERED_DIPPED)));
    public static final Item CLOUDBERRIES_GOLDEN = register("cloudberries_golden", new GoldenBerryItem(new Item.Settings().food(ModFoodComponents.GOLDEN), ModStatusEffects.NIMBUS, ModGameRules.NIMBUS_STRENGTH, 480, 2));
    public static final Item CLOUDBERRY_CAKE = register("cloudberry_cake", new BlockItem(ModBlocks.CLOUDBERRY_CAKE, new Item.Settings().maxCount(1)));
    public static final Item CLOUDBERRY_COOKIE = register("cloudberry_cookie", new Item(new Item.Settings().food(FoodComponents.COOKIE)));
    public static final Item CLOUDBERRY_JAM_SANDWICH = register("cloudberry_jam_sandwich", new Item(new Item.Settings().food(ModFoodComponents.JAM_SANDWICH)));
    public static final Item CLOUDBERRY_MUFFIN = register("cloudberry_muffin", new Item(new Item.Settings().food(ModFoodComponents.MUFFIN)));
    public static final Item CLOUDBERRY_PIE = register("cloudberry_pie", new Item(new Item.Settings().food(FoodComponents.PUMPKIN_PIE)));
    public static final Item CLOUDBERRY_JUICE = register("cloudberry_juice", new JuiceItem(new Item.Settings().food(ModFoodComponents.JUICE).maxCount(16)));
    public static final Item CLOUDBERRY_JAM = register("cloudberry_jam", new HoneyBottleItem(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).food(ModFoodComponents.JAM).maxCount(16)));

    // Goji Berries
    public static final Item GOJI_BERRIES = register("goji_berries", new AliasedBlockItem(ModBlocks.GOJI_BERRY_SHRUB, (new Item.Settings().food(FoodComponents.SWEET_BERRIES))));
    public static final Item GOJI_BERRIES_COOKED = register("goji_berries_cooked", new Item(new Item.Settings().food(ModFoodComponents.COOKED)));
    public static final Item GOJI_BERRIES_COCOA_COVERED = register("goji_berries_cocoa_covered", new Item(new Item.Settings().food(ModFoodComponents.COVERED_DIPPED)));
    public static final Item GOJI_BERRIES_HONEY_DIPPED = register("goji_berries_honey_dipped", new Item(new Item.Settings().food(ModFoodComponents.COVERED_DIPPED)));
    public static final Item GOJI_BERRIES_GOLDEN = register("goji_berries_golden", new GoldenBerryItem(new Item.Settings().food(ModFoodComponents.GOLDEN), ModStatusEffects.VITALITY, ModGameRules.VITALITY_STRENGTH, 960, 2));
    public static final Item GOJI_BERRY_CAKE = register("goji_berry_cake", new BlockItem(ModBlocks.GOJI_BERRY_CAKE, new Item.Settings().maxCount(1)));
    public static final Item GOJI_BERRY_COOKIE = register("goji_berry_cookie", new Item(new Item.Settings().food(FoodComponents.COOKIE)));
    public static final Item GOJI_BERRY_JAM_SANDWICH = register("goji_berry_jam_sandwich", new Item(new Item.Settings().food(ModFoodComponents.JAM_SANDWICH)));
    public static final Item GOJI_BERRY_MUFFIN = register("goji_berry_muffin", new Item(new Item.Settings().food(ModFoodComponents.MUFFIN)));
    public static final Item GOJI_BERRY_PIE = register("goji_berry_pie", new Item(new Item.Settings().food(FoodComponents.PUMPKIN_PIE)));
    public static final Item GOJI_BERRY_JUICE = register("goji_berry_juice", new JuiceItem(new Item.Settings().food(ModFoodComponents.JUICE).maxCount(16)));
    public static final Item GOJI_BERRY_JAM = register("goji_berry_jam", new HoneyBottleItem(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).food(ModFoodComponents.JAM).maxCount(16)));

    // Redcurrants
    public static final Item REDCURRANTS = register("redcurrants", new AliasedBlockItem(ModBlocks.REDCURRANT_SHRUB, (new Item.Settings().food(FoodComponents.SWEET_BERRIES))));
    public static final Item REDCURRANTS_COOKED = register("redcurrants_cooked", new Item(new Item.Settings().food(ModFoodComponents.COOKED)));
    public static final Item REDCURRANTS_COCOA_COVERED = register("redcurrants_cocoa_covered", new Item(new Item.Settings().food(ModFoodComponents.COVERED_DIPPED)));
    public static final Item REDCURRANTS_HONEY_DIPPED = register("redcurrants_honey_dipped", new Item(new Item.Settings().food(ModFoodComponents.COVERED_DIPPED)));
    public static final Item REDCURRANTS_GOLDEN = register("redcurrants_golden", new GoldenBerryItem(new Item.Settings().food(ModFoodComponents.GOLDEN), ModStatusEffects.DETOXIFY, ModGameRules.DETOXIFY_STRENGTH, 1600, 2));
    public static final Item REDCURRANT_CAKE = register("redcurrant_cake", new BlockItem(ModBlocks.REDCURRANT_CAKE, new Item.Settings().maxCount(1)));
    public static final Item REDCURRANT_COOKIE = register("redcurrant_cookie", new Item(new Item.Settings().food(FoodComponents.COOKIE)));
    public static final Item REDCURRANT_JAM_SANDWICH = register("redcurrant_jam_sandwich", new Item(new Item.Settings().food(ModFoodComponents.JAM_SANDWICH)));
    public static final Item REDCURRANT_MUFFIN = register("redcurrant_muffin", new Item(new Item.Settings().food(ModFoodComponents.MUFFIN)));
    public static final Item REDCURRANT_PIE = register("redcurrant_pie", new Item(new Item.Settings().food(FoodComponents.PUMPKIN_PIE)));
    public static final Item REDCURRANT_JUICE = register("redcurrant_juice", new JuiceItem(new Item.Settings().food(ModFoodComponents.JUICE).maxCount(16)));
    public static final Item REDCURRANT_JAM = register("redcurrant_jam", new HoneyBottleItem(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).food(ModFoodComponents.JAM).maxCount(16)));

    // Blackcurrants
    public static final Item BLACKCURRANTS = register("blackcurrants", new AliasedBlockItem(ModBlocks.BLACKCURRANT_SHRUB, (new Item.Settings().food(FoodComponents.SWEET_BERRIES))));
    public static final Item BLACKCURRANTS_COOKED = register("blackcurrants_cooked", new Item(new Item.Settings().food(ModFoodComponents.COOKED)));
    public static final Item BLACKCURRANTS_COCOA_COVERED = register("blackcurrants_cocoa_covered", new Item(new Item.Settings().food(ModFoodComponents.COVERED_DIPPED)));
    public static final Item BLACKCURRANTS_HONEY_DIPPED = register("blackcurrants_honey_dipped", new Item(new Item.Settings().food(ModFoodComponents.COVERED_DIPPED)));
    public static final Item BLACKCURRANTS_GOLDEN = register("blackcurrants_golden", new GoldenBerryItem(new Item.Settings().food(ModFoodComponents.GOLDEN), ModStatusEffects.DETOXIFY, ModGameRules.DETOXIFY_STRENGTH, 1600, 2));
    public static final Item BLACKCURRANT_CAKE = register("blackcurrant_cake", new BlockItem(ModBlocks.BLACKCURRANT_CAKE, new Item.Settings().maxCount(1)));
    public static final Item BLACKCURRANT_COOKIE = register("blackcurrant_cookie", new Item(new Item.Settings().food(FoodComponents.COOKIE)));
    public static final Item BLACKCURRANT_JAM_SANDWICH = register("blackcurrant_jam_sandwich", new Item(new Item.Settings().food(ModFoodComponents.JAM_SANDWICH)));
    public static final Item BLACKCURRANT_MUFFIN = register("blackcurrant_muffin", new Item(new Item.Settings().food(ModFoodComponents.MUFFIN)));
    public static final Item BLACKCURRANT_PIE = register("blackcurrant_pie", new Item(new Item.Settings().food(FoodComponents.PUMPKIN_PIE)));
    public static final Item BLACKCURRANT_JUICE = register("blackcurrant_juice", new JuiceItem(new Item.Settings().food(ModFoodComponents.JUICE).maxCount(16)));
    public static final Item BLACKCURRANT_JAM = register("blackcurrant_jam", new HoneyBottleItem(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).food(ModFoodComponents.JAM).maxCount(16)));

    // Gooseberries
    public static final Item GOOSEBERRIES = register("gooseberries", new AliasedBlockItem(ModBlocks.GOOSEBERRY_SHRUB, (new Item.Settings().food(FoodComponents.SWEET_BERRIES))));
    public static final Item GOOSEBERRIES_COOKED = register("gooseberries_cooked", new Item(new Item.Settings().food(ModFoodComponents.COOKED)));
    public static final Item GOOSEBERRIES_COCOA_COVERED = register("gooseberries_cocoa_covered", new Item(new Item.Settings().food(ModFoodComponents.COVERED_DIPPED)));
    public static final Item GOOSEBERRIES_HONEY_DIPPED = register("gooseberries_honey_dipped", new Item(new Item.Settings().food(ModFoodComponents.COVERED_DIPPED)));
    public static final Item GOOSEBERRIES_GOLDEN = register("gooseberries_golden", new GoldenBerryItem(new Item.Settings().food(ModFoodComponents.GOLDEN), ModStatusEffects.VITALITY, ModGameRules.VITALITY_STRENGTH, 960, 2));
    public static final Item GOOSEBERRY_CAKE = register("gooseberry_cake", new BlockItem(ModBlocks.GOOSEBERRY_CAKE, new Item.Settings().maxCount(1)));
    public static final Item GOOSEBERRY_COOKIE = register("gooseberry_cookie", new Item(new Item.Settings().food(FoodComponents.COOKIE)));
    public static final Item GOOSEBERRY_JAM_SANDWICH = register("gooseberry_jam_sandwich", new Item(new Item.Settings().food(ModFoodComponents.JAM_SANDWICH)));
    public static final Item GOOSEBERRY_MUFFIN = register("gooseberry_muffin", new Item(new Item.Settings().food(ModFoodComponents.MUFFIN)));
    public static final Item GOOSEBERRY_PIE = register("gooseberry_pie", new Item(new Item.Settings().food(FoodComponents.PUMPKIN_PIE)));
    public static final Item GOOSEBERRY_JUICE = register("gooseberry_juice", new JuiceItem(new Item.Settings().food(ModFoodComponents.JUICE).maxCount(16)));
    public static final Item GOOSEBERRY_JAM = register("gooseberry_jam", new HoneyBottleItem(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).food(ModFoodComponents.JAM).maxCount(16)));

    // Cape Gooseberries
    public static final Item CAPE_GOOSEBERRIES = register("cape_gooseberries", new AliasedBlockItem(ModBlocks.CAPE_GOOSEBERRY_SHRUB, (new Item.Settings().food(FoodComponents.SWEET_BERRIES))));
    public static final Item CAPE_GOOSEBERRIES_COOKED = register("cape_gooseberries_cooked", new Item(new Item.Settings().food(ModFoodComponents.COOKED)));
    public static final Item CAPE_GOOSEBERRIES_COCOA_COVERED = register("cape_gooseberries_cocoa_covered", new Item(new Item.Settings().food(ModFoodComponents.COVERED_DIPPED)));
    public static final Item CAPE_GOOSEBERRIES_HONEY_DIPPED = register("cape_gooseberries_honey_dipped", new Item(new Item.Settings().food(ModFoodComponents.COVERED_DIPPED)));
    public static final Item CAPE_GOOSEBERRIES_GOLDEN = register("cape_gooseberries_golden", new GoldenBerryItem(new Item.Settings().food(ModFoodComponents.GOLDEN), ModStatusEffects.VITALITY, ModGameRules.VITALITY_STRENGTH, 960, 2));
    public static final Item CAPE_GOOSEBERRY_CAKE = register("cape_gooseberry_cake", new BlockItem(ModBlocks.CAPE_GOOSEBERRY_CAKE, new Item.Settings().maxCount(1)));
    public static final Item CAPE_GOOSEBERRY_COOKIE = register("cape_gooseberry_cookie", new Item(new Item.Settings().food(FoodComponents.COOKIE)));
    public static final Item CAPE_GOOSEBERRY_JAM_SANDWICH = register("cape_gooseberry_jam_sandwich", new Item(new Item.Settings().food(ModFoodComponents.JAM_SANDWICH)));
    public static final Item CAPE_GOOSEBERRY_MUFFIN = register("cape_gooseberry_muffin", new Item(new Item.Settings().food(ModFoodComponents.MUFFIN)));
    public static final Item CAPE_GOOSEBERRY_PIE = register("cape_gooseberry_pie", new Item(new Item.Settings().food(FoodComponents.PUMPKIN_PIE)));
    public static final Item CAPE_GOOSEBERRY_JUICE = register("cape_gooseberry_juice", new JuiceItem(new Item.Settings().food(ModFoodComponents.JUICE).maxCount(16)));
    public static final Item CAPE_GOOSEBERRY_JAM = register("cape_gooseberry_jam", new HoneyBottleItem(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).food(ModFoodComponents.JAM).maxCount(16)));

    // Mortars
    public static final MortarBlockItem ANDESITE_MORTAR = register("andesite_mortar", ModBlocks.ANDESITE_MORTAR, ModBlocks.ANDESITE_MORTAR.getMaxDurability(), Items.ANDESITE);
    public static final MortarBlockItem BASALT_MORTAR = register("basalt_mortar", ModBlocks.BASALT_MORTAR, ModBlocks.BASALT_MORTAR.getMaxDurability(), Items.BASALT);
    public static final MortarBlockItem BLACKSTONE_MORTAR = register("blackstone_mortar", ModBlocks.BLACKSTONE_MORTAR, ModBlocks.BLACKSTONE_MORTAR.getMaxDurability(), Items.BLACKSTONE);
    public static final MortarBlockItem CALCITE_MORTAR = register("calcite_mortar", ModBlocks.CALCITE_MORTAR, ModBlocks.CALCITE_MORTAR.getMaxDurability(), Items.CALCITE);
    public static final MortarBlockItem DEEPSLATE_MORTAR = register("deepslate_mortar", ModBlocks.DEEPSLATE_MORTAR, ModBlocks.DEEPSLATE_MORTAR.getMaxDurability(), Items.DEEPSLATE);
    public static final MortarBlockItem DIAMOND_MORTAR = register("diamond_mortar", ModBlocks.DIAMOND_MORTAR, ModBlocks.DIAMOND_MORTAR.getMaxDurability(), Items.DIAMOND);
    public static final MortarBlockItem NETHER_BRICK_MORTAR = register("nether_brick_mortar", ModBlocks.NETHER_BRICK_MORTAR, ModBlocks.NETHER_BRICK_MORTAR.getMaxDurability(), Items.NETHER_BRICKS);
    public static final MortarBlockItem NETHERITE_MORTAR = register("netherite_mortar", ModBlocks.NETHERITE_MORTAR, ModBlocks.NETHERITE_MORTAR.getMaxDurability(), Items.NETHERITE_SCRAP);
    public static final MortarBlockItem QUARTZ_MORTAR = register("quartz_mortar", ModBlocks.QUARTZ_MORTAR, ModBlocks.QUARTZ_MORTAR.getMaxDurability(), Items.QUARTZ_BLOCK);
    public static final MortarBlockItem SANDSTONE_MORTAR = register("sandstone_mortar", ModBlocks.SANDSTONE_MORTAR, ModBlocks.SANDSTONE_MORTAR.getMaxDurability(), Items.SANDSTONE);
    public static final MortarBlockItem SMOOTH_STONE_MORTAR = register("smooth_stone_mortar", ModBlocks.SMOOTH_STONE_MORTAR, ModBlocks.SMOOTH_STONE_MORTAR.getMaxDurability(), Items.SMOOTH_STONE);
    public static final MortarBlockItem STONE_MORTAR = register("stone_mortar", ModBlocks.STONE_MORTAR, ModBlocks.STONE_MORTAR.getMaxDurability(), Items.STONE);
    public static final MortarBlockItem TUFF_MORTAR = register("tuff_mortar", ModBlocks.TUFF_MORTAR, ModBlocks.TUFF_MORTAR.getMaxDurability(), Items.TUFF);

    // Helper method for registering an item.
    public static Item register(String id, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(PureBerries.MOD_ID, id), item);
    }

    // new helper for mortars
    public static MortarBlockItem register(String name, Block mortarBlock, int maxDurability, Item repairMaterial) {
        MortarBlockItem item = new MortarBlockItem(mortarBlock, new Item.Settings().maxDamage(maxDurability), repairMaterial);
        return (MortarBlockItem) register(name, item);
    }



    // Registers compostable items with their respective chances.
    public static void registerCompostables() {
        registerGroup(0.3f, ModItems.BLUEBERRIES, ModItems.CLOUDBERRIES, ModItems.GOJI_BERRIES,
                ModItems.REDCURRANTS, ModItems.BLACKCURRANTS, ModItems.GOOSEBERRIES, ModItems.CAPE_GOOSEBERRIES);

        registerGroup(0.85f, ModItems.SWEET_BERRY_COOKIE, ModItems.GLOW_BERRY_COOKIE, ModItems.BLUEBERRY_COOKIE, ModItems.CLOUDBERRY_COOKIE,
                ModItems.GOJI_BERRY_COOKIE, ModItems.REDCURRANT_COOKIE, ModItems.BLACKCURRANT_COOKIE, ModItems.GOOSEBERRY_COOKIE, ModItems.CAPE_GOOSEBERRY_COOKIE);

        registerGroup(1.0f, ModItems.SWEET_BERRY_CAKE, ModItems.GLOW_BERRY_CAKE, ModItems.BLUEBERRY_CAKE,
                ModItems.CLOUDBERRY_CAKE, ModItems.GOJI_BERRY_CAKE, ModItems.REDCURRANT_CAKE,
                ModItems.BLACKCURRANT_CAKE, ModItems.GOOSEBERRY_CAKE, ModItems.CAPE_GOOSEBERRY_CAKE,
                ModItems.SWEET_BERRY_JAM_SANDWICH, ModItems.GLOW_BERRY_JAM_SANDWICH, ModItems.BLUEBERRY_JAM_SANDWICH,
                ModItems.CLOUDBERRY_JAM_SANDWICH, ModItems.GOJI_BERRY_JAM_SANDWICH, ModItems.REDCURRANT_JAM_SANDWICH,
                ModItems.BLACKCURRANT_JAM_SANDWICH, ModItems.GOOSEBERRY_JAM_SANDWICH, ModItems.CAPE_GOOSEBERRY_JAM_SANDWICH,
                ModItems.SWEET_BERRY_MUFFIN, ModItems.GLOW_BERRY_MUFFIN, ModItems.BLUEBERRY_MUFFIN,
                ModItems.CLOUDBERRY_MUFFIN, ModItems.GOJI_BERRY_MUFFIN, ModItems.REDCURRANT_MUFFIN,
                ModItems.BLACKCURRANT_MUFFIN, ModItems.GOOSEBERRY_MUFFIN, ModItems.CAPE_GOOSEBERRY_MUFFIN,
                ModItems.SWEET_BERRY_PIE, ModItems.GLOW_BERRY_PIE, ModItems.BLUEBERRY_PIE,
                ModItems.CLOUDBERRY_PIE, ModItems.GOJI_BERRY_PIE, ModItems.REDCURRANT_PIE,
                ModItems.BLACKCURRANT_PIE, ModItems.GOOSEBERRY_PIE, ModItems.CAPE_GOOSEBERRY_PIE);
    }

    // Internal helper to register a group of items with the same compost chance.
    private static void registerGroup(float chance, ItemConvertible... items) {
        for (ItemConvertible item : items) {
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(item.asItem(), chance);
        }
    }

    // Called from the mod initializer.
    public static void init() {
        registerCompostables();
    }

}
