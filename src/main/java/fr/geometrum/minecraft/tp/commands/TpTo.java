package fr.geometrum.minecraft.tp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import fr.geometrum.minecraft.tp.Main;


public class TpTo extends BaseCommand {
    public static String command = "tpto";

    private final Main plugin;

    public TpTo(Main plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        TpTo.this.plugin.getLogger().info("CoucouTpTo");
        return true;
    }
}