package me.gabriel.gfacsetspawn.utils;

import org.bukkit.inventory.*;
import org.bukkit.*;
import java.util.*;
import com.mojang.authlib.*;
import org.apache.commons.codec.binary.Base64;

import com.mojang.authlib.properties.*;
import org.bukkit.inventory.meta.*;
import java.lang.reflect.*;
import org.bukkit.entity.*;
import com.google.common.collect.*;

public class Heads
{
    public static ItemStack VERDE;
    public static ItemStack MAGENTA;
    public static ItemStack BRANCO;
    public static ItemStack AMARELO;
    public static ItemStack ROXO;
    public static ItemStack LARANJA;
    public static ItemStack CINZA;
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static ItemStack getSkull(final String s) {
        final ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        if (s == null || s.isEmpty()) {
            return itemStack;
        }
        final SkullMeta itemMeta = (SkullMeta)itemStack.getItemMeta();
        final GameProfile gameProfile = new GameProfile(UUID.randomUUID(), (String)null);
        ((ForwardingMultimap)gameProfile.getProperties()).put((Object)"textures", (Object)new Property("textures", new String(Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", s).getBytes()))));
        Field declaredField = null;
        try {
            declaredField = itemMeta.getClass().getDeclaredField("profile");
        }
        catch (NoSuchFieldException | SecurityException ex) {
            ex.printStackTrace();
        }
        declaredField.setAccessible(true);
        try {
            declaredField.set(itemMeta, gameProfile);
        }
        catch (IllegalArgumentException | IllegalAccessException ex) {
            ex.printStackTrace();
        }
        itemStack.setItemMeta((ItemMeta)itemMeta);
        return itemStack;
    }
    
    public static ItemBuilder getMobHead(final String s) {
        final EntityType value = EntityType.valueOf(s);
        return new ItemBuilder(Material.SKULL_ITEM).name("§e" + traduzir(value)).durability(3).owner(head(value));
    }
    
    @SuppressWarnings("rawtypes")
	public static String traduzir(final EntityType entityType) {
        if (entityType == null) {
            return "";
        }
        switch (entityType) {
            case BAT: {
                return "Morcego";
            }
            case BLAZE: {
                return "Blaze";
            }
            case CAVE_SPIDER: {
                return "Aranha das cavernas";
            }
            case CHICKEN: {
                return "Galinha";
            }
            case COW: {
                return "Vaca";
            }
            case CREEPER: {
                return "Creeper";
            }
            case GHAST: {
                return "Ghast";
            }
            case GUARDIAN: {
                return "Guardian";
            }
            case IRON_GOLEM: {
                return "Iron Golem";
            }
            case MAGMA_CUBE: {
                return "Magma Cube";
            }
            case OCELOT: {
                return "Jaguatirica";
            }
            case PIG: {
                return "Porco";
            }
            case PIG_ZOMBIE: {
                return "Porco Zumbi";
            }
            case RABBIT: {
                return "Coelho";
            }
            case SHEEP: {
                return "Ovelha";
            }
            case SILVERFISH: {
                return "Silverfish";
            }
            case SKELETON: {
                return "Esqueleto";
            }
            case SLIME: {
                return "Slime";
            }
            case SPIDER: {
                return "Aranha";
            }
            case SQUID: {
                return "Lula";
            }
            case WITCH: {
                return "Bruxa";
            }
            case WITHER: {
                return "Wither";
            }
            case WOLF: {
                return "Lobo";
            }
            case ZOMBIE: {
                return "Zumbi";
            }
            case ENDERMAN: {
                return "Enderman";
            }
            default: {
                return ((Enum)entityType).toString();
            }
        }
    }
    
    @SuppressWarnings("rawtypes")
	private static String head(final EntityType entityType) {
        if (entityType == null) {
            return "";
        }
        switch (entityType) {
            case BLAZE: {
                return "MHF_BLAZE";
            }
            case CAVE_SPIDER: {
                return "MHF_CAVESPIDER";
            }
            case CHICKEN: {
                return "MHF_CHICKEN";
            }
            case COW: {
                return "MHF_COW";
            }
            case CREEPER: {
                return "MHF_CREEPER";
            }
            case GHAST: {
                return "MHF_GHAST";
            }
            case IRON_GOLEM: {
                return "MHF_GOLEM";
            }
            case MAGMA_CUBE: {
                return "MHF_LavaSlime";
            }
            case OCELOT: {
                return "MHF_OCELOT";
            }
            case PIG: {
                return "MHF_PIG";
            }
            case PIG_ZOMBIE: {
                return "MHF_PIGZOMBIE";
            }
            case SHEEP: {
                return "MHF_SHEEP";
            }
            case SKELETON: {
                return "MHF_SKELETON";
            }
            case SLIME: {
                return "MHF_SLIME";
            }
            case SPIDER: {
                return "MHF_SPIDER";
            }
            case SQUID: {
                return "MHF_SQUID";
            }
            case WITHER: {
                return "MHF_WITHER";
            }
            case ZOMBIE: {
                return "MHF_ZOMBIE";
            }
            case ENDERMAN: {
                return "MHF_ENDERMAN";
            }
            case WOLF: {
                return "MHF_WOLF";
            }
            case GUARDIAN: {
                return "MHF_GUARDIAN";
            }
            default: {
                return "MHF_" + ((Enum)entityType).toString().toUpperCase();
            }
        }
    }
    
    static {
        Heads.VERDE = getSkull("http://textures.minecraft.net/texture/361e5b333c2a3868bb6a58b6674a2639323815738e77e053977419af3f77");
        Heads.MAGENTA = new ItemBuilder(Material.SKULL_ITEM).durability(3).owner("diablo3pk").build();
        Heads.BRANCO = new ItemBuilder(Material.SKULL_ITEM).durability(3).owner("cy1337").build();
        Heads.LARANJA = new ItemBuilder(Material.SKULL_ITEM).durability(3).owner("wulfric17").build();
        Heads.AMARELO = getSkull("http://textures.minecraft.net/texture/14c4141c1edf3f7e41236bd658c5bc7b5aa7abf7e2a852b647258818acd70d8");
        Heads.ROXO = getSkull("http://textures.minecraft.net/texture/e9352bcabfc27edb44ceb51b04786542f26a299a0529475346186ee94738f");
        Heads.CINZA = getSkull("http://textures.minecraft.net/texture/f2f085c6b3cb228e5ba81df562c4786762f3c257127e9725c77b7fd301d37");
    }
}
