/*

Plugin by Gaming12846

*/

package de.gaming12846.heads.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import de.gaming12846.heads.utilitys.Var;

public class GetHeatCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("gethead")) {

			if (sender instanceof Player) {
				Player p = (Player) sender;

				if (p.hasPermission("heads.gethead")) {

					if (args.length == 0) {
						ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) 3);
						SkullMeta meta = (SkullMeta) skull.getItemMeta();
						meta.setOwner(p.getName());
						skull.setItemMeta(meta);
						p.getInventory().addItem(skull);
						p.sendMessage(Var.getownhead);
					} else if (args.length == 1) {
						ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) 3);
						SkullMeta meta = (SkullMeta) skull.getItemMeta();
						meta.setOwner(args[0]);
						skull.setItemMeta(meta);
						p.getInventory().addItem(skull);
						String playerhead = "";
						playerhead = Var.getplayerhead.replace("[Player]", args[0]);
						p.sendMessage(playerhead);
					} else
						p.sendMessage(Var.usagegethead);

				} else
					p.sendMessage(Var.nopermission);

			} else
				sender.sendMessage(Var.noconsole);

		}

		return false;
	}

}
