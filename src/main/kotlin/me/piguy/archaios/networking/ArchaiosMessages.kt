package me.piguy.archaios.networking

import me.piguy.archaios.Archaios
import me.piguy.archaios.networking.packet.CastingC2SPacket
import me.piguy.archaios.networking.packet.ExampleC2SPacket
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking
import net.minecraft.util.Identifier

class ArchaiosMessages {
  companion object {
    var ABILITY_ID = Identifier(Archaios.MOD_ID, "casting")
    var MANA_SYNC = Identifier(Archaios.MOD_ID, "mana_sync")
    var EXAMPLE_ID = Identifier(Archaios.MOD_ID, "example")


    fun registerC2SPackets() {
      ServerPlayNetworking.registerGlobalReceiver(ABILITY_ID, CastingC2SPacket::receive);

    }

    fun registerS2CPackets() {

    }


  }


}