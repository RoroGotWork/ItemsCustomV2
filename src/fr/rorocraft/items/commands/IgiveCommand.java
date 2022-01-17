package fr.rorocraft.items.commands;

import fr.rorocraft.items.ItemsCustom;
import fr.rorocraft.items.items.EmeraldPlus;
import fr.rorocraft.items.items.Item;
import fr.rorocraft.items.utils.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class IgiveCommand implements CommandExecutor {

    private  ItemsCustom plugin;

    public IgiveCommand(ItemsCustom plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if(args.length < 1) {
            commandSender.sendMessage(Messages.WRONG_COMMAND);
            return true;
        }

        String itemID = args[0];
        int number;

        if (args.length == 1) {
            if(commandSender instanceof Player) {
                Player player = (Player) commandSender;

                plugin.getItemsManager().giveItemtoPlayer(player, itemID,  1);

            } else {
                commandSender.sendMessage(Messages.WRONG_COMMAND);
            }


        } else if(args.length == 2){

            try {
                number = Integer.parseInt(args[1]);
            } catch (NumberFormatException e){
                commandSender.sendMessage(Messages.WRONG_COMMAND);
                return true;
            }

            if(commandSender instanceof Player) {
                Player player = (Player) commandSender;

                plugin.getItemsManager().giveItemtoPlayer(player, itemID,  number);

            } else {
                commandSender.sendMessage(Messages.WRONG_COMMAND);
            }

            return true;

        } else  if (args.length >= 3) {

            try {
                number = Integer.parseInt(args[1]);
            } catch (NumberFormatException e){
                commandSender.sendMessage(Messages.WRONG_COMMAND);
                return true;
            }

            Player target = Bukkit.getPlayer(args[2]);

            if(target == null){
                commandSender.sendMessage(Messages.PLAYER_NOT_FOUND);
                return true;
            }

            plugin.getItemsManager().giveItemtoPlayer(target, itemID,  number);

        }

        return false;
    }
}
