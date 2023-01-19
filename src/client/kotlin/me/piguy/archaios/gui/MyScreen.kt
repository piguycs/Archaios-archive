package me.piguy.archaios.gui

import io.wispforest.owo.ui.base.BaseUIModelScreen
import io.wispforest.owo.ui.component.ButtonComponent
import io.wispforest.owo.ui.container.FlowLayout
import java.awt.Button


class MyScreen(
  rootComponentClass: Class<FlowLayout>,
  source: DataSource
) : BaseUIModelScreen<FlowLayout>(rootComponentClass, source) {


  override fun build(rootComponent: FlowLayout) {
//    rootComponent.childById(ButtonComponent::class.java, "the-button")!!.onPress { _ ->
//      println("Hello test")
//    }

  }

  companion object {
    fun new(): MyScreen {
      return MyScreen(FlowLayout::class.java, DataSource.file("../src/main/resources/assets/archaios/ui/test.xml"))
    }
  }
}