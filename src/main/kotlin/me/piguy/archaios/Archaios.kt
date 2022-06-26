package me.piguy.archaios

import net.fabricmc.api.ModInitializer
import net.minecraft.client.MinecraftClient
import net.minecraft.client.network.ClientPlayerEntity
import net.minecraft.client.util.math.MatrixStack
import javax.annotation.Nullable


@Suppress("UNUSED")
class Archaios: ModInitializer {
  override fun onInitialize() {
    // Mod starts
    println("Eternal mystery, eternal adventure. Thats the nature of this world")
  }


  companion object {
    val MOD_ID = "archaios"
    private val mc = MinecraftClient.getInstance()

    @Nullable val player : ClientPlayerEntity?
      get() {
        return mc.player
      }

    fun onTick() {

    }

    fun onWorldLoad() {
    }

    fun onRender(matrices: MatrixStack) {

    }
  }
}