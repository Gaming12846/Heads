/*
 * This file is part of Heads.
 * Copyright (C) 2023 Gaming12846
 */

package de.gaming12846.heads.commands;

import de.gaming12846.heads.Heads;
import de.gaming12846.heads.utils.Constants;
import de.gaming12846.heads.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class GetHeadCommand implements CommandExecutor {
    private final Heads plugin;

    public GetHeadCommand(Heads plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Constants.PLUGIN_PREFIX + label + Constants.PLUGIN_NO_CONSOLE);
            return true;
        }

        Player player = (Player) sender;
        if (!player.hasPermission(Constants.PERMISSION_GETHEAD_OWN) || !player.hasPermission(Constants.PERMISSION_GETHEAD_OTHER)) {
            player.sendMessage(Constants.PLUGIN_NO_PERMISSION);
            return true;
        }

        FileConfiguration langConfig = plugin.getLanguageConfig().getConfig();
        if (args.length == 0) {
            player.getInventory().addItem(ItemBuilder.createSkull(1, ChatColor.GOLD + ChatColor.BOLD.toString() + player.getName(), player));
            player.sendMessage(Constants.PLUGIN_PREFIX + langConfig.getString("gethead-own-head"));
        } else if (args.length == 1) {
            if (!player.hasPermission(Constants.PERMISSION_GETHEAD_OTHER)) {
                player.sendMessage(Constants.PLUGIN_NO_PERMISSION);
                return true;
            } else {
                player.getInventory().addItem(ItemBuilder.createSkull(1, ChatColor.GOLD + ChatColor.BOLD.toString() + args[0], Bukkit.getOfflinePlayer(args[0])));
                if (args[0].equals(player.getName())) {
                    player.sendMessage(Constants.PLUGIN_PREFIX + langConfig.getString("gethead-own-head"));
                } else
                    player.sendMessage(Constants.PLUGIN_PREFIX + langConfig.getString("gethead-target-head") + " " + ChatColor.GOLD + ChatColor.BOLD + args[0]);
            }
        } else {
            if (player.hasPermission(Constants.PERMISSION_GETHEAD_OTHER)) {
                player.sendMessage(Constants.PLUGIN_INVALID_SYNTAX + label + " <player>");
            } else player.sendMessage(Constants.PLUGIN_INVALID_SYNTAX + label);
            return true;
        }

        return true;
    }
}