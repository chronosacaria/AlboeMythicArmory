package dev.timefall.alboemythicarmory.util.handler;

import dev.timefall.alboemythicarmory.client.StunnedEntityClientHandler;
import dev.timefall.alboemythicarmory.client.gui.hud.StunnedOverlay;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

@Environment(EnvType.CLIENT)
public class ClientEventHandler {
    public static void registerStartTickEvents() {
        // Start Client Tick Events
        ClientTickEvents.START_CLIENT_TICK.register(StunnedEntityClientHandler::onClientTick);
    }

    public static void registerOverlayEvents() {
        HudRenderCallback.EVENT.register(new StunnedOverlay());
    }
}
