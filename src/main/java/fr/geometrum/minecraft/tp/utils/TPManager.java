package fr.geometrum.minecraft.tp.utils;

import java.util.ArrayList;
import org.bukkit.entity.Player;


public class TPManager {
    protected ArrayList<TP> tps;

    public TPManager() {
        TPManager.this.tps = new ArrayList<TP>();
    }

    public TP get(Player player) {
        for (TP tp: TPManager.this.tps) {
            if (tp.getSender() == player) {
                return tp;
            }
        }

        return null;
    }

    public boolean has(Player player) {
        for (TP tp : TPManager.this.tps) {
            if (tp.getSender() == player) {
                return true;
            }
        }

        return false;
    }

    public void remove(TP tp) {
        TPManager.this.tps.remove(tp);
    }

    public void remove(Player player) {
        for (TP tp : TPManager.this.tps) {
            if (tp.getSender() == player) {
                TPManager.this.remove(tp);

                break;
            }
        }
    }

    public void clean() {
        TP tp;

        while (TPManager.this.tps.size() > 0) {
            tp = TPManager.this.tps.get(0);
            
            tp.cancel();
            TPManager.this.remove(tp);
        }
    }

    public void addTp(TP tp) {
        TPManager.this.tps.add(tp);
    }
}
