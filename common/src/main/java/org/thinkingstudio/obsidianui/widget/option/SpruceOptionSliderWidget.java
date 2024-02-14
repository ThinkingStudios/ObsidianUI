/*
 * Copyright © 2020~2024 LambdAurora <email@lambdaurora.dev>
 * Copyright © 2024 ThinkingStudio
 *
 * This file is part of SpruceUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.thinkingstudio.obsidianui.widget.option;

import org.thinkingstudio.obsidianui.Position;
import org.thinkingstudio.obsidianui.option.SpruceDoubleOption;
import org.thinkingstudio.obsidianui.widget.SpruceSliderWidget;
import net.minecraft.text.LiteralText;
import org.jetbrains.annotations.NotNull;

/**
 * Represents an option slider widget.
 *
 * @author LambdAurora
 * @version 2.0.0
 * @since 1.0.0
 */
public class SpruceOptionSliderWidget extends SpruceSliderWidget {
    private final SpruceDoubleOption option;

    public SpruceOptionSliderWidget(Position position, int width, int height, @NotNull SpruceDoubleOption option) {
        super(position, width, height, LiteralText.EMPTY, option.getRatio(option.get()), slider -> option.set(option.getValue(slider.getValue())));
        this.option = option;
        this.updateMessage();
    }

    @Override
    protected void updateMessage() {
        if (this.option != null)
            this.setMessage(this.option.getDisplayString());
    }
}
