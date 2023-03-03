package de.devsnx.simplecloudnpc;

import de.devsnx.simplecloudnpc.commands.NPCommand;
import de.devsnx.simplecloudnpc.file.NPCFile;
import de.devsnx.simplecloudnpc.listener.PlayerJoinListener;
import de.devsnx.simplecloudnpc.manager.NPCManager;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.units.qual.N;

public final class SimpleCloud_NPC extends JavaPlugin {

    public static SimpleCloud_NPC instance;
    public static NPCFile npcFile;
    public static NPCManager npcManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        npcFile = new NPCFile();
        npcManager = new NPCManager();
        getCommand("npc").setExecutor(new NPCommand());

        PluginManager load = Bukkit.getPluginManager();
        load.registerEvents(new PlayerJoinListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        instance = null;
    }

    public static SimpleCloud_NPC getInstance() {
        return instance;
    }

    public static NPCFile getNpcFile() {
        return npcFile;
    }

    public static NPCManager getNpcManager() {
        return npcManager;
    }

}
