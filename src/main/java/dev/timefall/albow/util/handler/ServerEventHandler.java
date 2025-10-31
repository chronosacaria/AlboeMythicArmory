package dev.timefall.albow.util.handler;

import dev.timefall.albow.registry.StatusEffectsRegistry;
import net.fabricmc.fabric.api.event.player.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.TypedActionResult;

public class ServerEventHandler {
    public static void register() {
        UseEntityCallback.EVENT.register(((player, world, hand, entity, entityHitResult) -> {
            if (player.hasStatusEffect(StatusEffectsRegistry.STUNNED.value())) return ActionResult.FAIL;
            return ActionResult.PASS;
        }));

        UseBlockCallback.EVENT.register(((player, world, hand, blockHitResult) -> {
            if (player.hasStatusEffect(StatusEffectsRegistry.STUNNED.value())) return ActionResult.FAIL;
            return ActionResult.PASS;
        }));

        UseItemCallback.EVENT.register(((player, world, hand) -> {
            if (player.hasStatusEffect(StatusEffectsRegistry.STUNNED.value())) return TypedActionResult.fail(player.getStackInHand(hand));
            return TypedActionResult.pass(player.getStackInHand(hand));
        }));

        AttackEntityCallback.EVENT.register(((player, world, hand, entity, entityHitResult) -> {
            if (player.hasStatusEffect(StatusEffectsRegistry.STUNNED.value())) return ActionResult.FAIL;
            return ActionResult.PASS;
        }));

        AttackBlockCallback.EVENT.register(((player, world, hand, pos, direction) -> {
            if (player.hasStatusEffect(StatusEffectsRegistry.STUNNED.value())) return ActionResult.FAIL;
            return ActionResult.PASS;
        }));
    }
}
