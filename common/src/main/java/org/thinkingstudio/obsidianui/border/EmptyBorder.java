/*
 * Copyright © 2020~2024 LambdAurora <email@lambdaurora.dev>
 * Copyright © 2024 ThinkingStudio
 *
 * This file is part of SpruceUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.thinkingstudio.obsidianui.border;

import org.thinkingstudio.obsidianui.widget.SpruceWidget;
import net.minecraft.client.util.math.MatrixStack;

/**
 * Represents an empty border.
 *
 * @author LambdAurora
 * @version 2.0.0
 * @since 2.0.0
 */
public final class EmptyBorder extends Border {
    public static final EmptyBorder EMPTY_BORDER = new EmptyBorder();

    private EmptyBorder() {
    }

    @Override
    public void render(MatrixStack matrices, SpruceWidget widget, int mouseX, int mouseY, float delta) {
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
