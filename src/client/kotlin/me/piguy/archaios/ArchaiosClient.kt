package me.piguy.archaios

import me.piguy.archaios.config.ArchaiosConfig
import me.piguy.archaios.gui.ArchaiosScreenHandlers
import me.piguy.archaios.gui.hud.HudOverlay
import me.piguy.archaios.gui.screens.AlchemyTableScreen
import me.piguy.archaios.gui.screens.ToolViseScreen
import me.piguy.archaios.networking.ManaCastPacket
import me.piguy.archaios.networking.ManaSyncPacket
import me.piguy.archaios.utils.ManaData.Companion.setMana
import me.piguy.archaios.utils.interfaces.IEntityDataSaver
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback
import net.minecraft.client.MinecraftClient
import net.minecraft.client.gui.screen.ingame.HandledScreens
import net.minecraft.client.option.KeyBinding
import net.minecraft.client.util.InputUtil
import net.minecraft.text.Text
import org.lwjgl.glfw.GLFW


object ArchaiosClient : ClientModInitializer {

  val CONFIG = ArchaiosConfig.createAndLoad()
  val mc = MinecraftClient.getInstance()

  override fun onInitializeClient() {


    HudRenderCallback.EVENT.register(HudOverlay())

    val key = KeyBindingHelper.registerKeyBinding(
      KeyBinding(
        "key.archaios.open",
        InputUtil.Type.KEYSYM,
        GLFW.GLFW_KEY_R,
        "category.archaios.test"
      )
    )

    ClientTickEvents.END_CLIENT_TICK.register(ClientTickEvents.EndTick { client: MinecraftClient ->
      while (key.wasPressed()) {
//        client.setScreenAndRender(CharacterScreen())
//        client.setScreenAndRender(MyScreen.new())
        Archaios.ARCHAIOS_CHANNEL.clientHandle().send(
          ManaCastPacket(
            2
          )
        )
      }
    })

//    BlockRenderLayerMap.INSTANCE.putBlock(ArchaiosBlocks.ALCHEMY_TABLE, RenderLayer.getCutout())


    // BLOCK ENTITIES
    HandledScreens.register(ArchaiosScreenHandlers.ALCHEMY_TABLE_SCREEN_HANDLER) { screenHandler, inventory, text ->
      AlchemyTableScreen(screenHandler, inventory, text)
    }
    HandledScreens.register(ArchaiosScreenHandlers.TOOL_VISE_SCREEN_HANDLER) { screenHandler, inventory, text ->
      ToolViseScreen(screenHandler, inventory, text)
    }


    // NETWORKING
    Archaios.ARCHAIOS_CHANNEL.registerClientbound(ManaSyncPacket::class.java) { message, access ->
      val player = mc.player
      if (player is IEntityDataSaver) {
        setMana(player, message.mana)
      } else {
        Archaios.logger.info("Player is not IEntityDataSaver")
      }
    }

  }
}