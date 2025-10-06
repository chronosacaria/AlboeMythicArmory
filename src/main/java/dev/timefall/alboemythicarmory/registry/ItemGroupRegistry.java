package dev.timefall.alboemythicarmory.registry;

import dev.timefall.alboemythicarmory.ModConstants;
import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import me.fzzyhmstrs.fzzy_config.util.platform.Registrar;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;

@SuppressWarnings("UnstableApiUsage")
public class ItemGroupRegistry {
    private static final Registrar<ItemGroup> ITEM_GROUP = ConfigApiJava.platform().createRegistrar(ModConstants.MOD_ID, Registries.ITEM_GROUP);

    public static void register() {
        ModConstants.LOGGER.info("Initializing Item Groups from " + ModConstants.MOD_NAME);
        ITEM_GROUP.init();
        ITEM_GROUP.register(
                "weapons",
                () -> ItemGroup.create(null, -1)
                        .displayName(Text.translatable("itemGroup.alboe_mythic_armory.weapons"))
                        .icon(() -> ItemRegistry.DIVINITY_SHRAPNEL.get().getDefaultStack())
                        .entries((displayContext, entries) -> ItemRegistry.ITEMS_LIST.forEach(s -> entries.add(s.get())))
                        .build());
    }
}
