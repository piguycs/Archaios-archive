package me.piguy.archaios.data

import net.minecraft.entity.data.DataTracker
import net.minecraft.entity.data.TrackedData
import net.minecraft.entity.data.TrackedDataHandlerRegistry
import net.minecraft.entity.player.PlayerEntity

object DataTrackers {
  val MANA: TrackedData<Int> = DataTracker.registerData(PlayerEntity::class.java, TrackedDataHandlerRegistry.INTEGER)
}
