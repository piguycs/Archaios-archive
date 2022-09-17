package me.piguy.archaios.utils

import net.minecraft.nbt.NbtCompound

interface IEntityDataSaver {
  fun getPersistentData(): NbtCompound
}