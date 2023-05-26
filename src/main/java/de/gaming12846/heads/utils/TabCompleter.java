/*
 * This file is part of Heads.
 * Copyright (C) 2023 Gaming12846
 */

package de.gaming12846.heads.utils;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TabCompleter implements org.bukkit.command.TabCompleter {
    final List<String> results = new ArrayList<>();

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getLabel().equalsIgnoreCase("heads")) {
            if (args.length == 1) {
                results.clear();
                results.add("version");
                if (sender.hasPermission(Constants.PERMISSION_RELOAD)) {
                    results.add("reload");
                }
            } else results.clear();
        } else if (cmd.getLabel().equalsIgnoreCase("gethead") && sender.hasPermission(Constants.PERMISSION_GETHEAD_OTHER)) {
            if (args.length == 1) {
                results.clear();

                for (Player p : Bukkit.getOnlinePlayers()) {
                    results.add(p.getName());
                }
            } else results.clear();
        }

        return results;
    }
}