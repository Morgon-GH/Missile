package de.morgon.missile;

import de.morgon.missile.commands.*;
import de.morgon.missile.events.InteractMissile;
import de.morgon.missile.events.InventoryEvents.MissileInvClickEvent;
import de.morgon.missile.events.UseMissileItem;
import de.morgon.missile.recipes.MissileRecipe;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
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

        System.out.println("Listeners loaded successfully");

        System.out.println("Loading Recipes");

        NamespacedKey keyMissile = new NamespacedKey(this, "missile");
        MissileRecipe.register(keyMissile);

        System.out.println("Recipes loaded successfully");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
