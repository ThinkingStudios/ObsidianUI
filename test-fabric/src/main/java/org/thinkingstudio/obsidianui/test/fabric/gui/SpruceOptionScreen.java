/*
 * Copyright © 2020~2024 LambdAurora <email@lambdaurora.dev>
 * Copyright © 2024 ThinkingStudio
 *
 * This file is part of ObsidianUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.thinkingstudio.obsidianui.test.fabric.gui;

import org.thinkingstudio.obsidianui.Position;
import org.thinkingstudio.obsidianui.SpruceTexts;
import org.thinkingstudio.obsidianui.option.SpruceOption;
import org.thinkingstudio.obsidianui.screen.SpruceScreen;
import org.thinkingstudio.obsidianui.test.fabric.ObsidianUITestFabric;
import org.thinkingstudio.obsidianui.widget.SpruceButtonWidget;
import org.thinkingstudio.obsidianui.widget.container.SpruceOptionListWidget;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a screen to test the different {@link SpruceOption} classes.
 *
 * @author LambdAurora
 */
public class SpruceOptionScreen extends SpruceScreen {
	private final Screen parent;

	//private ButtonListWidget list;
	private SpruceOptionListWidget list;

	public SpruceOptionScreen(@Nullable Screen parent) {
		super(Text.literal("ObsidianUI Test Option Menu"));
		this.parent = parent;
	}

	private int getTextHeight() {
		return (5 + this.textRenderer.fontHeight) * 3 + 5;
	}

	@Override
	protected void init() {
		super.init();

		// Button list.
		//this.list = new ButtonListWidget(this.client, this.width, this.height, 43, this.height - 29 - this.getTextHeight(), 25);
		this.list = ObsidianUITestFabric.get().buildOptionList(Position.of(0, 22), this.width, this.height - 35 - 22);
		ObsidianUITestFabric.get().resetConsumer = btn -> {
			// Re-initialize the screen to update all the values.
			this.init(this.client, this.client.getWindow().getScaledWidth(), this.client.getWindow().getScaledHeight());
		};

		this.addDrawableChild(this.list);

		// Add reset button. You can add option buttons outside a button list widget. GameOptions instance is required because of Vanilla limitations.
		//this.addButton(this.resetOption.createButton(this.client.options, this.width / 2 - 155, this.height - 29, 150));
		// Add done button.
		this.addDrawableChild(new SpruceButtonWidget(Position.of(this, this.width / 2 - 155 + 160, this.height - 29), 150, 20, SpruceTexts.GUI_DONE,
				btn -> this.client.setScreen(this.parent)).asVanilla());
	}

	@Override
	public void renderTitle(DrawContext drawContext, int mouseX, int mouseY, float delta) {
		drawContext.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 8, 16777215);
	}
}
