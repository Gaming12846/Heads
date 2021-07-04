package com.github.gaming12846.heads.utils;

import java.io.File;

import com.github.gaming12846.heads.Heads;

/**
 * Heads com.github.gaming12846.heads.utils ConfigLoader.java
 *
 * @author Gaming12846
 */
public class ConfigLoader {
	public static void ConfigLoader() {
		// Loading the main config
		File Config = new File(Heads.getPlugin().getDataFolder(), "config.yml");

		if (Config.exists()) {
			Heads.logger.info(Vars.consolePrefix + "Config was loaded successfully");
			Heads.getPlugin().reloadConfig();
		} else {
			Heads.logger.info(Vars.consolePrefix + "Can't find a config, create a new one");
			Heads.getPlugin().getConfig().options().copyDefaults(true);
			Heads.getPlugin().saveConfig();
		}
	}
}