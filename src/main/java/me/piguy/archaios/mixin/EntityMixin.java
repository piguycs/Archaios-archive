package me.piguy.archaios.mixin;

import me.piguy.archaios.utils.interfaces.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class EntityMixin implements IEntityDataSaver {
  private NbtCompound persistentData;

  @Override
  public @NotNull NbtCompound getPersistentData() {
    if (persistentData == null) {
      persistentData = new NbtCompound();
    }
    return persistentData;
  }

  @Inject(method = "writeNbt", at = @At("HEAD"))
  protected void writeNbt(NbtCompound nbt, CallbackInfoReturnable<NbtCompound> cir) {
    if (persistentData != null) {
      nbt.put("archaios.mana", persistentData);
    }
  }

  @Inject(method = "readNbt", at = @At("HEAD"))
  protected void readNbt(NbtCompound nbt, CallbackInfo ci) {
    if (nbt.contains("archaios.mana", 10)) {
      persistentData = nbt.getCompound("archaios.mana");
    }
  }


}
