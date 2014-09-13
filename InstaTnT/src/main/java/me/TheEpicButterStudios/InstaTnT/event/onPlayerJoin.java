package me.TheEpicButterStudios.InstaTnT.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.TheEpicButterStudios.InstaTnT.InstaTnT;

public class onPlayerJoin extends InstaTnT implements Listener {
	InstaTnT InstaTnT = new InstaTnT();
	
	@EventHandler(priority=EventPriority.HIGHEST)
	public void PlayerJoin(PlayerJoinEvent e){
	    if(e.getPlayer().isOp() || e.getPlayer().hasPermission("instatnt.all"))
		{
			e.getPlayer().sendMessage("InstaTnT is running version " + version);
		}
		if(InstaTnT.disable_cmd)
		{
			toggleInstaTnT(e.getPlayer());
		}
		return;
	}
	}
