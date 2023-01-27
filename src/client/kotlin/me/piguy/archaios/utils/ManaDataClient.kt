package me.piguy.archaios.utils

import me.piguy.archaios.Archaios
import me.piguy.archaios.networking.ManaCastPacket

object ManaDataClient {
  fun cast(amount: Int) {
    Archaios.ARCHAIOS_CHANNEL.clientHandle().send(
      ManaCastPacket(
        2
      )
    )

  }
}