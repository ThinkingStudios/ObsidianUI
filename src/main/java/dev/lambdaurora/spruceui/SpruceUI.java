package dev.lambdaurora.spruceui;

import dev.architectury.platform.forge.EventBuses;
import dev.architectury.utils.EnvExecutor;
import dev.lambdaurora.spruceui.hud.HudManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkConstants;

@Mod(SpruceUI.MODID)
public class SpruceUI {
    public static final String MODID = "spruceui";

    public SpruceUI() {
        ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> NetworkConstants.IGNORESERVERONLY, (a, b) -> true));
        EventBuses.registerModEventBus(MODID, FMLJavaModLoadingContext.get().getModEventBus());
        EnvExecutor.runInEnv(Dist.CLIENT, () -> this::onInitializeClient);
    }

    public void onInitializeClient() {
        HudManager.initialize();
    }
}
