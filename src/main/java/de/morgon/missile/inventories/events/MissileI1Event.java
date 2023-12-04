package de.morgon.missile.inventories.events;

import de.morgon.missile.Fly;
import de.morgon.missile.configs.MissileSaves;
import de.morgon.missile.inventories.holder.MenuHolder1;
import de.morgon.missile.inventories.openInventories.MissileI2;
import de.morgon.missile.inventories.openInventories.MissileI3;
import de.morgon.missile.maps.PlayerEntityMap;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MissileI1Event implements Listener {

    @EventHandler
    public void onClickMissile(InventoryClickEvent e) {
        try {
            if (e.getInventory().getHolder() instanceof MenuHolder1) {
                Player p = (Player)e.getWhoClicked();
                e.setCancelled(true);
                if (e.getCurrentItem().getType() == Material.BARRIER) {
                    Entity missile = PlayerEntityMap.get(p);
                    ItemStack missileItem = new ItemStack(Material.PAPER);
                    ItemMeta missileItemM = missileItem.getItemMeta();
                    missileItemM.setCustomModelData(2);
                    missileItemM.setDisplayName("§oMissile");
                    missileItem.setItemMeta(missileItemM);
                    ItemStack gunpowder = new ItemStack(Material.GUNPOWDER, (Integer)MissileSaves.get().get(missile.getUniqueId() + ".Power"));
                    p.getInventory().addItem(new ItemStack[]{gunpowder});
                    missile.remove();
                    p.getInventory().addItem(new ItemStack[]{missileItem});
                    p.closeInventory();
                    PlayerEntityMap.remove(p);
                    MissileSaves.get().set(String.valueOf(missile.getUniqueId()), (Object)null);
                    MissileSaves.save();
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Load Gunpowder")) {
                    MissileI2 missileI2 = new MissileI2();
                    missileI2.open(p);
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aSet target")) {
                    MissileI3 missileI3 = new MissileI3();
                    missileI3.open(p);
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4LAUNCH")) {
                    p.sendMessage("LAUNCH");
                    p.closeInventory();

                    Fly fly = new Fly();
                    fly.launch(p);
                }
            }
        } catch (Exception var7) {
        }

    }
}