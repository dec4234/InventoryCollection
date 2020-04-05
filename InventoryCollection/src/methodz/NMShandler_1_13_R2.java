package methodz;

import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_13_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_13_R2.PacketPlayOutTitle;
import net.minecraft.server.v1_13_R2.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_13_R2.PacketPlayOutTitle.EnumTitleAction;

public class NMShandler_1_13_R2 implements NMShandler{

	@Override
	public void actionBarMsg(Player p, String msg) {
		PacketPlayOutTitle packet = new PacketPlayOutTitle(EnumTitleAction.ACTIONBAR, ChatSerializer.a("{\"text\":\"" + ChatColor.translateAlternateColorCodes('&', msg)+ "\"}"), 20, 120, 20);
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
	}
}
