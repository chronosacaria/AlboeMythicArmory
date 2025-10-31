package dev.timefall.albow.datagen.tag;

import dev.timefall.albow.ModConstants;
import dev.timefall.albow.registry.tag.AlbowEntityTypeTagKeys;
import dev.timefall.albow.util.helper.CleanlinessHelper;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class AlbowEntityTypeTagProvider extends FabricTagProvider<EntityType<?>> {
    private static final String VANILLA_NAMESPACE = "minecraft";
    private static final String ALBOM_NAMESPACE = "albom";

    public AlbowEntityTypeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.ENTITY_TYPE, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        // ALBOW -- Animals
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.ANIMALS)
                .addOptional(Identifier.of(VANILLA_NAMESPACE, CleanlinessHelper.albow$entityTypeToLowercaseName(EntityType.AXOLOTL, 17)))
                .addOptional(Identifier.of(VANILLA_NAMESPACE, CleanlinessHelper.albow$entityTypeToLowercaseName(EntityType.BAT, 17)))
                .addOptional(Identifier.of(VANILLA_NAMESPACE, CleanlinessHelper.albow$entityTypeToLowercaseName(EntityType.BEE, 17)))
                .addOptional(Identifier.of(VANILLA_NAMESPACE, CleanlinessHelper.albow$entityTypeToLowercaseName(EntityType.CAMEL, 17)))
                .addOptional(Identifier.of(VANILLA_NAMESPACE, CleanlinessHelper.albow$entityTypeToLowercaseName(EntityType.CAT, 17)))
                .addOptional(Identifier.of(VANILLA_NAMESPACE, CleanlinessHelper.albow$entityTypeToLowercaseName(EntityType.CHICKEN, 17)))
                .addOptional(Identifier.of(VANILLA_NAMESPACE, CleanlinessHelper.albow$entityTypeToLowercaseName(EntityType.COD, 17)))
                .addOptional(Identifier.of(VANILLA_NAMESPACE, CleanlinessHelper.albow$entityTypeToLowercaseName(EntityType.COW, 17)))
                .addOptional(Identifier.of(VANILLA_NAMESPACE, CleanlinessHelper.albow$entityTypeToLowercaseName(EntityType.DOLPHIN, 17)))
                .addOptional(Identifier.of(VANILLA_NAMESPACE, CleanlinessHelper.albow$entityTypeToLowercaseName(EntityType.DONKEY, 17)))
                .addOptional(Identifier.of(VANILLA_NAMESPACE, CleanlinessHelper.albow$entityTypeToLowercaseName(EntityType.FOX, 17)))
                .addOptional(Identifier.of(VANILLA_NAMESPACE, CleanlinessHelper.albow$entityTypeToLowercaseName(EntityType.FROG, 17)))
                .addOptional(Identifier.of(VANILLA_NAMESPACE, CleanlinessHelper.albow$entityTypeToLowercaseName(EntityType.GLOW_SQUID, 17)))
                .addOptional(Identifier.of(VANILLA_NAMESPACE, CleanlinessHelper.albow$entityTypeToLowercaseName(EntityType.GOAT, 17)))
                .addOptional(Identifier.of(VANILLA_NAMESPACE, CleanlinessHelper.albow$entityTypeToLowercaseName(EntityType.HORSE, 17)))
                .addOptional(Identifier.of(VANILLA_NAMESPACE, CleanlinessHelper.albow$entityTypeToLowercaseName(EntityType.LLAMA, 17)))
                .addOptional(Identifier.of(VANILLA_NAMESPACE, CleanlinessHelper.albow$entityTypeToLowercaseName(EntityType.MOOSHROOM, 17)))
                .addOptional(Identifier.of(VANILLA_NAMESPACE, CleanlinessHelper.albow$entityTypeToLowercaseName(EntityType.MULE, 17)))
                .addOptional(Identifier.of(VANILLA_NAMESPACE, CleanlinessHelper.albow$entityTypeToLowercaseName(EntityType.OCELOT, 17)))
                .addOptional(Identifier.of(VANILLA_NAMESPACE, CleanlinessHelper.albow$entityTypeToLowercaseName(EntityType.PANDA, 17)))
                .addOptional(Identifier.of(VANILLA_NAMESPACE, CleanlinessHelper.albow$entityTypeToLowercaseName(EntityType.PARROT, 17)))
                .addOptional(Identifier.of(VANILLA_NAMESPACE, CleanlinessHelper.albow$entityTypeToLowercaseName(EntityType.PIG, 17)))
                .addOptional(Identifier.of(VANILLA_NAMESPACE, CleanlinessHelper.albow$entityTypeToLowercaseName(EntityType.POLAR_BEAR, 17)))
                .addOptional(Identifier.of(VANILLA_NAMESPACE, CleanlinessHelper.albow$entityTypeToLowercaseName(EntityType.PUFFERFISH, 17)))
                .addOptional(Identifier.of(VANILLA_NAMESPACE, CleanlinessHelper.albow$entityTypeToLowercaseName(EntityType.RABBIT, 17)))
                .addOptional(Identifier.of(VANILLA_NAMESPACE, CleanlinessHelper.albow$entityTypeToLowercaseName(EntityType.SALMON, 17)))
                .addOptional(Identifier.of(VANILLA_NAMESPACE, CleanlinessHelper.albow$entityTypeToLowercaseName(EntityType.SHEEP, 17)))
                .addOptional(Identifier.of(VANILLA_NAMESPACE, CleanlinessHelper.albow$entityTypeToLowercaseName(EntityType.SNIFFER, 17)))
                .addOptional(Identifier.of(VANILLA_NAMESPACE, CleanlinessHelper.albow$entityTypeToLowercaseName(EntityType.SQUID, 17)))
                .addOptional(Identifier.of(VANILLA_NAMESPACE, CleanlinessHelper.albow$entityTypeToLowercaseName(EntityType.TRADER_LLAMA, 17)))
                .addOptional(Identifier.of(VANILLA_NAMESPACE, CleanlinessHelper.albow$entityTypeToLowercaseName(EntityType.TROPICAL_FISH, 17)))
                .addOptional(Identifier.of(VANILLA_NAMESPACE, CleanlinessHelper.albow$entityTypeToLowercaseName(EntityType.TURTLE, 17)))
                .addOptional(Identifier.of(VANILLA_NAMESPACE, CleanlinessHelper.albow$entityTypeToLowercaseName(EntityType.WOLF, 17)));

        // ALBOM -- Avians
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.AVIANS)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "thunderbird"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "roc"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "phoenix"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "harpy"));

        // ALBOM -- Bandits
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.BANDITS)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "bandit_grunt"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "bandit_raider"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "bandit_captain"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "outlaw_huntsman"));

        // ALBOW -- Beasts
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.BEASTS)
                .addOptional(Identifier.of(VANILLA_NAMESPACE, CleanlinessHelper.albow$entityTypeToLowercaseName(EntityType.HOGLIN, 17)))
                .addOptional(Identifier.of(VANILLA_NAMESPACE, CleanlinessHelper.albow$entityTypeToLowercaseName(EntityType.RAVAGER, 17)))
                .addOptional(Identifier.of(VANILLA_NAMESPACE, CleanlinessHelper.albow$entityTypeToLowercaseName(EntityType.STRIDER, 17)))
                .addOptional(Identifier.of(VANILLA_NAMESPACE, CleanlinessHelper.albow$entityTypeToLowercaseName(EntityType.ZOGLIN, 17)));

        // ALBOM -- Chimeric Horrors
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.CHIMERIC_HORRORS)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "manticore"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "basilisk"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "cockatrice"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "chimera"));

        // ALBOM -- Draconic Kin
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.DRACONIC_KIN)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "wyvern"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "wyrm"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "hydra"));

        // ALBOM -- Dragons
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.DRAGONS)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "elder_dragon"))
                .addOptional(Identifier.of(VANILLA_NAMESPACE, CleanlinessHelper.albow$entityTypeToLowercaseName(EntityType.ENDER_DRAGON, 17)))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "fire_dragon"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "ice_dragon"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "storm_dragon"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "harpy"));

        // ALBOM -- End Aligned
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.END_ALIGNED)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "thunderbird"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "roc"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "phoenix"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "harpy"));

        // ALBOM -- Leviathans
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.LEVIATHANS)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "sea_serpent"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "abyssal_leviathan"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "kraken"));

        // ALBOM -- Mythic Beasts
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.MYTHIC_BEASTS)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "centaur"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "glacier_serpent"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "ice_crawler"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "icebound_golem"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "sand_wraith"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "sand_wyrm"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "scarab"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "siren"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "snow_stag"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "treant"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "unicorn"));

        // ALBOM -- Predators
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.PREDATORS)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "direwolf"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "forest_stalker"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "shadow_wolf"));

        // ALBOM -- Spirits
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.SPIRITS)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "thunderbird"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "roc"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "phoenix"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "harpy"));

        // ALBOM -- Crimson Lotus
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.CRIMSON_LOTUS_SOLDIERS)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "lotus_grunt"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "lotus_rot_infected_soldier"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "lotus_scout"));
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.CRIMSON_LOTUS_SPECIALISTS)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "lotus_engineer"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "lotus_flamethrower"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "steam_augmented_enforcer"));
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.CRIMSON_LOTUS_ELITES)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "crimson_rot_beast"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "crimson_rot_champion"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "lotus_war_mech"));

        // ALBOM -- Demons
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.DEMONS_LESSER)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "imp"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "fiendling"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "hell_hound"));
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.DEMONS_BASE)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "demon_brute"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "hell_warrior"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "succubus"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "incubus"));
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.DEMONS_GREATER)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "pit_fiend"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "hellfire_sorcerer"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "abyssal_behemoth"));
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.DEMONS_DEMONIC_LORDS)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "beelzebub"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "paimon"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "azazel"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "demon_king"));

        // ALBOM -- Dwarves
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.DWARVES_CLANSFOLK)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "dwarven_miner"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "dwarven_blacksmith"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "dwarven_trader"));
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.DWARVES_WARRIOR)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "dwarven_footman"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "dwarven_crossbowman"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "dwarven_defender"));
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.DWARVES_ELITE)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "dwarven_rune_priest"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "dwarven_berserker"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "dwarven_king"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "stoneforged_golem"));

        // ALBOM -- Elves
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.ELVES_DARK)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "shadowblade_assassin"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "warlock_of_the_veil"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "spider_matriarch"));
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.ELVES_ELITE)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "archmage_of_the_moon"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "elf_bladedancer_champion"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "elf_high_warden"));
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.ELVES_HIGH)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "elf_mage"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "elf_seer"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "elf_swordmaster"));
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.ELVES_WOOD)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "elf_archer"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "elf_druid"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "elf_scout"));

        // ALBOM -- Fae
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.FAE_LESSER)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "fairy"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "pixie"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "sprite"));
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.FAE_FOREST_SPIRITS)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "nymph_earth"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "nymph_fire"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "nymph_water"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "sylph"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "satyr"));
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.FAE_GREATER)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "sidhe_noble"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "faerie_queen_knight"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "changeling_trickster"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "faerie_queen"));

        // ALBOM -- Giantkin
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.GIANTKIN_GIANTS)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "giant_fire"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "giant_frost"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "giant_hill"));
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.GIANTKIN_OGRES)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "ogre_brute"));
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.GIANTKIN_TROLLS)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "troll_cave"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "troll_mountain"));

        // ALBOM -- Goblins
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.GOBLINS_LESSER)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "goblin_youngling"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "goblin_common"));
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.GOBLINS_BASE)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "goblin_archer"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "goblin_bomber"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "goblin_grunt"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "goblin_scout"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "goblin_shaman"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "goblin_rider"));
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.GOBLINS_ELITE)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "hobgoblin_soldier"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "hobgoblin_sergeant"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "hobgoblin_warcaster"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "hobgoblin_brute"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "goblin_king"));

        // ALBOM -- House of Dawn
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.HOUSE_OF_DAWN_NATURAL_GUARDIANS)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "dawn_sentinel"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "dryad"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "grove_protector"));
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.HOUSE_OF_DAWN_ELEMENTAL_SPIRITS)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "ward_earth"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "ward_fire"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "ward_water"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "ward_wind"));
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.HOUSE_OF_DAWN_SOLARBOUND_ELITES)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "solarbound_knight"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "sun_touched_champion"));

        // ALBOM -- Twilight Veil
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.TWILIGHT_VEIL_OCCULT_FOLLOWERS)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "occult_initiate"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "occult_priest"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "occult_summoner"));
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.TWILIGHT_VEIL_TWISTED_HORRORS)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "flesh_golem"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "occult_lich"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "revenant"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "veil_abomination"));
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.TWILIGHT_VEIL_ELDRITCH_LEADERS)
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "occult_magus"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "revenant_knight"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "star_spawned_horror"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "twilight_warlock"))
                .addOptional(Identifier.of(ALBOM_NAMESPACE, "twilight_witch"));

        // ALBOM -- Faction Tags
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.FACTION_GOBLINS)
                .addOptionalTag(AlbowEntityTypeTagKeys.GOBLINS_LESSER)
                .addOptionalTag(AlbowEntityTypeTagKeys.GOBLINS_BASE)
                .addOptionalTag(AlbowEntityTypeTagKeys.GOBLINS_ELITE);
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.FACTION_DWARVES)
                .addOptionalTag(AlbowEntityTypeTagKeys.DWARVES_CLANSFOLK)
                .addOptionalTag(AlbowEntityTypeTagKeys.DWARVES_WARRIOR)
                .addOptionalTag(AlbowEntityTypeTagKeys.DWARVES_ELITE);
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.FACTION_ELVES)
                .addOptionalTag(AlbowEntityTypeTagKeys.ELVES_WOOD)
                .addOptionalTag(AlbowEntityTypeTagKeys.ELVES_HIGH)
                .addOptionalTag(AlbowEntityTypeTagKeys.ELVES_DARK)
                .addOptionalTag(AlbowEntityTypeTagKeys.ELVES_ELITE);
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.FACTION_CRIMSON_LOTUS)
                .addOptionalTag(AlbowEntityTypeTagKeys.CRIMSON_LOTUS_SOLDIERS)
                .addOptionalTag(AlbowEntityTypeTagKeys.CRIMSON_LOTUS_SPECIALISTS)
                .addOptionalTag(AlbowEntityTypeTagKeys.CRIMSON_LOTUS_ELITES);
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.FACTION_TWILIGHT_VEIL)
                .addOptionalTag(AlbowEntityTypeTagKeys.TWILIGHT_VEIL_OCCULT_FOLLOWERS)
                .addOptionalTag(AlbowEntityTypeTagKeys.TWILIGHT_VEIL_TWISTED_HORRORS)
                .addOptionalTag(AlbowEntityTypeTagKeys.TWILIGHT_VEIL_ELDRITCH_LEADERS);
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.FACTION_HOUSE_OF_DAWN)
                .addOptionalTag(AlbowEntityTypeTagKeys.HOUSE_OF_DAWN_NATURAL_GUARDIANS)
                .addOptionalTag(AlbowEntityTypeTagKeys.HOUSE_OF_DAWN_ELEMENTAL_SPIRITS)
                .addOptionalTag(AlbowEntityTypeTagKeys.HOUSE_OF_DAWN_SOLARBOUND_ELITES);
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.FACTION_FAE)
                .addOptionalTag(AlbowEntityTypeTagKeys.FAE_LESSER)
                .addOptionalTag(AlbowEntityTypeTagKeys.FAE_FOREST_SPIRITS)
                .addOptionalTag(AlbowEntityTypeTagKeys.FAE_GREATER);
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.FACTION_DEMONS)
                .addOptionalTag(AlbowEntityTypeTagKeys.DEMONS_LESSER)
                .addOptionalTag(AlbowEntityTypeTagKeys.DEMONS_BASE)
                .addOptionalTag(AlbowEntityTypeTagKeys.DEMONS_GREATER)
                .addOptionalTag(AlbowEntityTypeTagKeys.DEMONS_DEMONIC_LORDS);
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.FACTION_GOBLINS)
                .addOptionalTag(AlbowEntityTypeTagKeys.DEMONS_LESSER)
                .addOptionalTag(AlbowEntityTypeTagKeys.DEMONS_BASE)
                .addOptionalTag(AlbowEntityTypeTagKeys.DEMONS_GREATER)
                .addOptionalTag(AlbowEntityTypeTagKeys.DEMONS_DEMONIC_LORDS);
        getOrCreateTagBuilder(AlbowEntityTypeTagKeys.FACTION_GIANTKIN)
                .addOptionalTag(AlbowEntityTypeTagKeys.GIANTKIN_GIANTS)
                .addOptionalTag(AlbowEntityTypeTagKeys.GIANTKIN_OGRES)
                .addOptionalTag(AlbowEntityTypeTagKeys.GIANTKIN_TROLLS);
    }

    @Override
    public String getName() {
        return ModConstants.MOD_NAME + "Entity Type Tags";
    }
}
