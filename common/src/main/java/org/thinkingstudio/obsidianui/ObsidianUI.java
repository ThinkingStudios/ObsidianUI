/*
 * Copyright © 2020~2024 LambdAurora <email@lambdaurora.dev>
 * Copyright © 2024 ThinkingStudio
 *
 * This file is part of ObsidianUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.thinkingstudio.obsidianui;

import org.thinkingstudio.obsidianui.hud.HudManager;

public class ObsidianUI {
    public static final String MODID = "obsidianui";

    public static void clientInit() {
        new HudManager().initialize();
    }
}
