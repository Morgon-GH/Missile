package de.morgon.missile.summons;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.EulerAngle;

import static de.morgon.missile.ItemHandler.BASIC_MISSILE_ITEM;
import static de.morgon.missile.ItemHandler.BASIC_MISSILE_TEXTURE;

public class BasicMissile {

    public void summon(Player player, Location location) {
        EulerAngle angle = new EulerAngle(0.0, 0.0, 0.0);
        ArmorStand missile = (ArmorStand)player.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        missile.addScoreboardTag("missile");
        missile.setInvisible(true);
        missile.setBasePlate(false);
        missile.setInvulnerable(true);
        missile.setSmall(false);
        missile.setRightArmPose(angle);
        missile.setItem(EquipmentSlot.HAND, BASIC_MISSILE_TEXTURE);
        missile.setGravity(false);
    }
}
