package me.gabriel.gfacsetspawn.utils;

import org.bukkit.inventory.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class EntityUtils
{
    private static ItemStack BLAZE;
    private static ItemStack CAVE_SPIDER;
    private static ItemStack CHICKEN;
    private static ItemStack COW;
    private static ItemStack CREEPER;
    private static ItemStack GHAST;
    private static ItemStack IRON_GOLEM;
    private static ItemStack MAGMA_CUBE;
    private static ItemStack OCELOT;
    private static ItemStack PIG;
    private static ItemStack PIG_ZOMBIE;
    private static ItemStack SHEEP;
    private static ItemStack SKELETON;
    private static ItemStack SLIME;
    private static ItemStack SPIDER;
    private static ItemStack SQUID;
    private static ItemStack WITHER;
    private static ItemStack WITCH;
    private static ItemStack ZOMBIE;
    private static ItemStack ENDERMAN;
    private static ItemStack WOLF;
    private static ItemStack GUARDIAN;
    
    @SuppressWarnings("rawtypes")
	public static String traduzir(final EntityType entityType) {
        if (entityType == null) {
            return "";
        }
        switch (entityType) {
            case BAT: {
                return "Bat";
            }
            case BLAZE: {
                return "Blaze";
            }
            case CAVE_SPIDER: {
                return "Cave_Spider";
            }
            case CHICKEN: {
                return "Chicken";
            }
            case COW: {
                return "Cow";
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
                return "Iron_Golem";
            }
            case MAGMA_CUBE: {
                return "Magma";
            }
            case PIG: {
                return "Pig";
            }
            case PIG_ZOMBIE: {
                return "Pig_Zombie";
            }
            case RABBIT: {
                return "Rabbit";
            }
            case SHEEP: {
                return "Sheep";
            }
            case SILVERFISH: {
                return "Silverfish";
            }
            case SKELETON: {
                return "Skeleton";
            }
            case SLIME: {
                return "Slime";
            }
            case SPIDER: {
                return "Spider";
            }
            case OCELOT: {
                return "Ocelote";
            }
            case WITCH: {
                return "Witch";
            }
            case WITHER: {
                return "Wither";
            }
            case WOLF: {
                return "Wolf";
            }
            case ZOMBIE: {
                return "Zombie";
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
	public static String translate(final EntityType entityType) {
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
                return "Aranha da Caverna";
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
                return "Golem de Ferro";
            }
            case MAGMA_CUBE: {
                return "Magma";
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
                return "Traça";
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
            case OCELOT: {
                return "Lula";
            }
            case WITCH: {
                return "Bruxa";
            }
            case WITHER: {
                return "Wither";
            }
            case WOLF: {
                return "Cachorro";
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
	public static String head(final EntityType entityType) {
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
    
    @SuppressWarnings("rawtypes")
	public static ItemStack headItem(final EntityType entityType) {
        if (entityType == null) {
            return null;
        }
        switch (entityType) {
            case BLAZE: {
                return EntityUtils.BLAZE.clone();
            }
            case CAVE_SPIDER: {
                return EntityUtils.CAVE_SPIDER.clone();
            }
            case CHICKEN: {
                return EntityUtils.CHICKEN.clone();
            }
            case COW: {
                return EntityUtils.COW.clone();
            }
            case CREEPER: {
                return EntityUtils.CREEPER.clone();
            }
            case GHAST: {
                return EntityUtils.GHAST.clone();
            }
            case IRON_GOLEM: {
                return EntityUtils.IRON_GOLEM.clone();
            }
            case MAGMA_CUBE: {
                return EntityUtils.MAGMA_CUBE.clone();
            }
            case OCELOT: {
                return EntityUtils.OCELOT.clone();
            }
            case PIG: {
                return EntityUtils.PIG.clone();
            }
            case PIG_ZOMBIE: {
                return EntityUtils.PIG_ZOMBIE.clone();
            }
            case SHEEP: {
                return EntityUtils.SHEEP.clone();
            }
            case SKELETON: {
                return EntityUtils.SKELETON.clone();
            }
            case SLIME: {
                return EntityUtils.SLIME.clone();
            }
            case SPIDER: {
                return EntityUtils.SPIDER.clone();
            }
            case SQUID: {
                return EntityUtils.SQUID.clone();
            }
            case WITHER: {
                return EntityUtils.WITHER.clone();
            }
            case WITCH: {
                return EntityUtils.WITCH.clone();
            }
            case ZOMBIE: {
                return EntityUtils.ZOMBIE.clone();
            }
            case ENDERMAN: {
                return EntityUtils.ENDERMAN.clone();
            }
            case WOLF: {
                return EntityUtils.WOLF.clone();
            }
            case GUARDIAN: {
                return EntityUtils.GUARDIAN.clone();
            }
            default: {
                return new ItemBuilder(Material.SKULL_ITEM).durability(3).owner("MHF_" + ((Enum)entityType).toString().toUpperCase()).build();
            }
        }
    }
    
    static {
        EntityUtils.BLAZE = Heads.getSkull("http://textures.minecraft.net/texture/b78ef2e4cf2c41a2d14bfde9caff10219f5b1bf5b35a49eb51c6467882cb5f0");
        EntityUtils.CAVE_SPIDER = Heads.getSkull("http://textures.minecraft.net/texture/41645dfd77d09923107b3496e94eeb5c30329f97efc96ed76e226e98224");
        EntityUtils.CHICKEN = Heads.getSkull("http://textures.minecraft.net/texture/1638469a599ceef7207537603248a9ab11ff591fd378bea4735b346a7fae893");
        EntityUtils.COW = Heads.getSkull("http://textures.minecraft.net/texture/5d6c6eda942f7f5f71c3161c7306f4aed307d82895f9d2b07ab4525718edc5");
        EntityUtils.CREEPER = Heads.getSkull("http://textures.minecraft.net/texture/f4254838c33ea227ffca223dddaabfe0b0215f70da649e944477f44370ca6952");
        EntityUtils.GHAST = Heads.getSkull("http://textures.minecraft.net/texture/8b6a72138d69fbbd2fea3fa251cabd87152e4f1c97e5f986bf685571db3cc0");
        EntityUtils.IRON_GOLEM = Heads.getSkull("http://textures.minecraft.net/texture/89091d79ea0f59ef7ef94d7bba6e5f17f2f7d4572c44f90f76c4819a714");
        EntityUtils.MAGMA_CUBE = Heads.getSkull("http://textures.minecraft.net/texture/38957d5023c937c4c41aa2412d43410bda23cf79a9f6ab36b76fef2d7c429");
        EntityUtils.OCELOT = Heads.getSkull("http://textures.minecraft.net/texture/5657cd5c2989ff97570fec4ddcdc6926a68a3393250c1be1f0b114a1db1");
        EntityUtils.PIG = Heads.getSkull("http://textures.minecraft.net/texture/621668ef7cb79dd9c22ce3d1f3f4cb6e2559893b6df4a469514e667c16aa4");
        EntityUtils.PIG_ZOMBIE = Heads.getSkull("http://textures.minecraft.net/texture/74e9c6e98582ffd8ff8feb3322cd1849c43fb16b158abb11ca7b42eda7743eb");
        EntityUtils.SHEEP = Heads.getSkull("http://textures.minecraft.net/texture/f31f9ccc6b3e32ecf13b8a11ac29cd33d18c95fc73db8a66c5d657ccb8be70");
        EntityUtils.SKELETON = Heads.getSkull("http://textures.minecraft.net/texture/301268e9c492da1f0d88271cb492a4b302395f515a7bbf77f4a20b95fc02eb2");
        EntityUtils.SLIME = Heads.getSkull("http://textures.minecraft.net/texture/895aeec6b842ada8669f846d65bc49762597824ab944f22f45bf3bbb941abe6c");
        EntityUtils.SPIDER = Heads.getSkull("http://textures.minecraft.net/texture/cd541541daaff50896cd258bdbdd4cf80c3ba816735726078bfe393927e57f1");
        EntityUtils.SQUID = Heads.getSkull("http://textures.minecraft.net/texture/01433be242366af126da434b8735df1eb5b3cb2cede39145974e9c483607bac");
        EntityUtils.WITHER = Heads.getSkull("http://textures.minecraft.net/texture/cdf74e323ed41436965f5c57ddf2815d5332fe999e68fbb9d6cf5c8bd4139f");
        EntityUtils.WITCH = Heads.getSkull("http://textures.minecraft.net/texture/20e13d18474fc94ed55aeb7069566e4687d773dac16f4c3f8722fc95bf9f2dfa");
        EntityUtils.ZOMBIE = Heads.getSkull("http://textures.minecraft.net/texture/56fc854bb84cf4b7697297973e02b79bc10698460b51a639c60e5e417734e11");
        EntityUtils.ENDERMAN = Heads.getSkull("http://textures.minecraft.net/texture/7a59bb0a7a32965b3d90d8eafa899d1835f424509eadd4e6b709ada50b9cf");
        EntityUtils.WOLF = Heads.getSkull("http://textures.minecraft.net/texture/69d1d3113ec43ac2961dd59f28175fb4718873c6c448dfca8722317d67");
        EntityUtils.GUARDIAN = Heads.getSkull("http://textures.minecraft.net/texture/a0bf34a71e7715b6ba52d5dd1bae5cb85f773dc9b0d457b4bfc5f9dd3cc7c94");
    }
}
