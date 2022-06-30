package me.piguy.archaios.items.custom

import me.piguy.archaios.utils.interfaces.PlayerEntityInterface
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.text.Text
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World

class WandItem(settings: Settings?) : Item(settings) {
  override fun use(world: World?, user: PlayerEntity?, hand: Hand?): TypedActionResult<ItemStack> {
    if (world != null && user != null) {
      if (!world.isClient) {
        // execute on the server
        if (user is PlayerEntityInterface) {
          val mana = (user as PlayerEntityInterface).getMana()
          user.setMana(mana - 10)
        }
      }
    }


    return super.use(world, user, hand)
  }

  private fun outputUsage(user: PlayerEntity, mana: Int) {
    user.sendMessage(Text.literal("Used the wand $mana"))

  }

}