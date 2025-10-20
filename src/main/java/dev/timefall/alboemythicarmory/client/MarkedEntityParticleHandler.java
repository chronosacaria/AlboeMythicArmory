package dev.timefall.alboemythicarmory.client;

import dev.timefall.alboemythicarmory.util.helper.CleanlinessHelper;
import dev.timefall.alboemythicarmory.util.helper.EntityEffectHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particle.ParticleTypes;

@Environment(EnvType.CLIENT)
public class MarkedEntityParticleHandler {
    
    public static void onClientTick(ClientWorld world) {
        if (MinecraftClient.getInstance().isPaused()) return;
        if (world.getTime() % 2 != 0) return;
        for (Entity entity : world.getEntities()) {
            if (entity instanceof LivingEntity livingEntity && EntityEffectHelper.isEntityMarked(livingEntity)) {
                spawnClientParticles(livingEntity);
            }
        }
    }
    
    private static void spawnClientParticles(LivingEntity entity) {
        if (entity == null || entity.getWorld() == null) return;
        
        ClientWorld world = (ClientWorld) entity.getWorld();
        double x = entity.getX();
        double y = entity.getBodyY(0.5);
        double z = entity.getZ();

        for (int i = 0; i < 2; i++) {
            double angle = (world.getTime() * 0.1 + i * Math.PI) % (Math.PI * 2);
            double radius = 0.7 + Math.sin(world.getTime() * 0.1) * 0.1;
            
            double px = x + Math.cos(angle) * radius * entity.getWidth() * 0.8;
            double pz = z + Math.sin(angle) * radius * entity.getWidth() * 0.8;

            double py = y + 0.1 + Math.sin(world.getTime() * 0.1 + i) * 0.1;

            px += (CleanlinessHelper.RANDOM.nextDouble() - 0.5) * 0.1;
            pz += (CleanlinessHelper.RANDOM.nextDouble() - 0.5) * 0.1;

            world.addParticle(
                    ParticleTypes.ENCHANT,
                    px,
                    py,
                    pz,
                    0,
                    0,
                    0
            );

            if (CleanlinessHelper.RANDOM.nextFloat() < 0.3f) {
                world.addParticle(
                        ParticleTypes.ENTITY_EFFECT,
                        px,
                        py,
                        pz,
                        0.7,
                        0.2,
                        1.0
                );
            }
        }
    }
}
