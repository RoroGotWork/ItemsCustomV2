package fr.rorocraft.items.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import java.util.Arrays;


public class EmeraldPlus extends Item{

    public EmeraldPlus() {

        super("emeraude_plus",ChatColor.DARK_GREEN + "Emeraude +", Arrays.asList(""), Material.EMERALD);
    }

    @Override
    public ItemStack getItem() {
        return item;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return id;
    }


}
