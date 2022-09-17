package me.piguy.archaios.events

import me.piguy.archaios.networking.ArchaiosMessages
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs
import net.minecraft.client.option.KeyBinding
import net.minecraft.client.util.InputUtil
import org.lwjgl.glfw.GLFW

class InputHandler {

  companion object {
    private var KEY_CATEGORY = "key.archaios.category.archaios"
    private var KEY_ABILITY = "key.archaios.ability"

    private var drinkingKey: KeyBinding? = null


    private fun registerKeyInputs() {
      ClientTickEvents.END_CLIENT_TICK.register {
        if (drinkingKey?.wasPressed() == true) {
//          ClientPlayNetworking.send(ArchaiosMessages.EXAMPLE_ID, PacketByteBufs.create())
          ClientPlayNetworking.send(ArchaiosMessages.CASTING_ID, PacketByteBufs.create())
        }
      }
    }

    fun register() {
      drinkingKey = KeyBindingHelper.registerKeyBinding(
        KeyBinding(
          KEY_ABILITY,
          InputUtil.Type.KEYSYM,
          GLFW.GLFW_KEY_LEFT_ALT,
          KEY_CATEGORY
        )
      )

      registerKeyInputs()

    }
  }

}