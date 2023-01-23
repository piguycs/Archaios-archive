package me.piguy.archaios.blocks.entity.entities

import me.piguy.archaios.blocks.ArchaiosBlockEntities
import me.piguy.archaios.blocks.entity.ImplimentedInventory
import me.piguy.archaios.gui.ToolViseScreenHandler
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.Inventories
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound
import net.minecraft.network.PacketByteBuf
import net.minecraft.screen.NamedScreenHandlerFactory
import net.minecraft.screen.ScreenHandler
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.text.Text
import net.minecraft.util.collection.DefaultedList
import net.minecraft.util.math.BlockPos

class ToolViseBlockEntity(
  pos: BlockPos,
  state: BlockState,
  override val inventory: DefaultedList<ItemStack> = DefaultedList.ofSize(3, ItemStack.EMPTY)
) : BlockEntity(ArchaiosBlockEntities.TOOL_VISE_BLOCK_ENTITY, pos, state), ExtendedScreenHandlerFactory,
  ImplimentedInventory {
  override fun createMenu(syncId: Int, inv: PlayerInventory, player: PlayerEntity): ScreenHandler {
    return ToolViseScreenHandler(syncId, inv)
  }

  override fun getDisplayName(): Text {
    return Text.translatable("archaios.tool_vise_screen")
  }

  override fun writeScreenOpeningData(player: ServerPlayerEntity, buf: PacketByteBuf) {
  }

  override fun readNbt(nbt: NbtCompound) {
    super.readNbt(nbt)
    Inventories.readNbt(nbt, inventory)
  }

  override fun writeNbt(nbt: NbtCompound) {
    super.writeNbt(nbt)
    Inventories.writeNbt(nbt, inventory)
  }
}