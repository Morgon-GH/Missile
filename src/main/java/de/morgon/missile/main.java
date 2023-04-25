package de.morgon.missile;

import de.morgon.missile.commands.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Starting up plugin");

        System.out.println("Loading commands...");
        getCommand("SpawnMissile").setExecutor(new SpawnMissile());
        System.out.println("Commands loaded successfully");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
