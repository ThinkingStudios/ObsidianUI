/*
 * Copyright © 2020~2024 LambdAurora <email@lambdaurora.dev>
 * Copyright © 2024 ThinkingStudio
 *
 * This file is part of ObsidianUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.thinkingstudio.obsidianui;

/**
 * Generic interface representing an object that provides a screen position.
 *
 * @author LambdAurora
 * @version 3.0.0
 * @since 1.4.0
 */
public interface SprucePositioned {
	/**
	 * Returns the X coordinate.
	 *
	 * @return the X coordinate
	 */
	default int getX() {
		return 0;
	}

	/**
	 * Returns the Y coordinate.
	 *
	 * @return the Y coordinate
	 */
	default int getY() {
		return 0;
	}
}
