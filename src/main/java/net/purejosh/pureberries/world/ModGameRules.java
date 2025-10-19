package net.purejosh.pureberries.world;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;

public class ModGameRules {

    // Configuration, set to 0 to disable.
    public static final GameRules.Key<GameRules.IntRule> DETOXIFY_STRENGTH = GameRuleRegistry.register("pureBerriesDetoxifyStrength",
            GameRules.Category.PLAYER, GameRuleFactory.createIntRule(5)); // 5% base reduction per level
    public static final GameRules.Key<GameRules.IntRule> LUMINANCE_RADIUS = GameRuleRegistry.register("pureBerriesLuminanceRadius",
            GameRules.Category.PLAYER, GameRuleFactory.createIntRule(24)); // 24 blocks per level
    public static final GameRules.Key<GameRules.IntRule> NIMBUS_STRENGTH = GameRuleRegistry.register("pureBerriesNimbusStrength",
            GameRules.Category.PLAYER, GameRuleFactory.createIntRule(100)); // Final modification against gravity, effectFall, fallDamage, and fallSafeDistance.
    public static final GameRules.Key<GameRules.IntRule> SUSTENANCE_STRENGTH = GameRuleRegistry.register("pureBerriesSustenanceStrength",
            GameRules.Category.PLAYER, GameRuleFactory.createIntRule(15)); // 0.15f exhaustion restoration per level
    public static final GameRules.Key<GameRules.IntRule> VITALITY_STRENGTH = GameRuleRegistry.register("pureBerriesVitalityStrength",
            GameRules.Category.PLAYER, GameRuleFactory.createIntRule(100)); // Modification of frequency of vitality regeneration

    // Boolean rules
    public static final GameRules.Key<GameRules.BooleanRule> MORTAR_DURABILITY = GameRuleRegistry.register("pureBerriesMortarDurability",
            GameRules.Category.PLAYER, GameRuleFactory.createBooleanRule(true));

    public static void init() {
    }
}
