package me.piguy.archaios.events

import net.fabricmc.fabric.api.networking.v1.ServerLoginConnectionEvents
import net.minecraft.server.MinecraftServer
import net.minecraft.server.network.ServerLoginNetworkHandler


class EventHandler {

  fun commonEvents() {
    ServerLoginConnectionEvents.INIT.register(ServerLoginConnectionEvents.Init { handler: ServerLoginNetworkHandler?, server: MinecraftServer ->

    })
  }


}