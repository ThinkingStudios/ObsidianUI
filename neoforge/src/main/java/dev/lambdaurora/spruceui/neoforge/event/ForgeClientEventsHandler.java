package dev.lambdaurora.spruceui.neoforge.event;

import dev.lambdaurora.spruceui.hud.HudManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.GuiGraphics;
import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.TickEvent;

public class ForgeClientEventsHandler {
    public static void initialize() {
        NeoForge.EVENT_BUS.addListener(TickEvent.ClientTickEvent.class, event -> {
            if (!HudManager.canRenderHuds(MinecraftClient.getInstance()))
                return;
            HudManager.HUDS.forEach((id, hud) -> {
                if (hud.isEnabled() && hud.isVisible() && hud.hasTicks())
                    hud.tick();
            });
        });
        NeoForge.EVENT_BUS.addListener(RenderGuiEvent.Post.class, event -> {
            GuiGraphics graphics = event.getGuiGraphics();
            float tickDelta = event.getPartialTick();
            HudManager.HUDS.forEach((id, hud) -> {
                if (hud.isEnabled() && hud.isVisible())
                    hud.render(graphics, tickDelta);
            });
        });
        NeoForge.EVENT_BUS.addListener(OpenScreenEvent.Post.class, event -> {
            HudManager.initAll(event.getClient(), event.getClient().getWindow().getScaledWidth(), event.getClient().getWindow().getScaledHeight());
        });
        NeoForge.EVENT_BUS.addListener(ResolutionChangeEvent.class, event -> {
            HudManager.initAll(event.getClient(), event.getClient().getWindow().getScaledWidth(), event.getClient().getWindow().getScaledHeight());
        });
    }
}
