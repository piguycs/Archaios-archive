package me.piguy.archaios.gui.screens

import com.mojang.blaze3d.systems.RenderSystem
import io.wispforest.owo.ui.base.BaseOwoHandledScreen
import io.wispforest.owo.ui.component.ButtonComponent
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.FlowLayout
import io.wispforest.owo.ui.core.OwoUIAdapter
import io.wispforest.owo.ui.core.Sizing
import me.piguy.archaios.Archaios
import me.piguy.archaios.Archaios.MOD_ID
import me.piguy.archaios.gui.AlchemyTableScreenHandler
import net.minecraft.client.render.GameRenderer
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import java.util.function.Consumer


class AlchemyTableScreen(handler: AlchemyTableScreenHandler, inventory: PlayerInventory, title: Text) :
  BaseOwoHandledScreen<FlowLayout, AlchemyTableScreenHandler>(
    handler, inventory, title
  ) {

  override fun createAdapter(): OwoUIAdapter<FlowLayout> {
    return OwoUIAdapter.create(this, Containers::verticalFlow)
  }


  override fun drawForeground(matrices: MatrixStack?, mouseX: Int, mouseY: Int) {
    textRenderer.draw(matrices, title, titleX.toFloat(), titleY.toFloat(), 0xAAAAAA)
    textRenderer.draw(
      matrices,
      this.playerInventoryTitle,
      playerInventoryTitleX.toFloat(),
      playerInventoryTitleY.toFloat(),
      0xAAAAAA
    )
  }


  val TEXTURE = Identifier(MOD_ID, "textures/gui/alchemy_table.png")
  override fun drawBackground(matrices: MatrixStack?, delta: Float, mouseX: Int, mouseY: Int) {
    RenderSystem.setShader { GameRenderer.getPositionTexProgram() }
    RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f)
    RenderSystem.setShaderTexture(0, TEXTURE)
    val x = (width - backgroundWidth) / 2
    val y = (height - backgroundHeight) / 2
    drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight)

    super.drawBackground(matrices, delta, mouseX, mouseY)
  }

  override fun build(rootComponent: FlowLayout) {
    val display: Consumer<ButtonComponent> = Consumer<ButtonComponent> { _ -> Archaios.logger.info("Hello") }


    rootComponent
      .child(
        Containers.verticalFlow(Sizing.fixed(178), Sizing.fixed(166))
          .child(
            Components.button(Text.of("Press Me"), display)
          )
      )
  }
}