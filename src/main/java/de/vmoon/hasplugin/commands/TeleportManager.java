package de.vmoon.hasplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class TeleportManager {

    private final File configFile;
    private final FileConfiguration config;

    public TeleportManager() {
        this.configFile = new File("plugins/HASPlugin/config.yml");
        this.config = YamlConfiguration.loadConfiguration(configFile);
        // Standardwerte setzen, falls die Datei noch nicht existiert
        config.addDefault("teleportLocation.world", "world");
        config.addDefault("teleportLocation.x", 0);
        config.addDefault("teleportLocation.y", 64);
        config.addDefault("teleportLocation.z", 0);
        config.options().copyDefaults(true);
        saveConfig();
    }

    public void teleportAllPlayers() {
        World world = Bukkit.getWorld(config.getString("teleportLocation.world"));
        double x = config.getDouble("teleportLocation.x");
        double y = config.getDouble("teleportLocation.y");
        double z = config.getDouble("teleportLocation.z");
        Location location = new Location(world, x, y, z);
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.teleport(location);
        }
    }

    public void saveConfig() {
        try {
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
