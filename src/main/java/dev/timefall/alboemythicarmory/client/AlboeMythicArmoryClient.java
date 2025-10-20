package dev.timefall.alboemythicarmory.client;

import dev.timefall.alboemythicarmory.registry.ParticleRegistry;
import dev.timefall.alboemythicarmory.util.handler.ClientEventHandler;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class AlboeMythicArmoryClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ParticleRegistry.registerClient();
        ClientEventHandler.registerStartTickEvents();
        ClientEventHandler.registerOverlayEvents();
    }
}
