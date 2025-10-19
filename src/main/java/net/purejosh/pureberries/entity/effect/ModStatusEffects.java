package net.purejosh.pureberries.entity.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.purejosh.pureberries.PureBerries;

public class ModStatusEffects {

    public static final RegistryEntry<StatusEffect> DETOXIFY = register("detoxify", new DetoxifyStatusEffect(StatusEffectCategory.BENEFICIAL, 0x66CC66));
    public static final RegistryEntry<StatusEffect> LUMINANCE = register("luminance", new LuminanceStatusEffect(StatusEffectCategory.BENEFICIAL, 0xFFFF55));
    public static final RegistryEntry<StatusEffect> NIMBUS = register("nimbus", new NimbusStatusEffect(StatusEffectCategory.BENEFICIAL, 0xE6E6E6));
    public static final RegistryEntry<StatusEffect> SUSTENANCE = register("sustenance", new SustenanceStatusEffect(StatusEffectCategory.BENEFICIAL, 0xFFA500));
    public static final RegistryEntry<StatusEffect> VITALITY = register("vitality", new VitalityStatusEffect(StatusEffectCategory.BENEFICIAL, 0xFF5555));

    public ModStatusEffects() {
    }

    private static RegistryEntry<StatusEffect> register(String id, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(PureBerries.MOD_ID, id), statusEffect);
    }

    public static void init() {
    }
}
