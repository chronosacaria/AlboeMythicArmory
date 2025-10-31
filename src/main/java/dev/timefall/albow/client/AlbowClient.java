package dev.timefall.albow.client;

import dev.timefall.albow.registry.ParticleRegistry;
import dev.timefall.albow.util.handler.ClientEventHandler;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class AlbowClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ParticleRegistry.registerClient();
        ClientEventHandler.registerStartTickEvents();
        ClientEventHandler.registerOverlayEvents();
    }
}
