/*
 * Copyright © 2020~2024 LambdAurora <email@lambdaurora.dev>
 * Copyright © 2024 ThinkingStudio
 *
 * This file is part of SpruceUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.thinkingstudio.obsidianui.background;

import org.thinkingstudio.obsidianui.util.RenderUtil;
import org.thinkingstudio.obsidianui.widget.SpruceWidget;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

public final class DirtTexturedBackground implements Background {
    public static final Background NORMAL = new DirtTexturedBackground(64, 64, 64, 255);
    public static final Background DARKENED = new DirtTexturedBackground(32, 32, 32, 255);

    private final MinecraftClient client = MinecraftClient.getInstance();
    private final int red;
    private final int green;
    private final int blue;
    private final int alpha;

    public DirtTexturedBackground(int red, int green, int blue, int alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    @Override
    public void render(MatrixStack matrices, SpruceWidget widget, int vOffset, int mouseX, int mouseY, float delta) {
        RenderUtil.renderBackgroundTexture(this.client, widget.getX(), widget.getY(), widget.getWidth(), widget.getHeight(),
                vOffset / 32.f, this.red, this.green, this.blue, this.alpha);
    }

    @Override
    public String toString() {
        return "DirtTexturedBackground{" +
                "red=" + this.red +
                ", green=" + this.green +
                ", blue=" + this.blue +
                ", alpha=" + this.alpha +
                '}';
    }
}
