package dev.timefall.albow.registry;

import dev.timefall.albow.ModConstants;
import dev.timefall.albow.client.particle.ParticleProfile;
import dev.timefall.albow.client.particle.ProfiledParticleFactory;
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

    @Environment(EnvType.CLIENT)
    public static void registerClient() {
        ModConstants.LOGGER.info("Initializing Particles from " + ModConstants.MOD_NAME);
        ParticleFactoryRegistry.getInstance().register(
                MARKED,
                sprites ->
                        new ProfiledParticleFactory(
                                sprites,
                                ParticleProfile.MARKED
                        )
        );
        ParticleFactoryRegistry.getInstance().register(
                STUNNED,
                sprites ->
                        new ProfiledParticleFactory(
                                sprites,
                                ParticleProfile.STUNNED
                        )
        );
    }
}
