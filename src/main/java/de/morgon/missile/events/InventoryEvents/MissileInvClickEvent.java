package de.morgon.missile.events.InventoryEvents;

import de.morgon.missile.PlayerEntityMap;
import de.morgon.missile.events.InventoryHolder.MenuHolder1;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class MissileInvClickEvent implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e){

        if(e.getInventory().getHolder() instanceof MenuHolder1){

            Player p = (Player) e.getWhoClicked();

            e.setCancelled(true);
            if(Objects.requireNonNull(e.getCurrentItem()).getType() == Material.BARRIER){

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
            }


        }

    }

}
