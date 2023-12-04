package de.morgon.missile.events;

import de.morgon.missile.configs.MissileSaves;
import de.morgon.missile.maps.PlayerEntityMap;
import de.morgon.missile.maps.PlayerInputMap;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class EnterCoordinates implements Listener {

    @EventHandler
    public void onSendCoords(PlayerChatEvent e) {
        Player p = e.getPlayer();
        int input;
        Entity missile;

        try {

            if (PlayerInputMap.get(p).equals("X")) {
                if (e.getMessage().equals("cancel")) {
                    PlayerInputMap.remove(p);
                    p.sendMessage("Missile: Input canceled");
                    e.setCancelled(true);
                } else {
                    try {
                        input = Integer.parseInt(e.getMessage());
                        missile = PlayerEntityMap.get(p);
                        MissileSaves.get().set(missile.getUniqueId() + ".Target.X", input);
                        MissileSaves.get().set(missile.getUniqueId() + ".Target.Type", "Coords");
                        MissileSaves.save();
                        PlayerInputMap.remove(p);
                        p.sendMessage("Missile: Saved coordinates");
                        e.setCancelled(true);
                    } catch (Exception var6) {
                        p.sendMessage("Missile: Please insert a number(check for spacebars)");
                        p.sendMessage("Missile: To cancel type 'cancel'");
                        e.setCancelled(true);
                    }
                }
            } else if (PlayerInputMap.get(p).equals("Z")) {
                if (e.getMessage().equals("cancel")) {
                    PlayerInputMap.remove(p);
                    p.sendMessage("Missile: Input canceled");
                    e.setCancelled(true);
                } else {
                    try {
                        input = Integer.parseInt(e.getMessage());
                        missile = PlayerEntityMap.get(p);
                        MissileSaves.get().set(missile.getUniqueId() + ".Target.Z", input);
                        MissileSaves.get().set(missile.getUniqueId() + ".Target.Type", "Coords");
                        MissileSaves.save();
                        PlayerInputMap.remove(p);
                        p.sendMessage("Missile: Saved coordinates");
                        e.setCancelled(true);
                    } catch (Exception var5) {
                        p.sendMessage("Missile: Please insert a number(check for spacebars)");
                        p.sendMessage("Missile: To cancel type 'cancel'");
                        e.setCancelled(true);
                    }
                }
            } else if (PlayerInputMap.get(p) == null) {
                return;
            }
        }catch (Exception exception){
            return;
        }

    }
}
