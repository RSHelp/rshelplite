/*
 * Copyright (c) 2018, Infinitay <https://github.com/Infinitay>
 * Copyright (c) 2018-2019, Shaun Dreclin <https://github.com/ShaunDreclin>
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

package net.runelite.client.plugins.dailytaskindicators;

import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.VarClientInt;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.vars.AccountType;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Daily Task Indicator",
	description = "Show chat notifications for daily tasks upon login"
)
public class DailyTasksPlugin extends Plugin
{
	private static final int ONE_DAY = 86400000;

	private static final String HERB_BOX_MESSAGE = "You have herb boxes waiting to be collected at NMZ.";
	private static final int HERB_BOX_MAX = 15;
	private static final int HERB_BOX_COST = 9500;
	private static final String STAVES_MESSAGE = "You have battlestaves waiting to be collected from Zaff.";
	private static final String ESSENCE_MESSAGE = "You have essence waiting to be collected from Wizard Cromperty.";
	private static final String RUNES_MESSAGE = "You have random runes waiting to be collected from Lundail.";
	private static final String SAND_MESSAGE = "You have sand waiting to be collected from Bert.";
	private static final int SAND_QUEST_COMPLETE = 160;
	private static final String FLAX_MESSAGE = "You have bowstrings waiting to be converted from flax from the Flax keeper.";
<<<<<<< HEAD
	private static final String ARROWS_MESSAGE = "You have ogre arrows waiting to be collected from Rantz.";
	private static final String BONEMEAL_MESSAGE = "You have bonemeal and slime waiting to be collected from Robin.";
	private static final int BONEMEAL_PER_DIARY = 13;
	private static final String DYNAMITE_MESSAGE = "You have dynamite waiting to be collected from Thirus.";
=======
	private static final String BONEMEAL_MESSAGE = "You have bonemeal and slime waiting to be collected from Robin.";
	private static final int BONEMEAL_PER_DIARY = 13;
	private static final String RELOG_MESSAGE = " (Requires relog)";
>>>>>>> initial import of runelite

	@Inject
	private Client client;

	@Inject
	private DailyTasksConfig config;

	@Inject
	private ChatMessageManager chatMessageManager;

	private long lastReset;
	private boolean loggingIn;

	@Provides
	DailyTasksConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(DailyTasksConfig.class);
	}

	@Override
	public void startUp()
	{
		loggingIn = true;
	}

	@Override
	public void shutDown()
	{
		lastReset = 0L;
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGING_IN)
		{
			loggingIn = true;
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		long currentTime = System.currentTimeMillis();
		boolean dailyReset = !loggingIn && currentTime - lastReset > ONE_DAY;

		if ((dailyReset || loggingIn)
			&& client.getVar(VarClientInt.MEMBERSHIP_STATUS) == 1)
		{
			// Round down to the nearest day
			lastReset = (long) Math.floor(currentTime / ONE_DAY) * ONE_DAY;
			loggingIn = false;

			if (config.showHerbBoxes())
			{
				checkHerbBoxes(dailyReset);
			}

			if (config.showStaves())
			{
				checkStaves(dailyReset);
			}

			if (config.showEssence())
			{
				checkEssence(dailyReset);
			}

			if (config.showRunes())
			{
				checkRunes(dailyReset);
			}

			if (config.showSand())
			{
				checkSand(dailyReset);
			}

			if (config.showFlax())
			{
				checkFlax(dailyReset);
			}

			if (config.showBonemeal())
			{
				checkBonemeal(dailyReset);
			}
<<<<<<< HEAD

			if (config.showDynamite())
			{
				checkDynamite(dailyReset);
			}

			if (config.showArrows())
			{
				checkArrows(dailyReset);
			}
=======
>>>>>>> initial import of runelite
		}
	}

	private void checkHerbBoxes(boolean dailyReset)
	{
		if (client.getAccountType() == AccountType.NORMAL
<<<<<<< HEAD
			&& client.getVar(VarPlayer.NMZ_REWARD_POINTS) >= HERB_BOX_COST
			&& (client.getVar(Varbits.DAILY_HERB_BOXES_COLLECTED) < HERB_BOX_MAX
			|| dailyReset))
		{
			sendChatMessage(HERB_BOX_MESSAGE);
=======
			&& client.getVar(VarPlayer.NMZ_REWARD_POINTS) >= HERB_BOX_COST)
		{
			if (client.getVar(Varbits.DAILY_HERB_BOXES_COLLECTED) < HERB_BOX_MAX)
			{
				sendChatMessage(HERB_BOX_MESSAGE);
			}
			else if (dailyReset)
			{
				sendChatMessage(HERB_BOX_MESSAGE + RELOG_MESSAGE);
			}
>>>>>>> initial import of runelite
		}
	}

	private void checkStaves(boolean dailyReset)
	{
<<<<<<< HEAD
		if (client.getVar(Varbits.DIARY_VARROCK_EASY) == 1
			&& (client.getVar(Varbits.DAILY_STAVES_COLLECTED) == 0
			|| dailyReset))
		{
			sendChatMessage(STAVES_MESSAGE);
=======
		if (client.getVar(Varbits.DIARY_VARROCK_EASY) == 1)
		{
			if (client.getVar(Varbits.DAILY_STAVES_COLLECTED) == 0)
			{
				sendChatMessage(STAVES_MESSAGE);
			}
			else if (dailyReset)
			{
				sendChatMessage(STAVES_MESSAGE + RELOG_MESSAGE);
			}
>>>>>>> initial import of runelite
		}
	}

	private void checkEssence(boolean dailyReset)
	{
<<<<<<< HEAD
		if (client.getVar(Varbits.DIARY_ARDOUGNE_MEDIUM) == 1
			&& (client.getVar(Varbits.DAILY_ESSENCE_COLLECTED) == 0
			|| dailyReset))
		{
			sendChatMessage(ESSENCE_MESSAGE);
=======
		if (client.getVar(Varbits.DIARY_ARDOUGNE_MEDIUM) == 1)
		{
			if (client.getVar(Varbits.DAILY_ESSENCE_COLLECTED) == 0)
			{
				sendChatMessage(ESSENCE_MESSAGE);
			}
			else if (dailyReset)
			{
				sendChatMessage(ESSENCE_MESSAGE + RELOG_MESSAGE);
			}
>>>>>>> initial import of runelite
		}
	}

	private void checkRunes(boolean dailyReset)
	{
<<<<<<< HEAD
		if (client.getVar(Varbits.DIARY_WILDERNESS_EASY) == 1
			&& (client.getVar(Varbits.DAILY_RUNES_COLLECTED) == 0
			|| dailyReset))
		{
			sendChatMessage(RUNES_MESSAGE);
=======
		if (client.getVar(Varbits.DIARY_WILDERNESS_EASY) == 1)
		{
			if (client.getVar(Varbits.DAILY_RUNES_COLLECTED) == 0)
			{
				sendChatMessage(RUNES_MESSAGE);
			}
			else if (dailyReset)
			{
				sendChatMessage(RUNES_MESSAGE + RELOG_MESSAGE);
			}
>>>>>>> initial import of runelite
		}
	}

	private void checkSand(boolean dailyReset)
	{
<<<<<<< HEAD
		if (client.getVar(Varbits.QUEST_THE_HAND_IN_THE_SAND) >= SAND_QUEST_COMPLETE
			&& (client.getVar(Varbits.DAILY_SAND_COLLECTED) == 0
			|| dailyReset))
		{
			sendChatMessage(SAND_MESSAGE);
=======
		if (client.getVar(Varbits.QUEST_THE_HAND_IN_THE_SAND) >= SAND_QUEST_COMPLETE)
		{
			if (client.getVar(Varbits.DAILY_SAND_COLLECTED) == 0)
			{
				sendChatMessage(SAND_MESSAGE);
			}
			else if (dailyReset)
			{
				sendChatMessage(SAND_MESSAGE + RELOG_MESSAGE);
			}
>>>>>>> initial import of runelite
		}
	}

	private void checkFlax(boolean dailyReset)
	{
<<<<<<< HEAD
		if (client.getVar(Varbits.DIARY_KANDARIN_EASY) == 1
			&& (client.getVar(Varbits.DAILY_FLAX_STATE) == 0
			|| dailyReset))
		{
			sendChatMessage(FLAX_MESSAGE);
		}
	}

	private void checkArrows(boolean dailyReset)
	{
		if (client.getVar(Varbits.DIARY_WESTERN_EASY) == 1
			&& (client.getVar(Varbits.DAILY_ARROWS_STATE) == 0
			|| dailyReset))
		{
			sendChatMessage(ARROWS_MESSAGE);
=======
		if (client.getVar(Varbits.DIARY_KANDARIN_EASY) == 1)
		{
			if (client.getVar(Varbits.DAILY_FLAX_STATE) == 0)
			{
				sendChatMessage(FLAX_MESSAGE);
			}
			else if (dailyReset)
			{
				sendChatMessage(FLAX_MESSAGE + RELOG_MESSAGE);
			}
>>>>>>> initial import of runelite
		}
	}

	private void checkBonemeal(boolean dailyReset)
	{
		if (client.getVar(Varbits.DIARY_MORYTANIA_MEDIUM) == 1)
		{
			int collected = client.getVar(Varbits.DAILY_BONEMEAL_STATE);
			int max = BONEMEAL_PER_DIARY;
			if (client.getVar(Varbits.DIARY_MORYTANIA_HARD) == 1)
			{
				max += BONEMEAL_PER_DIARY;
				if (client.getVar(Varbits.DIARY_MORYTANIA_ELITE) == 1)
				{
					max += BONEMEAL_PER_DIARY;
				}
			}
<<<<<<< HEAD
			if (collected < max || dailyReset)
			{
				sendChatMessage(BONEMEAL_MESSAGE);
			}
		}
	}

	private void checkDynamite(boolean dailyReset)
	{
		if (client.getVar(Varbits.DIARY_KOUREND_MEDIUM) == 1
			&& (client.getVar(Varbits.DAILY_DYNAMITE_COLLECTED) == 0
			|| dailyReset))
		{
			sendChatMessage(DYNAMITE_MESSAGE);
=======
			if (collected < max)
			{
				sendChatMessage(BONEMEAL_MESSAGE);
			}
			else if (dailyReset)
			{
				sendChatMessage(BONEMEAL_MESSAGE + RELOG_MESSAGE);
			}
>>>>>>> initial import of runelite
		}
	}

	private void sendChatMessage(String chatMessage)
	{
		final String message = new ChatMessageBuilder()
			.append(ChatColorType.HIGHLIGHT)
			.append(chatMessage)
			.build();

		chatMessageManager.queue(
			QueuedMessage.builder()
<<<<<<< HEAD
				.type(ChatMessageType.CONSOLE)
=======
				.type(ChatMessageType.GAME)
>>>>>>> initial import of runelite
				.runeLiteFormattedMessage(message)
				.build());
	}
}
