package dev.timefall.alboemythicarmory.util.helper;

import dev.timefall.alboemythicarmory.registry.StatusEffectsRegistry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;

public class EntityEffectHelper {
    private static final int DEFAULT_MARK_DURATION = 40; // 2 seconds
    private static final int DEFAULT_STUN_DURATION = 20; // 1 second

    /**
     * Marks an entity with the Marked status effect
     * @param livingEntity The entity to mark
     * @param duration Duration in ticks (20 ticks = 1 second). If not specified, uses default duration.
     */
    public static void markEntity(LivingEntity livingEntity, int duration) {
        if (livingEntity != null && !livingEntity.getWorld().isClient()) {
            livingEntity.addStatusEffect(new StatusEffectInstance(
                    StatusEffectsRegistry.MARKED.value(),
                    duration > 0 ? duration : DEFAULT_MARK_DURATION,
                    0,
                    false,
                    true,
                    true
            ));
        }
    }

    /**
     * Stuns an entity that has the Marked status effect
     * @param livingEntity The entity to mark
     * @param duration Duration in ticks (20 ticks = 1 second). If not specified, uses default duration.
     */
    public static void stunEntity(LivingEntity livingEntity, int duration) {
        if (livingEntity != null && !livingEntity.getWorld().isClient()) {
            livingEntity.addStatusEffect(new StatusEffectInstance(
                    StatusEffectsRegistry.STUNNED.value(),
                    duration > 0 ? duration : DEFAULT_STUN_DURATION,
                    0,
                    false,
                    true,
                    true
            ));
        }
    }

    /**
     * Marks an entity for the default duration
     * @param livingEntity The entity to mark
     */
    public static void markEntity(LivingEntity livingEntity) {
        markEntity(livingEntity, DEFAULT_MARK_DURATION);
    }

    /**
     * Stuns an entity for the default duration
     * @param livingEntity The entity to mark
     */
    public static void stunEntity(LivingEntity livingEntity) {
        stunEntity(livingEntity, DEFAULT_STUN_DURATION);
    }

    /**
     * Checks if an entity is currently marked
     * @param livingEntity The entity to check
     * @return true if the entity has the marked status effect
     */
    public static boolean isEntityMarked(LivingEntity livingEntity) {
        return livingEntity != null && livingEntity.hasStatusEffect(StatusEffectsRegistry.MARKED.value());
    }

    /**
     * Checks if an entity is currently marked
     * @param livingEntity The entity to check
     * @return true if the entity has the marked status effect
     */
    public static boolean isEntityStunned(LivingEntity livingEntity) {
        return livingEntity != null && livingEntity.hasStatusEffect(StatusEffectsRegistry.STUNNED.value());
    }

    /**
     * Removes the marked status effect from an entity
     * @param livingEntity The entity to unmark
     */
    public static void unmarkEntity(LivingEntity livingEntity) {
        if (livingEntity != null) {
            livingEntity.removeStatusEffect(StatusEffectsRegistry.MARKED.value());
        }
    }
}
