package fr.geometrum.minecraft.tp.utils;

import org.bukkit.entity.Player;


public class TP {
    protected Player sender;
    protected Player receiver;
    protected boolean tpHere = false;

    public TP(Player sender, Player receiver, boolean tpHere) {
        TP.this.sender = sender;
        TP.this.receiver = receiver;
        TP.this.tpHere = tpHere;
    }

    public TP(Player sender, Player receiver) {
        TP.this.sender = sender;
        TP.this.receiver = receiver;
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
}
