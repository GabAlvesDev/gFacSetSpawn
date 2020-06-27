package me.gabriel.gfacsetspawn.eventos;

import org.bukkit.plugin.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.event.*;
import org.bukkit.event.inventory.InventoryType;

import com.massivecraft.factions.entity.*;

import me.gabriel.gfacsetspawn.Main;
import me.gabriel.gfacsetspawn.manager.Manager_Mobs;
import me.gabriel.gfacsetspawn.utils.Utils;

import org.bukkit.*;
import java.util.*;

public class InventoryClickEvent implements Listener
{
    private Main plugin;
    
    public InventoryClickEvent(final Main plugin) {
        plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)plugin);
        this.setPlugin(plugin);
    }
    
    @EventHandler(ignoreCancelled = true)
    void onClickInventory(final org.bukkit.event.inventory.InventoryClickEvent event) {
        if (event.getWhoClicked().getType() == EntityType.PLAYER && event.getSlotType() == InventoryType.SlotType.CONTAINER) {
            final Inventory clickedInventory = event.getClickedInventory();
            final Player player = (Player) event.getWhoClicked();
            if (clickedInventory != null && clickedInventory.getName().endsWith(" - Setar spawner spawn§f")) {
                event.setCancelled(true);
                event.setResult(Event.Result.DENY);
                final MPlayer value = MPlayer.get((Object)player);
                if (!value.hasFaction()) {
                    player.closeInventory();
                }
                if (this.getPlugin().getSpawnerControllerManager().getConta(value.getFactionName()) == null) {
                    player.closeInventory();
                }
                switch (event.getSlot()) {
                    case 10: {
                        this.setSpawnSpawner(player, value.getFaction(), EntityType.COW);
                        break;
                    }
                    case 11: {
                        this.setSpawnSpawner(player, value.getFaction(), EntityType.SPIDER);
                        break;
                    }
                    case 12: {
                        this.setSpawnSpawner(player, value.getFaction(), EntityType.ZOMBIE);
                        break;
                    }
                    case 13: {
                        this.setSpawnSpawner(player, value.getFaction(), EntityType.SKELETON);
                        break;
                    }
                    case 14: {
                        this.setSpawnSpawner(player, value.getFaction(), EntityType.BLAZE);
                        break;
                    }
                    case 15: {
                        this.setSpawnSpawner(player, value.getFaction(), EntityType.PIG_ZOMBIE);
                        break;
                    }
                    case 16: {
                        this.setSpawnSpawner(player, value.getFaction(), EntityType.IRON_GOLEM);
                        break;
                    }
                    case 19: {
                        this.setSpawnSpawner(player, value.getFaction(), EntityType.MAGMA_CUBE);
                        break;
                    }
                }
            }
        }
    }
    
    private void setSpawnSpawner(final Player player, final Faction faction, final EntityType entityType) {
        boolean b = false;
        final Manager_Mobs conta = this.getPlugin().getSpawnerControllerManager().getConta(faction.getName());
        if (conta == null) {
            player.closeInventory();
        }
        try {
            conta.getMobs().put(entityType, player.getLocation());
            String string = "";
            for (final Map.Entry<EntityType, Location> entry : conta.getMobs().entrySet()) {
                string = String.valueOf(String.valueOf(string)) + "{" + entry.getKey() + "=" + Utils.locationSerializer(entry.getValue()) + "}";
            }
            this.getPlugin().getManager().setarMobs(faction.getName(), string);
            b = true;
        }
        catch (NullPointerException ex) {}
        if (b) {
            Utils.sendAction(player, this.getPlugin().getConfig().getString("Mensagens.action-bar").replace("&", "§"));
            player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1.0f, 1.0f);
        }
        player.closeInventory();
    }
    
    public Main getPlugin() {
        return this.plugin;
    }
    
    public void setPlugin(final Main plugin) {
        this.plugin = plugin;
    }
}
