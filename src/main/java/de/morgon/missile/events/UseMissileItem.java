package de.morgon.missile.events;

import java.util.Objects;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class UseMissileItem implements Listener {

    @EventHandler
    public void onUseMissile(PlayerInteractEvent e) {
        try {
            if (e.getItem().getType() == Material.PAPER && e.getItem().getItemMeta().getCustomModelData() == 2) {
                Player p = e.getPlayer();
                Location location = ((Block)Objects.requireNonNull(e.getClickedBlock())).getLocation();
                double X = location.getX();
                double Y = location.getY() + 0.5;
                double Z = location.getZ();
                p.performCommand("spawnmissile " + X + " " + Y + " " + Z);
                int amount = p.getInventory().getItemInMainHand().getAmount();
                p.getInventory().getItemInMainHand().setAmount(amount - 1);
            }

        } catch (Exception var11) {
        }
    }
}
