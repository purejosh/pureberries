package net.purejosh.pureberries.component.type;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {

    public static final FoodComponent COOKED = new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build();
    public static final FoodComponent COVERED_DIPPED = new FoodComponent.Builder().nutrition(5).saturationModifier(0.6f).build();
    public static final FoodComponent GOLDEN = new FoodComponent.Builder().nutrition(4).saturationModifier(1.2f).alwaysEdible().build();
    public static final FoodComponent MUFFIN = new FoodComponent.Builder().nutrition(6).saturationModifier(0.3f).build();
    public static final FoodComponent JUICE = new FoodComponent.Builder().nutrition(6).saturationModifier(0.5f).build();
    public static final FoodComponent JAM = new FoodComponent.Builder().nutrition(6).saturationModifier(0.65f).build();
    public static final FoodComponent JAM_SANDWICH = new FoodComponent.Builder().nutrition(9).saturationModifier(0.8f).build();
}
