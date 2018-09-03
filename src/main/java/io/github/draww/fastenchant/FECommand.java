package io.github.draww.fastenchant;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import io.github.draww.fastenchant.utils.StringUtils;
import mkremins.fanciful.FancyMessage;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;

@CommandAlias("fe|fastenchant")
public class FECommand extends BaseCommand {

    @Default
    @Subcommand("help")
    @Syntax("")
    @CommandPermission("fastenchant.help")
    public void onHelp(CommandSender sender) {
        String label = getExecCommandLabel();
        sender.sendMessage(StringUtils.setColourList(Arrays.asList(
                "&a&m--------------------------------------------------"
                , "&f&lFastEnchant &7- How to use /" + label + " properly."
                , " "
                , "&7Proper Usage: &e/" + label + " <arg>"
                , "&bAll possible actions. &7&o(Click the text to autofill the command)"))
                .toArray(new String[0]));
        new FancyMessage("/" + label + " help")
                .color(ChatColor.GREEN)
                .tooltip("Click to autofill command")
                .suggest("/" + label + " help")
                .then(" - sends help message")
                .color(ChatColor.YELLOW)
                .send(sender);
        if (sender.hasPermission("fastenchant.reload")) {
            new FancyMessage("/" + label + " reload")
                    .color(ChatColor.GREEN)
                    .tooltip("Click to autofill command")
                    .suggest("/" + label + " reload")
                    .then(" - reloads the plugin and all configuration files")
                    .color(ChatColor.YELLOW)
                    .send(sender);
        }
        sender.sendMessage("&a&m--------------------------------------------------");
    }

    @Subcommand("reload")
    @CommandPermission("fastenchant.reload")
    @Syntax("")
    public void onReload(CommandSender sender) {
        FastEnchant.getInstance().reload();
        sender.sendMessage(StringUtils.cc("&7FastEnchant has been successfully reloaded!"));
    }
}
