package mc.craig.software.angels.config;

import com.google.common.collect.Lists;
import mc.craig.software.angels.common.entities.AngelType;
import mc.craig.software.angels.common.variants.AbstractVariant;
import mc.craig.software.angels.utils.AngelUtil;
import mc.craig.software.angels.utils.DamageType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

public class WAConfig {
    public static final WAConfig CONFIG;
    public static final ForgeConfigSpec CONFIG_SPEC;

    static {
        final Pair<WAConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(WAConfig::new);
        CONFIG = specPair.getLeft();
        CONFIG_SPEC = specPair.getRight();
    }

    // WorldGen
    public final ForgeConfigSpec.BooleanValue arms;
    public final ForgeConfigSpec.BooleanValue genOres;
    public final ForgeConfigSpec.BooleanValue genGraveyard;
    public final ForgeConfigSpec.BooleanValue genCatacombs;
    // Spawn
    public final ForgeConfigSpec.IntValue maxCount;
    public final ForgeConfigSpec.IntValue spawnWeight;
    public final ForgeConfigSpec.IntValue minCount;
    public final ForgeConfigSpec.EnumValue<EntityClassification> spawnType;
    public final ForgeConfigSpec.ConfigValue<List<? extends String>> allowedBiomes;
    // Angel
    public final ForgeConfigSpec.EnumValue<DamageType> damageType;
    public final ForgeConfigSpec.BooleanValue playScrapeSounds;
    public final ForgeConfigSpec.BooleanValue playSeenSounds;
    public final ForgeConfigSpec.DoubleValue damage;
    public final ForgeConfigSpec.IntValue xpGained;
    public final ForgeConfigSpec.BooleanValue blockBreaking;
    public final ForgeConfigSpec.IntValue blockBreakRange;
    public final ForgeConfigSpec.BooleanValue chickenGoboom;
    public final ForgeConfigSpec.BooleanValue torchBlowOut;
    public final ForgeConfigSpec.BooleanValue freezeOnAngel;
    public final ForgeConfigSpec.IntValue stalkRange;
    public final ForgeConfigSpec.DoubleValue moveSpeed;

    // Teleport
    public final ForgeConfigSpec.EnumValue<AngelUtil.EnumTeleportType> teleportType;
    public final ForgeConfigSpec.ConfigValue<List<? extends String>> notAllowedDimensions;
    public final ForgeConfigSpec.BooleanValue justTeleport;
    public final ForgeConfigSpec.IntValue teleportRange;
    public final ForgeConfigSpec.BooleanValue angelDimTeleport;
    public final ForgeConfigSpec.BooleanValue aggroCreative;
    public final ForgeConfigSpec.BooleanValue spawnFromBlocks;

    // Easter Eggs
    public final ForgeConfigSpec.BooleanValue showSantaHatsAtXmas;
    public final ForgeConfigSpec.ConfigValue<List<? extends String>> allowedAngelTypes;
    public final ForgeConfigSpec.ConfigValue<List<? extends String>> allowedVariants;


    public WAConfig(ForgeConfigSpec.Builder builder) {
        builder.push("world_gen");
        arms = builder.translation("config.weeping_angels.genArms").comment("Config to toggle the generation of arms in snow biomes").define("arms", true);
        genOres = builder.translation("config.weeping_angels.genOre").comment("Configure whether the mods ores spawn. This MAY require a restart when changed.").define("genOres", true);
        genGraveyard = builder.translation("config.weeping_angels.genGraveyard").comment("Configure whether Graveyard Structures spawn. This will require a restart when changed.").define("genGraveyard", true);
        genCatacombs = builder.translation("config.weeping_angels.genCatacombs").comment("Configure whether Catacombs Structures spawn. This will require a restart when changed.").define("genCatacombs", true);
        builder.pop();

        builder.push("spawn");
        minCount = builder.translation("config.weeping_angels.minCount").comment("The minimum amount of 'Weeping Angels' that spawn at each spawn attempt").defineInRange("minCount", 1, 1, 100);
        maxCount = builder.translation("config.weeping_angels.maxCount").comment("The maximum amount of 'Weeping Angels' that spawn at each spawn attempt").defineInRange("maxCount", 1, 1, 100);
        spawnWeight = builder.translation("config.weeping_angels.spawn_weight").comment("The weight of spawn in relation to other mods 'Weeping Angels' will spawn in. Less than 100 = Rarer").defineInRange("spawn_weight", 1, 1, Integer.MAX_VALUE);
        spawnType = builder.translation("config.weeping_angels.spawntype").comment("'Weeping Angel' spawn classification").worldRestart().defineEnum("spawnType", EntityClassification.MONSTER);
        allowedBiomes = builder.translation("config.weeping_angels.spawnBiomes").comment("Note: A list of biomes where angels should spawn.").defineList("spawnBiomes", genBiomesForSpawn(), String.class::isInstance);
        builder.pop();

        builder.push("angel");
        damageType = builder.translation("config.weeping_angels.damageType").comment("Damage Type For Angels").defineEnum("damageType", DamageType.ANY_PICKAXE_AND_GENERATOR_ONLY);
        playScrapeSounds = builder.translation("config.weeping_angels.angel_move_sound").comment("Non-child angels play scraping sounds when moving, this toggles that").define("playScrapeSound", true);
        playSeenSounds = builder.translation("config.weeping_angels.angel_seen_sound").comment("Toggle seen sounds").define("playSeenSounds", true);
        damage = builder.translation("config.weeping_angels.angel_damage").comment("The damage dealt by an angel").defineInRange("damage", 8.0D, 1.0D, Double.MAX_VALUE);
        xpGained = builder.translation("config.weeping_angels.angel_xp_value").comment("XP gained from angels").defineInRange("xpGained", 25, 1, Integer.MAX_VALUE);
        chickenGoboom = builder.translation("config.weeping_angels.chicken_go_boom").comment("If this is enabled, the timey wimey detector can blow up chickens when in use randomly").define("chickenGoboom", true);
        torchBlowOut = builder.translation("config.weeping_angels.blowout_torch").comment("If this is enabled, baby angels will blow out light items from the players hand").define("torchBlowOut", true);
        freezeOnAngel = builder.translation("config.weeping_angels.ql").comment("if enabled, angels will freeze when they see one another. (Impacts performance a bit)").define("freezeOnAngel", false);
        stalkRange = builder.translation("config.weeping_angels.around_player_range").comment("Determines the range the angels will look for players within, personally, I'd stay under 100").defineInRange("stalkRange", 65, 1, 100);
        moveSpeed = builder.translation("config.weeping_angels.moveSpeed").comment("Determines the angels move speed").defineInRange("angelMovementSpeed", 0.2, 0.1, Double.MAX_VALUE);
        blockBreaking = builder.translation("config.weeping_angels.angel.block_break").comment("If this is enabled, angels will break blocks (If gamerules allow) - !!!! BLOCK BLACKLISTING: You may be looking for a config option in order to stop certain blocks from being broken. You can do this with a datapack using weeping_angels:angel_proof").define("blockBreaking", true);
        blockBreakRange = builder.translation("config.weeping_angels.block_break_range").comment("The maximum range a angel can break blocks within").defineInRange("blockBreakRange", 15, 1, 120);
        builder.pop();

        builder.push("teleport");
        teleportType = builder.translation("config.weeping_angels.teleport_enabled").comment("Teleport Type - STRUCTURES: Teleports you to Structures Only - DONT: No Teleporting, only damage - RANDOM: Anywhere").defineEnum("teleportType", AngelUtil.EnumTeleportType.RANDOM_PLACE);
        notAllowedDimensions = builder.translation("config.weeping_angels.disallowed_dimensions").comment("Note: This a list of dimensions that angels should NOT teleport you to.").defineList("notAllowedDimensions", Lists.newArrayList(World.END.location().toString()), String.class::isInstance);
        justTeleport = builder.translation("config.weeping_angels.teleport_instant").comment("just teleport. no damage.").define("justTeleport", false);
        teleportRange = builder.translation("config.weeping_angels.teleportRange").comment("The maximum range a user can be teleported by the Angels").defineInRange("teleportRange", 450, 1, Integer.MAX_VALUE);
        angelDimTeleport = builder.translation("config.weeping_angels.angeldimteleport").comment("If this is enabled, angel teleporting can also tp the player to other dimensions").define("angelDimTeleport", true);
        aggroCreative = builder.translation("config.weeping_angels.aggroCreative").comment("Should Angels target creative players?").define("aggroCreative", true);
        builder.pop();

        builder.push("block");
        spawnFromBlocks = builder.translation("config.weeping_angels.spawnFromBlocks").comment("This config option toggles whether angels can spawn from Statues/Plinths when they receive a redstone signal").define("spawnFromBlocks", true);
        builder.pop();

        builder.push("misc");
        showSantaHatsAtXmas = builder.translation("config.weeping_angels.santa_hat").comment("Toggle whether santa hats are shown at Xmas").define("showSantaHatsAtXmas", true);
        allowedAngelTypes = builder.translation("config.weeping_angels.allowed_types").comment("Toggle certain angel models (Only applies to Entity)").defineList("allowedAngelTypes", genAngelTypes(), String.class::isInstance);
        allowedVariants = builder.translation("config.weeping_angels.allowed_variants").comment("Toggle certain angel variants (Only applies to Entity)").defineList("allowedVariants", getAngelVariants(), String.class::isInstance);
        builder.pop();
    }


    public boolean isModelPermitted(AngelType angelType) {
        for (String s : allowedAngelTypes.get()) {
            if (s.equalsIgnoreCase(angelType.name())) {
                return true;
            }
        }
        return false;
    }

    public boolean isVariantPermitted(AbstractVariant angelType) {
        for (String s : allowedVariants.get()) {
            if (s.equalsIgnoreCase(angelType.getRegistryName().toString())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> genBiomesForSpawn() {
        ArrayList<String> spawnBiomes = new ArrayList<>();
        for (Biome biome : ForgeRegistries.BIOMES) {
            if (biome.getBiomeCategory() == Biome.Category.NETHER || biome.getBiomeCategory() == Biome.Category.FOREST || biome.getBiomeCategory() == Biome.Category.PLAINS) {
                spawnBiomes.add(biome.getRegistryName().toString());
            }
        }
        return spawnBiomes;
    }

    public ArrayList<String> getAngelVariants() {
        ArrayList<String> allowedTypes = new ArrayList<>();
        allowedTypes.add("weeping_angels:gold");
        allowedTypes.add("weeping_angels:diamond");
        allowedTypes.add("weeping_angels:iron");
        allowedTypes.add("weeping_angels:mossy");
        allowedTypes.add("weeping_angels:normal");
        allowedTypes.add("weeping_angels:basalt");
        allowedTypes.add("weeping_angels:rusted");
        allowedTypes.add("weeping_angels:rusted_no_arm");
        allowedTypes.add("weeping_angels:rusted_no_wing");
        allowedTypes.add("weeping_angels:rusted_no_head");
        allowedTypes.add("weeping_angels:dirt");
        allowedTypes.add("weeping_angels:emerald");
        allowedTypes.add("weeping_angels:copper");
        allowedTypes.add("weeping_angels:lapis_lazuli");
        allowedTypes.add("weeping_angels:quartz");
        return allowedTypes;
    }

    public ArrayList<String> genAngelTypes() {
        ArrayList<String> allowedTypes = new ArrayList<>();
        allowedTypes.add("DISASTER_MC");
        allowedTypes.add("DOCTOR");
        allowedTypes.add("ED");
        allowedTypes.add("ED_ANGEL_CHILD");
        allowedTypes.add("A_DIZZLE");
        allowedTypes.add("DYING");
        allowedTypes.add("VILLAGER");
        allowedTypes.add("VIO_1");
        allowedTypes.add("VIO_2");
        allowedTypes.add("SPARE_TIME");
        return allowedTypes;
    }
}