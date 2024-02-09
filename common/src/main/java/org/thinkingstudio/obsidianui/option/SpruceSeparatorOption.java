/*
 * Copyright © 2020~2024 LambdAurora <email@lambdaurora.dev>
 * Copyright © 2024 ThinkingStudio
 *
 * This file is part of ObsidianUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.thinkingstudio.obsidianui.option;

import org.thinkingstudio.obsidianui.Position;
import org.thinkingstudio.obsidianui.widget.SpruceSeparatorWidget;
import org.thinkingstudio.obsidianui.widget.SpruceWidget;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import org.jetbrains.annotations.Nullable;

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
		var separator = new SpruceSeparatorWidget(position, width, this.showTitle ? new TranslatableText(this.key) : null);
		this.getOptionTooltip().ifPresent(separator::setTooltip);
		return separator;
	}
}
