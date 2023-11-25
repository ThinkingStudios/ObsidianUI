package dev.lambdaurora.spruceui.event;

import net.minecraft.client.MinecraftClient;
import net.neoforged.bus.api.Event;


/**
 * Represents an event callback which is fired when the Minecraft's resolution is changed.
 *
 * @author TexTrue
 * @version 0.1.1
 * @since 0.1.1
 */
public class ResolutionChangeEvent extends Event {
    private final MinecraftClient client;
    public ResolutionChangeEvent(MinecraftClient client) {
        this.client = client;
    }
    public MinecraftClient getClient() {
        return client;
    }
}
