package com.zhenya_kot.thecurses.commands;



import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class SetTimerCommand extends CommandBase {
	
	public static final String
	NAME = "tc_settimer",
	USAGE = "/tc_settimer [value]";
	
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
			if (args.length == 1 && isDigit(args[0])) {
				EntityPlayer player = this.getCommandSenderAsPlayer(sender);
				int arg =  Integer.parseInt(args[0]);
				player.getEntityData().setInteger("cursetimer", arg);
				player.sendMessage(new TextComponentString("Curse Timer is set to " + arg));
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
