package fr.geometrum.minecraft.tp;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.entity.Player;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.plugin.java.JavaPlugin;
import fr.geometrum.minecraft.tp.commands.*;
import fr.geometrum.minecraft.tp.utils.Chat;


public class Main extends JavaPlugin {
   protected HashMap<String, BaseCommand> commands;

   public void onEnable() {
      Main.this.getLogger().info("TP plugin has been enabled!");

      Main.this.initCommands();
   }

   public void onDisable() {
      Main.this.getLogger().info("TP plugin has been disabled!");
   }

   public void initCommands() {
      Main.this.commands = new HashMap<String, BaseCommand>();
   
      Main.this.commands.put(TpTo.command, new TpTo(this));
   }

   public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
      if (!(sender instanceof Player)) {
         Chat.requirePlayer(sender);

         return false;
      }

      for (String commandName: Main.this.commands.keySet()) {
         if (command.getName().equalsIgnoreCase(commandName)) {
            return Main.this.commands.get(commandName).onCommand(sender, command, label, args);
         }
      }
      
      Chat.sendError((Player) sender, "Unknown command!");

      return false;
   }
}