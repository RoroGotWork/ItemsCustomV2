package fr.rorocraft.items.items;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public abstract class BowItem extends Item implements Listener {
    protected int damage;

    public BowItem(String id, String name, List<String> lore, Material type, int damage) {
        super(id, name, lore, type);

        this.damage = damage;
    }

    @Override
    public abstract String getName();

    @Override
    public abstract String getId();

    @Override
    public abstract ItemStack getItem();

    public abstract double getDamage();

    @EventHandler
    public abstract void onProjectileHit(ProjectileHitEvent e);

    @EventHandler
    public abstract void onDamage(EntityDamageByEntityEvent e);


}
