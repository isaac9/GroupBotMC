package com.google.android;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.permissions.Permission;

public class CommandExecutorClass implements CommandExecutor {
	public final groupbot plugin;
	public Permission playerPermission = new Permission("gb.admin");
	
	public CommandExecutorClass(groupbot plugin) {
		this.plugin = plugin;
	}	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[]args){
		//Sends the welcoming message
		if(label.equalsIgnoreCase("hi")){
			Player p = (Player) sender;
			p.sendMessage("Hi!");
	}
		//Handles the GroupBot Main menu
		if(label.equalsIgnoreCase("gbmenu")){
			Player p = (Player) sender;
			if(p.hasPermission("gb.admin")){
			p.sendMessage("\u00A7c\u00A7lWelcome to the \u00A7b[GroupBot] \u00A7c\u00A7lplugin helper!-----------");
			p.sendMessage("\u00A71\u00A7l-\u00A7etype \u00A7c/plugins \u00A7efor  list of correctly installed plugins");
			p.sendMessage("\u00A71\u00A7l-\u00A7etype \u00A7c/gbmenu \u00A7efor the GroupBot menu rod");
			p.sendMessage("\u00A71\u00A7l-\u00A7etype \u00A7c/totalexp \u00A7efor your total experience points");
			p.sendMessage("\u00A71\u00A7l-\u00A7etype \u00A7c/exp \u00A7eto see how much exp left untill you level up");
			p.sendMessage("\u00A71\u00A7l-\u00A7etype \u00A7c/gbversion \u00A7eto view your GroupBot version");
			p.sendMessage("\u00A71\u00A7l-\u00A7etype \u00A7c/gbweb\u00A7efor the website link");
			p.sendMessage("\u00A71\u00A7l-\u00A7eType \u00A7c/gbessentials \u00A7efor download, install, or tutorial help for essentials ");
			p.sendMessage("\u00A71\u00A7l-\u00A7eType \u00A7c/gbitems \u00A7efor an item ids list");
			}
		}
		//Tells the player how much EXP points they have, or need to have to level up 
		if(label.equalsIgnoreCase("totalexp") && sender instanceof Player) {
			Player player = (Player) sender;
			player.sendMessage("\u00A76Total EXP: " + player.getTotalExperience());
			return true;	
		} else if (command.getName().equalsIgnoreCase("exp") && sender instanceof Player) {
			Player player = (Player) sender;
			player.sendMessage("\u00A76EXP to next level: " + player.getExpToLevel());
			return true;
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


