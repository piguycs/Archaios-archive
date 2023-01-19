package me.piguy.archaios.networking

import me.piguy.archaios.Archaios
import me.piguy.archaios.networking.packets.CastingC2SPacket
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking
import net.minecraft.util.Identifier

class ArchaiosServerNetworking {
  companion object {

    var CASTING_ID = Identifier(Archaios.MOD_ID, "casting")
    var MANA_SYNC = Identifier(Archaios.MOD_ID, "mana_sync")

    fun registerC2SPackets() {
      ServerPlayNetworking.registerGlobalReceiver(CASTING_ID, CastingC2SPacket::receive)
    }
  }

}