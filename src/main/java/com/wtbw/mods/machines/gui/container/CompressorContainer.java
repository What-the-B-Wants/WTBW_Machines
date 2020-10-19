package com.wtbw.mods.machines.gui.container;

import com.wtbw.mods.lib.gui.container.BaseTileContainer;
import com.wtbw.mods.lib.util.nbt.NBTManager;
import com.wtbw.mods.machines.tile.machine.CompressorEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemStackHandler;

/*
  @author: Sunekaer
*/
public class CompressorContainer extends BaseTileContainer<CompressorEntity>
{
    public CompressorContainer(int id, World world, BlockPos pos, PlayerInventory inventory) {
        super(ModContainers.COMPRESSOR, id, world, pos, inventory);

        NBTManager manager = tileEntity.getManager();

        track(manager);

        ItemStackHandler handler = tileEntity.getInventory();

        addInputSlot(handler, CompressorEntity.INPUT_SLOT, 175 / 2 - 6, 20);

        addSlot(handler, CompressorEntity.OUTPUT_SLOT, 175 / 2 - 6, 52);

        layoutPlayerInventorySlots();
    }
}
