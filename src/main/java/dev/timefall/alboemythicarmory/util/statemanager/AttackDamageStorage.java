package dev.timefall.alboemythicarmory.util.statemanager;

import dev.timefall.alboemythicarmory.util.helper.CleanlinessHelper;
import net.minecraft.entity.LivingEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AttackDamageStorage {
    private static final Map<UUID, Float> LAST_STORED_AMOUNT = new HashMap<>();
    private static final Map<UUID, Boolean> IS_FIRST_ATTACK = new HashMap<>();
    private static final Map<UUID, Long> LAST_ATTACK_TIME = new HashMap<>();

    public static void storeDamage(LivingEntity player, float damage) {
        UUID uuid = player.getUuid();
        float stored = damage * 0.25f;
        LAST_STORED_AMOUNT.put(player.getUuid(), stored);
        IS_FIRST_ATTACK.put(player.getUuid(), false);
        LAST_ATTACK_TIME.put(uuid, player.getWorld().getTime());

    }
    
    public static boolean isFirstAttack(LivingEntity player) {
        return IS_FIRST_ATTACK.getOrDefault(player.getUuid(), true);
    }
    
    public static float getLastStoredAmount(LivingEntity player) {
        return LAST_STORED_AMOUNT.getOrDefault(player.getUuid(), 0f);
    }

    public static void checkAndClearExpired(LivingEntity player) {
        UUID uuid = player.getUuid();
        if (LAST_ATTACK_TIME.containsKey(uuid)) {
            long currentTime = player.getWorld().getTime();
            if (currentTime - LAST_ATTACK_TIME.get(uuid) > CleanlinessHelper.alboe_mystic_armory$calculateTicksFromSeconds(3)) {
                clearStoredDamage(player);
            }
        }
    }

    public static void clearStoredDamage(LivingEntity player) {
        UUID uuid = player.getUuid();
        LAST_STORED_AMOUNT.remove(uuid);
        IS_FIRST_ATTACK.remove(uuid);
        LAST_ATTACK_TIME.remove(uuid);
    }

    public static void clearIsFirstAttack(LivingEntity player) {
        UUID uuid = player.getUuid();
        IS_FIRST_ATTACK.remove(uuid);
    }
}
