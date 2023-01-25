package me.piguy.archaios.items

import io.wispforest.owo.itemgroup.Icon
import io.wispforest.owo.itemgroup.OwoItemGroup
import io.wispforest.owo.itemgroup.gui.ItemGroupButton
import me.piguy.archaios.Archaios.MOD_ID
import me.piguy.archaios.blocks.ArchaiosBlocks
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.util.Identifier
import java.util.function.Consumer


object ArchaiosGroup {
//  val ARCHAIOS_GROUP: ItemGroup = FabricItemGroup.builder(Identifier(MOD_ID, "archaios_group"))
//    .icon { ItemStack(ArchaiosBlocks.ALCHEMY_TABLE) }
//    .build()


  var ARCHAIOS_GROUP: OwoItemGroup =
    OwoItemGroup.builder(Identifier(MOD_ID, "archaios_group")) { Icon.of(ItemStack(ArchaiosBlocks.ALCHEMY_TABLE)) }
      .initializer { group ->
        group.addButton(ItemGroupButton.modrinth(group, "https://modrinth.com/mod/archaios"))
        group.addButton(ItemGroupButton.github(group, "https://github.com/RocKing1001/Archaios"))
      }
      .build()
}