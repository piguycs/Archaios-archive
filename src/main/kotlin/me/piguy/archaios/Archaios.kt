package me.piguy.archaios

import me.piguy.archaios.networking.ArchaiosServerNetworking
import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object Archaios : ModInitializer {
  val logger = LoggerFactory.getLogger("archaios")
  const val MOD_ID = "archaios"



  override fun onInitialize() {
    ArchaiosServerNetworking.registerC2SPackets()
  }
}