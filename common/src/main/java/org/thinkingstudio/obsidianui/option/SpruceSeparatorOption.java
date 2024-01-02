/*
 * Copyright © 2020 LambdAurora <email@lambdaurora.dev>
 *
 * This file is part of SpruceUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.thinkingstudio.obsidianui.option;

import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;
import org.thinkingstudio.obsidianui.Position;
import org.thinkingstudio.obsidianui.widget.SpruceSeparatorWidget;
import org.thinkingstudio.obsidianui.widget.SpruceWidget;

/**
 * Represents a separator option.
 *
 * @author LambdAurora
 * @version 3.0.0
 * @since 1.0.1
 */
public class SpruceSeparatorOption extends SpruceOption {
	private final boolean showTitle;

	public SpruceSeparatorOption(String key, boolean showTitle, @Nullable Text tooltip) {
		super(key);
		this.showTitle = showTitle;
		this.setTooltip(tooltip);
	}

	@Override
	public SpruceWidget createWidget(Position position, int width) {
		var separator = new SpruceSeparatorWidget(position, width, this.showTitle ? Text.translatable(this.key) : null);
		this.getOptionTooltip().ifPresent(separator::setTooltip);
		return separator;
	}
}
