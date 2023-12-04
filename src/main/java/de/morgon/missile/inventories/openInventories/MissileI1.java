package de.morgon.missile.inventories.openInventories;

import de.morgon.missile.configs.MissileSaves;
import de.morgon.missile.inventories.holder.MenuHolder1;
import de.morgon.missile.maps.PlayerEntityMap;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MissileI1 {

    public void open(Player player) {
        Inventory missileI1 = Bukkit.createInventory(new MenuHolder1(), 27, "Configure Missile");
        Entity missile = PlayerEntityMap.get(player);
        ItemStack pickup = new ItemStack(Material.BARRIER, 1);
        ItemMeta pickupM = pickup.getItemMeta();
        pickupM.setDisplayName("§cPick up");
        pickup.setItemMeta(pickupM);
        ItemStack clear = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta clearM = clear.getItemMeta();
        clearM.setDisplayName(" ");
        clear.setItemMeta(clearM);
        ItemStack launch = new ItemStack(Material.RED_CONCRETE);
        ItemMeta launchM = launch.getItemMeta();
        launchM.setDisplayName("§4LAUNCH");
        launch.setItemMeta(launchM);
        ArrayList<String> loreTarget = new ArrayList();
        if (MissileSaves.get().get(missile.getUniqueId() + ".Target.Type").equals("Player")) {
            loreTarget.add(ChatColor.DARK_PURPLE + "Set to: " + MissileSaves.get().get(missile.getUniqueId() + ".Target.Player"));
        } else if (MissileSaves.get().get(missile.getUniqueId() + ".Target.Type").equals("Coords")) {
            loreTarget.add(ChatColor.DARK_PURPLE + "Set X to: " + MissileSaves.get().get(missile.getUniqueId() + ".Target.X"));
            loreTarget.add(ChatColor.DARK_PURPLE + "and Z to: " + MissileSaves.get().get(missile.getUniqueId() + ".Target.Z"));
        }

        ItemStack target = new ItemStack(Material.ARROW);
        ItemMeta targetM = target.getItemMeta();
        targetM.setDisplayName("§aSet target");
        targetM.setLore(loreTarget);
        target.setItemMeta(targetM);
        ItemStack power = new ItemStack(Material.GUNPOWDER);
        ItemMeta powerM = power.getItemMeta();
        powerM.setDisplayName("§7Load Gunpowder");
        List<String> powerL = new ArrayList();
        powerL.add("Current power: " + MissileSaves.get().get(PlayerEntityMap.get(player).getUniqueId() + ".Power") + " Gunpowder");
        powerM.setLore(powerL);
        power.setItemMeta(powerM);

        int i;
        for(i = 0; i < 10; ++i) {
            missileI1.setItem(i, clear);
        }

        missileI1.setItem(10, launch);
        missileI1.setItem(11, clear);
        missileI1.setItem(12, target);
        missileI1.setItem(13, clear);
        missileI1.setItem(14, power);
        missileI1.setItem(15, clear);
        missileI1.setItem(16, pickup);

        for(i = 17; i < 27; ++i) {
            missileI1.setItem(i, clear);
        }

        player.openInventory(missileI1);
    }
}
