package dev.lambdaurora.spruceui;

import dev.lambdaurora.spruceui.hud.HudManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;

@Mod(SpruceUI.MODID)
public class SpruceUI {
    public static final String MODID = "spruceui";

    public SpruceUI() {
        ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> MODID, (a, b) -> true));
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> this::onInitializeClient);
    }

    public void onInitializeClient() {
        MinecraftForge.EVENT_BUS.addListener(HudManager::renderGameOverlayEvent);
        MinecraftForge.EVENT_BUS.addListener(HudManager::clientTickEvent);
        HudManager.initialize();
    }
}
