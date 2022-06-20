package me.piguy.archaios.mixins;

import me.piguy.archaios.Archaios;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
    @Inject(method = "tick", at = @At("HEAD"))
    public void tick(CallbackInfo ci) {
        Archaios.Companion.onTick();
    }

    @Inject(method = "joinWorld", at = @At("HEAD"))
    public void joinWorld(CallbackInfo ci) {
        Archaios.Companion.onWorldLoad();
    }
}
