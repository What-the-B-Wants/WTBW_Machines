package com.wtbw.machines.recipe;

import com.wtbw.machines.WTBWMachines;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.Optional;

/*
  @author: Naxanria
*/

public class ModRecipes
{
  public static void init()
  {}
  
  public static final IRecipeType<DryerRecipe> DRYING = register("drying");
  
  private static <T extends IRecipe<?>> IRecipeType<T> register(final String key)
  {
    WTBWMachines.LOGGER.info("Registering recipe type {}:{}", WTBWMachines.MODID, key);
    return Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(WTBWMachines.MODID, key), new IRecipeType<T>()
    {
      @Override
      public String toString()
      {
        return key;
      }
    });
  }
}
