/*
 * This file is part of Heads.
 * Copyright (C) 2023 Gaming12846
 */

package de.gaming12846.heads.utils;

import de.gaming12846.heads.Heads;
import org.bukkit.ChatColor;

public final class Constants {
    // Plugin presets
    public static final String PLUGIN_PREFIX = ChatColor.DARK_GRAY + "[" + ChatColor.DARK_BLUE + ChatColor.BOLD + "Heads" + ChatColor.RESET + ChatColor.DARK_GRAY + "]" + ChatColor.RESET + " ";
    public static final String PLUGIN_CONSOLE_PREFIX = "[Heads] ";

    // Permission nodes
    public static final String PERMISSION_RELOAD = "heads.reload";

    public static final String PERMISSION_GETHEAD_OWN = "heads.gethead.own";
    public static final String PERMISSION_GETHEAD_OTHER = "heads.gethead.other";

    public static final String PERMISSION_HEAD_RECIPE = "heads.headrecipe";

    // Plugin info messages presets
    public static String PLUGIN_NO_PERMISSION;
    public static String PLUGIN_NO_CONSOLE;
    public static String PLUGIN_INVALID_SYNTAX;

    public Constants(Heads plugin) {
        PLUGIN_NO_PERMISSION = ChatColor.RED + plugin.getLanguageConfig().getConfig().getString("no-permission");
        PLUGIN_NO_CONSOLE = " " + plugin.getLanguageConfig().getConfig().getString("no-console");
        PLUGIN_INVALID_SYNTAX = PLUGIN_PREFIX + ChatColor.RED + plugin.getLanguageConfig().getConfig().getString("invalid-syntax") + " " + ChatColor.RESET + plugin.getLanguageConfig().getConfig().getString("invalid-syntax-use");
    }
}