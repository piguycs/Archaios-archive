package me.piguy.archaios

import me.piguy.archaios.client.ManaHudOverlay
import me.piguy.archaios.events.InputHandler
import me.piguy.archaios.networking.ArchaiosMessages
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback

class ArchaiosClient : ClientModInitializer {
  override fun onInitializeClient() {

    InputHandler.register()

    ArchaiosMessages.registerS2CPackets()

    HudRenderCallback.EVENT.register(ManaHudOverlay())

  }
}
