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

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;

public final class RenderUtil {
	/**
	 * The dirt background texture used in 1.20.5 and above versions.
	 */
	public static final Identifier DIRT_BACKGROUND_TEXTURE = Identifier.of("obsidianui", "textures/gui/dirt_background.png");
	private static final Identifier MENU_LIST_BACKGROUND_TEXTURE = Identifier.ofVanilla("textures/gui/menu_list_background.png");
	private static final Identifier INWORLD_MENU_LIST_BACKGROUND_TEXTURE = Identifier.ofVanilla("textures/gui/inworld_menu_list_background.png");
	private static final MinecraftClient client = MinecraftClient.getInstance();

	private RenderUtil() {
		throw new IllegalStateException("RenderUtil only contains static-definitions.");
	}

	/**
	 * Renders the vanilla's transparent background texture.
	 *
	 * @param drawContext the current draw context
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 * @param width the width
	 * @param height the height
	 * @param vOffset the v offset
	 * @see #renderTransparentBackgroundTexture(DrawContext, int, int, int, int, float, int, int, int, int)
	 */
	public static void renderTransparentBackgroundTexture(DrawContext drawContext, int x, int y, int width, int height, float vOffset) {
		renderTransparentBackgroundTexture(drawContext, x, y, width, height, vOffset, 64, 64, 64, 255);
	}

	/**
	 * Renders the vanilla's transparent background texture.
	 *
	 * @param context the current draw context
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
	public static void renderTransparentBackgroundTexture(DrawContext context, int x, int y, int width, int height, float vOffset,
														  int red, int green, int blue, int alpha) {
		int right = x + width;
		int bottom = y + height;

		context.drawTexture(RenderPipelines.GUI_TEXTURED, getListBackgroundTexture(), x, y, x, y, width, height, (int) (right / 32.f), (int) (bottom / 32.f + vOffset), ColorUtil.packARGBColor(red, green, blue, alpha));
	}
	public static Identifier getListBackgroundTexture() {
		return client.world == null ? MENU_LIST_BACKGROUND_TEXTURE : INWORLD_MENU_LIST_BACKGROUND_TEXTURE;
	}

	/**
	 * Renders the dirt background texture.
	 *
	 * @param drawContext the current draw context
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 * @param width the width
	 * @param height the height
	 * @param vOffset the v offset
	 * @see #renderDirtBackgroundTexture(DrawContext, int, int, int, int, float, int, int, int, int)
	 */
	@Deprecated(since = "1.20.5")
	public static void renderDirtBackgroundTexture(DrawContext drawContext, int x, int y, int width, int height, float vOffset) {
		renderDirtBackgroundTexture(drawContext, x, y, width, height, vOffset, 64, 64, 64, 255);
	}

	/**
	 * Renders the dirt background texture.
	 *
	 * @param context the current draw context
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
	@Deprecated(since = "1.20.5")
	public static void renderDirtBackgroundTexture(DrawContext context, int x, int y, int width, int height, float vOffset,
	                                           int red, int green, int blue, int alpha) {
		int right = x + width;
		int bottom = y + height;

		context.drawTexture(RenderPipelines.GUI_TEXTURED, DIRT_BACKGROUND_TEXTURE, x, y, x, y, width, height, (int) (right / 32.f), (int) (bottom / 32.f + vOffset), ColorUtil.packARGBColor(red, green, blue, alpha));
	}

	/**
	 * Renders a selection box as background.
	 *
	 * @param context the current draw context
	 * @param x the X-coordinate of the selection box
	 * @param y the Y-coordinate of the selection box
	 * @param width the width of the selection box
	 * @param height the height of the selection box
	 * @param red the red-component color value of the outer border
	 * @param green the green-component color value of the outer border
	 * @param blue the blue-component color value of the outer border
	 * @param alpha the alpha-component color value of the outer border
	 */
	public static void renderSelectionBox(DrawContext context, int x, int y, int width, int height, int red, int green, int blue, int alpha) {
		int top = y + height;
		int right = x + width;

		int argb = ColorHelper.getArgb(alpha, red, green, blue);
		context.fill(x, top, right, y, argb);
		int dark = ColorHelper.getArgb(0, 0, 0);
		context.fill(x, top, right, y, dark);
	}
}
