/*
 * Copyright © 2020~2024 LambdAurora <email@lambdaurora.dev>
 * Copyright © 2024 ThinkingStudio
 *
 * This file is part of SpruceUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.thinkingstudio.obsidianui;

import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

/**
 * Represents an object which can show a tooltip.
 *
 * @author LambdAurora
 * @version 2.0.0
 * @since 1.0.0
 */
public interface Tooltipable {
    /**
     * Gets the tooltip.
     *
     * @return the tooltip to show
     */
    @NotNull Optional<Text> getTooltip();

    /**
     * Sets the tooltip.
     *
     * @param tooltip the tooltip to show
     */
    void setTooltip(@Nullable Text tooltip);
}
