/*

Plugin by Gaming12846

*/

package de.gaming12846.heads.utilitys;

import de.gaming12846.heads.main.Main;

public class Var {
	public static String prefix = "§f[§bHeads§f] ";
	public static String nopermission = prefix + Main.getPlugin().getConfig().getString("message.nopermission");
	public static String noconsole = "[Heads] " + Main.getPlugin().getConfig().getString("message.noconsole");
	public static String usagegethead = prefix + Main.getPlugin().getConfig().getString("message.usagegethead");
	public static String getownhead = prefix + Main.getPlugin().getConfig().getString("message.getownhead");
	public static String getplayerhead = prefix + Main.getPlugin().getConfig().getString("message.getplayerhead");
}
