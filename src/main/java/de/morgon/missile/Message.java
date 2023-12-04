package de.morgon.missile;

import org.bukkit.command.CommandSender;

public class Message {

    public void ConsoleCantExecuteError(CommandSender commandSender) {
        commandSender.sendMessage("This Error can't be performed by the console");
    }

    public void WrongInputTypeError(CommandSender commandSender) {
        commandSender.sendMessage("Please enter the right input type");
    }
}
