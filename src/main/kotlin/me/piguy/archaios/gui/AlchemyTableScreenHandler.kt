package me.piguy.archaios.gui

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.Inventory
import net.minecraft.inventory.SimpleInventory
import net.minecraft.item.ItemStack
import net.minecraft.network.PacketByteBuf
import net.minecraft.screen.ArrayPropertyDelegate
import net.minecraft.screen.PropertyDelegate
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.slot.Slot

class AlchemyTableScreenHandler/*, entity: BlockEntity*/(
  syncId: Int,
  playerInventory: PlayerInventory/*, entity: BlockEntity*/,
  delegate: PropertyDelegate,
  blockInventory: Inventory
) : ScreenHandler(
  ArchaiosScreenHandlers.ALCHEMY_TABLE_SCREEN_HANDLER,
  syncId
) {

  val inv: Inventory;

  companion object {
    fun new(syncId: Int, inventory: PlayerInventory, buf: PacketByteBuf): AlchemyTableScreenHandler {
//      return AlchemyTableScreenHandler(syncId , inventory, /* it, ArrayPropertyDelegate(2) */)
      return AlchemyTableScreenHandler(
        syncId, inventory,
        /*,*/ ArrayPropertyDelegate(2),
        SimpleInventory(3)
      )
    }
  }


  init {

    checkSize(blockInventory, 3)

    this.inv = playerInventory

    blockInventory.onOpen(playerInventory.player)

    this.addSlot(Slot(blockInventory, 0, 22, 35)) // input
    this.addSlot(Slot(blockInventory, 1, 64, 35)) // input
    this.addSlot(Slot(blockInventory, 2, 120, 35)) // output

    addPlayerInventory(playerInventory)
    addPlayerHotbar(playerInventory)
  }

  override fun quickMove(player: PlayerEntity, invSlot: Int): ItemStack {
    var newStack = ItemStack.EMPTY
    val slot = slots[invSlot]
    if (slot.hasStack()) {
      val originalStack = slot.stack
      newStack = originalStack.copy()
      if (invSlot < this.inv.size()) {
        if (!insertItem(originalStack, this.inv.size(), slots.size, true)) {
          return ItemStack.EMPTY
        }
      } else if (!insertItem(originalStack, 0, this.inv.size(), false)) {
        return ItemStack.EMPTY
      }
      if (originalStack.isEmpty) {
        slot.stack = ItemStack.EMPTY
      } else {
        slot.markDirty()
      }
    }

    return newStack!!
  }

  override fun canUse(player: PlayerEntity): Boolean {
    return inv.canPlayerUse(player)
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