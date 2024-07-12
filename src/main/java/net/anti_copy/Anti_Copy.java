package net.anti_copy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("anti_copy")
public class Anti_Copy {
    public Anti_Copy() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);
        if (ModList.get().isLoaded("man") || //检测加载模组来禁止对方进入游戏
        ModList.get().isLoaded("annoying_villagers") ||
        ModList.get().isLoaded("annoying_villagersbychentu") ||
        ModList.get().isLoaded("opti_villagers") ||
        ModList.get().isLoaded("gods_dusk") ||
        ModList.get().isLoaded("more_blades_of_god_of_war") ||
        ModList.get().isLoaded("zysr") ||
        ModList.get().isLoaded("minze_mod") ||
        ModList.get().isLoaded("duskofgods") ||
        ModList.get().isLoaded("twilight_of_the_gods") ||
        ModList.get().isLoaded("minzemod") ||
        ModList.get().isLoaded("multiverse_crisis") ||
        ModList.get().isLoaded("multiversecrisis") ||
        ModList.get().isLoaded("brainstorming_villagers")){
        Minecraft.getInstance().stop();
        }
    }
    private void onClientSetup(FMLClientSetupEvent event) { //检测玩家ID或者UUID来禁止对方进入游戏
        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;
        if (player != null) { //你在这里写玩家ID就可以了
            String niakdidj = "niakdidj";
            String pugilist_steve = "Pugilist_Steve";
            String TRUEphase1 = "TRUEphase1";
            String playerUsername = player.getName().getString();//你在这里再copy一下代码就可以了
            if (playerUsername.equals(niakdidj)||
                playerUsername.equals(pugilist_steve)||
                playerUsername.equals(TRUEphase1)){
                mc.stop();
            }
        }
    }
}


