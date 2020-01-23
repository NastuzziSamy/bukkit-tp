package fr.geometrum.minecraft.tp.commands;

import org.bukkit.event.Listener;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import fr.geometrum.minecraft.tp.Main;
import fr.geometrum.minecraft.tp.utils.TPManager;
import fr.geometrum.minecraft.tp.utils.Chat;


abstract public class BaseCommand implements CommandExecutor, Listener {
    protected Main plugin;

    abstract public String getCommandName();

    abstract protected int getMinArgs();

    abstract protected int getMaxArgs();

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < BaseCommand.this.getMinArgs()) {
            Chat.tooFewArgs((Player) sender);

            return false;
        }

        if (args.length > BaseCommand.this.getMaxArgs()) {
            Chat.tooManyArgs((Player) sender);

            return false;
        }

        return BaseCommand.this.onCommand((Player) sender, command, label, args);
    }

    abstract public boolean onCommand(Player player, Command command, String label, String[] args);

    protected Player findPlayer(String playerName) {
        return Bukkit.getServer().getPlayer(playerName);
    }

    protected TPManager getTPManager() {
        return BaseCommand.this.plugin.getTPManager();
    }
}