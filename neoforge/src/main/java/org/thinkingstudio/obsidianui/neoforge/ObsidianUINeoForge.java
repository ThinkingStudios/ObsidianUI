/*
 * Copyright © 2020~2024 LambdAurora <email@lambdaurora.dev>
 * Copyright © 2024 ThinkingStudio
 *
 * This file is part of ObsidianUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.thinkingstudio.obsidianui.neoforge;

import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLLoader;
import org.thinkingstudio.obsidianui.ObsidianUI;

@Mod(ObsidianUI.MODID)
public class ObsidianUINeoForge {
    public ObsidianUINeoForge() {
        if (FMLLoader.getDist().isClient()) {
            ObsidianUI.clientInit();
        }
    }
}
