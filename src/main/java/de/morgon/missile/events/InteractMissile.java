package de.morgon.missile.events;

import de.morgon.missile.HashMaps.PlayerEntityMap;
import de.morgon.missile.events.Inventories.openInventories.missileI1;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;



public class InteractMissile implements Listener {

    @EventHandler
    public void onInteractMissile(PlayerInteractAtEntityEvent e){
        if(e.getRightClicked() instanceof ArmorStand && e.getRightClicked().getScoreboardTags().contains("missile")){

            e.setCancelled(true);

            ArmorStand missile = (ArmorStand) e.getRightClicked();
            Player p = e.getPlayer();

            PlayerEntityMap.set(p, missile);

            missileI1 missileI1 = new missileI1();

            missileI1.open(p);
        }
    }
}
