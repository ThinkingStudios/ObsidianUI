package dev.lambdaurora.spruceui.event;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraftforge.eventbus.api.Cancelable;
import net.minecraftforge.eventbus.api.Event;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

public abstract class OpenScreenEvent extends Event {
    private final MinecraftClient client;
    private final Screen screen;

    @ApiStatus.Internal
    public OpenScreenEvent(MinecraftClient client, @Nullable Screen screen) {
        this.client = client;
        this.screen = screen;
    }

    public MinecraftClient getClient() {
        return client;
    }

    public Screen getScreen() {
        return screen;
    }

    @Cancelable
    public static class Pre extends OpenScreenEvent {
        @ApiStatus.Internal
        public Pre(MinecraftClient client, @Nullable Screen screen) {
            super(client, screen);
        }
    }

    public static class Post extends OpenScreenEvent {
        @ApiStatus.Internal
        public Post(MinecraftClient client, @Nullable Screen screen) {
            super(client, screen);
        }
    }
}
