package me.piguy.archaios.mixins;

import me.piguy.archaios.utils.interfaces.PlayerEntityInterface;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerWorld.class)
public class ServerWorldMixin {
  @Inject(method = "onPlayerConnected", at = @At("HEAD"))
  public void onPlayerConnected(ServerPlayerEntity player, CallbackInfo ci) {
    if (player instanceof PlayerEntityInterface) {
      int mana = ((PlayerEntityInterface) player).calculateMana();
      ((PlayerEntityInterface) player).setMana(mana);
    }
  }
}
