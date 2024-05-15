/*
 * Copyright © 2020~2024 LambdAurora <email@lambdaurora.dev>
 * Copyright © 2024 ThinkingStudio
 *
 * This file is part of ObsidianUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.thinkingstudio.obsidianui.neoforge.event;

import net.minecraft.client.MinecraftClient;
import net.neoforged.bus.api.Event;

/**
 * Represents an event callback which is fired when the Minecraft's resolution is changed.
 *
 * @author TexTrue
 * @version 0.1.2
 * @since 0.1.1
 */
public class ResolutionChangeCallbackEvent extends Event {
    private final MinecraftClient client;

    public ResolutionChangeCallbackEvent(MinecraftClient client) {
        this.client = client;
    }

    public MinecraftClient getClient() {
        return client;
    }
}
