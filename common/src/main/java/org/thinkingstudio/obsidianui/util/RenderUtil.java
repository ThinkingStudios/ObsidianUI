/*
 * Copyright © 2020~2024 LambdAurora <email@lambdaurora.dev>
 * Copyright © 2024 ThinkingStudio
 *
 * This file is part of ObsidianUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.thinkingstudio.obsidianui.util;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;

public final class RenderUtil {
	/**
	 * The dirt background texture used in 1.20.5 and above versions.
	 */
	public static final Identifier DIRT_BACKGROUND_TEXTURE = new Identifier("obsidianui", "textures/gui/dirt_background.png");

	private static final Identifier MENU_LIST_BACKGROUND_TEXTURE = new Identifier("textures/gui/menu_list_background.png");
	private static final Identifier INWORLD_MENU_LIST_BACKGROUND_TEXTURE = new Identifier("textures/gui/inworld_menu_list_background.png");
	private static final MinecraftClient client = MinecraftClient.getInstance();

	private RenderUtil() {
		throw new IllegalStateException("RenderUtil only contains static-definitions.");
	}

	/**
	 * Renders the vanilla's transparent background texture.
	 *
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 * @param width the width
	 * @param height the height
	 * @param vOffset the v offset
	 * @see #renderTransparentBackgroundTexture(int, int, int, int, float, int, int, int, int)
	 */
	public static void renderTransparentBackgroundTexture(int x, int y, int width, int height, float vOffset) {
		renderTransparentBackgroundTexture(x, y, width, height, vOffset, 64, 64, 64, 255);
	}

	/**
	 * Renders the vanilla's transparent background texture.
	 *
	 * @param x the X-coordinate
	 * @param y the Y-coordinate
	 * @param width the width
	 * @param height the height
	 * @param vOffset the v offset
	 * @param red the red-component color value
	 * @param green the green-component color value
	 * @param blue the blue-component color value
	 * @param alpha the alpha-component alpha value
	 */
	public static void renderTransparentBackgroundTexture(int x, int y, int width, int height, float vOffset,
												   int red, int green, int blue, int alpha) {
		var tessellator = Tessellator.getInstance();
		var bufferBuilder = tessellator.getBuffer();
		RenderSystem.setShader(GameRenderer::getPositionTexColorProgram);
		RenderSystem.setShaderColor(1.f, 1.f, 1.f, 1.f);
		RenderSystem.setShaderTexture(0, getListBackgroundTexture());

		int right = x + width;
		int bottom = y + height;

		bufferBuilder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);

		RenderSystem.enableBlend();
		bufferBuilder.vertex(x, bottom, 0)
				.texture(0, bottom / 32.f + vOffset)
				.color(red, green, blue, alpha).next();
		bufferBuilder.vertex(right, bottom, 0)
				.texture(right / 32.f, bottom / 32.f + vOffset)
				.color(red, green, blue, alpha).next();
		bufferBuilder.vertex(right, y, 0)
				.texture(right / 32.f, y / 32.f + vOffset)
				.color(red, green, blue, alpha).next();
		bufferBuilder.vertex(x, y, 0)
				.texture(0, y / 32.f + vOffset)
				.color(red, green, blue, alpha).next();
		tessellator.draw();
		RenderSystem.disableBlend();
	}

	public static Identifier getListBackgroundTexture() {
		return client.world == null ? MENU_LIST_BACKGROUND_TEXTURE : INWORLD_MENU_LIST_BACKGROUND_TEXTURE;
	}

	/**
	 * Renders the dirt background texture.
	 *
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 * @param width the width
	 * @param height the height
	 * @param vOffset the v offset
	 * @see #renderDirtBackgroundTexture(int, int, int, int, float, int, int, int, int)
	 */
	public static void renderDirtBackgroundTexture(int x, int y, int width, int height, float vOffset) {
		renderDirtBackgroundTexture(x, y, width, height, vOffset, 64, 64, 64, 255);
	}

	/**
	 * Renders the dirt background texture.
	 *
	 * @param x the X-coordinate
	 * @param y the Y-coordinate
	 * @param width the width
	 * @param height the height
	 * @param vOffset the v offset
	 * @param red the red-component color value
	 * @param green the green-component color value
	 * @param blue the blue-component color value
	 * @param alpha the alpha-component alpha value
	 */
	public static void renderDirtBackgroundTexture(int x, int y, int width, int height, float vOffset,
	                                           int red, int green, int blue, int alpha) {
		var tessellator = Tessellator.getInstance();
		var bufferBuilder = tessellator.getBuffer();
		RenderSystem.setShader(GameRenderer::getPositionTexColorProgram);
		RenderSystem.setShaderColor(1.f, 1.f, 1.f, 1.f);
		RenderSystem.setShaderTexture(0, DIRT_BACKGROUND_TEXTURE);

		int right = x + width;
		int bottom = y + height;

		bufferBuilder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
		bufferBuilder.vertex(x, bottom, 0)
				.texture(0, bottom / 32.f + vOffset)
				.color(red, green, blue, alpha).next();
		bufferBuilder.vertex(right, bottom, 0)
				.texture(right / 32.f, bottom / 32.f + vOffset)
				.color(red, green, blue, alpha).next();
		bufferBuilder.vertex(right, y, 0)
				.texture(right / 32.f, y / 32.f + vOffset)
				.color(red, green, blue, alpha).next();
		bufferBuilder.vertex(x, y, 0)
				.texture(0, y / 32.f + vOffset)
				.color(red, green, blue, alpha).next();
		tessellator.draw();
	}

	/**
	 * Renders a selection box as background.
	 *
	 * @param x the X-coordinate of the selection box
	 * @param y the Y-coordinate of the selection box
	 * @param width the width of the selection box
	 * @param height the height of the selection box
	 * @param red the red-component color value of the outer border
	 * @param green the green-component color value of the outer border
	 * @param blue the blue-component color value of the outer border
	 * @param alpha the alpha-component color value of the outer border
	 */
	public static void renderSelectionBox(int x, int y, int width, int height, int red, int green, int blue, int alpha) {
		var tessellator = Tessellator.getInstance();
		var bufferBuilder = tessellator.getBuffer();

		int top = y + height;
		int right = x + width;

		RenderSystem.setShader(GameRenderer::getPositionColorProgram);
		RenderSystem.setShaderColor(red / 255.f, green / 255.f, blue / 255.f, alpha / 255.f);
		bufferBuilder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION);
		bufferBuilder.vertex(x, top, 0).next();
		bufferBuilder.vertex(right, top, 0).next();
		bufferBuilder.vertex(right, y, 0).next();
		bufferBuilder.vertex(x, y, 0).next();
		tessellator.draw();
		RenderSystem.setShaderColor(0, 0, 0, 1.f);
		bufferBuilder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION);
		bufferBuilder.vertex(x + 1, top - 1, 0).next();
		bufferBuilder.vertex(right - 1, top - 1, 0).next();
		bufferBuilder.vertex(right - 1, y + 1, 0).next();
		bufferBuilder.vertex(x + 1, y + 1, 0).next();
		tessellator.draw();
	}
}
