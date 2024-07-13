package net.anti_copy;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import java.util.UUID;
@Mod("anti_copy")
public class Anti_Copy {
    public Anti_Copy() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.addListener(PlayerLoggedInHandler::onLoggedIn);
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
    public static class PlayerLoggedInHandler {
        public static void onLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
            String MuFengDaShe = "mufengyes";//沐枫外传大蛇
            String PG = "Pugilist_Steve";//拳史大蛇
            UUID pugilist_steve = UUID.fromString("e4bae6c7-d1ab-489a-b20b-c0e87b19f50a");//拳史正版
            String playerUsername = event.getPlayer().getName().getString();
            UUID playerUUID = event.getPlayer().getUUID();
                if (playerUUID.equals(pugilist_steve) ||
                    playerUsername.equals(PG) ||
                    playerUsername.equals(MuFengDaShe)) {
                if (event.getPlayer() instanceof ServerPlayer) {
                    ServerPlayer serverPlayer = (ServerPlayer) event.getPlayer();
                    serverPlayer.connection.disconnect(new TextComponent("牢底，上黑名单舒服吗？"));
                } else {
                    Minecraft.getInstance().stop();//爆！芜湖我滴原子弹回来辣。
                }
            }
        }
    }
}
