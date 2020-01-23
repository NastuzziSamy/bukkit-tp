package fr.geometrum.minecraft.tp.commands;

import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import fr.geometrum.minecraft.tp.Main;
import fr.geometrum.minecraft.tp.utils.TP;
import fr.geometrum.minecraft.tp.utils.Chat;


public class TpCancel extends BaseCommand {
    public TpCancel(Main plugin) {
        TpCancel.this.plugin = plugin;
    }

    public String getCommandName() {
        return BaseCommand.TP_CANCEL;
    }

    protected int getMinArgs() {
        return 0;
    }

    protected int getMaxArgs() {
        return 0;
    }

    public boolean onCommand(Player player, Command cmd, String label, String[] args) {
        if (!TpCancel.this.getTPManager().has(player)) {
            Chat.tpNeverRequested(player);

            return true;
        }

        TP tp = TpCancel.this.getTPManager().get(player);

        tp.cancel();
        TpCancel.this.getTPManager().remove(tp);
    
        return true;
    }
}