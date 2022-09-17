package me.piguy.archaios.networking.packet

import me.piguy.archaios.utils.IEntityDataSaver
import net.fabricmc.fabric.api.networking.v1.PacketSender
import net.minecraft.client.MinecraftClient
import net.minecraft.client.network.ClientPlayNetworkHandler
import net.minecraft.network.PacketByteBuf


class ManaSyncS2CPacket {
  companion object {
    fun receive(
      client: MinecraftClient, handler: ClientPlayNetworkHandler?,
      buf: PacketByteBuf, responseSender: PacketSender?
    ) {
      if (client.player != null) {
        (client.player as IEntityDataSaver).getPersistentData().putInt("mana", buf.readInt())
      }
    }
  }
}