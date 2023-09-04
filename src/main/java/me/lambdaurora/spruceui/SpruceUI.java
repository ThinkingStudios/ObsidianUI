package me.lambdaurora.spruceui;

import me.lambdaurora.spruceui.hud.HudManager;
import me.shedaniel.architectury.utils.EnvExecutor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.FMLNetworkConstants;
import org.apache.commons.lang3.tuple.Pair;

@Mod(SpruceUI.MODID)
public class SpruceUI {
    public static final String MODID = "spruceui";

    public SpruceUI() {
        ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.DISPLAYTEST, () -> Pair.of(() -> FMLNetworkConstants.IGNORESERVERONLY, (a, b) -> true));
        EnvExecutor.runInEnv(Dist.CLIENT, () -> this::onInitializeClient);
    }

    public void onInitializeClient() {
        HudManager.initialize();
    }
}
