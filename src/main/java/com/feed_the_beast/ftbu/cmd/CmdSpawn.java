package com.feed_the_beast.ftbu.cmd;

import com.feed_the_beast.ftbl.api.cmd.CommandLM;
import com.feed_the_beast.ftbl.api.cmd.CommandLevel;
import com.feed_the_beast.ftbl.util.BlockDimPos;
import com.feed_the_beast.ftbl.util.LMDimUtils;
import com.feed_the_beast.ftbu.FTBULang;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CmdSpawn extends CommandLM
{
    public CmdSpawn()
    {
        super("spawn", CommandLevel.ALL);
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender ics, String[] args) throws CommandException
    {
        EntityPlayerMP ep = getCommandSenderAsPlayer(ics);
        World w = LMDimUtils.getWorld(0);
        BlockPos spawnpoint = w.getSpawnPoint();

        while(w.getBlockState(spawnpoint).isFullCube())
        {
            spawnpoint = spawnpoint.up(2);
        }

        LMDimUtils.teleportPlayer(ep, new BlockDimPos(spawnpoint, 0));
        FTBULang.warp_spawn.printChat(ics);
    }
}