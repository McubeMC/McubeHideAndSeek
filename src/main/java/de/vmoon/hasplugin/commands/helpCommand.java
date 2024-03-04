package de.vmoon.hasplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class helpCommand implements CommandExecutor, TabCompleter, Listener {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String alias, String[] strings) {
        if (command.getName().equalsIgnoreCase("hashelp")) {
            if (!commandSender.hasPermission("hashelp.use")) {
                commandSender.sendMessage("§cDu hast keine Berechtigung um diesen Befehl auszuführen!");
                return true;
            }
            else {
                if (strings.length == 0) {
                    commandSender.sendMessage("§l§n§2-----Help-----§r\n/has [select|stop|{time}|reload|teleportall]\n");
                    commandSender.sendMessage("Bei welchem befehl brauchst du Hilfe?");
                    return true;
                }
                else {
                    if (strings[0].equalsIgnoreCase("reload")) {
                        if (!commandSender.hasPermission("hashelp.reload")) {
                            commandSender.sendMessage("§cDu hast keine Berechtigung um diesen Befehl auszuführen!");
                            return true;
                        }
                        else {
                            commandSender.sendMessage("§l§n§2-----Help-----§r\n/has reload\nLädt die Configurations Datei neu.");
                        }
                    }
                    else if (strings[0].equalsIgnoreCase("select")) {
                        if (!commandSender.hasPermission("hashelp.select")) {
                            commandSender.sendMessage("§cDu hast keine Berechtigung um diesen Befehl auszuführen!");
                            return true;
                        }
                        else {
                            commandSender.sendMessage("§l§n§2-----Help-----§r\n/has select\nDamit wählst du den Spieler aus, der suchen soll. (Gild für alle nachfolgenden Runden)");
                        }
                    }
                    else if (strings[0].equalsIgnoreCase("stop")) {
                        if (!commandSender.hasPermission("hashelp.stop")) {
                            commandSender.sendMessage("§cDu hast keine Berechtigung um diesen Befehl auszuführen!");
                            return true;
                        }
                        else {
                            commandSender.sendMessage("§l§n§2-----Help-----§r\n/has stop\nBricht einen laufenden Timer ab.");
                        }
                    }
                    else if (strings[0].equalsIgnoreCase("teleportall")) {
                        if (!commandSender.hasPermission("hashelp.teleportall")) {
                            commandSender.sendMessage("§cDu hast keine Berechtigung um diesen Befehl auszuführen!");
                            return true;
                        }
                        else {
                            commandSender.sendMessage("§l§n§2-----Help-----§r\n/has teleportall\nTeleportiert alle Spieler zu den in der Datei angegebenen Koordinaten.");
                        }
                    }
                    else if (strings[0].equalsIgnoreCase("help")) {
                        if (!commandSender.hasPermission("hashelp.help")) {
                            commandSender.sendMessage("§cDu hast keine Berechtigung um diesen Befehl auszuführen!");
                            return true;
                        }
                        else {
                            commandSender.sendMessage("§l§n§2-----Help-----§r\n/has help\nZeigt diese Hilfe.");
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String alias, String[] strings) {
        if (strings.length == 1) {
            List<String> completions = new ArrayList<>();
            completions.add("reload");
            completions.add("select");
            completions.add("stop");
            completions.add("teleportall");
            completions.add("help");
            return completions.stream()
                    .filter(s -> s.startsWith(strings[0]))
                    .collect(Collectors.toList());
        }
        return null;
    }
}
