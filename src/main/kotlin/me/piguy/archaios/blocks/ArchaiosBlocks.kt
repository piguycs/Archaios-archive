package me.piguy.archaios.blocks

import io.wispforest.owo.registration.reflect.BlockRegistryContainer
import me.piguy.archaios.blocks.custom.AlchemyTable
import me.piguy.archaios.blocks.custom.ToolVise
import me.piguy.archaios.items.ArchaiosGroup
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.block.Block
import net.minecraft.item.BlockItem

class ArchaiosBlocks : BlockRegistryContainer {
  companion object {
    @JvmField
    var ALCHEMY_TABLE = AlchemyTable()

    @JvmField
    var TOOL_VISE = ToolVise()
  }

  override fun createBlockItem(block: Block, identifier: String): BlockItem {

    val blockItem = super.createBlockItem(block, identifier)
    ItemGroupEvents.modifyEntriesEvent(ArchaiosGroup.ARCHAIOS_GROUP).register { entries ->
      entries.add(blockItem)
    }

    return blockItem
  }
}