package fr.rorocraft.items.utils;

import org.bukkit.ChatColor;

public class Messages {
    private static final String PREFIX =  ChatColor.RED + "[OneSky] ";


    public static final String ITEM_NOT_FOUND = PREFIX + "L'item est introuvable";
    public static final String WRONG_COMMAND = PREFIX +  "Faites la commande /igive [id] {nombre} {joueur}";
    public static final String PLAYER_NOT_FOUND = PREFIX + "LE joueur n'est pas en ligne ou n'existe pas";

    public static final String ITEM_GRAPPLE_COOLDOWN = PREFIX + "Tu ne peux pas encore utiliser ce grappin";
}
