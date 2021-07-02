/**
 * Heads
 * 
 * @author Gaming12846
 */

package de.gaming12846.heads.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.gaming12846.heads.utilitys.ItemBuilder;
import de.gaming12846.heads.utilitys.Vars;
import net.md_5.bungee.api.ChatColor;

public class GetHeadCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("gethead")) {

			if (sender instanceof Player) {
				Player p = (Player) sender;

				if (p.hasPermission("heads.gethead")) {

					if (args.length == 0) {
						p.getInventory().addItem(ItemBuilder.createSkull(3, ChatColor.RED + p.getName(), p.getName()));
						p.sendMessage(Vars.Messages.gotOwnHead);
					} else if (args.length == 1) {
						p.getInventory().addItem(ItemBuilder.createSkull(3, ChatColor.RED + args[0], args[0]));
						String playerHead = Vars.Messages.gotPlayerHead.replace("[Player]", ChatColor.BOLD + args[0] + ChatColor.RESET);
						p.sendMessage(playerHead);
					} else
						p.sendMessage(Vars.Messages.usageGetHead);
				} else
					p.sendMessage(Vars.Messages.noPermission);
			} else
				sender.sendMessage(Vars.Messages.noConsole);
		}
		return true;
	}
}
