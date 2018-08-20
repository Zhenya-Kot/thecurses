package com.zhenya_kot.thecurses;

import com.zhenya_kot.thecurses.events.EventsHandler;
import com.zhenya_kot.thecurses.items.ItemsRegister;
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



@Mod(modid = "thecurses", name="The Curses", version="1.0")
public class TheCurses {
	@SidedProxy(clientSide="com.zhenya_kot.thecurses.client.ClientProxy", serverSide="com.zhenya_kot.server.CommonProxy")
	public static CommonProxy proxy;
	public static boolean DEBUG;
	public static boolean CRAFT_PROJECTIVE_ITEMS;
	@EventHandler
	public void preInit(FMLPreInitializationEvent E) {
		config(E);
		ItemsRegister.registerItems();
		this.proxy.preInit(E);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent E) {
		this.proxy.init(E);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent E) {
		this.proxy.postInit(E);
	}
	
	@EventHandler
	public void serverStareting(FMLServerStartingEvent E) {
		this.proxy.serverStareting(E);
	}
	
	public void config(FMLPreInitializationEvent E) {
		Configuration config = new Configuration(E.getSuggestedConfigurationFile());
		config.load();
		
		DEBUG = config.get("debug", "DEBUG", false, "DEBUG?").getBoolean();
		CRAFT_PROJECTIVE_ITEMS = config.get("projective_items", "CRAFT_PROJECTIVE_ITEM", true).getBoolean();
		
		if(config.hasChanged());
		config.save();
	}
}
