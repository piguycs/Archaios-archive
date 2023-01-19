package me.piguy.archaios.gui

import io.wispforest.owo.ui.base.BaseOwoScreen
import io.wispforest.owo.ui.component.ButtonComponent
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.FlowLayout
import io.wispforest.owo.ui.core.*
import me.piguy.archaios.Archaios.logger
import net.minecraft.client.MinecraftClient
import org.jetbrains.annotations.NotNull
import java.util.function.Consumer


class CharacterScreen : BaseOwoScreen<FlowLayout>() {
  val mc = MinecraftClient.getInstance()

  override fun shouldPause(): Boolean {
    return false
  }

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
            Components.entity(
              Sizing.fixed(64),
              mc.player
            )
              .lookAtCursor(true)
              .allowMouseRotation(true)
              .scaleToFit(true)
          )
          .padding(Insets.of(10))
          .surface(Surface.DARK_PANEL)
          .verticalAlignment(VerticalAlignment.CENTER)
          .horizontalAlignment(HorizontalAlignment.CENTER)
      )
  }
}