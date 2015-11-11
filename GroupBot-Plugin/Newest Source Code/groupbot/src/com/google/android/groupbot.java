package com.google.android;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class groupbot extends JavaPlugin {
public Permission playerPermission = new Permission("gb.admin");	
public final Logger logger = Logger.getLogger("Minecraft");



public void onEnable() {
	new ListenerClass(this);
	new CommandExecutorClass(this);
	PluginDescriptionFile pdffile = this.getDescription();
	this.logger.info(pdffile.getName() + " has been enabled!"); 
	this.getCommand("gbmenu").setExecutor(new CommandExecutorClass(this));
	this.getCommand("hi").setExecutor(new CommandExecutorClass(this));
	this.getCommand("totalexp").setExecutor(new CommandExecutorClass(this));
	this.getCommand("exp").setExecutor(new CommandExecutorClass(this));
	PluginManager pm = getServer().getPluginManager();
	pm.addPermission(playerPermission);
}
public void onDisable() {
	PluginDescriptionFile pdffile = this.getDescription();
	this.logger.info(pdffile.getName() + " has been disabled!");
}

public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
for (Listener listener : listeners) {
Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
	}
}
public boolean onCommand(CommandSender sender, Command command, String label, String[]args){
	//Handles the GroupBot version 
	if(label.equalsIgnoreCase("gbversion")){
		Player p = (Player) sender;
		if(p.hasPermission("gb.admin")){
		p.sendMessage("\u00A75GroupBot Version \u00A76---------------------------");
		p.sendMessage("\u00A78GroupBot developed by ivw");
		p.sendMessage("\u00A78For more info type \u00A75/gweb \u00A78to go to our website");
		p.sendMessage("\u00A7eYou are currenly using Groupbot version \u00A751.1.5 Alpha");
		p.sendMessage(ChatColor.DARK_PURPLE + "------------------------------------");
		}
	}	
	//Sends the player a link to GroupBot
	if(label.equalsIgnoreCase("gbweb")){
		Player p = (Player) sender;
		if(p.hasPermission("gb.admin")){
		p.sendMessage(ChatColor.RED + "-------------------------------------------");
		p.sendMessage("\u00A7eYou can visit us for help or more info below");
		p.sendMessage("\u00A71http://groupbotmc.com/");
		p.sendMessage(ChatColor.RED + "-------------------------------------------");
		}
	}	
	//Handles the GroupBot essentials menu
	if(label.equalsIgnoreCase("gbessentials")){
		Player p = (Player) sender;
		if(p.hasPermission("gb.admin")){
		p.sendMessage("\u00A7cWelcome to the GroupBot essentials help menu \u00A75--------------");
		p.sendMessage("\u00A7eBelow is the essentials download link");
		p.sendMessage("\u00A7aCore: \u00A71https://hub.spigotmc.org/jenkins/job/Spigot-Essentials/");
		p.sendMessage("\u00A7aGroupManager: \u00A71http://ess.ementalo.com/repository/download/bt10/6258:id/EssentialsGroupManager.jar");
		p.sendMessage("\u00A7eBelow is the essentials tutorial youtube video link");
		p.sendMessage("\u00A71https://youtu.be/05K6CxGYwBE");
		p.sendMessage(ChatColor.RED + "This is the only working version of essentials " + p.getName() + "!");
		p.sendMessage(ChatColor.RED + "-------------------------------------------");
		}	
	}
	//Handles the GroupBot items menu
	if(label.equalsIgnoreCase("gbitems")){
		Player p = (Player) sender;
		if(p.hasPermission("gb.admin")){
		p.sendMessage("\u00A7cWelcome to the GroupBot items menu \u00A75--------------");
		p.sendMessage("\u00A7eBelow is the item ids list link");
		p.sendMessage("\u00A71http://minecraft-ids.grahamedgecombe.com/");
		p.sendMessage(ChatColor.RED + "-------------------------------------------");		
		}
	}	
	//Handles the GroupBot Bukkit GUI menu
	if(label.equalsIgnoreCase("gbgui")){
		Player p = (Player) sender;
		if(p.hasPermission("gb.admin")){
		p.sendMessage(ChatColor.LIGHT_PURPLE + "Welcome to the GroupBot Bukkit GUI menu " + ChatColor.RED + "----------");
		p.sendMessage(ChatColor.YELLOW + "BukkitGUI download link: " + "\u00A71http://get.bertware.net/detail/bukkitgui2");
		p.sendMessage(ChatColor.GREEN + "F.A.Q page: " + ChatColor.DARK_BLUE + "dev.bukkit.org/bukkit-plugins/bukkitgui/pages/help/faq");
		p.sendMessage(ChatColor.RED + "-------------------------------------------");
		}
	}
	//Handles the BuildTools Message
	if(label.equalsIgnoreCase("buildtools")){
		Player p = (Player) sender;
		if(p.hasPermission("gb.admin")){
		p.sendMessage(ChatColor.LIGHT_PURPLE + "Welcome to the GroupBot BuildTools menu " + p.getName() + "!");	
		p.sendMessage(ChatColor.GREEN + "BuildTools link: " + ChatColor.DARK_BLUE + "https://www.spigotmc.org/wiki/buildtools/");
		p.sendMessage(ChatColor.LIGHT_PURPLE + "-------------------------------------------");
		}
	}
	if(label.equalsIgnoreCase("gbscorestats")){
		Player p = (Player) sender;
		if(p.hasPermission("gb.admin")){
		p.sendMessage(ChatColor.RED + "-------------------------------------------");
		p.sendMessage("\u00A7eScoreBoardStats Download link is Below");
		p.sendMessage("\u00A71http://dev.bukkit.org/bukkit-plugins/scoreboardstats/");
		p.sendMessage("\u00A7eScoreBoardStats Variables link is Below");
		p.sendMessage("\u00A71http://dev.bukkit.org/bukkit-plugins/scoreboardstats/pages/variables/");
		p.sendMessage("\u00A7eScoreBoardStats Tutorial link is Below");		
		p.sendMessage("\u00A71https://www.youtube.com/watch?v=5SN65X-cCZU");
		p.sendMessage(ChatColor.RED + "-------------------------------------------");
		}
	}
	if(label.equalsIgnoreCase("gbroadcaster")){
		Player p = (Player) sender;
		if(p.hasPermission("gb.admin")){
		p.sendMessage(ChatColor.RED + "-------------------------------------------");
		p.sendMessage("\u00A7eAutoBroadcaster Download link is Below");
		p.sendMessage("\u00A71http://dev.bukkit.org/bukkit-plugins/jamesyahugh/");
		p.sendMessage("\u00A7eAutoBroadcaster Tutorial link is Below");		
		p.sendMessage("\u00A71https://www.youtube.com/watch?v=-FjDjFFoqPE");
		p.sendMessage(ChatColor.RED + "-------------------------------------------");
		}
	}
	if(label.equalsIgnoreCase("gbnametag")){
		Player p = (Player) sender;
		if(p.hasPermission("gb.admin")){
		p.sendMessage(ChatColor.RED + "-------------------------------------------");
		p.sendMessage("\u00A7eNameTagEdit Download link is Below");
		p.sendMessage("\u00A71http://ci.playmc.cc/job/NametagEdit/");
		p.sendMessage("\u00A7eNameTagEdit Tutorial link is Below");		
		p.sendMessage("\u00A71https://www.youtube.com/watch?v=OPC0RWCkNSM");
		p.sendMessage(ChatColor.RED + "-------------------------------------------");
		}
	}
	if(label.equalsIgnoreCase("gbclearlagg")){
		Player p = (Player) sender;
		if(p.hasPermission("gb.admin")){
		p.sendMessage(ChatColor.RED + "-------------------------------------------");
		p.sendMessage("\u00A7eClearLagg Download link is Below");
		p.sendMessage("\u00A71http://dev.bukkit.org/bukkit-plugins/clearlagg/");
		p.sendMessage("\u00A7eClearLagg Tutorial link is Below");		
		p.sendMessage("\u00A71https://www.youtube.com/watch?v=UYSdjFUaP98");
		p.sendMessage(ChatColor.RED + "-------------------------------------------");
		}
	}
	if(label.equalsIgnoreCase("gbptweaks")){
		Player p = (Player) sender;
		if(p.hasPermission("gb.admin")){
		p.sendMessage(ChatColor.RED + "-------------------------------------------");
		p.sendMessage("\u00A7ePTweaks Download link is Below");
		p.sendMessage("\u00A71http://dev.bukkit.org/bukkit-plugins/ptweaks-remove-all-server-lag/");
		p.sendMessage("\u00A7ePTweaks Tutorial link is Below");		
		p.sendMessage("\u00A71https://www.youtube.com/watch?v=7ZXg-BJbweM");
		p.sendMessage(ChatColor.RED + "-------------------------------------------");
		}
	}
	if(label.equalsIgnoreCase("gboptimize")){
		Player p = (Player) sender;
		if(p.hasPermission("gb.admin")){
		p.sendMessage(ChatColor.RED + "-------------------------------------------");
		p.sendMessage("\u00A7eOptimize Download link is Below");
		p.sendMessage("\u00A71http://dev.bukkit.org/bukkit-plugins/optimize/");
		p.sendMessage("\u00A7eThere is no Tutorial for Optimize");		
		p.sendMessage("\u00A7cThis plugin is more server info based!");
		p.sendMessage("\u00A7cThings like: How much ram does your server have?");
		p.sendMessage(ChatColor.RED + "-------------------------------------------");
		}
	}
	return true;
}
//Sets up item name and lore 
public ItemStack setMeta(ItemStack material, String name, List<String> lore){
	if(((material == null) || material.getType() == Material.AIR)
		 || (name == null && lore == null))
	return null;

	ItemMeta im = material.getItemMeta();	
	if (name !=null)
		im.setDisplayName(name);
	if(lore != null){
		im.setLore(lore);
	
	material.setItemMeta(im);	
	return material;
	}
	return null;
}
}