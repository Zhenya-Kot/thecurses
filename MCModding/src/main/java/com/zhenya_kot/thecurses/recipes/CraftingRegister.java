package com.zhenya_kot.thecurses.recipes;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.IRecipeFactory;

public class CraftingRegister {
	public static void registerRecipes() {
		registerRecipe("protective_item_1");
		registerRecipe("protective_item_2");
		registerRecipe("protective_item_3");
	}
	
	private static void registerRecipe(String name) {
		CraftingHelper.register(new ResourceLocation(name), (IRecipeFactory) (context, json) -> CraftingHelper.getRecipe(json, context));
	}
}
