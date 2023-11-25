package dev.lambdaurora.spruceui.event;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;


/**
 * Represents an event callback which is fired when an {@link Screen} is opened.
 *
 * @author TexTrue
 * @version 0.1.1
 * @since 0.1.1
 */
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

    public static class Pre extends OpenScreenEvent implements ICancellableEvent {
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
