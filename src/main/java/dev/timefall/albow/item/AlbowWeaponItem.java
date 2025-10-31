package dev.timefall.albow.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import dev.timefall.albow.registry.ItemRegistry;
import dev.timefall.albow.util.helper.CleanlinessHelper;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.Vanishable;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AlbowWeaponItem extends ToolItem implements Vanishable {

    @SuppressWarnings("FieldCanBeLocal")
    private final float attackDamage;
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    public AlbowWeaponItem(ToolMaterial material, int attackDamage, float attackSpeed, float attackRange, Settings settings) {
        super(material, settings);
        this.attackDamage = attackDamage + material.getAttackDamage();
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(
                EntityAttributes.GENERIC_ATTACK_DAMAGE,
                new EntityAttributeModifier(
                        ATTACK_DAMAGE_MODIFIER_ID,
                        "Attack Damage modifier",
                        this.attackDamage,
                        EntityAttributeModifier.Operation.ADDITION
                )
        );
        builder.put(
                EntityAttributes.GENERIC_ATTACK_SPEED,
                new EntityAttributeModifier(
                        ATTACK_SPEED_MODIFIER_ID,
                        "Attack Speed modifier",
                        attackSpeed,
                        EntityAttributeModifier.Operation.ADDITION
                )
        );
        if (FabricLoader.getInstance().isModLoaded("reach-entity-attributes")) {
            /* This code is to add reach to the player. This is understood to mean the distance the player can reach
             * to open chests, break blocks, etc.
             * Reach is disabled by default and can be changed in the CONFIG
             */
            //if (AlboeWeapons.CONFIG.alboe_mythic_armory$is_reach_enabled) {
            //    builder.put(
            //            ReachEntityAttributes.REACH,
            //            new EntityAttributeModifier(
            //                    "Reach modifier",
            //                    attackRange,
            //                    EntityAttributeModifier.Operation.ADDITION
            //            )
            //    );
            //}
            builder.put(
                    ReachEntityAttributes.ATTACK_RANGE,
                    new EntityAttributeModifier(
                            "Attack Range modifier",
                            attackRange,
                            EntityAttributeModifier.Operation.ADDITION
                    )
            );
        }
        this.attributeModifiers = builder.build();
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.MAINHAND ? attributeModifiers :
                super.getAttributeModifiers(slot);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isOf(ItemRegistry.DIVINITY_SHRAPNEL.get());
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        CleanlinessHelper.albow$tooltipHelper(stack, tooltip);
    }
}
