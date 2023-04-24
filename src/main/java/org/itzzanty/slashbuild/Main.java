package org.itzzanty.slashbuild;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.itzzanty.slashbuild.commands.BuildCommand;
import org.itzzanty.slashbuild.listeners.BuildListener;

import java.util.ArrayList;

public final class Main extends JavaPlugin {

    // Erstellen einer Prefix für das Plugin
    public static final String prefix = "§8[§eSlash§6Build§8] §r";

    // Erstellen einer ArrayList, in welcher alle Spieler enthalten sind, die gerade die Welt modifizieren dürfen
    private static ArrayList<Player> builders = new ArrayList<>();


    // Getter-Methode für die ArrayList
    public static ArrayList<Player> getBuilders() {
        return builders;
    }

    // Spieler zur ArrayList hinzufügen
    public static void addBuilder(Player plr) {
        if (!(builders.contains(plr))) { // if-Abfrage um zu schauen, ob der Spieler noch nicht in der ArrayList enthalten ist
            builders.add(plr);
        }
    }

    // Spieler aus der ArrayList entfernen
    public static void removeBuilder(Player plr) {
        if (builders.contains(plr)) { // if-Abfrage um zu schauen, ob der Spieler momentan in der ArrayList enthalten ist
            builders.remove(plr);
        }
    }

    @Override
    public void onEnable() {
        // Code der bei Start des Plugins abgerufen wird

        getServer().getConsoleSender().sendMessage(prefix + ChatColor.GREEN + "Plugin startet..."); // In der Konsole ausgeben, dass das Plugin startet


        // Commands
        getCommand("build").setExecutor(new BuildCommand());

        // Listeners
        getServer().getPluginManager().registerEvents(new BuildListener(), this);

    }

}
