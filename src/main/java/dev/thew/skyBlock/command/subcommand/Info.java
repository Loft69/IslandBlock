package dev.thew.skyBlock.command.subcommand;

import dev.thew.command.SubCommand;
import dev.thew.message.Message;
import org.bukkit.command.CommandSender;

import java.util.List;

public class Info extends SubCommand {

    public Info() {
        super("info");
    }

    @Override
    public Message execute(CommandSender commandSender, String[] strings) {
        return null;
    }

    @Override
    public List<String> tabList(CommandSender commandSender, String[] strings) {
        return List.of();
    }
}
