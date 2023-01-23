package me.piguy.archaios.blocks.custom

import me.piguy.archaios.blocks.entity.entities.AlchemyTableBlockEntity
import me.piguy.archaios.blocks.entity.entities.ToolViseBlockEntity
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.*
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemPlacementContext
import net.minecraft.state.StateManager
import net.minecraft.util.*
import net.minecraft.util.function.BooleanBiFunction
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.util.shape.VoxelShape
import net.minecraft.util.shape.VoxelShapes
import net.minecraft.world.BlockView
import net.minecraft.world.World
import org.jetbrains.annotations.Nullable
import java.util.stream.Stream

class ToolVise : BlockWithEntity(SETTINGS) {

  //<editor-fold desc="SHAPE_N_S">

  var SHAPE_N_S = Stream.of(
    Stream.of(
      createCuboidShape(13.0, 0.0, 14.0, 15.0, 0.75, 15.0),
      createCuboidShape(2.0, 0.0, 2.0, 14.0, 1.0, 14.0),
      createCuboidShape(1.0, 0.0, 14.0, 3.0, 0.75, 15.0),
      createCuboidShape(3.0, 0.0, 14.0, 13.0, 1.0, 15.0),
      createCuboidShape(2.0, 0.0, 15.0, 14.0, 0.75, 16.0),
      createCuboidShape(13.0, 0.0, 1.0, 15.0, 0.75, 2.0),
      createCuboidShape(1.0, 0.0, 1.0, 3.0, 0.75, 2.0),
      createCuboidShape(3.0, 0.0, 1.0, 13.0, 1.0, 2.0),
      createCuboidShape(2.0, 0.0, 0.0, 14.0, 0.75, 1.0),
      createCuboidShape(1.0, 0.0, 2.0, 2.0, 0.75, 3.0),
      createCuboidShape(1.0, 0.0, 13.0, 2.0, 0.75, 14.0),
      createCuboidShape(0.0, 0.0, 2.0, 1.0, 0.75, 14.0),
      createCuboidShape(1.0, 0.0, 3.0, 2.0, 1.0, 13.0),
      createCuboidShape(14.0, 0.0, 2.0, 15.0, 0.75, 3.0),
      createCuboidShape(14.0, 0.0, 13.0, 15.0, 0.75, 14.0),
      createCuboidShape(14.0, 0.0, 3.0, 15.0, 1.0, 13.0),
      createCuboidShape(15.0, 0.0, 2.0, 16.0, 0.75, 14.0)
    ).reduce { v1: VoxelShape?, v2: VoxelShape? ->
      VoxelShapes.combineAndSimplify(
        v1,
        v2,
        BooleanBiFunction.OR
      )
    }.get(),
    Stream.of(
      createCuboidShape(6.0, 1.0, 7.0, 10.0, 6.0, 9.0),
      createCuboidShape(7.0, 1.0, 9.0, 9.0, 6.0, 10.0),
      createCuboidShape(7.0, 1.0, 6.0, 9.0, 6.0, 7.0)
    ).reduce { v1: VoxelShape?, v2: VoxelShape? ->
      VoxelShapes.combineAndSimplify(
        v1,
        v2,
        BooleanBiFunction.OR
      )
    }.get(),
    VoxelShapes.combineAndSimplify(
      createCuboidShape(2.0, 6.0, 3.0, 14.0, 16.0, 7.75),
      createCuboidShape(2.0, 6.0, 8.25, 14.0, 16.0, 13.0),
      BooleanBiFunction.OR
    ),
    Stream.of(
      createCuboidShape(0.0, 5.0, 7.5, 6.0, 6.0, 8.5),
      createCuboidShape(14.0, 6.0, 7.5, 16.0, 16.0, 8.5),
      createCuboidShape(13.0, 6.0, 7.75, 14.0, 16.0, 8.25),
      createCuboidShape(2.0, 6.0, 7.75, 3.0, 16.0, 8.25),
      createCuboidShape(0.0, 6.0, 7.5, 2.0, 16.0, 8.5),
      createCuboidShape(10.0, 5.0, 7.5, 16.0, 6.0, 8.5)
    ).reduce { v1: VoxelShape?, v2: VoxelShape? ->
      VoxelShapes.combineAndSimplify(
        v1,
        v2,
        BooleanBiFunction.OR
      )
    }.get(),
    Stream.of(
      createCuboidShape(9.0, 10.0, 13.0, 9.75, 12.0, 13.75),
      createCuboidShape(6.5, 12.0, 13.0, 7.0, 12.5, 13.75),
      createCuboidShape(9.0, 12.0, 13.0, 9.5, 12.5, 13.75),
      createCuboidShape(9.0, 9.5, 13.0, 9.5, 10.0, 13.75),
      createCuboidShape(8.5, 10.0, 13.0, 9.0, 10.5, 13.75),
      createCuboidShape(8.5, 11.5, 13.0, 9.0, 12.0, 13.75),
      createCuboidShape(7.0, 11.5, 13.0, 7.5, 12.0, 13.75),
      createCuboidShape(7.0, 10.0, 13.0, 7.5, 10.5, 13.75),
      createCuboidShape(6.5, 9.5, 13.0, 7.0, 10.0, 13.75),
      createCuboidShape(6.25, 10.0, 13.0, 7.0, 12.0, 13.75),
      createCuboidShape(7.0, 9.25, 13.0, 9.0, 10.0, 13.75),
      createCuboidShape(7.0, 12.0, 13.0, 9.0, 12.75, 13.75)
    ).reduce { v1: VoxelShape?, v2: VoxelShape? ->
      VoxelShapes.combineAndSimplify(
        v1,
        v2,
        BooleanBiFunction.OR
      )
    }.get(),
    Stream.of(
      createCuboidShape(9.0, 10.0, 2.25, 9.75, 12.0, 3.0),
      createCuboidShape(6.5, 12.0, 2.25, 7.0, 12.5, 3.0),
      createCuboidShape(9.0, 12.0, 2.25, 9.5, 12.5, 3.0),
      createCuboidShape(9.0, 9.5, 2.25, 9.5, 10.0, 3.0),
      createCuboidShape(8.5, 10.0, 2.25, 9.0, 10.5, 3.0),
      createCuboidShape(8.5, 11.5, 2.25, 9.0, 12.0, 3.0),
      createCuboidShape(7.0, 11.5, 2.25, 7.5, 12.0, 3.0),
      createCuboidShape(7.0, 10.0, 2.25, 7.5, 10.5, 3.0),
      createCuboidShape(6.5, 9.5, 2.25, 7.0, 10.0, 3.0),
      createCuboidShape(6.25, 10.0, 2.25, 7.0, 12.0, 3.0),
      createCuboidShape(7.0, 9.25, 2.25, 9.0, 10.0, 3.0),
      createCuboidShape(7.0, 12.0, 2.25, 9.0, 12.75, 3.0)
    ).reduce { v1: VoxelShape?, v2: VoxelShape? ->
      VoxelShapes.combineAndSimplify(
        v1,
        v2,
        BooleanBiFunction.OR
      )
    }.get()
  ).reduce { v1: VoxelShape?, v2: VoxelShape? ->
    VoxelShapes.combineAndSimplify(
      v1,
      v2,
      BooleanBiFunction.OR
    )
  }.get()

  //</editor-fold>
  //<editor-fold desc="SHAPE_W_E">
  var SHAPE_W_E = Stream.of(
    Stream.of(
      createCuboidShape(1.0, 0.0, 13.0, 2.0, 0.75, 15.0),
      createCuboidShape(2.0, 0.0, 2.0, 14.0, 1.0, 14.0),
      createCuboidShape(1.0, 0.0, 1.0, 2.0, 0.75, 3.0),
      createCuboidShape(1.0, 0.0, 3.0, 2.0, 1.0, 13.0),
      createCuboidShape(0.0, 0.0, 2.0, 1.0, 0.75, 14.0),
      createCuboidShape(14.0, 0.0, 13.0, 15.0, 0.75, 15.0),
      createCuboidShape(14.0, 0.0, 1.0, 15.0, 0.75, 3.0),
      createCuboidShape(14.0, 0.0, 3.0, 15.0, 1.0, 13.0),
      createCuboidShape(15.0, 0.0, 2.0, 16.0, 0.75, 14.0),
      createCuboidShape(13.0, 0.0, 1.0, 14.0, 0.75, 2.0),
      createCuboidShape(2.0, 0.0, 1.0, 3.0, 0.75, 2.0),
      createCuboidShape(2.0, 0.0, 0.0, 14.0, 0.75, 1.0),
      createCuboidShape(3.0, 0.0, 1.0, 13.0, 1.0, 2.0),
      createCuboidShape(13.0, 0.0, 14.0, 14.0, 0.75, 15.0),
      createCuboidShape(2.0, 0.0, 14.0, 3.0, 0.75, 15.0),
      createCuboidShape(3.0, 0.0, 14.0, 13.0, 1.0, 15.0),
      createCuboidShape(2.0, 0.0, 15.0, 14.0, 0.75, 16.0)
    ).reduce { v1: VoxelShape?, v2: VoxelShape? ->
      VoxelShapes.combineAndSimplify(
        v1,
        v2,
        BooleanBiFunction.OR
      )
    }.get(),
    Stream.of(
      createCuboidShape(7.0, 1.0, 6.0, 9.0, 6.0, 10.0),
      createCuboidShape(6.0, 1.0, 7.0, 7.0, 6.0, 9.0),
      createCuboidShape(9.0, 1.0, 7.0, 10.0, 6.0, 9.0)
    ).reduce { v1: VoxelShape?, v2: VoxelShape? ->
      VoxelShapes.combineAndSimplify(
        v1,
        v2,
        BooleanBiFunction.OR
      )
    }.get(),
    VoxelShapes.combineAndSimplify(
      createCuboidShape(8.25, 6.0, 2.0, 13.0, 16.0, 14.0),
      createCuboidShape(3.0, 6.0, 2.0, 7.75, 16.0, 14.0),
      BooleanBiFunction.OR
    ),
    Stream.of(
      createCuboidShape(7.5, 5.0, 0.0, 8.5, 6.0, 6.0),
      createCuboidShape(7.5, 6.0, 14.0, 8.5, 16.0, 16.0),
      createCuboidShape(7.75, 6.0, 13.0, 8.25, 16.0, 14.0),
      createCuboidShape(7.75, 6.0, 2.0, 8.25, 16.0, 3.0),
      createCuboidShape(7.5, 6.0, 0.0, 8.5, 16.0, 2.0),
      createCuboidShape(7.5, 5.0, 10.0, 8.5, 6.0, 16.0)
    ).reduce { v1: VoxelShape?, v2: VoxelShape? ->
      VoxelShapes.combineAndSimplify(
        v1,
        v2,
        BooleanBiFunction.OR
      )
    }.get(),
    Stream.of(
      createCuboidShape(2.25, 10.0, 9.0, 3.0, 12.0, 9.75),
      createCuboidShape(2.25, 12.0, 6.5, 3.0, 12.5, 7.0),
      createCuboidShape(2.25, 12.0, 9.0, 3.0, 12.5, 9.5),
      createCuboidShape(2.25, 9.5, 9.0, 3.0, 10.0, 9.5),
      createCuboidShape(2.25, 10.0, 8.5, 3.0, 10.5, 9.0),
      createCuboidShape(2.25, 11.5, 8.5, 3.0, 12.0, 9.0),
      createCuboidShape(2.25, 11.5, 7.0, 3.0, 12.0, 7.5),
      createCuboidShape(2.25, 10.0, 7.0, 3.0, 10.5, 7.5),
      createCuboidShape(2.25, 9.5, 6.5, 3.0, 10.0, 7.0),
      createCuboidShape(2.25, 10.0, 6.25, 3.0, 12.0, 7.0),
      createCuboidShape(2.25, 9.25, 7.0, 3.0, 10.0, 9.0),
      createCuboidShape(2.25, 12.0, 7.0, 3.0, 12.75, 9.0)
    ).reduce { v1: VoxelShape?, v2: VoxelShape? ->
      VoxelShapes.combineAndSimplify(
        v1,
        v2,
        BooleanBiFunction.OR
      )
    }.get(),
    Stream.of(
      createCuboidShape(13.0, 10.0, 9.0, 13.75, 12.0, 9.75),
      createCuboidShape(13.0, 12.0, 6.5, 13.75, 12.5, 7.0),
      createCuboidShape(13.0, 12.0, 9.0, 13.75, 12.5, 9.5),
      createCuboidShape(13.0, 9.5, 9.0, 13.75, 10.0, 9.5),
      createCuboidShape(13.0, 10.0, 8.5, 13.75, 10.5, 9.0),
      createCuboidShape(13.0, 11.5, 8.5, 13.75, 12.0, 9.0),
      createCuboidShape(13.0, 11.5, 7.0, 13.75, 12.0, 7.5),
      createCuboidShape(13.0, 10.0, 7.0, 13.75, 10.5, 7.5),
      createCuboidShape(13.0, 9.5, 6.5, 13.75, 10.0, 7.0),
      createCuboidShape(13.0, 10.0, 6.25, 13.75, 12.0, 7.0),
      createCuboidShape(13.0, 9.25, 7.0, 13.75, 10.0, 9.0),
      createCuboidShape(13.0, 12.0, 7.0, 13.75, 12.75, 9.0)
    ).reduce { v1: VoxelShape?, v2: VoxelShape? ->
      VoxelShapes.combineAndSimplify(
        v1,
        v2,
        BooleanBiFunction.OR
      )
    }.get()
  ).reduce { v1: VoxelShape?, v2: VoxelShape? ->
    VoxelShapes.combineAndSimplify(
      v1,
      v2,
      BooleanBiFunction.OR
    )
  }.get()
  //</editor-fold>


  companion object {
    val FACING = HorizontalFacingBlock.FACING

    val SETTINGS = FabricBlockSettings
      .of(Material.METAL)
      .drops(Identifier("archaios:tool_vise"))
      .hardness(4.5f)
      .resistance(1200f)
      .mapColor(DyeColor.BLACK)
      .requiresTool()
  }


  override fun getOutlineShape(
    state: BlockState,
    world: BlockView,
    pos: BlockPos,
    context: ShapeContext
  ): VoxelShape {
    return when (state.get(AlchemyTable.FACING)) {
      Direction.NORTH -> SHAPE_N_S
      Direction.SOUTH -> SHAPE_N_S
      Direction.WEST -> SHAPE_W_E
      else -> SHAPE_W_E
    }
  }

  @Nullable
  override fun getPlacementState(ctx: ItemPlacementContext): BlockState {
    return defaultState.with(AlchemyTable.FACING, ctx.playerFacing.opposite)
  }

  override fun rotate(state: BlockState, rotation: BlockRotation): BlockState {
    return state.with(AlchemyTable.FACING, rotation.rotate(state.get(AlchemyTable.FACING)))
  }

  override fun mirror(state: BlockState, mirror: BlockMirror): BlockState {
    return state.rotate(mirror.getRotation(state.get(AlchemyTable.FACING)))
  }

  override fun appendProperties(builder: StateManager.Builder<Block, BlockState?>) {
    builder.add(AlchemyTable.FACING)
  }

  // Block Entity

  override fun onUse(
    state: BlockState,
    world: World,
    pos: BlockPos,
    player: PlayerEntity,
    hand: Hand,
    hit: BlockHitResult
  ): ActionResult {
    if (!world.isClient) {
      val screenHandlerFactory = world.getBlockEntity(pos) as ToolViseBlockEntity
      player.openHandledScreen(screenHandlerFactory)
      return ActionResult.SUCCESS
    }
    return ActionResult.FAIL
  }

  override fun getRenderType(state: BlockState): BlockRenderType {
    return BlockRenderType.MODEL
  }

  override fun createBlockEntity(pos: BlockPos, state: BlockState): BlockEntity {
    return ToolViseBlockEntity(pos, state)
  }

}