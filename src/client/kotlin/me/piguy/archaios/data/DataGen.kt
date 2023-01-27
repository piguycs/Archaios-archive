package me.piguy.archaios.data

import me.piguy.archaios.data.recipes.ArchaiosRecipeGenerator
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput

class DataGen : DataGeneratorEntrypoint {
  override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
    val pack = fabricDataGenerator.createPack()

    pack.addProvider { output: FabricDataOutput -> ArchaiosRecipeGenerator(output) }
  }
}