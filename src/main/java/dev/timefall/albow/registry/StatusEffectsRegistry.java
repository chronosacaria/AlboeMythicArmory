package dev.timefall.albow.registry;

import dev.timefall.albow.ModConstants;
import dev.timefall.albow.entity.effect.MarkedStatusEffect;
import dev.timefall.albow.entity.effect.StunnedStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class StatusEffectsRegistry {
    public static RegistryEntry<StatusEffect> MARKED;
    public static RegistryEntry<StatusEffect> STUNNED;

    public static void register() {
        ModConstants.LOGGER.info("Initializing Status Effects from " + ModConstants.MOD_NAME);
        MARKED = register("marked", new MarkedStatusEffect(StatusEffectCategory.HARMFUL, 0x8B0000));
        STUNNED = register("stunned", new StunnedStatusEffect(StatusEffectCategory.HARMFUL, 16701501));
    }

    public static RegistryEntry<StatusEffect> register(String id, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT,Identifier.of(ModConstants.MOD_ID, id), statusEffect);
    }
}
