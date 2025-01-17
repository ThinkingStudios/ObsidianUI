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

import net.minecraft.client.gui.DrawContext;
import org.thinkingstudio.obsidianui.widget.SpruceWidget;

/**
 * Represents an empty background.
 *
 * @author LambdAurora
 * @version 5.0.0
 * @since 2.0.0
 */
public final class EmptyBackground implements Background {
	public static final EmptyBackground EMPTY_BACKGROUND = new EmptyBackground();

	private EmptyBackground() {
	}

	@Override
	public void render(DrawContext drawContext, SpruceWidget widget, int vOffset, int mouseX, int mouseY, float delta) {
	}

	@Override
	public String toString() {
		return "EmptyBackground{}";
	}
}
