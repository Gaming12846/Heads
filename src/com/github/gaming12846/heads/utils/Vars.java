package com.github.gaming12846.heads.utils;

import com.github.gaming12846.heads.Heads;

/**
 * Heads com.github.gaming12846.heads.utils Vas.java
 *
 * @author Gaming12846
 */
public class Vars {
	public static String prefix = "§8[§b§lHeads§8]§f ";
	public static String consolePrefix = "[Heads] ";

	// Booleans
	public static class Booleans {
		public static boolean checkForUpdates = Heads.getPlugin().getConfig().getBoolean("CheckForUpdates");

		public static boolean headRecipeSwitch = Heads.getPlugin().getConfig().getBoolean("Features.HeadRecipeSwitch");
	}

	// Messages
	public static class Messages {
		public static String noPermission = Heads.getPlugin().getConfig().getString("Messages.NoPermission");
		public static String noConsole = prefix + Heads.getPlugin().getConfig().getString("Messages.NoConsole");

		public static String usageGetHead = prefix + Heads.getPlugin().getConfig().getString("Messages.UsageGetHead");

		public static String gotOwnHead = prefix + Heads.getPlugin().getConfig().getString("Messages.GotOwnHead");
		public static String gotPlayerHead = prefix + Heads.getPlugin().getConfig().getString("Messages.GotPlayerHead");
	}
}