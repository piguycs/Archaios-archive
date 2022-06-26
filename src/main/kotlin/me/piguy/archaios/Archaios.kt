package me.piguy.archaios

import me.piguy.archaios.items.ModItems
import net.fabricmc.api.ModInitializer
import net.minecraft.client.MinecraftClient
import net.minecraft.client.network.ClientPlayerEntity
import net.minecraft.client.util.math.MatrixStack
import org.slf4j.LoggerFactory
import javax.annotation.Nullable


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

    fun onTick() {

    }

    fun onWorldLoad() {
    }

    fun onRender(matrices: MatrixStack) {

    }
  }
}