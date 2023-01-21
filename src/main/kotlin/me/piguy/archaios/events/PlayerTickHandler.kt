package me.piguy.archaios.events

import me.piguy.archaios.networking.interfaces.IEntityDataSaver
import me.piguy.archaios.utils.ManaData
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents
import net.minecraft.server.MinecraftServer

class PlayerTickHandler: ServerTickEvents.StartTick {
  override fun onStartTick(server: MinecraftServer) {
    if (server.ticks % 60 == 0) {
      for (player in server.playerManager.playerList) {
        player as IEntityDataSaver
        if (ManaData.getMana(player) < ManaData.getMaxMana(player)) {
          ManaData.addMana(player, 1);
        }
      }
    }
  }
}