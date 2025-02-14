package dev.thew.skyBlock.command;

import dev.thew.command.AbstractCommand;
import dev.thew.message.Message;
import dev.thew.skyBlock.command.subcommand.Create;
import dev.thew.skyBlock.command.subcommand.Delete;
import dev.thew.skyBlock.command.subcommand.Info;
import org.bukkit.command.CommandSender;

import java.util.List;

public class IslandCommand extends AbstractCommand {

    public IslandCommand() {
        super("island");

        subCommand(new Info(), new Create(), new Delete());
    }

    @Override
    public Message execute(CommandSender commandSender, String[] args) {
        return null;
    }

    @Override
    public List<String> tabList(CommandSender commandSender, String[] args) {
        return List.of();
    }
}
