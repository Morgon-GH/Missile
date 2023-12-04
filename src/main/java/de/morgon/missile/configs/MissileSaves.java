package de.morgon.missile.configs;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class MissileSaves {
    private static File file;
    private static FileConfiguration customFile;

    public MissileSaves() {
    }

    public static void setup() {
        file = new File(((Plugin)Objects.requireNonNull(Bukkit.getServer().getPluginManager().getPlugin("Missile"))).getDataFolder(), "MissileSaves.yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException var1) {
            }
        }

        customFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get() {
        return customFile;
    }

    public static void save() {
        try {
            customFile.save(file);
        } catch (IOException var1) {
            System.out.println("Couldn't save Progress Config");
        }

    }
}
