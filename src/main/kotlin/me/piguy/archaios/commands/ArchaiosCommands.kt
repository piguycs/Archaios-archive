package me.piguy.archaios.commands

import com.mojang.brigadier.arguments.IntegerArgumentType
import com.mojang.brigadier.builder.LiteralArgumentBuilder
import me.piguy.archaios.utils.ManaData
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback
import net.minecraft.server.command.CommandManager
import net.minecraft.server.command.ServerCommandSource
import net.minecraft.text.Text

object ArchaiosCommands {
  fun register() {
    val dispatcher = CommandRegistrationCallback.EVENT

    dispatcher.register { disp, _, _ ->
      disp.register(
        LiteralArgumentBuilder.literal<ServerCommandSource>("setmana").then(
          CommandManager.argument("amount", IntegerArgumentType.integer(0, 10))
            .executes { c ->
              val amount = IntegerArgumentType.getInteger(c, "amount")
              c.source.sendMessage(Text.of("$amount"))
              ManaData.setMana(c.source.player!!, amount)
              1
            })
      )
    }


    dispatcher.register { dispatcher, registryAccess, env ->
      dispatcher.register(LiteralArgumentBuilder.literal<ServerCommandSource>("getmana").executes { ctx ->
        val a = ManaData.getMana(ctx.source.player!!)
        ctx.source.sendMessage(Text.of("$a"))
        1
      })
    }
  }
}