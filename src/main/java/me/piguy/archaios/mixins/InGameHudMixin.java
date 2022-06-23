package me.piguy.archaios.mixins;

import me.piguy.archaios.Archaios;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class InGameHudMixin {
  @Inject(method="render", at=@At("HEAD"))
  public void render(MatrixStack matrices, float tickDelta, CallbackInfo ci) {
    Archaios.Companion.onRender(matrices);
  }
}
