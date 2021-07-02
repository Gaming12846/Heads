/**
 * Heads
 * 
 * @author Gaming12846
 */

package de.gaming12846.heads.utilitys;

import java.io.File;

import de.gaming12846.heads.main.Main;

public class ConfigLoader {

	// Loading the configs
	public static void ConfigLoader() {
		// Loading the main config
		File Config = new File(Main.getPlugin().getDataFolder(), "config.yml");

		if (Config.exists()) {
			Main.logger.info(Vars.consolePrefix + "Config was loaded successfully");
			Main.getPlugin().reloadConfig();
		} else {
			Main.logger.info(Vars.consolePrefix + "Can't find a config, create a new one");
			Main.getPlugin().getConfig().options().copyDefaults(true);
			Main.getPlugin().saveConfig();
		}
	}
}
