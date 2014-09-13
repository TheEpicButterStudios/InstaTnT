package me.TheEpicButterStudios.InstaTnT;
import java.util.ArrayList;

import me.TheEpicButterStudios.InstaTnT.Updater.UpdateResult;
import me.TheEpicButterStudios.InstaTnT.Updater.UpdateType;
import me.TheEpicButterStudios.InstaTnT.exception.*;
import me.TheEpicButterStudios.InstaTnT.event.commandExecutor;

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
import org.bukkit.event.player.PlayerJoinEvent;
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
/**
 * InstaTnT.java
 * <br>
 * Last edited 6/30/2014
 * <br>
 * <b>InstaTnT usage:</b>
 * <br>Coming soon.
 * @author TheEpicButterStudios
 * 
 * @version 1.0
 * 
 */
	public class InstaTnT extends JavaPlugin implements Listener
	{
	public final ArrayList<Player> InstaTnTUsers = new ArrayList<Player>();
	public String version = "v1.0-DEV";
    boolean enable = getConfig().getBoolean("plugin-enabled");
    boolean update = getConfig().getBoolean("auto-update");
    public boolean disable_cmd = getConfig().getBoolean("disable-cmd");
    protected SenderIsNotInstanceOfPlayerException SenderIsNotInstanceOfPlayerException = new SenderIsNotInstanceOfPlayerException();

    @Override
	public void onEnable()
		{
    	    if(!enable)
    	    {
    	    	Bukkit.getPluginManager().disablePlugin(this);
    	    }
			getLogger().info("has been enabled!");
			getLogger().info("by TheEpicButterStudios!");
			getLogger().info("Running version " + version + ".");
			getLogger().info("----- InstaTnT -----");
			getLogger().info("----- Enabled! -----");
			getLogger().info("Well, happy explosions!");
			getConfig().options().copyDefaults(true);
			for (Player player : Bukkit.getServer().getOnlinePlayers()) {
			    playerList.put(player.getName(), playerData(player));
			}
			if(update) {
			Updater updater = new Updater(this, 67156, this.getFile(), UpdateType.DEFAULT, true);
			if (updater.getResult() == UpdateResult.UPDATE_AVAILABLE) {
			    this.getLogger().info("New version available! " + updater.getLatestName() + " Downloading...");
			}}
			this.getCommand("instaboom").setExecutor(new commandExecutor(this));
		}

    
    @Override
    public void onDisable()
		{
			getLogger().info("Has Been Disabled.");
			getLogger().info("Good Night!");
			saveConfig();
		}
		protected void toggleInstaTnT(CommandSender sender)
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
