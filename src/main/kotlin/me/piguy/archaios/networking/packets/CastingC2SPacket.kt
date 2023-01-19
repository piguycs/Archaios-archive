package me.piguy.archaios.networking.packets

import me.piguy.archaios.networking.interfaces.IEntityDataSaver
import me.piguy.archaios.utils.ManaData
import net.fabricmc.fabric.api.networking.v1.PacketSender
import net.minecraft.network.PacketByteBuf
import net.minecraft.server.MinecraftServer
import net.minecraft.server.network.ServerPlayNetworkHandler
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.server.world.ServerWorld
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvents

class CastingC2SPacket {
  companion object {
    fun receive(
      server: MinecraftServer, player: ServerPlayerEntity, handler: ServerPlayNetworkHandler,
      buf: PacketByteBuf, responseSender: PacketSender
    ) {
      if (player !is IEntityDataSaver) return

      val world = player.world as ServerWorld

      val canCast = checkCanCast(player)

      if (canCast) {

        ManaData.addMana(player, -5)

//        player.sendMessage(
//          Text.literal("Casted arcane ${ManaData.getMana(player)}")
//            .fillStyle(Style.EMPTY.withColor(Formatting.AQUA)),
//          true
//        )
        world.playSound(
          null, player.blockPos, SoundEvents.ENTITY_ENDERMAN_TELEPORT,
          SoundCategory.PLAYERS, 0.5F, world.random.nextFloat() * 0.1f + 0.9f
        )

      } else {
//        player.sendMessage(
//          Text.literal("Out of mana ${ManaData.getMana(player)}")
//            .fillStyle(Style.EMPTY.withColor(Formatting.RED)),
//          true
//        )


        world.playSound(
          null, player.blockPos, SoundEvents.ITEM_BOTTLE_EMPTY,
          SoundCategory.PLAYERS, 0.5F, world.random.nextFloat() * 0.1f + 0.9f
        )


        ManaData.syncMana(player, player.getPersistentData().getInt("mana"))
      }
    }

    private fun checkCanCast(player: ServerPlayerEntity, amount: Int = -5): Boolean {
      return if (player is IEntityDataSaver) {
        val mana = ManaData.getMana(player)
        (mana + amount) in 0..10
      } else {
        false
      }
    }


  }
}