/**
 * InstaTnT.java
 * 
 * Last edited 6/14/2014
 * 
 * @author TheEpicButterStudios
 * 
 * @version 1.0
 */


package me.TheEpicButterStudios.InstaTnT;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;

/*
 * InstaTnT Error Codes:
 * 0 - Error Not Found (null)
 * 1 - Unknown Error
 * 2 - Error on startup (onEnable())
 * 3 - Error on shutdown (onDisable())
 * 4 - Error on command (onCommand())
 * 5 - Config Error
 * 6 - Resolving an error
 * 7 - CraftBukkit error (package org.bukkit.*)
 * 8 - Minecraft Server error (package net.minecraft.server.*)
 * 9 - Internal plugin error - Create a ticket at http://dev.bukkit.org/bukkit-plugins/instatnt/tickets/ so I can resolve it
 * 29- Invalid sender (Player instance not found)
 */
 
	public class InstaTnT extends JavaPlugin implements Listener
	{
	public final ArrayList<Player> InstaTnTUsers = new ArrayList<Player>();
	String version = "Release 1.0";
    boolean enable = getConfig().getBoolean("plugin-enabled");

    @Override
	public void onEnable()
		{
    	    if(enable)
    	    {
    	    	Bukkit.getPluginManager().disablePlugin(this);
    	    }
			getLogger().info("has been enabled!");
			getLogger().info("by TheEpicButterStudios!");
			getLogger().info("Running version " + version + ".");
			getLogger().info("----- InstaTnT -----");
			getLogger().info("----- Enabled -----");
			getLogger().info("Well, happy explosions!");
			getServer().getPluginManager().registerEvents(this, this);
			getConfig().options().copyDefaults(true);
		}

    
    @Override
    public void onDisable()
		{
			getLogger().info("Has Been Disabled.");
			getLogger().info("Good Night!");
			saveConfig();
		}
		
		public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) 
		{
			if(commandLabel.equalsIgnoreCase("instaboom")){
				if(!(sender instanceof Player))
				{
					(sender).sendMessage("You must be a player to use InstaTnT! (InstaTnT error code 29)");
				} else {
					if(args[0].equals(null)){
						toggleInstaTnT((Player) sender);
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
							reloadConfig();
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
		
		private void toggleInstaTnT(CommandSender sender)
		{
		
			if(!(sender instanceof Player))
			{
				(sender).sendMessage("Only Players are allowed to use InstaTnT (InstaTnT error code 29)");
			} else {
				if(!enabled((Player) sender))
				{
					InstaTnTUsers.add((Player) sender);
					((Player) sender).sendMessage(ChatColor.YELLOW + "[InstaTnT] Enabled for YOU!");
					getLogger().info(sender + "Enabled InstaTnT!");

				}
				else
				{
					
					InstaTnTUsers.remove((Player)sender);
					((Player) sender).sendMessage(ChatColor.RED + "[InstaTnT] Disabled. See Ya!");
					getLogger().info(((Player) sender) + "disabled InstaTnT.");
				}
			}

		}
		public boolean enabled(Player player)
		{
			return InstaTnTUsers.contains(player);
		}
		public static Player player;
		@EventHandler(priority=EventPriority.NORMAL)
		public void BlockPlace(BlockPlaceEvent event){
			if(InstaTnTUsers.contains(event.getPlayer())){
				 if(event.getBlock().getType().equals(Material.TNT)){
			        	event.getBlock().setType(Material.AIR); 
			        	event.getPlayer().getWorld().spawnEntity(event.getBlock().getLocation(), EntityType.PRIMED_TNT);
			        	return;
					
		}
		
	
	       

			        
		
} } }