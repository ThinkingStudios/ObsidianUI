/*
 * Copyright © 2020~2024 LambdAurora <email@lambdaurora.dev>
 * Copyright © 2024 ThinkingStudio
 *
 * This file is part of ObsidianUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.thinkingstudio.obsidianui.fabric;

import net.fabricmc.api.ClientModInitializer;
import org.thinkingstudio.obsidianui.ObsidianUI;

public class ObsidianUIFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ObsidianUI.clientInit();
    }
}
