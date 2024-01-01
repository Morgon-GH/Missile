package de.morgon.missile.events;

import de.morgon.missile.configs.MissileSaves;
import de.morgon.missile.inventories.openInventories.MissileI1;
import de.morgon.missile.maps.MissileActiveMap;
import de.morgon.missile.maps.PlayerEntityMap;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class InteractMissile implements Listener {

    @EventHandler
    public void onInteractMissile(PlayerInteractAtEntityEvent e) {
        if (e.getRightClicked() instanceof ArmorStand && e.getRightClicked().getScoreboardTags().contains("missile")) {
            e.setCancelled(true);
            ArmorStand missile = (ArmorStand)e.getRightClicked();
            Player p = e.getPlayer();
            PlayerEntityMap.set(p, missile);
            if (MissileSaves.get().get(String.valueOf(missile.getUniqueId())) == null) {
                MissileSaves.get().set(missile.getUniqueId() + ".Power", 0);
                MissileSaves.get().set(missile.getUniqueId() + ".Target.Type", "Not set");
                MissileSaves.save();
            }

            MissileI1 missileI1 = new MissileI1();
            missileI1.open(p);
        }

    }
}
