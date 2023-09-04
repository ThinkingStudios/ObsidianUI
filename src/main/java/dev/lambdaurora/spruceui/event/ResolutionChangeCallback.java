/*
 * Copyright © 2020-2022 LambdAurora <email@lambdaurora.dev>
 *
 * This file is part of SpruceUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package dev.lambdaurora.spruceui.event;

import dev.architectury.event.Event;
import dev.architectury.event.EventFactory;
import net.minecraft.client.MinecraftClient;

/**
 * Represents an event callback which is fired when the Minecraft's resolution is changed.
 *
 * @author LambdAurora
 * @version 3.3.0
 * @since 1.2.0
 */
@FunctionalInterface
public interface ResolutionChangeCallback {
	Event<ResolutionChangeCallback> EVENT = EventFactory.createEventResult();

	void apply(MinecraftClient client);
}
