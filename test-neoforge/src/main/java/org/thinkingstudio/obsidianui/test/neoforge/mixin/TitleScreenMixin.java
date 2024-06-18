/*
 * Copyright © 2020 LambdAurora <email@lambdaurora.dev>
 *
 * This file is part of SpruceUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.thinkingstudio.obsidianui.test.neoforge.mixin;

import org.thinkingstudio.obsidianui.Position;
import org.thinkingstudio.obsidianui.test.neoforge.gui.SpruceMainMenuScreen;
import org.thinkingstudio.obsidianui.widget.SpruceButtonWidget;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin extends Screen {
	protected TitleScreenMixin(Text title) {
		super(title);
	}

	@Inject(method = "init", at = @At("RETURN"))
	private void onInit(CallbackInfo ci) {
		this.addDrawableChild(new SpruceButtonWidget(Position.of(0, 0), 150, 20, Text.literal("ObsidianUI Test Menu"),
				btn -> this.client.setScreen(new SpruceMainMenuScreen(this))).asVanilla());
	}
}