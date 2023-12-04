package de.morgon.missile.inventories.events;

import de.morgon.missile.inventories.holder.MenuHolder4;
import de.morgon.missile.maps.PlayerInputMap;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MissileI4Event implements Listener {
    public MissileI4Event() {
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getInventory().getHolder() instanceof MenuHolder4) {
            Player p = (Player)e.getWhoClicked();
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Set X")) {
                PlayerInputMap.set(p, "X");
                p.closeInventory();
                p.sendMessage("Missile: Enter the X coordinate in the Chat");
                p.sendMessage("Missile: To cancel type 'cancel'");
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Set Z")) {
                PlayerInputMap.set(p, "Z");
                p.closeInventory();
                p.sendMessage("Missile: Enter the Z coordinate in the Chat");
                p.sendMessage("Missile: To cancel type 'cancel'");
            }
        }

    }
}

