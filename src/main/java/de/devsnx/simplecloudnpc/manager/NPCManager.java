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
            npc.setText("§b" + name);
            npc.setSkin("ewogICJ0aW1lc3RhbXAiIDogMTYwMjUxNjAyODgyMSwKICAicHJvZmlsZUlkIiA6ICJlNzkzYjJjYTdhMmY0MTI2YTA5ODA5MmQ3Yzk5NDE3YiIsCiAgInByb2ZpbGVOYW1lIiA6ICJUaGVfSG9zdGVyX01hbiIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9hMWE2ODE2ZTg3ZTEwNjE3MGU0YmMwODNkY2IzMDFjZjc4MGJjZjRhNGQ4ZmZmYzkwNTIyMmQ4YmNkYzI5ZjdmIgogICAgfQogIH0KfQ==",
                    "cYlih9oP64vrnPMqXDWp2Y/6WlO196XKVy9qrVgNF4dlpXmKPrJa9lRRwIZc4Ma2HobXM9uT6gW/NUyKS7FOQEycVUZlUvVvemwiQZmSgCTJNFh1UW9rxUt6g4l+5qF/V0n49e6rN2sgtrV1LwLLS7pdAHpm8LtlwgFFTvVzCq+poiXrZwzPZxVLrZxGCMZeN4VsqzNN99em2taPFXPiI/fLp0e2FG1n84029HgsKfUcubrkHvSYPZK9AoIPygDqLm/tRkBYSlgMvZ82UlNm4D22pwAv33Z7VLLd6mpAek9f+InhrGVjZreA2aZYRT6elnt4AfJn2GKDv0d3HEWqBtK06RRSZxlLJeHoCCxqwnM1NcplVFn7uKywmK9my/35L5tn3A5PSYu+EvHjd/Q+vgGzx/auAo3qqDvajm8tWIf41OmAYWpQMega4rGvzUT2uxtgSJO9e4xnthdXsHUSTQ4UBoe0DemQHcxVbvtHV5q4kzfRxr8+1+DAtpeX4UZmHwi4eIwNGH7oUrZzjIepICNv9NeCVWej+GGvNKI2UXYh+9Q8gjOJqMr+QoIBA1bXUkMev2jqiUF0BGPJZMj7lNRYnDYEGKfT1PDeQK3LqEqQdaRpaOXEZXW/qZLU2C2SL9hL0fNcvwyMCBDC7HPYYcbvzX9pyaPfS5a76NpFuDg=");
            npc.setShowOnTabList(false);

            npc.setItemInMainHand(new ItemStack(Material.GRASS_BLOCK));

            npc.setGazeTrackingType(NPC.GazeTrackingType.PLAYER);

            //
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
