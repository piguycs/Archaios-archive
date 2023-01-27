package me.piguy.archaios.events

import me.piguy.archaios.utils.ManaData
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents
import net.minecraft.server.MinecraftServer


class ServerTickEvent : ServerTickEvents.StartTick {
  override fun onStartTick(server: MinecraftServer) {
    if (server.ticks % 60 == 0) {
      for (player in server.playerManager.playerList) {
        if (ManaData.getMana(player) < 10) {
          ManaData.addMana(player, 1)
        }
      }
    }
  }
}