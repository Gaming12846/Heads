/**
 * Heads
 * 
 * @author Gaming12846
 */

package de.gaming12846.heads.features;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import de.gaming12846.heads.main.Main;
import de.gaming12846.heads.utilitys.ItemBuilder;
import de.gaming12846.heads.utilitys.Vars;
import net.md_5.bungee.api.ChatColor;

public class HeadRecipe implements Listener {

	@EventHandler
	public void InventoryClickEvent(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if (Vars.Switches.headRecipeSwitch == true) {

			if (p.hasPermission("heads.headrecipe")) {

				try {

					if (e.getCurrentItem().getType() == Material.PAPER) {
						String playername = e.getCurrentItem().getItemMeta().getDisplayName();
						ItemStack head = ItemBuilder.createSkull(3, ChatColor.RED + playername, playername);
						ShapedRecipe recipe = new ShapedRecipe(head);

						recipe.shape("CDC", "BAB", "BBB");
						recipe.setIngredient('A', Material.CREEPER_HEAD);
						recipe.setIngredient('B', Material.CLAY_BALL);
						recipe.setIngredient('C', Material.IRON_INGOT);
						recipe.setIngredient('D', Material.PAPER);
						Main.getPlugin().getServer().addRecipe(recipe);
					}
					if (e.getCurrentItem().getType() == Material.PAPER) {
						String playername = e.getCurrentItem().getItemMeta().getDisplayName();
						ItemStack head = ItemBuilder.createSkull(3, ChatColor.RED + playername, playername);
						ShapedRecipe recipe = new ShapedRecipe(head);

						recipe.shape("CDC", "BAB", "BBB");
						recipe.setIngredient('A', Material.DRAGON_HEAD);
						recipe.setIngredient('B', Material.CLAY_BALL);
						recipe.setIngredient('C', Material.IRON_INGOT);
						recipe.setIngredient('D', Material.PAPER);
						Main.getPlugin().getServer().addRecipe(recipe);
					}
					if (e.getCurrentItem().getType() == Material.PAPER) {
						String playername = e.getCurrentItem().getItemMeta().getDisplayName();
						ItemStack head = ItemBuilder.createSkull(3, ChatColor.RED + playername, playername);
						ShapedRecipe recipe = new ShapedRecipe(head);

						recipe.shape("CDC", "BAB", "BBB");
						recipe.setIngredient('A', Material.PLAYER_HEAD);
						recipe.setIngredient('B', Material.CLAY_BALL);
						recipe.setIngredient('C', Material.IRON_INGOT);
						recipe.setIngredient('D', Material.PAPER);
						Main.getPlugin().getServer().addRecipe(recipe);
					}
					if (e.getCurrentItem().getType() == Material.PAPER) {
						String playername = e.getCurrentItem().getItemMeta().getDisplayName();
						ItemStack head = ItemBuilder.createSkull(3, ChatColor.RED + playername, playername);
						ShapedRecipe recipe = new ShapedRecipe(head);

						recipe.shape("CDC", "BAB", "BBB");
						recipe.setIngredient('A', Material.ZOMBIE_HEAD);
						recipe.setIngredient('B', Material.CLAY_BALL);
						recipe.setIngredient('C', Material.IRON_INGOT);
						recipe.setIngredient('D', Material.PAPER);
						Main.getPlugin().getServer().addRecipe(recipe);
					}
					if (e.getCurrentItem().getType() == Material.PAPER) {
						String playername = e.getCurrentItem().getItemMeta().getDisplayName();
						ItemStack head = ItemBuilder.createSkull(3, ChatColor.RED + playername, playername);
						ShapedRecipe recipe = new ShapedRecipe(head);

						recipe.shape("CDC", "BAB", "BBB");
						recipe.setIngredient('A', Material.LEGACY_SKULL_ITEM);
						recipe.setIngredient('B', Material.CLAY_BALL);
						recipe.setIngredient('C', Material.IRON_INGOT);
						recipe.setIngredient('D', Material.PAPER);
						Main.getPlugin().getServer().addRecipe(recipe);
					}
					if (e.getCurrentItem().getType() == Material.PAPER) {
						String playername = e.getCurrentItem().getItemMeta().getDisplayName();
						ItemStack head = ItemBuilder.createSkull(3, ChatColor.RED + playername, playername);
						ShapedRecipe recipe = new ShapedRecipe(head);

						recipe.shape("CDC", "BAB", "BBB");
						recipe.setIngredient('A', Material.SKELETON_SKULL);
						recipe.setIngredient('B', Material.CLAY_BALL);
						recipe.setIngredient('C', Material.IRON_INGOT);
						recipe.setIngredient('D', Material.PAPER);
						Main.getPlugin().getServer().addRecipe(recipe);
					}
					if (e.getCurrentItem().getType() == Material.PAPER) {
						String playername = e.getCurrentItem().getItemMeta().getDisplayName();
						ItemStack head = ItemBuilder.createSkull(3, ChatColor.RED + playername, playername);
						ShapedRecipe recipe = new ShapedRecipe(head);

						recipe.shape("CDC", "BAB", "BBB");
						recipe.setIngredient('A', Material.WITHER_SKELETON_SKULL);
						recipe.setIngredient('B', Material.CLAY_BALL);
						recipe.setIngredient('C', Material.IRON_INGOT);
						recipe.setIngredient('D', Material.PAPER);
						Main.getPlugin().getServer().addRecipe(recipe);
					}
				} catch (Exception e1) {

				}
			}
		}
	}
}
