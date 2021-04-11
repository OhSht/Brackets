package dev.barbar.brackets;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

public class Startit implements CommandExecutor {
    public static Integer Freeze = 0;

    FileConfiguration config = Main.plugin.getConfig();
    public Integer setNum(int num) {
        return Freeze;
    }
    @Override



    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if(command.getName().equalsIgnoreCase("start")){
            Player p = (Player) sender;
            if(args.length == 0){

                if(Freeze==0){
                    p.sendMessage("frozen!");
                    Freeze = 1;
                    p.sendMessage(Freeze.toString());
                    BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
                    if(Startit.Freeze==1){


                        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {
                            public void run() {
                                Bukkit.broadcastMessage("NO");
                            }
                        }, 20L, 20L);

                    }


                }
            }
                    return false;
        }
        return false;
    }
}


