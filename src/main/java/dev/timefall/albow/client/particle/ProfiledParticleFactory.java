package dev.timefall.albow.client.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

@Environment(EnvType.CLIENT)
// This is done to allow for future multiloader compatibility without the need to rewrite code
public record ProfiledParticleFactory(SpriteProvider sprites, ParticleProfile profile) implements ParticleFactory<DefaultParticleType> {

    @Override
    public Particle createParticle(
            DefaultParticleType type,
            ClientWorld world,
            double x,
            double y,
            double z,
            double vx,
            double vy,
            double vz
    ) {
        return new SpiralFadeParticle(world, x, y, z, vx, vy, vz, sprites, profile);
    }
}