package me.piguy.archaios

import me.piguy.archaios.config.ArchaiosConfig
import me.piguy.archaios.gui.CharacterScreen
import me.piguy.archaios.gui.hud.HudOverlay
import me.piguy.archaios.networking.ArchaiosClientNetworking
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback
import net.minecraft.client.MinecraftClient
import net.minecraft.client.option.KeyBinding
import net.minecraft.client.util.InputUtil
import org.lwjgl.glfw.GLFW


object ArchaiosClient : ClientModInitializer {

  val CONFIG = ArchaiosConfig.createAndLoad()

  override fun onInitializeClient() {

    ArchaiosClientNetworking.registerS2CPackets()

    HudRenderCallback.EVENT.register(HudOverlay())

    val key = KeyBindingHelper.registerKeyBinding(
      KeyBinding(
        "key.archaios.open",
        InputUtil.Type.KEYSYM,
        GLFW.GLFW_KEY_R,
        "category.archaios.test"
      )
    )

    ClientTickEvents.END_CLIENT_TICK.register(ClientTickEvents.EndTick { client: MinecraftClient ->
      while (key.wasPressed()) {
        client.setScreenAndRender(CharacterScreen())
//        client.setScreenAndRender(MyScreen.new())
      }
    })
  }
}