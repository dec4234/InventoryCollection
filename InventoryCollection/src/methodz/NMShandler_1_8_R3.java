package methodz;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

public class NMShandler_1_8_R3 implements NMShandler{

	@Override
	public void actionBarMsg(Player p, String msg) {
		PacketPlayOutChat packet = new PacketPlayOutChat(ChatSerializer.a("{\"text\": \"" + msg + "\"}"), (byte) 2);
		((CraftPlayer ) p).getHandle().playerConnection.sendPacket(packet);
	}
}
