package me.gabriel.gfacsetspawn;

import org.bukkit.plugin.java.JavaPlugin;

import me.gabriel.gfacsetspawn.eventos.InventoryClickEvent;
import me.gabriel.gfacsetspawn.eventos.PlayerCommandPreprocessEvent;
import me.gabriel.gfacsetspawn.eventos.SpawnerSpawnEvent;
import me.gabriel.gfacsetspawn.manager.Manager_Conta;
import me.gabriel.gfacsetspawn.mysql.DB;
import me.gabriel.gfacsetspawn.mysql.MySQL;

public class Main extends JavaPlugin{

    private MySQL m;
    private DB manager;
    private Manager_Conta spawnerControllerManager;
    private static Main main;
    

    public void onEnable() {
    	enablePlugin();
    }
    
    private void enablePlugin() {
    	main = this;
    	loadConfig();
    	loadMySQL();
        this.setSpawnerControllerManager(new Manager_Conta(this));
        this.setManager(new DB(this));
        loadFacções();
        loadListners();
    }
    
    private void loadFacções() {
        this.getSpawnerControllerManager().loadContas();
    }
   
    private void loadListners() {
        new InventoryClickEvent(this);
        new SpawnerSpawnEvent(this);
        new PlayerCommandPreprocessEvent(this);
    }
    
    private void loadConfig() {
        this.saveDefaultConfig();
    }
    
    private void loadMySQL() {
        this.setM(new MySQL(this));
        this.getM().open();
        this.getM().createTable();
    }

    public static Main get() {
        return main;
    }

    public MySQL getM() {
        return this.m;
    }
    
    public void setM(final MySQL m) {
        this.m = m;
    }
    
    public DB getManager() {
        return this.manager;
    }
    
    public void setManager(final DB manager) {
        this.manager = manager;
    }
    
    public Manager_Conta getSpawnerControllerManager() {
        return this.spawnerControllerManager;
    }
    
    public void setSpawnerControllerManager(final Manager_Conta spawnerControllerManager) {
        this.spawnerControllerManager = spawnerControllerManager;
    }

}
