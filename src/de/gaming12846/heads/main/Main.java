/**
 * Heads
 * 
 * @author Gaming12846
 */

package de.gaming12846.heads.main;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.gaming12846.heads.commands.GetHeadCommand;
import de.gaming12846.heads.features.HeadRecipe;
import de.gaming12846.heads.utilitys.ConfigLoader;
import de.gaming12846.heads.utilitys.UpdateChecker;
import de.gaming12846.heads.utilitys.Vars;

public class Main extends JavaPlugin {

	private static Main plugin;
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

		new UpdateChecker(this, 81202).getVersion(version -> {
			if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
				logger.info(Vars.consolePrefix + "There is no new update available");
			} else {
				logger.info(Vars.consolePrefix + "There is a new update available");
				logger.info(Vars.consolePrefix
						+ "To download the latest version visit: https://www.spigotmc.org/resources/heads.81202 or https://github.com/Gaming12846/Heads/releases");
			}
		});
	}

	public static Main getPlugin() {
		return plugin;
	}

	// Register commands
	private void registerCommands() {
		getCommand("gethead").setExecutor(new GetHeadCommand());
	}

	// Register listeners
	private void registerListeners() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new HeadRecipe(), this);
	}
}
