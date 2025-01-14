/*
 * Copyright © 2020~2024 LambdAurora <email@lambdaurora.dev>
 * Copyright © 2024 ThinkingStudio
 *
 * This file is part of ObsidianUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.thinkingstudio.obsidianui.wrapper;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.widget.ClickableWidget;
import org.thinkingstudio.obsidianui.navigation.NavigationDirection;
import org.thinkingstudio.obsidianui.widget.AbstractSpruceButtonWidget;
import org.thinkingstudio.obsidianui.widget.SpruceElement;

/**
 * Represents a vanilla button wrapper for ObsidianUI's own button widgets.
 *
 * @author LambdAurora
 * @version 5.0.0
 * @since 2.0.0
 */
@Environment(EnvType.CLIENT)
public class VanillaButtonWrapper extends ClickableWidget implements SpruceElement {
	private final AbstractSpruceButtonWidget widget;

	public VanillaButtonWrapper(AbstractSpruceButtonWidget widget) {
		super(widget.getX(), widget.getY(), widget.getWidth(), widget.getHeight(), widget.getMessage());
		this.widget = widget;
	}

	@Override
	public void renderWidget(DrawContext drawContext, int mouseX, int mouseY, float delta) {
		this.widget.getPosition().setRelativeY(this.getY());
		this.widget.render(drawContext, mouseX, mouseY, delta);
	}

	@Override
	public boolean mouseClicked(double mouseX, double mouseY, int button) {
		return this.widget.mouseClicked(mouseX, mouseY, button);
	}

	@Override
	public boolean mouseReleased(double mouseX, double mouseY, int button) {
		return this.widget.mouseReleased(mouseX, mouseY, button);
	}

	@Override
	public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
		return this.widget.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
	}

	@Override
	public boolean onNavigation(NavigationDirection direction, boolean tab) {
		return this.widget.onNavigation(direction, tab);
	}

	@Override
	public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
		return this.widget.keyPressed(keyCode, scanCode, modifiers);
	}

	@Override
	public boolean keyReleased(final int keyCode, final int scanCode, final int modifiers) {
		return this.widget.keyReleased(keyCode, scanCode, modifiers);
	}

	@Override
	public SelectionType getType() {
		return this.widget.getType();
	}

	@Override
	public void appendClickableNarrations(NarrationMessageBuilder builder) {
		this.widget.appendNarrations(builder);
	}
}
