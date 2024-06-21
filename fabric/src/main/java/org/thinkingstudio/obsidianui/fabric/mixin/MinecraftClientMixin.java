/*
 * Copyright © 2020~2024 LambdAurora <email@lambdaurora.dev>
 * Copyright © 2024 ThinkingStudio
 *
 * This file is part of ObsidianUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.thinkingstudio.obsidianui.fabric.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.thinkingstudio.obsidianui.fabric.event.OpenScreenCallback;
import org.thinkingstudio.obsidianui.fabric.event.ResolutionChangeCallback;

/**
 * Represents the injection point for the {@link OpenScreenCallback} and {@link ResolutionChangeCallback} events.
 *
 * @author LambdAurora
 * @version 3.2.1
 * @since 1.2.0
 */
@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
	@Inject(method = "setScreen", at = @At("HEAD"))
	private void obsidianui_onScreenPre(Screen screen, CallbackInfo ci) {
		OpenScreenCallback.PRE.invoker().apply((MinecraftClient) (Object) this, screen);
	}

	@Inject(method = "setScreen", at = @At("RETURN"))
	private void obsidianui_onScreenChange(Screen screen, CallbackInfo ci) {
		OpenScreenCallback.POST.invoker().apply((MinecraftClient) (Object) this, screen);
	}

	@Inject(method = "onResolutionChanged", at = @At("RETURN"))
	private void obsidianui_onResolutionChanged(CallbackInfo ci) {
		ResolutionChangeCallback.EVENT.invoker().apply((MinecraftClient) (Object) this);
	}
}
