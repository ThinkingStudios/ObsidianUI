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

import net.minecraft.client.MinecraftClient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.neoforge.common.NeoForge;
import org.thinkingstudio.obsidianui.ObsidianUI;
import org.thinkingstudio.obsidianui.hud.HudManager;
import org.thinkingstudio.obsidianui.neoforge.event.OpenScreenCallbackEvent;
import org.thinkingstudio.obsidianui.neoforge.event.ResolutionChangeCallbackEvent;

@Mod(value = ObsidianUI.MODID, dist = Dist.CLIENT)
public class ObsidianUINeoForge {
    public ObsidianUINeoForge() {
        IEventBus forgeEventBus = NeoForge.EVENT_BUS;

        if (FMLLoader.getDist().isClient()) {
            forgeEventBus.addListener(EventPriority.HIGHEST, RenderGuiEvent.Post.class, event -> {
                var drawContext = event.getGuiGraphics();
                var tickDelta = event.getPartialTick();

                HudManager.HUDS.forEach((id, hud) -> {
                    if (hud.isEnabled() && hud.isVisible())
                        hud.render(drawContext, tickDelta);
                });
            });
            forgeEventBus.addListener(EventPriority.HIGHEST, ClientTickEvent.Post.class, event -> {
                if (!HudManager.canRenderHuds(MinecraftClient.getInstance()))
                    return;
                HudManager.HUDS.forEach((id, hud) -> {
                    if (hud.isEnabled() && hud.isVisible() && hud.hasTicks())
                        hud.tick();
                });
            });
            forgeEventBus.addListener(EventPriority.HIGHEST, OpenScreenCallbackEvent.Post.class, event -> {
                HudManager.initAll(event.getClient(), event.getClient().getWindow().getScaledWidth(), event.getClient().getWindow().getScaledHeight());
            });
            forgeEventBus.addListener(EventPriority.HIGHEST, ResolutionChangeCallbackEvent.class, event -> {
                HudManager.initAll(event.getClient(), event.getClient().getWindow().getScaledWidth(), event.getClient().getWindow().getScaledHeight());
            });
        }
    }
}
