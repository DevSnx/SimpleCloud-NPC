package de.devsnx.simplecloudnpc.manager;

import de.devsnx.simplecloudnpc.SimpleCloud_NPC;
import dev.sergiferry.playernpc.api.NPC;
import dev.sergiferry.playernpc.api.NPCLib;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Set;

/**
 * @author DevSnx
 * @since 03.03.2023
 */
public class NPCManager {

    public NPCManager(){
        NPCLib.getInstance().registerPlugin(SimpleCloud_NPC.getInstance());
    }

    public void loadNPCS(Player player){

        FileConfiguration cfg = SimpleCloud_NPC.getNpcFile().getConfig();
        ConfigurationSection config = cfg.getConfigurationSection("NPC.");
        Set<String> set = config.getKeys(false);

        int i = 0;

        for (String name : set) {

            NPC.Personal npc = NPCLib.getInstance().generatePersonalNPC(player ,SimpleCloud_NPC.getInstance(), name, SimpleCloud_NPC.getNpcFile().getNPCLocation(name));

            npc.setText(cfg.getString("NPC." + name + ".NAME").replace("&", "§"));

            npc.setSkin(cfg.getString("NPC." + name + ".SKIN.TERXTURE"), cfg.getString("NPC." + name + ".SKIN.SIGNATURE"));

            if(cfg.getBoolean("NPC." + name + ".GLOWING.SHOW") == true){
                npc.setGlowing(true, NPC.Color.valueOf(cfg.getString("NPC." + name + ".GLOWING.COLOR")));
            }

            if(cfg.getBoolean("NPC." + name + ".SHOWINGPLAYER") == true){
                npc.setGazeTrackingType(NPC.GazeTrackingType.PLAYER);
            }

            npc.create();
            npc.show();

            i++;
        }
        player.sendMessage("§cEs wurden §b" + i + " §cNpcs geladen!");
    }

    public void createNPC(String name, Location location, String serciveGroup){

        SimpleCloud_NPC.getNpcFile().saveNPC(name, location, serciveGroup);

    }

    public void removeNPC(String name){

        SimpleCloud_NPC.getNpcFile().removeNPC(name);

    }
}
