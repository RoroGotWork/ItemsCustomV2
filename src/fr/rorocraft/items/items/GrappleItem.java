package fr.rorocraft.items.items;

import fr.rorocraft.items.ItemsCustom;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;


public abstract class GrappleItem extends Item implements Listener {
    protected long cooldown;
    protected List<Player> playersInCooldown;
    protected ItemsCustom plugin;


    public GrappleItem(String id, String name, List<String> lore, Material type, int level, long cooldown, ItemsCustom plugin)  {
        super(id, name, lore, type);

        this.cooldown = cooldown;
        this.playersInCooldown = new ArrayList<>();
        this.plugin = plugin;
    }

    @Override
    public abstract ItemStack getItem();

    @Override
    public abstract String getName();

    @Override
    public abstract String getId();

    public abstract long getCooldown();

    public abstract void addPlayerCooldown(Player player);

    public abstract void removePlayerCooldown(Player player);

    public abstract boolean isInCooldown(Player player);

    @EventHandler
    public abstract void onFish(PlayerFishEvent e);
}
