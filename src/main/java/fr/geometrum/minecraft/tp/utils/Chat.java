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
        sender.sendMessage(ChatColor.DARK_RED + msg);
    }

    public static void requirePlayer(CommandSender sender) {
        Chat.sendFail(sender, "You must be a player to use this command!");
    }

    public static void requirePermission(Player player) {
        Chat.sendFail(player, "You dont have permission to do that!");
    }

    public static void requirePermission(Player player, Player target) {
        Chat.sendFail(player, target.getDisplayName() + " dont have permissions for teleportation!");
    }

    public static void playerNotFound(Player player, String playerName) {
        Chat.sendError(player, "Player " + playerName + " not found!");
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

    public static void tpNeverRequested(Player player) {
        Chat.sendError(player, "You have sent no tp requests!");
    }

    public static void tpNeverReceived(Player player) {
        Chat.sendError(player, "You have received no tp requests!");
    }

    public static void tpNeverReceivedFrom(Player player, Player sender) {
        Chat.sendError(player, "You have received no tp requests from " + sender.getDisplayName() + "!");
    }

    public static void needDifferentPlayer(Player player) {
        Chat.sendError(player, "You cannot tp to yourself!");
    }

    public static void needSameWorld(Player player, Player target) {
        Chat.sendError(player, "The player " + target.getDisplayName() + " is in a different world!");
    }

    public static void askTpTo(Player player, Player target) {
        Chat.sendPending(player, "Teleportation request sent to " + target.getDisplayName() + ".");
        Chat.sendPending(target, 
            player.getDisplayName() + " has requested to teleport to you.\n" +
            "To accept, type " + ChatColor.GREEN + "/tpaccept" + ChatColor.GOLD + ".\n" + 
            "To deny this request, type " + ChatColor.RED + "/tpdeny" + ChatColor.GOLD + "."
        );
    }

    public static void askTpHere(Player player, Player target) {
        Chat.sendPending(player, "Teleportation request sent to " + target.getDisplayName() + ".");
        Chat.sendPending(target,
            player.getDisplayName() + " has requested to teleport you to its position.\n" + "To accept, type " + ChatColor.GREEN
            + "/tpaccept" + ChatColor.GOLD + ".\n" + "To deny this request, type " + ChatColor.RED
            + "/tpdeny" + ChatColor.GOLD + ".");
    }

    public static void cancelAskTp(Player player, Player target) {
        Chat.sendError(player, "Teleportation request was canceled.");
        Chat.sendError(target, player.getDisplayName() + "'s teleportation request has been canceled.");
    }

    public static void denyAskTp(Player sender, Player receiver) {
        Chat.sendError(sender, "Teleportation request was denied.");
        Chat.sendError(receiver, sender.getDisplayName() + "'s teleportation request has been denied.");
    }
}
