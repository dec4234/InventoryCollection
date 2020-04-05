package methodz;

import org.bukkit.craftbukkit.v1_9_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_9_R2.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_9_R2.PacketPlayOutChat;

public class NMShandler_1_9_R2 implements NMShandler{

	@Override
	public void actionBarMsg(Player p, String msg) {
		PacketPlayOutChat packet = new PacketPlayOutChat(ChatSerializer.a("{\"text\": \"" + msg + "\"}"), (byte) 2);
		((CraftPlayer ) p).getHandle().playerConnection.sendPacket(packet);
	}
}
