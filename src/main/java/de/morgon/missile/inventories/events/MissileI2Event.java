package de.morgon.missile.inventories.events;

import de.morgon.missile.configs.MissileSaves;
import de.morgon.missile.inventories.holder.MenuHolder2;
import de.morgon.missile.inventories.openInventories.MissileI1;
import de.morgon.missile.maps.PlayerEntityMap;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class MissileI2Event implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getInventory().getHolder() instanceof MenuHolder2) {
            Player p = (Player)e.getWhoClicked();
            MissileI1 missileI1 = new MissileI1();
            Entity missile = PlayerEntityMap.get(p);

            try {
                if (e.getCurrentItem().getType() != Material.GUNPOWDER) {
                    e.setCancelled(true);
                }

                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aConfirm")) {
                    Inventory missileI2 = e.getInventory();
                    int sum = 0;

                    for(int i = 0; i < 9; ++i) {
                        try {
                            sum = sum + missileI2.getItem(i).getAmount() + 1;
                        } catch (Exception var9) {
                            ++sum;
                        }
                    }

                    sum -= 9;
                    MissileSaves.get().set(missile.getUniqueId() + ".Power", sum);
                    MissileSaves.save();
                    missileI1.open(p);
                    p.sendMessage("You set the power to " + sum + " Gunpowder");
                }
            } catch (Exception var10) {
                return;
            }
        }

    }
}
