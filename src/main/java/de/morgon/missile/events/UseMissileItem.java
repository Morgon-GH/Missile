package de.morgon.missile.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;

public class UseMissileItem implements Listener {

    @EventHandler
    public void onUseMissile(PlayerInteractEvent e){
        if(Objects.requireNonNull(e.getItem()).getType() == Material.PAPER && e.getItem().getItemMeta().getCustomModelData() == 2){

            Location location = Objects.requireNonNull(e.getClickedBlock()).getLocation();
            double X = location.getX();
            double Y = location.getY() + 0.5;
            double Z = location.getZ();

            e.getPlayer().performCommand("spawnmissile " + X + " " + Y + " " + Z);
        }
    }

}
