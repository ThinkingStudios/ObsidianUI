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
import org.thinkingstudio.obsidianui.screen.SpruceScreen;
import org.thinkingstudio.obsidianui.test.fabric.ObsidianUITestFabric;
import org.thinkingstudio.obsidianui.widget.text.SpruceTextAreaWidget;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a screen to test the {@link SpruceTextAreaWidget} widget.
 *
 * @author LambdAurora
 */
public class SpruceTextAreaScreen extends SpruceScreen {
	private final Screen parent;
	private SpruceTextAreaWidget textArea;

	public SpruceTextAreaScreen(@Nullable Screen parent) {
		super(Text.literal("ObsidianUI Test TextArea Menu"));
		this.parent = parent;
	}

	@Override
	protected void init() {
		super.init();

		var containerWidget =
				ObsidianUITestFabric.buildTextAreaContainer(Position.of(this, 0, 50), this.width, this.height - 50,
						textArea -> {
							if (this.textArea != null) {
								textArea.setText(this.textArea.getText());
							}
							this.textArea = textArea;
						}, btn -> this.client.setScreen(this.parent));
		this.addDrawableChild(containerWidget);
	}

	@Override
	public void renderTitle(DrawContext drawContext, int mouseX, int mouseY, float delta) {
		drawContext.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 8, 16777215);
	}
}
