/*
Heads by Gaming12846
*/

package de.gaming12846.heads.main;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.gaming12846.heads.commands.GetHeatCommand;
import de.gaming12846.heads.features.HeadRecipe;

public class Main extends JavaPlugin {

	private static Main plugin;

	@Override
	public void onEnable() {
		plugin = this;

		File Config = new File("plugins/Heads/config.yml");

		if (Config.exists()) {
			Bukkit.getConsoleSender().sendMessage("[Heads] Configuration was loaded successfully.");
			reloadConfig();
		} else {
			Bukkit.getConsoleSender().sendMessage("[Heads] Cant find a config, create a new one.");
			getConfig().options().copyDefaults(true);
			saveConfig();
		}

		registerCommands();
		registerListeners();
	}

	public static Main getPlugin() {
		return plugin;
	}

	private void registerCommands() {
		getCommand("gethead").setExecutor(new GetHeatCommand());
	}

	private void registerListeners() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new HeadRecipe(), this);
	}

}
