package me.reinatix.MoGolems.events;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import me.reinatix.MoGolems.Main;
import me.reinatix.MoGolems.utils.Utils;


public class EntityDeath implements Listener {
	
	Utils utils = Main.instance.getUtils();
	
	@EventHandler
	public void onDeath(EntityDeathEvent e) {
		boolean hasCustomName = e.getEntity().getCustomName() != null;
		if (!hasCustomName) {
			return;
		}
		if (e.getEntity().getCustomName().equals(utils.colorize(Main.instance.getConfig().getString("golems.ig-name")))) {
			e.getDrops().clear();
			Random iron = new Random();
			Random tulip = new Random();
			int amount = iron.nextInt(5);
			int tulipAmount = tulip.nextInt(2);
			switch (amount) {
			case 0:
				amount++;amount++;amount++;
				break;
			case 1:
				amount++;amount++;amount++;
				break;
			case 2: 
				amount++;amount++;amount++;amount++;
				break;
			}
			e.getDrops().add(new ItemStack(Material.IRON_INGOT, amount));
			e.getDrops().add(new ItemStack(Material.RED_ROSE, tulipAmount, (short) 6));
		} else if (e.getEntity().getCustomName().equals(utils.colorize(Main.instance.getConfig().getString("golems.gg-name")))) {
			e.getDrops().clear();
			Random iron = new Random();
			Random tulip = new Random();
			int amount = iron.nextInt(5);
			int tulipAmount = tulip.nextInt(2);
			switch (amount) {
			case 0:
				amount++;amount++;amount++;
				break;
			case 1:
				amount++;amount++;amount++;
				break;
			case 2: 
				amount++;amount++;amount++;amount++;
				break;
			}
			e.getDrops().add(new ItemStack(Material.GOLD_INGOT, amount));
			e.getDrops().add(new ItemStack(Material.YELLOW_FLOWER, tulipAmount));
		} else if (e.getEntity().getCustomName().equals(utils.colorize(Main.instance.getConfig().getString("golems.dg-name")))) {
			e.getDrops().clear();
			Random iron = new Random();
			Random tulip = new Random();
			int amount = iron.nextInt(3);
			int tulipAmount = tulip.nextInt(1);
			switch (amount) {
			case 0:
				amount++;amount++;amount++;
				break;
			case 1:
				amount++;amount++;amount++;
				break;
			case 2: 
				amount++;amount++;amount++;amount++;
				break;
			}
			e.getDrops().add(new ItemStack(Material.DIAMOND, amount));
			e.getDrops().add(new ItemStack(Material.RED_ROSE, tulipAmount, (short) 1));
		} else if (e.getEntity().getCustomName().equals(utils.colorize(Main.instance.getConfig().getString("golems.eg-name")))) {
			e.getDrops().clear();
			Random iron = new Random();
			Random tulip = new Random();
			int amount = iron.nextInt(1);
			int tulipAmount = tulip.nextInt(1);
			switch (amount) {
			case 0:
				amount++;amount++;amount++;
				break;
			case 1:
				amount++;amount++;amount++;
				break;
			case 2: 
				amount++;amount++;amount++;amount++;
				break;
			}
			e.getDrops().add(new ItemStack(Material.EMERALD, amount));
			e.getDrops().add(new ItemStack(Material.VINE, tulipAmount));
		}
	}

}
