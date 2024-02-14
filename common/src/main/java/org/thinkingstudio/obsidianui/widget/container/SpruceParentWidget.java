/*
 * Copyright © 2020~2024 LambdAurora <email@lambdaurora.dev>
 * Copyright © 2024 ThinkingStudio
 *
 * This file is part of SpruceUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.thinkingstudio.obsidianui.widget.container;

import org.thinkingstudio.obsidianui.navigation.NavigationDirection;
import org.thinkingstudio.obsidianui.navigation.NavigationUtils;
import org.thinkingstudio.obsidianui.widget.SpruceWidget;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * Represents a parent widget.
 *
 * @author LambdAurora
 * @version 2.0.4
 * @since 2.0.4
 */
public interface SpruceParentWidget<E extends SpruceWidget> extends SpruceWidget {
    List<E> children();

    @Nullable E getFocused();

    void setFocused(@Nullable E focused);

    default Optional<E> hoveredElement(double mouseX, double mouseY) {
        Iterator<E> it = this.children().iterator();

        E element;
        do {
            if (!it.hasNext()) {
                return Optional.empty();
            }

            element = it.next();
        } while (!element.isMouseOver(mouseX, mouseY));

        return Optional.of(element);
    }

    /* Navigation */

    @Override
    default boolean onNavigation(@NotNull NavigationDirection direction, boolean tab) {
        if (this.requiresCursor()) return false;
        boolean result = NavigationUtils.tryNavigate(direction, tab, this.children(), this.getFocused(), this::setFocused, false);
        if (result)
            this.setFocused(true);
        return result;
    }
}
