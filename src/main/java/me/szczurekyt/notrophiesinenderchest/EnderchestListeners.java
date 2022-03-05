package me.szczurekyt.notrophiesinenderchest;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.stream.Collectors;

public class EnderchestListeners implements Listener {

    private final NoTrophiesInEnderchest plugin;
    private final String message = ChatColor.RED + "You can't put rare, valuable items in enderchest.";

    public EnderchestListeners(NoTrophiesInEnderchest plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY) {
            if (!(event.getView().getTopInventory().getType() == InventoryType.ENDER_CHEST)) return;
            if (!(TrophyTag.isTagged(event.getCurrentItem().getType()))) return;
        }
        else {
            if (!(event.getClickedInventory().getType() == InventoryType.ENDER_CHEST)) return;

            if (event.getAction() == InventoryAction.HOTBAR_MOVE_AND_READD || event.getAction() == InventoryAction.HOTBAR_SWAP) {
                if (!(TrophyTag.isTagged(event.getWhoClicked().getInventory().getItem(event.getHotbarButton()).getType()))) return;
            }
            else {
                if (!( TrophyTag.isTagged(event.getWhoClicked().getItemOnCursor().getType() ))) return;
            }

        }

        new BukkitRunnable() {

            @Override
            public void run() {
                event.getView().close();
            }
        }.runTask(plugin);

        event.getWhoClicked().sendMessage(message);
        event.setCancelled(true);
    }

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent event) {
        if (!(event.getRawSlots().stream().filter(integer -> (integer > 26)).collect(Collectors.toList()).isEmpty())) return;
        if (!(event.getInventory().getType() == InventoryType.ENDER_CHEST)) return;
        if (!(TrophyTag.isTagged(event.getOldCursor().getType()))) return;

        new BukkitRunnable() {

            @Override
            public void run() {
                event.getView().close();
            }
        }.runTask(plugin);

        event.getWhoClicked().sendMessage(message);
        event.setCancelled(true);
    }

}
