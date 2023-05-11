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
import java.util.logging.Logger;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {
        Logger logger = Bukkit.getLogger();
        logger.info("[Missile] Starting up plugin");

        logger.info("[Missile] Loading commands...");
        Objects.requireNonNull(getCommand("SpawnMissile")).setExecutor(new SpawnMissile());
        logger.info("[Missile] Commands loaded successfully");

        logger.info("[Missile] Loading Event listeners");
        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new UseMissileItem(), this);
        pluginManager.registerEvents(new InteractMissile(), this);
        pluginManager.registerEvents(new MissileInvClickEvent(), this);

        logger.info("[Missile] Listeners loaded successfully");

        logger.info("[Missile] Loading Recipes");

        NamespacedKey keyMissile = new NamespacedKey(this, "missile");
        MissileRecipe.register(keyMissile);

        logger.info("[Missile] Recipes loaded successfully");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
