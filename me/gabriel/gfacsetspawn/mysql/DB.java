package me.gabriel.gfacsetspawn.mysql;

import org.bukkit.scheduler.*;

import me.gabriel.gfacsetspawn.Main;
import me.gabriel.gfacsetspawn.manager.Manager_Mobs;
import me.gabriel.gfacsetspawn.utils.Utils;

import org.bukkit.plugin.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import java.util.*;
import java.sql.*;

public class DB
{
    private Main plugin;
    
    public DB(final Main plugin) {
        this.plugin = plugin;
    }
    
    public void criarConta(final String s) {
        new BukkitRunnable() {
            public void run() {
                try {
                    final PreparedStatement prepareStatement = Main.get().getM().con.prepareStatement("INSERT INTO `fac_spawners`(`nome`,`Mobs`) VALUES (?,?)");
                    prepareStatement.setString(1, s);
                    prepareStatement.setString(2, "");
                    prepareStatement.execute();
                }
                catch (SQLException ex) {}
            }
        }.runTaskAsynchronously((Plugin)this.plugin);
    }
    
    public void deleteConta(final String s) {
        new BukkitRunnable() {
            public void run() {
                try {
                    final PreparedStatement prepareStatement = Main.get().getM().con.prepareStatement("DELETE FROM `fac_spawners` WHERE `nome` = ?");
                    prepareStatement.setString(1, s);
                    prepareStatement.execute();
                }
                catch (SQLException ex) {}
            }
        }.runTaskAsynchronously((Plugin)this.plugin);
    }
    
    public void setarMobs(final String s, final String s2) {
        new BukkitRunnable() {
            public void run() {
                try {
                    final PreparedStatement prepareStatement = Main.get().getM().con.prepareStatement("UPDATE `fac_spawners` SET `Mobs` = ? WHERE `nome` = ?");
                    prepareStatement.setString(1, s2);
                    prepareStatement.setString(2, s);
                    prepareStatement.executeUpdate();
                }
                catch (SQLException ex) {}
            }
        }.runTaskAsynchronously((Plugin)this.plugin);
    }
    
    public List<Manager_Mobs> getContas() {
        final ArrayList<Manager_Mobs> list = new ArrayList<Manager_Mobs>();
        try {
            final ResultSet executeQuery = Main.get().getM().con.prepareStatement("SELECT * FROM fac_spawners").executeQuery();
            while (executeQuery.next()) {
                final String string = executeQuery.getString("Mobs");
                final HashMap<EntityType, Location> hashMap = new HashMap<EntityType, Location>();
                String[] split;
                for (int length = (split = string.split("(?=\\{)|(?<=\\})")).length, i = 0; i < length; ++i) {
                    final String s = split[i];
                    try {
                        if (s != null && s.length() >= 3) {
                            final String[] split2 = s.replace("{", "").replace("}", "").split("=");
                            hashMap.put(EntityType.valueOf(split2[0].toUpperCase()), Utils.locationDeserializer(split2[1]));
                        }
                    }
                    catch (Exception ex) {}
                }
                list.add(new Manager_Mobs(executeQuery.getString("nome"), hashMap));
            }
            return list;
        }
        catch (Exception ex2) {
            return list;
        }
    }
}
