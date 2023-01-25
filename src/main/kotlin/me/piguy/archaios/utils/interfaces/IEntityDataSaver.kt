package me.piguy.archaios.utils.interfaces

import net.minecraft.nbt.NbtCompound

interface IEntityDataSaver {
  fun getPersistentData() : NbtCompound
}