/*
 * Copyright © 2020~2024 LambdAurora <email@lambdaurora.dev>
 * Copyright © 2024 ThinkingStudio
 *
 * This file is part of ObsidianUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.thinkingstudio.obsidianui.neoforge.event;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.neoforge.common.NeoForge;
import org.thinkingstudio.obsidianui.hud.HudManager;

public class ForgeEventHandler {
    public static void registerEvents(IEventBus modEventBus) {
        IEventBus forgeEventBus = NeoForge.EVENT_BUS;

        forgeEventBus.addListener(EventPriority.HIGHEST, RenderGuiEvent.Post.class, event -> {
            DrawContext drawContext = event.getGuiGraphics();
            float tickDelta = event.getPartialTick();

            HudManager.HUDS.forEach((id, hud) -> {
                if (hud.isEnabled() && hud.isVisible())
                    hud.render(drawContext, tickDelta);
            });
        });
        forgeEventBus.addListener(EventPriority.HIGHEST, ClientTickEvent.class, event -> {
            if (!HudManager.canRenderHuds(MinecraftClient.getInstance()))
                return;
            HudManager.HUDS.forEach((id, hud) -> {
                if (hud.isEnabled() && hud.isVisible() && hud.hasTicks())
                    hud.tick();
            });
        });
        forgeEventBus.addListener(EventPriority.HIGHEST, OpenScreenCallbackEvent.Post.class,event -> {
            HudManager.initAll(event.getClient(), event.getClient().getWindow().getScaledWidth(), event.getClient().getWindow().getScaledHeight());
        });
        forgeEventBus.addListener(EventPriority.HIGHEST, ResolutionChangeCallbackEvent.class,event -> {
            HudManager.initAll(event.getClient(), event.getClient().getWindow().getScaledWidth(), event.getClient().getWindow().getScaledHeight());
        });
    }
}
