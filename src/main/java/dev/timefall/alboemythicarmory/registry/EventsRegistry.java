package dev.timefall.alboemythicarmory.registry;

import dev.timefall.alboemythicarmory.ModConstants;
import dev.timefall.alboemythicarmory.util.handler.StunEventHandler;

public class EventsRegistry {
    public static void register() {
        ModConstants.LOGGER.info("Initializing Events from " + ModConstants.MOD_NAME);
        StunEventHandler.register();
    }
}
