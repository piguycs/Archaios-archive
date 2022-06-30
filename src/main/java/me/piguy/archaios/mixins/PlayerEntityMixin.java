package me.piguy.archaios.mixins;

import me.piguy.archaios.utils.interfaces.PlayerEntityInterface;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends Entity implements PlayerEntityInterface {
  private static final TrackedData<Integer> MANA = DataTracker.registerData(PlayerEntityMixin.class, TrackedDataHandlerRegistry.INTEGER);
  int baseMana = 100;
  int bonusMana = 50;
  int manaMultiplier = 2;

  int manaRegen = 5;

  int MAX_MANA = calculateMana();

  public PlayerEntityMixin(EntityType<?> type, World world) {
    super(type, world);
  }

  @Inject(method = "initDataTracker", at = @At("TAIL"))
  public void initDataTracker(CallbackInfo ci) {
    this.dataTracker.startTracking(MANA, 100);
  }

  public int getMana() {
    return this.dataTracker.get(MANA);
  }

  public void setMana(int mana) {
    if (!(mana <=0)) {
      this.dataTracker.set(MANA, mana);
    }
  }

  public void addMana(int amt) {
    setMana(getMana() + amt);
  }

  public int calculateMana() {
    return (baseMana * manaMultiplier) + bonusMana;
  }

  public void regenMana() {
    int mana = getMana();
    if (mana < MAX_MANA) {
      addMana(manaRegen);
    }
  }

}
