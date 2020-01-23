package fr.geometrum.minecraft.tp.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.command.CommandSender;


public class Chat {
    public static void sendSuccess(Player player, String msg) {
        player.sendMessage(ChatColor.GOLD + msg);
    }

    public static void sendInfo(Player player, String msg) {
        player.sendMessage(ChatColor.WHITE + msg);
    }

    public static void sendError(Player player, String msg) {
        player.sendMessage(ChatColor.DARK_RED + msg);
    }

    public static void requirePlayer(CommandSender sender) {
        sender.sendMessage(ChatColor.DARK_RED + "You must be a player to use this command!");
    }

    public static void requirePermission(Player player) {
        Chat.sendError(player, "You dont have permission to do that!");
    }

    public static void tooManyArgs(Player player) {
        Chat.sendError(player, "Too many arguments!");
    }
}
