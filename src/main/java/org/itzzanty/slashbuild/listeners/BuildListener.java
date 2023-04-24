package org.itzzanty.slashbuild.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.itzzanty.slashbuild.Main;

public class BuildListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) { // Wird ausgeführt, wenn ein Spieler einen Block zerstört
        Player plr = event.getPlayer(); // Der Spieler, der den Block versucht hat zu zerstören
        if (!(Main.getBuilders().contains(plr))) { // Wenn der Spieler nicht in der ArrayList ist
            event.setCancelled(true); // Event abbrechen (Der Block wird nicht zerstört)
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) { // Wird ausgeführt, wenn ein Spieler einen Block baut
        Player plr = event.getPlayer(); // Der Spieler, der den Block versucht hat zu bauen
        if (!(Main.getBuilders().contains(plr))) { // Wenn der Spieler nicht in der ArrayList ist
            event.setCancelled(true); // Event abbrechen (Der Block wird nicht gebaut)
        }
    }

}
