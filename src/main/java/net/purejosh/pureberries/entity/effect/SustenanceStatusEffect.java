package net.purejosh.pureberries.entity.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.purejosh.pureberries.world.ModGameRules;

public class SustenanceStatusEffect extends StatusEffect {

    public SustenanceStatusEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity e, int amp) {
        // Early exit if not ServerPlayerEntity or ServerWorld.
        if (!(e instanceof ServerPlayerEntity p) || !(e.getWorld() instanceof ServerWorld world)) return true;

        // Retrieve sustenanceStrength, convert to float.
        float sustenanceStrength = world.getGameRules().getInt(ModGameRules.SUSTENANCE_STRENGTH) / 100.0f;

        // Exit early if the player has too little exhaustion.
        float exhaustionRegen = sustenanceStrength * (amp + 1);
        if (p.getHungerManager().getExhaustion() <= exhaustionRegen) {
            return true;
        }

        p.addExhaustion(-exhaustionRegen);
        world.spawnParticles(ParticleTypes.COMPOSTER, p.getX(), p.getY() + 0.5, p.getZ(),
                5, 0.3, 0.3, 0.3, 0.1);

        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration % 20 == 0; // Apply effect once every second (every 20 ticks)
    }
}
