package dev.timefall.alboemythicarmory.item;

import dev.timefall.alboemythicarmory.util.AlboeMythicArmoryStyles;
import dev.timefall.alboemythicarmory.util.CleanlinessHelper;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DivinityShrapnelItem extends Item {
    public DivinityShrapnelItem(Settings settings) {
        super(settings);
    }

    @Override
    public Text getName(ItemStack stack) {
        return Text.translatable(this.getTranslationKey(stack))
                .setStyle(AlboeMythicArmoryStyles.DIVINE_NAME.get());
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        CleanlinessHelper.alboe_mystic_armory$tooltipHelper(stack, tooltip);
    }
}
