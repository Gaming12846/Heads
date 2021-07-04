package com.github.gaming12846.heads.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

/**
 * Heads com.github.gaming12846.heads.utils ItemBuilder.java
 *
 * @author Gaming12846
 */
public class ItemBuilder {
	// Easy method to create an skull
	public static ItemStack createSkull(int subid, String name, String owner) {
		ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) subid);
		SkullMeta meta = (SkullMeta) skull.getItemMeta();
		meta.setOwner(owner);
		meta.setDisplayName(name);
		skull.setItemMeta(meta);
		return skull;
	}
}