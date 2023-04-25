package de.morgon.missile.summons;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Missile {

    public void summon(Player player, Location location){
        ArmorStand missile = (ArmorStand) player.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);

        ItemStack missileT = new ItemStack(Material.PAPER);     //missileTexture
        ItemMeta missileTM = missileT.getItemMeta();            //missileTextureMeta
        missileTM.setCustomModelData(1);
        missileT.setItemMeta(missileTM);

        missile.setInvisible(true);
        missile.setBasePlate(false);
        missile.setSmall(true);
        missile.setMarker(true);
        missile.setInvulnerable(true);
        missile.setItem(EquipmentSlot.HEAD, missileT);
    }

}
