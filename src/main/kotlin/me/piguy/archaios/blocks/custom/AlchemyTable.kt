package me.piguy.archaios.blocks.custom

import net.minecraft.block.*
import net.minecraft.item.ItemPlacementContext
import net.minecraft.state.StateManager
import net.minecraft.util.BlockMirror
import net.minecraft.util.BlockRotation
import net.minecraft.util.function.BooleanBiFunction
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.util.shape.VoxelShape
import net.minecraft.util.shape.VoxelShapes
import net.minecraft.world.BlockView
import org.jetbrains.annotations.Nullable
import java.util.stream.Stream


class AlchemyTable :
  Block(Settings.of(Material.WOOD)) {
  companion object {
    val FACING = HorizontalFacingBlock.FACING
  }

  //<editor-fold desc="voxel">

  val VOXEL_N_S = Stream.of(
    createCuboidShape(-10.0, 11.0, 0.0, 26.0, 15.0, 16.0),
    createCuboidShape(22.0, 0.0, 1.0, 24.0, 11.0, 3.0),
    createCuboidShape(-8.0, 0.0, 1.0, -6.0, 11.0, 3.0),
    createCuboidShape(-8.0, 0.0, 13.0, -6.0, 11.0, 15.0),
    createCuboidShape(22.0, 0.0, 13.0, 24.0, 11.0, 15.0)
  ).reduce { v1, v2 -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR) }.get()

  val VOXEL_W_E = Stream.of(
    createCuboidShape(0.0, 11.0, -10.0, 16.0, 15.0, 26.0),
    createCuboidShape(1.0, 0.0, -8.0, 3.0, 11.0, -6.0),
    createCuboidShape(1.0, 0.0, 22.0, 3.0, 11.0, 24.0),
    createCuboidShape(13.0, 0.0, 22.0, 15.0, 11.0, 24.0),
    createCuboidShape(13.0, 0.0, -8.0, 15.0, 11.0, -6.0)
  ).reduce { v1, v2 -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR) }.get();

  //</editor-fold>


  override fun getOutlineShape(
    state: BlockState, world: BlockView, pos: BlockPos, context: ShapeContext
  ): VoxelShape {
    return when (state.get(FACING)) {
      Direction.NORTH -> VOXEL_N_S
      Direction.SOUTH -> VOXEL_N_S
      Direction.WEST -> VOXEL_W_E
      else -> VOXEL_W_E
    }
  }


  @Nullable
  override fun getPlacementState(ctx: ItemPlacementContext): BlockState {
    return defaultState.with(FACING, ctx.playerFacing.opposite)
  }

  override fun rotate(state: BlockState, rotation: BlockRotation): BlockState {
    return state.with(FACING, rotation.rotate(state.get(FACING)))
  }

  override fun mirror(state: BlockState, mirror: BlockMirror): BlockState {
    return state.rotate(mirror.getRotation(state.get(FACING)))
  }

  override fun appendProperties(builder: StateManager.Builder<Block, BlockState?>) {
    builder.add(FACING)
  }

  // Block Entity

//  override fun createBlockEntity(pos: BlockPos, state: BlockState): BlockEntity {
//    return AlchemyBench()
//  }


}