package dev.timefall.albow;

import dev.timefall.albow.registry.EventsRegistry;
import dev.timefall.albow.registry.ItemGroupRegistry;
import dev.timefall.albow.registry.ItemRegistry;
import dev.timefall.albow.registry.StatusEffectsRegistry;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.EntityType;

public class Albow implements ModInitializer {

    @Override
    public void onInitialize() {
        ModConstants.LOGGER.info("Initializing " + ModConstants.MOD_NAME);
        
        // Register custom status effects
        StatusEffectsRegistry.register();

        // Register items and item groups
        ItemRegistry.register();
        ItemGroupRegistry.register();

        // Register events
        EventsRegistry.register();
        System.out.println();
        System.out.println(EntityType.CAT.getTranslationKey());
    }
}
