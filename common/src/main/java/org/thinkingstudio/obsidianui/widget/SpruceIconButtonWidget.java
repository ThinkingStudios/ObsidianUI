/*
 * Copyright © 2020 LambdAurora <email@lambdaurora.dev>
 *
 * This file is part of SpruceUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.thinkingstudio.obsidianui.widget;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.text.Text;
import org.thinkingstudio.obsidianui.Position;

public class SpruceIconButtonWidget extends AbstractSpruceIconButtonWidget {
	public SpruceIconButtonWidget(Position position, int width, int height, Text message, PressAction action) {
		super(position, width, height, message, action);
	}

	/**
	 * Renders the icon of the button.
	 *
	 * @return the x-offset the icon creates
	 */
	protected int renderIcon(GuiGraphics graphics, int mouseX, int mouseY, float delta) {
		return 0;
	}
}
