package me.piguy.archaios.items.custom

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.ItemUsageContext
import net.minecraft.text.Text
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World

class WandItem(settings: Settings?) : Item(settings) {

  override fun use(world: World?, user: PlayerEntity?, hand: Hand?): TypedActionResult<ItemStack> {
    if (world != null) {
      if (!world.isClient) {
        // execute on the server

      }
    }

    return super.use(world, user, hand)
  }

  private fun sendOutput(player : PlayerEntity) {

  }

}