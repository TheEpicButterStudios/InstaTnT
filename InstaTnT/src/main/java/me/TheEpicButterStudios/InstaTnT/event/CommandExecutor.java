package me.TheEpicButterStudios.InstaTnT.event;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.TheEpicButterStudios.InstaTnT.InstaTnT;
import me.TheEpicButterStudios.InstaTnT.exception.SenderIsNotInstanceOfPlayerException;

public class CommandExecutor extends InstaTnT implements CommandExecutor
{
	private InstaTnT plugin;
	public CommandExecutor(InstaTnT plugin)
	{
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) 
	{
		if(commandLabel.equalsIgnoreCase("instaboom") || commandLabel.equalsIgnoreCase("instatnt")){
			if(!(sender instanceof Player))
			{
				try {
					throw SenderIsNotInstanceOfPlayerException;
				} catch (SenderIsNotInstanceOfPlayerException e) {
					sender.sendMessage("YOU HAVE TO BE A PLAYER TO USE INSTATNT! WHY WOULD YOU PLACE TNT IN THE CONSOLE?");
					sender.sendMessage("ARE YOU OUT OF YOUR MIND? THINK, MAN! CMON! (What plugin are you usingto place blocks from the console? YOU'RE NOT USING ONE!!!)");
					e.printStackTrace();
				}
			} else {
				if(args.length > 2)
				{
					sender.sendMessage("Too many arguments! Try /instaboom help");
				}
				if(super.disable_cmd)
				{
					((Player) sender).sendMessage("Sorry, what?");
					
					return false;
				}
				if(args[0].equals(null)){
					super.toggleInstaTnT((Player) sender);
				}
					if(args[0].equalsIgnoreCase("help"))
					{
						((Player) sender).sendMessage(ChatColor.DARK_AQUA + "oOo------------- InstaTnT Help ------------oOo");
						((Player) sender).sendMessage(ChatColor.YELLOW + "/instaboom: Enables InstaTnT --------------oOo");
						((Player) sender).sendMessage(ChatColor.YELLOW + "/instaboom help: Opens help screen.--------oOo");
						((Player) sender).sendMessage(ChatColor.RED + "/instaboom reload: Reloads InstaTnT.  OP ONLY! -oOo");
						((Player) sender).sendMessage(ChatColor.RED + "/instaboom reload full: Reloads the server. OP ONLY! -oOo");
						((Player) sender).sendMessage(ChatColor.LIGHT_PURPLE + "/instaboom dev: Are you a plugin dev intrested in helping? -oOo");
						((Player) sender).sendMessage(ChatColor.LIGHT_PURPLE + "                Command displays info about helping! Not OP only. -oOo");
						((Player) sender).sendMessage(ChatColor.GRAY + "InstaTnT version " + version + " by TheEpicButterStudios");
						((Player) sender).sendMessage(ChatColor.YELLOW + "/instatnt [arguments]: Does the same as /instaboom [args] -oOo");
						((Player) sender).sendMessage(ChatColor.DARK_AQUA + "oOo------------- InstaTnT Help ------------oOo");
					}
					if(args[0].equalsIgnoreCase("reload") && ((Player) sender).isOp())
					{
						super.reloadConfig();
						((Player) sender).sendMessage("Reloaded InstaTnT, version " + version + ".");
						if((args[1].equalsIgnoreCase("full")) || args[0].equalsIgnoreCase("reload"))
						{
							if(player.hasPermission("InstaTnT.reload.full"))
							{
								Bukkit.reload();
							} else {
								((Player) sender).sendMessage(ChatColor.RED +"You don't have the permission to do /instaboom reload full !");
							}
						}
					}
			        if(args[0].equalsIgnoreCase("dev")) {
			        	((Player) sender).sendMessage("Email theepicbutterstudios@gmail.com for info and spaces!");
			        	
			        }
				
			}
			
		}
		
	return false;
	}
}
