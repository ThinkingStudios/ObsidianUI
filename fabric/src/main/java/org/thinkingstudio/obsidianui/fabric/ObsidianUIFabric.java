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
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import org.thinkingstudio.obsidianui.fabric.event.OpenScreenCallback;
import org.thinkingstudio.obsidianui.fabric.event.ResolutionChangeCallback;
import org.thinkingstudio.obsidianui.hud.HudManager;

public class ObsidianUIFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
            HudManager.HUDS.forEach((id, hud) -> {
                if (hud.isEnabled() && hud.isVisible())
                    hud.render(drawContext, tickDelta.getTickDelta(true));
            });
        });
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (!HudManager.canRenderHuds(client))
                return;
            HudManager.HUDS.forEach((id, hud) -> {
                if (hud.isEnabled() && hud.isVisible() && hud.hasTicks())
                    hud.tick();
            });
        });
        OpenScreenCallback.POST.register((client, screen) -> HudManager.initAll(client, client.getWindow().getScaledWidth(), client.getWindow().getScaledHeight()));
        ResolutionChangeCallback.EVENT.register(client -> HudManager.initAll(client, client.getWindow().getScaledWidth(), client.getWindow().getScaledHeight()));
    }
}
