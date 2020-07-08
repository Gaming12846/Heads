/*

Plugin by Gaming12846

*/

package de.gaming12846.heads.main;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.gaming12846.heads.commands.GetHeatCommand;

public class Main extends JavaPlugin {

	private static Main plugin;

	@Override
	public void onEnable() {
		plugin = this;

		File Config = new File("plugins/Heads/config.yml");

		if (Config.exists()) {
			Bukkit.getConsoleSender().sendMessage("[Heads] Config was loaded.");
			loadConfig();
		} else {
			Bukkit.getConsoleSender().sendMessage("[Heads] Cant find a config, create a new one.");
			loadConfig();
		}

		registerCommands();
	}

	public static Main getPlugin() {
		return plugin;
	}

	private void loadConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}

	private void registerCommands() {
		getCommand("gethead").setExecutor(new GetHeatCommand());
	}

}
