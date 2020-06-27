package me.gabriel.gfacsetspawn.manager;

import java.util.*;

import me.gabriel.gfacsetspawn.Main;

public class Manager_Conta
{
    private Map<String, Manager_Mobs> conta;
    private Main plugin;
    
    public Manager_Conta(final Main plugin) {
        this.setPlugin(plugin);
        this.conta = new HashMap<String, Manager_Mobs>();
    }
    
    public void criarConta(final Manager_Mobs spawnerController) {
        this.conta.put(spawnerController.getFacção(), spawnerController);
    }
    
    public void deletarConta(final String s) {
        this.conta.remove(s);
    }
    
    public Manager_Mobs getConta(final String s) {
        return this.conta.get(s);
    }
    
    public void loadContas() {
        for (final Manager_Mobs spawnerController : this.getPlugin().getManager().getContas()) {
            this.conta.put(spawnerController.getFacção(), spawnerController);
        }
    }
    
    public Main getPlugin() {
        return this.plugin;
    }
    
    public void setPlugin(final Main plugin) {
        this.plugin = plugin;
    }
}
