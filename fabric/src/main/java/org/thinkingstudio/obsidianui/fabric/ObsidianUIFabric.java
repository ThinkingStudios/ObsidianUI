package org.thinkingstudio.obsidianui.fabric;

import net.fabricmc.api.ClientModInitializer;
import org.thinkingstudio.obsidianui.ObsidianUI;

public class ObsidianUIFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ObsidianUI.clientInit();
    }
}
