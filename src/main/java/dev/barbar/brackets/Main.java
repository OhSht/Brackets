package dev.barbar.brackets;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public static Main plugin;

    FileConfiguration config = getConfig();


    @Override
    public void onEnable(){
        plugin = this;
        Bukkit.getPluginManager().registerEvents(new Day(), this);
        Bukkit.getPluginManager().registerEvents(new Break(), this);

        this.getCommand("set").setExecutor(new XListener());
        this.getCommand("bspawn").setExecutor(new CmdT());
        this.getCommand("start").setExecutor(new Startit());

        config.addDefault("Test", true);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public void ConfigListener(Main instance) {

        plugin = instance;

    }
    public class Day implements Listener{
        @EventHandler
        public void onMove(PlayerMoveEvent e){
            Player player = e.getPlayer();

            if (e.getFrom().getX() != e.getTo().getX() || e.getFrom().getZ() != e.getTo().getZ()){
                player.getWorld().setTime(8000);



            }

    }

}
    public class Break implements Listener{
        @EventHandler
        public void onBreak(BlockBreakEvent e){
            Player player = e.getPlayer();
            if (e.getBlock()!= null&& !player.isOp()){
                e.setCancelled(true);

            }

        }

    }
}
