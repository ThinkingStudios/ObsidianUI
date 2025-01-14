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

import net.minecraft.client.gui.Element;
import org.thinkingstudio.obsidianui.navigation.NavigationDirection;

/**
 * Represents an element with navigation and controller input implementation.
 *
 * @author LambdAurora
 * @version 3.0.0
 * @since 2.0.0
 */
public interface SpruceElement extends Element {
	/**
	 * Called when navigating in the menu.
	 *
	 * @param direction direction of navigation
	 * @param tab {@code true} if the navigation was triggered by the tab key, else {@code false}
	 * @return {@code true} if success, else {@code false}
	 */
	default boolean onNavigation(NavigationDirection direction, boolean tab) {
		if (this.requiresCursor()) return false;
		if (direction.isVertical()) {
			this.setFocused(direction == NavigationDirection.DOWN);
			return true;
		}
		return false;
	}

	/**
	 * Returns whether this is element requires a cursor to be used.
	 *
	 * @return {@code true} if a cursor is required, else {@code false}
	 */
	default boolean requiresCursor() {
		return false;
	}
}
