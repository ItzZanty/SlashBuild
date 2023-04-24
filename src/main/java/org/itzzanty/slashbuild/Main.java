package org.itzzanty.slashbuild;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Plugin initializing...");


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
