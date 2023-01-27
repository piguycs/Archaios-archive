package me.piguy.archaios.items

import io.wispforest.owo.registration.reflect.ItemRegistryContainer
import me.piguy.archaios.items.custom.WandItem
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item

class ArchaiosItems : ItemRegistryContainer {
  companion object {
    @JvmField
    val WAND = WandItem()
  }
}