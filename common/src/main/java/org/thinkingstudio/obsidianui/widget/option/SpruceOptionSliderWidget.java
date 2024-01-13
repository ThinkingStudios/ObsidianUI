/*
 * Copyright © 2020~2024 LambdAurora <email@lambdaurora.dev>
 * Copyright © 2024 ThinkingStudio
 *
 * This file is part of ObsidianUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.thinkingstudio.obsidianui.widget.option;

import net.minecraft.text.Text;
import org.thinkingstudio.obsidianui.Position;
import org.thinkingstudio.obsidianui.option.SpruceDoubleOption;
import org.thinkingstudio.obsidianui.widget.SpruceSliderWidget;

/**
 * Represents an option slider widget.
 *
 * @author LambdAurora
 * @version 3.3.0
 * @since 1.0.0
 */
public class SpruceOptionSliderWidget extends SpruceSliderWidget {
	private final SpruceDoubleOption option;

	public SpruceOptionSliderWidget(Position position, int width, int height, SpruceDoubleOption option) {
		super(position, width, height, Text.empty(), option.getRatio(option.get()), slider -> option.set(option.getValue(slider.getValue())));
		this.option = option;
		this.updateMessage();
	}

	@Override
	protected void updateMessage() {
		if (this.option != null)
			this.setMessage(this.option.getDisplayString());
	}
}
