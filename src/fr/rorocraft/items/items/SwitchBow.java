package fr.rorocraft.items.items;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.Objects;

public class SwitchBow extends BowItem  {
    public SwitchBow() {
        super("switch_bow", ChatColor.RED + "Switch Bow", null, Material.BOW, 3);
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
    public ItemStack getItem() {
        return item;
    }

    @Override
    public double getDamage() {
        return damage;
    }


    @EventHandler
    @Override
    public void onProjectileHit(ProjectileHitEvent e) throws NullPointerException{
        Entity victim = e.getHitEntity();

        if(victim == null) return;

        Projectile projectile = e.getEntity();

        if(!(projectile.getShooter() instanceof Player)) return;
        Player player = (Player) projectile.getShooter();

        PlayerInventory inv = player.getInventory();



        if (Objects.requireNonNull(inv.getItemInMainHand().getItemMeta()).getDisplayName().equalsIgnoreCase(this.getName())
        || Objects.requireNonNull(inv.getItemInOffHand().getItemMeta()).getDisplayName().equals(this.getName())) {

            Location playerLocation = player.getLocation();
            player.teleport(victim.getLocation());
            victim.teleport(playerLocation);
        }
    }

    @EventHandler
    @Override
    public void onDamage(EntityDamageByEntityEvent e) {
        if(!(e.getDamager() instanceof Projectile)) return;

        Projectile projectile =  (Projectile) e.getDamager();

        if(!(projectile.getShooter() instanceof Player)) return;

        Player player = (Player) projectile.getShooter();

        PlayerInventory inv = player.getInventory();

        if (Objects.requireNonNull(inv.getItemInMainHand().getItemMeta()).getDisplayName().equalsIgnoreCase(this.getName())
                || Objects.requireNonNull(inv.getItemInOffHand().getItemMeta()).getDisplayName().equals(this.getName())) {

            e.setDamage(this.getDamage());
        }

    }
}
