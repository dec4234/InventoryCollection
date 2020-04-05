package methodz;

import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.PacketPlayOutChat;

public class NMShandler_1_8_R1 implements NMShandler{

	@Override
	public void actionBarMsg(Player p, String msg) {
		PacketPlayOutChat packet = new PacketPlayOutChat(ChatSerializer.a("{\"text\": \"" + msg + "\"}"), (byte) 2);
		((CraftPlayer ) p).getHandle().playerConnection.sendPacket(packet);
	}

}
