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

import net.minecraft.text.OrderedText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.jetbrains.annotations.Nullable;
import org.thinkingstudio.obsidianui.Position;
import org.thinkingstudio.obsidianui.util.SpruceUtil;
import org.thinkingstudio.obsidianui.widget.SpruceWidget;
import org.thinkingstudio.obsidianui.widget.text.SpruceNamedTextFieldWidget;
import org.thinkingstudio.obsidianui.widget.text.SpruceTextFieldWidget;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Represents an integer input option.
 *
 * @author LambdAurora
 * @version 3.2.1
 * @since 2.1.0
 */
public class SpruceIntegerInputOption extends SpruceOption {
	private final Supplier<Integer> getter;
	private final Consumer<Integer> setter;

	public SpruceIntegerInputOption(String key, Supplier<Integer> getter, Consumer<Integer> setter, @Nullable Text tooltip) {
		super(key);
		this.getter = getter;
		this.setter = setter;
		this.setTooltip(tooltip);
	}

	@Override
	public SpruceWidget createWidget(Position position, int width) {
		var textField = new SpruceTextFieldWidget(position, width, 20, this.getPrefix());
		textField.setText(String.valueOf(this.get()));
		textField.setTextPredicate(SpruceTextFieldWidget.INTEGER_INPUT_PREDICATE);
		textField.setRenderTextProvider((displayedText, offset) -> {
			try {
				Integer.parseInt(textField.getText());
				return OrderedText.forward(displayedText, Style.EMPTY);
			} catch (NumberFormatException e) {
				return OrderedText.forward(displayedText, Style.EMPTY.withColor(Formatting.RED));
			}
		});
		textField.setChangedListener(input -> {
			int value = SpruceUtil.parseIntFromString(input);
			this.set(value);
		});
		this.getOptionTooltip().ifPresent(textField::setTooltip);
		return new SpruceNamedTextFieldWidget(textField);
	}

	public void set(int value) {
		this.setter.accept(value);
	}

	/**
	 * Gets the current value.
	 *
	 * @return the current value
	 */
	public int get() {
		return this.getter.get();
	}
}
