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

public class XListener implements CommandExecutor {
    FileConfiguration config = Main.plugin.getConfig();


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("set")){
            Player p = (Player) sender;

            Player player = (Player) sender;
            player.getLocation();
            if(args.length == 0){

            }
            else if (args[0].equalsIgnoreCase("one")) {
                player.getLocation();


                config.set("P1.x", player.getLocation().getX());                      // All of this is just to set the spawnpoint. Multiple vars for OnDeath...
                config.set("P1.y", player.getLocation().getY());
                config.set("P1.z", player.getLocation().getZ());
                config.set("P1.pitch", player.getLocation().getPitch());
                config.set("P1.yaw", player.getLocation().getYaw());
                config.set("P1.LNL", player.getLocation());
                Main.plugin.saveConfig();

                Object x = config.get("P2.x");
                Object y = config.get("P2.y");
                Object z = config.get("P2.z");
               // Bukkit.broadcastMessage(ChatColor.RED+""+ChatColor.BOLD+"BRACCCCKETS> "+ChatColor.WHITE + "" +"Player 1: "+ChatColor.RED+""+p.getName()+ChatColor.GRAY+"LOCATION: "+ChatColor.YELLOW +Math.round((Double) x)+" , "+Math.round((Double) y)+" , "+Math.round((Double) z));

            }else if (args[0].equalsIgnoreCase("two")) {

                    player.getLocation();


                    config.set("P2.x", player.getLocation().getX());                      // All of this is just to set the spawnpoint. Multiple vars for OnDeath...
                    config.set("P2.y", player.getLocation().getY());
                    config.set("P2.z", player.getLocation().getZ());
                    config.set("P2.pitch", player.getLocation().getPitch());
                    config.set("P2.yaw", player.getLocation().getYaw());
                    config.set("P2.LNL", player.getLocation());
                    Main.plugin.saveConfig();

                    Object x = config.get("P2.x");
                    Object y = config.get("P2.y");
                    Object z = config.get("P2.z");
                    Bukkit.broadcastMessage(ChatColor.RED+""+ChatColor.BOLD+"BRACKETS> "+ChatColor.WHITE + "" +"Player 2: "+ChatColor.RED+""+p.getName()+ChatColor.GRAY+"LOCATION: "+ChatColor.YELLOW +Math.round((Double) x)+" , "+Math.round((Double) y)+" , "+Math.round((Double) z));

                }else {
                    Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + "BRACKETS> " + ChatColor.DARK_RED + "ERROR: No LNL found in config.yml or no ARGS. Please use the /s1 command to set your bracket spawn location, you dunce.");

                }
            }




        return false;

    }

}



