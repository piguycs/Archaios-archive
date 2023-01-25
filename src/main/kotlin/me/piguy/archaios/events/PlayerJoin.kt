package me.piguy.archaios.events

import me.piguy.archaios.Archaios
import me.piguy.archaios.utils.ManaData
import net.fabricmc.fabric.api.networking.v1.PacketSender
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents
import net.minecraft.server.MinecraftServer
import net.minecraft.server.network.ServerPlayNetworkHandler

class PlayerJoin : ServerPlayConnectionEvents.Join {
  override fun onPlayReady(handler: ServerPlayNetworkHandler, sender: PacketSender, server: MinecraftServer) {
    Archaios.logger.info("Player joined so syncing mana")
    val mana = ManaData.getMana(handler.player)
    ManaData.syncData(handler.player, mana)
  }
}