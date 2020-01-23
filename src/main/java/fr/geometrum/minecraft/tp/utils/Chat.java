package fr.geometrum.minecraft.tp.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.command.CommandSender;


public class Chat {
    public static void sendPending(CommandSender sender, String msg) {
        sender.sendMessage(ChatColor.GOLD + msg);
    }

    public static void sendInfo(CommandSender sender, String msg) {
        sender.sendMessage(ChatColor.WHITE + msg);
    }

    public static void sendError(CommandSender sender, String msg) {
        sender.sendMessage(ChatColor.RED + msg);
    }

    public static void sendFail(CommandSender sender, String msg) {
        sender.sendMessage(ChatColor.RED + msg);
    }

    public static void requirePlayer(CommandSender sender) {
        Chat.sendFail(sender, "You must be a player to use this command!");
    }

    public static void requirePermission(Player player) {
        Chat.sendFail(player, "You dont have permission to do that!");
    }

    public static void tooManyArgs(Player player) {
        Chat.sendError(player, "Too many arguments!");
    }

    public static void tooFewArgs(Player player) {
        Chat.sendError(player, "Too few arguments!");
    }

    public static void tpAlreadyRequested(Player player) {
        Chat.sendError(player, "You have already sent a tp request!");
    }

    public static void needDifferentPlayer(Player player) {
        Chat.sendError(player, "You cannot tp to yourself!");
    }

    public static void needSameWorld(Player player, Player target) {
        Chat.sendError(player, "The player " + target.getDisplayName() + " is in a different world!");
    }

    public static void askTpTo(Player player, Player target) {
        Chat.sendPending(player, "Teleportation request sent to " + ChatColor.WHITE + target.getDisplayName() + ChatColor.GOLD + ".");
        Chat.sendPending(target, 
            ChatColor.WHITE + player.getDisplayName() + 
            ChatColor.GOLD + " has requested to teleport to you.\n" +
            "To accept, type " + ChatColor.GREEN + "/tpaccept" + ChatColor.GOLD + ".\n" + 
            "To deny this request, type " + ChatColor.RED + "/tpdeny" + ChatColor.GOLD + "."
        );
    }
}
