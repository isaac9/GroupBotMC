package com.google.android;
import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class groupbot extends JavaPlugin {
public final Logger logger = Logger.getLogger("Minecraft");	
public void onEnable() {
	PluginDescriptionFile pdffile = this.getDescription();
	this.logger.info(pdffile.getName() + " has been enabled!");    	
}

public void onDisable() {
	PluginDescriptionFile pdffile = this.getDescription();
	this.logger.info(pdffile.getName() + " has been disabled!");     
}
public boolean onCommand(CommandSender sender, Command command, String label, String[]args){
	if(label.equalsIgnoreCase("hi")){
		Player p = (Player) sender;
		p.sendMessage("Hi!");
	}
	return true;
}
}
