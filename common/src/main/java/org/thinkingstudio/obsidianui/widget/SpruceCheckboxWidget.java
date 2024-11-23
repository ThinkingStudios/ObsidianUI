/*
 * Copyright © 2020~2024 LambdAurora <email@lambdaurora.dev>
 * Copyright © 2024 ThinkingStudio
 *
 * This file is part of ObsidianUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.thinkingstudio.obsidianui.widget;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Language;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.math.MathHelper;
import org.thinkingstudio.obsidianui.Position;
import org.thinkingstudio.obsidianui.mixin.DrawContextAccessor;

/**
 * Represents a checkbox widget.
 *
 * @author LambdAurora
 * @version 5.0.0
 * @since 1.0.0
 */
public class SpruceCheckboxWidget extends AbstractSpruceBooleanButtonWidget {
	private static final Identifier TEXTURE = Identifier.of("obsidianui", "textures/gui/checkbox.png");
	private boolean showCross = false;
	private boolean colored = false;

	public SpruceCheckboxWidget(Position position, int width, int height, Text message, boolean value) {
		super(position, width, height, message, value);
	}

	public SpruceCheckboxWidget(Position position, int width, int height, Text message, boolean value, boolean showMessage) {
		super(position, width, height, message, value, showMessage);
	}

	public SpruceCheckboxWidget(Position position, int width, int height, Text message, PressAction action, boolean value) {
		super(position, width, height, message, action, value);
	}

	public SpruceCheckboxWidget(Position position, int width, int height, Text message, PressAction action, boolean value, boolean showMessage) {
		super(position, width, height, message, action, value, showMessage);
	}

	/**
	 * Returns whether this checkbox shows a cross for the {@code false} value.
	 *
	 * @return {@code true} if this checkbox can show a cross, else {@code false}
	 */
	public boolean showCross() {
		return this.showCross;
	}

	/**
	 * Sets whether this checkbox shows a cross for the {@code false} value.
	 *
	 * @param showCross {@code true} if this checkbox can show a cross, else {@code false}
	 */
	public void setShowCross(boolean showCross) {
		this.showCross = showCross;
	}

	/**
	 * Returns whether this checkbox is colored or not.
	 *
	 * @return {@code true} if colored, else {@code false}
	 */
	public boolean isColored() {
		return this.colored;
	}

	/**
	 * Sets whether this checkbox is colored or not.
	 *
	 * @param colored {@code true} if colored, else {@code false}
	 */
	public void setColored(boolean colored) {
		this.colored = colored;
	}

	/* Rendering */

	@Override
	protected void renderButton(DrawContext drawContext, int mouseX, int mouseY, float delta) {
		RenderSystem.enableDepthTest();
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.blendFunc(GlStateManager.SrcFactor.SRC_ALPHA, GlStateManager.DstFactor.ONE_MINUS_SRC_ALPHA);
		float[] oldColor = RenderSystem.getShaderColor();
		float oldRed = oldColor[0], oldGreen = oldColor[1], oldBlue = oldColor[2], oldAlpha = oldColor[3];

		if (this.getValue()) {
			if (this.colored)
				RenderSystem.setShaderColor(0.f, 1.f, 0.f, this.alpha);
			drawContext.drawTexture(RenderLayer::getGuiTextured, TEXTURE, this.getX(), this.getY(), 0.f, 40.f, this.getHeight(), this.getHeight(), 64, 64);
		} else if (this.showCross) {
			if (this.colored)
				RenderSystem.setShaderColor(1.f, 0.f, 0.f, this.alpha);
			drawContext.drawTexture(RenderLayer::getGuiTextured, TEXTURE, this.getX(), this.getY(), 0.f, 20.f, this.getHeight(), this.getHeight(), 64, 64);
		}

		if (this.colored) {
			RenderSystem.setShaderColor(oldRed, oldGreen, oldBlue, oldAlpha);
		}

		if (this.showMessage) {
			OrderedText message = Language.getInstance().reorder(this.client.textRenderer.trimToWidth(this.getMessage(), this.getWidth() - this.getHeight() - 4));
			drawContext.drawTextWithShadow(MinecraftClient.getInstance().textRenderer, message, this.getX() + this.getHeight() + 4, this.getY() + (this.getHeight() - 8) / 2,
					14737632 | MathHelper.ceil(this.alpha * 255.0F) << 24);
		}
	}

	@Override
	protected void renderBackground(DrawContext drawContext, int mouseX, int mouseY, float delta) {
		RenderSystem.enableDepthTest();
		int color = ColorHelper.fromFloats(this.alpha, 1.f, 1.f, 1.f);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.blendFunc(GlStateManager.SrcFactor.SRC_ALPHA, GlStateManager.DstFactor.ONE_MINUS_SRC_ALPHA);
		drawContext.drawTexture(RenderLayer::getGuiTextured, TEXTURE, this.getX(), this.getY(), this.isFocusedOrHovered() ? 20.f : 0.f, 0.f, this.getHeight(), this.getHeight(), 64, 64, color);
	}

	/* Narration */

	@Override
	protected Text getNarrationFocusedUsageMessage() {
		return Text.translatable("narration.checkbox.usage.focused");
	}

	@Override
	protected Text getNarrationHoveredUsageMessage() {
		return Text.translatable("narration.checkbox.usage.hovered");
	}
}
