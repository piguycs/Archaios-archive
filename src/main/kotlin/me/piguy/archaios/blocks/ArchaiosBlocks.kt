package me.piguy.archaios.blocks

import io.wispforest.owo.registration.reflect.BlockRegistryContainer
import me.piguy.archaios.Archaios
import me.piguy.archaios.blocks.custom.AlchemyBench
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.block.AbstractBlock.Settings
import net.minecraft.block.Material
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier


class ArchaiosBlocks {
  var ALCHEMY = AlchemyBench(Settings.of(Material.WOOD))

  fun init() {
    Registry.register(
      Registries.BLOCK,
      Identifier(Archaios.MOD_ID, "alchemy"),
      ALCHEMY
    )

  }
}