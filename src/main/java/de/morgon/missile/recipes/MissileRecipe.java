package de.morgon.missile.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import static de.morgon.missile.ItemHandler.BASIC_MISSILE_ITEM;

public class MissileRecipe {

    public static void register(NamespacedKey key) {
        ShapedRecipe recipe = new ShapedRecipe(key, BASIC_MISSILE_ITEM);
        recipe.shape(new String[]{" I ", "ITI", "IGI"});
        recipe.setIngredient('I', Material.IRON_BLOCK);
        recipe.setIngredient('T', Material.TNT);
        recipe.setIngredient('G', Material.GUNPOWDER);
        Bukkit.addRecipe(recipe);
    }
}
