package me.TheEpicButterStudios.InstaTnT.event;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockPlaceEvent;

import me.TheEpicButterStudios.InstaTnT.InstaTnT;

public class onBlockPlace extends InstaTnT
{
	@EventHandler(priority=EventPriority.NORMAL)
	public void BlockPlace(BlockPlaceEvent event){
		if(InstaTnTUsers.contains(event.getPlayer())){
			 if(event.getBlock().getType().equals(Material.TNT)){
		        	event.getBlock().setType(Material.AIR); 
		        	event.getPlayer().getWorld().spawnEntity(event.getBlock().getLocation(), EntityType.PRIMED_TNT);
		        	return;
				
	}
}}}