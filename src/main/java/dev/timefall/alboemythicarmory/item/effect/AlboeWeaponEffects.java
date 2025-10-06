package dev.timefall.alboemythicarmory.item.effect;

import dev.timefall.alboemythicarmory.registry.ItemRegistry;
import dev.timefall.alboemythicarmory.util.helper.CleanlinessHelper;
import dev.timefall.alboemythicarmory.util.helper.EntityEffectHelper;
import dev.timefall.alboemythicarmory.util.helper.UUIDHelper;
import dev.timefall.alboemythicarmory.util.statemanager.AttackDamageStorage;
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
        if (!(damageSource.getAttacker() instanceof LivingEntity attackingEntity)) return damage;

        if (attackingEntity.getEquippedStack(EquipmentSlot.MAINHAND).isOf(ItemRegistry.ECHO_EDGE.get())) {
            if (!AttackDamageStorage.isFirstAttack(attackingEntity)) {
                float storedDamage = AttackDamageStorage.getLastStoredAmount(attackingEntity);
                boolean hasStoredDamage = storedDamage > 0.0F;

                if (hasStoredDamage) {
                    AttackDamageStorage.clearStoredDamage(attackingEntity);
                    damage += storedDamage;
                }
            }

            if (damage > 0.0F) {
                float damageToStore = damage * 0.25f;
                AttackDamageStorage.storeDamage(attackingEntity, damageToStore);
            }

            return damage;
        }

        return damage;
    }

    public static float handleIronfangAttack(DamageSource damageSource, float damage, LivingEntity targetEntity) {
        /* TODO Break out checks for the Ironfang attack into smaller pieces for easy editing later
         *  Section 1: Mark Entity Logic
         *  Section 2: Stun Entity Logic
         *  Section 3: Clear Stored Values
         *  *** Make sure to remove Debugging Outputs ***
         */


        if (!(damageSource.getAttacker() instanceof LivingEntity attacker)) {
            return damage;
        }

        if (!attacker.getEquippedStack(EquipmentSlot.MAINHAND).isOf(ItemRegistry.IRONFANG.get())) {
            return damage;
        }

        if (AttackDamageStorage.isFirstAttack(attacker)) {
            if (!EntityEffectHelper.isEntityMarked(targetEntity)) {
                EntityEffectHelper.markEntity(targetEntity, 100);
                System.out.println("Marked " + targetEntity.getName().getString() + " for stun");
            }
            AttackDamageStorage.storeDamage(attacker, 0);
            return damage;
        }

        if (EntityEffectHelper.isEntityMarked(targetEntity)) {
            EntityEffectHelper.unmarkEntity(targetEntity);
            System.out.println(targetEntity.getName().getString() + " is no longer marked.");
            EntityEffectHelper.stunEntity(targetEntity, 60);
            System.out.println(targetEntity.getName().getString() + " is now stunned.");

            AttackDamageStorage.clearIsFirstAttack(attacker);
            System.out.println(attacker.getName().getString() + "'s first attack has been cleared.");

            float bonusDamage = damage * 0.2f;

            System.out.println(targetEntity.getName().getString() + " will receive " + bonusDamage + " extra damage."
                    + "\n"
                    + "This is on top of the " + damage + ". This brings to total damage to " + (damage + bonusDamage));

            return damage + bonusDamage;
        }

        AttackDamageStorage.clearStoredDamage(attacker);
        return damage;
    }
}
