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

import org.thinkingstudio.obsidianui.widget.SpruceWidget;
import net.minecraft.client.util.math.MatrixStack;

/**
 * Represents a background which can be rendered on a widget.
 *
 * @author LambdAurora
 * @version 3.0.0
 * @since 2.0.0
 */
public interface Background {
	void render(MatrixStack matrices, SpruceWidget widget, int vOffset, int mouseX, int mouseY, float delta);
}
