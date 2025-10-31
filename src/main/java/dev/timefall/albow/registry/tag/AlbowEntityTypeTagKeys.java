package dev.timefall.albow.registry.tag;

import dev.timefall.albow.ModConstants;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public final class AlbowEntityTypeTagKeys {
    public static final TagKey<EntityType<?>> ANIMALS = register("animals");
    public static final TagKey<EntityType<?>> AVIANS = register("avians");
    public static final TagKey<EntityType<?>> BANDITS = register("bandits");
    public static final TagKey<EntityType<?>> BEASTS = register("beasts");
    public static final TagKey<EntityType<?>> CHIMERIC_HORRORS = register("chimeric_horrors");
    public static final TagKey<EntityType<?>> DRACONIC_KIN = register("draconic_kin");
    public static final TagKey<EntityType<?>> DRAGONS = register("dragons");
    public static final TagKey<EntityType<?>> END_ALIGNED = register("end_aligned");
    public static final TagKey<EntityType<?>> LEVIATHANS = register("leviathans");
    public static final TagKey<EntityType<?>> MYTHIC_BEASTS = register("mythic_beasts");
    public static final TagKey<EntityType<?>> PREDATORS = register("predators");
    public static final TagKey<EntityType<?>> SPIRITS = register("spirits");


    public static final TagKey<EntityType<?>> FACTION_GOBLINS = register("factions/faction_goblins");
        public static final TagKey<EntityType<?>> GOBLINS_LESSER = register("goblins/lesser_goblins");
        public static final TagKey<EntityType<?>> GOBLINS_BASE = register("goblins/base_goblins");
        public static final TagKey<EntityType<?>> GOBLINS_ELITE = register("goblins/elite_goblins");

    public static final TagKey<EntityType<?>> FACTION_DWARVES = register("factions/faction_dwarves");
        public static final TagKey<EntityType<?>> DWARVES_CLANSFOLK = register("dwarves/clansfolk_dwarves");
        public static final TagKey<EntityType<?>> DWARVES_WARRIOR = register("dwarves/warrior_dwarves");
        public static final TagKey<EntityType<?>> DWARVES_ELITE = register("dwarves/elite_dwarves");

    public static final TagKey<EntityType<?>> FACTION_ELVES = register("factions/faction_elves");
        public static final TagKey<EntityType<?>> ELVES_WOOD = register("elves/wood_elves");
        public static final TagKey<EntityType<?>> ELVES_HIGH = register("elves/high_elves");
        public static final TagKey<EntityType<?>> ELVES_DARK = register("elves/dark_elves");
        public static final TagKey<EntityType<?>> ELVES_ELITE = register("elves/elite_elves");

    public static final TagKey<EntityType<?>> FACTION_CRIMSON_LOTUS = register("factions/faction_crimson_lotus");
        public static final TagKey<EntityType<?>> CRIMSON_LOTUS_SOLDIERS = register("crimson_lotus/lotus_soldiers");
        public static final TagKey<EntityType<?>> CRIMSON_LOTUS_SPECIALISTS = register("crimson_lotus/lotus_specialists");
        public static final TagKey<EntityType<?>> CRIMSON_LOTUS_ELITES = register("crimson_lotus/lotus_elites");

    public static final TagKey<EntityType<?>> FACTION_TWILIGHT_VEIL = register("factions/faction_twilight_veil");
        public static final TagKey<EntityType<?>> TWILIGHT_VEIL_OCCULT_FOLLOWERS = register("twilight_veil/occult_followers");
        public static final TagKey<EntityType<?>> TWILIGHT_VEIL_TWISTED_HORRORS = register("twilight_veil/twisted_horrors");
        public static final TagKey<EntityType<?>> TWILIGHT_VEIL_ELDRITCH_LEADERS = register("twilight_veil/eldritch_leaders");

    public static final TagKey<EntityType<?>> FACTION_HOUSE_OF_DAWN = register("factions/faction_house_of_dawn");
        public static final TagKey<EntityType<?>> HOUSE_OF_DAWN_NATURAL_GUARDIANS = register("house_of_dawn/natural_guardians");
        public static final TagKey<EntityType<?>> HOUSE_OF_DAWN_ELEMENTAL_SPIRITS = register("house_of_dawn/elemental_spirits");
        public static final TagKey<EntityType<?>> HOUSE_OF_DAWN_SOLARBOUND_ELITES = register("house_of_dawn/solarbound_elites");

    public static final TagKey<EntityType<?>> FACTION_FAE = register("factions/faction_fae");
        public static final TagKey<EntityType<?>> FAE_LESSER = register("fae/lesser_fae");
        public static final TagKey<EntityType<?>> FAE_FOREST_SPIRITS = register("fae/forest_spirits");
        public static final TagKey<EntityType<?>> FAE_GREATER = register("fae/greater_fae");

    public static final TagKey<EntityType<?>> FACTION_DEMONS = register("faction_demons");
        public static final TagKey<EntityType<?>> DEMONS_LESSER = register("demons/lesser_demons");
        public static final TagKey<EntityType<?>> DEMONS_BASE = register("demons/base_demons");
        public static final TagKey<EntityType<?>> DEMONS_GREATER = register("demons/greater_demons");
        public static final TagKey<EntityType<?>> DEMONS_DEMONIC_LORDS = register("demons/demonic_lords");

    public static final TagKey<EntityType<?>> FACTION_GIANTKIN = register("factions/faction_giantkin");
        public static final TagKey<EntityType<?>> GIANTKIN_GIANTS = register("giantkin/giants");
        public static final TagKey<EntityType<?>> GIANTKIN_OGRES = register("giantkin/ogres");
        public static final TagKey<EntityType<?>> GIANTKIN_TROLLS = register("giantkin/trolls");

    private static TagKey<EntityType<?>> register(String path) {
        return TagKey.of(RegistryKeys.ENTITY_TYPE, new Identifier(ModConstants.MOD_ID, path));
    }
}
