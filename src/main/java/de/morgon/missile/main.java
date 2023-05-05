package de.morgon.missile;

import de.morgon.missile.commands.*;
import de.morgon.missile.events.InteractMissile;
import de.morgon.missile.events.InventoryEvents.MissileInvClickEvent;
import de.morgon.missile.events.UseMissileItem;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Starting up plugin");

        System.out.println("Loading commands...");
        Objects.requireNonNull(getCommand("SpawnMissile")).setExecutor(new SpawnMissile());
        System.out.println("Commands loaded successfully");

        System.out.println("Loading Event listeners");
        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new UseMissileItem(), this);
        pluginManager.registerEvents(new InteractMissile(), this);
        pluginManager.registerEvents(new MissileInvClickEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
