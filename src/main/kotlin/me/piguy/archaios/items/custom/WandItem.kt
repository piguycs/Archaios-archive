package me.piguy.archaios.items.custom

import me.piguy.archaios.utils.ManaData
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World

class WandItem : Item(SETTINGS) {
  companion object {
    val SETTINGS = FabricItemSettings()
  }

  override fun use(world: World, user: PlayerEntity, hand: Hand): TypedActionResult<ItemStack> {
    if (!world.isClient) {
      ManaData.castMana(user as ServerPlayerEntity, 1)
    }

    return super.use(world, user, hand)
  }

}