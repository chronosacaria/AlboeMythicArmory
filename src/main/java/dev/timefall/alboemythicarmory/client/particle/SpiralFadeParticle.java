package dev.timefall.alboemythicarmory.client.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.particle.SpriteBillboardParticle;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class SpiralFadeParticle extends SpriteBillboardParticle {

    private final SpriteProvider sprites;
    private final ParticleProfile profile;

    protected SpiralFadeParticle(
            ClientWorld world,
            double x, double y, double z,
            double vx, double vy, double vz,
            SpriteProvider sprites,
            ParticleProfile profile
    ) {
        super(world, x, y, z, vx, vy, vz);
        this.sprites = sprites;
        this.profile = profile;

        this.velocityX = vx;
        this.velocityY = vy;
        this.velocityZ = vz;

        this.scale *= profile.initialScaleMultiplier();
        this.maxAge = this.random.nextInt(profile.ageJitter()) + profile.ageBase();
        this.setSpriteForAge(sprites);

        this.red   = profile.red();
        this.green = profile.green();
        this.blue  = profile.blue();
        this.alpha = profile.baseAlpha();
    }

    @Override
    public void tick() {
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;

        if (this.age++ >= this.maxAge) {
            this.markDead();
            return;
        }

        float progress = (float) this.age / (float) this.maxAge;
        float angle  = this.age * profile.angleSpeed();
        float radius = profile.radiusMax() * progress;

        this.x += MathHelper.cos(angle) * radius * profile.radiusScale();
        this.z += MathHelper.sin(angle) * radius * profile.radiusScale();
        this.y += profile.risePerTick();

        this.alpha = profile.baseAlpha() * (1.0f - progress);
        this.setSpriteForAge(this.sprites);
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }
}