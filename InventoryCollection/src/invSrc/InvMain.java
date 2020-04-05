package invSrc;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import invEvents.BlockBreak;
import methodz.NMSutil;

public class InvMain extends JavaPlugin{
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new BlockBreak(), this);
		NMSutil.setupNMS();
	}
	
}
