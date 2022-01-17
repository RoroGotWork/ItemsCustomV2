package fr.rorocraft.items.manager;

import fr.rorocraft.items.ItemsCustom;
import fr.rorocraft.items.items.*;
import fr.rorocraft.items.utils.Messages;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ItemsManager {
    private List<Item> items;
    private ItemsCustom plugin;

    public ItemsManager(ItemsCustom plugin) {
        items = new ArrayList<>();

        this.plugin = plugin;

        registerItems();
        registerItemsEvent();
    }

    public  Item getItemById(String id){
        for(Item item : items){
            if(item.getId().equalsIgnoreCase(id)){
                return  item;
            }
        }
        return null;
    }

    public void giveItemtoPlayer(Player player, String id, int number){
        Item item = getItemById(id);

        if(item != null){

            for (int i = 0; i < number; i ++){
                player.getInventory().addItem(item.getItem());
            }

            return;
        }

        player.sendMessage(Messages.ITEM_NOT_FOUND);

    }

    private void registerItems(){
        items.add(new EmeraldPlus());

        items.add(new SwitchBow());

        items.add(new GrappleLevelOne(plugin));
        items.add(new GrappleLevelTwo(plugin));
        items.add(new GrappleLevelThree(plugin));
    }

    private void registerItemsEvent(){
        plugin.getServer().getPluginManager().registerEvents(new SwitchBow(), plugin);

        plugin.getServer().getPluginManager().registerEvents(new GrappleLevelOne(plugin), plugin);
        plugin.getServer().getPluginManager().registerEvents(new GrappleLevelTwo(plugin), plugin);
        plugin.getServer().getPluginManager().registerEvents(new GrappleLevelThree(plugin), plugin);

    }
}
