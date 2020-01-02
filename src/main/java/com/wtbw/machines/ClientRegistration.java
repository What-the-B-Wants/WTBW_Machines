package com.wtbw.machines;

import com.wtbw.machines.block.ModBlocks;
import com.wtbw.machines.gui.container.ModContainers;
import com.wtbw.machines.gui.screen.*;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;

/*
  @author: Naxanria
*/
@SuppressWarnings("ConstantConditions")
public class ClientRegistration
{
  public static void init(){
    registerScreens();
    registerRenderLayers();
  }
  public static void registerScreens()
  {
    ScreenManager.registerFactory(ModContainers.TIERED_FURNACE, TieredFurnaceScreen::new);

    ScreenManager.registerFactory(ModContainers.VACUUM_CHEST, VacuumChestScreen::new);
    ScreenManager.registerFactory(ModContainers.BLOCK_BREAKER, BlockBreakerScreen::new);
    ScreenManager.registerFactory(ModContainers.BLOCK_PLACER, BlockPlacerScreen::new);
    ScreenManager.registerFactory(ModContainers.BLOCK_DETECTOR, BlockDetectorScreen::new);

    ScreenManager.registerFactory(ModContainers.QUARRY, QuarryScreen::new);
    ScreenManager.registerFactory(ModContainers.DRYER, DryerScreen::new);
  }

  public static void registerRenderLayers()
  {
    RenderType cutout = RenderType.func_228643_e_();
    RenderTypeLookup.setRenderLayer(ModBlocks.QUARRY, cutout);
    RenderTypeLookup.setRenderLayer(ModBlocks.QUARRY_MARKER, cutout);
  }
}
