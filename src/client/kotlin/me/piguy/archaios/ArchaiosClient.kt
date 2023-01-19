package me.piguy.archaios

import me.piguy.archaios.config.ArchaiosConfig
import me.piguy.archaios.gui.MyFirstScreen
import me.piguy.archaios.gui.MyScreen
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
import net.minecraft.client.MinecraftClient
import net.minecraft.client.option.KeyBinding
import net.minecraft.client.util.InputUtil
import org.lwjgl.glfw.GLFW


object ArchaiosClient : ClientModInitializer {

  val CONFIG = ArchaiosConfig.createAndLoad()

  override fun onInitializeClient() {
    // This entrypoint is suitable for setting up client-specific logic, such as rendering.
    val key = KeyBindingHelper.registerKeyBinding(
      KeyBinding(
        "key.archaios.open",  // The translation key of the keybinding's name
        InputUtil.Type.KEYSYM,  // The type of the keybinding, KEYSYM for keyboard, MOUSE for mouse.
        GLFW.GLFW_KEY_R,  // The keycode of the key
        "category.archaios.test" // The translation key of the keybinding's category.
      )
    )

    ClientTickEvents.END_CLIENT_TICK.register(ClientTickEvents.EndTick { client: MinecraftClient ->
      while (key.wasPressed()) {
//        client.setScreenAndRender(MyFirstScreen())
        client.setScreenAndRender(MyScreen.new())
      }
    })
  }
}