package me.piguy.archaios.gui

import me.piguy.archaios.blocks.entity.AlchemyBenchEntity
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.Inventory
import net.minecraft.inventory.SimpleInventory
import net.minecraft.item.ItemStack
import net.minecraft.network.PacketByteBuf
import net.minecraft.screen.ArrayPropertyDelegate
import net.minecraft.screen.PropertyDelegate
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.ScreenHandlerType
import net.minecraft.screen.slot.Slot


class ArchaiosScreenHandler : ScreenHandler {

  val inventory: Inventory
  val propertyDelegate: PropertyDelegate
  val blockEntity: AlchemyBenchEntity

  constructor(syncID: Int, inv: PlayerInventory, entity: BlockEntity, delegate: PropertyDelegate) : super(
    ARCHAIOS_SCREEN_HANDLER, syncID
  ) {
    checkSize(entity as Inventory, 3)
    this.inventory = entity
    inventory.onOpen(inv.player)
    this.propertyDelegate = delegate
    this.blockEntity = entity as AlchemyBenchEntity

    this.addSlot((Slot(inventory, 0, 0, 0)))
    this.addSlot((Slot(inventory, 1, 0, 20)))
    this.addSlot((Slot(inventory, 2, 0, 40)))

    addProperties(delegate)
  }

  companion object {
    lateinit var ARCHAIOS_SCREEN_HANDLER: ScreenHandlerType<ArchaiosScreenHandler>
  }

  override fun quickMove(player: PlayerEntity, slot: Int): ItemStack {
    TODO("Not yet implemented")
  }


  override fun canUse(player: PlayerEntity): Boolean {
    return false
  }
}