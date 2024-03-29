package me.piguy.archaios.gui

import me.piguy.archaios.Archaios.MOD_ID
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.network.PacketByteBuf
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.screen.ScreenHandlerType
import net.minecraft.util.Identifier


class ArchaiosScreenHandlers {
  companion object {
    val ALCHEMY_TABLE_SCREEN_HANDLER =
      ExtendedScreenHandlerType { syncId: Int, inventory: PlayerInventory, buf: PacketByteBuf ->
        AlchemyTableScreenHandler.new(syncId, inventory, buf)
      }
    val TOOL_VISE_SCREEN_HANDLER =
      ExtendedScreenHandlerType { syncId: Int, inventory: PlayerInventory, _ ->
        ToolViseScreenHandler.new(syncId, inventory)
      }

    fun register() {
      Registry.register(
        Registries.SCREEN_HANDLER,
        Identifier(MOD_ID, "alchemy_table_screen_handler"),
        ALCHEMY_TABLE_SCREEN_HANDLER
      )
      Registry.register(
        Registries.SCREEN_HANDLER,
        Identifier(MOD_ID, "tool_vise_screen_handler"),
        TOOL_VISE_SCREEN_HANDLER
      )
    }

  }
}