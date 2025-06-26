package de.vmoon.hasplugin;

import de.vmoon.hasplugin.commands.HasCommand;
import de.vmoon.hasplugin.commands.helpCommand;
import de.vmoon.hasplugin.commands.pvpCommand;
import de.vmoon.hasplugin.manager.LanguageManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class HASPlugin extends JavaPlugin {
    private static HASPlugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        LanguageManager languageManager = new LanguageManager(this);
        Bukkit.getWorld("world").setPVP(false);
        Bukkit.getConsoleSender().sendMessage("&a&l[MCUBEMC] &eHS is now successfully enabled!");
        getCommand("has").setExecutor(new HasCommand(languageManager));
        getCommand("pvp").setExecutor(new pvpCommand());
        getCommand("hashelp").setExecutor(new helpCommand());

    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("&c&l[MCUBEMC] &eHS is now successfully disabled.");
    }
    public static HASPlugin getPlugin() {
        return plugin;
    }
}
