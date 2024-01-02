package org.thinkingstudio.obsidianui.fabric;

import net.fabricmc.api.ModInitializer;
import org.thinkingstudio.obsidianui.ObsidianUI;

public class ObsidianUIFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ObsidianUI.clientInit();
    }
}
