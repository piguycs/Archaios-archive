package me.piguy.archaios

import me.piguy.archaios.items.ModItems
import me.piguy.archaios.utils.interfaces.PlayerEntityInterface
import net.fabricmc.api.ModInitializer
import net.minecraft.client.MinecraftClient
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.Formatting
import net.minecraft.world.GameRules
import org.slf4j.LoggerFactory


@Suppress("UNUSED")
class Archaios: ModInitializer {
  override fun onInitialize() {
    // Mod starts
    println("Eternal mystery, eternal adventure. Thats the nature of this world")

    ModItems.registerModItems()
  }


  companion object {
    val MOD_ID = "archaios"
    val LOGGER = LoggerFactory.getLogger(MOD_ID)
    private val mc = MinecraftClient.getInstance()
    private var counter = 1

    fun onTick() {
      val user = mc.player

      mc.world?.gameRules?.get(GameRules.RANDOM_TICK_SPEED)

      if (user is PlayerEntityInterface && counter == 20) {
        user.regenMana()
      }


      // counter for running things once a second
      if (counter >= 20) {
        counter = 1
      } else {
        counter += 1
      }



    }

    fun onWorldLoad() {
    }

    fun onRender(matrices: MatrixStack) {
      val user = mc.player




      if (user is PlayerEntityInterface) {
        val mana = user.getMana()



        val x = (mc.window.width / mc.window.scaleFactor / 2 ) + 94
        val y = mc.window.height / mc.window.scaleFactor - 12

        Formatting.AQUA.colorValue?.let { mc.textRenderer.drawWithShadow(matrices, "mana: $mana", x.toFloat(), y.toFloat(), it) }
      }
    }
  }
}