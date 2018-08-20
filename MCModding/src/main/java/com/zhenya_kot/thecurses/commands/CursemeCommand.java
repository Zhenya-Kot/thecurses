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
import net.minecraft.util.text.TextComponentString;

public class CursemeCommand extends CommandBase {
	public static final String
	NAME = "tc_curseme",
	USAGE = "/tc_curseme [level 1-3]";
	
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
			if (args.length == 1 && isDigit(args[0]) && Integer.parseInt(args[0]) > 0 && Integer.parseInt(args[0]) < 4) {
				EntityLivingBase player = this.getCommandSenderAsPlayer(sender);
				int arg =  Integer.parseInt(args[0]);
				switch (arg) {
				case 1:
					Curses.C1LC(new Random(player.getEntityWorld().getTotalWorldTime()), player);
					break;
				case 2:
					Curses.C2LC(new Random(player.getEntityWorld().getTotalWorldTime()), player);
					break;
				case 3:
					Curses.C3LC(new Random(player.getEntityWorld().getTotalWorldTime()), player);
					break;
				}
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
