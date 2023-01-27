package me.piguy.archaios.utils

import me.piguy.archaios.Archaios
import me.piguy.archaios.networking.ManaSyncPacket
import me.piguy.archaios.utils.interfaces.IEntityDataSaver
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.text.Text


class ManaData {

  companion object {
    fun getMana(player: ServerPlayerEntity): Int {
      if (player is IEntityDataSaver) {
        val nbt = player.getPersistentData()
        return nbt.getInt("archaios.mana")
      }

      player.sendMessage(Text.literal("Player is not of type IEntityDataSaver"))
      Archaios.logger.info("Player is not of type IEntityDataSaver")
      return -1
    }

    fun getMana(player: IEntityDataSaver): Int {
      val nbt = player.getPersistentData()
      return nbt.getInt("archaios.mana")
    }

    fun setMana(player: ServerPlayerEntity, amount: Int) {
      if (player is IEntityDataSaver && amount >= 0 && amount <= 10) {
        val nbt = player.getPersistentData()
        nbt.putInt("archaios.mana", amount)
      }

      syncData(player, amount)
    }

    fun setMana(player: IEntityDataSaver, amount: Int) {
      val nbt = player.getPersistentData()
      nbt.putInt("archaios.mana", amount)

      if (player is ServerPlayerEntity) {
        syncData(player, amount)
      } else {
        Archaios.logger.warn("Player is not of type ServerPlayerEntity, cant call syncData")
      }

    }

    fun addMana(player: ServerPlayerEntity, amount: Int) {
      setMana(player, amount + getMana(player))
    }

    fun syncData(player: ServerPlayerEntity, amount: Int) {
      Archaios.ARCHAIOS_CHANNEL.serverHandle(player).send(
        ManaSyncPacket(
          amount
        )
      )
    }

    fun castMana(player: ServerPlayerEntity, cost: Int) {
      if (player is IEntityDataSaver) {
        val nbt = player.getPersistentData()

        val currMana = getMana(player as IEntityDataSaver)


        if (cost <= currMana) {
          val mana = currMana - cost
          nbt.putInt("archaios.mana", mana)
          syncData(player, mana)
        } else {
          player.sendMessage(Text.of("Not enough mana"), true)
        }


      } else {
        Archaios.logger.warn("Player is not of type IEntityDataSaver, cant reduce mana")
      }
    }

  }

}