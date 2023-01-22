package me.piguy.archaios.gui

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.item.ItemStack
import net.minecraft.network.PacketByteBuf
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.ScreenHandlerType
import net.minecraft.screen.slot.Slot

class AlchemyTableScreenHandler : ScreenHandler {

  companion object {
    fun new(syncId: Int, inventory: PlayerInventory, buf: PacketByteBuf): AlchemyTableScreenHandler? {
      return AlchemyTableScreenHandler(syncId , inventory, /* it, ArrayPropertyDelegate(2) */)
//      return inventory.player.world.getBlockEntity(buf.readBlockPos())?.let {
//        AlchemyTableScreenHandler(syncId /*, inventory, it, ArrayPropertyDelegate(2) */)
//      }
    }
  }


  constructor(type: ScreenHandlerType<*>, syncId: Int) : super(type, syncId)
  constructor(syncId: Int, inventory: PlayerInventory, /*entity: BlockEntity, delegate: PropertyDelegate */) : super(
    ArchaiosScreenHandlers.ALCHEMY_TABLE_SCREEN_HANDLER,
    syncId
  ) {

    addPlayerInventory(inventory)
    addPlayerHotbar(inventory)

  }

  override fun quickMove(player: PlayerEntity, slot: Int): ItemStack {
    return ItemStack.EMPTY
  }

  override fun canUse(player: PlayerEntity): Boolean {
    return true
  }

  private fun addPlayerInventory(playerInventory: PlayerInventory) {
    for (i in 0..2) {
      for (l in 0..8) {
        addSlot(Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18))
      }
    }
  }

  private fun addPlayerHotbar(playerInventory: PlayerInventory) {
    for (i in 0..8) {
      addSlot(Slot(playerInventory, i, 8 + i * 18, 142))
    }
  }

}