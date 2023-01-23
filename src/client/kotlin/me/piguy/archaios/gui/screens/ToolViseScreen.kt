package me.piguy.archaios.gui.screens

import io.wispforest.owo.ui.base.BaseOwoHandledScreen
import io.wispforest.owo.ui.component.ButtonComponent
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.FlowLayout
import io.wispforest.owo.ui.core.OwoUIAdapter
import io.wispforest.owo.ui.core.Sizing
import me.piguy.archaios.Archaios
import me.piguy.archaios.gui.ToolViseScreenHandler
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.text.Text
import java.util.function.Consumer


class ToolViseScreen(handler: ToolViseScreenHandler, inventory: PlayerInventory, title: Text) :
  BaseOwoHandledScreen<FlowLayout, ToolViseScreenHandler>(
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