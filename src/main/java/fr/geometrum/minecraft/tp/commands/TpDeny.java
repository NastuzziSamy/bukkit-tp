package fr.geometrum.minecraft.tp.commands;

import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import fr.geometrum.minecraft.tp.Main;
import fr.geometrum.minecraft.tp.utils.TP;
import fr.geometrum.minecraft.tp.utils.Chat;


public class TpDeny extends BaseCommand {
    public TpDeny(Main plugin) {
        TpDeny.this.plugin = plugin;
    }

    public String getCommandName() {
        return BaseCommand.TP_DENY;
    }

    protected int getMinArgs() {
        return 0;
    }

    protected int getMaxArgs() {
        return 1;
    }

    public boolean onCommand(Player player, Command cmd, String label, String[] args) {
        if (!TpDeny.this.getTPManager().hasReceiver(player)) {
            Chat.tpNeverReceived(player);

            return true;
        }

        TP tp;

        if (args.length == 1) {
            Player sender = TpDeny.this.findPlayer(args[0]);

            if (sender == null) {
                Chat.playerNotFound(player, args[0]);

                return true;
            }

            if (!TpDeny.this.getTPManager().has(sender)) {
                Chat.tpNeverReceivedFrom(player, sender);

                return true;
            }

            tp = TpDeny.this.getTPManager().get(sender);

            if (tp.getReceiver() != player) {
                Chat.tpNeverReceivedFrom(player, sender);

                return true;
            }
        } else {
            tp = TpDeny.this.getTPManager().getReceiver(player);
        }

        tp.deny();
        TpDeny.this.getTPManager().remove(tp);
    
        return true;
    }
}