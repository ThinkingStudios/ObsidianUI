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
import org.thinkingstudio.obsidianui.widget.SpruceWidget;

/**
 * Represents a border to draw around a widget.
 *
 * @author LambdAurora
 * @version 5.0.0
 * @since 2.0.0
 */
public interface Border {
	void render(DrawContext drawContext, SpruceWidget widget, int mouseX, int mouseY, float delta);

	/**
	 * Returns the thickness of the border.
	 *
	 * @return the thickness
	 */
	int getThickness();
}
