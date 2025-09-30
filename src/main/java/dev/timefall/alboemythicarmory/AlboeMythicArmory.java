package dev.timefall.alboemythicarmory;

import dev.timefall.alboemythicarmory.registry.ItemGroupRegistry;
import dev.timefall.alboemythicarmory.registry.ItemRegistry;
import net.fabricmc.api.ModInitializer;

public class AlboeMythicArmory implements ModInitializer {


    @Override
    public void onInitialize() {
        ItemRegistry.register();
        ItemGroupRegistry.register();
    }
}
