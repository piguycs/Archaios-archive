package me.piguy.archaios.items

import io.wispforest.owo.registration.reflect.ItemRegistryContainer
import me.piguy.archaios.items.custom.Wand
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Material
import net.minecraft.item.Item

class ArchaiosItems : ItemRegistryContainer {
  val wand = Wand(Item.Settings().fireproof().maxCount(1))
}