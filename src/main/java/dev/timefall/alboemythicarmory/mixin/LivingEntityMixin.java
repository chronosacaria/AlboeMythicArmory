package dev.timefall.alboemythicarmory.mixin;

import dev.timefall.alboemythicarmory.item.effect.AlboeWeaponEffects;
import dev.timefall.alboemythicarmory.registry.ItemRegistry;
import dev.timefall.alboemythicarmory.util.AttackDamageStorage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({LivingEntity.class, PlayerEntity.class})
public abstract class LivingEntityMixin extends Entity {
    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci) {
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        if (livingEntity.getEquippedStack(EquipmentSlot.MAINHAND).isOf(ItemRegistry.ECHO_EDGE.get()))
            AttackDamageStorage.checkAndClearExpired(livingEntity);
    }

    @Inject(method = "tickMovement", at = @At("TAIL"))
    public void tickMovement(CallbackInfo ci) {
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        AlboeWeaponEffects.alboe_mythic_armory$shadowfangDarknessMovement(livingEntity);
        AlboeWeaponEffects.alboe_mystic_armory$sunwroughtBladeHealingInSunlight(livingEntity);
    }

    @Inject(method = "applyDamage(Lnet/minecraft/entity/damage/DamageSource;F)V", at = @At("HEAD"))
    public void applyDamage(DamageSource damageSource, float f, CallbackInfo ci) {
        LivingEntity targetEntity = (LivingEntity) (Object) this;
        AlboeWeaponEffects.alboe_mystic_armory$emberbladeIgnition(damageSource, targetEntity);
        AlboeWeaponEffects.alboe_mystic_armory$obsidianSliverExtraDamageWithArmor(damageSource, f, targetEntity);
        AlboeWeaponEffects.alboe_mystic_armory$stormbiteSpeedFromAttack(damageSource, f);
    }

    @ModifyVariable(method = "damage", at = @At("HEAD"), argsOnly = true)
    public float damage(float damage, DamageSource damageSource) {
        if (this.getWorld().isClient()) return damage;
        LivingEntity targetEntity = (LivingEntity) (Object) this;
        return AlboeWeaponEffects.alboe_mystic_armory$echoEdgeStoredDamage(damageSource, damage, targetEntity);
    }
}
