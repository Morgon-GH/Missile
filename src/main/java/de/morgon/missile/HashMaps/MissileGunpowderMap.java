package de.morgon.missile.HashMaps;

import org.bukkit.entity.Entity;

import java.util.HashMap;
import java.util.Map;

public class MissileGunpowderMap {

    public static Map<Entity, Integer> MissileGunpowder = new HashMap<>();

    public static void set(Entity missile, int amount){
        MissileGunpowder.put(missile, amount);
    }

    public static Integer get(Entity missile){
        return MissileGunpowder.get(missile);
    }

    public static void remove(Entity missile){
        MissileGunpowder.remove(missile);
    }

}
