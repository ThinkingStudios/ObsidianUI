package org.thinkingstudio.obsidianui;

import org.thinkingstudio.obsidianui.hud.HudManager;

public class ObsidianUI {
    public static final String MODID = "obsidianui";

    public static void clientInit() {
        new HudManager().initialize();
    }
}
