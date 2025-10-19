package net.purejosh.pureberries.entity.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Box;
import net.purejosh.pureberries.world.ModGameRules;

import java.util.List;

public class LuminanceStatusEffect extends StatusEffect {

    public LuminanceStatusEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity e, int amp) {
        // Early exit if not ServerPlayerEntity or ServerWorld.
        if (!(e instanceof ServerPlayerEntity p) || !(e.getWorld() instanceof ServerWorld world)) return true;

        // Retrieve luminanceRadius, store as int.
        int luminanceRadius = world.getGameRules().getInt(ModGameRules.LUMINANCE_RADIUS) * (amp + 1);

        // Expand bounding box based on calculated radius and retrieve nearby living entities, excluding the player.
        Box searchBox = p.getBoundingBox().expand(luminanceRadius);
        List<LivingEntity> nearbyEntities = world.getEntitiesByClass(LivingEntity.class, searchBox, other -> other != p);

        // Apply the glowing effect to all nearby entities
        for (LivingEntity target : nearbyEntities) {
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 11, amp, false, false));
        }

        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration % 10 == 0; // Apply effect twice every second
    }
}
