package me.suff.mc.angels;

import com.mojang.serialization.Codec;
import me.suff.mc.angels.client.models.entity.WAModels;
import me.suff.mc.angels.client.renders.entities.AngelRender;
import me.suff.mc.angels.client.renders.entities.AnomalyRender;
import me.suff.mc.angels.client.renders.entities.CGRender;
import me.suff.mc.angels.common.WAObjects;
import me.suff.mc.angels.common.WAPaintings;
import me.suff.mc.angels.common.entities.WeepingAngel;
import me.suff.mc.angels.common.entities.attributes.WAAttributes;
import me.suff.mc.angels.common.level.WAFeatures;
import me.suff.mc.angels.common.level.biomemodifiers.BiomeFeatureModifier;
import me.suff.mc.angels.common.level.biomemodifiers.BiomeSpawnsModifier;
import me.suff.mc.angels.common.variants.AngelTypes;
import me.suff.mc.angels.compat.vivecraft.ServerReflector;
import me.suff.mc.angels.config.WAConfig;
import me.suff.mc.angels.data.*;
import me.suff.mc.angels.network.Network;
import me.suff.mc.angels.utils.AngelUtil;
import me.suff.mc.angels.utils.ClientUtil;
import me.suff.mc.angels.utils.FortuneBonusEnchant;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.progress.StartupMessageManager;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import static me.suff.mc.angels.common.level.WAPieces.init;

@Mod("weeping_angels")
public class WeepingAngels {

    public static final String MODID = "weeping_angels";
    public static final String NAME = "Weeping Angels";
    public static final ServerReflector VR_REFLECTOR = new ServerReflector();
    public static Logger LOGGER = LogManager.getLogger(NAME);

    public WeepingAngels() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.register(this);
        modBus.addListener(this::setup);
        modBus.addListener(this::onAttributeAssign);

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        AngelTypes.VARIANTS.register(modBus);
        WAObjects.Sounds.SOUNDS.register(bus);
        WAObjects.Blocks.BLOCKS.register(bus);
        WAObjects.Blocks.BLOCK_ITEMS.register(bus);
        WAObjects.Items.ITEMS.register(bus);
        WAObjects.EntityEntries.ENTITIES.register(bus);
        WAObjects.Tiles.TILES.register(bus);
        WAFeatures.STRUCTURES.register(bus);
        WAPaintings.PAINTINGS.register(bus);
        WAAttributes.ATTRIBUTES.register(bus);
        WAGlobalLoot.GLM.register(modBus);

        WAFeatures.CONFIGURED_FEATURES.register(modBus);
        WAFeatures.PLACED_FEATURES.register(modBus);

        final DeferredRegister<Codec<? extends BiomeModifier>> serializers = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, MODID);
        serializers.register(modBus);
        serializers.register(BiomeSpawnsModifier.WEEPING_ANGEL_SPAWNS.getPath(), BiomeSpawnsModifier::makeCodec);
        serializers.register(BiomeFeatureModifier.ADD_FEATURE.getPath(), BiomeFeatureModifier::makeCodec);

        MinecraftForge.EVENT_BUS.register(this);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, WAConfig.CONFIG_SPEC);
        DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> modBus.addListener(this::doClientStuff));
        StartupMessageManager.addModMessage("Don't Blink!");
    }

    private void setup(final @NotNull FMLCommonSetupEvent event) {
        Network.init();
        AngelUtil.registerFunction(new ResourceLocation(MODID, "fortune_enchant"), new FortuneBonusEnchant.Serializer()); //registerFunction
        VR_REFLECTOR.init();
        init();
        AngelTypes.updateWeighted();
    }


    @SubscribeEvent
    public void regModels(EntityRenderersEvent.RegisterLayerDefinitions definitions) {
        WAModels.init(definitions);
    }

    @SubscribeEvent
    public void entityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(WAObjects.EntityEntries.WEEPING_ANGEL.get(), AngelRender::new);
        event.registerEntityRenderer(WAObjects.EntityEntries.ANOMALY.get(), AnomalyRender::new);
        event.registerEntityRenderer(WAObjects.EntityEntries.CHRONODYNE_GENERATOR.get(), CGRender::new);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        DistExecutor.runWhenOn(Dist.CLIENT, () -> ClientUtil::doClientStuff);
    }

    @SubscribeEvent
    public void onGatherData(GatherDataEvent e) {
        DataGenerator generator = e.getGenerator();
        ExistingFileHelper existingFileHelper = e.getExistingFileHelper();
        generator.addProvider(true, new WAItemTags(generator, new WABlockTags(generator, existingFileHelper), existingFileHelper));
        generator.addProvider(true, new WABlockTags(generator, existingFileHelper));
        generator.addProvider(true, new LootTablesForDrops(generator));
        generator.addProvider(true, new WALangEnglish());
        generator.addProvider(true, new WABiomeGen(generator, existingFileHelper));
        generator.addProvider(true, new WAStructureTagGen(generator, existingFileHelper));
        generator.addProvider(true, new WARecipeGen(generator));
        generator.addProvider(true, new WABiomeModifiers(generator));
        // generator.addProvider(new WALootTables(generator));
    }

    public void onAttributeAssign(EntityAttributeCreationEvent event) {
        event.put(WAObjects.EntityEntries.WEEPING_ANGEL.get(), WeepingAngel.createAttributes().build());
        event.put(WAObjects.EntityEntries.ANOMALY.get(), WeepingAngel.createAttributes().build());
    }


}
