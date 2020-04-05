package invEvents;

import java.util.Collection;

import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import methodz.NMSutil;

public class BlockBreak implements Listener {


	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		Inventory inv = p.getInventory();

		if (p.getGameMode().equals(GameMode.CREATIVE))
			return; // Causes it to ignore users in creative

		@SuppressWarnings("deprecation")
		Collection<ItemStack> co = e.getBlock().getDrops(e.getPlayer().getItemInHand()); // Somehow fixed bug stopping cobblestone and other things from being detected?
		
			if (e.getPlayer().getInventory().firstEmpty() != -1) {
				for (ItemStack drop : co) {
					inv.addItem(drop);
				}
			} else {
				for (ItemStack item : co) {
					for (int i = 0; i < 35; i++) {
						if (e.getPlayer().getInventory().getItem(i).getAmount() + item.getAmount() <= 64) {
							if (e.getPlayer().getInventory().getItem(i).getType().equals(item.getType())) {
								e.getPlayer().getInventory().addItem(item);
								break;
							}
						}
						if (i == 34) {
							NMSutil.getNMS().actionBarMsg(p, "&c&lYour inventory is full!");
							p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2.0F, 2.0F);
						}
					}
				}
			}
		e.setDropItems(false); // Stops the drops from dropping
		e.getBlock().getDrops().clear(); // Clears the array list containing all of the drops
	}
}