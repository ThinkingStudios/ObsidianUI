/*
 * Copyright © 2020~2024 LambdAurora <email@lambdaurora.dev>
 * Copyright © 2024 ThinkingStudio
 *
 * This file is part of ObsidianUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.thinkingstudio.obsidianui.border;

import net.minecraft.client.gui.DrawContext;
import org.thinkingstudio.obsidianui.util.ColorUtil;
import org.thinkingstudio.obsidianui.widget.SpruceWidget;

import java.util.Arrays;

/**
 * Represents a simple solid border to draw around a widget.
 *
 * @author LambdAurora
 * @version 5.0.0
 * @since 2.0.0
 */
public final class SimpleBorder implements Border {
	public static final SimpleBorder SIMPLE_BORDER = new SimpleBorder(1, 192, 192, 192, 255);

	private final int thickness;
	private final int color;
	private final int focusedColor;

	public SimpleBorder(int thickness, int color) {
		this(thickness, color, color);
	}

	public SimpleBorder(int thickness, int color, int focusedColor) {
		this.thickness = thickness;
		this.color = color;
		this.focusedColor = focusedColor;
	}

	public SimpleBorder(int thickness, int red, int green, int blue, int alpha) {
		this(thickness, red, green, blue, alpha, red, green, blue, alpha);
	}

	public SimpleBorder(int thickness, int red, int green, int blue, int alpha, int focusedRed, int focusedGreen, int focusedBlue, int focusedAlpha) {
		this.thickness = thickness;
		this.color = ColorUtil.packARGBColor(red, green, blue, alpha);
		this.focusedColor = ColorUtil.packARGBColor(focusedRed, focusedGreen, focusedBlue, focusedAlpha);
	}

	@Override
	public void render(DrawContext context, SpruceWidget widget, int mouseX, int mouseY, float delta) {
		int x = widget.getX();
		int y = widget.getY();
		int right = x + widget.getWidth();
		int bottom = y + widget.getHeight();
		boolean focused = widget.isFocused();
		int color = focused ? this.focusedColor : this.color;
		// Top border
		context.fill(x, y, right, y + thickness, color);
		// Right border
		context.fill(right - thickness, y, right, bottom, color);
		// Bottom
		context.fill(x, bottom - thickness, right, bottom, color);
		// Left border
		context.fill(x, y, x + thickness, bottom, color);
	}

	@Override
	public int getThickness() {
		return this.thickness;
	}

	@Override
	public String toString() {
		return "SimpleBorder{" +
				"thickness=" + this.thickness +
				", color=" + Arrays.toString(ColorUtil.unpackARGBColor(this.color)) +
				", focusedColor=" + Arrays.toString(ColorUtil.unpackARGBColor(this.focusedColor)) +
				'}';
	}
}
