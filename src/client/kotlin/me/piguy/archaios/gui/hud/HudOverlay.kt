package me.piguy.archaios.gui.hud

import me.piguy.archaios.gui.MyFirstScreen
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback
import net.minecraft.client.MinecraftClient
import net.minecraft.client.util.math.MatrixStack

class HudOverlay : HudRenderCallback {
  override fun onHudRender(matrixStack: MatrixStack?, tickDelta: Float) {
    val mc = MinecraftClient.getInstance()!!

    val width = mc.window.scaledWidth
    val height = mc.window.scaledHeight

    val sc = MyFirstScreen()

    sc.render(matrixStack, 0, 0, 0f)
  }
}