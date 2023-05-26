/*
 * This file is part of Heads.
 * Copyright (C) 2023 Gaming12846
 */

package de.gaming12846.heads.commands;

import de.gaming12846.heads.Heads;
import de.gaming12846.heads.utils.Constants;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;

public final class HeadsCommand implements CommandExecutor {

    private final Heads plugin;

    public HeadsCommand(Heads plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(Constants.PLUGIN_INVALID_SYNTAX + label + " <version|reload>");
            return true;
        }

        FileConfiguration langConfig = plugin.getLanguageConfig().getConfig();

        // Version subcommand
        if (args[0].equalsIgnoreCase("version")) {
            if (args.length != 1) {
                sender.sendMessage(Constants.PLUGIN_INVALID_SYNTAX + label + " version");
                return true;
            }

            PluginDescriptionFile description = plugin.getDescription();
            String headerFooter = ChatColor.DARK_GRAY.toString() + ChatColor.BOLD + StringUtils.repeat("-", 44);

            sender.sendMessage(headerFooter);
            sender.sendMessage("");
            sender.sendMessage(ChatColor.RED + langConfig.getString("heads-version") + " " + ChatColor.WHITE + description.getVersion());
            sender.sendMessage(ChatColor.RED + langConfig.getString("heads-developer") + " " + ChatColor.WHITE + description.getAuthors().get(0));
            sender.sendMessage(ChatColor.RED + langConfig.getString("heads-plugin-website") + " " + ChatColor.WHITE + description.getWebsite());
            sender.sendMessage(ChatColor.RED + langConfig.getString("heads-report-bugs") + ChatColor.WHITE + " https://github.com/Gaming12846/Heads/issues");
            sender.sendMessage("");
            sender.sendMessage(headerFooter);

            if (plugin.updateAvailable) {
                sender.sendMessage(langConfig.getString("update-available") + " https://www.spigotmc.org/resources/81202");
            }
        }
        // Reload subcommand
        else if (args[0].equalsIgnoreCase("reload")) {
            if (!sender.hasPermission(Constants.PERMISSION_RELOAD)) {
                sender.sendMessage(Constants.PLUGIN_NO_PERMISSION);
                return true;
            }

            if (args.length != 1) {
                sender.sendMessage(Constants.PLUGIN_INVALID_SYNTAX + label + " reload");
                return true;
            }

            plugin.reloadConfig();
            plugin.getLanguageConfig().reload();

            sender.sendMessage(Constants.PLUGIN_PREFIX + ChatColor.GREEN + langConfig.getString("heads-reload"));
        }
        // Unknown command usage
        else {
            sender.sendMessage(Constants.PLUGIN_INVALID_SYNTAX + label + " <version|reload|blocklist>");
            return true;
        }

        return true;
    }
}