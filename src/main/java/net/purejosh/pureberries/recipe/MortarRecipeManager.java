package net.purejosh.pureberries.recipe;

import com.google.gson.JsonParser;
import com.mojang.serialization.JsonOps;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;
import net.purejosh.pureberries.PureBerries;

import java.io.BufferedReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class MortarRecipeManager implements SimpleSynchronousResourceReloadListener {
    private static final Map<Identifier, Supplier<List<ItemStack>>> RECIPES = new HashMap<>();

    private MortarRecipeManager() {}

    @Override
    public Identifier getFabricId() {
        return Identifier.of(PureBerries.MOD_ID, "mortar_recipes");
    }

    @Override
    public void reload(ResourceManager manager) {
        RECIPES.clear();
        manager.findResources("mortar_recipes", path -> path.getPath().endsWith(".json"))
                .forEach((resId, resource) -> {
                    try (BufferedReader reader = resource.getReader()) {
                        MortarRecipe recipe = MortarRecipe.CODEC
                                .parse(JsonOps.INSTANCE, JsonParser.parseReader(reader))
                                .resultOrPartial(err ->
                                        PureBerries.LOGGER.error("Failed parsing {}: {}", resId, err)
                                ).orElseThrow();

                        RECIPES.put(recipe.input(),
                                () -> recipe.outputs().stream()
                                        .map(MortarRecipe.Output::toStack)
                                        .toList()
                        );
                    } catch (Exception e) {
                        PureBerries.LOGGER.error("Error loading {}:", resId, e);
                    }
                });
    }

    public static List<ItemStack> getOutputsFor(Item input) {
        Identifier id = net.minecraft.registry.Registries.ITEM.getId(input);
        return RECIPES.getOrDefault(id, Collections::<ItemStack>emptyList).get();
    }

    public static void init() {
        ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(new MortarRecipeManager());
    }
}
