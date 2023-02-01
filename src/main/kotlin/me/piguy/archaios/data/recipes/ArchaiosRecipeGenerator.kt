package me.piguy.archaios.data.recipes

import me.piguy.archaios.blocks.ArchaiosBlocks
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeJsonProvider
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder
import net.minecraft.item.Items
import net.minecraft.recipe.book.RecipeCategory
import net.minecraft.util.Identifier
import java.util.function.Consumer

class ArchaiosRecipeGenerator(output: FabricDataOutput) : FabricRecipeProvider(output) {
  override fun generate(exporter: Consumer<RecipeJsonProvider>) {
    ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ArchaiosBlocks.ALCHEMY_TABLE)
      .pattern("###")
      .pattern("IOI")
      .pattern("I I")
      .input('#', Items.NETHERITE_INGOT)
      .input('O', Items.NETHER_STAR)
      .input('I', Items.IRON_INGOT)
      .criterion(hasItem(Items.NETHER_STAR), conditionsFromItem(Items.NETHER_STAR))
      .offerTo(exporter, Identifier(getRecipeName(ArchaiosBlocks.ALCHEMY_TABLE)))
  }
}