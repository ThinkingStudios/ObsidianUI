package dev.lambdaurora.spruceui;

import dev.architectury.utils.EnvExecutor;
import dev.lambdaurora.spruceui.hud.HudManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod(SpruceUI.MODID)
public class SpruceUI {
    public static final String MODID = "spruceui";

    public SpruceUI() {
        EnvExecutor.runInEnv(Dist.CLIENT, () -> this::onInitializeClient);
    }

    public void onInitializeClient() {
        HudManager.initialize();
    }
}
