package de.morgon.missile;

import de.morgon.missile.commands.*;
import de.morgon.missile.configs.MissilePowerConfig;
import de.morgon.missile.events.InteractMissile;
import de.morgon.missile.inventories.events.MissileI1Event;
import de.morgon.missile.inventories.events.MissileI2Event;
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
        pluginManager.registerEvents(new MissileI1Event(), this);
        pluginManager.registerEvents(new MissileI2Event(), this);

        logger.info("[Missile] Listeners loaded successfully");

        logger.info("[Missile] Loading Recipes");

        NamespacedKey keyMissile = new NamespacedKey(this, "missile");
        MissileRecipe.register(keyMissile);

        logger.info("[Missile] Recipes loaded successfully");

        logger.info("[Missile] Loading Configs");

        getConfig().options().copyDefaults();
        saveDefaultConfig();
        //TODO Config geht nicht

        MissilePowerConfig.setup();
        MissilePowerConfig.save();
        MissilePowerConfig.get().options().copyDefaults(true);

        logger.info("[Missile] Configs loaded successfully");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
