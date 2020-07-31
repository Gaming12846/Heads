/*
Heads by Gaming12846
*/

package de.gaming12846.heads.features;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.SkullMeta;

import de.gaming12846.heads.utilitys.Config;

public class HeadRecipe implements Listener {

	private static String playername;

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if (Config.enableheadrecipe == true) {

			if (p.hasPermission("heads.headrecipe")) {

				try {

					if (e.getCurrentItem().getType() == Material.PAPER) {
						playername = e.getCurrentItem().getItemMeta().getDisplayName();

						ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) 3);
						SkullMeta meta = (SkullMeta) skull.getItemMeta();
						meta.setOwner(playername);
						skull.setItemMeta(meta);

						ShapedRecipe recipe = new ShapedRecipe(skull);

						recipe.shape("ACA", "BDB", "ABA");

						recipe.setIngredient('A', Material.IRON_INGOT);
						recipe.setIngredient('B', Material.REDSTONE);
						recipe.setIngredient('C', Material.PAPER);
						recipe.setIngredient('D', Material.CREEPER_HEAD);

						Bukkit.addRecipe(recipe);
					}

					if (e.getCurrentItem().getType() == Material.PAPER) {
						playername = e.getCurrentItem().getItemMeta().getDisplayName();

						ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) 3);
						SkullMeta meta = (SkullMeta) skull.getItemMeta();
						meta.setOwner(playername);
						skull.setItemMeta(meta);

						ShapedRecipe recipe = new ShapedRecipe(skull);

						recipe.shape("ACA", "BDB", "ABA");

						recipe.setIngredient('A', Material.IRON_INGOT);
						recipe.setIngredient('B', Material.REDSTONE);
						recipe.setIngredient('C', Material.PAPER);
						recipe.setIngredient('D', Material.DRAGON_HEAD);

						Bukkit.addRecipe(recipe);
					}

					if (e.getCurrentItem().getType() == Material.PAPER) {
						playername = e.getCurrentItem().getItemMeta().getDisplayName();

						ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) 3);
						SkullMeta meta = (SkullMeta) skull.getItemMeta();
						meta.setOwner(playername);
						skull.setItemMeta(meta);

						ShapedRecipe recipe = new ShapedRecipe(skull);

						recipe.shape("ACA", "BDB", "ABA");

						recipe.setIngredient('A', Material.IRON_INGOT);
						recipe.setIngredient('B', Material.REDSTONE);
						recipe.setIngredient('C', Material.PAPER);
						recipe.setIngredient('D', Material.PLAYER_HEAD);

						Bukkit.addRecipe(recipe);
					}

					if (e.getCurrentItem().getType() == Material.PAPER) {
						playername = e.getCurrentItem().getItemMeta().getDisplayName();

						ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) 3);
						SkullMeta meta = (SkullMeta) skull.getItemMeta();
						meta.setOwner(playername);
						skull.setItemMeta(meta);

						ShapedRecipe recipe = new ShapedRecipe(skull);

						recipe.shape("ACA", "BDB", "ABA");

						recipe.setIngredient('A', Material.IRON_INGOT);
						recipe.setIngredient('B', Material.REDSTONE);
						recipe.setIngredient('C', Material.PAPER);
						recipe.setIngredient('D', Material.ZOMBIE_HEAD);

						Bukkit.addRecipe(recipe);
					}

					if (e.getCurrentItem().getType() == Material.PAPER) {
						playername = e.getCurrentItem().getItemMeta().getDisplayName();

						ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) 3);
						SkullMeta meta = (SkullMeta) skull.getItemMeta();
						meta.setOwner(playername);
						skull.setItemMeta(meta);

						ShapedRecipe recipe = new ShapedRecipe(skull);

						recipe.shape("ACA", "BDB", "ABA");

						recipe.setIngredient('A', Material.IRON_INGOT);
						recipe.setIngredient('B', Material.REDSTONE);
						recipe.setIngredient('C', Material.PAPER);
						recipe.setIngredient('D', Material.SKELETON_SKULL);

						Bukkit.addRecipe(recipe);
					}

					if (e.getCurrentItem().getType() == Material.PAPER) {
						playername = e.getCurrentItem().getItemMeta().getDisplayName();

						ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) 3);
						SkullMeta meta = (SkullMeta) skull.getItemMeta();
						meta.setOwner(playername);
						skull.setItemMeta(meta);

						ShapedRecipe recipe = new ShapedRecipe(skull);

						recipe.shape("ACA", "BDB", "ABA");

						recipe.setIngredient('A', Material.IRON_INGOT);
						recipe.setIngredient('B', Material.REDSTONE);
						recipe.setIngredient('C', Material.PAPER);
						recipe.setIngredient('D', Material.WITHER_SKELETON_SKULL);

						Bukkit.addRecipe(recipe);
					}

				} catch (Exception e1) {

				}

			}

		}

	}

}
