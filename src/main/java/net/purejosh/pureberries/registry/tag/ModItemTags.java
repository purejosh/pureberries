package net.purejosh.pureberries.registry.tag;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.purejosh.pureberries.PureBerries;

public class ModItemTags {
    public static final TagKey<Item> BERRIES = of("berries");

    private static TagKey<Item> of(String id) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(PureBerries.MOD_ID, id));
    }
}
