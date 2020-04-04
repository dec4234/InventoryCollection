package methodz;

import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_15_R1.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_15_R1.PacketPlayOutTitle;
import net.minecraft.server.v1_15_R1.PacketPlayOutTitle.EnumTitleAction;

public class AlertActions {

	public void actionBarMsg(Player p, String msg) {
		PacketPlayOutTitle packet = new PacketPlayOutTitle(EnumTitleAction.ACTIONBAR, ChatSerializer.a("{\"text\":\"" + ChatColor.translateAlternateColorCodes('&', msg)+ "\"}"), 20, 120, 20);
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
	}
}
