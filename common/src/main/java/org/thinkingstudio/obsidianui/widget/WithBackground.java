/*
 * Copyright © 2020~2024 LambdAurora <email@lambdaurora.dev>
 * Copyright © 2024 ThinkingStudio
 *
 * This file is part of ObsidianUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.thinkingstudio.obsidianui.widget;

import org.thinkingstudio.obsidianui.background.Background;

/**
 * Represents a widget with a background.
 *
 * @author LambdAurora
 * @version 3.3.0
 * @since 2.0.0
 */
public interface WithBackground {
	/**
	 * Returns the background of this widget.
	 *
	 * @return the background
	 */
	Background getBackground();

	/**
	 * Sets the background of this widget.
	 *
	 * @param background the background
	 */
	void setBackground(Background background);
}
