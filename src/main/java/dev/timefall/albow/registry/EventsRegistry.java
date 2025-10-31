package dev.timefall.albow.registry;

import dev.timefall.albow.ModConstants;
import dev.timefall.albow.util.handler.ServerEventHandler;

public class EventsRegistry {
    public static void register() {
        ModConstants.LOGGER.info("Initializing Server Events from " + ModConstants.MOD_NAME);
        ServerEventHandler.register();
    }
}
