/*
 * Copyright © 2020~2024 LambdAurora <email@lambdaurora.dev>
 * Copyright © 2024 ThinkingStudio
 *
 * This file is part of ObsidianUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.thinkingstudio.obsidianui.util;

/**
 * Provides some common utils.
 *
 * @author LambdAurora
 * @version 3.3.0
 * @since 3.2.1
 */
public class SpruceUtil {
	/**
	 * Parses an integer from a string. If the value is not a integer it returns {@code 0}.
	 *
	 * @param value a {@code String} which represents an integer
	 * @return the parsed integer, if parsing fails returns {@code 0}.
	 */
	public static int parseIntFromString(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return 0;
		}
	}
}
