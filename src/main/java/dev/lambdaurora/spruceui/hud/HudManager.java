/*
 * Copyright © 2020 LambdAurora <email@lambdaurora.dev>
 *
 * This file is part of SpruceUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package dev.lambdaurora.spruceui.hud;

import dev.lambdaurora.spruceui.event.OpenScreenEvent;
import dev.lambdaurora.spruceui.event.ResolutionChangeEvent;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.util.Identifier;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

/**
 * Represents the HUD manager.
 *
 * @author LambdAurora
 * @version 3.2.0
 * @since 1.2.0
 */
public class HudManager {
	public static final Map<Identifier, Hud> HUDS = new Object2ObjectOpenHashMap<>();

	public static void initialize() {
		MinecraftForge.EVENT_BUS.addListener(HudManager::clientTickEvent);
		MinecraftForge.EVENT_BUS.addListener(HudManager::renderGuiEvent);
		MinecraftForge.EVENT_BUS.addListener(HudManager::openScreenEvent);
		MinecraftForge.EVENT_BUS.addListener(HudManager::resolutionChangeEvent);
	}

	protected static void initAll(@NotNull MinecraftClient client, int screenWidth, int screenHeight) {
		if (!canRenderHuds(client))
			return;
		HUDS.forEach((id, hud) -> {
			if (hud.isEnabled())
				hud.init(client, screenWidth, screenHeight);
		});
	}

	/**
	 * Registers a HUD.
	 *
	 * @param hud The HUD to register.
	 */
	public static void register(@NotNull Hud hud) {
		if (HUDS.containsKey(hud.getIdentifier()))
			throw new IllegalArgumentException("Cannot register the same HUD twice!");
		HUDS.put(hud.getIdentifier(), hud);
	}

	/**
	 * Unregisters the specified HUD by its identifier.
	 *
	 * @param identifier The HUD to unregister
	 */
	public static void unregister(@NotNull Identifier identifier) {
		HUDS.remove(identifier);
	}

	/**
	 * Unregisters the specified HUD.
	 *
	 * @param hud The HUD to unregister.
	 */
	public static void unregister(@NotNull Hud hud) {
		unregister(hud.getIdentifier());
	}

	/**
	 * Returns whether the HUDs can be rendered or not.
	 *
	 * @param client The client instance.
	 * @return True if the HUDs can be rendered, else false.
	 */
	public static boolean canRenderHuds(@NotNull MinecraftClient client) {
		return client.world != null && (!client.options.hudHidden || client.currentScreen != null);
	}

	/**
	 * Returns the HUD from its identifier.
	 *
	 * @param identifier The identifier of the HUD.
	 * @return The optional HUD.
	 */
	public static Optional<Hud> getHud(@NotNull Identifier identifier) {
		return Optional.ofNullable(HUDS.get(identifier));
	}

	/**
	 * Returns a collection of the registered HUDs.
	 *
	 * @return The registered HUDs.
	 */
	public static Collection<Hud> getHuds() {
		return HUDS.values();
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void clientTickEvent(TickEvent.ClientTickEvent event) {
		if (!canRenderHuds(MinecraftClient.getInstance()))
			return;
		HUDS.forEach((id, hud) -> {
			if (hud.isEnabled() && hud.isVisible() && hud.hasTicks())
				hud.tick();
		});
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void renderGuiEvent(RenderGuiEvent.Post event) {
		GuiGraphics graphics = event.getGuiGraphics();
		float tickDelta = event.getPartialTick();
		HUDS.forEach((id, hud) -> {
			if (hud.isEnabled() && hud.isVisible())
				hud.render(graphics, tickDelta);
		});
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void openScreenEvent(OpenScreenEvent.Post event) {
		initAll(event.getClient(), event.getClient().getWindow().getScaledWidth(), event.getClient().getWindow().getScaledHeight());
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void resolutionChangeEvent(ResolutionChangeEvent event) {
		initAll(event.getClient(), event.getClient().getWindow().getScaledWidth(), event.getClient().getWindow().getScaledHeight());
	}
}
