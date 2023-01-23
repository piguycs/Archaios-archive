package me.piguy.archaios.blocks

import io.wispforest.owo.registration.reflect.BlockEntityRegistryContainer
import me.piguy.archaios.blocks.ArchaiosBlocks
import me.piguy.archaios.blocks.custom.ToolVise
import me.piguy.archaios.blocks.entity.entities.AlchemyTableBlockEntity
import me.piguy.archaios.blocks.entity.entities.ToolViseBlockEntity
import net.fabricmc.fabric.api.`object`.builder.v1.block.entity.FabricBlockEntityTypeBuilder

class ArchaiosBlockEntities : BlockEntityRegistryContainer {
  companion object {
    @JvmField
    var ALCHEMY_TABLE_BLOCK_ENTITY = FabricBlockEntityTypeBuilder.create({ pos, state ->
      AlchemyTableBlockEntity(pos, state)
    }, ArchaiosBlocks.ALCHEMY_TABLE).build()

    @JvmField
    var TOOL_VISE_BLOCK_ENTITY = FabricBlockEntityTypeBuilder.create({ pos, state ->
      ToolViseBlockEntity(pos, state)
    }, ArchaiosBlocks.TOOL_VISE).build()

  }
}