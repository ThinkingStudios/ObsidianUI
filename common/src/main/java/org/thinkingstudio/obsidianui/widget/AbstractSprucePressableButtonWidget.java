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

import org.thinkingstudio.obsidianui.Position;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.glfw.GLFW;

/**
 * Represents a pressable button widget.
 *
 * @author LambdAurora
 * @version 2.0.0
 * @since 2.0.0
 */
public abstract class AbstractSprucePressableButtonWidget extends AbstractSpruceButtonWidget {
    public AbstractSprucePressableButtonWidget(@NotNull Position position, int width, int height, @NotNull Text message) {
        super(position, width, height, message);
    }

    public abstract void onPress();

    @Override
    public void onClick(double mouseX, double mouseY) {
        this.onPress();
        this.playDownSound();
    }

    @Override
    protected boolean onKeyPress(int keyCode, int scanCode, int modifiers) {
        if (keyCode == GLFW.GLFW_KEY_ENTER || keyCode == GLFW.GLFW_KEY_KP_ENTER) {
            this.onPress();
            this.playDownSound();
            return true;
        }
        return false;
    }
}
