package de.morgon.missile.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class MissileRecipe {

    public static void register(NamespacedKey key) {
        ItemStack missileItem = new ItemStack(Material.PAPER);
        ItemMeta missileItemM = missileItem.getItemMeta();
        missileItemM.setDisplayName("§oMissile");
        missileItemM.setCustomModelData(2);
        missileItem.setItemMeta(missileItemM);
        ShapedRecipe recipe = new ShapedRecipe(key, missileItem);
        recipe.shape(new String[]{" I ", "ITI", "IGI"});
        recipe.setIngredient('I', Material.IRON_BLOCK);
        recipe.setIngredient('T', Material.TNT);
        recipe.setIngredient('G', Material.GUNPOWDER);
        Bukkit.addRecipe(recipe);
    }
}
