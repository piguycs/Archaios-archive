package me.piguy.archaios.utils

import me.piguy.archaios.networking.ArchaiosServerNetworking
import me.piguy.archaios.networking.interfaces.IEntityDataSaver
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking
import net.minecraft.server.network.ServerPlayerEntity

object ManaData {
  fun addMana(player: IEntityDataSaver, amount: Int): Int {

    val mana = getMana(player)
    val newMana = mana + amount

    if (newMana in 0..10) {
      setMana(player, newMana)
    }

    return getMana(player);
  }

  fun getMana(player: IEntityDataSaver): Int {
    val nbt = player.getPersistentData()
    val mana = nbt.getInt("mana")

    return mana
  }


  private fun setMana(player: IEntityDataSaver, amount: Int) {
    val nbt = player.getPersistentData()
    nbt.putInt("mana", amount)

    syncMana(player as ServerPlayerEntity, amount)
  }

  fun getMaxMana(player: IEntityDataSaver): Int {
    return 10;
  }

  fun syncMana(player: ServerPlayerEntity, mana: Int) {
    val buffer = PacketByteBufs.create()
    buffer.writeInt(mana)
    ServerPlayNetworking.send(player, ArchaiosServerNetworking.MANA_SYNC, buffer)
  }

}