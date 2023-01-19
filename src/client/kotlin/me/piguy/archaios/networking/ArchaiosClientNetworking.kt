package me.piguy.archaios.networking

import me.piguy.archaios.Archaios
import me.piguy.archaios.networking.packets.ManaSyncS2CPacket
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking
import net.minecraft.util.Identifier

class ArchaiosClientNetworking {
  companion object {
    var CASTING_ID = Identifier(Archaios.MOD_ID, "casting")
    var MANA_SYNC = Identifier(Archaios.MOD_ID, "mana_sync")
    fun registerS2CPackets() {
      ClientPlayNetworking.registerGlobalReceiver(MANA_SYNC, ManaSyncS2CPacket::receive)
    }
  }
}