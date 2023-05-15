package de.morgon.missile.inventories.openInventories;

import de.morgon.missile.configs.MissilePowerConfig;
import de.morgon.missile.inventories.holder.MenuHolder2;
import de.morgon.missile.maps.MissileGunpowderMap;
import de.morgon.missile.maps.PlayerEntityMap;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

//AKA Power
public class missileI2 {

    public void open(Player player){

        Entity missile = PlayerEntityMap.get(player);
        Inventory power = Bukkit.createInventory(new MenuHolder2(), 18, "Load Missile");

        ItemStack clear = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta clearM = clear.getItemMeta();
        clearM.setDisplayName(" ");
        clear.setItemMeta(clearM);

        ItemStack confirm = new ItemStack(Material.LIME_WOOL);
        ItemMeta confirmM = confirm.getItemMeta();
        confirmM.setDisplayName("Confirm");
        confirm.setItemMeta(confirmM);

        int amount = MissilePowerConfig.get().getInt(String.valueOf(missile.getUniqueId()));

        for (int i = 0; i < 9; i++){
            power.setItem(i, new ItemStack(Material.GUNPOWDER, amount));
            amount = amount - 64;
        }

        for(int i = 9; i < 17; i++){
            power.setItem(i, clear);
        }

        power.setItem(17, confirm);

        player.openInventory(power);
    }

}
