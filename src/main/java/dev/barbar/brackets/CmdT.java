package dev.barbar.brackets;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

public class CmdT implements CommandExecutor {
    int count = 10;
    FileConfiguration config = Main.plugin.getConfig();


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {




        if (command.getName().equalsIgnoreCase("bspawn")) {
            Player p = (Player) sender;

            Player player = (Player) sender;
            player.getLocation();
            if (args.length == 0) {

            } else if (args[0].equalsIgnoreCase("one")) {
                if (config.contains("P1.LNL")) {
                    Object x = config.get("P1.x");
                    Object y = config.get("P1.y");
                    Object z = config.get("P1.z");
                    Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + "BRACKETS> " + ChatColor.WHITE + "" + "SPAWNSET: " + ChatColor.RED + "" + p.getName() + ChatColor.GRAY + "HAS BEGUN SPAWNED AT: " + ChatColor.YELLOW + Math.round((Double) x) + " , " + Math.round((Double) y) + " , " + Math.round((Double) z) + ChatColor.BOLD + ChatColor.GRAY + " ROUND WILL BEGIN SHORTLY");
                    Location loc = (Location) config.get("P1.LNL");
                    p.teleport(loc);
                    boolean b = true;
                }
            } else if (args[0].equalsIgnoreCase("two")) {

                Startit start = new Startit();

                if (config.contains("P2.LNL")) {
                    Object x = config.get("P2.x");
                    Object y = config.get("P2.y");
                    Object z = config.get("P2.z");
                    Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + "BRACKETS> " + ChatColor.WHITE + "" + "SPAWNSET: " + ChatColor.RED + "" + p.getName() + ChatColor.GRAY + "HAS BEGUN SPAWNED AT: " + ChatColor.YELLOW + Math.round((Double) x) + " , " + Math.round((Double) y) + " , " + Math.round((Double) z) + ChatColor.BOLD + ChatColor.GRAY + " ROUND WILL BEGIN SHORTLY");
                    Location loc = (Location) config.get("P2.LNL");
                    p.teleport(loc);
                    config.set("Players." + p.getUniqueId(), loc);
                    Main.plugin.saveConfig();

                    Location b = p.getLocation();
                    if(count>=0){
                        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
                        scheduler.scheduleSyncRepeatingTask(Main.plugin, new Runnable() {
                            @Override
                            public void run() {
                                Bukkit.broadcastMessage(String.valueOf(count));
                                count--;
                                if(count==0){
                                    scheduler.cancelTasks(Main.plugin);
                                    count=10;
                                }
                            }
                        }, 20L, 20L);
                    }
                }
            } else {
                Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + "BRACKETS> " + ChatColor.DARK_RED + "ERROR: No LNL found in config.yml or no ARGS. Please use the /s1 command to set your bracket spawn location, you dunce.");

            }


            return false;

        }
        return false;

    }
    public void cd(){
        if(count<=0){
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(Main.plugin, new Runnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage(String.valueOf(count));
                count--;
            }
        }, 5L, 20L);
    }

    }
}




