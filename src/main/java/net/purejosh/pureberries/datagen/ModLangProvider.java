package net.purejosh.pureberries.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import net.purejosh.pureberries.block.ModBlocks;
import net.purejosh.pureberries.entity.effect.ModStatusEffects;
import net.purejosh.pureberries.item.ModItems;
import net.purejosh.pureberries.world.ModGameRules;

import java.util.concurrent.CompletableFuture;

public class ModLangProvider extends FabricLanguageProvider {
    public ModLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    // It might be unusual, but I'm going to add these in the same order as ModBlocks
    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        // Blocks
        // Natural Blocks
        translationBuilder.add(ModBlocks.BLUEBERRY_BUSH, "Blueberry Bush");
        translationBuilder.add(ModBlocks.CLOUDBERRY_PATCH, "Cloudberry Patch");
        translationBuilder.add(ModBlocks.GOJI_BERRY_SHRUB, "Goji Berry Shrub");
        translationBuilder.add(ModBlocks.REDCURRANT_SHRUB, "Redcurrant Shrub");
        translationBuilder.add(ModBlocks.BLACKCURRANT_SHRUB, "Blackcurrant Shrub");
        translationBuilder.add(ModBlocks.GOOSEBERRY_SHRUB, "Gooseberry Shrub");
        translationBuilder.add(ModBlocks.CAPE_GOOSEBERRY_SHRUB, "Cape Gooseberry Shrub");

        // Functional Blocks
        translationBuilder.add(ModBlocks.ANDESITE_MORTAR, "Andesite Mortar and Pestle");
        translationBuilder.add(ModBlocks.BASALT_MORTAR, "Basalt Mortar and Pestle");
        translationBuilder.add(ModBlocks.BLACKSTONE_MORTAR, "Blackstone Mortar and Pestle");
        translationBuilder.add(ModBlocks.CALCITE_MORTAR, "Calcite Mortar and Pestle");
        translationBuilder.add(ModBlocks.DEEPSLATE_MORTAR, "Deepslate Mortar and Pestle");
        translationBuilder.add(ModBlocks.DIAMOND_MORTAR, "Diamond Mortar and Pestle");
        translationBuilder.add(ModBlocks.NETHER_BRICK_MORTAR, "Nether Brick Mortar and Pestle");
        translationBuilder.add(ModBlocks.NETHERITE_MORTAR, "Netherite Mortar and Pestle");
        translationBuilder.add(ModBlocks.QUARTZ_MORTAR, "Quartz Mortar and Pestle");
        translationBuilder.add(ModBlocks.SANDSTONE_MORTAR, "Sandstone Mortar and Pestle");
        translationBuilder.add(ModBlocks.SMOOTH_STONE_MORTAR, "Smooth Stone Mortar and Pestle");
        translationBuilder.add(ModBlocks.STONE_MORTAR, "Stone Mortar and Pestle");
        translationBuilder.add(ModBlocks.TUFF_MORTAR, "Tuff Mortar and Pestle");
        
        // Items
        // Food & Drink
        // Berries
        translationBuilder.add(ModItems.BLUEBERRIES, "Blueberries");
        translationBuilder.add(ModItems.CLOUDBERRIES, "Cloudberries");
        translationBuilder.add(ModItems.GOJI_BERRIES, "Goji Berries");
        translationBuilder.add(ModItems.REDCURRANTS, "Redcurrants");
        translationBuilder.add(ModItems.BLACKCURRANTS, "Blackcurrants");
        translationBuilder.add(ModItems.GOOSEBERRIES, "Gooseberries");
        translationBuilder.add(ModItems.CAPE_GOOSEBERRIES, "Cape Gooseberries");

        // Cooked
        translationBuilder.add(ModItems.SWEET_BERRIES_COOKED, "Cooked Sweet Berries");
        translationBuilder.add(ModItems.GLOW_BERRIES_COOKED, "Cooked Glow Berries");
        translationBuilder.add(ModItems.BLUEBERRIES_COOKED, "Cooked Blueberries");
        translationBuilder.add(ModItems.CLOUDBERRIES_COOKED, "Cooked Cloudberries");
        translationBuilder.add(ModItems.GOJI_BERRIES_COOKED, "Cooked Goji Berries");
        translationBuilder.add(ModItems.REDCURRANTS_COOKED, "Cooked Redcurrants");
        translationBuilder.add(ModItems.BLACKCURRANTS_COOKED, "Cooked Blackcurrants");
        translationBuilder.add(ModItems.GOOSEBERRIES_COOKED, "Cooked Gooseberries");
        translationBuilder.add(ModItems.CAPE_GOOSEBERRIES_COOKED, "Cooked Cape Gooseberries");

        // Cocoa Covered
        translationBuilder.add(ModItems.SWEET_BERRIES_COCOA_COVERED, "Cocoa Covered Sweet Berries");
        translationBuilder.add(ModItems.GLOW_BERRIES_COCOA_COVERED, "Cocoa Covered Glow Berries");
        translationBuilder.add(ModItems.BLUEBERRIES_COCOA_COVERED, "Cocoa Covered Blueberries");
        translationBuilder.add(ModItems.CLOUDBERRIES_COCOA_COVERED, "Cocoa Covered Cloudberries");
        translationBuilder.add(ModItems.GOJI_BERRIES_COCOA_COVERED, "Cocoa Covered Goji Berries");
        translationBuilder.add(ModItems.REDCURRANTS_COCOA_COVERED, "Cocoa Covered Redcurrants");
        translationBuilder.add(ModItems.BLACKCURRANTS_COCOA_COVERED, "Cocoa Covered Blackcurrants");
        translationBuilder.add(ModItems.GOOSEBERRIES_COCOA_COVERED, "Cocoa Covered Gooseberries");
        translationBuilder.add(ModItems.CAPE_GOOSEBERRIES_COCOA_COVERED, "Cocoa Covered Cape Gooseberries");

        // Honey Dipped
        translationBuilder.add(ModItems.SWEET_BERRIES_HONEY_DIPPED, "Honey Dipped Sweet Berries");
        translationBuilder.add(ModItems.GLOW_BERRIES_HONEY_DIPPED, "Honey Dipped Glow Berries");
        translationBuilder.add(ModItems.BLUEBERRIES_HONEY_DIPPED, "Honey Dipped Blueberries");
        translationBuilder.add(ModItems.CLOUDBERRIES_HONEY_DIPPED, "Honey Dipped Cloudberries");
        translationBuilder.add(ModItems.GOJI_BERRIES_HONEY_DIPPED, "Honey Dipped Goji Berries");
        translationBuilder.add(ModItems.REDCURRANTS_HONEY_DIPPED, "Honey Dipped Redcurrants");
        translationBuilder.add(ModItems.BLACKCURRANTS_HONEY_DIPPED, "Honey Dipped Blackcurrants");
        translationBuilder.add(ModItems.GOOSEBERRIES_HONEY_DIPPED, "Honey Dipped Gooseberries");
        translationBuilder.add(ModItems.CAPE_GOOSEBERRIES_HONEY_DIPPED, "Honey Dipped Cape Gooseberries");

        // Golden
        translationBuilder.add(ModItems.SWEET_BERRIES_GOLDEN, "Golden Sweet Berries");
        translationBuilder.add(ModItems.GLOW_BERRIES_GOLDEN, "Golden Glow Berries");
        translationBuilder.add(ModItems.BLUEBERRIES_GOLDEN, "Golden Blueberries");
        translationBuilder.add(ModItems.CLOUDBERRIES_GOLDEN, "Golden Cloudberries");
        translationBuilder.add(ModItems.GOJI_BERRIES_GOLDEN, "Golden Goji Berries");
        translationBuilder.add(ModItems.REDCURRANTS_GOLDEN, "Golden Redcurrants");
        translationBuilder.add(ModItems.BLACKCURRANTS_GOLDEN, "Golden Blackcurrants");
        translationBuilder.add(ModItems.GOOSEBERRIES_GOLDEN, "Golden Gooseberries");
        translationBuilder.add(ModItems.CAPE_GOOSEBERRIES_GOLDEN, "Golden Cape Gooseberries");

        // Cakes
        translationBuilder.add(ModItems.SWEET_BERRY_CAKE, "Sweet Berry Cake");
        translationBuilder.add(ModItems.GLOW_BERRY_CAKE, "Glow Berry Cake");
        translationBuilder.add(ModItems.BLUEBERRY_CAKE, "Blueberry Cake");
        translationBuilder.add(ModItems.CLOUDBERRY_CAKE, "Cloudberry Cake");
        translationBuilder.add(ModItems.GOJI_BERRY_CAKE, "Goji Berry Cake");
        translationBuilder.add(ModItems.REDCURRANT_CAKE, "Redcurrant Cake");
        translationBuilder.add(ModItems.BLACKCURRANT_CAKE, "Blackcurrant Cake");
        translationBuilder.add(ModItems.GOOSEBERRY_CAKE, "Gooseberry Cake");
        translationBuilder.add(ModItems.CAPE_GOOSEBERRY_CAKE, "Cape Gooseberry Cake");

        // Cookies
        translationBuilder.add(ModItems.SWEET_BERRY_COOKIE, "Sweet Berry Cookie");
        translationBuilder.add(ModItems.GLOW_BERRY_COOKIE, "Glow Berry Cookie");
        translationBuilder.add(ModItems.BLUEBERRY_COOKIE, "Blueberry Cookie");
        translationBuilder.add(ModItems.CLOUDBERRY_COOKIE, "Cloudberry Cookie");
        translationBuilder.add(ModItems.GOJI_BERRY_COOKIE, "Goji Berry Cookie");
        translationBuilder.add(ModItems.REDCURRANT_COOKIE, "Redcurrant Cookie");
        translationBuilder.add(ModItems.BLACKCURRANT_COOKIE, "Blackcurrant Cookie");
        translationBuilder.add(ModItems.GOOSEBERRY_COOKIE, "Gooseberry Cookie");
        translationBuilder.add(ModItems.CAPE_GOOSEBERRY_COOKIE, "Cape Gooseberry Cookie");

        // Muffins
        translationBuilder.add(ModItems.SWEET_BERRY_MUFFIN, "Sweet Berry Muffin");
        translationBuilder.add(ModItems.GLOW_BERRY_MUFFIN, "Glow Berry Muffin");
        translationBuilder.add(ModItems.BLUEBERRY_MUFFIN, "Blueberry Muffin");
        translationBuilder.add(ModItems.CLOUDBERRY_MUFFIN, "Cloudberry Muffin");
        translationBuilder.add(ModItems.GOJI_BERRY_MUFFIN, "Goji Berry Muffin");
        translationBuilder.add(ModItems.REDCURRANT_MUFFIN, "Redcurrant Muffin");
        translationBuilder.add(ModItems.BLACKCURRANT_MUFFIN, "Blackcurrant Muffin");
        translationBuilder.add(ModItems.GOOSEBERRY_MUFFIN, "Gooseberry Muffin");
        translationBuilder.add(ModItems.CAPE_GOOSEBERRY_MUFFIN, "Cape Gooseberry Muffin");

        // Pies
        translationBuilder.add(ModItems.SWEET_BERRY_PIE, "Sweet Berry Pie");
        translationBuilder.add(ModItems.GLOW_BERRY_PIE, "Glow Berry Pie");
        translationBuilder.add(ModItems.BLUEBERRY_PIE, "Blueberry Pie");
        translationBuilder.add(ModItems.CLOUDBERRY_PIE, "Cloudberry Pie");
        translationBuilder.add(ModItems.GOJI_BERRY_PIE, "Goji Berry Pie");
        translationBuilder.add(ModItems.REDCURRANT_PIE, "Redcurrant Pie");
        translationBuilder.add(ModItems.BLACKCURRANT_PIE, "Blackcurrant Pie");
        translationBuilder.add(ModItems.GOOSEBERRY_PIE, "Gooseberry Pie");
        translationBuilder.add(ModItems.CAPE_GOOSEBERRY_PIE, "Cape Gooseberry Pie");

        // Juices
        translationBuilder.add(ModItems.SWEET_BERRY_JUICE, "Sweet Berry Juice");
        translationBuilder.add(ModItems.GLOW_BERRY_JUICE, "Glow Berry Juice");
        translationBuilder.add(ModItems.BLUEBERRY_JUICE, "Blueberry Juice");
        translationBuilder.add(ModItems.CLOUDBERRY_JUICE, "Cloudberry Juice");
        translationBuilder.add(ModItems.GOJI_BERRY_JUICE, "Goji Berry Juice");
        translationBuilder.add(ModItems.REDCURRANT_JUICE, "Redcurrant Juice");
        translationBuilder.add(ModItems.BLACKCURRANT_JUICE, "Blackcurrant Juice");
        translationBuilder.add(ModItems.GOOSEBERRY_JUICE, "Gooseberry Juice");
        translationBuilder.add(ModItems.CAPE_GOOSEBERRY_JUICE, "Cape Gooseberry Juice");

        // Jams
        translationBuilder.add(ModItems.SWEET_BERRY_JAM, "Sweet Berry Jam");
        translationBuilder.add(ModItems.GLOW_BERRY_JAM, "Glow Berry Jam");
        translationBuilder.add(ModItems.BLUEBERRY_JAM, "Blueberry Jam");
        translationBuilder.add(ModItems.CLOUDBERRY_JAM, "Cloudberry Jam");
        translationBuilder.add(ModItems.GOJI_BERRY_JAM, "Goji Berry Jam");
        translationBuilder.add(ModItems.REDCURRANT_JAM, "Redcurrant Jam");
        translationBuilder.add(ModItems.BLACKCURRANT_JAM, "Blackcurrant Jam");
        translationBuilder.add(ModItems.GOOSEBERRY_JAM, "Gooseberry Jam");
        translationBuilder.add(ModItems.CAPE_GOOSEBERRY_JAM, "Cape Gooseberry Jam");

        // Jam Sandwiches
        translationBuilder.add(ModItems.SWEET_BERRY_JAM_SANDWICH, "Sweet Berry Jam Sandwich");
        translationBuilder.add(ModItems.GLOW_BERRY_JAM_SANDWICH, "Glow Berry Jam Sandwich");
        translationBuilder.add(ModItems.BLUEBERRY_JAM_SANDWICH, "Blueberry Jam Sandwich");
        translationBuilder.add(ModItems.CLOUDBERRY_JAM_SANDWICH, "Cloudberry Jam Sandwich");
        translationBuilder.add(ModItems.GOJI_BERRY_JAM_SANDWICH, "Goji Berry Jam Sandwich");
        translationBuilder.add(ModItems.REDCURRANT_JAM_SANDWICH, "Redcurrant Jam Sandwich");
        translationBuilder.add(ModItems.BLACKCURRANT_JAM_SANDWICH, "Blackcurrant Jam Sandwich");
        translationBuilder.add(ModItems.GOOSEBERRY_JAM_SANDWICH, "Gooseberry Jam Sandwich");
        translationBuilder.add(ModItems.CAPE_GOOSEBERRY_JAM_SANDWICH, "Cape Gooseberry Jam Sandwich");

        // Misc
        translationBuilder.add(ModItems.GLOW_DYE, "Glow Dye");

        // Mod Effects
        translationBuilder.add(ModStatusEffects.DETOXIFY.value(), "Detoxify");
        translationBuilder.add(ModStatusEffects.LUMINANCE.value(), "Luminance");
        translationBuilder.add(ModStatusEffects.NIMBUS.value(), "Nimbus");
        translationBuilder.add(ModStatusEffects.SUSTENANCE.value(), "Sustenance");
        translationBuilder.add(ModStatusEffects.VITALITY.value(), "Vitality");

        // Gamerules
        translationBuilder.add(ModGameRules.DETOXIFY_STRENGTH.getTranslationKey(),
                "Pure Berries: Detoxify Strength (Percentage)");
        translationBuilder.add(ModGameRules.DETOXIFY_STRENGTH.getTranslationKey() + ".description",
                "Determines the percentage that negative status effects are reduced every 5 seconds. Set to 0 to disable.");
        translationBuilder.add(ModGameRules.LUMINANCE_RADIUS.getTranslationKey(),
                "Pure Berries: Luminance Radius (Integer)");
        translationBuilder.add(ModGameRules.LUMINANCE_RADIUS.getTranslationKey() + ".description",
                "Determines the radius that nearby entities are affected. Set to 0 to disable.");
        translationBuilder.add(ModGameRules.NIMBUS_STRENGTH.getTranslationKey(),
                "Pure Berries: Nimbus Strength (Percentage)");
        translationBuilder.add(ModGameRules.NIMBUS_STRENGTH.getTranslationKey() + ".description",
                "Determines the strength of the gravity, safe fall distance, and fall damage multiplier effects. Set to 0 to disable.");
        translationBuilder.add(ModGameRules.SUSTENANCE_STRENGTH.getTranslationKey(),
                "Pure Berries: Sustenance Strength (Float)");
        translationBuilder.add(ModGameRules.SUSTENANCE_STRENGTH.getTranslationKey() + ".description",
                "Determines the value that exhaustion is regenerated. Set to 0 to disable.");
        translationBuilder.add(ModGameRules.VITALITY_STRENGTH.getTranslationKey(),
                "Pure Berries: Vitality Strength (Percentage)");
        translationBuilder.add(ModGameRules.VITALITY_STRENGTH.getTranslationKey() + ".description",
                "Determines the modification against the frequency that health is regenerated. Set to 0 to disable.");
        translationBuilder.add(ModGameRules.MORTAR_DURABILITY.getTranslationKey(),
                "Pure Berries: Mortar Durability (Boolean)");
        translationBuilder.add(ModGameRules.MORTAR_DURABILITY.getTranslationKey() + ".description",
                "Enables durability loss on mortars when used. Set to false to disable.");

        // Sound subtitles
        translationBuilder.add("subtitles.pureberries.nimbus_whirl", "Nimbus whirling");
        translationBuilder.add("subtitles.pureberries.nimbus_end", "Nimbus dissipating");
        translationBuilder.add("subtitles.pureberries.mortar_use", "Mortar grinds");
        translationBuilder.add("subtitles.pureberries.mortar_impact", "Mortar breaks");
        translationBuilder.add("subtitles.pureberries.mortar_hit", "Mortar cracking");

        // Tooltips
        translationBuilder.add("item.pureberries.hold", "Hold");
        translationBuilder.add("item.pureberries.shift", "shift");
        translationBuilder.add("item.pureberries.for_info", "for info");
        translationBuilder.add("item.pureberries.golden_berries.detoxify.tooltip",
                "Reduces the duration of negative\n" +
                    "status effects every 5 seconds.\n" +
                    "Higher levels increase reduction\n" +
                    "amount and duration.");

        translationBuilder.add("item.pureberries.golden_berries.luminance.tooltip",
                "Makes nearby entities glow.\n" +
                    "Higher levels increase the\n" +
                    "glow radius and duration.");

        translationBuilder.add("item.pureberries.golden_berries.nimbus.tooltip",
                "Grants a floating effect while\n" +
                    "jumping, and slow falling that\n" +
                    "fades over time. Reduces fall\n" +
                    "damage. Higher levels enhance\n" +
                    "all aspects of the effect.");

        translationBuilder.add("item.pureberries.golden_berries.sustenance.tooltip",
                "Regenerates exhaustion.\n" +
                    "Higher levels increase\n" +
                    "efficacy and duration.");

        translationBuilder.add("item.pureberries.golden_berries.vitality.tooltip",
                "Regenerates health. Higher\n" +
                    "levels increase effect\n" +
                    "speed and duration.");

        translationBuilder.add("block.pureberries.cake.candle_disabled", "Candle placement is not yet supported");
    }
}

