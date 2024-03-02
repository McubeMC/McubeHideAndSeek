package de.vmoon.hasplugin;

import de.vmoon.hasplugin.commands.HasCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class HASPlugin extends JavaPlugin {
    private static HASPlugin plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        Bukkit.getConsoleSender().sendMessage("§6HASPlugin erfolgreich geladen!");
        getCommand("has").setExecutor(new HasCommand());

    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§6HASPlugin erfolgreich deaktiviert!");
        // Plugin shutdown logic
    }
    public static HASPlugin getPlugin() {
        return plugin;
    }
}
