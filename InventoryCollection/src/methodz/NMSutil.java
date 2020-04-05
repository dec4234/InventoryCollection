package methodz;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import invSrc.InvMain;

public class NMSutil {

	private static NMShandler nms;
	private static InvMain main;
	
	public NMSutil(InvMain main) {
		NMSutil.main = main;
	}

	public static void setupNMS() {
		String version = null;

		try {
			version = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
		} catch (ArrayIndexOutOfBoundsException e) {
			Bukkit.getConsoleSender()
					.sendMessage(ChatColor.RED + "Something went wrong while loading NMS in InventoryCollection!");
		}
		if (version.equals("v1_8_R1")) {
			nms = new NMShandler_1_8_R1();
		} else if (version.equals("v1_8_R2")) {
			nms = new NMShandler_1_8_R2();
		} else if (version.equals("v1_8_R3")) {
			nms = new NMShandler_1_8_R3();
		} else if (version.equals("v1_9_R1")) {
			nms = new NMShandler_1_9_R1();
		} else if (version.equals("v1_9_R2")) {
			nms = new NMShandler_1_9_R2();
		} else if (version.equals("v1_10_R1")) {
			nms = new NMShandler_1_10_R1();
		} else if (version.equals("v1_11_R1")) {
			nms = new NMShandler_1_11_R1();
		} else if (version.equals("v1_12_R1")) {
			nms = new NMShandler_1_12_R1();
		} else if (version.equals("v1_13_R1")) {
			nms = new NMShandler_1_13_R1();
		} else if (version.equals("v1_13_R2")) {
			nms = new NMShandler_1_13_R2();
		} else if (version.equals("v1_14_R1")) {
			nms = new NMShandler_1_14_R1();
		}  else if (version.equals("v1_15_R1")) {
			nms = new NMShandler_1_15_R1();
		} else {
			Bukkit.getPluginManager().disablePlugin(main);
			Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD + "InventoryCollection is not compatible with the version of this server!");
		}

	}

	public static NMShandler getNMS() {
		return nms;
	}
}
