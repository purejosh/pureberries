package net.purejosh.pureberries.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;

public class ModItemGroups {

    // Berries
    private static final ItemConvertible[] BERRIES = {
            Items.GLOW_BERRIES, // Anchor item, starts the sequence
            ModItems.BLUEBERRIES, // This item follows the previous
            ModItems.CLOUDBERRIES, // ...and so on...
            ModItems.GOJI_BERRIES,
            ModItems.REDCURRANTS,
            ModItems.BLACKCURRANTS,
            ModItems.GOOSEBERRIES,
            ModItems.CAPE_GOOSEBERRIES
    };

    // Cooked
    private static final ItemConvertible[] BERRIES_COOKED = {
            ModItems.CAPE_GOOSEBERRIES,
            ModItems.SWEET_BERRIES_COOKED,
            ModItems.GLOW_BERRIES_COOKED,
            ModItems.BLUEBERRIES_COOKED,
            ModItems.CLOUDBERRIES_COOKED,
            ModItems.GOJI_BERRIES_COOKED,
            ModItems.REDCURRANTS_COOKED,
            ModItems.BLACKCURRANTS_COOKED,
            ModItems.GOOSEBERRIES_COOKED,
            ModItems.CAPE_GOOSEBERRIES_COOKED
    };

    // Cocoa covered
    private static final ItemConvertible[] BERRIES_COCOA_COVERED = {
            ModItems.CAPE_GOOSEBERRIES_COOKED,
            ModItems.SWEET_BERRIES_COCOA_COVERED,
            ModItems.GLOW_BERRIES_COCOA_COVERED,
            ModItems.BLUEBERRIES_COCOA_COVERED,
            ModItems.CLOUDBERRIES_COCOA_COVERED,
            ModItems.GOJI_BERRIES_COCOA_COVERED,
            ModItems.REDCURRANTS_COCOA_COVERED,
            ModItems.BLACKCURRANTS_COCOA_COVERED,
            ModItems.GOOSEBERRIES_COCOA_COVERED,
            ModItems.CAPE_GOOSEBERRIES_COCOA_COVERED
    };

    // Honey dipped
    private static final ItemConvertible[] BERRIES_HONEY_DIPPED = {
            ModItems.CAPE_GOOSEBERRIES_COCOA_COVERED,
            ModItems.SWEET_BERRIES_HONEY_DIPPED,
            ModItems.GLOW_BERRIES_HONEY_DIPPED,
            ModItems.BLUEBERRIES_HONEY_DIPPED,
            ModItems.CLOUDBERRIES_HONEY_DIPPED,
            ModItems.GOJI_BERRIES_HONEY_DIPPED,
            ModItems.REDCURRANTS_HONEY_DIPPED,
            ModItems.BLACKCURRANTS_HONEY_DIPPED,
            ModItems.GOOSEBERRIES_HONEY_DIPPED,
            ModItems.CAPE_GOOSEBERRIES_HONEY_DIPPED
    };

    // Golden
    public static final ItemConvertible[] BERRIES_GOLDEN = {
            ModItems.CAPE_GOOSEBERRIES_HONEY_DIPPED,
            ModItems.SWEET_BERRIES_GOLDEN,
            ModItems.GLOW_BERRIES_GOLDEN,
            ModItems.BLUEBERRIES_GOLDEN,
            ModItems.CLOUDBERRIES_GOLDEN,
            ModItems.GOJI_BERRIES_GOLDEN,
            ModItems.REDCURRANTS_GOLDEN,
            ModItems.BLACKCURRANTS_GOLDEN,
            ModItems.GOOSEBERRIES_GOLDEN,
            ModItems.CAPE_GOOSEBERRIES_GOLDEN
    };

    // Cakes
    private static final ItemConvertible[] BERRY_CAKE = {
            Items.CAKE,
            ModItems.SWEET_BERRY_CAKE,
            ModItems.GLOW_BERRY_CAKE,
            ModItems.BLUEBERRY_CAKE,
            ModItems.CLOUDBERRY_CAKE,
            ModItems.GOJI_BERRY_CAKE,
            ModItems.REDCURRANT_CAKE,
            ModItems.BLACKCURRANT_CAKE,
            ModItems.GOOSEBERRY_CAKE,
            ModItems.CAPE_GOOSEBERRY_CAKE
    };

    // Cookies
    private static final ItemConvertible[] BERRY_COOKIE = {
            Items.COOKIE,
            ModItems.SWEET_BERRY_COOKIE,
            ModItems.GLOW_BERRY_COOKIE,
            ModItems.BLUEBERRY_COOKIE,
            ModItems.CLOUDBERRY_COOKIE,
            ModItems.GOJI_BERRY_COOKIE,
            ModItems.REDCURRANT_COOKIE,
            ModItems.BLACKCURRANT_COOKIE,
            ModItems.GOOSEBERRY_COOKIE,
            ModItems.CAPE_GOOSEBERRY_COOKIE
    };

    // Jam sandwiches
    private static final ItemConvertible[] BERRY_JAM_SANDWICH = {
            Items.BREAD,
            ModItems.SWEET_BERRY_JAM_SANDWICH,
            ModItems.GLOW_BERRY_JAM_SANDWICH,
            ModItems.BLUEBERRY_JAM_SANDWICH,
            ModItems.CLOUDBERRY_JAM_SANDWICH,
            ModItems.GOJI_BERRY_JAM_SANDWICH,
            ModItems.REDCURRANT_JAM_SANDWICH,
            ModItems.BLACKCURRANT_JAM_SANDWICH,
            ModItems.GOOSEBERRY_JAM_SANDWICH,
            ModItems.CAPE_GOOSEBERRY_JAM_SANDWICH
    };

    // Muffins
    private static final ItemConvertible[] BERRY_MUFFIN = {
            ModItems.CAPE_GOOSEBERRY_COOKIE,
            ModItems.SWEET_BERRY_MUFFIN,
            ModItems.GLOW_BERRY_MUFFIN,
            ModItems.BLUEBERRY_MUFFIN,
            ModItems.CLOUDBERRY_MUFFIN,
            ModItems.GOJI_BERRY_MUFFIN,
            ModItems.REDCURRANT_MUFFIN,
            ModItems.BLACKCURRANT_MUFFIN,
            ModItems.GOOSEBERRY_MUFFIN,
            ModItems.CAPE_GOOSEBERRY_MUFFIN
    };

    // Pies
    private static final ItemConvertible[] BERRY_PIE = {
            Items.PUMPKIN_PIE,
            ModItems.SWEET_BERRY_PIE,
            ModItems.GLOW_BERRY_PIE,
            ModItems.BLUEBERRY_PIE,
            ModItems.CLOUDBERRY_PIE,
            ModItems.GOJI_BERRY_PIE,
            ModItems.REDCURRANT_PIE,
            ModItems.BLACKCURRANT_PIE,
            ModItems.GOOSEBERRY_PIE,
            ModItems.CAPE_GOOSEBERRY_PIE
    };

    // Juices
    private static final ItemConvertible[] BERRY_JUICE = {
            Items.HONEY_BOTTLE,
            ModItems.SWEET_BERRY_JUICE,
            ModItems.GLOW_BERRY_JUICE,
            ModItems.BLUEBERRY_JUICE,
            ModItems.CLOUDBERRY_JUICE,
            ModItems.GOJI_BERRY_JUICE,
            ModItems.REDCURRANT_JUICE,
            ModItems.BLACKCURRANT_JUICE,
            ModItems.GOOSEBERRY_JUICE,
            ModItems.CAPE_GOOSEBERRY_JUICE
    };

    // Jams
    private static final ItemConvertible[] BERRY_JAM = {
            ModItems.CAPE_GOOSEBERRY_JAM_SANDWICH,
            ModItems.SWEET_BERRY_JAM,
            ModItems.GLOW_BERRY_JAM,
            ModItems.BLUEBERRY_JAM,
            ModItems.CLOUDBERRY_JAM,
            ModItems.GOJI_BERRY_JAM,
            ModItems.REDCURRANT_JAM,
            ModItems.BLACKCURRANT_JAM,
            ModItems.GOOSEBERRY_JAM,
            ModItems.CAPE_GOOSEBERRY_JAM
    };

    // Mortars
    private static final ItemConvertible[] MORTARS = {
            Items.CAULDRON,
            ModItems.CALCITE_MORTAR,
            ModItems.TUFF_MORTAR,
            ModItems.BASALT_MORTAR,
            ModItems.BLACKSTONE_MORTAR,
            ModItems.DEEPSLATE_MORTAR,
            ModItems.NETHER_BRICK_MORTAR,
            ModItems.SMOOTH_STONE_MORTAR,
            ModItems.STONE_MORTAR,
            ModItems.ANDESITE_MORTAR,
            ModItems.SANDSTONE_MORTAR,
            ModItems.QUARTZ_MORTAR,
            ModItems.DIAMOND_MORTAR,
            ModItems.NETHERITE_MORTAR
    };

    // Misc
    public static final ItemConvertible[] GLOW_DYE = {
            Items.PINK_DYE,
            ModItems.GLOW_DYE
    };

    public static void init() {
        // Registers the lists above in this order, defines the tab here.
        registerSequence(ItemGroups.FOOD_AND_DRINK, BERRIES);
        registerSequence(ItemGroups.FOOD_AND_DRINK, BERRIES_COOKED);
        registerSequence(ItemGroups.FOOD_AND_DRINK, BERRIES_COCOA_COVERED);
        registerSequence(ItemGroups.FOOD_AND_DRINK, BERRIES_HONEY_DIPPED);
        registerSequence(ItemGroups.FOOD_AND_DRINK, BERRIES_GOLDEN);
        registerSequence(ItemGroups.FOOD_AND_DRINK, BERRY_CAKE);
        registerSequence(ItemGroups.FOOD_AND_DRINK, BERRY_COOKIE);
        registerSequence(ItemGroups.FOOD_AND_DRINK, BERRY_JAM_SANDWICH);
        registerSequence(ItemGroups.FOOD_AND_DRINK, BERRY_MUFFIN);
        registerSequence(ItemGroups.FOOD_AND_DRINK, BERRY_PIE);
        registerSequence(ItemGroups.FOOD_AND_DRINK, BERRY_JUICE);
        registerSequence(ItemGroups.FOOD_AND_DRINK, BERRY_JAM);
        registerSequence(ItemGroups.INGREDIENTS, GLOW_DYE);
        registerSequence(ItemGroups.FUNCTIONAL, MORTARS);
    }

    // Loops through the ItemConvertible list and calls addAfter for each adjacent pair
    private static void registerSequence(RegistryKey<ItemGroup> group, ItemConvertible... items) {
        for (int i = 1; i < items.length; i++) {
            registerItemOrder(group, items[i - 1], items[i]);
        }
    }

    private static void registerItemOrder(RegistryKey<ItemGroup> group, ItemConvertible before, ItemConvertible after) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(before, after));
    }
}
