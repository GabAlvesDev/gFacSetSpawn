package me.gabriel.gfacsetspawn.manager;

import java.util.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class Manager_Mobs
{
    private String Fac��o;
    private Map<EntityType, Location> mobs;
    
    public Manager_Mobs(final String fac��o, final Map<EntityType, Location> mobs) {
        this.Fac��o = fac��o;
        this.mobs = mobs;
    }
    
    public Map<EntityType, Location> getMobs() {
        return this.mobs;
    }
    
    public void setMobs(final Map<EntityType, Location> mobs) {
        this.mobs = mobs;
    }
    
    public String getFac��o() {
        return this.Fac��o;
    }
    
    public void setFac��o(final String fac��o) {
        this.Fac��o = fac��o;
    }
}
