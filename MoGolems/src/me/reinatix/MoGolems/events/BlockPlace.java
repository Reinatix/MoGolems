package me.reinatix.MoGolems.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import me.reinatix.MoGolems.Main;
import me.reinatix.MoGolems.utils.Utils;

public class BlockPlace implements Listener {

	Utils utils = Main.instance.getUtils();

	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlock();
		Location loc = b.getLocation();
		World w = b.getWorld();
		int x = loc.getBlockX();
		int y = loc.getBlockY();
		int z = loc.getBlockZ();
		String spawnerLoc = utils.colorize("&a" + w.getName() + "&f: &e" + x + "&6, &e" + y + "&6, &e" + z + "".toString());
		@SuppressWarnings("deprecation")
		ItemStack item = p.getItemInHand();
		String name = item.getItemMeta().getDisplayName();

		if (item != null) {
			if (item.getType() == Material.MOB_SPAWNER) {
				if (name.equals(utils.colorize(Main.instance.getConfig().getString("customization.ig-name")))) {
					for (Player pl : Bukkit.getOnlinePlayers()) {
						if (pl.hasPermission("mogolems.admin")) {
							utils.send(pl, "&d&kGGG&r&e&lALERT&d&kGGG&r&e&l: &6" + p.getName() + " &ehas placed an Iron Golem Spawner at:");
							utils.send(pl, spawnerLoc);
						}
					}
					CreatureSpawner spawner = (CreatureSpawner) b.getState();
					spawner.setSpawnedType(EntityType.IRON_GOLEM);
					utils.saveIronSpawner(spawner);
				} else if (name.equals(utils.colorize(Main.instance.getConfig().getString("customization.gg-name")))) {
					for (Player pl : Bukkit.getOnlinePlayers()) {
						if (pl.hasPermission("mogolems.admin")) {
							utils.send(pl, "&d&kGGG&r&e&lALERT&d&kGGG&r&e&l: &6" + p.getName() + " &ehas placed a Gold Golem Spawner at:");
							utils.send(pl, spawnerLoc);
						}
					}
					CreatureSpawner spawner = (CreatureSpawner) b.getState();
					spawner.setSpawnedType(EntityType.IRON_GOLEM);
					utils.saveGoldSpawner(spawner);
				} else if (name.equals(utils.colorize(Main.instance.getConfig().getString("customization.dg-name")))) {
					for (Player pl : Bukkit.getOnlinePlayers()) {
						if (pl.hasPermission("mogolems.admin")) {
							utils.send(pl, "&d&kGGG&r&e&lALERT&d&kGGG&r&e&l: &6" + p.getName() + " &ehas placed a DIamond Golem Spawner at:");
							utils.send(pl, spawnerLoc);
						}
					}
					CreatureSpawner spawner = (CreatureSpawner) b.getState();
					spawner.setSpawnedType(EntityType.IRON_GOLEM);
					utils.saveDiamondSpawner(spawner);
				} else if (name.equals(utils.colorize(Main.instance.getConfig().getString("customization.eg-name")))) {
					for (Player pl : Bukkit.getOnlinePlayers()) {
						if (pl.hasPermission("mogolems.admin")) {
							utils.send(pl, "&d&kGGG&r&e&lALERT&d&kGGG&r&e&l: &6" + p.getName() + " &ehas placed an Emerald Golem Spawner at:");
							utils.send(pl, spawnerLoc);
						}
					}
					CreatureSpawner spawner = (CreatureSpawner) b.getState();
					spawner.setSpawnedType(EntityType.IRON_GOLEM);
					utils.saveEmeraldSpawner(spawner);
				}
			}
		}
	}

}
