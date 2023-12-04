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

public class MissileI4 {

    public void open(Player p) {
        Entity missile = PlayerEntityMap.get(p);
        Inventory targetCords = Bukkit.createInventory(new MenuHolder4(), 27, "Input Coordinates");
        ItemStack clear = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta clearM = clear.getItemMeta();
        clearM.setDisplayName(" ");
        clear.setItemMeta(clearM);
        ArrayList<String> loreX = new ArrayList();
        loreX.add(ChatColor.DARK_PURPLE + "Set to: " + MissileSaves.get().get(missile.getUniqueId() + ".Target.X"));
        ItemStack X = new ItemStack(Material.ARROW);
        ItemMeta XM = clear.getItemMeta();
        XM.setDisplayName("§7Set X");
        XM.setLore(loreX);
        X.setItemMeta(XM);
        ArrayList<String> loreZ = new ArrayList();
        loreZ.add(ChatColor.DARK_PURPLE + "Set to: " + MissileSaves.get().get(missile.getUniqueId() + ".Target.Z"));
        ItemStack Z = new ItemStack(Material.ARROW);
        ItemMeta ZM = clear.getItemMeta();
        ZM.setDisplayName("§7Set Z");
        ZM.setLore(loreZ);
        Z.setItemMeta(ZM);

        int i;
        for(i = 0; i <= 10; ++i) {
            targetCords.setItem(i, clear);
        }

        targetCords.setItem(11, X);
        targetCords.setItem(12, clear);
        targetCords.setItem(13, clear);
        targetCords.setItem(14, clear);
        targetCords.setItem(15, Z);

        for(i = 16; i <= 26; ++i) {
            targetCords.setItem(i, clear);
        }

        p.openInventory(targetCords);
    }
}

