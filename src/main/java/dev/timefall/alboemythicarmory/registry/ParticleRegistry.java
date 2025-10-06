package dev.timefall.alboemythicarmory.registry;

import dev.timefall.alboemythicarmory.ModConstants;
import dev.timefall.alboemythicarmory.particle.MarkedParticle;
import dev.timefall.alboemythicarmory.particle.StunnedParticle;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ParticleRegistry {
    public static final DefaultParticleType MARKED = registerParticle("marked", FabricParticleTypes.simple());
    public static final DefaultParticleType STUNNED = registerParticle("stunned", FabricParticleTypes.simple());

    private static DefaultParticleType registerParticle(String name, DefaultParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, new Identifier(ModConstants.MOD_ID, name), particleType);
    }

    public static void register() {
        ModConstants.LOGGER.info("Initializing Particles from " + ModConstants.MOD_NAME);
    }

    @Environment(EnvType.CLIENT)
    public static void registerClient() {
        ParticleFactoryRegistry.getInstance().register(MARKED, MarkedParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(STUNNED, StunnedParticle.Factory::new);
    }
}
