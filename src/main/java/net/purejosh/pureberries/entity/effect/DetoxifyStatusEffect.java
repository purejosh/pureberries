package net.purejosh.pureberries.entity.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.purejosh.pureberries.world.ModGameRules;

import java.util.List;

public class DetoxifyStatusEffect extends StatusEffect {

    public DetoxifyStatusEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity e, int amp) {
        if (!(e instanceof ServerPlayerEntity p) || !(e.getWorld() instanceof ServerWorld world)) {
            return true;
        }

        int reduction = world.getGameRules().getInt(ModGameRules.DETOXIFY_STRENGTH) * (amp + 1);

        // snapshot the list
        List<StatusEffectInstance> snapshot = List.copyOf(p.getStatusEffects());

        for (StatusEffectInstance inst : snapshot) {
            if (!inst.getEffectType().value().isBeneficial()) {
                int shortened = Math.max(1, inst.getDuration() * (100 - reduction) / 100);

                // reapply
                p.removeStatusEffect(inst.getEffectType());
                p.addStatusEffect(new StatusEffectInstance(
                        inst.getEffectType(),
                        shortened,
                        inst.getAmplifier(),
                        inst.isAmbient(),
                        inst.shouldShowParticles(),
                        inst.shouldShowIcon()
                ));
            }
        }
        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration % 100 == 0; // Triggers every 5 seconds
    }
}
