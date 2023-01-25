package me.piguy.archaios.gui.hud

import com.mojang.blaze3d.systems.RenderSystem
import me.piguy.archaios.Archaios.MOD_ID
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback
import net.minecraft.client.MinecraftClient
import net.minecraft.client.gui.DrawableHelper.drawTexture
import net.minecraft.client.render.GameRenderer
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.Identifier

class HudOverlay : HudRenderCallback {
  override fun onHudRender(matrixStack: MatrixStack?, tickDelta: Float) {
    val mc = MinecraftClient.getInstance()!!

    val width = mc.window.scaledWidth
    val height = mc.window.scaledHeight

    val MANA_TEXTURE = Identifier(MOD_ID, "textures/gui/hud.png")

    RenderSystem.setShader { GameRenderer.getPositionTexProgram() }
    RenderSystem.setShaderColor(1f, 1f, 1f, 1f)
    RenderSystem.setShaderTexture(0, MANA_TEXTURE)

    // drawing the empty texture
    for (i in 1..10) {
      drawTexture(
        matrixStack, (width/2) + (i * 8) + 2 , +height - 49, 0f, 0f,
        9, 9, 64, 64
      )
    }
  }
}