package dev.timefall.alboemythicarmory;

import dev.timefall.alboemythicarmory.registry.*;
import net.fabricmc.api.ModInitializer;

public class AlboeMythicArmory implements ModInitializer {

    @Override
    public void onInitialize() {
        ModConstants.LOGGER.info("Initializing " + ModConstants.MOD_NAME);
        
        // Register custom status effects
        StatusEffectsRegistry.register();

        // Register particles
        ParticleRegistry.register();
        
        // Register items and item groups
        ItemRegistry.register();
        ItemGroupRegistry.register();

        // Register events
        EventsRegistry.register();
    }
}
