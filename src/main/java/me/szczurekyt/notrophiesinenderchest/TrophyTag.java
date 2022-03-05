package me.szczurekyt.notrophiesinenderchest;

import org.bukkit.Material;

public class TrophyTag {

    public static boolean isTagged(Material material) {
        return  (material == Material.DRAGON_EGG ||
                material == Material.DRAGON_HEAD ||
                material == Material.BEDROCK ||
                material == Material.BARRIER ||
                material == Material.SKELETON_SKULL ||
                material == Material.ZOMBIE_HEAD ||
                material == Material.CREEPER_HEAD ||
                material == Material.ENCHANTED_GOLDEN_APPLE ||
                material == Material.NETHER_STAR ||
                material == Material.BEACON ||
                material == Material.MUSIC_DISC_WARD ||
                material == Material.MUSIC_DISC_STRAD ||
                material == Material.MUSIC_DISC_WAIT ||
                material == Material.MUSIC_DISC_STAL ||
                material == Material.MUSIC_DISC_PIGSTEP ||
                material == Material.MUSIC_DISC_OTHERSIDE ||
                material == Material.MUSIC_DISC_MELLOHI ||
                material == Material.MUSIC_DISC_MALL ||
                material == Material.MUSIC_DISC_FAR ||
                material == Material.MUSIC_DISC_CHIRP ||
                material == Material.MUSIC_DISC_CAT ||
                material == Material.MUSIC_DISC_BLOCKS ||
                material == Material.MUSIC_DISC_13 ||
                material == Material.MUSIC_DISC_11);
    }
}
