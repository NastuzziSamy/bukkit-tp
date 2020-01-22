package fr.geometrum.minecraft.tp;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
   public void onEnable() {
      this.getLogger().info("TP plugin has been enabled!");
   }

   public void onDisable() {
      this.getLogger().info("TP plugin has been disabled!");
   }
}