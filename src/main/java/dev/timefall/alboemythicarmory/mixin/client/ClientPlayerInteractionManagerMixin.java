package dev.timefall.alboemythicarmory.mixin.client;

import dev.timefall.alboemythicarmory.registry.StatusEffectsRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// TODO Remove once certain it is no longer needed
@Mixin(ClientPlayerInteractionManager.class)
public class ClientPlayerInteractionManagerMixin {

    @Inject(method = "interactEntity", at = @At("HEAD"), cancellable = true)
    public void interactEntity(PlayerEntity player, Entity entity, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        if (player.hasStatusEffect(StatusEffectsRegistry.STUNNED.value())) cir.setReturnValue(ActionResult.FAIL);
    }

    @Inject(method = "interactEntityAtLocation", at = @At("HEAD"), cancellable = true)
    public void interactEntityAtLocation(PlayerEntity player, Entity entity, EntityHitResult hitResult, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        if (player.hasStatusEffect(StatusEffectsRegistry.STUNNED.value())) cir.setReturnValue(ActionResult.FAIL);
    }

    @Inject(method = "interactBlock", at = @At("HEAD"), cancellable = true)
    public void interactBlock(ClientPlayerEntity player, Hand hand, BlockHitResult hitResult, CallbackInfoReturnable<ActionResult> cir) {
        if (player.hasStatusEffect(StatusEffectsRegistry.STUNNED.value())) cir.setReturnValue(ActionResult.FAIL);
    }

    @Inject(method = "interactItem", at = @At("HEAD"), cancellable = true)
    public void interactItem(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        if (player.hasStatusEffect(StatusEffectsRegistry.STUNNED.value())) cir.setReturnValue(ActionResult.FAIL);
    }

    @Inject(method = "attackEntity", at = @At("HEAD"), cancellable = true)
    public void attackEntity(PlayerEntity player, Entity target, CallbackInfo ci) {
        if (player.hasStatusEffect(StatusEffectsRegistry.STUNNED.value())) ci.cancel();
    }


    @Inject(method = "attackBlock", at = @At("HEAD"), cancellable = true)
    public void attackBlock(BlockPos pos, Direction direction, CallbackInfoReturnable<Boolean> cir) {
        ClientPlayerEntity clientPlayerEntity = MinecraftClient.getInstance().player;
        if (clientPlayerEntity != null && clientPlayerEntity.hasStatusEffect(StatusEffectsRegistry.STUNNED.value())) cir.setReturnValue(false);
    }
}
