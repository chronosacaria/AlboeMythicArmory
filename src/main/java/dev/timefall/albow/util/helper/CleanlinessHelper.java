package dev.timefall.albow.util.helper;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.math.random.Random;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;

public class CleanlinessHelper {
    public static final Random RANDOM = Random.create();

    /*
     * TOOLTIP HELPER METHODS
     */
    @Environment(EnvType.CLIENT)
    public static void albow$tooltipHelper(ItemStack stack, List<Text> tooltip) {
        String itemPath = Registries.ITEM.getId(stack.getItem()).getPath();
        String base = "tooltip_info_item.alboe_mythic_armory." + itemPath;

        boolean printedAnyEffect = false;

        if (base.contains("alboe_mythic_armory")) {
            for (int effectNumber = 1;
                 I18n.hasTranslation(base + "_divine_effect.name_" + effectNumber);
                 effectNumber++) {
                    printedAnyEffect = true;

                    // Divine Effect Name
                    tooltip.add(
                            Text.translatable(base + "_divine_effect.name_" + effectNumber)
                                    .setStyle(AlboeMythicArmoryStylesHelper.DIVINE_EFFECT.get()));

                    // Divine Effect Descriptions
                    for (int descriptionNumber = 1;
                         I18n.hasTranslation(base + "_divine_effect.name_" + effectNumber + ".description_" + descriptionNumber);
                         descriptionNumber++) {
                            albow$addLangMultiline(
                                    tooltip,
                                    base + "_divine_effect.name_" + effectNumber + ".description_" + descriptionNumber,
                                    AlboeMythicArmoryStylesHelper.TOOLTIP.get());
                    }
            }

            // Conditional Line Break
            boolean hasPlainItemLines = I18n.hasTranslation(base + "_1");
            if (printedAnyEffect && hasPlainItemLines) tooltip.add(Text.empty());

            // Non-Divine Effect Tooltips
            for (int line = 1; I18n.hasTranslation(base + "_" + line); line++) {
                albow$addLangMultiline(
                        tooltip,
                        base + "_" + line,
                        AlboeMythicArmoryStylesHelper.TOOLTIP.get()
                );
            }
        }
    }

    @Environment(EnvType.CLIENT)
    private static void albow$addLangMultiline(List<Text> tooltip, String key, Style style) {
        if (!I18n.hasTranslation(key)) return;

        String raw = I18n.translate(key);
        String[] lines = raw.split("\\\\n", -1);

        for (String line : lines) {
            if (line.isEmpty()) tooltip.add(Text.empty());
            else tooltip.add(Text.literal(line).setStyle(style));
        }
    }

    /*
     * CALCULATION HELPER METHODS
     */

    public static float albow$calculateAttackSpeed(float desiredAttackSpeed) {
        return desiredAttackSpeed - 4.0F;
    }

    public static int albow$calculateAttackDamage(int desiredAttackDamage, ToolMaterial material) {
        return desiredAttackDamage - (1 + Math.round(material.getAttackDamage()));
    }

    public static float albow$calculateAttackRange(float desiredAttackRange) {
        return desiredAttackRange - 2.5f;
    }

    public static int albow$calculateTicksFromSeconds(int seconds) {
        return Math.multiplyExact(20, seconds);
    }

    public static boolean percentToOccur(int chance) {
        return RANDOM.nextInt(100) < chance;
    }

    /**
     * Checks if a living entity has any armor equipped in any slot.
     * @param entity The living entity to check
     * @return true if the entity has any armor equipped, false otherwise
     */
    public static boolean hasAnyArmorEquipped(LivingEntity entity) {
        return !entity.getEquippedStack(EquipmentSlot.HEAD).isEmpty()
                || !entity.getEquippedStack(EquipmentSlot.CHEST).isEmpty()
                || !entity.getEquippedStack(EquipmentSlot.LEGS).isEmpty()
                || !entity.getEquippedStack(EquipmentSlot.FEET).isEmpty();
    }

    /**
     * Takes a rgb input and translates it to a singular decimal number
     *
     * @param red The red value of the color (0 -> 255)
     * @param green The green value of the pixel (0 -> 255)
     * @param blue The blue value of the pixel (0 -> 255)
     * @return A decimal value denoting the color input
     */
    public static int albow$toDecimalColor(int red, int green, int blue) {
        return (red << 16) | (green << 8) | blue;
    }

    /**
     * Turns a time config option (in ticks) and turns it into a String value (of seconds).
     * @param ticks The time in ticks.
     * @return The time as a String in seconds.
     */
    public static String albow$ticksToSeconds(float ticks) {
        float seconds = ticks / 20f;
        return new DecimalFormat("#.##").format(seconds);
    }

    /**
     * Turns a multiplier config option (in decimal) and turns it into a String value (of a percentage).
     * Does not include the % sign.
     * @param decimal The multiplier in decimal.
     * @return The multiplier as a String percentage.
     */
    public static String albow$decimalToPercentage(float decimal) {
        float percentage = decimal * 100;
        return new DecimalFormat("#.##").format(percentage);
    }

    /**
     * Checks whether an entity is holding an item in one of their hands. If an item is two-handed, only checks if it is held in the Main Hand
     * @param entity The entity being tested.
     * @param item The item to check whether the entity is holding.
     * @param isTwoHanded Whether the item is one-handed (and CAN be held in the offhand) or is two-handed and cannot.
     * @return True if the entity is holding the item.
     */
    public static boolean albow$isHolding(LivingEntity entity, Item item, boolean isTwoHanded) {
        return isTwoHanded ? entity.getMainHandStack().getItem() == item : entity.isHolding(item);
    }

    /**
     * Similar to the other <code>isHolding</code> method, except this one checks for an exact itemStack instead.
     * @param entity The entity being tested.
     * @param itemStack The exact itemStack to check whether the entity is holding.
     * @param isTwoHanded Whether the item is one-handed (and CAN be held in the offhand) or is two-handed and cannot.
     * @return True if the entity is holding the exact itemStack.
     */
    public static boolean albow$isHolding(LivingEntity entity, ItemStack itemStack, boolean isTwoHanded) {
        if(entity.getMainHandStack().equals(itemStack)) return true;
        return !isTwoHanded && entity.getOffHandStack().equals(itemStack);
    }

    /**
     * Interpolates a value along a sine wave, oscillating between <code>middle - bound</code> and <code>middle + bound</code>.
     * @param progress A decimal value that determines the position along the sine wave. This value is normalized to the range [0,1).
     *                 <ul>
     *                   <li>At 0.00, the return value equals <code>middle</code></li>
     *                   <li>At 0.25, the return value equals <code>middle + bound</code></li>
     *                   <li>At 0.50, the return value equals <code>middle</code></li>
     *                   <li>At 0.75, the return value equals <code>middle - bound</code></li>
     *                   <li>At 1.00, the return value equals <code>middle</code></li>
     *                 </ul>
     * @param middle The midpoint of the sine wave.
     * @param bound The amplitude of the sine wave.
     * @return The interpolated value.
     */
    public static double albow$sinInterpol(float progress, double middle, double bound) {
        double normalisedValue = Math.sin(progress * 2 * Math.PI);

        return middle + (normalisedValue * bound);
    }

    /**
     * Creates a multiplier from the player's spell scaling if the Spell Power Attributes mod is present (which it should almost always be).
     *
     * <p>If multiple spell schools are provided, their values are added together. Specifying the same school multiple times will apply its modifier multiple times.</p>
     *
     * //@param player The player whose spell scaling attributes are being used to scale.
     * //@param coefficient  A multiplier applied to each school's spell power before being added to the total.
     * //@param schools The schools to scale from.
     * //@return A double value acting as a multiplier, scaled using the player's spell attributes.
     */

    /*
    public static float albow$getScale(PlayerEntity player, float coefficient, @NotNull SpellSchool... schools) {
        if(player == null) {
            return 1f;
        }

        if (FabricLoader.getInstance().isModLoaded("spell_power")) {
            double power = 1f;

            for(SpellSchool school : schools) {
                power += coefficient * SpellPower.getSpellPower(school, player).randomValue();
            }

            return (float) power;
        }

        return 1f;
    }
    */
    
    public static String albow$entityTypeToLowercaseName(EntityType<?> entityType, int numberOfCharsRemoved) {
        return entityType.getTranslationKey().substring(numberOfCharsRemoved).toLowerCase(Locale.ROOT);
    }
}
