package invEvents;

import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import methodz.AlertActions;

public class BlockBreak implements Listener {

	AlertActions a = new AlertActions();

	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		Inventory inv = p.getInventory();

		if (p.getGameMode().equals(GameMode.CREATIVE))
			return; // Causes it to ignore users in creative

		if (e.getPlayer().getInventory().firstEmpty() != -1) {
			for (ItemStack item : e.getBlock().getDrops()) {
				inv.addItem(item);
			}
		} else {
			for (ItemStack item : e.getBlock().getDrops()) {
				for (int i = 0; i < 35; i++) {
					if (e.getPlayer().getInventory().getItem(i).getAmount() + item.getAmount() <= 64) {
						if (e.getPlayer().getInventory().getItem(i).getType().equals(item.getType())) {
							e.getPlayer().getInventory().addItem(item);
							break;
						}
					}
					if (i == 34) {
						a.actionBarMsg(p, "&c&lYour inventory is full!");
						p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2.0F, 2.0F);
					}
				}
			}
		}
		e.setDropItems(false);
	}
}