package me.chaylannprophet.burnatday;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class BurnAtDay extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        // Register this plugin's listener
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location location = player.getLocation();
        World world = location.getWorld();
        long time = world.getTime();

        // Check if the player is in direct sunlight during the day
        if (location.getBlock().getLightFromSky() == 15 && time >= 0 && time < 12300 && !world.hasStorm()) {
            // Set the player on fire for 3 seconds
            player.setFireTicks(60);
        }
    }
}