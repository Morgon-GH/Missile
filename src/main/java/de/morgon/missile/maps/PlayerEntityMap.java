package de.morgon.missile.maps;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class PlayerEntityMap {
    public static Map<Player, Entity> playerEntityMap = new HashMap();

    public PlayerEntityMap() {
    }

    public static void set(Player player, Entity missile) {
        playerEntityMap.put(player, missile);
    }

    public static Entity get(Player player) {
        return (Entity)playerEntityMap.get(player);
    }

    public static void remove(Player player) {
        playerEntityMap.remove(player);
    }
}
