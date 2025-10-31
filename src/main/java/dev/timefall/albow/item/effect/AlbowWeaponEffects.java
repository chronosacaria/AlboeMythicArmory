package dev.timefall.albow.item.effect;

import dev.timefall.albow.registry.ItemRegistry;
import dev.timefall.albow.util.helper.CleanlinessHelper;
import dev.timefall.albow.util.helper.EntityEffectHelper;
import dev.timefall.albow.util.helper.UUIDHelper;
import dev.timefall.albow.util.statemanager.AttackDamageStorage;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

public class AlbowWeaponEffects {

    public static void albow$shadowfangDarknessMovement(LivingEntity livingEntity) {
        EntityAttributeInstance entityAttributeInstance = livingEntity.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
        EntityAttributeModifier SHADOWFANG_SPEED_BOOST = new EntityAttributeModifier(
                UUIDHelper.SHADOWFANG_SPEED_BOOST_ID.getUUID(),
                "Shadowfang speed boost",
                0.10D,
                EntityAttributeModifier.Operation.MULTIPLY_TOTAL
        );

        if ((!livingEntity.getEquippedStack(EquipmentSlot.MAINHAND).isOf(ItemRegistry.SHADOWFANG.get())
                || livingEntity.getEntityWorld().getLightLevel(livingEntity.getBlockPos()) > 5)
                && entityAttributeInstance != null) {
            entityAttributeInstance.removeModifier(SHADOWFANG_SPEED_BOOST);
        }
        if (entityAttributeInstance != null
                && entityAttributeInstance.getModifier(SHADOWFANG_SPEED_BOOST.getId()) == null
                && livingEntity.getMainHandStack().isOf(ItemRegistry.SHADOWFANG.get().asItem())) {
            entityAttributeInstance.addTemporaryModifier(SHADOWFANG_SPEED_BOOST);
        }
    }
    public static void albow$healInSunlight(LivingEntity livingEntity) {
        if (livingEntity instanceof PlayerEntity playerEntity && playerEntity.isCreative()) return;
        if (albow$isInSunlight(livingEntity)
                && livingEntity.getHealth() != livingEntity.getMaxHealth()
                && livingEntity.getEntityWorld().getTime()
                    % CleanlinessHelper.albow$calculateTicksFromSeconds(10) == 0)
            livingEntity.heal(0.5F);
    }

    public static void albow$chanceToIgniteEntity(LivingEntity targetEntity, int timeInSeconds, int chance) {
        if (CleanlinessHelper.percentToOccur(chance))
                targetEntity.setOnFireFor(timeInSeconds);
    }
    public static void albow$receiveSpeedFromAttack(LivingEntity attackingEntity, int timeInSeconds) {
        attackingEntity.addStatusEffect(
                new StatusEffectInstance(
                        StatusEffects.SPEED,
                        CleanlinessHelper.albow$calculateTicksFromSeconds(timeInSeconds)
                )
        );
    }
    public static float albow$storedDamage(DamageSource damageSource, float damage, float storedDamagePercentage) {
        if (!(damageSource.getAttacker() instanceof LivingEntity attackingEntity)) return damage;

        if (!AttackDamageStorage.isFirstAttack(attackingEntity)) {
            float storedDamage = AttackDamageStorage.getLastStoredAmount(attackingEntity);
            boolean hasStoredDamage = storedDamage > 0.0F;
            if (hasStoredDamage) {
                AttackDamageStorage.clearStoredDamage(attackingEntity);
                damage += storedDamage;
            }
        }
        if (damage > 0.0F) {
            float damageToStore = damage * storedDamagePercentage;
            AttackDamageStorage.storeDamage(attackingEntity, damageToStore);
        }
        return damage;
    }
    public static float albow$extraDamageWhenArmored(DamageSource damageSource, LivingEntity targetEntity, float damage, float extraArmoredDamage) {
        if (!(damageSource.getAttacker() instanceof LivingEntity)) return damage;
        if (CleanlinessHelper.hasAnyArmorEquipped(targetEntity))
            return damage + extraArmoredDamage;
        return damage;
    }
    public static float albow$wetDamage(DamageSource damageSource, float damage, float additionalWetDamage) {
        if (!(damageSource.getAttacker() instanceof LivingEntity attackingEntity)) return damage;
        if (!attackingEntity.isWet()) return damage;

        return damage + additionalWetDamage;
    }
    public static float albow$handleIronfangAttack(DamageSource damageSource, float damage, LivingEntity targetEntity) {

        if (!(damageSource.getAttacker() instanceof LivingEntity attacker)) return damage;
        if (!attacker.getEquippedStack(EquipmentSlot.MAINHAND).isOf(ItemRegistry.IRONFANG.get())) return damage;

        if (AttackDamageStorage.isFirstAttack(attacker)) {
            if (!EntityEffectHelper.isEntityMarked(targetEntity))
                EntityEffectHelper.markEntity(targetEntity, 100);
            AttackDamageStorage.storeDamage(attacker, 0);
            return damage;
        }

        if (EntityEffectHelper.isEntityMarked(targetEntity)) {
            EntityEffectHelper.unmarkEntity(targetEntity);
            EntityEffectHelper.stunEntity(targetEntity, 60);

            AttackDamageStorage.clearIsFirstAttack(attacker);

            float bonusDamage = damage * 0.2f;
            return damage + bonusDamage;
        }

        AttackDamageStorage.clearStoredDamage(attacker);
        return damage;
    }

    static boolean albow$isInSunlight(LivingEntity livingEntity) {
        return livingEntity.getEntityWorld().isSkyVisibleAllowingSea(livingEntity.getBlockPos())
                && livingEntity.getEntityWorld().isDay()
                && !livingEntity.getEntityWorld().isRaining()
                && !livingEntity.getEntityWorld().isThundering();
    }
}
