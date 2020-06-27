package me.gabriel.gfacsetspawn.mysql;

import org.bukkit.plugin.*;

import me.gabriel.gfacsetspawn.Main;

import java.sql.*;

import org.bukkit.Bukkit;
import org.bukkit.configuration.*;

public class MySQL
{
    private Main plugin;
    public Connection con;
    
    public MySQL(final Main plugin) {
        this.setPlugin(plugin);
    }
    
    public void open() {
        final String string = "jdbc:mysql://" + ((MemorySection)this.getPlugin().getConfig()).getString("MySQL.Host") + ":" + ((MemorySection)this.getPlugin().getConfig()).getString("MySQL.Porta") + "/" + ((MemorySection)this.getPlugin().getConfig()).getString("MySQL.Database");
        final String string2 = new StringBuilder().append(((MemorySection)this.getPlugin().getConfig()).getString("MySQL.Usuario")).toString();
        final String string3 = new StringBuilder().append(((MemorySection)this.getPlugin().getConfig()).getString("MySQL.Senha")).toString();
        try {
            this.con = DriverManager.getConnection(string, string2, string3);
        }
        catch (SQLException ex) {
            Bukkit.getConsoleSender().sendMessage("§4[gFacSetSpawn] Falha ao conectar com MySQL.");
            this.getPlugin().getServer().getPluginManager().disablePlugin((Plugin)this.getPlugin());
        }
    }
    
    protected void close() {
        if (this.con != null) {
            try {
                this.con.close();
            }
            catch (SQLException ex) {}
        }
    }
    
    public void createTable() {
        if (this.con != null) {
            try {
                this.con.prepareStatement("CREATE TABLE IF NOT EXISTS `fac_spawners` (`nome` VARCHAR(48) NULL, `Mobs` VARCHAR(255) NULL);").execute();
            }
            catch (SQLException ex) {}
        }
    }
    
    public Main getPlugin() {
        return this.plugin;
    }
    
    public void setPlugin(final Main plugin) {
        this.plugin = plugin;
    }
}
