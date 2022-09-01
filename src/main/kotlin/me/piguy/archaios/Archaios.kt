package me.piguy.archaios

import me.piguy.archaios.items.ModItems
import me.piguy.archaios.networking.ArchaiosMessages
import net.fabricmc.api.ModInitializer
import net.minecraft.client.MinecraftClient
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.world.GameRules
import org.slf4j.LoggerFactory


@Suppress("UNUSED")
class Archaios : ModInitializer {
  override fun onInitialize() {
    // Mod starts
    println("Eternal mystery, eternal adventure. Thats the nature of this world")

    ModItems.registerModItems()

    ArchaiosMessages.registerC2SPackets()
  }


  companion object {
    val MOD_ID = "archaios"
    val LOGGER = LoggerFactory.getLogger(MOD_ID)
    private val mc = MinecraftClient.getInstance()
    private var counter = 1

    fun onTick() {
      val user = mc.player

      mc.world?.gameRules?.get(GameRules.RANDOM_TICK_SPEED)


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

    }
  }
}