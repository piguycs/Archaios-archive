package me.piguy.archaios.blocks.entity

import me.piguy.archaios.gui.AlchemyTableScreenHandler
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.item.ItemStack
import net.minecraft.network.PacketByteBuf
import net.minecraft.screen.NamedScreenHandlerFactory
import net.minecraft.screen.PropertyDelegate
import net.minecraft.screen.ScreenHandler
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.text.Text
import net.minecraft.util.collection.DefaultedList
import net.minecraft.util.math.BlockPos

class AlchemyTableBlockEntity(
  pos: BlockPos, state: BlockState?,
  override val inventory: DefaultedList<ItemStack> = DefaultedList.ofSize(3, ItemStack.EMPTY)
) : BlockEntity(
  ArchaiosBlockEntities.ALCHEMY_TABLE_BLOCK_ENTITY, pos,
  state
), ExtendedScreenHandlerFactory, ImplimentedInventory {

  val propertyDelegate: PropertyDelegate
  var progress = 0
  var maxProgress = 10

  init {
    propertyDelegate = object : PropertyDelegate {
      override fun get(index: Int): Int {
        return when (index) {
          0 -> this@AlchemyTableBlockEntity.progress
          1 -> this@AlchemyTableBlockEntity.maxProgress
          else -> 0
        }
      }

      override fun set(index: Int, value: Int) {
        when (index) {
          0 -> this@AlchemyTableBlockEntity.progress = value
          1 -> this@AlchemyTableBlockEntity.maxProgress = value
        }
      }

      override fun size(): Int {
        return 2
      }
    }
  }


  override fun createMenu(syncId: Int, inv: PlayerInventory, player: PlayerEntity): ScreenHandler {
    return AlchemyTableScreenHandler(syncId, inv, /*this, this.propertyDelegate */)
  }

  override fun getDisplayName(): Text {
    return Text.translatable("archaios.alchemy_table_screen")
  }



  override fun writeScreenOpeningData(player: ServerPlayerEntity, buf: PacketByteBuf) {
  }

}