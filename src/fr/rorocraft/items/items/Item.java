package fr.rorocraft.items.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public abstract class Item{
    protected String id;
    protected String name;
    protected ItemStack item;



    public Item(String id , String name, List<String> lore, Material type) {
        this.id = id;
        this.name = name;

        ItemStack item  = new ItemStack(type);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(name);
        itemMeta.setLore(lore);
        itemMeta.addEnchant(Enchantment.SILK_TOUCH, 1, false);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(itemMeta);
        this.item = item;

    }

    public abstract ItemStack getItem();

    public abstract String getName();

    public abstract String getId();


}
