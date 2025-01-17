/*
 * Copyright © 2020~2024 LambdAurora <email@lambdaurora.dev>
 * Copyright © 2024 ThinkingStudio
 *
 * This file is part of ObsidianUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.thinkingstudio.obsidianui.hud;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.thinkingstudio.obsidianui.util.Identifiable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Represents a HUD.
 *
 * @author LambdAurora
 * @version 5.0.0
 * @since 1.2.0
 */
public abstract class Hud implements Identifiable {
	protected final Identifier identifier;
	protected final List<HudComponent> components = new ArrayList<>();
	protected final String translationKey;
	private boolean enabled = true;
	protected boolean visible = true;

	public Hud(@NotNull Identifier id) {
		this.identifier = id;
		this.translationKey = this.identifier.getNamespace() + ".hud." + this.identifier.getPath()
				.replace('/', '.');
	}

	/**
	 * Returns the translation key of this HUD.
	 *
	 * @return The translation key.
	 */
	public String getTranslationKey() {
		return this.translationKey;
	}

	/**
	 * Returns whether the HUD is enabled or not.
	 *
	 * @return True if the HUD is enabled, else false.
	 */
	public boolean isEnabled() {
		return this.enabled;
	}

	/**
	 * Sets whether the HUD is enabled or not.
	 *
	 * @param enabled True if the HUD is enabled, else false.
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
		if (enabled) {
			MinecraftClient client = MinecraftClient.getInstance();
			this.init(client, client.getWindow().getScaledWidth(), client.getWindow().getScaledHeight());
		}
	}

	/**
	 * Returns whether the HUD is visible or not.
	 *
	 * @return True if the HUD is visible, else false.
	 */
	public boolean isVisible() {
		return this.visible;
	}

	/**
	 * Sets whether the HUD is visible or not.
	 *
	 * @param visible True if the HUD is visible, else false.
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public void init(@NotNull MinecraftClient client, int screenWidth, int screenHeight) {
		this.components.clear();
	}

	/**
	 * Renders the HUD if enabled.
	 *
	 * @param tickDelta Progress for linearly interpolating between the previous and current game state.
	 * @see #isEnabled()
	 */
	public void render(DrawContext drawContext, RenderTickCounter tickDelta) {
		this.components.stream().filter(HudComponent::isEnabled).forEach(component -> component.render(drawContext, tickDelta));
	}

	/**
	 * Updates the HUD each tick if enabled and has tick updates.
	 *
	 * @see #isEnabled()
	 * @see #hasTicks()
	 */
	public void tick() {
		this.components.stream().filter(((Predicate<HudComponent>) HudComponent::hasTicks).and(HudComponent::isEnabled))
				.forEach(HudComponent::tick);
	}

	/**
	 * Returns whether this HUD has tick updates.
	 *
	 * @return True if this HUD has tick updates, else false.
	 * @see #tick()
	 */
	public boolean hasTicks() {
		return false;
	}

	/**
	 * Returns a list of this HUD's components.
	 *
	 * @return The HUD's components.
	 */
	public @NotNull List<HudComponent> getComponents() {
		return ImmutableList.copyOf(this.components);
	}

	@Override
	public @NotNull Identifier getIdentifier() {
		return this.identifier;
	}
}
