package dev.timefall.alboemythicarmory.registry;

import dev.timefall.alboemythicarmory.ModConstants;
import dev.timefall.alboemythicarmory.util.handler.ServerEventHandler;

public class EventsRegistry {
    public static void register() {
        ModConstants.LOGGER.info("Initializing Server Events from " + ModConstants.MOD_NAME);
        ServerEventHandler.register();
    }
}
