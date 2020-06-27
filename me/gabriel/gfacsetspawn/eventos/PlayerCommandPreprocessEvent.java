package me.gabriel.gfacsetspawn.eventos;

import org.bukkit.plugin.*;
import com.massivecraft.factions.*;
import com.massivecraft.massivecore.ps.*;

import me.gabriel.gfacsetspawn.Main;
import me.gabriel.gfacsetspawn.manager.Manager_Mobs;
import me.gabriel.gfacsetspawn.utils.EntityUtils;
import me.gabriel.gfacsetspawn.utils.ItemBuilder;

import org.bukkit.entity.*;
import com.massivecraft.factions.entity.*;
import org.bukkit.event.*;
import java.util.*;
import org.bukkit.*;
import org.bukkit.inventory.*;

public class PlayerCommandPreprocessEvent implements Listener
{
    private Main plugin;
    
    public PlayerCommandPreprocessEvent(final Main plugin) {
        plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)plugin);
        this.setPlugin(plugin);
    }
    
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    void onCommand(final org.bukkit.event.player.PlayerCommandPreprocessEvent event) {
        final Player player = event.getPlayer();
        if (event.getMessage().equalsIgnoreCase("/f setspawner") || event.getMessage().equalsIgnoreCase("/f setspawn")) {
            event.setCancelled(true);
            final MPlayer value = MPlayer.get(player);
            if (!value.hasFaction()) {
                player.sendMessage(this.getPlugin().getConfig().getString("Mensagens.sem-fac").replace("&", "§"));
                return;
            }
            if (value.getRole() != Rel.LEADER && value.getRole() != Rel.OFFICER) {
                player.sendMessage(this.getPlugin().getConfig().getString("Mensagens.sem-cargo").replace("&", "§"));
                return;
            }
            final Faction faction = BoardColl.get().getFactionAt(PS.valueOf(player.getLocation()));
            if (faction == null || faction != value.getFaction()) {
                player.sendMessage(this.plugin.getConfig().getString("Mensagens.precisa-estar-claim"));
                return;
            }
            if (this.hasOpenSpawnerSetGui(player, value.getFaction())) {
                player.sendMessage(this.getPlugin().getConfig().getString("Mensagens.ja-acessando-menu").replace("&", "§"));
                return;
            }
            if (this.getPlugin().getSpawnerControllerManager().getConta(value.getFactionName()) == null) {
                this.getPlugin().getManager().criarConta(value.getFactionName());
                this.getPlugin().getSpawnerControllerManager().criarConta(new Manager_Mobs(value.getFactionName(), new HashMap<EntityType, Location>()));
            }
            player.openInventory(this.getInventory(value.getFaction().getTag()));
        }
    }
    
    public boolean hasOpenSpawnerSetGui(final Player player, final Faction faction) {
        for (final Player player2 : faction.getOnlinePlayers()) {
            if (player2 != null && !player.equals(player2) && player2.getOpenInventory() != null && player2.getOpenInventory().getTitle().endsWith("Setar spawner spawn§f§f")) {
                return true;
            }
        }
        return false;
    }
    
    protected ItemStack itemFromEntity(final EntityType entityType) {
        final String translate = EntityUtils.translate(entityType);
        return new ItemBuilder(EntityUtils.headItem(entityType)).removeAttributes().name(ChatColor.WHITE + translate).lore("§7Clique para setar o spawn", "§7dos spawners de §f" + translate + "§7.").build();
    }
    
    public Inventory getInventory(final String s) {
        final Inventory inventory = Bukkit.createInventory((InventoryHolder)null, 36, s + " - Setar spawner spawn§f");
        inventory.setItem(10, this.itemFromEntity(EntityType.COW));
        inventory.setItem(11, this.itemFromEntity(EntityType.SPIDER));
        inventory.setItem(12, this.itemFromEntity(EntityType.ZOMBIE));
        inventory.setItem(13, this.itemFromEntity(EntityType.SKELETON));
        inventory.setItem(14, this.itemFromEntity(EntityType.BLAZE));
        inventory.setItem(15, this.itemFromEntity(EntityType.PIG_ZOMBIE));
        inventory.setItem(16, this.itemFromEntity(EntityType.IRON_GOLEM));
        inventory.setItem(19, this.itemFromEntity(EntityType.MAGMA_CUBE));
        return inventory;
    }
    
    public Main getPlugin() {
        return this.plugin;
    }
    
    public void setPlugin(final Main plugin) {
        this.plugin = plugin;
    }
}
