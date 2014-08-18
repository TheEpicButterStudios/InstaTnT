package me.TheEpicButterStudios.InstaTnT.exception;

import org.bukkit.configuration.file.FileConfiguration;

import me.TheEpicButterStudios.InstaTnT.InstaTnT;

public class ConfigurationNotValidException extends Exception {
	
	InstaTnT mainclass = new InstaTnT();

	/**
	 * Serial Version UID - <b>DO NOT EDIT</b>
	 */
	private static final long serialVersionUID = 3932430577159027321L;
	void main()
	{
	FileConfiguration config = mainclass.getConfig();
	}
}
