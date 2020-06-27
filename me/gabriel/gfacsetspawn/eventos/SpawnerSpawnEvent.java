package me.gabriel.gfacsetspawn.eventos;

import org.bukkit.plugin.*;
import com.massivecraft.massivecore.ps.*;

import me.gabriel.gfacsetspawn.Main;
import me.gabriel.gfacsetspawn.manager.Manager_Mobs;

import org.bukkit.*;
import com.massivecraft.factions.entity.*;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class SpawnerSpawnEvent implements Listener
{
    private Main plugin;
    
    public SpawnerSpawnEvent(final Main plugin) {
        this.setPlugin(plugin);
        plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)plugin);
    }
    
	@EventHandler(ignoreCancelled = true)
    void onSpawnerSpawn(final org.bukkit.event.entity.SpawnerSpawnEvent event) {
        final Faction faction = BoardColl.get().getFactionAt(PS.valueOf(event.getLocation()));
        if (faction == null || faction.isNone()) {
            return;
        }
        final Manager_Mobs conta = this.getPlugin().getSpawnerControllerManager().getConta(faction.getName());
        if (conta == null || conta.getMobs() == null) {
            return;
        }
        if (!conta.getMobs().containsKey(event.getEntityType())) {
            return;
        }
        if (conta.getMobs().get(event.getEntityType()) == null) {
            return;
        }
        final Location location = conta.getMobs().get(event.getEntityType());
        if (location == null) {
        	return;
        }
        Bukkit.getScheduler().runTask((Plugin)this.getPlugin(), () -> event.getEntity().teleport(location));
    }
    
    public Main getPlugin() {
        return this.plugin;
    }
    
    public void setPlugin(final Main plugin) {
        this.plugin = plugin;
    }
}
