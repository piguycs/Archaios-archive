package me.piguy.archaios.networking.packet

import net.fabricmc.fabric.api.networking.v1.PacketSender
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnReason
import net.minecraft.network.PacketByteBuf
import net.minecraft.server.MinecraftServer
import net.minecraft.server.network.ServerPlayNetworkHandler
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.server.world.ServerWorld

class ExampleC2SPacket {

  companion object {


    fun receive(
      server: MinecraftServer, player: ServerPlayerEntity, handler: ServerPlayNetworkHandler,
      buf: PacketByteBuf, responseSender: PacketSender
    ) {
      // happens on the server
      EntityType.CAT.spawn(
        player.world as ServerWorld?, null, null, player,
        player.blockPos, SpawnReason.TRIGGERED, true, false
      )
    }
  }
}