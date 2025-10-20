package dev.timefall.alboemythicarmory.client.gui.hud;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.timefall.alboemythicarmory.ModConstants;
import dev.timefall.alboemythicarmory.registry.StatusEffectsRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class StunnedOverlay implements HudRenderCallback {
    private static final Identifier STUNNED_TEXTURE = new Identifier(ModConstants.MOD_ID, "textures/misc/stunned_outline.png");
    private static final MinecraftClient CLIENT = MinecraftClient.getInstance();

    @Override
    public void onHudRender(DrawContext context, float tickDelta) {
        ClientPlayerEntity player = CLIENT.player;
        if (player == null) return;

        StatusEffectInstance effect = player.getStatusEffect(StatusEffectsRegistry.STUNNED.value());
        if (effect == null) return;

        int width = context.getScaledWindowWidth();
        int height = context.getScaledWindowHeight();
        float progress = (float)effect.getDuration() / 40;
        float alpha = MathHelper.clamp(0.7f * progress, 0.1f, 0.7f);

        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();

        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, alpha);
        RenderSystem.setShaderTexture(0, STUNNED_TEXTURE);

        float scale = 1.0f + (float)Math.sin(player.age * 0.1f) * 0.05f;
        int scaledWidth = (int)(width * scale);
        int scaledHeight = (int)(height * scale);
        int offsetX = (width - scaledWidth) / 2;
        int offsetY = (height - scaledHeight) / 2;

        context.drawTexture(
                STUNNED_TEXTURE,
                offsetX,
                offsetY,
                0,
                0,
                scaledWidth,
                scaledHeight,
                scaledWidth,
                scaledHeight
        );

        RenderSystem.disableBlend();
        RenderSystem.depthMask(true);
        RenderSystem.enableDepthTest();
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
    }
}
