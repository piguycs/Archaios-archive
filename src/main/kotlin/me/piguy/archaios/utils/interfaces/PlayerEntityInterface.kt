package me.piguy.archaios.utils.interfaces;

interface PlayerEntityInterface {
  fun getMana(): Int
  fun setMana(mana:Int)
  fun addMana(amt:Int)
  fun calculateMana() : Int
}

