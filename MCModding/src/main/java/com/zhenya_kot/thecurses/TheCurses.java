package com.zhenya_kot.thecurses;

import com.zhenya_kot.thecurses.events.EventsHandler;
import com.zhenya_kot.thecurses.server.CommonProxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;



@Mod(modid = "thecurses", name="The Curses", version="0.0.2a")
public class TheCurses {
	@SidedProxy(clientSide="com.zhenya_kot.thecurses.client.ClientProxy", serverSide="com.zhenya_kot.server.CommonProxy")
	public static CommonProxy proxy;
	public static boolean DEBUG;
	@EventHandler
	public void preInit(FMLPreInitializationEvent E) {
		config(E);
		//MinecraftForge.EVENT_BUS.register(new EventsHandler());
	}
	
	@EventHandler
	public void init(FMLInitializationEvent E) {
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent E) {
		
	}
	
	@EventHandler
	public void serverStareting(FMLServerStartingEvent E) {
		this.proxy.serverStareting(E);
	}
	
	public void config(FMLPreInitializationEvent E) {
		Configuration config = new Configuration(E.getSuggestedConfigurationFile());
		config.load();
		
		DEBUG = config.get("debug", "DEBUG", false).getBoolean();
		
		if(config.hasChanged());
		config.save();
	}
}
