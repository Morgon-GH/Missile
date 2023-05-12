package de.morgon.missile.events.Inventories.events;

import de.morgon.missile.HashMaps.PlayerEntityMap;
import de.morgon.missile.events.Inventories.inventoryHolder.MenuHolder1;
import de.morgon.missile.events.Inventories.inventoryHolder.MenuHolder2;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MissileI1Event implements Listener {

    @EventHandler
    public void onClickMissile(InventoryClickEvent e){

        if(e.getInventory().getHolder() instanceof MenuHolder1){

            Player p = (Player) e.getWhoClicked();

            e.setCancelled(true);

            if(e.getCurrentItem().getType() == Material.BARRIER){

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
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("Load Gunpowder")){
                
                Inventory power = Bukkit.createInventory(new MenuHolder2(), 18, "Load Missile");

                ItemStack clear = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                ItemMeta clearM = clear.getItemMeta();
                clearM.setDisplayName(" ");
                clear.setItemMeta(clearM);

                ItemStack confirm = new ItemStack(Material.LIME_WOOL);
                ItemMeta confirmM = confirm.getItemMeta();
                confirmM.setDisplayName("Confirm");
                confirm.setItemMeta(confirmM);


                for(int i = 9; i < 17; i++){
                    power.setItem(i, clear);
                }

                power.setItem(17, confirm);


                p.openInventory(power);
            }
        }
    }
}
