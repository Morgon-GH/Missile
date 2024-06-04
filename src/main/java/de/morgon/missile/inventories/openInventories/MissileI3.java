package de.morgon.missile.inventories.openInventories;

import de.morgon.missile.configs.MissileSaves;
import de.morgon.missile.inventories.holder.MenuHolder3;
import de.morgon.missile.maps.PlayerEntityMap;
import java.util.ArrayList;

import jdk.internal.ref.CleanerImpl;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static de.morgon.missile.ItemHandler.CLEAR;

public class MissileI3 {

    public void open(Player p) {
        Entity missile = PlayerEntityMap.get(p);
        Inventory targetOption = Bukkit.createInventory(new MenuHolder3(), 27, "Choose Target Type");

        ItemStack choice = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
        ItemMeta choiceM = choice.getItemMeta();
        choiceM.setDisplayName(" ");
        choice.setItemMeta(choiceM);

        ArrayList<String> loreCoords = new ArrayList();
        if (MissileSaves.get().get(missile.getUniqueId() + ".Target.X") != null) {
            loreCoords.add(ChatColor.DARK_PURPLE + "Set X to: " + MissileSaves.get().get(missile.getUniqueId() + ".Target.X"));
        } else
            loreCoords.add(ChatColor.DARK_PURPLE + "X not set");
        if (MissileSaves.get().get(missile.getUniqueId() + ".Target.Z") != null) {
            loreCoords.add(ChatColor.DARK_PURPLE + "and Z to: " + MissileSaves.get().get(missile.getUniqueId() + ".Target.Z"));
        } else
            loreCoords.add(ChatColor.DARK_PURPLE + "Z not set");

        ItemStack cords = new ItemStack(Material.COMPASS);
        ItemMeta cordsM = cords.getItemMeta();
        cordsM.setDisplayName("§7Target location by cords");
        cordsM.setLore(loreCoords);
        cords.setItemMeta(cordsM);

        ArrayList<String> lorePlayer = new ArrayList();
        if (MissileSaves.get().get(missile.getUniqueId() + ".Target.Player") != null){
            lorePlayer.add(ChatColor.DARK_PURPLE + "Set to: " + MissileSaves.get().get(missile.getUniqueId() + ".Target.Player"));
        } else
            lorePlayer.add(ChatColor.DARK_PURPLE + "Player not set");

        ItemStack player = new ItemStack(Material.PLAYER_HEAD);
        ItemMeta playerM = player.getItemMeta();
        playerM.setDisplayName("§7Target a player");
        playerM.setLore(lorePlayer);
        player.setItemMeta(playerM);

        int i;
        if (MissileSaves.get().get(missile.getUniqueId() + ".Target.Type").equals("Coords")) {
            targetOption.setItem(0, CLEAR);
            targetOption.setItem(1, CLEAR);
            targetOption.setItem(2, choice);

            for(i = 3; i <= 10; ++i) {
                targetOption.setItem(i, CLEAR);
            }

            targetOption.setItem(11, cords);

            for(i = 12; i <= 14; ++i) {
                targetOption.setItem(i, CLEAR);
            }

            targetOption.setItem(15, player);

            for(i = 16; i <= 19; ++i) {
                targetOption.setItem(i, CLEAR);
            }

            targetOption.setItem(20, choice);

            for(i = 21; i <= 26; ++i) {
                targetOption.setItem(i, CLEAR);
            }

            p.openInventory(targetOption);
        } else if (MissileSaves.get().get(missile.getUniqueId() + ".Target.Type").equals("Player")) {
            for(i = 0; i <= 5; ++i) {
                targetOption.setItem(i, CLEAR);
            }

            targetOption.setItem(6, choice);

            for(i = 7; i <= 10; ++i) {
                targetOption.setItem(i, CLEAR);
            }

            targetOption.setItem(11, cords);

            for(i = 12; i <= 14; ++i) {
                targetOption.setItem(i, CLEAR);
            }

            targetOption.setItem(15, player);

            for(i = 16; i <= 23; ++i) {
                targetOption.setItem(i, CLEAR);
            }

            targetOption.setItem(24, choice);
            targetOption.setItem(25, CLEAR);
            targetOption.setItem(26, CLEAR);
            p.openInventory(targetOption);
        } else {
            for(i = 0; i <= 10; ++i) {
                targetOption.setItem(i, CLEAR);
            }

            targetOption.setItem(11, cords);

            for(i = 12; i <= 14; ++i) {
                targetOption.setItem(i, CLEAR);
            }

            targetOption.setItem(15, player);

            for(i = 16; i <= 26; ++i) {
                targetOption.setItem(i, CLEAR);
            }

            p.openInventory(targetOption);
        }

    }
}

