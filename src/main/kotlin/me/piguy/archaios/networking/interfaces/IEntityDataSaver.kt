package me.piguy.archaios.networking.interfaces

import net.minecraft.nbt.NbtCompound

interface IEntityDataSaver {
  fun getPersistentData(): NbtCompound
}