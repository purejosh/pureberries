package net.purejosh.pureberries.entity.effect;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import net.purejosh.pureberries.PureBerries;
import net.purejosh.pureberries.sound.ModSoundEvents;
import net.purejosh.pureberries.world.ModGameRules;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import static net.purejosh.pureberries.PureBerries.LOGGER;
import static net.purejosh.pureberries.PureBerries.devLogging;

public class NimbusStatusEffect extends StatusEffect {

    // HashMap to track UUIDs of players' final particle spawn
    public static final Set<UUID> NIMBUS_FINAL_PARTICLE = ConcurrentHashMap.newKeySet();

    // Local identifiers for the attribute modifiers.
    private static final Identifier
        GRAVITY_ID = PureBerries.id("nimbus_gravity"),
        SAFE_FALL_ID = PureBerries.id("nimbus_safe_fall"),
        FALL_DMG_ID = PureBerries.id("nimbus_fall_damage");

    public NimbusStatusEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void onApplied(LivingEntity e, int amp) {
        // Early exit if not ServerPlayerEntity or ServerWorld.
        if (!(e instanceof ServerPlayerEntity p) || !(e.getWorld() instanceof ServerWorld world)) return;

        // Get the strength of the Nimbus effect.
        float nimbusStrength = world.getGameRules().getInt(ModGameRules.NIMBUS_STRENGTH) / 100f;

        // If effect disabled, early exit.
        if (nimbusStrength == 0) return;

        // Add attribute modifiers
        safeAddModifier(p.getAttributeInstance(EntityAttributes.GENERIC_GRAVITY), GRAVITY_ID,
                Math.max(-0.065 * nimbusStrength, -0.07), EntityAttributeModifier.Operation.ADD_VALUE);
        safeAddModifier(p.getAttributeInstance(EntityAttributes.GENERIC_SAFE_FALL_DISTANCE), SAFE_FALL_ID,
                ((3 * (amp + 1)) + 3) * nimbusStrength, EntityAttributeModifier.Operation.ADD_VALUE);
        safeAddModifier(p.getAttributeInstance(EntityAttributes.GENERIC_FALL_DAMAGE_MULTIPLIER), FALL_DMG_ID,
                Math.max((-0.1 * (amp + 1)) * nimbusStrength, -0.8), EntityAttributeModifier.Operation.ADD_VALUE);
    }

    @Override
    public void onEntityRemoval(LivingEntity e, int amp, Entity.RemovalReason r) {
        NIMBUS_FINAL_PARTICLE.remove(e.getUuid());
        safeRemoveModifier(e.getAttributeInstance(EntityAttributes.GENERIC_GRAVITY), GRAVITY_ID);
        safeRemoveModifier(e.getAttributeInstance(EntityAttributes.GENERIC_SAFE_FALL_DISTANCE), SAFE_FALL_ID);
        safeRemoveModifier(e.getAttributeInstance(EntityAttributes.GENERIC_FALL_DAMAGE_MULTIPLIER), FALL_DMG_ID);
        super.onEntityRemoval(e, amp, r);
    }

    @Override
    public void onRemoved(AttributeContainer attribute) {
        safeRemoveModifier(attribute.getCustomInstance(EntityAttributes.GENERIC_GRAVITY), GRAVITY_ID);
        safeRemoveModifier(attribute.getCustomInstance(EntityAttributes.GENERIC_SAFE_FALL_DISTANCE), SAFE_FALL_ID);
        safeRemoveModifier(attribute.getCustomInstance(EntityAttributes.GENERIC_FALL_DAMAGE_MULTIPLIER), FALL_DMG_ID);
        super.onRemoved(attribute);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity e, int amp) {
        // Early exit if not ServerWorld
        if (!(e instanceof ServerPlayerEntity p) || !(e.getWorld() instanceof ServerWorld world)) return true;

        // Check if we need to re-add the modifiers. Unfortunate as it may be, due to how the attribute modifiers are applied,
        // they'll be removed on logout and not re-added on login. This checks if Nimbus is active, but missing the modifiers.
        var sfInst = p.getAttributeInstance(EntityAttributes.GENERIC_SAFE_FALL_DISTANCE);
        var fdInst = p.getAttributeInstance(EntityAttributes.GENERIC_FALL_DAMAGE_MULTIPLIER);
        boolean missingSF = (sfInst == null || sfInst.getModifier(SAFE_FALL_ID) == null);
        boolean missingFD = (fdInst == null || fdInst.getModifier(FALL_DMG_ID)  == null);

        // If Nimbus is active and the modifiers are missing, re-add them.
        if (p.hasStatusEffect(ModStatusEffects.NIMBUS) && (missingSF || missingFD)) {
            onApplied(e, amp);
        }

        EntityAttributeInstance grav = p.getAttributeInstance(EntityAttributes.GENERIC_GRAVITY);
        boolean hasGrav = grav != null && grav.getModifier(GRAVITY_ID) != null;

        // Player is elytra or creative flying, remove gravity modifier.
        if (p.getAbilities().flying || p.isFallFlying()) {
            if (hasGrav) {
                safeRemoveModifier(grav, GRAVITY_ID);
                devLogging(e, "Flying: removed gravity modifier");
            }
            return true;
        }

        UUID id = p.getUuid();
        boolean flagged = NIMBUS_FINAL_PARTICLE.contains(id);
        double effectFall = p.getAttributeValue(EntityAttributes.GENERIC_SAFE_FALL_DISTANCE) - 3;
        double fall = e.fallDistance;

        // Player on ground, check and remove gravity attribute and clear particle flag, if present.
        if (p.isOnGround()) {
            if (hasGrav) {
                safeRemoveModifier(grav, GRAVITY_ID);
                devLogging(e, "Landed: removed gravity modifier");
            }
            if (flagged) {
                NIMBUS_FINAL_PARTICLE.remove(id);
                devLogging(e, "Landed: cleared end-particle flag");
            }
            return true;
        }

        // Player in the air, and exceeding the effectFall threshold.
        // effectFall is the distance in blocks that the Nimbus effect cushions the player's descent. Damage occurs after exceeding this threshold by 3 blocks.
        if (fall >= effectFall) {
            if (hasGrav) {
                safeRemoveModifier(grav, GRAVITY_ID);
                devLogging(e, String.format("Threshold crossed (%.2f >= %.2f): removed gravity", fall, effectFall));
            }
            if (!flagged) {
                NIMBUS_FINAL_PARTICLE.add(id);
                nimbusEffectEndingParticle(e, world);
                devLogging(e, String.format("Threshold crossed (%.2f >= %.2f): spawned end particle", fall, effectFall));
            }
            return true;
        }

        // Player in the air, but not yet exceeding effectFall range, apply gravity once & spawn falling particles continuously.
        if (!hasGrav) {
            float str = world.getServer().getGameRules().getInt(ModGameRules.NIMBUS_STRENGTH) / 100f;
            safeAddModifier(grav, GRAVITY_ID,
                    Math.max(-0.065 * str, -0.07), EntityAttributeModifier.Operation.ADD_VALUE);
            devLogging(e, "Nimbus floating: gravity applied");
        }
        nimbusEffectParticles(e, world);
        devLogging(e, String.format("Nimbus floating: %.2f blocks fallen", fall));
        return true;
    }

    // Private helper methods -------------------------------------------------------------------------------------

    private static void nimbusEffectParticles(LivingEntity entity, ServerWorld serverWorld) {
        // Called while the player is falling, but not exceeding effectFall. Spawns particles and plays sound.
        // Using serverWorld.spawnParticles() to notify clients nearby via sendToPlayerIfNearby.
        for (int i = 0; i < 3; i++) {
            double offsetX = (entity.getRandom().nextDouble() - 0.5) * (entity.getWidth() * 1.2);
            double offsetZ = (entity.getRandom().nextDouble() - 0.5) * (entity.getWidth() * 1.2);
            serverWorld.spawnParticles(ParticleTypes.SMALL_GUST,
                    entity.getX() + offsetX, entity.getY() - 0.8, entity.getZ() + offsetZ,
                    1, 0, 0.1, 0, 10);
        }
        if (serverWorld.getTime() % 8 == 0) {
            float pitch = 1.8F + entity.getRandom().nextFloat() * 0.2F;
            for (int i = 0; i < 3; i++) {
                serverWorld.playSound(null, entity.getX(), entity.getY(), entity.getZ(),
                        ModSoundEvents.NIMBUS_WHIRL, SoundCategory.PLAYERS, 1F, pitch, 1);
            }
        }

    }

    // Called when the player exceeds the effectFall threshold.
    private static void nimbusEffectEndingParticle(LivingEntity entity, ServerWorld serverWorld) {
        serverWorld.spawnParticles(ParticleTypes.GUST, entity.getX(), entity.getY() - 1, entity.getZ(),
                1, 0, 0, 0, 0);
        serverWorld.playSound(null, entity.getX(), entity.getY(), entity.getZ(),
                ModSoundEvents.NIMBUS_END, SoundCategory.PLAYERS, 0.2F, 1.6F + entity.getRandom().nextFloat() * 0.2F, 1);
    }

    // Utility method to safely add a temporary modifier.
    private static void safeAddModifier(EntityAttributeInstance attribute, Identifier id, double value, EntityAttributeModifier.Operation operation) {
        // Check for a null attribute instance, which is unexpected, as attributes such as GENERIC_GRAVITY are always present.
        if (attribute == null) {
            LOGGER.error("[NimbusStatusEffect] safeAddModifier: Attribute instance is null for modifier {}. This is unexpected. If this caused a crash, please notify the developer with full logs.", id);
            return;
        }

        // Check if the modifier is already applied, which (if I did my code correctly) it shouldn't be.
        EntityAttributeModifier existing = attribute.getModifier(id);
        if (existing != null) {
            LOGGER.error("[NimbusStatusEffect] safeAddModifier: Modifier {} is already applied on attribute {}. This is unexpected. If this caused a crash, please notify the developer with full logs.", id, attribute.getAttribute().getIdAsString());
            return;
        }

        // Try to add the modifier. If we're this far and get an exception, something is very broken.
        try {
            attribute.addTemporaryModifier(new EntityAttributeModifier(id, value, operation));
        } catch (RuntimeException e) {
            LOGGER.error("[NimbusStatusEffect] safeAddModifier: Exception while adding modifier {} (value: {}, operation: {}) to attribute {}. This is unexpected. If this caused a crash, please notify the developer with full logs.", id, value, operation, attribute.getAttribute().getIdAsString(), e);
        }
    }

    // Utility method to safely remove a modifier.
    private static void safeRemoveModifier(EntityAttributeInstance attribute, Identifier id) {
        // Check for a null attribute instance, which is unexpected, as attributes such as GENERIC_GRAVITY are always present.
        if (attribute == null) {
            LOGGER.error("[NimbusStatusEffect] safeRemoveModifier: Attribute instance is null for modifier {}. This is unexpected. If this caused a crash, please notify the developer with full logs.", id);
            return;
        }

        // Check if the modifier is still present, which (if I did my code correctly) it should be.
        if (attribute.getModifier(id) == null) {
            return;
        }

        // Try to remove the modifier. If we're this far and get an exception, something is very broken.
        try {
            attribute.removeModifier(id);
        } catch (RuntimeException e) {
            LOGGER.error("[NimbusStatusEffect] safeRemoveModifier: Exception while removing modifier {} from attribute {}. If this caused a crash, please notify the developer with full logs.", id, attribute.getAttribute().getIdAsString(), e);
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
