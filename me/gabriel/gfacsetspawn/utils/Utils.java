package me.gabriel.gfacsetspawn.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

public class Utils {

    public static String locationSerializer(final Location location) {
        return location.getWorld().getName() + "@" + location.getX() + "@" + location.getY() + "@" + location.getZ();
    }
    
    public static Location locationDeserializer(final String s) {
        final String[] split = s.split("@");
        return new Location(Bukkit.getWorld(split[0]), Double.parseDouble(split[1]), Double.parseDouble(split[2]), Double.parseDouble(split[3]));
    }

    @SuppressWarnings("rawtypes")
	public static void sendAction(final Player player, final String s) {
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket((Packet)new PacketPlayOutChat(IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + s + "\"}"), (byte)2));
    }

}
