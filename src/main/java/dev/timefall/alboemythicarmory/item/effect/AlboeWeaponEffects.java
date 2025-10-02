package dev.timefall.alboemythicarmory.item.effect;

import dev.timefall.alboemythicarmory.registry.ItemRegistry;
import dev.timefall.alboemythicarmory.util.AttackDamageStorage;
import dev.timefall.alboemythicarmory.util.CleanlinessHelper;
import dev.timefall.alboemythicarmory.util.UUIDHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

public class AlboeWeaponEffects {

    public static void alboe_mythic_armory$shadowfangDarknessMovement(LivingEntity livingEntity) {
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
        if (entityAttributeInstance.getModifier(SHADOWFANG_SPEED_BOOST.getId()) == null
                && livingEntity.getMainHandStack().isOf(ItemRegistry.SHADOWFANG.get().asItem())) {
            entityAttributeInstance.addTemporaryModifier(SHADOWFANG_SPEED_BOOST);
        }
    }
    public static void alboe_mystic_armory$sunwroughtBladeHealingInSunlight(LivingEntity livingEntity) {
        if (livingEntity instanceof PlayerEntity playerEntity && playerEntity.isCreative()) return;
        if (livingEntity.getEquippedStack(EquipmentSlot.MAINHAND).isOf(ItemRegistry.SUNWROUGHT_BLADE.get())
                && livingEntity.getEntityWorld().isSkyVisibleAllowingSea(livingEntity.getBlockPos())
                && livingEntity.getEntityWorld().isDay()
                && !livingEntity.getEntityWorld().isRaining()
                && !livingEntity.getEntityWorld().isThundering()
                && livingEntity.getHealth() != livingEntity.getMaxHealth()
                && livingEntity.getEntityWorld().getTime()
                    % CleanlinessHelper.alboe_mystic_armory$calculateTicksFromSeconds(10) == 0)
            livingEntity.heal(0.5F);
    }
    public static void alboe_mystic_armory$emberbladeIgnition(DamageSource damageSource, LivingEntity targetEntity) {
        if (damageSource.getSource() instanceof LivingEntity attackingEntity
                && attackingEntity.getEquippedStack(EquipmentSlot.MAINHAND).isOf(ItemRegistry.EMBERBRAND.get())) {
            if (CleanlinessHelper.percentToOccur(25))
                targetEntity.setOnFireFor(2);
        }
    }
    public static void alboe_mystic_armory$obsidianSliverExtraDamageWithArmor(DamageSource damageSource, float amount, LivingEntity targetEntity) {
        if (damageSource.getSource() instanceof LivingEntity attackingEntity
                && attackingEntity.getEquippedStack(EquipmentSlot.MAINHAND).isOf(ItemRegistry.OBSIDIAN_SLIVER.get())) {
            if (CleanlinessHelper.hasAnyArmorEquipped(targetEntity)) {
                targetEntity.damage(damageSource, amount + 1.0f);
            }
        }
    }
    public static void alboe_mystic_armory$stormbiteSpeedFromAttack(DamageSource damageSource, float amount) {
        if (damageSource.getSource() instanceof LivingEntity attackingEntity
                && attackingEntity.getEquippedStack(EquipmentSlot.MAINHAND).isOf(ItemRegistry.STORMBITE.get())) {
            if (amount > 0.0F) {
                attackingEntity.addStatusEffect(
                        new StatusEffectInstance(
                                StatusEffects.SPEED,
                                CleanlinessHelper.alboe_mystic_armory$calculateTicksFromSeconds(3)
                        )
                );
            }
        }
    }
    public static float alboe_mystic_armory$echoEdgeStoredDamage(DamageSource damageSource, float damage, LivingEntity targetEntity) {
        System.out.println("=== DAMAGE DEBUG ===");
        System.out.println("Target: " + targetEntity.getName().getString() +
                " | Health: " + targetEntity.getHealth() + "/" + targetEntity.getMaxHealth());
        System.out.println("Initial damage: " + damage);

        if (!(damageSource.getAttacker() instanceof LivingEntity attackingEntity)) {
            System.out.println("No attacking entity or not a living entity wielding an Echo Edge; skipping Echo Edge logic");
            return damage;
        }

        if (attackingEntity.getEquippedStack(EquipmentSlot.MAINHAND).isOf(ItemRegistry.ECHO_EDGE.get())) {
            if (!AttackDamageStorage.isFirstAttack(attackingEntity)) {
                float storedDamage = AttackDamageStorage.getLastStoredAmount(attackingEntity);
                boolean hasStoredDamage = storedDamage > 0.0F;

                if (hasStoredDamage) {
                    AttackDamageStorage.clearStoredDamage(attackingEntity);

                    System.out.println("Applying stored damage: " + storedDamage);
                    System.out.println("Total damage before stored: " + damage);

                    damage += storedDamage;
                }
            }

            if (damage > 0.0F) {
                float damageToStore = damage * 0.25f;
                AttackDamageStorage.storeDamage(attackingEntity, damageToStore);
                System.out.println("Storing damage for next attack: " + damageToStore);
            }

            System.out.println("Final damage being applied: " + damage);
            System.out.println("Target health after damage: " +
                    (targetEntity.getHealth() - damage) + "/" + targetEntity.getMaxHealth());
            System.out.println("=================");

            return damage;
        }

        System.out.println("Not holding Echo Edge, using normal damage: " + damage);
        System.out.println("=================");
        return damage;
    }
}
