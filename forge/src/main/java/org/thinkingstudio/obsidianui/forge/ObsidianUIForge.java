/*
 * Copyright © 2020~2024 LambdAurora <email@lambdaurora.dev>
 * Copyright © 2024 ThinkingStudio
 *
 * This file is part of ObsidianUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.thinkingstudio.obsidianui.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.network.NetworkConstants;
import org.thinkingstudio.obsidianui.ObsidianUI;

@Mod(ObsidianUI.MODID)
public class ObsidianUIForge {
    public ObsidianUIForge() {
        EventBuses.registerModEventBus(ObsidianUI.MODID, FMLJavaModLoadingContext.get().getModEventBus());
        ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> NetworkConstants.IGNORESERVERONLY, (a, b) -> true));
        if (FMLLoader.getDist().isClient()) {
            ObsidianUI.clientInit();
        }
    }
}
