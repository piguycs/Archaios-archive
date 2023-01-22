package me.piguy.archaios.blocks.entity

import io.wispforest.owo.registration.reflect.BlockEntityRegistryContainer
import me.piguy.archaios.blocks.ArchaiosBlocks
import net.fabricmc.fabric.api.`object`.builder.v1.block.entity.FabricBlockEntityTypeBuilder

class ArchaiosBlockEntities : BlockEntityRegistryContainer {
  companion object {
    @JvmField
    var ALCHEMY_TABLE_BLOCK_ENTITY = FabricBlockEntityTypeBuilder.create({ pos, state ->
      AlchemyTableBlockEntity(pos, state)
    }, ArchaiosBlocks.ALCHEMY_TABLE).build()
  }
}