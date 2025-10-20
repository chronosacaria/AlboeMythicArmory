package dev.timefall.alboemythicarmory.util.handler;

import dev.timefall.alboemythicarmory.client.MarkedEntityParticleHandler;
import dev.timefall.alboemythicarmory.client.gui.hud.StunnedOverlay;
import dev.timefall.alboemythicarmory.registry.StatusEffectsRegistry;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.input.Input;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;

public class ClientEventHandler {
    public static void registerStartTickEvents() {
        // Start Client Tick Events
        ClientTickEvents.START_CLIENT_TICK.register(client -> {
            if (client.player == null) return;
            if (!client.player.hasStatusEffect(StatusEffectsRegistry.STUNNED.value())) return;

            KeyBinding[] keys = new KeyBinding[] {
                    client.options.forwardKey,
                    client.options.backKey,
                    client.options.leftKey,
                    client.options.rightKey,
                    client.options.jumpKey,
                    client.options.sneakKey,
                    client.options.sprintKey
            };
            for (KeyBinding keyBinding : keys) {
                if (keyBinding == null) continue;
                keyBinding.setPressed(false);
                //noinspection StatementWithEmptyBody (This is intentionally left empty)
                while (keyBinding.wasPressed()) { /* Do Nothing */ }
            }

            ClientPlayerEntity clientPlayerEntity = client.player;
            Input clientKeyInput = clientPlayerEntity.input;
            if (clientKeyInput != null) {
                clientKeyInput.movementForward = 0f;
                clientKeyInput.movementSideways = 0f;
                clientKeyInput.pressingForward = false;
                clientKeyInput.pressingBack = false;
                clientKeyInput.pressingLeft = false;
                clientKeyInput.pressingRight = false;
                clientKeyInput.jumping = false;
                clientKeyInput.sneaking = false;
            }
            clientPlayerEntity.setSprinting(false);
        });

        // Start World Tick Events
        ClientTickEvents.START_WORLD_TICK.register(MarkedEntityParticleHandler::onClientTick);
        // TODO Add handler for the StunnedEntityParticles
    }

    public static void registerOverlayEvents() {
        HudRenderCallback.EVENT.register(new StunnedOverlay());
    }
}
