package fr.geometrum.minecraft.tp.commands;

import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import fr.geometrum.minecraft.tp.Main;
import fr.geometrum.minecraft.tp.utils.TP;
import fr.geometrum.minecraft.tp.utils.Chat;


public class TpAccept extends BaseCommand {
    public TpAccept(Main plugin) {
        TpAccept.this.plugin = plugin;
    }

    public String getCommandName() {
        return BaseCommand.TP_ACCEPT;
    }

    protected int getMinArgs() {
        return 0;
    }

    protected int getMaxArgs() {
        return 1;
    }

    public boolean onCommand(Player player, Command cmd, String label, String[] args) {
        if (!TpAccept.this.getTPManager().hasReceiver(player)) {
            Chat.tpNeverReceived(player);

            return true;
        }

        TP tp;

        if (args.length == 1) {
            Player sender = TpAccept.this.findPlayer(args[0]);

            if (sender == null) {
                Chat.playerNotFound(player, args[0]);

                return true;
            }

            if (!TpAccept.this.getTPManager().has(sender)) {
                Chat.tpNeverReceivedFrom(player, sender);

                return true;
            }

            tp = TpAccept.this.getTPManager().get(sender);

            if (tp.getReceiver() != player) {
                Chat.tpNeverReceivedFrom(player, sender);

                return true;
            }
        } else {
            tp = TpAccept.this.getTPManager().getReceiver(player);
        }

        tp.accept();
        TpAccept.this.getTPManager().remove(tp);
    
        return true;
    }
}