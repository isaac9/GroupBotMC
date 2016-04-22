package com.google.android;

import java.util.Arrays;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class ListenerClass implements Listener {
	//This section contains the item button menus, edit, copy, and paste this code to generate the menus of your desire!
	public static Inventory gbmenu = Bukkit.getServer().createInventory(null, 9, ChatColor.DARK_RED + "\u00A7lGroupBot Main Menu");
	static {
		createButton(Material.BLAZE_ROD, gbmenu, 1, "\u00A74GroupBot Menu", "\u00A7cThe GroupBot Main menu with all GroupBot help");		
		createButton(Material.GLASS, gbmenu, 3, "\u00A72Plugins Main Menu", "\u00A73The Plugins Main menu with all plugins help");	
		createButton(Material.REDSTONE, gbmenu, 5, "\u00A75Server help Main Menu", "\u00A76The GroupBot Server Main help menu");
		createButton(Material.GRASS, gbmenu, 7, "\u00A7eItems Main Menu", "\u00A7aThe Items Main menu with all Item & Blocks minecraft ids");
	}
	public static Inventory servermenu = Bukkit.getServer().createInventory(null, 9, ChatColor.DARK_BLUE + "\u00A7lGroupBot Server Menu");
	static {
		createButton(Material.BLAZE_POWDER, servermenu, 1, "\u00A74BukkitGUI Main Menu", "\u00A7cThe BukkitGUI Main menu with all BukkitGUI help");		
		createButton(Material.GOLD_INGOT, servermenu, 3, "\u00A72BuildTools Main Menu", "\u00A73The BuildTools Main menu with all BuildTools server help");	
		createButton(Material.REDSTONE_BLOCK, servermenu, 5, "\u00A75Server Commands Menu", "\u00A76Opens the Server commands menu");
		createButton(Material.STAINED_GLASS_PANE, servermenu, 7, "\u00A74Back", "\u00A7cTakes you back to the GroupBot main menu");
	}
	public static Inventory gbmainmenu = Bukkit.getServer().createInventory(null, 9, ChatColor.DARK_GREEN + "\u00A7lGroupBot Menu");
	static {
		createButton(Material.DIAMOND, gbmainmenu, 1, "\u00A74GroupBot Commands Menu", "\u00A7cThe GroupBot Commands menu with all commands help");		
		createButton(Material.GOLD_BLOCK, gbmainmenu, 3, "\u00A72GroupBot Website Menu", "\u00A73The GroupBot website menu with a link to GroupBot");	
		createButton(Material.EXP_BOTTLE, gbmainmenu, 5, "\u00A75GroupBot Version Menu", "\u00A76Tells you which version of GroupBot you are using");
		createButton(Material.STAINED_GLASS_PANE, gbmainmenu, 7, "\u00A74Back", "\u00A7cTakes you back to the GroupBot main menu");
	}
	public static Inventory pluginsmenu = Bukkit.getServer().createInventory(null, 9, ChatColor.DARK_PURPLE + "\u00A7lGroupBot Plugins Menu");
	static {
		createButton(Material.LAVA_BUCKET, pluginsmenu, 1, "\u00A74Essentials Menu", "\u00A7cThe GroupBot menu for the Essentials plugin");		
		createButton(Material.EMERALD, pluginsmenu, 3, "\u00A72Display Plugins Menu", "\u00A73The GroupBot menu for the main Display plugins");	
		createButton(Material.COMPASS, pluginsmenu, 5, "\u00A75Server Optimization Plugins Menu", "\u00A76The GroupBot menu for Server Optimization plugins");
		createButton(Material.STAINED_GLASS_PANE, pluginsmenu, 7, "\u00A74Back", "\u00A7cTakes you back to the GroupBot main menu");
	}
	public static Inventory displugins = Bukkit.getServer().createInventory(null, 9, ChatColor.YELLOW + "\u00A7lDisplay Plugins");
	static {
		createButton(Material.SUGAR_CANE, displugins, 1, "\u00A74ScoreBoardStats Menu", "\u00A7cThe GroupBot menu for the ScoreBoardStats plugin");		
		createButton(Material.OBSIDIAN, displugins, 3, "\u00A72AutoBroadcaster Menu", "\u00A73The GroupBot menu for the AutoBroadcaster plugin");	
		createButton(Material.WHEAT, displugins, 5, "\u00A75NameTagEdit Menu", "\u00A76The GroupBot menu for the NameTagEdit plugin");
		createButton(Material.STAINED_GLASS_PANE, displugins, 7, "\u00A74Back", "\u00A7cTakes you back to the plugins menu");
	}
	public static Inventory optplugins = Bukkit.getServer().createInventory(null, 9, ChatColor.GOLD + "\u00A7lOptimization Plugins");
	static {
		createButton(Material.WATCH, optplugins, 1, "\u00A74ClearLagg Menu", "\u00A7cThe GroupBot menu for the ClearLagg plugin");		
		createButton(Material.EMERALD_ORE, optplugins, 3, "\u00A72PTweaks Menu", "\u00A73The GroupBot menu for the PTweaks plugin");	
		createButton(Material.COMPASS, optplugins, 5, "\u00A75Optimize Menu", "\u00A76The GroupBot menu for the Optimize plugin");
		createButton(Material.STAINED_GLASS_PANE, optplugins, 7, "\u00A74Back", "\u00A7cTakes you back to the main menu");
	}
	//This contains the ItemStack format 
	public static void createButton(Material mat, Inventory inv, int Slot, String name, String lore) {
		ItemStack item = new ItemStack(mat);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(Arrays.asList(lore));
		item.setItemMeta(meta);
		inv.setItem(Slot, item);
	}
	public void openMenu(Player p) {
		p.openInventory(gbmenu);
	}
	//This is essentialy the guideline for gathering info on what to do when a player clicks a menu button
	@EventHandler
	public void click(InventoryClickEvent k) {
		Player p = (Player) k.getWhoClicked();
		ItemStack clicked = k.getCurrentItem();
		Inventory inv = k.getInventory();
		//Handles the GroupBot Main menu
		if(inv.getName().equals(gbmenu.getName())) {
			if(clicked.getType() == Material.BLAZE_ROD){
				k.setCancelled(true);
				p.closeInventory();
				p.openInventory(gbmainmenu);
				return;
			}
		}
		if(inv.getName().equals(gbmenu.getName())) {
			if(clicked.getType() == Material.GLASS){
				k.setCancelled(true);
				p.closeInventory();
				p.openInventory(pluginsmenu);
				return;
			}	
		}	
		if(inv.getName().equals(gbmenu.getName())) {
			if(clicked.getType() == Material.REDSTONE){
				k.setCancelled(true);
				p.closeInventory();
				p.openInventory(servermenu);
				return;
			}	
		}	
		if(inv.getName().equals(gbmenu.getName())) {
			if(clicked.getType() == Material.GRASS){
				k.setCancelled(true);
				p.closeInventory();
				p.performCommand("gbitems");
			return;
			}	
		}
		//Handles GroupBot Server Main menu
		if(inv.getName().equals(servermenu.getName())) {
			if(clicked.getType() == Material.BLAZE_POWDER){
				k.setCancelled(true);
				p.closeInventory();
				p.performCommand("gbgui");
				return;
			}
		}
		if(inv.getName().equals(servermenu.getName())) {
			if(clicked.getType() == Material.GOLD_INGOT){
				k.setCancelled(true);
				p.closeInventory();
				p.performCommand("buildtools");
				return;
			}	
		}	
		if(inv.getName().equals(servermenu.getName())) {
			if(clicked.getType() == Material.REDSTONE_BLOCK){
				k.setCancelled(true);
				p.closeInventory();
				p.performCommand("help");
				return;
			}	
		}	
		if(inv.getName().equals(servermenu.getName())) {
			if(clicked.getType() == Material.STAINED_GLASS_PANE){
				k.setCancelled(true);
				p.closeInventory();
				p.openInventory(gbmenu);
				return;
			}	
		}
		//Handles GroupBot side menu
		if(inv.getName().equals(gbmainmenu.getName())) {
			if(clicked.getType() == Material.DIAMOND){
				k.setCancelled(true);
				p.closeInventory();
				p.performCommand("gbmenu");
				return;
			}
		}
		if(inv.getName().equals(gbmainmenu.getName())) {
			if(clicked.getType() == Material.GOLD_BLOCK){
				k.setCancelled(true);
				p.closeInventory();
				p.performCommand("gbweb");
				return;
			}	
		}	
		if(inv.getName().equals(gbmainmenu.getName())) {
			if(clicked.getType() == Material.EXP_BOTTLE){
				k.setCancelled(true);
				p.closeInventory();
				p.performCommand("gbversion");
				return;
			}	
		}	
		if(inv.getName().equals(gbmainmenu.getName())) {
			if(clicked.getType() == Material.STAINED_GLASS_PANE){
				k.setCancelled(true);
				p.closeInventory();
				p.openInventory(gbmenu);
				return;
			}	
		}
		//Handles the GroupBot plugins menu
		if(inv.getName().equals(pluginsmenu.getName())) {
			if(clicked.getType() == Material.LAVA_BUCKET){
				k.setCancelled(true);
				p.closeInventory();
				p.performCommand("gbessentials");
					return;
			}
		}
		if(inv.getName().equals(pluginsmenu.getName())) {
			if(clicked.getType() == Material.EMERALD){
				k.setCancelled(true);
				p.closeInventory();
				p.openInventory(displugins);
				return;
			}	
		}	
		if(inv.getName().equals(pluginsmenu.getName())) {
			if(clicked.getType() == Material.COMPASS){
				k.setCancelled(true);
				p.closeInventory();
				p.openInventory(optplugins);
				return;
			}	
		}	
		if(inv.getName().equals(pluginsmenu.getName())) {
			if(clicked.getType() == Material.STAINED_GLASS_PANE){
				k.setCancelled(true);
				p.closeInventory();
				p.openInventory(gbmenu);
				return;
			}	
		}
		//Handles the display plugins menu
		if(inv.getName().equals(displugins.getName())) {
			if(clicked.getType() == Material.SUGAR_CANE){
				k.setCancelled(true);
				p.closeInventory();
				p.performCommand("gbscorestats");
				return;
			}
		}
		if(inv.getName().equals(displugins.getName())) {
			if(clicked.getType() == Material.OBSIDIAN){
				k.setCancelled(true);
				p.closeInventory();
				p.performCommand("gbroadcaster");
				return;
			}	
		}	
		if(inv.getName().equals(displugins.getName())) {
			if(clicked.getType() == Material.WHEAT){
				k.setCancelled(true);
				p.closeInventory();
				p.performCommand("gbnametag");
				return;
			}	
		}	
		if(inv.getName().equals(displugins.getName())) {
			if(clicked.getType() == Material.STAINED_GLASS_PANE){
				k.setCancelled(true);
				p.closeInventory();
				p.openInventory(pluginsmenu);
				return;
			}	
		}
		//Handles the Optimization plugins menu
		if(inv.getName().equals(optplugins.getName())) {
			if(clicked.getType() == Material.WATCH){
				k.setCancelled(true);
				p.closeInventory();
				p.performCommand("gbclearlagg");
				return;
			}
		}
		if(inv.getName().equals(optplugins.getName())) {
			if(clicked.getType() == Material.EMERALD_ORE){
				k.setCancelled(true);
				p.closeInventory();
				p.performCommand("gbptweaks");
				return;
			}	
		}	
		if(inv.getName().equals(optplugins.getName())) {
			if(clicked.getType() == Material.COMPASS){
				k.setCancelled(true);
				p.closeInventory();
				p.performCommand("gboptimize");
				return;
			}	
		}	
		if(inv.getName().equals(optplugins.getName())) {
			if(clicked.getType() == Material.STAINED_GLASS_PANE){
				k.setCancelled(true);
				p.closeInventory();
				p.openInventory(pluginsmenu);
				return;
			}	
		}
	}
	//Controls the gb.admin restriction	
	@EventHandler
	public void quickcommand(PlayerCommandPreprocessEvent c) {
		if(c.getMessage().equalsIgnoreCase("/gb")) {
			Player player = c.getPlayer();
			if(player.hasPermission("gb.admin")){
			c.setCancelled(true);
			this.openMenu(c.getPlayer());
			}
		}
	}
	//Makes sure the main program reads the Groupbot listener program
	public ListenerClass(groupbot plugin){
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	//Handles the Join message
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		Player player = e.getPlayer();
		e.setJoinMessage(ChatColor.AQUA + "Welcome, " + player.getName() + " , to the server, do /gb to open the GroupBot menu");
		if(player.hasPlayedBefore() == false) {
			if(player.hasPermission("gb.admin")){
			player.sendMessage("\u00A7aIf you have not set up the plugins " + player.getName() + " and are using GroupBot, you can visit \u00A71\u00A7nhttp://groupbotmc.com/ \u00A7afor more info & help");
		    } 
		}		
	}
//Ends the listener program
}


