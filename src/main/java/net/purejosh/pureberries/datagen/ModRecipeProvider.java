package net.purejosh.pureberries.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.recipe.SmokingRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.purejosh.pureberries.block.ModBlocks;
import net.purejosh.pureberries.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        // Blocks
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.ANDESITE_MORTAR, Blocks.ANDESITE);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.ANDESITE_MORTAR, Blocks.POLISHED_ANDESITE);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.BASALT_MORTAR, Blocks.BASALT);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.BASALT_MORTAR, Blocks.POLISHED_BASALT);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.BLACKSTONE_MORTAR, Blocks.BLACKSTONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.BLACKSTONE_MORTAR, Blocks.POLISHED_BLACKSTONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.CALCITE_MORTAR, Blocks.CALCITE);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.DEEPSLATE_MORTAR, Blocks.DEEPSLATE);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.DEEPSLATE_MORTAR, Blocks.POLISHED_DEEPSLATE);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.DIAMOND_MORTAR, Blocks.DIAMOND_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.NETHER_BRICK_MORTAR, Blocks.NETHER_BRICKS);
        offerNetheriteUpgradeRecipe(exporter, ModItems.DIAMOND_MORTAR, RecipeCategory.DECORATIONS, ModItems.NETHERITE_MORTAR);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.QUARTZ_MORTAR, Blocks.QUARTZ_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.QUARTZ_MORTAR, Blocks.SMOOTH_QUARTZ);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.SANDSTONE_MORTAR, Blocks.SANDSTONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.SANDSTONE_MORTAR, Blocks.SMOOTH_SANDSTONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.SMOOTH_STONE_MORTAR, Blocks.SMOOTH_STONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.STONE_MORTAR, Blocks.STONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.TUFF_MORTAR, Blocks.TUFF);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.TUFF_MORTAR, Blocks.POLISHED_TUFF);

        // Items
        // Cooked Berries
        offerCookedBerryRecipes(exporter, Items.SWEET_BERRIES, ModItems.SWEET_BERRIES_COOKED);
        offerCookedBerryRecipes(exporter, Items.GLOW_BERRIES, ModItems.GLOW_BERRIES_COOKED);
        offerCookedBerryRecipes(exporter, ModItems.BLUEBERRIES, ModItems.BLUEBERRIES_COOKED);
        offerCookedBerryRecipes(exporter, ModItems.CLOUDBERRIES, ModItems.CLOUDBERRIES_COOKED);
        offerCookedBerryRecipes(exporter, ModItems.GOJI_BERRIES, ModItems.GOJI_BERRIES_COOKED);
        offerCookedBerryRecipes(exporter, ModItems.REDCURRANTS, ModItems.REDCURRANTS_COOKED);
        offerCookedBerryRecipes(exporter, ModItems.BLACKCURRANTS, ModItems.BLACKCURRANTS_COOKED);
        offerCookedBerryRecipes(exporter, ModItems.GOOSEBERRIES, ModItems.GOOSEBERRIES_COOKED);
        offerCookedBerryRecipes(exporter, ModItems.CAPE_GOOSEBERRIES, ModItems.CAPE_GOOSEBERRIES_COOKED);

        // Cocoa Covered
        offerCocoaCoveredRecipe(exporter, ModItems.SWEET_BERRIES_COOKED, ModItems.SWEET_BERRIES_COCOA_COVERED);
        offerCocoaCoveredRecipe(exporter, ModItems.GLOW_BERRIES_COOKED, ModItems.GLOW_BERRIES_COCOA_COVERED);
        offerCocoaCoveredRecipe(exporter, ModItems.BLUEBERRIES_COOKED, ModItems.BLUEBERRIES_COCOA_COVERED);
        offerCocoaCoveredRecipe(exporter, ModItems.CLOUDBERRIES_COOKED, ModItems.CLOUDBERRIES_COCOA_COVERED);
        offerCocoaCoveredRecipe(exporter, ModItems.GOJI_BERRIES_COOKED, ModItems.GOJI_BERRIES_COCOA_COVERED);
        offerCocoaCoveredRecipe(exporter, ModItems.REDCURRANTS_COOKED, ModItems.REDCURRANTS_COCOA_COVERED);
        offerCocoaCoveredRecipe(exporter, ModItems.BLACKCURRANTS_COOKED, ModItems.BLACKCURRANTS_COCOA_COVERED);
        offerCocoaCoveredRecipe(exporter, ModItems.GOOSEBERRIES_COOKED, ModItems.GOOSEBERRIES_COCOA_COVERED);
        offerCocoaCoveredRecipe(exporter, ModItems.CAPE_GOOSEBERRIES_COOKED, ModItems.CAPE_GOOSEBERRIES_COCOA_COVERED);

        // Honey Dipped
        offerHoneyDippedRecipe(exporter, ModItems.SWEET_BERRIES_COOKED, ModItems.SWEET_BERRIES_HONEY_DIPPED);
        offerHoneyDippedRecipe(exporter, ModItems.GLOW_BERRIES_COOKED, ModItems.GLOW_BERRIES_HONEY_DIPPED);
        offerHoneyDippedRecipe(exporter, ModItems.BLUEBERRIES_COOKED, ModItems.BLUEBERRIES_HONEY_DIPPED);
        offerHoneyDippedRecipe(exporter, ModItems.CLOUDBERRIES_COOKED, ModItems.CLOUDBERRIES_HONEY_DIPPED);
        offerHoneyDippedRecipe(exporter, ModItems.GOJI_BERRIES_COOKED, ModItems.GOJI_BERRIES_HONEY_DIPPED);
        offerHoneyDippedRecipe(exporter, ModItems.REDCURRANTS_COOKED, ModItems.REDCURRANTS_HONEY_DIPPED);
        offerHoneyDippedRecipe(exporter, ModItems.BLACKCURRANTS_COOKED, ModItems.BLACKCURRANTS_HONEY_DIPPED);
        offerHoneyDippedRecipe(exporter, ModItems.GOOSEBERRIES_COOKED, ModItems.GOOSEBERRIES_HONEY_DIPPED);
        offerHoneyDippedRecipe(exporter, ModItems.CAPE_GOOSEBERRIES_COOKED, ModItems.CAPE_GOOSEBERRIES_HONEY_DIPPED);

        // Golden
        offerGoldenRecipe(exporter, Items.SWEET_BERRIES, ModItems.SWEET_BERRIES_GOLDEN);
        offerGoldenRecipe(exporter, Items.GLOW_BERRIES, ModItems.GLOW_BERRIES_GOLDEN);
        offerGoldenRecipe(exporter, ModItems.BLUEBERRIES, ModItems.BLUEBERRIES_GOLDEN);
        offerGoldenRecipe(exporter, ModItems.CLOUDBERRIES, ModItems.CLOUDBERRIES_GOLDEN);
        offerGoldenRecipe(exporter, ModItems.GOJI_BERRIES, ModItems.GOJI_BERRIES_GOLDEN);
        offerGoldenRecipe(exporter, ModItems.REDCURRANTS, ModItems.REDCURRANTS_GOLDEN);
        offerGoldenRecipe(exporter, ModItems.BLACKCURRANTS, ModItems.BLACKCURRANTS_GOLDEN);
        offerGoldenRecipe(exporter, ModItems.GOOSEBERRIES, ModItems.GOOSEBERRIES_GOLDEN);
        offerGoldenRecipe(exporter, ModItems.CAPE_GOOSEBERRIES, ModItems.CAPE_GOOSEBERRIES_GOLDEN);

        // Cake
        offerCakeRecipe(exporter, Items.SWEET_BERRIES, ModItems.SWEET_BERRY_CAKE);
        offerCakeRecipe(exporter, Items.GLOW_BERRIES, ModItems.GLOW_BERRY_CAKE);
        offerCakeRecipe(exporter, ModItems.BLUEBERRIES, ModItems.BLUEBERRY_CAKE);
        offerCakeRecipe(exporter, ModItems.CLOUDBERRIES, ModItems.CLOUDBERRY_CAKE);
        offerCakeRecipe(exporter, ModItems.GOJI_BERRIES, ModItems.GOJI_BERRY_CAKE);
        offerCakeRecipe(exporter, ModItems.REDCURRANTS, ModItems.REDCURRANT_CAKE);
        offerCakeRecipe(exporter, ModItems.BLACKCURRANTS, ModItems.BLACKCURRANT_CAKE);
        offerCakeRecipe(exporter, ModItems.GOOSEBERRIES, ModItems.GOOSEBERRY_CAKE);
        offerCakeRecipe(exporter, ModItems.CAPE_GOOSEBERRIES, ModItems.CAPE_GOOSEBERRY_CAKE);

        // Cookies
        offerCookieRecipe(exporter, Items.SWEET_BERRIES, ModItems.SWEET_BERRY_COOKIE);
        offerCookieRecipe(exporter, Items.GLOW_BERRIES, ModItems.GLOW_BERRY_COOKIE);
        offerCookieRecipe(exporter, ModItems.BLUEBERRIES, ModItems.BLUEBERRY_COOKIE);
        offerCookieRecipe(exporter, ModItems.CLOUDBERRIES, ModItems.CLOUDBERRY_COOKIE);
        offerCookieRecipe(exporter, ModItems.GOJI_BERRIES, ModItems.GOJI_BERRY_COOKIE);
        offerCookieRecipe(exporter, ModItems.REDCURRANTS, ModItems.REDCURRANT_COOKIE);
        offerCookieRecipe(exporter, ModItems.BLACKCURRANTS, ModItems.BLACKCURRANT_COOKIE);
        offerCookieRecipe(exporter, ModItems.GOOSEBERRIES, ModItems.GOOSEBERRY_COOKIE);
        offerCookieRecipe(exporter, ModItems.CAPE_GOOSEBERRIES, ModItems.CAPE_GOOSEBERRY_COOKIE);

        // Jam Sandwiches
        offerJamSandwichRecipe(exporter, ModItems.SWEET_BERRY_JAM, ModItems.SWEET_BERRY_JAM_SANDWICH);
        offerJamSandwichRecipe(exporter, ModItems.GLOW_BERRY_JAM, ModItems.GLOW_BERRY_JAM_SANDWICH);
        offerJamSandwichRecipe(exporter, ModItems.BLUEBERRY_JAM, ModItems.BLUEBERRY_JAM_SANDWICH);
        offerJamSandwichRecipe(exporter, ModItems.CLOUDBERRY_JAM, ModItems.CLOUDBERRY_JAM_SANDWICH);
        offerJamSandwichRecipe(exporter, ModItems.GOJI_BERRY_JAM, ModItems.GOJI_BERRY_JAM_SANDWICH);
        offerJamSandwichRecipe(exporter, ModItems.REDCURRANT_JAM, ModItems.REDCURRANT_JAM_SANDWICH);
        offerJamSandwichRecipe(exporter, ModItems.BLACKCURRANT_JAM, ModItems.BLACKCURRANT_JAM_SANDWICH);
        offerJamSandwichRecipe(exporter, ModItems.GOOSEBERRY_JAM, ModItems.GOOSEBERRY_JAM_SANDWICH);
        offerJamSandwichRecipe(exporter, ModItems.CAPE_GOOSEBERRY_JAM, ModItems.CAPE_GOOSEBERRY_JAM_SANDWICH);

        // Muffins
        offerMuffinRecipe(exporter, Items.SWEET_BERRIES, ModItems.SWEET_BERRY_MUFFIN);
        offerMuffinRecipe(exporter, Items.GLOW_BERRIES, ModItems.GLOW_BERRY_MUFFIN);
        offerMuffinRecipe(exporter, ModItems.BLUEBERRIES, ModItems.BLUEBERRY_MUFFIN);
        offerMuffinRecipe(exporter, ModItems.CLOUDBERRIES, ModItems.CLOUDBERRY_MUFFIN);
        offerMuffinRecipe(exporter, ModItems.GOJI_BERRIES, ModItems.GOJI_BERRY_MUFFIN);
        offerMuffinRecipe(exporter, ModItems.REDCURRANTS, ModItems.REDCURRANT_MUFFIN);
        offerMuffinRecipe(exporter, ModItems.BLACKCURRANTS, ModItems.BLACKCURRANT_MUFFIN);
        offerMuffinRecipe(exporter, ModItems.GOOSEBERRIES, ModItems.GOOSEBERRY_MUFFIN);
        offerMuffinRecipe(exporter, ModItems.CAPE_GOOSEBERRIES, ModItems.CAPE_GOOSEBERRY_MUFFIN);

        // Pies
        offerPieRecipe(exporter, Items.SWEET_BERRIES, ModItems.SWEET_BERRY_PIE);
        offerPieRecipe(exporter, Items.GLOW_BERRIES, ModItems.GLOW_BERRY_PIE);
        offerPieRecipe(exporter, ModItems.BLUEBERRIES, ModItems.BLUEBERRY_PIE);
        offerPieRecipe(exporter, ModItems.CLOUDBERRIES, ModItems.CLOUDBERRY_PIE);
        offerPieRecipe(exporter, ModItems.GOJI_BERRIES, ModItems.GOJI_BERRY_PIE);
        offerPieRecipe(exporter, ModItems.REDCURRANTS, ModItems.REDCURRANT_PIE);
        offerPieRecipe(exporter, ModItems.BLACKCURRANTS, ModItems.BLACKCURRANT_PIE);
        offerPieRecipe(exporter, ModItems.GOOSEBERRIES, ModItems.GOOSEBERRY_PIE);
        offerPieRecipe(exporter, ModItems.CAPE_GOOSEBERRIES, ModItems.CAPE_GOOSEBERRY_PIE);

        // Juices
        offerJuiceRecipe(exporter, ModItems.SWEET_BERRIES_COOKED, ModItems.SWEET_BERRY_JUICE);
        offerJuiceRecipe(exporter, ModItems.GLOW_BERRIES_COOKED, ModItems.GLOW_BERRY_JUICE);
        offerJuiceRecipe(exporter, ModItems.BLUEBERRIES_COOKED, ModItems.BLUEBERRY_JUICE);
        offerJuiceRecipe(exporter, ModItems.CLOUDBERRIES_COOKED, ModItems.CLOUDBERRY_JUICE);
        offerJuiceRecipe(exporter, ModItems.GOJI_BERRIES_COOKED, ModItems.GOJI_BERRY_JUICE);
        offerJuiceRecipe(exporter, ModItems.REDCURRANTS_COOKED, ModItems.REDCURRANT_JUICE);
        offerJuiceRecipe(exporter, ModItems.BLACKCURRANTS_COOKED, ModItems.BLACKCURRANT_JUICE);
        offerJuiceRecipe(exporter, ModItems.GOOSEBERRIES_COOKED, ModItems.GOOSEBERRY_JUICE);
        offerJuiceRecipe(exporter, ModItems.CAPE_GOOSEBERRIES_COOKED, ModItems.CAPE_GOOSEBERRY_JUICE);

        // Jams
        offerJamRecipe(exporter, ModItems.SWEET_BERRIES_COOKED, ModItems.SWEET_BERRY_JAM);
        offerJamRecipe(exporter, ModItems.GLOW_BERRIES_COOKED, ModItems.GLOW_BERRY_JAM);
        offerJamRecipe(exporter, ModItems.BLUEBERRIES_COOKED, ModItems.BLUEBERRY_JAM);
        offerJamRecipe(exporter, ModItems.CLOUDBERRIES_COOKED, ModItems.CLOUDBERRY_JAM);
        offerJamRecipe(exporter, ModItems.GOJI_BERRIES_COOKED, ModItems.GOJI_BERRY_JAM);
        offerJamRecipe(exporter, ModItems.REDCURRANTS_COOKED, ModItems.REDCURRANT_JAM);
        offerJamRecipe(exporter, ModItems.BLACKCURRANTS_COOKED, ModItems.BLACKCURRANT_JAM);
        offerJamRecipe(exporter, ModItems.GOOSEBERRIES_COOKED, ModItems.GOOSEBERRY_JAM);
        offerJamRecipe(exporter, ModItems.CAPE_GOOSEBERRIES_COOKED, ModItems.CAPE_GOOSEBERRY_JAM);

        // Misc
        offerGlowItemFrameRecipe(exporter, ModItems.GLOW_DYE, Items.GLOW_ITEM_FRAME);
    }

    // Helper methods to create recipes
    public static void offerCookedBerryRecipes(RecipeExporter exporter, ItemConvertible input, ItemConvertible output) {
        offerFoodCookingRecipe(exporter, "smelting", RecipeSerializer.SMELTING, SmeltingRecipe::new, 200, input, output, 0.35F);
        offerFoodCookingRecipe(exporter, "campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new, 600, input, output, 0.35F);
        offerFoodCookingRecipe(exporter, "smoking", RecipeSerializer.SMOKING, SmokingRecipe::new, 100, input, output, 0.35F);
    }

    public static void offerCocoaCoveredRecipe(RecipeExporter exporter, ItemConvertible input, ItemConvertible output) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, output, 3)
                .input(input, 3)
                .input(Items.COCOA_BEANS)
                .group("cocoa_covered")
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }

    public static void offerHoneyDippedRecipe(RecipeExporter exporter, ItemConvertible input, ItemConvertible output) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, output, 3)
                .input(input, 3)
                .input(Items.HONEY_BOTTLE)
                .group("honey_dipped")
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }

    public static void offerGoldenRecipe(RecipeExporter exporter, ItemConvertible input, ItemConvertible output) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, output)
                .input('#', input)
                .input('G', Items.GOLD_NUGGET)
                .pattern("GGG")
                .pattern("G#G")
                .pattern("GGG")
                .group("golden")
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }

    public static void offerCakeRecipe(RecipeExporter exporter, ItemConvertible input, ItemConvertible output) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, output)
                .input('#', input)
                .input('M', Items.MILK_BUCKET)
                .input('W', Items.WHEAT)
                .input('E', Items.EGG)
                .pattern("MMM")
                .pattern("#E#")
                .pattern("WWW")
                .group("cake")
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }

    public static void offerCookieRecipe(RecipeExporter exporter, ItemConvertible input, ItemConvertible output) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, output, 8)
                .input('#', input)
                .input('W', Items.WHEAT)
                .pattern("W#W")
                .group("cookie")
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }

    public static void offerJamSandwichRecipe(RecipeExporter exporter, ItemConvertible input, ItemConvertible output) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, output)
                .input(input)
                .input(Items.BREAD)
                .group("jam_sandwich")
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }

    public static void offerMuffinRecipe(RecipeExporter exporter, ItemConvertible input, ItemConvertible output) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, output, 3)
                .input('#', input)
                .input('M', Items.MILK_BUCKET)
                .input('W', Items.WHEAT)
                .input('E', Items.EGG)
                .input('S', Items.SUGAR)
                .pattern("SMS")
                .pattern("#E#")
                .pattern("WWW")
                .group("muffin")
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }

    public static void offerPieRecipe(RecipeExporter exporter, ItemConvertible input, ItemConvertible output) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, output)
                .input(input)
                .input(Items.SUGAR)
                .input(Items.EGG)
                .group("pie")
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }

    public static void offerJuiceRecipe(RecipeExporter exporter, ItemConvertible input, ItemConvertible output) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, output)
                .input(input, 3)
                .input(Items.GLASS_BOTTLE)
                .group("juice")
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }

    public static void offerJamRecipe(RecipeExporter exporter, ItemConvertible input, ItemConvertible output) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, output)
                .input(input, 3)
                .input(Items.GLASS_BOTTLE)
                .input(Items.SUGAR, 2)
                .group("jam")
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }

    public static void offerGlowItemFrameRecipe(RecipeExporter exporter, ItemConvertible input, ItemConvertible output) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, output)
                .input(Items.ITEM_FRAME)
                .input(input)
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }
}
