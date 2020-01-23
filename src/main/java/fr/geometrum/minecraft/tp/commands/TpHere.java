package fr.geometrum.minecraft.tp.commands;

import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import fr.geometrum.minecraft.tp.Main;
import fr.geometrum.minecraft.tp.utils.TP;
import fr.geometrum.minecraft.tp.utils.Chat;


public class TpHere extends BaseCommand {
    public TpHere(Main plugin) {
        TpHere.this.plugin = plugin;
    }

    public String getCommandName() {
        return BaseCommand.TP_HERE;
    }

    protected int getMinArgs() {
        return 1;
    }

    protected int getMaxArgs() {
        return 1;
    }

    public boolean onCommand(Player player, Command cmd, String label, String[] args) {
        if (TpHere.this.getTPManager().has(player)) {
            Chat.tpAlreadyRequested(player);

            return true;
        }

        Player target = TpHere.this.findPlayer(args[0]);

        if (target == null) {
            Chat.playerNotFound(player, args[0]);

            return true;
        }

        if (target == player) {
            Chat.needDifferentPlayer(player);

            return true;
        }

        if (target.getWorld() != player.getWorld()) {
            Chat.needSameWorld(player, target);

            return true;
        }

        if (!TpHere.this.hasPermission(target, BaseCommand.TP_ACCEPT) || !TpHere.this.hasPermission(target, BaseCommand.TP_DENY)) {
            Chat.requirePermission(player, target);

            return true;
        }

        TpHere.this.getTPManager().addTp(new TP(player, target, TP.HERE));

        return true;
    }
}