package me.piguy.archaios

import io.wispforest.owo.registration.reflect.FieldRegistrationHandler
import me.piguy.archaios.blocks.ArchaiosBlocks
import me.piguy.archaios.blocks.entity.ArchaiosBlockEntities
import me.piguy.archaios.gui.ArchaiosScreenHandlers
import me.piguy.archaios.networking.ArchaiosServerNetworking
import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object Archaios : ModInitializer {
  val logger = LoggerFactory.getLogger("archaios")
  const val MOD_ID = "archaios"


  override fun onInitialize() {

    FieldRegistrationHandler.register(ArchaiosBlocks::class.java, MOD_ID, false)
    FieldRegistrationHandler.register(ArchaiosBlockEntities::class.java, MOD_ID, false)
    ArchaiosScreenHandlers.register()

    ArchaiosServerNetworking.registerC2SPackets()
  }
}