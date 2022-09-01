package me.piguy.archaios.networking.packet

import net.fabricmc.fabric.api.networking.v1.PacketSender
import net.minecraft.block.Blocks
import net.minecraft.network.PacketByteBuf
import net.minecraft.server.MinecraftServer
import net.minecraft.server.network.ServerPlayNetworkHandler
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.server.world.ServerWorld
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvents
import net.minecraft.text.Style
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import net.minecraft.util.math.BlockPos

class CastingC2SPacket {
  companion object {
    fun receive(
      server: MinecraftServer, player: ServerPlayerEntity, handler: ServerPlayNetworkHandler,
      buf: PacketByteBuf, responseSender: PacketSender
    ) {
      val world = player.world as ServerWorld
      var isAroundQuartz = BlockPos.stream(player.boundingBox.expand(2.0))
        .map(world::getBlockState)
        .filter { it.isOf(Blocks.QUARTZ_BLOCK) }.toArray().isNotEmpty()


      if (isAroundQuartz) {
        player.sendMessage(
          Text.literal("Casted arcane")
            .fillStyle(Style.EMPTY.withColor(Formatting.AQUA)),
          true
        )
        world.playSound(
          null, player.blockPos, SoundEvents.ENTITY_ENDERMAN_TELEPORT,
          SoundCategory.PLAYERS, 0.5F, world.random.nextFloat() * 0.1f + 0.9f
        )

      } else {
        player.sendMessage(
          Text.literal("No Arcane nearby")
            .fillStyle(Style.EMPTY.withColor(Formatting.RED)),
          true
        )

      }


    }
  }
}