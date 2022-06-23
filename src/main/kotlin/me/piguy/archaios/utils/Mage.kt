package me.piguy.archaios.utils

import net.minecraft.util.Identifier

interface Mage {
  fun getMana(): Int

  fun getMaxMana(): Int

  fun setMana(amount: Int)

  fun addMana(amount: Int)

  fun isManaVisible(): Boolean

  fun shouldShowMana(shouldShowMana: Boolean)

}