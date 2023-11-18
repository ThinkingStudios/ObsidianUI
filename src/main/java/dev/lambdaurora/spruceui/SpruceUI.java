package dev.lambdaurora.spruceui;

import dev.lambdaurora.spruceui.hud.HudManager;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLLoader;

@Mod(SpruceUI.MODID)
public class SpruceUI {
    public static final String MODID = "obsidianui";
    public static final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

    public SpruceUI() {
        ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> IExtensionPoint.DisplayTest.IGNORESERVERONLY, (a, b) -> true));
        if (FMLLoader.getDist().isClient()) {
            this.onInitializeClient();
        }
    }

    public void onInitializeClient() {
        HudManager.initialize();
    }
}
