package dev.lambdaurora.spruceui.forge.event;

import dev.lambdaurora.spruceui.hud.HudManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ForgeClientEventsHandler {
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void clientTickEvent(TickEvent.ClientTickEvent event) {
        if (!HudManager.canRenderHuds(MinecraftClient.getInstance()))
            return;
        HudManager.HUDS.forEach((id, hud) -> {
            if (hud.isEnabled() && hud.isVisible() && hud.hasTicks())
                hud.tick();
        });
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void renderGuiEvent(RenderGuiEvent.Post event) {
        GuiGraphics graphics = event.getGuiGraphics();
        float tickDelta = event.getPartialTick();
        HudManager.HUDS.forEach((id, hud) -> {
            if (hud.isEnabled() && hud.isVisible())
                hud.render(graphics, tickDelta);
        });
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void openScreenEvent(OpenScreenEvent.Post event) {
        HudManager.initAll(event.getClient(), event.getClient().getWindow().getScaledWidth(), event.getClient().getWindow().getScaledHeight());
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void resolutionChangeEvent(ResolutionChangeEvent event) {
        HudManager.initAll(event.getClient(), event.getClient().getWindow().getScaledWidth(), event.getClient().getWindow().getScaledHeight());
    }
}
