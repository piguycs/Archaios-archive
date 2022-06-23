package me.piguy.archaios.mixins;

import me.piguy.archaios.Archaios;
import me.piguy.archaios.data.DataTrackers;
import me.piguy.archaios.utils.Mage;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.lang.reflect.Array;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity implements Mage {

  private DataTracker dataTracker;

  protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
    super(entityType, world);
  }

  @Inject(method = "writeCustomDataToNbt", at = @At("TAIL"))
  public void writeNbt(NbtCompound tag, CallbackInfo ci) {
    dataTracker.set(DataTrackers.INSTANCE.getMANA(), 100);

  }

  @Inject(method = "readCustomDataFromNbt", at = @At("TAIL"))
  public void readNbt(NbtCompound tag, CallbackInfo ci) {
    NbtCompound rootTag = new NbtCompound();
    NbtList listTag = new NbtList();

    tag.put(Archaios.Companion.getMOD_ID(), rootTag);
    if (dataTracker.get(DataTrackers.INSTANCE.getMANA()) == null) {
      rootTag.putInt("mana", 100);
    } else {
      rootTag.putInt("mana", dataTracker.get(DataTrackers.INSTANCE.getMANA()));

    }

  }
}
