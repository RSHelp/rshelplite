/*
 * Copyright (c) 2018, Cas <https://github.com/casvandongen>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.agility;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("agility")
public interface AgilityConfig extends Config
{
	@ConfigItem(
		keyName = "showLapCount",
		name = "Show Lap Count",
		description = "Enable/disable the lap counter",
		position = 1
	)
	default boolean showLapCount()
	{
		return true;
	}

	@ConfigItem(
		keyName = "lapTimeout",
		name = "Hide Lap Count (minutes)",
		description = "Time until the lap counter hides/resets",
		position = 2
	)
	default int lapTimeout()
	{
		return 5;
	}

	@ConfigItem(
<<<<<<< HEAD
		keyName = "lapsToLevel",
		name = "Show Laps Until Level",
		description = "Show number of laps remaining until next level is reached.",
		position = 3
	)
	default boolean lapsToLevel()
	{
		return true;
	}

	@ConfigItem(
		keyName = "lapsToGoal",
		name = "Show Laps Until Goal",
		description = "Show number of laps remaining until experience tracker goal is reached",
		position = 4
	)
	default boolean lapsToGoal()
	{
		return false;
	}

	@ConfigItem(
		keyName = "overlayColor",
		name = "Overlay Color",
		description = "Color of Agility overlay",
		position = 5
=======
		keyName = "overlayColor",
		name = "Overlay Color",
		description = "Color of Agility overlay",
		position = 3
>>>>>>> initial import of runelite
	)
	default Color getOverlayColor()
	{
		return Color.GREEN;
	}

	@ConfigItem(
		keyName = "highlightMarks",
		name = "Highlight Marks of Grace",
		description = "Enable/disable the highlighting of retrievable Marks of Grace",
<<<<<<< HEAD
		position = 6
=======
		position = 4
>>>>>>> initial import of runelite
	)
	default boolean highlightMarks()
	{
		return true;
	}

	@ConfigItem(
		keyName = "markHighlight",
		name = "Mark Highlight Color",
		description = "Color of highlighted Marks of Grace",
<<<<<<< HEAD
		position = 7
=======
		position = 5
>>>>>>> initial import of runelite
	)
	default Color getMarkColor()
	{
		return Color.RED;
	}

	@ConfigItem(
		keyName = "highlightShortcuts",
		name = "Highlight Agility Shortcuts",
		description = "Enable/disable the highlighting of Agility shortcuts",
<<<<<<< HEAD
		position = 8
=======
		position = 6
>>>>>>> initial import of runelite
	)
	default boolean highlightShortcuts()
	{
		return true;
	}

	@ConfigItem(
		keyName = "trapOverlay",
		name = "Show Trap Overlay",
		description = "Enable/disable the highlighting of traps on Agility courses",
<<<<<<< HEAD
		position = 9
=======
		position = 7
>>>>>>> initial import of runelite
	)
	default boolean showTrapOverlay()
	{
		return true;
	}

	@ConfigItem(
		keyName = "trapHighlight",
		name = "Trap Overlay Color",
		description = "Color of Agility trap overlay",
<<<<<<< HEAD
		position = 10
=======
		position = 8
>>>>>>> initial import of runelite
	)
	default Color getTrapColor()
	{
		return Color.RED;
	}

	@ConfigItem(
		keyName = "agilityArenaNotifier",
		name = "Agility Arena notifier",
		description = "Notify on ticket location change in Agility Arena",
<<<<<<< HEAD
		position = 11
=======
		position = 9
>>>>>>> initial import of runelite
	)
	default boolean notifyAgilityArena()
	{
		return true;
	}

	@ConfigItem(
		keyName = "agilityArenaTimer",
		name = "Agility Arena timer",
		description = "Configures whether Agility Arena timer is displayed",
<<<<<<< HEAD
		position = 12
=======
		position = 10
>>>>>>> initial import of runelite
	)
	default boolean showAgilityArenaTimer()
	{
		return true;
	}
}
