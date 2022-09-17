package me.piguy.archaios.client

import me.piguy.archaios.utils.IEntityDataSaver
import me.piguy.archaios.utils.ManaData
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback
import net.minecraft.client.MinecraftClient
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.Formatting

class ManaHudOverlay : HudRenderCallback {
  override fun onHudRender(matrixStack: MatrixStack, tickDelta: Float) {
    val mc = MinecraftClient.getInstance()!!

    val width = mc.window.scaledWidth
    val height = mc.window.scaledHeight

    mc.textRenderer.drawWithShadow(
      matrixStack,
      "Mana: ${ManaData.getMana(mc.player as IEntityDataSaver)}",
      width / 2f,
      height - 54f,
      Formatting.AQUA.colorValue!!
    )
  }
}