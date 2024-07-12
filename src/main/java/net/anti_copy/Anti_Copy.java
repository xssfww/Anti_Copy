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
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();//这里是注册事件监听器的，不要乱碰。
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);
        if (//检测加载模组来禁止对方进入游戏
        ModList.get().isLoaded("kobe") || //牢大
        ModList.get().isLoaded("man") || //雾中人
        ModList.get().isLoaded("annoying_villagers") || //拳史烦村
        ModList.get().isLoaded("annoying_villagersbychentu") || //尘土烦村（已经是拳史的了）
        ModList.get().isLoaded("opti_villagers") || //Opti烦村（材质方面拉满，其他不好说）
        ModList.get().isLoaded("gods_dusk") || //诸神黄昏（小屿）
        ModList.get().isLoaded("more_blades_of_god_of_war") || //更多战神之刃（小屿）
        ModList.get().isLoaded("zysr") || //烦村（水星兽）
        ModList.get().isLoaded("minze_mod") || //诸神之战
        ModList.get().isLoaded("duskofgods") || //诸神黄昏
        ModList.get().isLoaded("twilight_of_the_gods") || //诸神黄昏
        ModList.get().isLoaded("minzemod") || //诸神之战
        ModList.get().isLoaded("multiverse_crisis") || //多元宇宙灾难（烦村概念性武器）
        ModList.get().isLoaded("multiversecrisis") || //多元宇宙灾难（烦村概念性武器）
        ModList.get().isLoaded("brainstorming_villagers") //恼人的村民（大仙）
        ){
        Minecraft.getInstance().stop(); //爆！芜湖我滴原子弹回来辣。
        }
    }
    private void onClientSetup(FMLClientSetupEvent event) { //检测玩家ID来禁止对方进入游戏
        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;
        if (player != null) { //你在这里写玩家ID就可以了
            String pugilist_steve = "Pugilist_Steve";//拳史大蛇
            String MuFengDaShe = "mufengyes";//沐枫外传大蛇
            String playerUsername = player.getName().getString();//你在这里再copy一下代码就可以了
            if (
                playerUsername.equals(pugilist_steve)||
                playerUsername.equals(MuFengDaShe)
               ){
                mc.stop();//爆！芜湖我滴原子弹回来辣。
            }
        }
    }
}


