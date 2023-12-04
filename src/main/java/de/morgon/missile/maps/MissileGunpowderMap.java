package de.morgon.missile.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;

public class MissileGunpowderMap {
    public static Map<Entity, Integer> MissileGunpowder = new HashMap();

    public MissileGunpowderMap() {
    }

    public static void set(Entity missile, int amount) {
        MissileGunpowder.put(missile, amount);
    }

    public static Integer get(@NotNull UUID missile) {
        return (Integer)MissileGunpowder.get(missile);
    }

    public static void remove(Entity missile) {
        MissileGunpowder.remove(missile);
    }
}
