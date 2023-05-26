/*
 * This file is part of Heads.
 * Copyright (C) 2023 Gaming12846
 */

package de.gaming12846.heads.utils;

import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public final class ItemBuilder {
    // Create a skull
    public static ItemStack createSkull(int amount, String name, OfflinePlayer owner) {
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD, amount);
        SkullMeta meta = (SkullMeta) skull.getItemMeta();

        assert meta != null;
        meta.setDisplayName(name);
        meta.setOwningPlayer(owner);
        skull.setItemMeta(meta);

        return skull;
    }
}