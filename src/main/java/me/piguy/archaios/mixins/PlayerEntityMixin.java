package me.piguy.archaios.mixins;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {


  @Inject(method = "writeCustomDataToNbt", at = @At("TAIL"))
  public void writeNbt(NbtCompound tag, CallbackInfo ci) {

  }

  @Inject(method = "readCustomDataFromNbt", at = @At("TAIL"))
  public void readNbt(NbtCompound tag, CallbackInfo ci) {
  }
}
