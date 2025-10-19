package net.purejosh.pureberries.item;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;

public class MortarBlockItem extends BlockItem {
    private final Ingredient repairIngredient;

    public MortarBlockItem(Block block, Settings settings, Item repairMaterial) {
        super(block, settings);
        this.repairIngredient = Ingredient.ofItems(repairMaterial);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return repairIngredient.test(ingredient) || super.canRepair(stack, ingredient);
    }
}
