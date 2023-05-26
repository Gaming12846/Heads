/*
 * This file is part of Heads.
 * Copyright (C) 2023 Gaming12846
 *
 * Heads is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Heads is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package de.gaming12846.heads;

import de.gaming12846.heads.commands.GetHeadCommand;
import de.gaming12846.heads.commands.HeadsCommand;
import de.gaming12846.heads.listener.InventoryClickListener;
import de.gaming12846.heads.metrics.Metrics;
import de.gaming12846.heads.utils.ConfigUtil;
import de.gaming12846.heads.utils.Constants;
import de.gaming12846.heads.utils.TabCompleter;
import de.gaming12846.heads.utils.UpdateChecker;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.logging.Logger;

public class Heads extends JavaPlugin {
    public static final Logger BUKKIT_LOGGER = Logger.getLogger("TrollPlus");
    public boolean updateAvailable = false;

    // Create ConfigUtils
    private ConfigUtil langCustomConfig;
    private ConfigUtil langEnglishConfig;

    @Override
    public void onEnable() {
        // Load configs
        loadConfigs();

        // Register listeners
        registerListener(getServer().getPluginManager());

        // Register commands
        registerCommands();

        // Register tabcompleter
        registerTabCompleter();

        // Check for updates
        checkUpdate();

        // Metrics
        if (getConfig().getBoolean("metrics-enabled", true)) {
            BUKKIT_LOGGER.info(Constants.PLUGIN_CONSOLE_PREFIX + getLanguageConfig().getConfig().getString("metrics-enabled"));

            Metrics metrics = new Metrics(this, 11987);
        }
    }

    // Load configs
    private void loadConfigs() {
        this.saveDefaultConfig();

        langCustomConfig = new ConfigUtil(this, "lang_custom.yml");
        langEnglishConfig = new ConfigUtil(this, "lang_en.yml");

        Constants constants = new Constants(this);
    }

    public ConfigUtil getLanguageConfig() {
        if (Objects.equals(getConfig().getString("language"), "custom")) {
            return langCustomConfig;
        } else return langEnglishConfig;
    }

    // Register listeners
    private void registerListener(PluginManager pm) {
        pm.registerEvents(new InventoryClickListener(this), this);
    }

    // Register commands
    private void registerCommands() {
        Objects.requireNonNull(this.getCommand("heads")).setExecutor(new HeadsCommand(this));
        Objects.requireNonNull(this.getCommand("gethead")).setExecutor(new GetHeadCommand(this));
    }

    // Register tabcompleter
    private void registerTabCompleter() {
        Objects.requireNonNull(this.getCommand("heads")).setTabCompleter(new TabCompleter());
        Objects.requireNonNull(this.getCommand("gethead")).setTabCompleter(new TabCompleter());
    }

    // Check for Update
    private void checkUpdate() {
        if (getConfig().getBoolean("check-for-updates", true)) {
            BUKKIT_LOGGER.info(Constants.PLUGIN_CONSOLE_PREFIX + getLanguageConfig().getConfig().getString("checking-updates"));

            new UpdateChecker(this, 81202).getVersion(version -> {
                if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                    BUKKIT_LOGGER.info(Constants.PLUGIN_CONSOLE_PREFIX + getLanguageConfig().getConfig().getString("no-update-available"));
                } else {
                    BUKKIT_LOGGER.info(Constants.PLUGIN_CONSOLE_PREFIX + getLanguageConfig().getConfig().getString("update-available") + " https://www.spigotmc.org/resources/81202");

                    updateAvailable = true;
                }
            });
        }
    }
}