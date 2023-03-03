package de.devsnx.simplecloudnpc.file;

import de.devsnx.simplecloudnpc.utils.FileBase;
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

    public void saveNPC(String NPC, Location loc, String serviceGroup ,String SKIN) {

        FileConfiguration cfg = getConfig();

        cfg.set("NPC." + NPC + ".SERVERGROUP", serviceGroup);
        cfg.set("NPC." + NPC + ".SKIN", SKIN);
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