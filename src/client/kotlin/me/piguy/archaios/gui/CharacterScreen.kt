package me.piguy.archaios.gui

import com.mojang.authlib.GameProfile
import io.wispforest.owo.ui.base.BaseOwoScreen
import io.wispforest.owo.ui.component.ButtonComponent
import io.wispforest.owo.ui.component.Components
import io.wispforest.owo.ui.container.Containers
import io.wispforest.owo.ui.container.FlowLayout
import io.wispforest.owo.ui.core.*
import me.piguy.archaios.Archaios.logger
import net.minecraft.client.MinecraftClient
import net.minecraft.client.render.entity.model.PlayerEntityModel
import net.minecraft.entity.Entity
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.player.PlayerEntity
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




    val pl = mc.player as LivingEntity

//    pl.bodyYaw = (180 + mc.mouse.x * 20).toFloat()
//    pl.setYaw((180.0f + mc.mouse.x * 40.0f).toFloat())
//    pl.setPitch((-mc.mouse.y * 20.0f).toFloat())

    rootComponent
      .child(
        Containers.verticalFlow(Sizing.content(), Sizing.content())
          .child(
            Components.entity(
              Sizing.fixed(64),
              pl
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