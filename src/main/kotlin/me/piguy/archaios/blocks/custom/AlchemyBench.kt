package me.piguy.archaios.blocks.custom

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.item.ItemPlacementContext
import net.minecraft.state.StateManager
import net.minecraft.state.property.Properties
import net.minecraft.util.BlockMirror
import net.minecraft.util.BlockRotation

class AlchemyBench(settings: Settings) : Block(settings) {
//  val FACING = Properties.HORIZONTAL_FACING
//
//  override fun getPlacementState(ctx: ItemPlacementContext): BlockState? {
//    return super.getDefaultState().with(FACING, ctx.playerFacing.opposite)
//  }
//
//  override fun rotate(state: BlockState, rotation: BlockRotation): BlockState {
//    return state.with(FACING, rotation.rotate(state.get(FACING)))
//  }
//
//  override fun mirror(state: BlockState, mirror: BlockMirror): BlockState {
//    return state.rotate(mirror.getRotation(state.get(FACING)))
//  }
//
//  override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
//    builder.add(FACING)
//  }

}