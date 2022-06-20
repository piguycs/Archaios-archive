package me.piguy.archaios
import net.fabricmc.api.ModInitializer
import net.minecraft.client.MinecraftClient
import net.minecraft.client.util.math.MatrixStack

@Suppress("UNUSED")
class Archaios: ModInitializer {
    override fun onInitialize() {
        // Mod starts
        println("Eternal mystery, eternal adventure. Thats the nature of this world")

    }

    companion object {
        private val mc = MinecraftClient.getInstance()

        fun onTick() {

        }

        fun onWorldLoad() {

        }

        fun onRender(matrices: MatrixStack) {

        }
    }
}