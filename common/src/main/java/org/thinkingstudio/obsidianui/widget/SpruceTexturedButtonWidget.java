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

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.thinkingstudio.obsidianui.Position;

/**
 * Represents a textured button widget.
 *
 * @author LambdAurora
 * @version 5.0.0
 * @since 2.0.0
 */
public class SpruceTexturedButtonWidget extends SpruceButtonWidget {
	private final Identifier texture;
	private final int u;
	private final int v;
	private final int hoveredVOffset;
	private final int textureWidth;
	private final int textureHeight;
	private final boolean showMessage;

	public SpruceTexturedButtonWidget(Position position, int width, int height, Text message, PressAction action, int u, int v,
                                      int hoveredVOffset, Identifier texture) {
		this(position, width, height, message, false, action, u, v, hoveredVOffset, texture);
	}

	public SpruceTexturedButtonWidget(Position position, int width, int height, Text message, boolean showMessage, PressAction action,
                                      int u, int v, int hoveredVOffset, Identifier texture) {
		this(position, width, height, message, showMessage, action, u, v, hoveredVOffset, texture, 256, 256);
	}

	public SpruceTexturedButtonWidget(Position position, int width, int height, Text message, PressAction action,
                                      int u, int v, int hoveredVOffset, Identifier texture, int textureWidth, int textureHeight) {
		this(position, width, height, message, false, action, u, v, hoveredVOffset, texture, textureWidth, textureHeight);
	}

	public SpruceTexturedButtonWidget(Position position, int width, int height, Text message, boolean showMessage, PressAction action,
                                      int u, int v, int hoveredVOffset, Identifier texture, int textureWidth, int textureHeight) {
		super(position, width, height, message, action);
		this.texture = texture;
		this.u = u;
		this.v = v;
		this.hoveredVOffset = hoveredVOffset;
		this.textureWidth = textureWidth;
		this.textureHeight = textureHeight;
		this.showMessage = showMessage;
	}

	/* Rendering */

	@Override
	protected void renderButton(DrawContext drawContext, int mouseX, int mouseY, float delta) {
		if (this.showMessage)
			super.renderButton(drawContext, mouseX, mouseY, delta);
	}

	@Override
	protected void renderBackground(DrawContext drawContext, int mouseX, int mouseY, float delta) {
		int v = this.v;
		if (this.isFocusedOrHovered()) {
			v += this.hoveredVOffset;
		}

		RenderSystem.setShaderColor(1.f, 1.f, 1.f, this.getAlpha());
		RenderSystem.setShaderTexture(0, this.texture);
		RenderSystem.enableDepthTest();
		drawContext.drawTexture(this.texture,
				this.getX(), this.getY(),
				this.u, v,
				this.getWidth(), this.getHeight(),
				this.textureWidth, this.textureHeight
		);
	}

	@Override
	public String toString() {
		return "SpruceTexturedButtonWidget{" +
				"position=" + this.getPosition() +
				", width=" + this.getWidth() +
				", height=" + this.getHeight() +
				", visible=" + this.isVisible() +
				", active=" + this.isActive() +
				", message=" + this.getMessage() +
				", focused=" + this.isFocused() +
				", hovered=" + this.isMouseHovered() +
				", wasHovered=" + this.wasHovered +
				", dragging=" + this.dragging +
				", lastDrag=" + this.lastDrag +
				", alpha=" + this.getAlpha() +
				", texture=" + this.texture +
				", u=" + this.u +
				", v=" + this.v +
				", hoveredVOffset=" + this.hoveredVOffset +
				", textureWidth=" + this.textureWidth +
				", textureHeight=" + this.textureHeight +
				", showMessage=" + this.showMessage +
				'}';
	}
}
