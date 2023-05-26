/*
 * This file is part of Heads.
 * Copyright (C) 2023 Gaming12846
 */

package de.gaming12846.heads.listener;

import de.gaming12846.heads.Heads;
import de.gaming12846.heads.utils.Constants;
import de.gaming12846.heads.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public final class InventoryClickListener implements Listener {
    private final Heads plugin;
    private NamespacedKey key;

    public InventoryClickListener(Heads plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        // Head recipe
        if (!plugin.getConfig().getBoolean("head-recipe", true)) return;

        if (!player.hasPermission(Constants.PERMISSION_HEAD_RECIPE)) return;

        if (event.getCurrentItem() == null || event.getInventory().getType() != InventoryType.WORKBENCH || event.getCurrentItem().getType() != Material.valueOf(plugin.getConfig().getString("head-recipe-X")))
            return;

        String playerName = event.getCurrentItem().getItemMeta().getDisplayName();
        player.sendMessage(playerName);
        if (!playerName.isEmpty()) {
            if (key != null) plugin.getServer().removeRecipe(key);

            ItemStack head = ItemBuilder.createSkull(1, playerName, Bukkit.getOfflinePlayer(playerName));
            key = new NamespacedKey(plugin, "head_" + playerName);
            ShapedRecipe recipeHead = new ShapedRecipe(key, head);
            recipeHead.shape("AXB", "CDE", "FGH");
            recipeHead.setIngredient('X', Material.valueOf(plugin.getConfig().getString("head-recipe-X")));
            recipeHead.setIngredient('A', Material.valueOf(plugin.getConfig().getString("head-recipe-A")));
            recipeHead.setIngredient('B', Material.valueOf(plugin.getConfig().getString("head-recipe-B")));
            recipeHead.setIngredient('C', Material.valueOf(plugin.getConfig().getString("head-recipe-C")));
            recipeHead.setIngredient('D', Material.valueOf(plugin.getConfig().getString("head-recipe-D")));
            recipeHead.setIngredient('E', Material.valueOf(plugin.getConfig().getString("head-recipe-E")));
            recipeHead.setIngredient('F', Material.valueOf(plugin.getConfig().getString("head-recipe-F")));
            recipeHead.setIngredient('G', Material.valueOf(plugin.getConfig().getString("head-recipe-G")));
            recipeHead.setIngredient('H', Material.valueOf(plugin.getConfig().getString("head-recipe-H")));
            plugin.getServer().addRecipe(recipeHead);
        }
    }
}