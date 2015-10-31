package com.google.android;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class ListenerClass implements Listener {
	
	public ListenerClass(groupbot plugin){
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	//Handles the Join message
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		Player player = e.getPlayer();
		e.setJoinMessage(ChatColor.AQUA + "Welcome, " + player.getName() + " , to the server, do /gb to open the GroupBot menu");
		if(player.hasPlayedBefore() == false) {
			player.sendMessage("\u00A7aIf you have not set up the plugins " + player.getName() + " and are using GroupBot, you can visit \u00A71\u00A7nhttp://groupbotmc.com/ \u00A7afor more info & help");
			ItemStack newItem = setMeta(new ItemStack(Material.BLAZE_ROD), "\u00A74GroupBot Menu", Arrays.asList("\u00A7cDo \u00A75/gb \u00A7cto open the GroupBot Menu" , "\u00A7cThe GroupBot menu will apear in the chat!"));
			player.getInventory().addItem(newItem);		
		}
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
