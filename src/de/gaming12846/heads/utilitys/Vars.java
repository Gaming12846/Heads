/**
 * Heads
 * 
 * @author Gaming12846
 */

package de.gaming12846.heads.utilitys;

import de.gaming12846.heads.main.Main;

public class Vars {
	public static String prefix = "§8[§b§lHeads§8]§f ";
	public static String consolePrefix = "[Heads] ";

	// Switches
	public static class Switches {
		public static boolean headRecipeSwitch = Main.getPlugin().getConfig().getBoolean("switches.headRecipeSwitch");
	}

	// Messages
	public static class Messages {
		public static String noPermission = Main.getPlugin().getConfig().getString("messages.noPermission");
		public static String noConsole = prefix + Main.getPlugin().getConfig().getString("messages.noConsole");

		public static String usageGetHead = prefix + Main.getPlugin().getConfig().getString("messages.usageGetHead");

		public static String gotOwnHead = prefix + Main.getPlugin().getConfig().getString("messages.gotOwnHead");
		public static String gotPlayerHead = prefix + Main.getPlugin().getConfig().getString("messages.gotPlayerHead");
	}
}
