package de.morgon.missile;

import de.morgon.missile.commands.SpawnMissile;
import de.morgon.missile.configs.MissileSaves;
import de.morgon.missile.events.CloseGunpowderInv;
import de.morgon.missile.events.EnterCoordinates;
import de.morgon.missile.events.EnterPlayer;
import de.morgon.missile.events.InteractMissile;
import de.morgon.missile.events.UseMissileItem;
import de.morgon.missile.inventories.events.MissileI1Event;
import de.morgon.missile.inventories.events.MissileI2Event;
import de.morgon.missile.inventories.events.MissileI3Event;
import de.morgon.missile.inventories.events.MissileI4Event;
import de.morgon.missile.recipes.MissileRecipe;
import java.util.Objects;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {
    public main() {
    }

    public void onEnable() {
        Logger logger = Bukkit.getLogger();
        logger.info("[Missile] Starting up plugin");
        logger.info("[Missile] Loading commands...");
        ((PluginCommand)Objects.requireNonNull(this.getCommand("SpawnMissile"))).setExecutor(new SpawnMissile());
        logger.info("[Missile] Commands loaded successfully");
        logger.info("[Missile] Loading Event listeners");
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new UseMissileItem(), this);
        pluginManager.registerEvents(new InteractMissile(), this);
        pluginManager.registerEvents(new MissileI1Event(), this);
        pluginManager.registerEvents(new MissileI2Event(), this);
        pluginManager.registerEvents(new MissileI3Event(), this);
        pluginManager.registerEvents(new MissileI4Event(), this);
        pluginManager.registerEvents(new EnterCoordinates(), this);
        pluginManager.registerEvents(new EnterPlayer(), this);
        pluginManager.registerEvents(new CloseGunpowderInv(), this);
        logger.info("[Missile] Listeners loaded successfully");
        logger.info("[Missile] Loading Recipes");
        NamespacedKey keyMissile = new NamespacedKey(this, "missile");
        MissileRecipe.register(keyMissile);
        logger.info("[Missile] Recipes loaded successfully");
        logger.info("[Missile] Loading Configs");
        this.getConfig().options().copyDefaults();
        this.saveDefaultConfig();
        MissileSaves.setup();
        MissileSaves.save();
        MissileSaves.get().options().copyDefaults(true);
        logger.info("[Missile] Configs loaded successfully");
    }

    public void onDisable() {
    }
}