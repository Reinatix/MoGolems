package me.reinatix.MoGolems.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.reinatix.MoGolems.Main;

public class Utils {

	public void send(Player p, String msg) {
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
	}

	public ItemStack addGlow(ItemStack item){
       net.minecraft.server.v1_12_R1.ItemStack nmsStack = org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack.asNMSCopy(item);
       net.minecraft.server.v1_12_R1.NBTTagCompound tag = null;
        if (!nmsStack.hasTag()) {
            tag = new net.minecraft.server.v1_12_R1.NBTTagCompound();
            nmsStack.setTag(tag);
        }
        if (tag == null) tag = nmsStack.getTag();
        net.minecraft.server.v1_12_R1.NBTTagList ench = new net.minecraft.server.v1_12_R1.NBTTagList();
        tag.set("ench", ench);
        nmsStack.setTag(tag);
        return org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack.asCraftMirror(nmsStack);
    }
	
	public String colorize(String s) {
		if (s != null) {
		s = ChatColor.translateAlternateColorCodes('&', s);
		}
		return s;
	}
	
	public void save(File f) {
		YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
		if (f.exists()) {
			try {
				config.save(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void saveIronSpawner(CreatureSpawner spawner) {
		Location loc = spawner.getLocation();
		int x = loc.getBlockX();
		int y = loc.getBlockY();
		int z = loc.getBlockZ();
		String world = loc.getWorld().getName();
		String spawnerloc = world + ":" + x + "," + y + "," + z + "".toString();
		List<String> ironlist = Main.instance.getConfig().getStringList("spawners.iron");
		ironlist.add(spawnerloc);
		Main.instance.getConfig().set("spawners.iron", ironlist);
		Main.instance.saveConfig();
		Main.instance.ironLocations.add(spawnerloc);
	}

	public void saveGoldSpawner(CreatureSpawner spawner) {
		Location loc = spawner.getLocation();
		int x = loc.getBlockX();
		int y = loc.getBlockY();
		int z = loc.getBlockZ();
		String world = loc.getWorld().getName();
		String spawnerloc = world + ":" + x + "," + y + "," + z + "".toString();
		List<String> goldlist = Main.instance.getConfig().getStringList("spawners.gold");
		goldlist.add(spawnerloc);
		Main.instance.getConfig().set("spawners.gold", goldlist);
		Main.instance.saveConfig();
		Main.instance.goldLocations.add(spawnerloc);
	}

	public void saveDiamondSpawner(CreatureSpawner spawner) {
		Location loc = spawner.getLocation();
		int x = loc.getBlockX();
		int y = loc.getBlockY();
		int z = loc.getBlockZ();
		String world = loc.getWorld().getName();
		String spawnerloc = world + ":" + x + "," + y + "," + z + "".toString();
		List<String> diamondlist = Main.instance.getConfig().getStringList("spawners.diamond");
		diamondlist.add(spawnerloc);
		Main.instance.getConfig().set("spawners.diamond", diamondlist);
		Main.instance.saveConfig();
		Main.instance.diamondLocations.add(spawnerloc);
	}

	public void saveEmeraldSpawner(CreatureSpawner spawner) {
		Location loc = spawner.getLocation();
		int x = loc.getBlockX();
		int y = loc.getBlockY();
		int z = loc.getBlockZ();
		String world = loc.getWorld().getName();
		String spawnerloc = world + ":" + x + "," + y + "," + z + "".toString();
		List<String> emeraldlist = Main.instance.getConfig().getStringList("spawners.emerald");
		emeraldlist.add(spawnerloc);
		Main.instance.getConfig().set("spawners.emerald", emeraldlist);
		Main.instance.saveConfig();
		Main.instance.emeraldLocations.add(spawnerloc);
	}
	
	public void removeIronSpawner(Block spawner) {
		Location loc = spawner.getLocation();
		int x = loc.getBlockX();
		int y = loc.getBlockY();
		int z = loc.getBlockZ();
		String world = loc.getWorld().getName();
		String spawnerloc = world + ":" + x + "," + y + "," + z + "".toString();
		List<String> ironlist = Main.instance.getConfig().getStringList("spawners.iron");
		ironlist.remove(spawnerloc);
		if (!ironlist.contains(spawnerloc)) {
			Main.instance.getConfig().set("spawners.iron", ironlist);
		} else {
			System.out.println("List contains the string");
			return;
		}
		Main.instance.saveConfig();
	}
	
	public void removeGoldSpawner(Block spawner) {
		Location loc = spawner.getLocation();
		int x = loc.getBlockX();
		int y = loc.getBlockY();
		int z = loc.getBlockZ();
		String world = loc.getWorld().getName();
		String spawnerloc = world + ":" + x + "," + y + "," + z + "".toString();
		List<String> goldlist = Main.instance.getConfig().getStringList("spawners.gold");
		goldlist.remove(spawnerloc);
		if (!goldlist.contains(spawnerloc)) {
			Main.instance.getConfig().set("spawners.gold", goldlist);
		} else {
			System.out.println("List contains the string");
			return;
		}
		Main.instance.saveConfig();
	}
	
	public void removeDiamondSpawner(Block spawner) {
		Location loc = spawner.getLocation();
		int x = loc.getBlockX();
		int y = loc.getBlockY();
		int z = loc.getBlockZ();
		String world = loc.getWorld().getName();
		String spawnerloc = world + ":" + x + "," + y + "," + z + "".toString();
		List<String> diamondlist = Main.instance.getConfig().getStringList("spawners.diamond");
		diamondlist.remove(spawnerloc);
		if (!diamondlist.contains(spawnerloc)) {
			Main.instance.getConfig().set("spawners.diamond", diamondlist);
		} else {
			System.out.println("List contains the string");
			return;
		}
		Main.instance.saveConfig();
	}
	
	public void removeEmeraldSpawner(Block spawner) {
		Location loc = spawner.getLocation();
		int x = loc.getBlockX();
		int y = loc.getBlockY();
		int z = loc.getBlockZ();
		String world = loc.getWorld().getName();
		String spawnerloc = world + ":" + x + "," + y + "," + z + "".toString();
		List<String> emeraldlist = Main.instance.getConfig().getStringList("spawners.emerald");
		emeraldlist.remove(spawnerloc);
		if (!emeraldlist.contains(spawnerloc)) {
			Main.instance.getConfig().set("spawners.iron", emeraldlist);
		} else {
			System.out.println("List contains the string");
			return;
		}
		Main.instance.saveConfig();
	}

	public void loadIronBlocks() {
		List<String> ironlist = Main.instance.getConfig().getStringList("spawners.iron");
		if ((ironlist != null) && (ironlist.size() > 0)) {
			Main.instance.ironLocations = ironlist;
		}
	}

	public void loadGoldBlocks() {
		List<String> goldlist = Main.instance.getConfig().getStringList("spawners.gold");
		if ((goldlist != null) && (goldlist.size() > 0)) {
			Main.instance.goldLocations = goldlist;
		}
	}

	public void loadDiamondBlocks() {
		List<String> diamondlist = Main.instance.getConfig().getStringList("spawners.diamond");
		if ((diamondlist != null) && (diamondlist.size() > 0)) {
			Main.instance.diamondLocations = diamondlist;
		}
	}
	
	public void loadEmeraldBlocks() {
		List<String> emeraldlist = Main.instance.getConfig().getStringList("spawners.emerald");
		if ((emeraldlist != null) && (emeraldlist.size() > 0)) {
			Main.instance.emeraldLocations = emeraldlist;
		}
	}

	public void giveIronSpawner(Player p) {
		Inventory inv = p.getInventory();
		ItemStack spawner = new ItemStack(Material.MOB_SPAWNER);
		ItemMeta meta = spawner.getItemMeta();
		List<String> igLore = new ArrayList<String>();
		for (String s : Main.instance.getConfig().getStringList("customization.ig-lore")) {
			s = colorize(s);
			igLore.add(s);
		}
		meta.setLore(igLore);
		meta.setDisplayName(colorize(Main.instance.getConfig().getString("customization.ig-name")));
		spawner.setItemMeta(meta);
		inv.addItem(new ItemStack[] { spawner });
	}

	public void giveGoldSpawner(Player p) {
		Inventory inv = p.getInventory();
		ItemStack spawner = new ItemStack(Material.MOB_SPAWNER);
		ItemMeta meta = spawner.getItemMeta();
		List<String> ggLore = new ArrayList<String>();
		for (String s : Main.instance.getConfig().getStringList("customization.gg-lore")) {
			s = colorize(s);
			ggLore.add(s);
		}
		meta.setLore(ggLore);
		meta.setDisplayName(colorize(Main.instance.getConfig().getString("customization.gg-name")));
		spawner.setItemMeta(meta);
		inv.addItem(new ItemStack[] { spawner });
	}

	public void giveDiamondSpawner(Player p) {
		Inventory inv = p.getInventory();
		ItemStack spawner = new ItemStack(Material.MOB_SPAWNER);
		ItemMeta meta = spawner.getItemMeta();
		List<String> dgLore = new ArrayList<String>();
		for (String s : Main.instance.getConfig().getStringList("customization.dg-lore")) {
			s = colorize(s);
			dgLore.add(s);
		}
		meta.setLore(dgLore);
		meta.setDisplayName(colorize(Main.instance.getConfig().getString("customization.dg-name")));
		spawner.setItemMeta(meta);
		inv.addItem(new ItemStack[] { spawner });
	}

	public void giveEmeraldSpawner(Player p) {
		Inventory inv = p.getInventory();
		ItemStack spawner = new ItemStack(Material.MOB_SPAWNER);
		ItemMeta meta = spawner.getItemMeta();
		List<String> egLore = new ArrayList<String>();
		for (String s : Main.instance.getConfig().getStringList("customization.eg-lore")) {
			s = colorize(s);
			egLore.add(s);
		}
		meta.setLore(egLore);
		meta.setDisplayName(colorize(Main.instance.getConfig().getString("customization.eg-name")));
		spawner.setItemMeta(meta);
		inv.addItem(new ItemStack[] { spawner });
	}
}
