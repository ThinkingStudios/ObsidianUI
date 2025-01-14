/*
 * Copyright © 2020~2024 LambdAurora <email@lambdaurora.dev>
 * Copyright © 2024 ThinkingStudio
 *
 * This file is part of ObsidianUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.thinkingstudio.obsidianui.widget.text;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.OrderedText;
import org.thinkingstudio.obsidianui.background.Background;
import org.thinkingstudio.obsidianui.border.Border;
import org.thinkingstudio.obsidianui.navigation.NavigationDirection;
import org.thinkingstudio.obsidianui.util.ColorUtil;
import org.thinkingstudio.obsidianui.widget.AbstractSpruceWidget;
import org.thinkingstudio.obsidianui.widget.WithBackground;
import org.thinkingstudio.obsidianui.widget.WithBorder;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Represents a text field widget with a title on top.
 *
 * @author LambdAurora
 * @version 5.0.0
 * @since 2.1.0
 */
public class SpruceNamedTextFieldWidget extends AbstractSpruceWidget implements WithBackground, WithBorder {
	private static final int Y_OFFSET = 13;
	private final SpruceTextFieldWidget textFieldWidget;

	public SpruceNamedTextFieldWidget(SpruceTextFieldWidget widget) {
		super(widget.getPosition().copy());
		widget.getPosition().setAnchor(this);
		widget.getPosition().setRelativeX(0);
		widget.getPosition().setRelativeY(Y_OFFSET);

		this.textFieldWidget = widget;
	}

	public SpruceTextFieldWidget getTextFieldWidget() {
		return this.textFieldWidget;
	}

	@Override
	public int getWidth() {
		return this.getTextFieldWidget().getWidth();
	}

	@Override
	public int getHeight() {
		return this.getTextFieldWidget().getHeight() + Y_OFFSET;
	}

	@Override
	public boolean isVisible() {
		return this.getTextFieldWidget().isVisible();
	}

	@Override
	public void setVisible(boolean visible) {
		this.getTextFieldWidget().setVisible(visible);
	}

	@Override
	public boolean isFocused() {
		return this.getTextFieldWidget().isFocused();
	}

	@Override
	public void setFocused(boolean focused) {
		this.getTextFieldWidget().setFocused(focused);
	}

	public String getText() {
		return this.getTextFieldWidget().getText();
	}

	public void setText(String text) {
		this.getTextFieldWidget().setText(text);
	}

	public Consumer<String> getChangedListener() {
		return this.getTextFieldWidget().getChangedListener();
	}

	public void setChangedListener(Consumer<String> changedListener) {
		this.getTextFieldWidget().setChangedListener(changedListener);
	}

	public Predicate<String> getTextPredicate() {
		return this.getTextFieldWidget().getTextPredicate();
	}

	public void setTextPredicate(Predicate<String> textPredicate) {
		this.getTextFieldWidget().setTextPredicate(textPredicate);
	}

	public BiFunction<String, Integer, OrderedText> getRenderTextProvider() {
		return this.getTextFieldWidget().getRenderTextProvider();
	}

	public void setRenderTextProvider(BiFunction<String, Integer, OrderedText> renderTextProvider) {
		this.getTextFieldWidget().setRenderTextProvider(renderTextProvider);
	}

	/**
	 * Returns the color for editable text.
	 *
	 * @return the editable text
	 */
	public int getEditableColor() {
		return this.getTextFieldWidget().getEditableColor();
	}

	/**
	 * Sets the color for editable text.
	 *
	 * @param editableColor the editable color
	 */
	public void setEditableColor(int editableColor) {
		this.getTextFieldWidget().setEditableColor(editableColor);
	}

	/**
	 * Returns the color for uneditable text.
	 *
	 * @return the uneditable color
	 */
	public int getUneditableColor() {
		return this.getTextFieldWidget().getUneditableColor();
	}

	/**
	 * Sets the color for uneditable text.
	 *
	 * @param uneditableColor the uneditable color
	 */
	public void setUneditableColor(int uneditableColor) {
		this.getTextFieldWidget().setUneditableColor(uneditableColor);
	}

	/**
	 * Returns the text color.
	 *
	 * @return the text color
	 */
	public int getTextColor() {
		return this.getTextFieldWidget().getTextColor();
	}

	@Override
	public Background getBackground() {
		return this.getTextFieldWidget().getBackground();
	}

	@Override
	public void setBackground(Background background) {
		this.getTextFieldWidget().setBackground(background);
	}

	@Override
	public Border getBorder() {
		return this.getTextFieldWidget().getBorder();
	}

	@Override
	public void setBorder(Border border) {
		this.getTextFieldWidget().setBorder(border);
	}

	/* Navigation */

	@Override
	public boolean onNavigation(NavigationDirection direction, boolean tab) {
		return this.getTextFieldWidget().onNavigation(direction, tab);
	}

	/* Input */

	@Override
	protected boolean onMouseClick(double mouseX, double mouseY, int button) {
		return this.getTextFieldWidget().mouseClicked(mouseX, mouseY, button);
	}

	@Override
	protected boolean onMouseRelease(double mouseX, double mouseY, int button) {
		return this.getTextFieldWidget().mouseReleased(mouseX, mouseY, button);
	}

	@Override
	protected boolean onMouseDrag(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
		return this.getTextFieldWidget().mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
	}

	@Override
	protected boolean onMouseScroll(double mouseX, double mouseY, double scrollX, double scrollY) {
		return this.getTextFieldWidget().mouseScrolled(mouseX, mouseY, scrollX, scrollY);
	}

	@Override
	protected boolean onKeyPress(int keyCode, int scanCode, int modifiers) {
		return this.getTextFieldWidget().keyPressed(keyCode, scanCode, modifiers);
	}

	@Override
	protected boolean onKeyRelease(int keyCode, int scanCode, int modifiers) {
		return this.getTextFieldWidget().keyReleased(keyCode, scanCode, modifiers);
	}

	@Override
	protected boolean onCharTyped(char chr, int keyCode) {
		return this.getTextFieldWidget().charTyped(chr, keyCode);
	}

	/* Rendering */

	@Override
	protected void renderWidget(DrawContext drawContext, int mouseX, int mouseY, float delta) {
		drawContext.drawTextWithShadow(this.client.textRenderer, this.getTextFieldWidget().getTitle(), this.getX() + 2, this.getY() + 2, ColorUtil.TEXT_COLOR);

		this.getTextFieldWidget().render(drawContext, mouseX, mouseY, delta);
	}
}
