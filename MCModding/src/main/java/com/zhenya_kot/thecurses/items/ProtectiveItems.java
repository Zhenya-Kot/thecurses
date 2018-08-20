package com.zhenya_kot.thecurses.items;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class ProtectiveItems extends Item {
	public ProtectiveItems(String name) {
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		
	}
	
	@Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {		
		if (stack.getItem().equals(ItemsRegister.PI1L)) tooltip.add("One-time protection from the first level curses");
		if (stack.getItem().equals(ItemsRegister.PI2L)) tooltip.add("One-time protection from the second level curses");
		if (stack.getItem().equals(ItemsRegister.PI3L)) tooltip.add("One-time protection from the third level curses");
    }
}
