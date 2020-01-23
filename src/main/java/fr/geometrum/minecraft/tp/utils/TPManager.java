package fr.geometrum.minecraft.tp.utils;

import java.util.ArrayList;
import org.bukkit.entity.Player;


public class TPManager {
    protected ArrayList<TP> tps;

    public TPManager() {
        TPManager.this.tps = new ArrayList<TP>();
    }

    public TP getFromSender(Player player) {
        for (TP tp: TPManager.this.tps) {
            if (tp.getSender() == player) {
                return tp;
            }
        }

        return null;
    }

    public boolean hasFromSender(Player player) {
        for (TP tp: TPManager.this.tps) {
            if (tp.getSender() == player) {
                return true;
            }
        }

        return false;
    }

    public void clean() {
        // Indicate that all was canceled.
    }

    public void addTp(TP tp) {
        TPManager.this.tps.add(tp);
    }
}
