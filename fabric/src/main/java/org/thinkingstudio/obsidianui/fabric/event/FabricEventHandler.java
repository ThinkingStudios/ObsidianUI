package org.thinkingstudio.obsidianui.fabric.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import org.thinkingstudio.obsidianui.hud.HudManager;

public class FabricEventHandler {
    public static void registerEvents() {
        HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
            HudManager.HUDS.forEach((id, hud) -> {
                if (hud.isEnabled() && hud.isVisible())
                    hud.render(drawContext, tickDelta);
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
