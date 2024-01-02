/*
 * Copyright © 2020 LambdAurora <email@lambdaurora.dev>
 *
 * This file is part of SpruceUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.thinkingstudio.obsidianui.background;

import net.minecraft.client.gui.GuiGraphics;
import org.thinkingstudio.obsidianui.util.ColorUtil;
import org.thinkingstudio.obsidianui.widget.SpruceWidget;

public class SimpleColorBackground implements Background {
	private final int color;

	public SimpleColorBackground(int color) {
		this.color = color;
	}

	public SimpleColorBackground(int red, int green, int blue, int alpha) {
		this(ColorUtil.packARGBColor(red, green, blue, alpha));
	}

	@Override
	public void render(GuiGraphics graphics, SpruceWidget widget, int vOffset, int mouseX, int mouseY, float delta) {
		int x = widget.getX();
		int y = widget.getY();
		graphics.fill(x, y, x + widget.getWidth(), y + widget.getHeight(), this.color);
	}

	@Override
	public String toString() {
		return "SimpleColorBackground{" +
				", color=" + this.color +
				'}';
	}
}
