package com.feed_the_beast.ftbutilities.cmd;

import com.feed_the_beast.ftblib.lib.cmd.CmdBase;
import com.feed_the_beast.ftbutilities.FTBULang;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class CmdKickme extends CmdBase
{
	public CmdKickme()
	{
		super("kickme", Level.ALL);
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
	{
		if (server.isDedicatedServer())
		{
			getCommandSenderAsPlayer(sender).connection.disconnect(FTBULang.KICKME.textComponent(sender));
		}
		else
		{
			server.initiateShutdown();
		}
	}
}