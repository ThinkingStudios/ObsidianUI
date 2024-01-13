/*
 * Copyright © 2020~2024 LambdAurora <email@lambdaurora.dev>
 * Copyright © 2024 ThinkingStudio
 *
 * This file is part of ObsidianUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.thinkingstudio.obsidianui.background;

import net.minecraft.client.gui.GuiGraphics;
import org.thinkingstudio.obsidianui.util.RenderUtil;
import org.thinkingstudio.obsidianui.widget.SpruceWidget;

public record DirtTexturedBackground(int red, int green, int blue, int alpha) implements Background {
	public static final Background NORMAL = new DirtTexturedBackground(64, 64, 64, 255);
	public static final Background DARKENED = new DirtTexturedBackground(32, 32, 32, 255);

	@Override
	public void render(GuiGraphics graphics, SpruceWidget widget, int vOffset, int mouseX, int mouseY, float delta) {
		RenderUtil.renderBackgroundTexture(widget.getX(), widget.getY(), widget.getWidth(), widget.getHeight(),
				vOffset / 32.f, this.red, this.green, this.blue, this.alpha);
	}

	@Override
	public String toString() {
		return "DirtTexturedBackground{" +
				"red=" + this.red +
				", green=" + this.green +
				", blue=" + this.blue +
				", alpha=" + this.alpha +
				'}';
	}
}
