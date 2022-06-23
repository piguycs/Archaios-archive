package me.piguy.archaios.mixins;

import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {
  private int mana = 100;
  public void setMana(int amount) {mana = mana + amount;};
  public int getMana() {return mana;};
}
