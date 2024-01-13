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

import net.minecraft.client.gui.GuiGraphics;
import org.thinkingstudio.obsidianui.widget.SpruceWidget;

/**
 * Represents an empty border.
 *
 * @author LambdAurora
 * @version 5.0.0
 * @since 2.0.0
 */
public final class EmptyBorder implements Border {
	public static final EmptyBorder EMPTY_BORDER = new EmptyBorder();

	private EmptyBorder() {
	}

	@Override
	public void render(GuiGraphics graphics, SpruceWidget widget, int mouseX, int mouseY, float delta) {
	}

	@Override
	public int getThickness() {
		return 0;
	}

	@Override
	public String toString() {
		return "EmptyBorder{}";
	}
}
