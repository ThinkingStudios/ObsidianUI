/*
 * Copyright © 2020~2024 LambdAurora <email@lambdaurora.dev>
 * Copyright © 2024 ThinkingStudio
 *
 * This file is part of ObsidianUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.thinkingstudio.obsidianui.forge.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.thinkingstudio.obsidianui.forge.event.OpenScreenCallbackEvent;
import org.thinkingstudio.obsidianui.forge.event.ResolutionChangeCallbackEvent;

/**
 * Represents the injection point for the {@link OpenScreenCallbackEvent} and {@link ResolutionChangeCallbackEvent} events.
 *
 * @author LambdAurora
 * @version 1.4.0
 * @since 1.2.0
 */
@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
	@Inject(method = "setScreen", at = @At("HEAD"))
	private void obsidianui_onScreenPre(Screen screen, CallbackInfo ci) {
		MinecraftForge.EVENT_BUS.post(new OpenScreenCallbackEvent.Pre((MinecraftClient) (Object) this, screen));
	}

	@Inject(method = "setScreen", at = @At("RETURN"))
	private void obsidianui_onScreenChange(Screen screen, CallbackInfo ci) {
		MinecraftForge.EVENT_BUS.post(new OpenScreenCallbackEvent.Post((MinecraftClient) (Object) this, screen));
	}

	@Inject(method = "onResolutionChanged", at = @At("RETURN"))
	private void obsidianui_onResolutionChanged(CallbackInfo ci) {
		MinecraftForge.EVENT_BUS.post(new ResolutionChangeCallbackEvent((MinecraftClient) (Object) this));
	}
}
