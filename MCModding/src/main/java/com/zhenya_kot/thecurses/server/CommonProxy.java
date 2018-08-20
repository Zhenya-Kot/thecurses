package com.zhenya_kot.thecurses.server;

import com.zhenya_kot.thecurses.TheCurses;
import com.zhenya_kot.thecurses.commands.CursemeCommand;
import com.zhenya_kot.thecurses.commands.SetCursetypeCommand;
import com.zhenya_kot.thecurses.commands.SetTimerCommand;
import com.zhenya_kot.thecurses.commands.TimerCommand;
import com.zhenya_kot.thecurses.items.ItemsRegister;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent E) {
		
	}
	
	public void init(FMLInitializationEvent E) {
		
	}
	
	public void postInit(FMLPostInitializationEvent E) {
		
	}
	
	public void serverStareting(FMLServerStartingEvent E) {
		if (TheCurses.DEBUG) System.out.println("!!! [COMMON PROXY] Commmand Registering [COMMON PROXY] !!!");
		E.registerServerCommand(new SetTimerCommand());
		E.registerServerCommand(new TimerCommand());
		E.registerServerCommand(new CursemeCommand());
		E.registerServerCommand(new SetCursetypeCommand());
	}
}
