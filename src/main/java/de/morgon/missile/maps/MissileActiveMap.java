package de.morgon.missile.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;

import static de.morgon.missile.maps.MissileGunpowderMap.MissileGunpowder;

public class MissileActiveMap {
    public static Map<Entity, Boolean> MissileActive = new HashMap();

    public static void set(Entity missile, boolean active) {
        MissileActive.put(missile, active);
    }

    public static Boolean get(Entity missile) {
        return (Boolean)MissileActive.get(missile);
    }

    public static void remove(Entity missile) {
        MissileActiveMap.remove(missile);
    }
}
