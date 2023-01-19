package me.piguy.archaios.config

import io.wispforest.owo.config.annotation.Config
import io.wispforest.owo.config.annotation.Modmenu
import me.piguy.archaios.Archaios.MOD_ID


@Modmenu(modId = MOD_ID)
@Config(name = MOD_ID, wrapperName = "ArchaiosConfig")
class ArchaiosConfigModel {
  @JvmField
  var helloWorld: String = "Hello World"
}