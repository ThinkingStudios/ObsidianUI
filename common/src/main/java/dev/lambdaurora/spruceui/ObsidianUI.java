package dev.lambdaurora.spruceui;

import dev.lambdaurora.spruceui.hud.HudManager;

public class ObsidianUI {
    public static final String MODID = "obsidianui";

    public static void clientInit() {
        new HudManager().initialize();
    }
}
