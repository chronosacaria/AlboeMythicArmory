package dev.timefall.alboemythicarmory.entity.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.math.Vec3d;

public class StunnedStatusEffect extends StatusEffect {
    public StunnedStatusEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity livingEntity, int amplifier) {
        super.applyUpdateEffect(livingEntity, amplifier);
        livingEntity.setVelocity(Vec3d.ZERO);
    }
}
