package de.morgon.missile.maps;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayerEntityMap {

    public static Map<Player, Entity> playerEntityMap = new HashMap<>();

    public static void set(Player player, Entity missile){
        playerEntityMap.put(player, missile);
    }

    public static Entity get(Player player){
        return playerEntityMap.get(player);
    }

    public static void remove(Player player){
        playerEntityMap.remove(player);
    }

}
