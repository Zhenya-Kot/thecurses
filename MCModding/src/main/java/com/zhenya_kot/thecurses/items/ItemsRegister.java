package com.zhenya_kot.thecurses.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemsRegister {
	public static Item PI1L = new ProtectiveItems("protective_item_1");
	public static Item PI2L = new ProtectiveItems("protective_item_2");
	public static Item PI3L = new ProtectiveItems("protective_item_3");
	
	public static void registerItems() {
		registerItem(PI1L);
		registerItem(PI2L);
		registerItem(PI3L);
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerRenders() {
		registerRender(PI1L);
		registerRender(PI2L);
		registerRender(PI3L);
	}
	
	private static void registerItem(Item item) {
		ForgeRegistries.ITEMS.register(item);
	}
	
	@SideOnly(Side.CLIENT)
	private static void registerRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
