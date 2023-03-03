package de.devsnx.simplecloudnpc.listener;

import de.devsnx.simplecloudnpc.SimpleCloud_NPC;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * @author DevSnx
 * @since 03.03.2023
 */
public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){

        SimpleCloud_NPC.getNpcManager().loadNPCS(event.getPlayer());

    }
}
