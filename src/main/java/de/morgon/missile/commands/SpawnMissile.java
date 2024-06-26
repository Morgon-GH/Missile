package de.morgon.missile.commands;

import de.morgon.missile.Message;
import de.morgon.missile.summons.BasicMissile;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SpawnMissile implements CommandExecutor {

    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        BasicMissile missile = new BasicMissile();
        if (commandSender instanceof Player) {
            Player p = (Player)commandSender;
            if (strings.length == 0) {
                missile.summon(p, p.getLocation());
            } else if (strings.length == 3) {
                try {
                    Location location = new Location(p.getWorld(), Double.parseDouble(strings[0]) + 0.5, Double.parseDouble(strings[1]) + 0.5, Double.parseDouble(strings[2]) + 0.5);
                    missile.summon(p, location);
                } catch (Exception var9) {
                    Message.WrongInputTypeError(p);
                }
            }
        } else {
            Message.ConsoleCantExecuteError(commandSender);
        }

        return false;
    }
}
