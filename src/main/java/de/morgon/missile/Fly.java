package de.morgon.missile;

import de.morgon.missile.configs.MissileSaves;
import de.morgon.missile.maps.PlayerEntityMap;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;


public class Fly {

    public static void launch(Player p) {

        Entity missile = PlayerEntityMap.get(p);
        Location loc = new Location(missile.getWorld(), 0, 0, 0);
        Location start = missile.getLocation();

        if (MissileSaves.get().get(missile.getUniqueId() + ".Target.Type").equals("Coords")) {

            double x = (MissileSaves.get().getDouble(missile.getUniqueId() + ".Target.X")) + 0.5;
            double y = missile.getLocation().getY() + 4;
            double z = (MissileSaves.get().getDouble(missile.getUniqueId() + ".Target.Z")) + 0.5;

            loc.set(x, y, z);

        } else {

            if (Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer((String) MissileSaves.get().get(missile.getUniqueId() + ".Target.Player")))) {

                double x = Bukkit.getPlayer((String) MissileSaves.get().get(missile.getUniqueId() + ".Target.Player")).getLocation().getX();
                double y = Bukkit.getPlayer((String) MissileSaves.get().get(missile.getUniqueId() + ".Target.Player")).getLocation().getY();
                double z = Bukkit.getPlayer((String) MissileSaves.get().get(missile.getUniqueId() + ".Target.Player")).getLocation().getZ();

                loc.set(x, y, z);
            } else {

                p.sendMessage("Could not find target. Are they online?");
                return;

            }

        }

        missile.setGravity(false);


        double dx = loc.getX() - start.getX();
        double dz = loc.getZ() - start.getZ();

        double distance = Math.sqrt(Math.pow(dx, 2) + Math.pow(dz, 2));

        float a;

        if (dz == 0) {
            if (loc.getX() > start.getX()) {
                a = (float) (0.5 * Math.PI);
            } else {
                a = (float) (-0.5 * Math.PI);
            }
        } else if (loc.getZ() > start.getZ()) {
            a = (float) (Math.atan(dx / dz));
        } else{
            a = (float) (Math.atan(dx / dz) - Math.PI);
        }

        missile.setRotation(a, 0);

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

        float speed = 0.5f;

        long reps = (long) (distance / speed);

        for (int i = 0; i < reps; i++) {

            int finalI = i;

            double Xspeed = Math.sin(a) * speed;
            double Zspeed = Math.cos(a) * speed;


            new BukkitRunnable() {
                @Override
                public void run() {


                    missile.teleport(new Location(missile.getWorld(), start.getX() + Xspeed * finalI, missile.getLocation().getY() , start.getZ() + Zspeed * finalI, (float) (a * 180 / Math.PI - 90), 0));

                }
            }.runTaskLater(main.getPlugin(), (long) (i + 48));

            if (!String.valueOf(new Location(missile.getWorld(), start.getX() + Xspeed * finalI, missile.getLocation().getY() , start.getZ() + Zspeed * finalI).getBlock().getBlockData().getMaterial()).equals("AIR")) {

                new BukkitRunnable() {
                    @Override
                    public void run() {

                        Bukkit.broadcastMessage("Missile hit a block");

                        missile.getWorld().createExplosion(missile.getLocation(), 4);
                        missile.remove();

                    }
                }.runTaskLater(main.getPlugin(), (long) (i + 48));

                break;

            }

        }

    }
}
