package com.github.gaming12846.heads;

import com.github.gaming12846.heads.commands.HeadsCommand;
import com.github.gaming12846.heads.listener.InventoryClickListener;
import com.github.gaming12846.heads.metrics.BStats;
import com.github.gaming12846.heads.utils.UpdateChecker;
import com.github.gaming12846.heads.utils.VMConstants;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Heads extends JavaPlugin {

    @Override
    public void onEnable() {
        // Configs
        this.saveDefaultConfig();

        // Register events
        this.getLogger().info("Registering events");
        registerEvents();

        // Register commands
        this.getLogger().info("Registering commands");
        registerCommands();

        // Metrics
        if (getConfig().getBoolean(VMConstants.CONFIG_METRICS_ENABLED, true)) {
            this.getLogger().info("Enabling plugin metrics");

            BStats metrics = new BStats(this, 11987);
        }

        // Update checker
        if (getConfig().getBoolean(VMConstants.CONFIG_CHECK_FOR_UPDATES, true)) {
            this.getLogger().info("Checking for updates");

            new UpdateChecker(this, 81202).getVersion(version -> {

                if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                    this.getLogger().info("There is no new update available");
                } else {
                    this.getLogger().info("A new update is available! To download it visit SpigotMC: https://www.spigotmc.org/resources/81202/");
                }

            });
        }
    }

    // Register events
    private void registerEvents() {
        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new InventoryClickListener(this), this);
    }

    // Register commands
    private void registerCommands() {
        this.getCommand("heads").setExecutor(new HeadsCommand(this));
    }

}