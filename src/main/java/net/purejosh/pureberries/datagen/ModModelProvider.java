package net.purejosh.pureberries.datagen;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.purejosh.pureberries.block.*;
import net.purejosh.pureberries.item.ModItems;

import java.util.function.Supplier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        // Natural Blocks
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.BLUEBERRY_BUSH, BlockStateModelGenerator.TintType.NOT_TINTED, BlueberryBushBlock.AGE, 0, 1, 2, 3);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.CLOUDBERRY_PATCH, BlockStateModelGenerator.TintType.NOT_TINTED, CloudberryPatchBlock.AGE, 0, 1, 2, 3);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.GOJI_BERRY_SHRUB, BlockStateModelGenerator.TintType.NOT_TINTED, GojiBerryShrubBlock.AGE, 0, 1, 2, 3);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.REDCURRANT_SHRUB, BlockStateModelGenerator.TintType.NOT_TINTED, RedcurrantShrubBlock.AGE, 0, 1, 2, 3);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.BLACKCURRANT_SHRUB, BlockStateModelGenerator.TintType.NOT_TINTED, BlackcurrantShrubBlock.AGE, 0, 1, 2, 3);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.GOOSEBERRY_SHRUB, BlockStateModelGenerator.TintType.NOT_TINTED, GooseberryShrubBlock.AGE, 0, 1, 2, 3);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.CAPE_GOOSEBERRY_SHRUB, BlockStateModelGenerator.TintType.NOT_TINTED, CapeGooseberryShrubBlock.AGE, 0, 1, 2, 3);

        // Cakes
        registerCake(blockStateModelGenerator, ModBlocks.SWEET_BERRY_CAKE, ModItems.SWEET_BERRY_CAKE, "pureberries:block/sweet_berry_cake");
        registerCake(blockStateModelGenerator, ModBlocks.GLOW_BERRY_CAKE, ModItems.GLOW_BERRY_CAKE, "pureberries:block/glow_berry_cake");
        registerCake(blockStateModelGenerator, ModBlocks.BLUEBERRY_CAKE, ModItems.BLUEBERRY_CAKE, "pureberries:block/blueberry_cake");
        registerCake(blockStateModelGenerator, ModBlocks.CLOUDBERRY_CAKE, ModItems.CLOUDBERRY_CAKE, "pureberries:block/cloudberry_cake");
        registerCake(blockStateModelGenerator, ModBlocks.GOJI_BERRY_CAKE, ModItems.GOJI_BERRY_CAKE, "pureberries:block/goji_berry_cake");
        registerCake(blockStateModelGenerator, ModBlocks.REDCURRANT_CAKE, ModItems.REDCURRANT_CAKE, "pureberries:block/redcurrant_cake");
        registerCake(blockStateModelGenerator, ModBlocks.BLACKCURRANT_CAKE, ModItems.BLACKCURRANT_CAKE, "pureberries:block/blackcurrant_cake");
        registerCake(blockStateModelGenerator, ModBlocks.GOOSEBERRY_CAKE, ModItems.GOOSEBERRY_CAKE, "pureberries:block/gooseberry_cake");
        registerCake(blockStateModelGenerator, ModBlocks.CAPE_GOOSEBERRY_CAKE, ModItems.CAPE_GOOSEBERRY_CAKE, "pureberries:block/cape_gooseberry_cake");

        // Functional Blocks
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.ANDESITE_MORTAR);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BASALT_MORTAR);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BLACKSTONE_MORTAR);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.CALCITE_MORTAR);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.DEEPSLATE_MORTAR);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.DIAMOND_MORTAR);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.NETHER_BRICK_MORTAR);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.NETHERITE_MORTAR);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.QUARTZ_MORTAR);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.SANDSTONE_MORTAR);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.SMOOTH_STONE_MORTAR);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.STONE_MORTAR);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TUFF_MORTAR);
    }

    // Create new cake models, because mojang doesn't have a nice way to do this
    public void registerCake(BlockStateModelGenerator blockStateModelGenerator, Block cakeBlock, Item cakeItem, String texturePrefix) {
        // Register item model for the cake
        blockStateModelGenerator.registerItemModel(cakeItem);

        // Register blockstate mapping (bite stages), this does not create the model
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(cakeBlock).coordinate(
                BlockStateVariantMap.create(Properties.BITES)
                        .register(0, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockModelId(cakeBlock)))
                        .register(1, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(cakeBlock, "_slice1")))
                        .register(2, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(cakeBlock, "_slice2")))
                        .register(3, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(cakeBlock, "_slice3")))
                        .register(4, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(cakeBlock, "_slice4")))
                        .register(5, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(cakeBlock, "_slice5")))
                        .register(6, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(cakeBlock, "_slice6")))
        ));

        // Generate full cake model
        Identifier fullCakeModelId = ModelIds.getBlockModelId(cakeBlock);
        blockStateModelGenerator.modelCollector.accept(fullCakeModelId, createCakeModel(texturePrefix));

        // Generate sliced models for bite stages 1-6
        for (int i = 1; i <= 6; i++) {
            Identifier sliceModelId = ModelIds.getBlockSubModelId(cakeBlock, "_slice" + i);
            blockStateModelGenerator.modelCollector.accept(sliceModelId, createCakeSliceModel(texturePrefix, i));
        }
    }

    // Helper method to create the full cake model
    private Supplier<JsonElement> createCakeModel(String baseTexture) {
        return () -> {
            JsonObject json = new JsonObject();
            json.addProperty("parent", "minecraft:block/cake");

            JsonObject textures = new JsonObject();
            textures.addProperty("particle", "minecraft:block/cake_side");  // Vanilla particle texture
            textures.addProperty("bottom", "minecraft:block/cake_bottom");  // Vanilla bottom texture
            textures.addProperty("top", baseTexture + "_top");              // Custom top texture
            textures.addProperty("side", "minecraft:block/cake_side");      // Vanilla side texture

            json.add("textures", textures);
            return json;
        };
    }

    // Helper method to create sliced models for bite stages 1-6
    private Supplier<JsonElement> createCakeSliceModel(String baseTexture, int sliceNumber) {
        return () -> {
            JsonObject json = new JsonObject();
            json.addProperty("parent", "minecraft:block/cake_slice" + sliceNumber); // Use vanilla slice model

            JsonObject textures = new JsonObject();
            textures.addProperty("particle", "minecraft:block/cake_side");  // Vanilla particle texture
            textures.addProperty("bottom", "minecraft:block/cake_bottom");  // Vanilla bottom texture
            textures.addProperty("top", baseTexture + "_top");              // Custom top texture
            textures.addProperty("side", "minecraft:block/cake_side");      // Vanilla side texture
            textures.addProperty("inside", "minecraft:block/cake_inner");   // Vanilla inside texture

            json.add("textures", textures);
            return json;
        };
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // Food & Drinks
        // Cooked
        itemModelGenerator.register(ModItems.SWEET_BERRIES_COOKED, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLOW_BERRIES_COOKED, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLUEBERRIES_COOKED, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLOUDBERRIES_COOKED, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOJI_BERRIES_COOKED, Models.GENERATED);
        itemModelGenerator.register(ModItems.REDCURRANTS_COOKED, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLACKCURRANTS_COOKED, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOOSEBERRIES_COOKED, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAPE_GOOSEBERRIES_COOKED, Models.GENERATED);

        // Cocoa Covered
        itemModelGenerator.register(ModItems.SWEET_BERRIES_COCOA_COVERED, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLOW_BERRIES_COCOA_COVERED, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLUEBERRIES_COCOA_COVERED, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLOUDBERRIES_COCOA_COVERED, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOJI_BERRIES_COCOA_COVERED, Models.GENERATED);
        itemModelGenerator.register(ModItems.REDCURRANTS_COCOA_COVERED, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLACKCURRANTS_COCOA_COVERED, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOOSEBERRIES_COCOA_COVERED, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAPE_GOOSEBERRIES_COCOA_COVERED, Models.GENERATED);

        // Honey Dipped
        itemModelGenerator.register(ModItems.SWEET_BERRIES_HONEY_DIPPED, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLOW_BERRIES_HONEY_DIPPED, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLUEBERRIES_HONEY_DIPPED, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLOUDBERRIES_HONEY_DIPPED, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOJI_BERRIES_HONEY_DIPPED, Models.GENERATED);
        itemModelGenerator.register(ModItems.REDCURRANTS_HONEY_DIPPED, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLACKCURRANTS_HONEY_DIPPED, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOOSEBERRIES_HONEY_DIPPED, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAPE_GOOSEBERRIES_HONEY_DIPPED, Models.GENERATED);

        // Golden
        itemModelGenerator.register(ModItems.SWEET_BERRIES_GOLDEN, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLOW_BERRIES_GOLDEN, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLUEBERRIES_GOLDEN, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLOUDBERRIES_GOLDEN, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOJI_BERRIES_GOLDEN, Models.GENERATED);
        itemModelGenerator.register(ModItems.REDCURRANTS_GOLDEN, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLACKCURRANTS_GOLDEN, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOOSEBERRIES_GOLDEN, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAPE_GOOSEBERRIES_GOLDEN, Models.GENERATED);

        // Cookies
        itemModelGenerator.register(ModItems.SWEET_BERRY_COOKIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLOW_BERRY_COOKIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLUEBERRY_COOKIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLOUDBERRY_COOKIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOJI_BERRY_COOKIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.REDCURRANT_COOKIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLACKCURRANT_COOKIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOOSEBERRY_COOKIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAPE_GOOSEBERRY_COOKIE, Models.GENERATED);

        // Muffins
        itemModelGenerator.register(ModItems.SWEET_BERRY_MUFFIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLOW_BERRY_MUFFIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLUEBERRY_MUFFIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLOUDBERRY_MUFFIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOJI_BERRY_MUFFIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.REDCURRANT_MUFFIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLACKCURRANT_MUFFIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOOSEBERRY_MUFFIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAPE_GOOSEBERRY_MUFFIN, Models.GENERATED);

        // Pies
        itemModelGenerator.register(ModItems.SWEET_BERRY_PIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLOW_BERRY_PIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLUEBERRY_PIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLOUDBERRY_PIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOJI_BERRY_PIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.REDCURRANT_PIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLACKCURRANT_PIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOOSEBERRY_PIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAPE_GOOSEBERRY_PIE, Models.GENERATED);

        // Juices
        itemModelGenerator.register(ModItems.SWEET_BERRY_JUICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLOW_BERRY_JUICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLUEBERRY_JUICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLOUDBERRY_JUICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOJI_BERRY_JUICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.REDCURRANT_JUICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLACKCURRANT_JUICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOOSEBERRY_JUICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAPE_GOOSEBERRY_JUICE, Models.GENERATED);

        // Jams
        itemModelGenerator.register(ModItems.SWEET_BERRY_JAM, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLOW_BERRY_JAM, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLUEBERRY_JAM, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLOUDBERRY_JAM, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOJI_BERRY_JAM, Models.GENERATED);
        itemModelGenerator.register(ModItems.REDCURRANT_JAM, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLACKCURRANT_JAM, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOOSEBERRY_JAM, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAPE_GOOSEBERRY_JAM, Models.GENERATED);

        // Jam Sandwiches
        itemModelGenerator.register(ModItems.SWEET_BERRY_JAM_SANDWICH, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLOW_BERRY_JAM_SANDWICH, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLUEBERRY_JAM_SANDWICH, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLOUDBERRY_JAM_SANDWICH, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOJI_BERRY_JAM_SANDWICH, Models.GENERATED);
        itemModelGenerator.register(ModItems.REDCURRANT_JAM_SANDWICH, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLACKCURRANT_JAM_SANDWICH, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOOSEBERRY_JAM_SANDWICH, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAPE_GOOSEBERRY_JAM_SANDWICH, Models.GENERATED);

        // Misc
        itemModelGenerator.register(ModItems.GLOW_DYE, Models.GENERATED);

    }
}
