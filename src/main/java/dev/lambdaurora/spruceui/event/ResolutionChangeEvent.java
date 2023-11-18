package dev.lambdaurora.spruceui.event;

import net.minecraft.client.MinecraftClient;
import net.neoforged.bus.api.Event;

public class ResolutionChangeEvent extends Event {
    private final MinecraftClient client;
    public ResolutionChangeEvent(MinecraftClient client) {
        this.client = client;
    }
    public MinecraftClient getClient() {
        return client;
    }
}
