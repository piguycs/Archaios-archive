package me.piguy.archaios.items

import me.piguy.archaios.Archaios
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry


object ModItems {

  private fun registerItem(name: String, item: Item): Item {
    return Registry.register(Registry.ITEM, Identifier(Archaios.MOD_ID, name), item)
  }

  // call this to register the items
  fun registerModItems() {
    Archaios.LOGGER.debug("Registering items for" + Archaios.MOD_ID)
  }
}