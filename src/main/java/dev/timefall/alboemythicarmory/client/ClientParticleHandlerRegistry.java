package dev.timefall.alboemythicarmory.client;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class ClientParticleHandlerRegistry {
    public static void register() {
        ClientTickEvents.START_WORLD_TICK.register(MarkedEntityParticleHandler::onClientTick);
        // TODO Add handler for the StunnedEntityParticles
    }
}
