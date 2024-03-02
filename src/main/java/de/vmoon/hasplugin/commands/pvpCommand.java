package de.vmoon.hasplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class pvpCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("pvp")) {
            if (!sender.hasPermission("pvp.use")) {
                sender.sendMessage("§cDu hast keine Berechtigung um diesen Befehl auszuführen!");
                return true;
            }
            else {
                disablepvp();
            }
        }
        else if (cmd.getName().equalsIgnoreCase("on")) {
            if (!sender.hasPermission("pvp.on")) {
                sender.sendMessage("§cDu hast keine Berechtigung um diesen Befehl auszuführen!");
                return true;
            }
            else {
                enablepvp();
            }
        }
        return false;
    }

    public void disablepvp() {
        Bukkit.getWorld("world").setPVP(false);
        Bukkit.getConsoleSender().sendMessage("§6[DEBUG] PVP wurde deaktiviert!");
    }
    public void enablepvp() {
        Bukkit.getWorld("world").setPVP(true);
        Bukkit.getConsoleSender().sendMessage("§6[DEBUG] PVP wurde aktiviert!");
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
        if (args.length == 1) {
            List<String> completions = new ArrayList<>();
            completions.add("on");
            completions.add("off");
        }
        return null;
    }
}
