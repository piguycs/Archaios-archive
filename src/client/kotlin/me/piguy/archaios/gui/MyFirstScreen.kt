package me.piguy.archaios.gui

import io.wispforest.owo.ui.base.BaseOwoScreen
import io.wispforest.owo.ui.component.ButtonComponent
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.FlowLayout
import io.wispforest.owo.ui.core.*
import me.piguy.archaios.Archaios.logger
import net.minecraft.text.Text
import org.jetbrains.annotations.NotNull
import java.awt.Button
import java.util.function.Consumer


class MyFirstScreen : BaseOwoScreen<FlowLayout>() {
  @NotNull
  override fun createAdapter(): OwoUIAdapter<FlowLayout> {
    return OwoUIAdapter.create(this, Containers::verticalFlow)
  }

  override fun build(rootComponent: FlowLayout) {

    val display: Consumer<ButtonComponent> = Consumer<ButtonComponent> { _ -> logger.info("Hello") }

    rootComponent
      .surface(Surface.VANILLA_TRANSLUCENT)
      .horizontalAlignment(HorizontalAlignment.CENTER)
      .verticalAlignment(VerticalAlignment.CENTER);

    rootComponent
      .child(
        Containers.verticalFlow(Sizing.content(), Sizing.content())
          .child(
            Components.button(
              Text.literal("A Button"),
              display
            )
          )
          .padding(Insets.of(10))
          .surface(Surface.DARK_PANEL)
          .verticalAlignment(VerticalAlignment.CENTER)
          .horizontalAlignment(HorizontalAlignment.CENTER)
      )
  }
}