package de.morgon.missile.inventories.events;

import de.morgon.missile.inventories.holder.MenuHolder3;
import de.morgon.missile.inventories.openInventories.MissileI4;
import de.morgon.missile.maps.PlayerEntityMap;
import de.morgon.missile.maps.PlayerInputMap;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MissileI3Event implements Listener {
    public MissileI3Event() {
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getInventory().getHolder() instanceof MenuHolder3) {
            Player p = (Player)e.getWhoClicked();
            MissileI4 missileI4 = new MissileI4();
            Entity missile = PlayerEntityMap.get(p);
            e.setCancelled(true);

            try {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Target location by cords")) {
                    missileI4.open(p);
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Target a player")) {
                    PlayerInputMap.set(p, "Player");
                    p.closeInventory();
                    p.sendMessage("Missile: Type the Players name");
                    p.sendMessage("Missile: To cancel type 'cancel'");
                }
            } catch (Exception var6) {
            }
        }

    }
}
