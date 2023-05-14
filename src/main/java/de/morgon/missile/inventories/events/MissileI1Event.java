package de.morgon.missile.inventories.events;

import de.morgon.missile.maps.PlayerEntityMap;
import de.morgon.missile.inventories.holder.MenuHolder1;
import de.morgon.missile.inventories.openInventories.missileI2;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MissileI1Event implements Listener {

    @EventHandler
    public void onClickMissile(InventoryClickEvent e){

        if(e.getInventory().getHolder() instanceof MenuHolder1){

            Player p = (Player) e.getWhoClicked();

            e.setCancelled(true);


            if (e.getCurrentItem().getType() == Material.BARRIER) {

                Entity missile = PlayerEntityMap.get(p);
                ItemStack missileItem = new ItemStack(Material.PAPER);
                ItemMeta missileItemM = missileItem.getItemMeta();
                missileItemM.setCustomModelData(2);
                missileItemM.setDisplayName("§oMissile");
                missileItem.setItemMeta(missileItemM);

                missile.remove();
                p.getInventory().addItem(missileItem);
                p.closeInventory();

                PlayerEntityMap.remove(p);
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("Load Gunpowder")) {

                missileI2 missileI2 = new missileI2();
                missileI2.open(p);
            }

        }
    }
}
