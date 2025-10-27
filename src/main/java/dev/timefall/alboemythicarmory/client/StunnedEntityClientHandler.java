package dev.timefall.alboemythicarmory.client;

import dev.timefall.alboemythicarmory.registry.StatusEffectsRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.input.Input;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;

@Environment(EnvType.CLIENT)
public class StunnedEntityClientHandler {
    
    public static void onClientTick(MinecraftClient client) {
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
    }
}
