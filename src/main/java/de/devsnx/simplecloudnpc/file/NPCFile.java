package de.devsnx.simplecloudnpc.file;

import de.devsnx.simplecloudnpc.utils.FileBase;
import dev.sergiferry.playernpc.api.NPC;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

/**
 * @author DevSnx
 * @since 03.03.2023
 */
public class NPCFile extends FileBase {

    public NPCFile() {
        super("", "npc");
    }

    public void saveNPC(String NPC, Location loc, String serviceGroup) {

        FileConfiguration cfg = getConfig();

        cfg.set("NPC." + NPC + ".SERVERGROUP", serviceGroup);
        cfg.set("NPC." + NPC + ".SKIN.TERXTURE", "ewogICJ0aW1lc3RhbXAiIDogMTYwMjUxNjAyODgyMSwKICAicHJvZmlsZUlkIiA6ICJlNzkzYjJjYTdhMmY0MTI2YTA5ODA5MmQ3Yzk5NDE3YiIsCiAgInByb2ZpbGVOYW1lIiA6ICJUaGVfSG9zdGVyX01hbiIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9hMWE2ODE2ZTg3ZTEwNjE3MGU0YmMwODNkY2IzMDFjZjc4MGJjZjRhNGQ4ZmZmYzkwNTIyMmQ4YmNkYzI5ZjdmIgogICAgfQogIH0KfQ==");
        cfg.set("NPC." + NPC + ".SKIN.SIGNATURE", "cYlih9oP64vrnPMqXDWp2Y/6WlO196XKVy9qrVgNF4dlpXmKPrJa9lRRwIZc4Ma2HobXM9uT6gW/NUyKS7FOQEycVUZlUvVvemwiQZmSgCTJNFh1UW9rxUt6g4l+5qF/V0n49e6rN2sgtrV1LwLLS7pdAHpm8LtlwgFFTvVzCq+poiXrZwzPZxVLrZxGCMZeN4VsqzNN99em2taPFXPiI/fLp0e2FG1n84029HgsKfUcubrkHvSYPZK9AoIPygDqLm/tRkBYSlgMvZ82UlNm4D22pwAv33Z7VLLd6mpAek9f+InhrGVjZreA2aZYRT6elnt4AfJn2GKDv0d3HEWqBtK06RRSZxlLJeHoCCxqwnM1NcplVFn7uKywmK9my/35L5tn3A5PSYu+EvHjd/Q+vgGzx/auAo3qqDvajm8tWIf41OmAYWpQMega4rGvzUT2uxtgSJO9e4xnthdXsHUSTQ4UBoe0DemQHcxVbvtHV5q4kzfRxr8+1+DAtpeX4UZmHwi4eIwNGH7oUrZzjIepICNv9NeCVWej+GGvNKI2UXYh+9Q8gjOJqMr+QoIBA1bXUkMev2jqiUF0BGPJZMj7lNRYnDYEGKfT1PDeQK3LqEqQdaRpaOXEZXW/qZLU2C2SL9hL0fNcvwyMCBDC7HPYYcbvzX9pyaPfS5a76NpFuDg=");
        cfg.set("NPC." + NPC + ".GLOWING", false);
        cfg.set("NPC." + NPC + ".GLOWINGCOLOR", dev.sergiferry.playernpc.api.NPC.Color.RED.toString());
        cfg.set("NPC." + NPC + ".SHOWINGPLAYER", true);
        cfg.set("NPC." + NPC + ".WORLD", loc.getWorld().getName());
        cfg.set("NPC." + NPC + ".X", Double.valueOf(loc.getX()));
        cfg.set("NPC." + NPC + ".Y", Double.valueOf(loc.getY()));
        cfg.set("NPC." + NPC + ".Z", Double.valueOf(loc.getZ()));
        cfg.set("NPC." + NPC + ".YAW", Double.valueOf(loc.getYaw()));
        cfg.set("NPC." + NPC + ".PITCH", Double.valueOf(loc.getPitch()));

        saveConfig();

        Bukkit.getServer().broadcastMessage("§aNPC §b" + NPC + " §aerstellt!" );

    }

    public void removeNPC(String NPC){
        FileConfiguration cfg = getConfig();
        if(cfg.getString("NPC." + NPC) != null){
            cfg.set("NPC." + NPC, null);
            saveConfig();
            Bukkit.getServer().broadcastMessage("§aNPC §b" + NPC + " §centfernt!" );
        }else{
            Bukkit.getServer().broadcastMessage("§aNPC §b" + NPC + " §cgibt es nicht!" );
        }
    }

    public String getNPCSkin(String NPC){
        FileConfiguration cfg = getConfig();
        if (cfg.getString("NPC." + NPC) != null) {

            return cfg.getString("NPC." + NPC + ".SKIN");

        }else{
            return null;
        }
    }


    public void setNPCSkin(String NPC, String Skin){
        FileConfiguration cfg = getConfig();

        if (cfg.getString("NPC." + NPC) != null) {

            cfg.set("NPC." + NPC + ".SKIN", String.valueOf(Skin));

            saveConfig();

        }
    }

    /*public ICloudServiceGroup getEntityCloudGroup(String Entity){
        FileConfiguration cfg = getConfig();
        if (cfg.getString("NPC." + Entity) != null) {

            if(CloudAPI.getInstance().getCloudServiceGroupManager().getServiceGroupByName(cfg.getString("ENTITY." + Entity + ".SERVERGROUP")) != null){

                ICloudServiceGroup serviceGroup = CloudAPI.getInstance().getCloudServiceGroupManager().getServiceGroupByName(cfg.getString("ENTITY." + Entity + ".SERVERGROUP"));

                return serviceGroup;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }*/

    public Location getNPCLocation(String NPC) {

        FileConfiguration cfg = getConfig();

        if (cfg.getString("NPC." + NPC) != null) {
            String world = cfg.getString("NPC." + NPC + ".WORLD");
            double x = cfg.getDouble("NPC." + NPC + ".X");
            double y = cfg.getDouble("NPC." + NPC + ".Y");
            double z = cfg.getDouble("NPC." + NPC + ".Z");
            float yaw = (float) cfg.getDouble("NPC." + NPC + ".YAW");
            float pitch = (float) cfg.getDouble("NPC." + NPC + ".PITCH");
            Location loc = new Location(Bukkit.getWorld(world), x, y, z);
            loc.setPitch(pitch);
            loc.setYaw(yaw);

            return loc;

        } else {

            return null;

        }

    }

}