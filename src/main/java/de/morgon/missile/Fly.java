package de.morgon.missile;

import de.morgon.missile.configs.MissileSaves;
import de.morgon.missile.maps.PlayerEntityMap;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Fly {

    public static void launch(Player p){

        Entity missile = PlayerEntityMap.get(p);
        Location loc = new Location(missile.getWorld(), 0, 0, 0);

        if(MissileSaves.get().get(missile.getUniqueId() + ".Target.Type").equals("Coords")){

            double x =MissileSaves.get().getDouble (missile.getUniqueId() + ".Target.X");
            double y = missile.getLocation().getY() + 4;
            double z = MissileSaves.get().getDouble(missile.getUniqueId() + ".Target.Z");

            loc.set(x, y, z);

        }else{

            if(Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer((String) MissileSaves.get().get(missile.getUniqueId() + ".Target.Player")))) {

                double x = Bukkit.getPlayer((String) MissileSaves.get().get(missile.getUniqueId() + ".Target.Player")).getLocation().getX();
                double y = Bukkit.getPlayer((String) MissileSaves.get().get(missile.getUniqueId() + ".Target.Player")).getLocation().getY();
                double z = Bukkit.getPlayer((String) MissileSaves.get().get(missile.getUniqueId() + ".Target.Player")).getLocation().getZ();

                loc.set(x, y, z);
            }else {

                p.sendMessage("Could not find target. Are they online?");
                return;

            }

        }

        missile.setGravity(false);

        missile.teleport(missile.getLocation().add(0, 0.1, 0));

        for (int i = 1; i < 11; i++) {

            int finalI = i;
            new BukkitRunnable() {
                @Override
                public void run() {
                    missile.teleport(missile.getLocation().add(0, Math.pow(finalI * 0.1, 7) * 1.5, 0));

                }
            }.runTaskLater(main.getPlugin(), (long) (3 * finalI + 15));

        }

        for (int i = 1; i < 48; i++) {
            new BukkitRunnable() {
                @Override
                public void run() {

                    for (Player p : Bukkit.getOnlinePlayers()) {

                        p.spawnParticle(Particle.CAMPFIRE_SIGNAL_SMOKE, missile.getLocation(), 0, 0, -0.1, 0);

                    }

                }
            }.runTaskLater(main.getPlugin(), (long) (i));

        }

        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.getLogger().info("Missile start sequence complete");
            }
        }.runTaskLater(main.getPlugin(), 48);

    }

}
