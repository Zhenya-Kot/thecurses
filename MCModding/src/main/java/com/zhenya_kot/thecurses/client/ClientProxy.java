package com.zhenya_kot.thecurses.client;

import com.zhenya_kot.thecurses.items.ItemsRegister;
import com.zhenya_kot.thecurses.server.CommonProxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	@Override
	public void preInit(FMLPreInitializationEvent E) {
		
	}
	
	@Override
	public void init(FMLInitializationEvent E) {
		ItemsRegister.registerRenders();
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent E) {
		
	}
}
