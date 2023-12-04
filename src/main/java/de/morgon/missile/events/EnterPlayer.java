package de.morgon.missile.events;

import de.morgon.missile.configs.MissileSaves;
import de.morgon.missile.maps.PlayerEntityMap;
import de.morgon.missile.maps.PlayerInputMap;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class EnterPlayer implements Listener {
    public EnterPlayer() {
    }

    @EventHandler
    public void onSendPlayer(PlayerChatEvent e) {
        Player p = e.getPlayer();
        if (PlayerInputMap.get(p).equals("Player")) {
            Entity missile = PlayerEntityMap.get(p);
            if (e.getMessage().equals("cancel")) {
                PlayerInputMap.remove(p);
                e.setCancelled(true);
            } else {
                String input = e.getMessage();
                MissileSaves.get().set(missile.getUniqueId() + ".Target.Player", input);
                MissileSaves.get().set(missile.getUniqueId() + ".Target.Type", "Player");
                MissileSaves.save();
                p.sendMessage("Missile: Set target to " + input);
                PlayerInputMap.remove(p);
                e.setCancelled(true);
            }
        } else if (PlayerInputMap.get(p) == null) {
            return;
        }

    }
}