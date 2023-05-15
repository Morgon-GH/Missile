package de.morgon.missile.inventories.openInventories;

import de.morgon.missile.configs.MissilePowerConfig;
import de.morgon.missile.maps.PlayerEntityMap;
import de.morgon.missile.maps.MissileGunpowderMap;
import de.morgon.missile.inventories.holder.MenuHolder1;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class missileI1 {
    public void open(Player player){

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

        ItemStack power = new ItemStack(Material.GUNPOWDER);
        ItemMeta powerM = power.getItemMeta();
        powerM.setDisplayName("Load Gunpowder");
        List<String> powerL = new ArrayList<String>();

        if(MissilePowerConfig.get().get(String.valueOf(PlayerEntityMap.get(player).getUniqueId())) != null) {
            powerL.add("Current power: " + MissilePowerConfig.get().get(String.valueOf(PlayerEntityMap.get(player).getUniqueId())) + " Gunpowder");
        }else{
            powerL.add("Current power: 0 Gunpowder");
        }

        powerM.setLore(powerL);
        power.setItemMeta(powerM);

        for(int i = 0; i < 10; i++){
            missileI1.setItem( i, clear);
        }

        missileI1.setItem(10, launch);

        missileI1.setItem(11, clear);

        missileI1.setItem(12, target);

        missileI1.setItem(13, clear);

        missileI1.setItem(14, power);

        missileI1.setItem(15, clear);

        missileI1.setItem(16, pickup);

        for(int i = 17; i < 27; i++){
            missileI1.setItem(i, clear);
        }

        player.openInventory(missileI1);

    }

}
