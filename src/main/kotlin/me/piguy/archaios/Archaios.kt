package me.piguy.archaios

import me.piguy.archaios.data.DataTrackers
import me.piguy.archaios.data.DataTrackers.MANA
import net.fabricmc.api.ModInitializer
import net.minecraft.client.MinecraftClient
import net.minecraft.client.network.ClientPlayerEntity
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.entity.data.DataTracker
import javax.annotation.Nullable


@Suppress("UNUSED")
class Archaios: ModInitializer {
  override fun onInitialize() {
    // Mod starts
    println("Eternal mystery, eternal adventure. Thats the nature of this world")

    DataTrackers.MANA.id
  }


  companion object {
    val MOD_ID = "archaios"
    private val mc = MinecraftClient.getInstance()
    private val dataTracker: DataTracker? = null

    @Nullable val player : ClientPlayerEntity?
      get() {
        return mc.player
      }

    fun onTick() {

    }

    fun onWorldLoad() {
      dataTracker?.set(MANA, 100)
    }

    fun onRender(matrices: MatrixStack) {

    }
  }
}