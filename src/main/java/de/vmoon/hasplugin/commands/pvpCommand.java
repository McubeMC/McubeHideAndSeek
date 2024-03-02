package de.vmoon.hasplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.List;

public class pvpCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("pvp")) {
            if (!sender.hasPermission("pvp.use")) {
                sender.sendMessage("§cDu hast keine Berechtigung um diesen Befehl auszuführen!");
                return true;
            }
            else {
                if (args.length == 0) {
                    sender.sendMessage("An oder aus?");
                    return true;
                }
                else {
                    if (args[0].equalsIgnoreCase("on")) {
                        if (!sender.hasPermission("pvp.on")) {
                            sender.sendMessage("§cDu hast keine Berechtigung um diesen Befehl auszuführen!");
                            return true;
                        }
                        else {
                            enablepvp();
                        }
                    }
                    else if (args[0].equalsIgnoreCase("off")) {
                        if (!sender.hasPermission("pvp.on")) {
                            sender.sendMessage("§cDu hast keine Berechtigung um diesen Befehl auszuführen!");
                            return true;
                        }
                        else {
                            disablepvp();
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        return null;
    }

    public void disablepvp() {
        Bukkit.getWorld("world").setPVP(false);
        Bukkit.getConsoleSender().sendMessage("§6[DEBUG] PVP wurde deaktiviert!");
    }
    public void enablepvp() {
        Bukkit.getWorld("world").setPVP(true);
        Bukkit.getConsoleSender().sendMessage("§6[DEBUG] PVP wurde aktiviert!");
    }
}
