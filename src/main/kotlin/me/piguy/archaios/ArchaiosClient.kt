package me.piguy.archaios

import me.piguy.archaios.events.InputHandler
import me.piguy.archaios.networking.ArchaiosMessages
import net.fabricmc.api.ClientModInitializer

class ArchaiosClient : ClientModInitializer {
  override fun onInitializeClient() {

    InputHandler.register()

    ArchaiosMessages.registerS2CPackets()
  }
}
