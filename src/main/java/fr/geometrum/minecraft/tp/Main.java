package fr.geometrum.minecraft.tp;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.geometrum.minecraft.tp.commands.BaseCommand;
import fr.geometrum.minecraft.tp.commands.TpAccept;
import fr.geometrum.minecraft.tp.commands.TpCancel;
import fr.geometrum.minecraft.tp.commands.TpDeny;
import fr.geometrum.minecraft.tp.commands.TpHere;
import fr.geometrum.minecraft.tp.commands.TpTo;
import fr.geometrum.minecraft.tp.utils.Chat;
import fr.geometrum.minecraft.tp.utils.TPManager;


public class Main extends JavaPlugin {
   protected ArrayList<BaseCommand> commands;
   protected TPManager tpManager;

   public void onEnable() {
      Main.this.initCommands();
      Main.this.initData();

      Main.this.getLogger().info("TP plugin has been enabled!");
   }

   public void onDisable() {
      Main.this.cleanData();

      Main.this.getLogger().info("TP plugin has been disabled!");
   }

   protected void initCommands() {
      Main.this.commands = new ArrayList<BaseCommand>();
   
      Main.this.commands.add(new TpTo(this));
      Main.this.commands.add(new TpHere(this));
      Main.this.commands.add(new TpCancel(this));
      Main.this.commands.add(new TpDeny(this));
      Main.this.commands.add(new TpAccept(this));
   }

   protected void initData() {
      Main.this.tpManager = new TPManager();
   }

   protected void cleanData() {
      Main.this.tpManager.clean();
   }

   public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
      if (!(sender instanceof Player)) {
         Chat.requirePlayer(sender);

         return true;
      }

      for (BaseCommand pluginCommand: Main.this.commands) {
         if (command.getName().equalsIgnoreCase(pluginCommand.getCommandName())) {
            return pluginCommand.onCommand(sender, command, label, args);
         }
      }
      
      Chat.sendError((Player) sender, "Unknown command!");

      return false;
   }

   public TPManager getTPManager() {
      return Main.this.tpManager;
   }
}