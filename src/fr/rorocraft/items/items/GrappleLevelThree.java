package fr.rorocraft.items.items;

import fr.rorocraft.items.ItemsCustom;
import fr.rorocraft.items.utils.Messages;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class GrappleLevelThree extends GrappleItem{


    public GrappleLevelThree(ItemsCustom plugin) {
        super("grapple_level_three", "" + ChatColor.BOLD + ChatColor.GREEN + "Grappin de niveau 3", null, Material.FISHING_ROD, 3, 5, plugin);
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

    @Override
    public long getCooldown() {
        return cooldown;
    }

    @Override
    public void addPlayerCooldown(Player player) {
        if( isInCooldown(player) ) return;

        playersInCooldown.add(player);

        new BukkitRunnable(){

            @Override
            public void run(){
                removePlayerCooldown(player);
            }
        }.runTaskLater(plugin, getCooldown() * 20);

    }

    @Override
    public void removePlayerCooldown(Player player) {
        if(!(isInCooldown(player))) return;

        playersInCooldown.remove(player);
    }

    @Override
    public boolean isInCooldown(Player player) {
        return playersInCooldown.contains(player);
    }

    @EventHandler
    @Override
    public void onFish(PlayerFishEvent e) {
        Player player = e.getPlayer();
        ItemStack itemHand = player.getInventory().getItemInMainHand();

        if(e.getState() != PlayerFishEvent.State.IN_GROUND) return;


        if(!(itemHand.hasItemMeta())) return;
        if(!(itemHand.getItemMeta().hasDisplayName())) return;
        if(!(itemHand.getItemMeta().getDisplayName().equals(this.getName()))) return;

        if(this.isInCooldown(player)){
            player.sendMessage(Messages.ITEM_GRAPPLE_COOLDOWN);
            return;
        }

        this.addPlayerCooldown(player);

        Location playerLoc = player.getLocation();

        Location hookLoc = e.getHook().getLocation();

        Location change = hookLoc.subtract(playerLoc);

        player.setVelocity(change.toVector().multiply(0.29));

    }
}
