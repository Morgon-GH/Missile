package de.morgon.missile.events;

import de.morgon.missile.configs.MissileSaves;
import de.morgon.missile.inventories.holder.MenuHolder2;
import de.morgon.missile.maps.PlayerEntityMap;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

public class CloseGunpowderInv implements Listener {
    public CloseGunpowderInv() {
    }

    @EventHandler
    public void onCloseInv(InventoryCloseEvent e) {
        Inventory inv = e.getInventory();
        if (inv.getHolder() instanceof MenuHolder2) {
            Player p = (Player)e.getPlayer();
            Entity missile = PlayerEntityMap.get(p);
            int sum = 0;

            for(int i = 0; i < 9; ++i) {
                try {
                    sum = sum + inv.getItem(i).getAmount() + 1;
                } catch (Exception var8) {
                    ++sum;
                }
            }

            sum -= 9;
            MissileSaves.get().set(missile.getUniqueId() + ".Power", sum);
            MissileSaves.save();
        }

    }
}
