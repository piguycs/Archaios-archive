package me.piguy.archaios.gui

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.item.ItemStack
import net.minecraft.screen.ScreenHandler

class ToolViseScreenHandler(syncId: Int, playerInventory: PlayerInventory) :
  ScreenHandler(ArchaiosScreenHandlers.TOOL_VISE_SCREEN_HANDLER, syncId) {


  companion object {
    fun new(syncId: Int, playerInventory: PlayerInventory): ToolViseScreenHandler {
      return ToolViseScreenHandler(syncId, playerInventory)
    }
  }

  override fun quickMove(player: PlayerEntity, slot: Int): ItemStack {
    return ItemStack.EMPTY
  }

  override fun canUse(player: PlayerEntity): Boolean {
    return true
  }
}