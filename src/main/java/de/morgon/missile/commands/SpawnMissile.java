package de.morgon.missile.commands;
import de.morgon.missile.Message;
import de.morgon.missile.summons.Missile;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static java.lang.Double.parseDouble;

public class SpawnMissile implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        Message message = new Message();
        Missile missile = new Missile();

        if(commandSender instanceof Player){
            Player p = (Player) commandSender;

            if(strings.length == 0) {

                missile.summon(p, p.getLocation());

            } else if (strings.length == 3) {
                try {
                    Location location = new Location(p.getWorld(), parseDouble(strings[0]) + 0.5, parseDouble(strings[1]) + 0.5, parseDouble(strings[2]) + 0.5);
                    missile.summon(p, location);
                } catch (Exception e) {
                    message.WrongInputTypeError(p);
                }
            }

        }else message.ConsoleCantExecuteError(commandSender);
        return false;
    }
}
