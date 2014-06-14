/**
 * OtherEventHandlers.java
 * 
 * Created: 6/14/14
 * 
 * Last Edited: 6/14/14
 * 
 * Soon, PlayerJoin and onCommand will be here. Maybe.
 * 
 * @author TheEpicButterStudios
 */
package me.TheEpicButterStudios.InstaTnT;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerJoinEvent;

public class OtherEventHandlers extends InstaTnT
{
	@EventHandler(priority=EventPriority.HIGHEST)
	public void PlayerJoin(PlayerJoinEvent e){
	    if(e.getPlayer().isOp() || e.getPlayer().hasPermission("instatnt.all"))
		{
			e.getPlayer().sendMessage("InstaTnT is running version " + version);
		}
		return;
	}
}
