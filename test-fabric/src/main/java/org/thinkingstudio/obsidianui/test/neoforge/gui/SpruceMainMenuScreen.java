/*
 * Copyright © 2020~2024 LambdAurora <email@lambdaurora.dev>
 * Copyright © 2024 ThinkingStudio
 *
 * This file is part of ObsidianUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.thinkingstudio.obsidianui.test.neoforge.gui;

import org.thinkingstudio.obsidianui.Position;
import org.thinkingstudio.obsidianui.SpruceTexts;
import org.thinkingstudio.obsidianui.screen.SpruceScreen;
import org.thinkingstudio.obsidianui.widget.SpruceButtonWidget;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a screen to navigate to the different ObsidianUI test screens.
 *
 * @author LambdAurora
 */
public class SpruceMainMenuScreen extends SpruceScreen {
	private final Screen parent;

	public SpruceMainMenuScreen(@Nullable Screen parent) {
		super(Text.literal("ObsidianUI Test Main Menu"));
		this.parent = parent;
	}

	@Override
	protected void init() {
		super.init();

		int startY = this.height / 4 + 48;
		this.addDrawableChild(new SpruceButtonWidget(Position.of(this, this.width / 2 - 100, startY), 200, 20, Text.literal("Option Test"),
				btn -> this.client.setScreen(new SpruceOptionScreen(this))));
		this.addDrawableChild(new SpruceButtonWidget(Position.of(this, this.width / 2 - 100, startY += 25), 200, 20, Text.literal("Text Area Test"),
				btn -> this.client.setScreen(new SpruceTextAreaScreen(this))));
		this.addDrawableChild(new SpruceButtonWidget(Position.of(this, this.width / 2 - 100, startY += 25), 200, 20, Text.literal("Tabbed Screen Test"),
				btn -> this.client.setScreen(new SpruceTabbedTestScreen(this))));

		// Add done button.
		this.addDrawableChild(new SpruceButtonWidget(Position.of(this, this.width / 2 - 75, this.height - 29), 150, 20, SpruceTexts.GUI_DONE,
				btn -> this.client.setScreen(this.parent)));
	}

	@Override
	public void renderTitle(DrawContext drawContext, int mouseX, int mouseY, float delta) {
		drawContext.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 8, 16777215);
	}
}
