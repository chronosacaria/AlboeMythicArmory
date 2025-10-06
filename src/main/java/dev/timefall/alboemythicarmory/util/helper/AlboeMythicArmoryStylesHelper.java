package dev.timefall.alboemythicarmory.util.helper;

import net.minecraft.text.Style;
import net.minecraft.util.Colors;

public enum AlboeMythicArmoryStylesHelper {
    TOOLTIP(Style.EMPTY.withColor(Colors.GRAY)),
    DIVINE_NAME(Style.EMPTY.withColor(CleanlinessHelper.alboe_mystic_armory$toDecimalColor(253, 220, 92))),
    DIVINE_EFFECT(Style.EMPTY.withColor(CleanlinessHelper.alboe_mystic_armory$toDecimalColor(255, 123, 0)).withUnderline(true).withBold(true));

    private final Style style;

    AlboeMythicArmoryStylesHelper(Style style) {
        this.style = style;
    }

    public Style get() {
        return this.style;
    }
}
