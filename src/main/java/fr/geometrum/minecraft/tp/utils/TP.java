package fr.geometrum.minecraft.tp.utils;

import org.bukkit.entity.Player;


public class TP {
    final public static boolean HERE = true;
    final public static boolean NOT_HERE = false;

    protected Player sender;
    protected Player receiver;
    protected boolean tpHere = TP.NOT_HERE;

    public TP(Player sender, Player receiver, boolean tpHere) {
        TP.this.sender = sender;
        TP.this.receiver = receiver;
        TP.this.tpHere = tpHere;

        if (TP.this.tpHere) {
            Chat.askTpHere(TP.this.sender, TP.this.receiver);
        } else {
            Chat.askTpTo(TP.this.sender, TP.this.receiver);
        }
    }

    public TP(Player sender, Player receiver) {
        this(sender, receiver, TP.NOT_HERE);
    }

    public Player getSender() {
        return TP.this.sender;
    }

    public Player getReceiver() {
        return TP.this.receiver;
    }

    public void cancel() {
        Chat.cancelAskTp(TP.this.sender, TP.this.receiver);
    }

    public void deny() {
        Chat.denyAskTp(TP.this.sender, TP.this.receiver);
    }

    public void accept() {
        if (TP.this.tpHere) {
            Chat.tpHere(TP.this.sender, TP.this.receiver);
            TP.this.tp(TP.this.sender, TP.this.receiver);
        } else {
            Chat.tp(TP.this.sender, TP.this.receiver);
            TP.this.tp(TP.this.receiver, TP.this.sender);
        }
    }

    public void tp(Player player, Player playerToTeleport) {
        playerToTeleport.teleport(player);
    }
}
