package fr.geometrum.minecraft.tp.commands;

import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import fr.geometrum.minecraft.tp.Main;
import fr.geometrum.minecraft.tp.utils.TP;
import fr.geometrum.minecraft.tp.utils.Chat;


public class TpTo extends BaseCommand {
    public TpTo(Main plugin) {
        TpTo.this.plugin = plugin;
    }

    public String getCommandName() {
        return BaseCommand.TP_TO;
    }

    protected int getMinArgs() {
        return 1;
    }

    protected int getMaxArgs() {
        return 1;
    }

    public boolean onCommand(Player player, Command cmd, String label, String[] args) {
        if (TpTo.this.getTPManager().has(player)) {
            Chat.tpAlreadyRequested(player);

            return true;
        }

        Player target = TpTo.this.findPlayer(args[0]);

        if (target == player) {
            Chat.needDifferentPlayer(player);

            return true;
        }

        if (target.getWorld() != player.getWorld()) {
            Chat.needSameWorld(player, target);

            return true;
        }

        if (!TpTo.this.hasPermission(target, BaseCommand.TP_ACCEPT) || !TpTo.this.hasPermission(target, BaseCommand.TP_DENY)) {
            Chat.requirePermission(player, target);

            return true;
        }

        TpTo.this.getTPManager().addTp(new TP(player, target));
    
        Chat.askTpTo(player, target);

        return true;
    }
}