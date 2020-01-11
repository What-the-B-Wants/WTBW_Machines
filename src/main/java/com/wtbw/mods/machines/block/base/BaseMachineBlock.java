package com.wtbw.mods.machines.block.base;

import com.wtbw.mods.lib.block.BaseTileBlock;
import com.wtbw.mods.lib.tile.util.energy.BaseEnergyStorage;
import com.wtbw.mods.lib.util.TextComponentBuilder;
import com.wtbw.mods.lib.util.Utilities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.util.Constants;

import javax.annotation.Nullable;
import java.util.List;

/*
  @author: Naxanria
*/
public class BaseMachineBlock<TE extends TileEntity> extends BaseTileBlock<TE>
{
  public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
  public static final BooleanProperty ON = BooleanProperty.create("on");
  
  protected boolean mirrorFacing;

  
  public BaseMachineBlock(Properties properties, TileEntityProvider<TE> tileEntityProvider)
  {
    super(properties, tileEntityProvider);
    
    setDefaultState(stateContainer.getBaseState().with(FACING, Direction.NORTH).with(ON, false));
  }
  
  /**
   * Makes the block be faced towards the player
   * @return this block
   */
  public BaseMachineBlock<TE> mirrored()
  {
    mirrorFacing = true;
    
    return this;
  }
  
  @Override
  public BlockState getStateForPlacement(BlockItemUseContext context)
  {
    return
      mirrorFacing ?
      this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite()) :
      this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing());
  }
  
  public BlockState rotate(BlockState state, Rotation rot)
  {
    return state.with(FACING, rot.rotate(state.get(FACING)));
  }
  
  public BlockState mirror(BlockState state, Mirror mirrorIn)
  {
    return state.rotate(mirrorIn.toRotation(state.get(FACING)));
  }
  
  @Override
  protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
  {
    builder.add(FACING, ON);
  }
  
}
