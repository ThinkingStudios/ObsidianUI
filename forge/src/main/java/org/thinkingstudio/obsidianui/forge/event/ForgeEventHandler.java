package org.thinkingstudio.obsidianui.forge.event;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.thinkingstudio.obsidianui.hud.HudManager;

public class ForgeEventHandler {
    public static void registerEvents() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

        forgeEventBus.<RenderGuiOverlayEvent.Post>addListener(EventPriority.HIGHEST, event -> {
            MatrixStack matrixStack = event.getPoseStack();
            float tickDelta = event.getPartialTick();

            HudManager.HUDS.forEach((id, hud) -> {
                if (hud.isEnabled() && hud.isVisible())
                    hud.render(matrixStack, tickDelta);
            });
        });
        forgeEventBus.<TickEvent.ClientTickEvent>addListener(EventPriority.HIGHEST, event -> {
            if (!HudManager.canRenderHuds(MinecraftClient.getInstance()))
                return;
            HudManager.HUDS.forEach((id, hud) -> {
                if (hud.isEnabled() && hud.isVisible() && hud.hasTicks())
                    hud.tick();
            });
        });
        forgeEventBus.<OpenScreenCallbackEvent.Post>addListener(EventPriority.HIGHEST, event -> {
            HudManager.initAll(event.getClient(), event.getClient().getWindow().getScaledWidth(), event.getClient().getWindow().getScaledHeight());
        });
        forgeEventBus.<ResolutionChangeCallbackEvent>addListener(EventPriority.HIGHEST, event -> {
            HudManager.initAll(event.getClient(), event.getClient().getWindow().getScaledWidth(), event.getClient().getWindow().getScaledHeight());
        });
    }
}
