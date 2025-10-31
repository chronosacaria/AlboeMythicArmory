package dev.timefall.albow.item;

import dev.timefall.albow.util.helper.AlboeMythicArmoryStylesHelper;
import dev.timefall.albow.util.helper.CleanlinessHelper;
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
                .setStyle(AlboeMythicArmoryStylesHelper.DIVINE_NAME.get());
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        CleanlinessHelper.albow$tooltipHelper(stack, tooltip);
    }
}
