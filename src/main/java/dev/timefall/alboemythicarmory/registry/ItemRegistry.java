package dev.timefall.alboemythicarmory.registry;

import dev.timefall.alboemythicarmory.ModConstants;
import dev.timefall.alboemythicarmory.item.material.AlboeToolMaterials;
import dev.timefall.alboemythicarmory.item.AlboeWeaponItem;
import dev.timefall.alboemythicarmory.item.DivinityShrapnelItem;
import dev.timefall.alboemythicarmory.util.CleanlinessHelper;
import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import me.fzzyhmstrs.fzzy_config.util.platform.Registrar;
import me.fzzyhmstrs.fzzy_config.util.platform.RegistrySupplier;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@SuppressWarnings("UnstableApiUsage")
public class ItemRegistry {
    private static final Registrar<Item> ITEM = ConfigApiJava.platform().createRegistrar(ModConstants.MOD_ID, Registries.ITEM);

    // MASTER ITEM LIST
    public static final List<RegistrySupplier<Item>> ITEMS_LIST = new ArrayList<>();

    // ITEMS
    public static final RegistrySupplier<Item> DIVINITY_SHRAPNEL = registerItem("divinity_shrapnel", () -> new DivinityShrapnelItem(new Item.Settings().maxCount(16).fireproof()));

    // SWORDS
    public static final RegistrySupplier<Item> IRONFANG             = registerWeapon("ironfang",                ToolMaterials.IRON,         8,  1.0F,   2.2F, 300);
    public static final RegistrySupplier<Item> SHADOWFANG           = registerWeapon("shadowfang",              ToolMaterials.DIAMOND,      6,  1.05F,  2.6F, 1700);
    public static final RegistrySupplier<Item> SUNWROUGHT_BLADE     = registerWeapon("sunwrought_blade",        AlboeToolMaterials.COPPER,  9,  0.9F,   2.7F, 1440);
    public static final RegistrySupplier<Item> EMBERBRAND           = registerWeapon("emberbrand",              ToolMaterials.IRON,         7,  0.9F,   2.3F, 600);
    public static final RegistrySupplier<Item> OBSIDIAN_SLIVER      = registerWeapon("obsidian_sliver",         ToolMaterials.DIAMOND,      10, 1.05F,  2.4F, 1160);
    public static final RegistrySupplier<Item> STORMBITE            = registerWeapon("stormbite",               ToolMaterials.DIAMOND,      9,  1.05F,  2.6F, 1873);
    public static final RegistrySupplier<Item> ECHO_EDGE            = registerWeapon("echo_edge",               ToolMaterials.DIAMOND,      7,  0.92F,  2.5F, 1160);
    public static final RegistrySupplier<Item> TIDEPIERCER          = registerWeapon("tidepiercer",             ToolMaterials.IRON,         8,  0.95F,  2.6F, 550);
    public static final RegistrySupplier<Item> WYRMFANG_BLADE       = registerWeapon("wyrmfang_blade",          ToolMaterials.IRON,         9,  0.93F,  2.3F, 345);
    public static final RegistrySupplier<Item> CRIMSON_OATH         = registerWeapon("crimson_oath",            ToolMaterials.NETHERITE,    7,  0.9F,   2.4F, 1437);
    public static final RegistrySupplier<Item> FROSTVEIN_EDGE       = registerWeapon("frostvein_edge",          ToolMaterials.IRON,         8,  0.94F,  2.3F, 600);
    public static final RegistrySupplier<Item> GRAVEKEEPERS_MERCY   = registerWeapon("gravekeepers_mercy",      ToolMaterials.STONE,        6,  1.0F,   2.2F, 357);
    public static final RegistrySupplier<Item> RADIANT_CRESCENT     = registerWeapon("radiant_crescent",        ToolMaterials.GOLD,         7,  0.96F,  2.4F, 338);
    public static final RegistrySupplier<Item> FLARECLUSTER         = registerWeapon("flarecluster",            ToolMaterials.IRON,         9,  0.82F,  2.2F, 388);
    public static final RegistrySupplier<Item> GLOAMWERK            = registerWeapon("gloamwerk",               ToolMaterials.DIAMOND,      8,  1.0F,   2.5F, 1500);
    public static final RegistrySupplier<Item> RUNEBLADE_OF_THORNS  = registerWeapon("runeblade_of_thorns",     ToolMaterials.DIAMOND,      7,  0.98F,  2.3F, 1980);
    public static final RegistrySupplier<Item> STARFORGED_EDGE      = registerWeapon("starforged_edge",         ToolMaterials.NETHERITE,    9,  0.87F,  2.6F, 1600);

    // DAGGERS
    public static final RegistrySupplier<Item> MOONPIERCER          = registerWeapon("moonpiercer",             ToolMaterials.IRON,         7,  2.4F,   2.0F, 400);
    public static final RegistrySupplier<Item> CLOCKWORK_DAGGER     = registerWeapon("clockwork_dagger",        AlboeToolMaterials.COPPER,  6,  2.3F,   2.0F, 260);
    public static final RegistrySupplier<Item> WINDWHISPER_BLADE    = registerWeapon("windwhisper_blade",       ToolMaterials.IRON,         7,  2.45F,  2.0F, 200);
    public static final RegistrySupplier<Item> ASHFANG_KNIFE        = registerWeapon("ashfang_knife",           ToolMaterials.IRON,         5,  2.35F,  2.2F, 400);
    public static final RegistrySupplier<Item> CHITTERFANG          = registerWeapon("chitterfang",             AlboeToolMaterials.BONE,    6,  2.5F,   2.0F, 280);
    public static final RegistrySupplier<Item> SHADEWRATH           = registerWeapon("shadewrath",              ToolMaterials.DIAMOND,      4,  2.2F,   2.1F, 1600);
    public static final RegistrySupplier<Item> TWINLIGHT_DAGGER     = registerWeapon("twinlight_dagger",        ToolMaterials.GOLD,         5,  2.3F,   2.0F, 226);
    public static final RegistrySupplier<Item> STORMFLICKER         = registerWeapon("stormflicker",            ToolMaterials.IRON,         6,  2.35F,  2.2F, 400);
    public static final RegistrySupplier<Item> GLIMMERVIEW          = registerWeapon("glimmerview",             ToolMaterials.DIAMOND,      4,  2.7F,   2.0F, 1440);
    public static final RegistrySupplier<Item> THORNSLICER          = registerWeapon("thornslicer",             ToolMaterials.IRON,         6,  2.3F,   2.1F, 400);
    public static final RegistrySupplier<Item> SMOKESTEP_SHIV       = registerWeapon("smokestep_shiv",          ToolMaterials.IRON,         7,  2.45F,  2.0F, 200);
    public static final RegistrySupplier<Item> SOULFANG_DIRKS       = registerWeapon("soulfang_dirks",          ToolMaterials.NETHERITE,    5,  2.4F,   2.0F, 1625);
    public static final RegistrySupplier<Item> FLAMEBITE_KNIFE      = registerWeapon("flamebite_knife",         ToolMaterials.IRON,         5,  2.3F,   2.1F, 400);
    public static final RegistrySupplier<Item> VOIDKISSED_BLADE     = registerWeapon("voidkissed_blade",        ToolMaterials.DIAMOND,      5,  2.4F,   2.3F, 1400);
    public static final RegistrySupplier<Item> BLAZETAIL_BLADE      = registerWeapon("blazetail_blade",         AlboeToolMaterials.COPPER,  4,  2.35F,  2.0F, 260);

    // AXES
    public static final RegistrySupplier<Item> BONEBITER            = registerWeapon("bonebiter",               ToolMaterials.IRON,         10,  0.8F,  2.5F, 225);
    public static final RegistrySupplier<Item> FLAMECLEAVER         = registerWeapon("flamecleaver",            ToolMaterials.IRON,         11,  0.75F, 2.6F, 625);
    public static final RegistrySupplier<Item> SOULHARVEST_AXE      = registerWeapon("soulharvest_axe",         ToolMaterials.DIAMOND,      12,  0.78F, 2.5F, 1500);
    public static final RegistrySupplier<Item> IRONHOWL             = registerWeapon("ironhowl",                ToolMaterials.IRON,         10,  0.82F, 2.5F, 313);

    // HAMMERS
    public static final RegistrySupplier<Item> EARTHSPLITTER        = registerWeapon("earthsplitter",           ToolMaterials.STONE,        10,  0.7F,  2.3F, 183);
    public static final RegistrySupplier<Item> SUNBREAKER_MAUL      = registerWeapon("sunbreaker_maul",         AlboeToolMaterials.COPPER,  10,  0.72F, 2.4F, 1680);
    public static final RegistrySupplier<Item> SHOCKCOIL_HAMMER     = registerWeapon("shockcoil_hammer",        ToolMaterials.IRON,         9,   0.75F, 2.2F, 700);
    public static final RegistrySupplier<Item> WITHERCRUSH          = registerWeapon("withercrush",             ToolMaterials.NETHERITE,    12,  0.73F, 2.3F, 1843);



    protected static RegistrySupplier<Item> registerWeapon(String id, ToolMaterial toolMaterial, int attackDamage, float attackSpeed, float attackRange, int durability) {
        RegistrySupplier<Item> supplier = ITEM.register(id, () -> new AlboeWeaponItem(
                toolMaterial,
                CleanlinessHelper.alboe_mystic_armory$calculateAttackDamage(attackDamage, toolMaterial),
                CleanlinessHelper.alboe_mystic_armory$calculateAttackSpeed(attackSpeed),
                CleanlinessHelper.alboe_mystic_armory$calculateAttackRange(attackRange),
                new Item.Settings().maxDamage(durability)));
        ITEMS_LIST.add(supplier);
        return supplier;
    }

    protected static RegistrySupplier<Item> registerItem(String id, Supplier<Item> itemSupplier) {
        RegistrySupplier<Item> supplier = ITEM.register(id, itemSupplier);
        ITEMS_LIST.add(supplier);
        return supplier;
    }

    public static void register() {
        ITEM.init();
    }
}
