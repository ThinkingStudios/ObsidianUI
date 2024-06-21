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
import org.thinkingstudio.obsidianui.test.neoforge.ObsidianUITestFabric;
import org.thinkingstudio.obsidianui.widget.SpruceButtonWidget;
import org.thinkingstudio.obsidianui.widget.SpruceLabelWidget;
import org.thinkingstudio.obsidianui.widget.container.SpruceContainerWidget;
import org.thinkingstudio.obsidianui.widget.container.tabbed.SpruceTabbedWidget;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.jetbrains.annotations.Nullable;

public class SpruceTabbedTestScreen extends SpruceScreen {
	private final Screen parent;

	private SpruceTabbedWidget tabbedWidget;

	protected SpruceTabbedTestScreen(@Nullable Screen parent) {
		super(Text.literal("Tabbed Screen Test"));
		this.parent = parent;
	}

	@Override
	protected void init() {
		super.init();
		this.tabbedWidget = new SpruceTabbedWidget(Position.of(this, 0, 4), this.width, this.height - 35 - 4, this.title);
		this.tabbedWidget.addTabEntry(Text.literal("Hello World"), null, (width, height) -> {
			var container = new SpruceContainerWidget(Position.origin(), width, height);
			container.addChildren((containerWidth, containerHeight, widgetAdder) -> {
				widgetAdder.accept(new SpruceLabelWidget(Position.of(0, 16),
						Text.literal("Hello World!").formatted(Formatting.WHITE),
						containerWidth, true));
				widgetAdder.accept(new SpruceLabelWidget(Position.of(0, 48),
						Text.literal("This is a tabbed widget. You can switch tabs by using the list on the left.\n" +
										"It also allows quite a good controller support and arrow key navigation.")
								.formatted(Formatting.WHITE),
						containerWidth, true));
			});
			return container;
		});
		this.tabbedWidget.addSeparatorEntry(Text.literal("Separator"));
		this.tabbedWidget.addTabEntry(Text.literal("Option Test"), Text.literal("useful for config stuff.").formatted(Formatting.GRAY),
				(width, height) -> ObsidianUITestFabric.get().buildOptionList(Position.origin(), width, height));
		this.tabbedWidget.addTabEntry(Text.literal("Text Area"), Text.literal("to edit stuff on multiple lines.").formatted(Formatting.GRAY),
				(width, height) -> ObsidianUITestFabric.buildTextAreaContainer(Position.origin(), width, height,
						textArea -> {
						}, null));
		this.addDrawableChild(this.tabbedWidget);

		// Add done button.
		this.addDrawableChild(new SpruceButtonWidget(Position.of(this, this.width / 2 - 75, this.height - 29), 150, 20, SpruceTexts.GUI_DONE,
				btn -> this.client.setScreen(this.parent)).asVanilla());
	}
}
