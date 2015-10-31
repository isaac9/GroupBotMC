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
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class groupbot extends JavaPlugin {
public final Logger logger = Logger.getLogger("Minecraft");	

public void onEnable() {
	new ListenerClass(this);
	new CommandExecutorClass(this);
	PluginDescriptionFile pdffile = this.getDescription();
	this.logger.info(pdffile.getName() + " has been enabled!"); 
	this.getCommand("gb").setExecutor(new CommandExecutorClass(this));
	this.getCommand("gbmenu").setExecutor(new CommandExecutorClass(this));
	this.getCommand("hi").setExecutor(new CommandExecutorClass(this));
	this.getCommand("totalexp").setExecutor(new CommandExecutorClass(this));
	this.getCommand("exp").setExecutor(new CommandExecutorClass(this));
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
		p.sendMessage("\u00A75GroupBot Version \u00A76---------------------------");
		p.sendMessage("\u00A78GroupBot developed by ivw");
		p.sendMessage("\u00A78For more info type \u00A75/gweb \u00A78to go to our website");
		p.sendMessage("\u00A7eYou are currenly using Groupbot version \u00A75" + this.getDescription());
		p.sendMessage(ChatColor.DARK_PURPLE + "----------------------------------------------");
	}
	//Sends the player a link to GroupBot
	if(label.equalsIgnoreCase("gbweb")){
		Player p = (Player) sender;
		p.sendMessage(ChatColor.RED + "--------------------------------------------------");
		p.sendMessage("\u00A7eYou can visit us for help or more info below");
		p.sendMessage("\u00A71\u00A7nhttp://groupbotmc.com/");
		p.sendMessage(ChatColor.RED + "--------------------------------------------------");
	}
	//Handles the GroupBot essentials menu
	if(label.equalsIgnoreCase("gbessentials")){
		Player p = (Player) sender;
		p.sendMessage("\u00A7cWelcome to the GroupBot essentials help menu \u00A75--------------");
		p.sendMessage("\u00A78*Essentials is not part of Groupbot");
		p.sendMessage("\u00A7eBelow is the essentials download link");
		p.sendMessage("\u00A71\u00A7nhttps://hub.spigotmc.org/jenkins/job/Spigot-Essentials/");
		p.sendMessage("\u00A7eBelow is the essentials tutorial youtube video link");
		p.sendMessage("\u00A71\u00A7nhttps://youtu.be/05K6CxGYwBE");
		p.sendMessage(ChatColor.RED + "This is the only working version of essentials " + p.getName() + "!");
		p.sendMessage(ChatColor.RED + "--------------------------------------------------");
	}
	//Handles the GroupBot items menu
	if(label.equalsIgnoreCase("gbitems")){
		Player p = (Player) sender;
		p.sendMessage("\u00A7cWelcome to the GroupBot items menu \u00A75--------------");
		p.sendMessage("\u00A7eBelow is the item ids list link");
		p.sendMessage("\u00A71\u00A7nhttp://minecraft-ids.grahamedgecombe.com/");
		p.sendMessage(ChatColor.RED + "-----------------------------------------------");		
	}	
	//Handles the GroupBot Bukkit GUI menu
	if(label.equalsIgnoreCase("gbgui")){
		Player p = (Player) sender;
		p.sendMessage(ChatColor.LIGHT_PURPLE + "Welcome to the GroupBot Bukkit GUI menu " + ChatColor.RED + "----------");
		p.sendMessage(ChatColor.GRAY + "*BukkitGUI is not developed by GroupBot");
		p.sendMessage(ChatColor.YELLOW + "BukkitGUI download link:" + "\u00A71\u00A7lhttp://get.bertware.net/detail/bukkitgui2");
		p.sendMessage(ChatColor.GREEN + "F.A.Q page:" + ChatColor.DARK_BLUE + ChatColor.BOLD + "dev.bukkit.org/bukkit-plugins/bukkitgui/pages/help/faq");
		p.sendMessage(ChatColor.RED + "-------------------------------------------------");
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