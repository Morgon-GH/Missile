package de.morgon.missile.events;

import de.morgon.missile.PlayerEntityMap;
import de.morgon.missile.events.InventoryHolder.MenuHolder1;
import org.bukkit.Bukkit;

import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class InteractMissile implements Listener {

    @EventHandler
    public void onInteractMissile(PlayerInteractAtEntityEvent e){
        if(e.getRightClicked() instanceof ArmorStand && e.getRightClicked().getScoreboardTags().contains("missile")){

            e.setCancelled(true);

            ArmorStand missile = (ArmorStand) e.getRightClicked();
            Player p = e.getPlayer();

            PlayerEntityMap.set(p, missile);

            Inventory missileI1 = Bukkit.createInventory(new MenuHolder1(), 27, "Configure Missile");
            ItemStack pickup = new ItemStack(Material.BARRIER, 1);
            ItemMeta pickupM = pickup.getItemMeta();
            pickupM.setDisplayName("Pick up");
            pickup.setItemMeta(pickupM);
            missileI1.setItem(26, pickup);

            p.openInventory(missileI1);

        }
    }
}
