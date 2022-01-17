package fr.rorocraft.items;

import fr.rorocraft.items.commands.IgiveCommand;
import fr.rorocraft.items.manager.ItemsManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ItemsCustom extends JavaPlugin {

    private ItemsManager itemsManager;

    @Override
    public void onEnable() {
        super.onEnable();

        this.itemsManager = new ItemsManager(this);

        registerCommands();


        System.out.println("#######################");
        System.out.println("#    ItemsCustomV2    #");
        System.out.println("#       By Roro       #");
        System.out.println("#######################");

    }


    private void registerCommands(){
        this.getCommand("igive").setExecutor(new IgiveCommand(this));
    }

    public ItemsManager getItemsManager(){return itemsManager;}

}
