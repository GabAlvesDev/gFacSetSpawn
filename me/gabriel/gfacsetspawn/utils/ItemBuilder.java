package me.gabriel.gfacsetspawn.utils;

import org.bukkit.enchantments.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import java.util.*;
import com.mojang.authlib.*;
import com.mojang.authlib.properties.*;
import java.lang.reflect.*;
import org.bukkit.*;
import java.util.logging.*;
import com.google.common.collect.*;

public class ItemBuilder
{
    private ItemStack is;
    
    public ItemBuilder(final Material material) {
        this(material, 1, (short)0);
    }
    
    public ItemBuilder(final ItemStack itemStack) {
        this.is = itemStack.clone();
    }
    
    public ItemBuilder(final Material material, final int n, final short n2) {
        this.is = new ItemStack(material, n, n2);
    }
    
    public ItemBuilder clone() {
        return new ItemBuilder(this.is);
    }
    
    public ItemBuilder durability(final int n) {
        this.is.setDurability((short)n);
        return this;
    }
    
    public ItemBuilder name(final String s) {
        final ItemMeta itemMeta = this.is.getItemMeta();
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', s));
        this.is.setItemMeta(itemMeta);
        return this;
    }
    
    public ItemBuilder unsafeEnchantment(final Enchantment enchantment, final int n) {
        this.is.addUnsafeEnchantment(enchantment, n);
        return this;
    }
    
    public ItemBuilder enchant(final Enchantment enchantment, final int n) {
        final ItemMeta itemMeta = this.is.getItemMeta();
        itemMeta.addEnchant(enchantment, n, true);
        this.is.setItemMeta(itemMeta);
        return this;
    }
    
    public ItemBuilder removeEnchantment(final Enchantment enchantment) {
        this.is.removeEnchantment(enchantment);
        return this;
    }
    
    public ItemBuilder owner(final String owner) {
        try {
            final SkullMeta itemMeta = (SkullMeta)this.is.getItemMeta();
            itemMeta.setOwner(owner);
            this.is.setItemMeta((ItemMeta)itemMeta);
        }
        catch (ClassCastException ex) {}
        return this;
    }
    
    public ItemBuilder infinityDurabilty() {
        this.is.setDurability((short)32767);
        return this;
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public ItemBuilder lore(final String... array) {
        final ItemMeta itemMeta = this.is.getItemMeta();
        final List lore = (itemMeta.getLore() == null) ? new ArrayList<String>() : itemMeta.getLore();
        for (int length = array.length, i = 0; i < length; ++i) {
            lore.add(ChatColor.translateAlternateColorCodes('&', array[i]));
        }
        itemMeta.setLore(lore);
        this.is.setItemMeta(itemMeta);
        return this;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ItemBuilder listLore(final List<String> list) {
        final ItemMeta itemMeta = this.is.getItemMeta();
        final List lore = (itemMeta.getLore() == null) ? new ArrayList<String>() : itemMeta.getLore();
        final Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            lore.add(ChatColor.translateAlternateColorCodes('&', (String)iterator.next()));
        }
        itemMeta.setLore(lore);
        this.is.setItemMeta(itemMeta);
        return this;
    }

    @SuppressWarnings({ "rawtypes", "deprecation" })
    public ItemBuilder woolColor(final DyeColor dyeColor) {
        if (!((Enum)this.is.getType()).equals(Material.WOOL)) {
            return this;
        }
        this.is.setDurability((short)dyeColor.getDyeData());
        return this;
    }
    
    public ItemBuilder amount(int amount) {
        if (amount > 64) {
            amount = 64;
        }
        this.is.setAmount(amount);
        return this;
    }
    
    public ItemBuilder removeAttributes() {
        final ItemMeta itemMeta = this.is.getItemMeta();
        itemMeta.addItemFlags(ItemFlag.values());
        this.is.setItemMeta(itemMeta);
        return this;
    }
    
    public ItemStack build() {
        return this.is;
    }
    
    @SuppressWarnings("rawtypes")
	public ItemBuilder color(final Color color) {
        if (!((Enum)this.is.getType()).name().contains("LEATHER_")) {
            return this;
        }
        final LeatherArmorMeta itemMeta = (LeatherArmorMeta)this.is.getItemMeta();
        itemMeta.setColor(color);
        this.is.setItemMeta((ItemMeta)itemMeta);
        return this;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static ItemStack createHead(final String displayName, final List<String> lore, final String s) {
        final GameProfile gameProfile = createGameProfile(s, UUID.randomUUID());
        final ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        RefSet(itemMeta.getClass(), itemMeta, "profile", gameProfile);
        itemStack.setItemMeta(itemMeta);
        final SkullMeta itemMeta2 = (SkullMeta)itemStack.getItemMeta();
        itemMeta2.setDisplayName(displayName);
        itemMeta2.setLore((List)lore);
        itemStack.setItemMeta((ItemMeta)itemMeta2);
        return itemStack;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static ItemStack createHead(final String displayName, final String s, final String s2) {
        final GameProfile gameProfile = createGameProfile(s2, UUID.randomUUID());
        final ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        RefSet(itemMeta.getClass(), itemMeta, "profile", gameProfile);
        itemStack.setItemMeta(itemMeta);
        final SkullMeta itemMeta2 = (SkullMeta)itemStack.getItemMeta();
        itemMeta2.setDisplayName(displayName);
        final String[] split = s.split("\n");
        final ArrayList<String> lore = new ArrayList<String>();
        for (int i = 0; i < split.length; ++i) {
            lore.add(split[i]);
        }
        itemMeta2.setLore((List)lore);
        itemStack.setItemMeta((ItemMeta)itemMeta2);
        return itemStack;
    }
    
    public static ItemStack createHead(final String displayName, final String s) {
        final GameProfile gameProfile = createGameProfile(s, UUID.randomUUID());
        final ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (!RefSet(itemMeta.getClass(), itemMeta, "profile", gameProfile)) {
            return null;
        }
        itemStack.setItemMeta(itemMeta);
        final SkullMeta itemMeta2 = (SkullMeta)itemStack.getItemMeta();
        itemMeta2.setDisplayName(displayName);
        itemStack.setItemMeta((ItemMeta)itemMeta2);
        return itemStack;
    }
    
    public static ItemStack createHead(final String displayName, final GameProfile gameProfile) {
        final ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (!RefSet(itemMeta.getClass(), itemMeta, "profile", gameProfile)) {
            return null;
        }
        itemStack.setItemMeta(itemMeta);
        final SkullMeta itemMeta2 = (SkullMeta)itemStack.getItemMeta();
        itemMeta2.setDisplayName(displayName);
        itemStack.setItemMeta((ItemMeta)itemMeta2);
        return itemStack;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static GameProfile createGameProfile(final String s, final UUID uuid) {
        final GameProfile gameProfile = new GameProfile(uuid, (String)null);
        ((ForwardingMultimap)gameProfile.getProperties()).put((Object)"textures", (Object)new Property("textures", s));
        return gameProfile;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static ItemStack createPlayerHead(final String displayName, final String owner, final String... array) {
        final ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        final SkullMeta itemMeta = (SkullMeta)itemStack.getItemMeta();
        itemMeta.setDisplayName(displayName);
        itemMeta.setOwner(owner);
        if (array.length != 0) {
            final String[] split = array[0].split("\n");
            final ArrayList<String> lore = new ArrayList<String>();
            for (int i = 0; i < split.length; ++i) {
                lore.add(split[i]);
            }
            itemMeta.setLore((List)lore);
        }
        itemStack.setItemMeta((ItemMeta)itemMeta);
        return itemStack;
    }
    
    public static ItemStack createItem(final Material material, final int n, final String displayName, final short... array) {
        final ItemStack itemStack = (array.length == 0) ? new ItemStack(material, n) : new ItemStack(material, n, array[0]);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(displayName);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static ItemStack createItem(final Material material, final int n, final String displayName, final String s, final short... array) {
        final ItemStack itemStack = (array.length == 0) ? new ItemStack(material, n) : new ItemStack(material, n, array[0]);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(displayName);
        if (s.length() != 0) {
            final String[] split = s.split("\n");
            final ArrayList<String> lore = new ArrayList<String>();
            for (int i = 0; i < split.length; ++i) {
                lore.add(split[i]);
            }
            itemMeta.setLore((List)lore);
        }
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static ItemStack renameStack(final ItemStack itemStack, final int amount, final String displayName, final boolean b) {
        final ItemStack clone = itemStack.clone();
        clone.setAmount(amount);
        final ItemMeta itemMeta = clone.getItemMeta();
        itemMeta.setDisplayName(displayName);
        if (b && itemMeta.hasLore()) {
            itemMeta.setLore((List)null);
        }
        clone.setItemMeta(itemMeta);
        return clone;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static ItemStack renameStack(final ItemStack itemStack, final int n, final String displayName, final String s, final short... array) {
        if (array.length != 0) {
            itemStack.setAmount(n);
        }
        itemStack.setAmount(n);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(displayName);
        if (s.length() != 0) {
            final String[] split = s.split("\n");
            final ArrayList<String> lore = new ArrayList<String>();
            for (int i = 0; i < split.length; ++i) {
                lore.add(split[i]);
            }
            itemMeta.setLore((List)lore);
        }
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    
    public static boolean RefSet(final Class<?> clazz, final Object o, final String s, final Object o2) {
        try {
            final Field declaredField = clazz.getDeclaredField(s);
            final Field declaredField2 = Field.class.getDeclaredField("modifiers");
            final int modifiers = declaredField2.getModifiers();
            if (!declaredField.isAccessible()) {
                declaredField.setAccessible(true);
            }
            if ((modifiers & 0x10) == 0x10) {
                declaredField2.setAccessible(true);
                declaredField2.setInt(declaredField, modifiers & 0xFFFFFFEF);
            }
            try {
                declaredField.set(o, o2);
            }
            finally {
                if ((modifiers & 0x10) == 0x10) {
                    declaredField2.setInt(declaredField, modifiers | 0x10);
                }
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(false);
                }
            }
            return true;
        }
        catch (Exception ex) {
            Bukkit.getLogger().log(Level.WARNING, "Unable to inject Gameprofile", ex);
            return false;
        }
    }
}
