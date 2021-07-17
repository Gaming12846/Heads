package com.github.gaming12846.heads.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

/**
 * Heads com.github.gaming12846.heads.utils ItemBuilder.java
 *
 * @author Gaming12846
 */
public final class ItemBuilder {

    // Create an skull
    public static ItemStack createSkull(int amount, int subId, String name, String owner) {
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD, 1, (short) subId);
        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        meta.setOwner(owner);
        meta.setDisplayName(name);
        skull.setItemMeta(meta);
        return skull;
    }

}