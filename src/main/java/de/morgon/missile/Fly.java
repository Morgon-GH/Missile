package de.morgon.missile;

import de.morgon.missile.maps.PlayerEntityMap;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Fly {

    public void launch(Player p){

        p.sendMessage("aowmdpawmd");

        Entity missile = PlayerEntityMap.get(p);

       missile.teleport(missile.getLocation().add(0, 1, 0));

    }

}
