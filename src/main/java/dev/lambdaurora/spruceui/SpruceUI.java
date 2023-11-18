package dev.lambdaurora.spruceui;

import dev.lambdaurora.spruceui.hud.HudManager;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.IExtensionPoint;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.network.NetworkConstants;

@Mod(SpruceUI.MODID)
public class SpruceUI {
    public static final String MODID = "obsidianui";
    public static final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    public SpruceUI() {
        ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> NetworkConstants.IGNORESERVERONLY, (a, b) -> true));
        if (FMLLoader.getDist().isClient()) {
            this.onInitializeClient();
        }
    }

    public void onInitializeClient() {
        HudManager.initialize();
    }
}
