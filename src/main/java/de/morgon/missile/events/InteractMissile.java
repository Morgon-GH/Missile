package de.morgon.missile.events;

import de.morgon.missile.PlayerEntityMap;
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

            ItemStack clear = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
            ItemMeta clearM = clear.getItemMeta();
            clearM.setDisplayName(" ");
            clear.setItemMeta(clearM);

            ItemStack launch = new ItemStack(Material.RED_CONCRETE);
            ItemMeta launchM = launch.getItemMeta();
            launchM.setDisplayName("LAUNCH");
            launch.setItemMeta(launchM);

            ItemStack target = new ItemStack(Material.ARROW);
            ItemMeta targetM = target.getItemMeta();
            targetM.setDisplayName("Set target");
            target.setItemMeta(targetM);

            for(int i = 0; i < 10; i++){
                missileI1.setItem( i, clear);
            }

            missileI1.setItem(10, launch);

            missileI1.setItem(11, clear);

            missileI1.setItem(12, target);

            missileI1.setItem(13, clear);



            missileI1.setItem(15, clear);

            missileI1.setItem(16, pickup);

            for(int i = 17; i < 27; i++){
                missileI1.setItem(i, clear);
            }

            p.openInventory(missileI1);

        }
    }
}
