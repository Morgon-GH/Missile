package de.morgon.missile;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayerEntityMap {

    public static Map<Player, Entity> playerUUIDMap = new HashMap<>();

    public static void set(Player player, Entity entity){
        playerUUIDMap.put(player, entity);
    }

    public static Entity get(Player player){
        return playerUUIDMap.get(player);
    }

    public static void remove(Player player){
        playerUUIDMap.remove(player);
    }

}
