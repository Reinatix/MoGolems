package me.reinatix.MoGolems.events;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.reinatix.MoGolems.Main;
import me.reinatix.MoGolems.utils.Utils;

public class BlockBreak implements Listener {
	
	Utils utils = Main.instance.getUtils();
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Block spawner = e.getBlock();
		Location loc = spawner.getLocation();
		World w = spawner.getWorld();
		@SuppressWarnings("deprecation")
		ItemStack hand = e.getPlayer().getItemInHand();
		int x = loc.getBlockX();
		int y = loc.getBlockY();
		int z = loc.getBlockZ();
		String spawnerLoc = w.getName() + ":" + x + "," + y + "," + z + "".toString();
		if (Main.instance.ironLocations.contains(spawnerLoc)) {
			ItemStack spawner2 = new ItemStack(Material.MOB_SPAWNER);
			ItemMeta meta = spawner2.getItemMeta();
			List<String> igLore = new ArrayList<String>();
			for (String s : Main.instance.getConfig().getStringList("customization.ig-lore")) {
				s = utils.colorize(s);
				igLore.add(s);
			}
			meta.setLore(igLore);
			meta.setDisplayName(utils.colorize(Main.instance.getConfig().getString("customization.ig-name")));
			spawner2.setItemMeta(meta);
			if (hand.getEnchantments().size() >= 1) {
				if (hand.containsEnchantment(Enchantment.SILK_TOUCH)) {
					e.setCancelled(true);
					spawner.setType(Material.AIR);
					spawner.getWorld().dropItemNaturally(loc, spawner2);
					utils.removeIronSpawner(spawner);
				}
			} else {
				e.setCancelled(false);
				utils.removeIronSpawner(spawner);
			}
		} else if (Main.instance.goldLocations.contains(spawnerLoc)) {
			ItemStack spawner2 = new ItemStack(Material.MOB_SPAWNER);
			ItemMeta meta = spawner2.getItemMeta();
			List<String> ggLore = new ArrayList<String>();
			for (String s : Main.instance.getConfig().getStringList("customization.gg-lore")) {
				s = utils.colorize(s);
				ggLore.add(s);
			}
			meta.setLore(ggLore);
			meta.setDisplayName(utils.colorize(Main.instance.getConfig().getString("customization.gg-name")));
			spawner2.setItemMeta(meta);
			if (hand.getEnchantments().size() >= 1) {
				if (hand.containsEnchantment(Enchantment.SILK_TOUCH)) {
					e.setCancelled(true);
					spawner.setType(Material.AIR);
					spawner.getWorld().dropItemNaturally(loc, spawner2);
					utils.removeGoldSpawner(spawner);
				}
			} else {
				e.setCancelled(false);
				utils.removeGoldSpawner(spawner);
			}
		} else if (Main.instance.diamondLocations.contains(spawnerLoc)) {
			ItemStack spawner2 = new ItemStack(Material.MOB_SPAWNER);
			ItemMeta meta = spawner2.getItemMeta();
			List<String> dgLore = new ArrayList<String>();
			for (String s : Main.instance.getConfig().getStringList("customization.dg-lore")) {
				s = utils.colorize(s);
				dgLore.add(s);
			}
			meta.setLore(dgLore);
			meta.setDisplayName(utils.colorize(Main.instance.getConfig().getString("customization.dg-name")));
			spawner2.setItemMeta(meta);
			if (hand.getEnchantments().size() >= 1) {
				if (hand.containsEnchantment(Enchantment.SILK_TOUCH)) {
					e.setCancelled(true);
					spawner.setType(Material.AIR);
					spawner.getWorld().dropItemNaturally(loc, spawner2);
					utils.removeDiamondSpawner(spawner);
				}
			} else {
				e.setCancelled(false);
				utils.removeDiamondSpawner(spawner);
			}
		} else if (Main.instance.emeraldLocations.contains(spawnerLoc)) {
			ItemStack spawner2 = new ItemStack(Material.MOB_SPAWNER);
			ItemMeta meta = spawner2.getItemMeta();
			List<String> egLore = new ArrayList<String>();
			for (String s : Main.instance.getConfig().getStringList("customization.eg-lore")) {
				s = utils.colorize(s);
				egLore.add(s);
			}
			meta.setLore(egLore);
			meta.setDisplayName(utils.colorize(Main.instance.getConfig().getString("customization.eg-name")));
			spawner2.setItemMeta(meta);
			if (hand.getEnchantments().size() >= 1) {
				if (hand.containsEnchantment(Enchantment.SILK_TOUCH)) {
					e.setCancelled(true);
					spawner.setType(Material.AIR);
					spawner.getWorld().dropItemNaturally(loc, spawner2);
					utils.removeEmeraldSpawner(spawner);
				}
			} else {
				e.setCancelled(false);
				utils.removeEmeraldSpawner(spawner);
			}
		}
	}

}
