/*
 * Copyright © 2020 LambdAurora <email@lambdaurora.dev>
 *
 * This file is part of SpruceUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package dev.lambdaurora.spruceui.neoforge.mixin;

import dev.lambdaurora.spruceui.neoforge.SpruceUINeoForge;
import dev.lambdaurora.spruceui.neoforge.event.OpenScreenEvent;
import dev.lambdaurora.spruceui.neoforge.event.ResolutionChangeEvent;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Represents the injection point for the {@link OpenScreenEvent} and {@link ResolutionChangeEvent} events.
 *
 * @author LambdAurora
 * @version 3.2.1
 * @since 1.2.0
 */
@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
	@Inject(method = "setScreen", at = @At("HEAD"))
	private void onScreenPre(Screen screen, CallbackInfo ci) {
		SpruceUINeoForge.MOD_EVENT_BUS.post(new OpenScreenEvent.Pre((MinecraftClient) (Object) this, screen));
	}

	@Inject(method = "setScreen", at = @At("RETURN"))
	private void onScreenChange(Screen screen, CallbackInfo ci) {
		SpruceUINeoForge.MOD_EVENT_BUS.post(new OpenScreenEvent.Pre((MinecraftClient) (Object) this, screen));
	}

	@Inject(method = "onResolutionChanged", at = @At("RETURN"))
	private void onResolutionChanged(CallbackInfo ci) {
		SpruceUINeoForge.MOD_EVENT_BUS.post(new ResolutionChangeEvent((MinecraftClient) (Object) this));
	}
}
