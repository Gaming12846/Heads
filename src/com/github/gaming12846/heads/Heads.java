package com.github.gaming12846.heads;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.gaming12846.heads.commands.GetHeadCommand;
import com.github.gaming12846.heads.features.HeadRecipeFeature;
import com.github.gaming12846.heads.utils.ConfigLoader;
import com.github.gaming12846.heads.utils.UpdateChecker;
import com.github.gaming12846.heads.utils.Vars;

/**
 * Heads com.github.gaming12846.heads Heads.java
 *
 * @author Gaming12846
 */
public class Heads extends JavaPlugin {
	private static Heads plugin;
	public static Logger logger = Bukkit.getLogger();

	// Plugin disable
	@Override
	public void onDisable() {
	}

	// Plugin enable
	@Override
	public void onEnable() {
		plugin = this;

		ConfigLoader.ConfigLoader();
		registerCommands();
		registerListeners();

		if (Vars.Booleans.checkForUpdates == true) {
			new UpdateChecker(this, 81202).getVersion(version -> {

				if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
					logger.info(Vars.consolePrefix + "There is no new update available");
				} else {
					logger.info(Vars.consolePrefix + "There is a new update available");
					logger.info(Vars.consolePrefix
							+ "To download the latest version visit: https://www.spigotmc.org/resources/81202/ , https://github.com/Gaming12846/Heads/releases or https://discord.com/invite/XvK2UMfGEJ");
				}
			});
		}
	}

	public static Heads getPlugin() {
		return plugin;
	}

	// Register commands
	private void registerCommands() {
		getCommand("gethead").setExecutor(new GetHeadCommand());
	}

	// Register listeners
	private void registerListeners() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new HeadRecipeFeature(), this);
	}
}