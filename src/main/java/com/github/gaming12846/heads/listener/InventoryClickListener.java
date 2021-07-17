package com.github.gaming12846.heads.listener;

import com.github.gaming12846.heads.Heads;
import com.github.gaming12846.heads.utils.ItemBuilder;
import com.github.gaming12846.heads.utils.VMConstants;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

/**
 * Heads com.github.gaming12846.heads.listener InventoryClickListener.java
 *
 * @author Gaming12846
 */
public final class InventoryClickListener implements Listener {

    private final Heads plugin;

    public InventoryClickListener(Heads plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        // Feature head recipe
        if (!plugin.getConfig().getBoolean(VMConstants.CONFIG_HEAD_RECIPE, true)) {
            return;
        }

        if (!player.hasPermission(VMConstants.PERMISSION_HEAD_RECIPE)) {
            return;
        }

        if (event.getCurrentItem() == null || event.getCurrentItem().getType() != Material.PAPER) {
            return;
        }

        String playerName = event.getCurrentItem().getItemMeta().getDisplayName();
        if (playerName == null) {
            return;
        }

        if (!playerName.isEmpty()) {
            ItemStack head = ItemBuilder.createSkull(1, 3, null, playerName);

            ShapedRecipe recipeCreeperHead = new ShapedRecipe(head);
            recipeCreeperHead.shape("CDC", "A A", "AAA");
            recipeCreeperHead.setIngredient('A', Material.CLAY);
            recipeCreeperHead.setIngredient('C', Material.IRON_INGOT);
            recipeCreeperHead.setIngredient('D', Material.PAPER);
            plugin.getServer().addRecipe(recipeCreeperHead);
        }
    }

}