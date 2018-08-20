package com.zhenya_kot.thecurses.commands;

import java.util.Random;

import com.zhenya_kot.thecurses.core.Curses;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

public class SetCursetypeCommand extends CommandBase{
	public static final String
	NAME = "tc_setcursetype",
	USAGE = "/tc_setcursetype [1-4]";
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.NAME;
	}

	@Override
	public String getUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return this.USAGE;
	}
	
	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if (sender instanceof EntityPlayer) {
			if (args.length == 1 && isDigit(args[0]) && Integer.parseInt(args[0]) > 0 && Integer.parseInt(args[0]) <= 4) {
				EntityLivingBase player = this.getCommandSenderAsPlayer(sender);
				int arg =  Integer.parseInt(args[0]);
				player.getEntityData().setByte("cursetype", (byte) arg);
			} else {
				throw new WrongUsageException(this.getUsage(sender));
			}
					
		}
		
	}
	
	private static boolean isDigit(String s) throws NumberFormatException {
	    try {
	        Integer.parseInt(s);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
}
