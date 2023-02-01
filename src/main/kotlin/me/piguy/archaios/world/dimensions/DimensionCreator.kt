package me.piguy.archaios.world.dimensions

import com.google.common.collect.ImmutableList
import com.mojang.serialization.Lifecycle
import me.piguy.archaios.Archaios
import me.piguy.archaios.Archaios.MOD_ID
import net.minecraft.registry.MutableRegistry
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.server.MinecraftServer
import net.minecraft.server.WorldGenerationProgressListener
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.Identifier
import net.minecraft.world.SaveProperties
import net.minecraft.world.World
import net.minecraft.world.dimension.DimensionOptions
import net.minecraft.world.dimension.DimensionType
import net.minecraft.world.gen.GeneratorOptions
import net.minecraft.world.level.UnmodifiableLevelProperties
import net.minecraft.world.level.WorldGenSettings
import net.minecraft.world.level.storage.LevelStorage
import java.util.concurrent.Executor
import java.util.function.BiFunction

/**
 *  DimensionCreator class from McJty's RFTools Dimension mod.
 *  Original code licensed under the MIT license.
 *  This code is also licensed under the MIT license.
 */
class DimensionCreator {

  lateinit var world: World

  fun getOrCreateWorld(server: MinecraftServer): ServerWorld {
    val newWorldKey: RegistryKey<World> = RegistryKey.of(RegistryKeys.WORLD, Identifier(MOD_ID, "new_world"))
    val worldKeys = server.worldRegistryKeys


    // get the world if it already exists
    if (worldKeys.contains(newWorldKey)) {
      Archaios.logger.debug("Dimension already exists")
      return server.getWorld(newWorldKey)!!
    }

    return server.overworld
  }

  private fun create(
    server: MinecraftServer,
    worldKey: RegistryKey<World>,
    dimensionFactory: BiFunction<MinecraftServer, RegistryKey<DimensionOptions>, DimensionOptions>,
    map: MutableMap<RegistryKey<World>, ServerWorld>
  ) {

    // get everything we need to create the dimension and the level
    val overworld: ServerWorld = server.overworld

    // dimension keys have a 1:1 relationship with level keys, they have the same IDs as well
    val dimensionKey: RegistryKey<DimensionOptions> = RegistryKey.of(RegistryKeys.DIMENSION, worldKey.value)
    val dimension: DimensionOptions = dimensionFactory.apply(server, dimensionKey)

    // the int in create() here is radius of chunks to watch, 11 is what the server uses when it initializes worlds
    val chunkProgressListener: WorldGenerationProgressListener =
      server.worldGenerationProgressListenerFactory.create(11)
    val executor: Executor = server.workerExecutor
    val anvilConverter: LevelStorage.Session = server.session
    val worldData: SaveProperties = server.saveProperties
    val worldGenSettings: GeneratorOptions = worldData.generatorOptions
    val derivedLevelData =
      UnmodifiableLevelProperties(worldData, worldData.mainWorldProperties)

    // now we have everything we need to create the dimension and the level
    // this is the same order server init creates levels:
    // the dimensions are already registered when levels are created, we'll do that first
    // then instantiate level, add border listener, add to map, fire world load event

    // register the actual dimension
    // net.minecraft.class_5285.method_28605
    val dimensionRegistry: Registry<DimensionOptions>? = null
    if (dimensionRegistry is MutableRegistry<DimensionOptions>) {
      dimensionRegistry.add(dimensionKey, dimension, Lifecycle.stable())
    } else {
      throw IllegalStateException("Unable to register dimension! Registry not writable!")
    }


    val newWorld: ServerWorld = ServerWorld(
      server,
      executor,
      anvilConverter,
      derivedLevelData,
      worldKey,
      dimension,
      chunkProgressListener,
      worldData.isDebugWorld,
      worldGenSettings.seed,
      ImmutableList.of(),
      false
    )

    map[worldKey] = newWorld

  }
}