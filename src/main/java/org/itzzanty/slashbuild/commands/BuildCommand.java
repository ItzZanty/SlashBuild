package org.itzzanty.slashbuild.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.itzzanty.slashbuild.Main;

public class BuildCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {

        if (sender.hasPermission("slashbuild.build")) {
            if (args.length == 0) { // Wenn keine Argumente angegeben sind
                // Da kein Spieler angegeben ist, muss der CommandSender automatisch als ausgewählten Spieler genommen werden
                // Dafür muss also geschaut werden, ob dieser CommandSender überhaupt ein Spieler ist:
                if (sender instanceof Player) {
                    Player plr = (Player) sender; // Wir entnehmen aus dem CommandSender nur den Spieler
                    if (Main.getBuilders().contains(plr)) { // Wenn der Spieler in der Liste ist
                        Main.removeBuilder(plr);
                        plr.sendMessage(Main.prefix + ChatColor.YELLOW + "Du kannst auf diesem Server jetzt " + ChatColor.RED + "nicht mehr bauen" + ChatColor.YELLOW + ".");
                    } else { // Wenn der Spieler nicht in der Liste ist
                        Main.addBuilder(plr);
                        sender.sendMessage(Main.prefix + ChatColor.YELLOW + "Du kannst auf diesem Server jetzt " + ChatColor.GREEN + "bauen" + ChatColor.YELLOW + ".");
                    }
                } else {
                    // Da der CommandSender kein Spieler ist, muss als Argument ein Spieler angegeben werden
                    // Es gibt also einen Fehler aus:
                    sender.sendMessage(
                            Main.prefix + ChatColor.RED + "Du musst ein Spieler sein um diesen Command auszuführen.\n" +
                            "Bitte benutze " + ChatColor.YELLOW + "/build [Spieler]" + ChatColor.RED + " um diesen Befehl in der Konsole auszuführen.");
                }
            } else if (args.length == 1) {
                // Wenn es ein Argument gibt, muss dieses ein Spieler sein
                if (Bukkit.getPlayer(args[0]) != null) { // Wenn das Argument ein Spieler ist
                    Player plr = Bukkit.getPlayer(args[0]);
                    if (Main.getBuilders().contains(plr)) { // Wenn der Spieler in der Liste ist
                        Main.removeBuilder(plr);
                        sender.sendMessage(Main.prefix + ChatColor.YELLOW + "Der Spieler " + ChatColor.GOLD + plr.getDisplayName() + ChatColor.YELLOW + " kann auf diesem Server jetzt " + ChatColor.RED + "nicht mehr bauen" + ChatColor.YELLOW + ".");
                        plr.sendMessage(Main.prefix + ChatColor.YELLOW + "Du kannst auf diesem Server jetzt " + ChatColor.RED + "nicht mehr bauen" + ChatColor.YELLOW + ".");
                    } else { // Wenn der Spieler nicht in der Liste ist
                        Main.addBuilder(plr);
                        sender.sendMessage(Main.prefix + ChatColor.YELLOW + "Der Spieler " + ChatColor.GOLD + plr.getDisplayName() + ChatColor.YELLOW + " kann auf diesem Server jetzt " + ChatColor.GREEN + "bauen" + ChatColor.YELLOW + ".");
                        plr.sendMessage(Main.prefix + ChatColor.YELLOW + "Du kannst auf diesem Server jetzt " + ChatColor.GREEN + "bauen" + ChatColor.YELLOW + ".");
                    }

                } else { // Wenn das Argument kein Spieler ist
                    sender.sendMessage(Main.prefix + ChatColor.DARK_RED + args[0] + ChatColor.RED + " ist kein gültiger Spieler.");
                }
            } else { // Wenn es mehr als ein Argument gibt
                sender.sendMessage(Main.prefix + ChatColor.RED + "Falsche Nutzung des Commands. Bitte nutze ihn so: /build [Spieler]");
            }
        }

        return true;
    }
}
