package me.piguy.archaios.networking

import me.piguy.archaios.Archaios
import me.piguy.archaios.networking.packet.CastingC2SPacket
import me.piguy.archaios.networking.packet.ManaSyncS2CPacket
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking
import net.minecraft.util.Identifier

class ArchaiosMessages {
  companion object {
    var CASTING_ID = Identifier(Archaios.MOD_ID, "casting")
    var MANA_SYNC = Identifier(Archaios.MOD_ID, "mana_sync")


    fun registerC2SPackets() {
      ServerPlayNetworking.registerGlobalReceiver(CASTING_ID, CastingC2SPacket::receive);

    }

    fun registerS2CPackets() {
      ClientPlayNetworking.registerGlobalReceiver(MANA_SYNC, ManaSyncS2CPacket::receive)
    }


  }


}