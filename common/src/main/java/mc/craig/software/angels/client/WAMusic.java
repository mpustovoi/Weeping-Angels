package mc.craig.software.angels.client;

import mc.craig.software.angels.WeepingAngels;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.SoundEvent;

public class WAMusic {

    public static Music CATACOMB_MUSIC;

    public static void init() {
        CATACOMB_MUSIC = new Music(Holder.direct(SoundEvent.createFixedRangeEvent(ResourceLocation.tryBuild(WeepingAngels.MODID, "catacomb"), 1)), -1, -1, true);
    }

}
