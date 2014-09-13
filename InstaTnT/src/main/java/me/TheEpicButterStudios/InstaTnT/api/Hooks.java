package me.TheEpicButterStudios.InstaTnT.api;

import me.TheEpicButterStudios.InstaTnT.InstaTnT;

public class Hooks extends InstaTnT {
	
	public String notice()
	{
		return "Still in development! long TimeLeft displays ETA until finish in DAYS.";
		
	}
	public long TimeLeft()
	{
		return 100L;
	}

}