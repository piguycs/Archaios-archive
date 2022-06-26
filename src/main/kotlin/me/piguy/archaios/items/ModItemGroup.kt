package me.piguy.archaios.items

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.ItemStack
import net.minecraft.util.Identifier


class ModItemGroup {
  val ARCHAIOS = FabricItemGroupBuilder.build(
    Identifier("archaios", "archaios")
  ) { ItemStack(ModItems.WAND) }

}