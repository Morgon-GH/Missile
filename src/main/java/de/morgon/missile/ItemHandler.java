package de.morgon.missile;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemHandler {

    public static final ItemStack BASIC_MISSILE_TEXTURE = new ItemStack(Material.PAPER);
    public static final ItemStack BASIC_MISSILE_ITEM = new ItemStack(Material.PAPER);
    public static final ItemStack CLEAR = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);

    public static void createItems(){
        createBasicMissileTexture();
        createBasicMissileItem();
        createClearItem();
    }

    static void createBasicMissileTexture(){
        ItemMeta meta = BASIC_MISSILE_TEXTURE.getItemMeta();
        meta.setCustomModelData(1);
        BASIC_MISSILE_TEXTURE.setItemMeta(meta);
    }

    static void createBasicMissileItem(){
        ItemMeta meta = BASIC_MISSILE_ITEM.getItemMeta();
        meta.setDisplayName("§oBasic Missile");
        meta.setCustomModelData(2);
        BASIC_MISSILE_ITEM.setItemMeta(meta);
    }

    static void createClearItem(){
        ItemMeta meta = CLEAR.getItemMeta();
        meta.setDisplayName(" ");
        CLEAR.setItemMeta(meta);
    }

}
