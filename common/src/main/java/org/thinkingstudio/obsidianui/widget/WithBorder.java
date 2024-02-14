/*
 * Copyright © 2020~2024 LambdAurora <email@lambdaurora.dev>
 * Copyright © 2024 ThinkingStudio
 *
 * This file is part of SpruceUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.thinkingstudio.obsidianui.widget;

import org.thinkingstudio.obsidianui.border.Border;
import org.thinkingstudio.obsidianui.border.EmptyBorder;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a widget with a border.
 *
 * @author LambdAurora
 * @version 2.0.0
 * @since 2.0.0
 */
public interface WithBorder {
    /**
     * Returns whether this widget has a border or not.
     *
     * @return {@code true} if this widget has a border, else {@code false}.
     */
    default boolean hasBorder() {
        return this.getBorder().getThickness() != 0 && this.getBorder() != EmptyBorder.EMPTY_BORDER;
    }

    /**
     * Gets the border of this widget.
     *
     * @return the border
     */
    @NotNull Border getBorder();

    /**
     * Sets the border of this widget.
     *
     * @param border the border
     */
    void setBorder(@NotNull Border border);
}
