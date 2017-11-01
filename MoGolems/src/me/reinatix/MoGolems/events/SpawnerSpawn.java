package me.reinatix.MoGolems.events;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.Creature;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.SpawnerSpawnEvent;

import me.reinatix.MoGolems.Main;
import me.reinatix.MoGolems.utils.Utils;

public class SpawnerSpawn implements Listener {
	
	Utils utils = Main.instance.getUtils();
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onSpawn(SpawnerSpawnEvent e) {
		List<String> iron = Main.instance.getConfig().getStringList("spawners.iron");
		List<String> gold = Main.instance.getConfig().getStringList("spawners.gold");
		List<String> diamond = Main.instance.getConfig().getStringList("spawners.diamond");
		List<String> emerald = Main.instance.getConfig().getStringList("spawners.emerald");
		CreatureSpawner spawner = e.getSpawner();
		Location loc = spawner.getLocation();
		World w = spawner.getWorld();
		if (e.getEntity().getType() == EntityType.IRON_GOLEM) {
			Creature c = (Creature) e.getEntity();
			int x = loc.getBlockX();
			int y = loc.getBlockY();
			int z = loc.getBlockZ();
			String spawnerLoc = w.getName() + ":" + x + "," + y + "," + z + "".toString();
			if (iron.contains(spawnerLoc)) {
				c.setCustomName(utils.colorize(Main.instance.getConfig().getString("golems.ig-name")));
			} else if (gold.contains(spawnerLoc)) {
				c.setCustomName(utils.colorize(Main.instance.getConfig().getString("golems.gg-name")));
				c.setMaxHealth(150.00D);
				c.setHealth(150.00D);
			} else if (diamond.contains(spawnerLoc)) {
				c.setCustomName(utils.colorize(Main.instance.getConfig().getString("golems.dg-name")));
				c.setMaxHealth(200.00D);
				c.setHealth(200.00D);
			} else if (emerald.contains(spawnerLoc)) {
				c.setCustomName(utils.colorize(Main.instance.getConfig().getString("golems.eg-name")));
				c.setMaxHealth(250.00D);
				c.setHealth(250.00D);
			}
		}
	}

}
