package com.zhenya_kot.thecurses.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class TimerCommand extends CommandBase {
	public final String
	NAME = "tc_timer",
	USAGE = "/tc_timer";
	
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
			if (args.length == 0) {
				EntityPlayer player = this.getCommandSenderAsPlayer(sender);
				player.sendMessage(new TextComponentString("Curse Timer is " + player.getEntityData().getInteger("cursetimer")));
			} else {
				throw new WrongUsageException(this.getUsage(sender));
			}
					
		}
		
	}
}
