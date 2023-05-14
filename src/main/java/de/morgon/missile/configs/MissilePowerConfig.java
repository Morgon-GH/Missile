package de.morgon.missile.configs;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class MissilePowerConfig {

    private static File file;
    private static FileConfiguration customFile;

    //finds or generates the config file
    public static void setup(){

        file = new File(Objects.requireNonNull(Bukkit.getServer().getPluginManager().getPlugin("Missile")).getDataFolder(), "MissilePowerConfig.yml");

        if(!file.exists()){
            try{
                file.createNewFile();
            }catch(IOException ignored){}
        }
        customFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get(){
        return customFile;
    }

    public static void save(){
        try{
            customFile.save(file);
        }catch (IOException e){
            System.out.println("Couldn't save Progress Config");
        }
    }

}
