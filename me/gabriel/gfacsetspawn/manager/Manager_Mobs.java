package me.gabriel.gfacsetspawn.manager;

import java.util.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class Manager_Mobs
{
    private String Facção;
    private Map<EntityType, Location> mobs;
    
    public Manager_Mobs(final String facção, final Map<EntityType, Location> mobs) {
        this.Facção = facção;
        this.mobs = mobs;
    }
    
    public Map<EntityType, Location> getMobs() {
        return this.mobs;
    }
    
    public void setMobs(final Map<EntityType, Location> mobs) {
        this.mobs = mobs;
    }
    
    public String getFacção() {
        return this.Facção;
    }
    
    public void setFacção(final String facção) {
        this.Facção = facção;
    }
}
