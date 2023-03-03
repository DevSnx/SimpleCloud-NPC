package de.devsnx.simplecloudnpc.commands;

import de.devsnx.simplecloudnpc.SimpleCloud_NPC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author DevSnx
 * @since 03.03.2023
 */
public class NPCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){
            return true;
        }

        Player player = (Player) sender;

        if(args.length == 0 || args.length > 3){

            sendHelp(player);

            return true;
        }

        if(args[0].equalsIgnoreCase("create")){
            if(!(args.length == 3)){
                player.sendMessage("§cnutze §e/npc create <name> <serviceGroup>");
                return true;
            }
            String name = args[1];
            String service = args[2];
            SimpleCloud_NPC.getNpcManager().createNPC(name, player.getLocation(), service ,"");
            return true;
        }

        if(args[0].equalsIgnoreCase("remove")){
            if(!(args.length == 2)){
                player.sendMessage("§cnutze §e/npc remove <name>");
                return true;
            }
            String name = args[1];
            SimpleCloud_NPC.getNpcManager().removeNPC(name);
            player.sendMessage("§bNPC §e" + name + " §bwurde gelöscht.");
            return true;
        }
        return false;
    }

    private void sendHelp(Player player){

        player.sendMessage("§7----------------------------");
        player.sendMessage(" §b/npc create <Name> <serviceGroup>");
        player.sendMessage(" §b/npc remove <Name>");
        player.sendMessage("§7----------------------------");

    }
}