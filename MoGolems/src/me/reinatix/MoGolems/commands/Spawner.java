package me.reinatix.MoGolems.commands;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.reinatix.MoGolems.Main;
import me.reinatix.MoGolems.utils.Utils;

public class Spawner implements CommandExecutor {
	
	Utils utils = Main.instance.getUtils();
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		File f = new File(Main.instance.getDataFolder() + File.separator + "messages.yml");
		YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission("mogolems.admin")) {
				if (args.length == 0) {
					utils.send(p, "&e&lSpawners &7- &6Version 1.0");
					utils.send(p, "");
					utils.send(p, "&a/spawner &f- &3Returns this menu");
					utils.send(p, "&a/spawner reload &f- &3Reloads the config file");
					utils.send(p, "&a/spawner give <player> <spawner> &f- &3Gives player the spawner");
					utils.send(p, "&a/spawner list &f- &3See all types of spawners");
					utils.send(p, "");
					utils.send(p, "&e&lDeveloped by Reinatix &e&owith love &d&o<3");
				}
				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("reload")) {
						Main.instance.reloadConfig();
						utils.send(p, config.getString("config-reload"));
						return true;
					} else if (args[0].equalsIgnoreCase("list")) {
						utils.send(p, "&e&lSpawner Types");
						utils.send(p, "");
						utils.send(p, "&a1) &3Iron");
						utils.send(p, "&a2) &3Gold");
						utils.send(p, "&a3) &3Diamond");
						utils.send(p, "&a4) &3Emerald");
						return true;
					} else if (args[0].equalsIgnoreCase("give")) {
						utils.send(p, config.getString("not-enough-arguments"));
						return true;
					}
				}
				if (args.length == 2) {
					if (args[0].equalsIgnoreCase("give")) {
						utils.send(p, config.getString("not-enough-arguments"));
						return true;
					}
				}
				if (args.length == 3) {
					if (args[0].equalsIgnoreCase("give")) {
						Player target = Bukkit.getPlayer(args[1]);
						if (target == null) {
							utils.send(p, config.getString("player-null"));
							return true;
						}
						if (args[2].equalsIgnoreCase("iron")) {
							utils.giveIronSpawner(target);
							String msg = config.getString("received-spawner");
							String msg2 = config.getString("gave-player-spawner");
							msg = msg.replaceAll("%type%", args[2].toString().toUpperCase());
							msg2 = msg2.replaceAll("%type%", args[2].toString().toUpperCase());
							msg2 = msg2.replaceAll("%player%", target.getName());
							utils.send(target, msg);
							utils.send(p, msg2);
							return true;
						} else if (args[2].equalsIgnoreCase("gold")) {
							utils.giveGoldSpawner(target);
							String msg = config.getString("received-spawner");
							String msg2 = config.getString("gave-player-spawner");
							msg = msg.replaceAll("%type%", args[2].toString().toUpperCase());
							msg2 = msg2.replaceAll("%type%", args[2].toString().toUpperCase());
							msg2 = msg2.replaceAll("%player%", target.getName());
							utils.send(target, msg);
							utils.send(p, msg2);
							return true;
						} else if (args[2].equalsIgnoreCase("diamond")) {
							utils.giveDiamondSpawner(target);
							String msg = config.getString("received-spawner");
							String msg2 = config.getString("gave-player-spawner");
							msg = msg.replaceAll("%type%", args[2].toString().toUpperCase());
							msg2 = msg2.replaceAll("%type%", args[2].toString().toUpperCase());
							msg2 = msg2.replaceAll("%player%", target.getName());
							utils.send(target, msg);
							utils.send(p, msg2);
							return true;
						} else if (args[2].equalsIgnoreCase("emerald")) {
							utils.giveEmeraldSpawner(target);
							String msg = config.getString("received-spawner");
							String msg2 = config.getString("gave-player-spawner");
							msg = msg.replaceAll("%type%", args[2].toString().toUpperCase());
							msg2 = msg2.replaceAll("%type%", args[2].toString().toUpperCase());
							msg2 = msg2.replaceAll("%player%", target.getName());
							utils.send(target, msg);
							utils.send(p, msg2);
							return true;
						}
						
					}
				} 
			} else {
				utils.send(p, config.getString("no-permission"));
				return true;
			}
		}
		return true;
	}

}
