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
	if(label.equalsIgnoreCase("gp")){
		Player p = (Player) sender;
		p.sendMessage("\u00A7cWelcome to the \u00A7b[GroupBot] \u00A7cplugin helper!");
		p.sendMessage("\u00A72type \u00A7c/plugins \u00A72to open the plugins menu ");
		p.sendMessage("\u00A7c/ep\u00A72,\u00A7c/inv\u00A72,and other plugin shortcuts will be available later!");	 	
	}	
	return true;
}
}
