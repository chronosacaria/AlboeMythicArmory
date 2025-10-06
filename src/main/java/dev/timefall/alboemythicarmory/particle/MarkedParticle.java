package dev.timefall.alboemythicarmory.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.math.MathHelper;

// TODO Combine MarkedParticle and StunnedParticle into a shared class
public class MarkedParticle extends SpriteBillboardParticle {
    private final SpriteProvider spriteProvider;

    protected MarkedParticle(ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ, SpriteProvider spriteProvider) {
        super(world, x, y, z, velocityX, velocityY, velocityZ);
        this.spriteProvider = spriteProvider;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.velocityZ = velocityZ;
        this.scale *= 0.75f;
        this.maxAge = this.random.nextInt(20) + 40;
        this.setSpriteForAge(spriteProvider);

        this.red = 0.7f;
        this.green = 0.2f;
        this.blue = 1.0f;
        this.alpha = 0.5f;
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

        float progress = (float)this.age / (float)this.maxAge;
        float radius = 0.5f * progress;
        float angle = this.age * 0.5f;
        
        this.x = this.x + MathHelper.cos(angle) * radius * 0.1f;
        this.z = this.z + MathHelper.sin(angle) * radius * 0.1f;
        this.y = this.y + 0.01f;

        this.alpha = 0.5f * (1.0f - progress);
        
        this.setSpriteForAge(this.spriteProvider);
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        public Particle createParticle(
                DefaultParticleType defaultParticleType,
                ClientWorld clientWorld,
                double x,
                double y,
                double z,
                double velocityX,
                double velocityY,
                double velocityZ
        ) {
            return new MarkedParticle(clientWorld, x, y, z, velocityX, velocityY, velocityZ, this.spriteProvider);
        }
    }
}
