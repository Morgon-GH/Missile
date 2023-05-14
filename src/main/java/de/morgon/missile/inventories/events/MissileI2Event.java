package de.morgon.missile.inventories.events;

import de.morgon.missile.configs.MissilePowerConfig;
import de.morgon.missile.maps.MissileGunpowderMap;
import de.morgon.missile.maps.PlayerEntityMap;
import de.morgon.missile.inventories.holder.MenuHolder2;
import de.morgon.missile.inventories.openInventories.missileI1;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class MissileI2Event implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e){
        if(e.getInventory().getHolder() instanceof MenuHolder2){

            Player p = (Player) e.getWhoClicked();
            missileI1 missileI1 = new missileI1();

            Entity missile = PlayerEntityMap.get(p);

            try {

                if (e.getCurrentItem().getType() != Material.GUNPOWDER) {
                    e.setCancelled(true);
                }

                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("Confirm")) {

                    Inventory missileI2 = e.getInventory();

                    int sum = 0;

                    for (int i = 0; i < 9; i++){
                        try{
                            sum = sum + missileI2.getItem(i).getAmount() + 1;
                        }catch (Exception emptyItemStack){
                            sum = sum + 1;
                        }
                    }

                    sum = sum - 9;

                    MissilePowerConfig.get().set(String.valueOf(missile.getUniqueId()), "hi");

                    missileI1.open(p);

                    p.sendMessage("You set the power to " + sum + " Gunpowder");

                    //TODO Sicherung bei Inv schließen ohne zu speichern
                }
            }catch (Exception exception){
                return;
            }
        }
    }

}
