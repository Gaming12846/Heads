/*
Heads by Gaming12846
*/

package de.gaming12846.heads.utilitys;

import de.gaming12846.heads.main.Main;

public class Config {
	public static String nopermission = Var.prefix + Main.getPlugin().getConfig().getString("messages.nopermission");
	public static String noconsole = "[Heads] " + Main.getPlugin().getConfig().getString("messages.noconsole");
	public static String usagegethead = Var.prefix + Main.getPlugin().getConfig().getString("messages.usagegethead");
	public static String getownhead = Var.prefix + Main.getPlugin().getConfig().getString("messages.getownhead");
	public static String getplayerhead = Var.prefix + Main.getPlugin().getConfig().getString("messages.getplayerhead");
	public static String unkowncommand = Main.getPlugin().getConfig().getString("messages.unkowncommand");

	public static boolean enablegethead = Main.getPlugin().getConfig().getBoolean("features.enablegethead");
	public static boolean enableheadmenu = Main.getPlugin().getConfig().getBoolean("features.enableheadmenu");
	public static boolean enableheadrecipe = Main.getPlugin().getConfig().getBoolean("features.enableheadrecipe");
}
