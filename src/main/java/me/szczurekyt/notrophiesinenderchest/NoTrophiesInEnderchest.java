package me.szczurekyt.notrophiesinenderchest;

import org.bukkit.plugin.java.JavaPlugin;

public final class NoTrophiesInEnderchest extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new EnderchestListeners(this), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
