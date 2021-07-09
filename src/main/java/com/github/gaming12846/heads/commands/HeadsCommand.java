package com.github.gaming12846.heads.commands;

import com.github.gaming12846.heads.Heads;
import com.github.gaming12846.heads.utils.ItemBuilder;
import com.github.gaming12846.heads.utils.VMConstants;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;

/**
 * Heads com.github.gaming12846.heads.commands HeadsCommand.java
 *
 * @author Gaming12846
 */
public final class HeadsCommand implements CommandExecutor {

    private final Heads plugin;

    public HeadsCommand(Heads plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(VMConstants.PLUGIN_PREFIX + ChatColor.RED + "Invalid command syntax! " + ChatColor.WHITE + "Use /" + label + " <version|reload|gethead>");
            return true;
        }

        // Version subcommand
        if (args[0].equalsIgnoreCase("version")) {
            if (args.length < 1 || args.length > 1) {
                sender.sendMessage(VMConstants.PLUGIN_PREFIX + ChatColor.RED + "Invalid command syntax! " + ChatColor.WHITE + "Use /" + label + " version");
                return true;
            }

            PluginDescriptionFile description = plugin.getDescription();
            String headerFooter = ChatColor.DARK_GRAY.toString() + ChatColor.BOLD + ChatColor.STRIKETHROUGH + StringUtils.repeat("-", 44);

            sender.sendMessage(headerFooter);
            sender.sendMessage("");
            sender.sendMessage(ChatColor.BLUE + "Version: " + ChatColor.WHITE + description.getVersion());
            sender.sendMessage(ChatColor.BLUE + "Developer: " + ChatColor.WHITE + description.getAuthors().get(0));
            sender.sendMessage(ChatColor.BLUE + "Plugin website: " + ChatColor.WHITE + description.getWebsite());
            sender.sendMessage(ChatColor.BLUE + "Report bugs to: " + ChatColor.WHITE + "https://github.com/Gaming12846/Heads/issues");
            sender.sendMessage("");
            sender.sendMessage(headerFooter);
        }

        // Reload subcommand
        else if (args[0].equalsIgnoreCase("reload")) {
            if (args.length < 1 || args.length > 1) {
                sender.sendMessage(VMConstants.PLUGIN_PREFIX + ChatColor.RED + "Invalid command syntax! " + ChatColor.WHITE + "Use /" + label + " reload");
                return true;
            }

            if (!sender.hasPermission(VMConstants.PERMISSION_RELOAD)) {
                sender.sendMessage(ChatColor.RED + "You have insufficient permissions to perform this command");
                return true;
            }

            plugin.reloadConfig();

            sender.sendMessage(VMConstants.PLUGIN_PREFIX + ChatColor.GREEN + "Configuration successfully reloaded");
        }

        // Gethead subcommand
        else if (args[0].equalsIgnoreCase("gethead")) {
            if ((!sender.hasPermission(VMConstants.PERMISSION_GETHEAD_OWN)) || (!sender.hasPermission(VMConstants.PERMISSION_GETHEAD_PLAYER))) {
                sender.sendMessage(ChatColor.RED + "You have insufficient permissions to perform this command");
                return true;
            }

            if (args.length > 2) {
                sender.sendMessage(VMConstants.PLUGIN_PREFIX + ChatColor.RED + "Invalid command syntax! " + ChatColor.WHITE + "Use /" + label + " gethead <player>");
                return true;
            }

            if (!(sender instanceof Player)) {
                sender.sendMessage("Heads " + label + " subcommand cannot be used from the console");
                return true;
            }

            Player player = (Player) sender;
            if (args.length == 1 && player.hasPermission(VMConstants.PERMISSION_GETHEAD_OWN)) {
                player.getInventory().addItem(ItemBuilder.createSkull(1, 3, ChatColor.GOLD + player.getName(), player.getName()));
                player.sendMessage(VMConstants.PLUGIN_PREFIX + "You got your own head");

            } else if (args.length == 2 && player.hasPermission(VMConstants.PERMISSION_GETHEAD_PLAYER)) {
                player.getInventory().addItem(ItemBuilder.createSkull(1, 3, ChatColor.GOLD + args[1], args[1]));
                player.sendMessage(VMConstants.PLUGIN_PREFIX + "You got the head from " + ChatColor.BOLD + args[1]);
            }
        }

        // Unknown command usage
        else {
            sender.sendMessage(VMConstants.PLUGIN_PREFIX + ChatColor.RED + "Invalid command syntax! " + ChatColor.WHITE + "Use /" + label + " <version|reload|gethead>");
            return true;
        }

        return true;
    }

}