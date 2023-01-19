package me.piguy.archaios.gui.hud

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback
import net.minecraft.client.MinecraftClient
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.text.OrderedText
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import java.awt.Color

class HudOverlay : HudRenderCallback {
  override fun onHudRender(matrixStack: MatrixStack?, tickDelta: Float) {
    val mc = MinecraftClient.getInstance()!!

    val width = mc.window.scaledWidth
    val height = mc.window.scaledHeight


    mc.textRenderer.drawWithShadow(matrixStack, "MANA", width / 2f, height - 54f, Formatting.BLUE.colorValue!!)

  }
}