package org.thinkingstudio.obsidianui.neoforge.event;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.RenderGuiOverlayEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.TickEvent;
import org.thinkingstudio.obsidianui.hud.HudManager;

public class ForgeEventHandler {
    public static void registerEvents(IEventBus modEventBus) {
        IEventBus forgeEventBus = NeoForge.EVENT_BUS;

        forgeEventBus.addListener(EventPriority.HIGHEST, RenderGuiOverlayEvent.Post.class,event -> {
            DrawContext drawContext = event.getGuiGraphics();
            float tickDelta = event.getPartialTick();

            HudManager.HUDS.forEach((id, hud) -> {
                if (hud.isEnabled() && hud.isVisible())
                    hud.render(drawContext, tickDelta);
            });
        });
        forgeEventBus.addListener(EventPriority.HIGHEST, TickEvent.ClientTickEvent.class,event -> {
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
