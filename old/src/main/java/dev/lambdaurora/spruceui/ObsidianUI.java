package dev.lambdaurora.spruceui;

import dev.lambdaurora.spruceui.hud.HudManager;
import net.neoforged.fml.IExtensionPoint;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.network.NetworkConstants;

@Mod(ObsidianUI.MODID)
public class ObsidianUI {
    public static final String MODID = "obsidianui";

    public ObsidianUI() {
        ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> NetworkConstants.IGNORESERVERONLY, (a, b) -> true));
        if (FMLLoader.getDist().isClient()) {
            new HudManager().initialize();
        }
    }
}
