package net.purejosh.pureberries.entity.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.purejosh.pureberries.world.ModGameRules;

public class VitalityStatusEffect extends StatusEffect {

    // Variable to store vitalityStrength, which is updated in the next tick.
    private int vitalityStrength = 100;

    public VitalityStatusEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity e, int amp) {
        // Early exit if not ServerPlayerEntity or ServerWorld.
        if (!(e instanceof ServerPlayerEntity p) || !(e.getWorld() instanceof ServerWorld world)) return true;

        // Update the previously stored vitalityStrength variable. This is to be used in canApplyUpdateEffect().
        vitalityStrength = world.getGameRules().getInt(ModGameRules.VITALITY_STRENGTH);

        // Heal only if player is not at max health
        if (p.getHealth() < p.getMaxHealth()) {
            p.heal(1.0f);
        }

        return true;
    }

    // Effect applies with default frequency via vitalityStrength, but frequency is updated the next tick.
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int interval = (int) ((120 - (amplifier * 20)) * (100.0 / vitalityStrength));
        return duration % interval == 0;
    }
}
