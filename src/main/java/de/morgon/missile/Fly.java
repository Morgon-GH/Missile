package de.morgon.missile;

import de.morgon.missile.configs.MissileSaves;
import de.morgon.missile.maps.PlayerEntityMap;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public class Fly {

    public static void launch(Player p){

        Entity missile = PlayerEntityMap.get(p);
        Location loc = new Location(missile.getWorld(), 0, 0, 0);

        if(MissileSaves.get().get(missile.getUniqueId() + ".Target.Type").equals("Coords")){

            Double x =MissileSaves.get().getDouble (missile.getUniqueId() + ".Target.X");
            Double y = missile.getLocation().getY() + 3;
            Double z = MissileSaves.get().getDouble(missile.getUniqueId() + ".Target.Z");

            loc.set(x, y, z);

        }else{

            Double x = Bukkit.getPlayer((String) MissileSaves.get().get(missile.getUniqueId() + ".Target.Player")).getLocation().getX();
            Double y = Bukkit.getPlayer((String) MissileSaves.get().get(missile.getUniqueId() + ".Target.Player")).getLocation().getY();
            Double z = Bukkit.getPlayer((String) MissileSaves.get().get(missile.getUniqueId() + ".Target.Player")).getLocation().getZ();

            loc.set(x, y, z);

        }

        missile.setGravity(false);

        new BukkitRunnable() {
            @Override
            public void run() {
                missile.teleport(missile.getLocation().add(0, 0.01, 0));
            }
        }.runTaskLater(main.getPlugin(), 3);

        new BukkitRunnable() {
            @Override
            public void run() {
                missile.teleport(missile.getLocation().add(0, 0.02, 0));
            }
        }.runTaskLater(main.getPlugin(), 6);

        new BukkitRunnable() {
            @Override
            public void run() {
                missile.teleport(missile.getLocation().add(0, 0.04, 0));
            }
        }.runTaskLater(main.getPlugin(), 9);

        new BukkitRunnable() {
            @Override
            public void run() {
                missile.teleport(missile.getLocation().add(0, 0.1, 0));
            }
        }.runTaskLater(main.getPlugin(), 12);

        new BukkitRunnable() {
            @Override
            public void run() {
                missile.teleport(missile.getLocation().add(0, 0.2, 0));
            }
        }.runTaskLater(main.getPlugin(), 15);

        new BukkitRunnable() {
            @Override
            public void run() {
                missile.teleport(missile.getLocation().add(0, 0.4, 0));
            }
        }.runTaskLater(main.getPlugin(), 18);

        new BukkitRunnable() {
            @Override
            public void run() {
                missile.teleport(missile.getLocation().add(0, 0.8, 0));
            }
        }.runTaskLater(main.getPlugin(), 21);

        new BukkitRunnable() {
            @Override
            public void run() {
                missile.teleport(missile.getLocation().add(0, 1.5, 0));
            }
        }.runTaskLater(main.getPlugin(), 24);

    }

}
