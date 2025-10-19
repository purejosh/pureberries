package net.purejosh.pureberries.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.List;

public record MortarRecipe(Identifier input, List<Output> outputs) {
    public static final Codec<MortarRecipe> CODEC = RecordCodecBuilder.create(inst ->
            inst.group(
                    Identifier.CODEC
                            .fieldOf("input").forGetter(MortarRecipe::input),
                    Output.CODEC.listOf()
                            .fieldOf("outputs").forGetter(MortarRecipe::outputs)
            ).apply(inst, MortarRecipe::new)
    );

    public record Output(Item item, int count) {
        public static final Codec<Output> CODEC = RecordCodecBuilder.create(inst ->
                inst.group(
                        // read/write an Item via its Identifier
                        Identifier.CODEC
                                .xmap(Registries.ITEM::get, Registries.ITEM::getId)
                                .fieldOf("item").forGetter(o -> o.item),

                        // if count is missing in the .json, default to 1
                        Codec.INT
                                .optionalFieldOf("count", 1)
                                .forGetter(o -> o.count)
                ).apply(inst, Output::new)
        );

        public ItemStack toStack() {
            return new ItemStack(item, count);
        }
    }
}
