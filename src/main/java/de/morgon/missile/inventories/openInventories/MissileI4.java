package de.morgon.missile.inventories.openInventories;

import de.morgon.missile.configs.MissileSaves;
import de.morgon.missile.inventories.holder.MenuHolder4;
import de.morgon.missile.maps.PlayerEntityMap;
import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static de.morgon.missile.ItemHandler.CLEAR;

public class MissileI4 {

    public void open(Player p) {
        Entity missile = PlayerEntityMap.get(p);
        Inventory targetCords = Bukkit.createInventory(new MenuHolder4(), 27, "Input Coordinates");


        ArrayList<String> loreX = new ArrayList();
        if (MissileSaves.get().get(missile.getUniqueId() + ".Target.X") != null) {
            loreX.add(ChatColor.DARK_PURPLE + "Set to: " + MissileSaves.get().get(missile.getUniqueId() + ".Target.X"));
        } else
            loreX.add(ChatColor.DARK_PURPLE + "X not set");
        ItemStack X = new ItemStack(Material.ARROW);
        ItemMeta XM = X.getItemMeta();
        XM.setDisplayName("§7Set X");
        XM.setLore(loreX);
        X.setItemMeta(XM);
        ArrayList<String> loreZ = new ArrayList();
        if (MissileSaves.get().get(missile.getUniqueId() + ".Target.Z") != null) {
            loreZ.add(ChatColor.DARK_PURPLE + "Set to: " + MissileSaves.get().get(missile.getUniqueId() + ".Target.Z"));
        } else
            loreZ.add(ChatColor.DARK_PURPLE + "Z not set");
        ItemStack Z = new ItemStack(Material.ARROW);
        ItemMeta ZM = Z.getItemMeta();
        ZM.setDisplayName("§7Set Z");
        ZM.setLore(loreZ);
        Z.setItemMeta(ZM);

        int i;
        for(i = 0; i <= 10; ++i) {
            targetCords.setItem(i, CLEAR);
        }

        targetCords.setItem(11, X);
        targetCords.setItem(12, CLEAR);
        targetCords.setItem(13, CLEAR);
        targetCords.setItem(14, CLEAR);
        targetCords.setItem(15, Z);

        for(i = 16; i <= 26; ++i) {
            targetCords.setItem(i, CLEAR);
        }

        p.openInventory(targetCords);
    }
}

