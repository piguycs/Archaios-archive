package me.piguy.archaios.items

import me.piguy.archaios.Archaios.MOD_ID
import me.piguy.archaios.blocks.ArchaiosBlocks
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.util.Identifier


object ArchaiosGroup {
  val ARCHAIOS_GROUP: ItemGroup = FabricItemGroup.builder(Identifier(MOD_ID, "archaios_group"))
    .icon { ItemStack(ArchaiosBlocks.ALCHEMY_TABLE) }
    .build()

}