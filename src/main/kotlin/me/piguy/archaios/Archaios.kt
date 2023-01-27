package me.piguy.archaios

import io.wispforest.owo.network.OwoNetChannel
import io.wispforest.owo.registration.reflect.FieldRegistrationHandler
import me.piguy.archaios.blocks.ArchaiosBlockEntities
import me.piguy.archaios.blocks.ArchaiosBlocks
import me.piguy.archaios.commands.ArchaiosCommands
import me.piguy.archaios.events.PlayerJoin
import me.piguy.archaios.events.ServerTickEvent
import me.piguy.archaios.gui.ArchaiosScreenHandlers
import me.piguy.archaios.items.ArchaiosGroup
import me.piguy.archaios.items.ArchaiosItems
import me.piguy.archaios.networking.ManaCastPacket
import me.piguy.archaios.networking.ManaSyncPacket
import me.piguy.archaios.utils.ManaData.Companion.castMana
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents
import net.minecraft.util.Identifier
import org.slf4j.LoggerFactory

object Archaios : ModInitializer {
  val logger = LoggerFactory.getLogger("archaios")
  const val MOD_ID = "archaios"

  val ARCHAIOS_CHANNEL = OwoNetChannel.create(Identifier(MOD_ID, "main"))


  override fun onInitialize() {

    FieldRegistrationHandler.register(ArchaiosBlocks::class.java, MOD_ID, false)
    FieldRegistrationHandler.register(ArchaiosBlockEntities::class.java, MOD_ID, false)
    FieldRegistrationHandler.register(ArchaiosItems::class.java, MOD_ID, false)


    ArchaiosScreenHandlers.register()

    ArchaiosGroup.ARCHAIOS_GROUP.initialize()

    ArchaiosCommands.register()

    ServerPlayConnectionEvents.JOIN.register(PlayerJoin())
    ServerTickEvents.START_SERVER_TICK.register(ServerTickEvent())


    // setup networking
    ARCHAIOS_CHANNEL.registerClientboundDeferred(ManaSyncPacket::class.java)
    ARCHAIOS_CHANNEL.registerServerbound(ManaCastPacket::class.java) { message, access ->
      castMana(access.player, message.mana)
    }

  }
}