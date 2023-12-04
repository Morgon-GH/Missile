package de.morgon.missile.maps;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.entity.Player;

public class PlayerInputMap {
    public static Map<Player, String> playerInputMap = new HashMap();

    public PlayerInputMap() {
    }

    public static void set(Player player, String coord) {
        playerInputMap.put(player, coord);
    }

    public static String get(Player player) {
        return (String)playerInputMap.get(player);
    }

    public static void remove(Player player) {
        playerInputMap.remove(player);
    }
}
