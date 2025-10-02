package dev.timefall.alboemythicarmory.util;

import net.minecraft.entity.LivingEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AttackDamageStorage {
    private static final Map<UUID, Float> storedDamage = new HashMap<>();
    private static final Map<UUID, Float> lastStoredAmount = new HashMap<>();
    private static final Map<UUID, Boolean> isFirstAttack = new HashMap<>();
    private static final Map<UUID, Long> lastAttackTime = new HashMap<>();

    public static void storeDamage(LivingEntity player, float damage) {
        UUID uuid = player.getUuid();
        float stored = damage * 0.25f;
        storedDamage.put(player.getUuid(), stored);
        lastStoredAmount.put(player.getUuid(), stored);
        isFirstAttack.put(player.getUuid(), false);
        lastAttackTime.put(uuid, player.getWorld().getTime()); // Store current world time

    }
    
    public static boolean isFirstAttack(LivingEntity player) {
        return isFirstAttack.getOrDefault(player.getUuid(), true);
    }
    
    public static float getLastStoredAmount(LivingEntity player) {
        return lastStoredAmount.getOrDefault(player.getUuid(), 0f);
    }

    public static void checkAndClearExpired(LivingEntity player) {
        UUID uuid = player.getUuid();
        if (lastAttackTime.containsKey(uuid)) {
            long currentTime = player.getWorld().getTime();
            if (currentTime - lastAttackTime.get(uuid) > CleanlinessHelper.alboe_mystic_armory$calculateTicksFromSeconds(3)) {
                clearStoredDamage(player);
            }
        }
    }

    public static void clearStoredDamage(LivingEntity player) {
        UUID uuid = player.getUuid();
        storedDamage.remove(uuid);
        lastStoredAmount.remove(uuid);
        isFirstAttack.remove(uuid);
        lastAttackTime.remove(uuid);
    }
}
