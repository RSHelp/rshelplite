/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.screenshot;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Consumer;
import javax.inject.Inject;
<<<<<<< HEAD
import static net.runelite.api.ChatMessageType.GAMEMESSAGE;
=======
import static net.runelite.api.ChatMessageType.SERVER;
>>>>>>> initial import of runelite
import net.runelite.api.Client;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import static net.runelite.api.widgets.WidgetID.DIALOG_SPRITE_GROUP_ID;
import static net.runelite.api.widgets.WidgetID.LEVEL_UP_GROUP_ID;
import static net.runelite.api.widgets.WidgetInfo.DIALOG_SPRITE_TEXT;
import static net.runelite.api.widgets.WidgetInfo.LEVEL_UP_LEVEL;
<<<<<<< HEAD
=======
import static net.runelite.api.widgets.WidgetInfo.PACK;
>>>>>>> initial import of runelite
import net.runelite.client.Notifier;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.DrawManager;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
<<<<<<< HEAD
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
=======
import org.mockito.Matchers;
>>>>>>> initial import of runelite
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
<<<<<<< HEAD
import org.mockito.junit.MockitoJUnitRunner;
=======
import org.mockito.runners.MockitoJUnitRunner;
>>>>>>> initial import of runelite

@RunWith(MockitoJUnitRunner.class)
public class ScreenshotPluginTest
{
	private static final String CLUE_SCROLL = "<col=3300ff>You have completed 28 medium Treasure Trails</col>";
	private static final String BARROWS_CHEST = "Your Barrows chest count is <col=ff0000>310</col>";
	private static final String CHAMBERS_OF_XERIC_CHEST = "Your completed Chambers of Xeric count is: <col=ff0000>489</col>.";
	private static final String THEATRE_OF_BLOOD_CHEST = "Your completed Theatre of Blood count is: <col=ff0000>73</col>.";
	private static final String VALUABLE_DROP = "<col=ef1020>Valuable drop: 6 x Bronze arrow (42 coins)</col>";
	private static final String UNTRADEABLE_DROP = "<col=ef1020>Untradeable drop: Rusty sword";

	@Mock
	@Bind
	private Client client;

	@Inject
	private ScreenshotPlugin screenshotPlugin;

	@Mock
	@Bind
	private ScreenshotConfig screenshotConfig;

	@Mock
	@Bind
	Notifier notifier;

	@Mock
	@Bind
	ClientUI clientUi;

	@Mock
	@Bind
	DrawManager drawManager;

	@Mock
	@Bind
	RuneLiteConfig config;

	@Mock
	@Bind
	ScheduledExecutorService service;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
<<<<<<< HEAD
=======
		when(screenshotConfig.screenshotRewards()).thenReturn(true);
>>>>>>> initial import of runelite
		when(screenshotConfig.screenshotLevels()).thenReturn(true);
		when(screenshotConfig.screenshotValuableDrop()).thenReturn(true);
		when(screenshotConfig.screenshotUntradeableDrop()).thenReturn(true);
	}

	@Test
	public void testClueScroll()
	{
<<<<<<< HEAD
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "Seth", CLUE_SCROLL, null, 0);
=======
		ChatMessage chatMessageEvent = new ChatMessage(null, SERVER, "Seth", CLUE_SCROLL, null, 0);
>>>>>>> initial import of runelite
		screenshotPlugin.onChatMessage(chatMessageEvent);

		assertEquals("medium", screenshotPlugin.getClueType());
		assertEquals(28, screenshotPlugin.getClueNumber());
	}

	@Test
	public void testBarrowsChest()
	{
<<<<<<< HEAD
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "Seth", BARROWS_CHEST, null, 0);
=======
		ChatMessage chatMessageEvent = new ChatMessage(null, SERVER, "Seth", BARROWS_CHEST, null, 0);
>>>>>>> initial import of runelite
		screenshotPlugin.onChatMessage(chatMessageEvent);

		assertEquals(310, screenshotPlugin.getBarrowsNumber());
	}

	@Test
	public void testChambersOfXericChest()
	{
<<<<<<< HEAD
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "Seth", CHAMBERS_OF_XERIC_CHEST, null, 0);
=======
		ChatMessage chatMessageEvent = new ChatMessage(null, SERVER, "Seth", CHAMBERS_OF_XERIC_CHEST, null, 0);
>>>>>>> initial import of runelite
		screenshotPlugin.onChatMessage(chatMessageEvent);

		assertEquals(489, screenshotPlugin.getChambersOfXericNumber());
	}

	@Test
	public void testTheatreOfBloodChest()
	{
<<<<<<< HEAD
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "Magic fTail", THEATRE_OF_BLOOD_CHEST, null, 0);
=======
		ChatMessage chatMessageEvent = new ChatMessage(null, SERVER, "Magic fTail", THEATRE_OF_BLOOD_CHEST, null, 0);
>>>>>>> initial import of runelite
		screenshotPlugin.onChatMessage(chatMessageEvent);

		assertEquals(73, screenshotPlugin.gettheatreOfBloodNumber());
	}

	@Test
	public void testValuableDrop()
	{
<<<<<<< HEAD
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "", VALUABLE_DROP, null, 0);
		screenshotPlugin.onChatMessage(chatMessageEvent);

		verify(drawManager).requestNextFrameListener(any(Consumer.class));
=======
		ChatMessage chatMessageEvent = new ChatMessage(null, SERVER, "", VALUABLE_DROP, null, 0);
		screenshotPlugin.onChatMessage(chatMessageEvent);

		verify(drawManager).requestNextFrameListener(Matchers.any(Consumer.class));
>>>>>>> initial import of runelite
	}

	@Test
	public void testUntradeableDrop()
	{
<<<<<<< HEAD
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "", UNTRADEABLE_DROP, null, 0);
		screenshotPlugin.onChatMessage(chatMessageEvent);

		verify(drawManager).requestNextFrameListener(any(Consumer.class));
=======
		ChatMessage chatMessageEvent = new ChatMessage(null, SERVER, "", UNTRADEABLE_DROP, null, 0);
		screenshotPlugin.onChatMessage(chatMessageEvent);

		verify(drawManager).requestNextFrameListener(Matchers.any(Consumer.class));
>>>>>>> initial import of runelite
	}

	@Test
	public void testHitpointsLevel99()
	{
<<<<<<< HEAD
		Widget levelChild = mock(Widget.class);
		when(client.getWidget(eq(LEVEL_UP_LEVEL))).thenReturn(levelChild);
=======
		Widget widget = mock(Widget.class);
		when(widget.getId()).thenReturn(PACK(LEVEL_UP_GROUP_ID, 0));

		Widget levelChild = mock(Widget.class);
		when(client.getWidget(Matchers.eq(LEVEL_UP_LEVEL))).thenReturn(levelChild);
>>>>>>> initial import of runelite

		when(levelChild.getText()).thenReturn("Your Hitpoints are now 99.");

		assertEquals("Hitpoints(99)", screenshotPlugin.parseLevelUpWidget(LEVEL_UP_LEVEL));

		WidgetLoaded event = new WidgetLoaded();
		event.setGroupId(LEVEL_UP_GROUP_ID);
		screenshotPlugin.onWidgetLoaded(event);

		GameTick tick = new GameTick();
		screenshotPlugin.onGameTick(tick);

<<<<<<< HEAD
		verify(drawManager).requestNextFrameListener(any(Consumer.class));
=======
		verify(drawManager).requestNextFrameListener(Matchers.any(Consumer.class));
>>>>>>> initial import of runelite
	}

	@Test
	public void testFiremakingLevel9()
	{
<<<<<<< HEAD
		Widget levelChild = mock(Widget.class);
		when(client.getWidget(eq(LEVEL_UP_LEVEL))).thenReturn(levelChild);
=======
		Widget widget = mock(Widget.class);
		when(widget.getId()).thenReturn(PACK(LEVEL_UP_GROUP_ID, 0));

		Widget levelChild = mock(Widget.class);
		when(client.getWidget(Matchers.eq(LEVEL_UP_LEVEL))).thenReturn(levelChild);
>>>>>>> initial import of runelite

		when(levelChild.getText()).thenReturn("Your Firemaking level is now 9.");

		assertEquals("Firemaking(9)", screenshotPlugin.parseLevelUpWidget(LEVEL_UP_LEVEL));

		WidgetLoaded event = new WidgetLoaded();
		event.setGroupId(LEVEL_UP_GROUP_ID);
		screenshotPlugin.onWidgetLoaded(event);

		GameTick tick = new GameTick();
		screenshotPlugin.onGameTick(tick);

<<<<<<< HEAD
		verify(drawManager).requestNextFrameListener(any(Consumer.class));
=======
		verify(drawManager).requestNextFrameListener(Matchers.any(Consumer.class));
>>>>>>> initial import of runelite
	}

	@Test
	public void testAttackLevel70()
	{
<<<<<<< HEAD
		Widget levelChild = mock(Widget.class);
		when(client.getWidget(eq(LEVEL_UP_LEVEL))).thenReturn(levelChild);
=======
		Widget widget = mock(Widget.class);
		when(widget.getId()).thenReturn(PACK(LEVEL_UP_GROUP_ID, 0));

		Widget levelChild = mock(Widget.class);
		when(client.getWidget(Matchers.eq(LEVEL_UP_LEVEL))).thenReturn(levelChild);
>>>>>>> initial import of runelite

		when(levelChild.getText()).thenReturn("Your Attack level is now 70.");

		assertEquals("Attack(70)", screenshotPlugin.parseLevelUpWidget(LEVEL_UP_LEVEL));

		WidgetLoaded event = new WidgetLoaded();
		event.setGroupId(LEVEL_UP_GROUP_ID);
		screenshotPlugin.onWidgetLoaded(event);

		GameTick tick = new GameTick();
		screenshotPlugin.onGameTick(tick);

<<<<<<< HEAD
		verify(drawManager).requestNextFrameListener(any(Consumer.class));
=======
		verify(drawManager).requestNextFrameListener(Matchers.any(Consumer.class));
>>>>>>> initial import of runelite
	}

	@Test
	public void testHunterLevel2()
	{
<<<<<<< HEAD
		Widget levelChild = mock(Widget.class);
		when(client.getWidget(eq(DIALOG_SPRITE_TEXT))).thenReturn(levelChild);
=======
		Widget widget = mock(Widget.class);
		when(widget.getId()).thenReturn(PACK(DIALOG_SPRITE_GROUP_ID, 0));

		Widget levelChild = mock(Widget.class);
		when(client.getWidget(Matchers.eq(DIALOG_SPRITE_TEXT))).thenReturn(levelChild);
>>>>>>> initial import of runelite

		when(levelChild.getText()).thenReturn("<col=000080>Congratulations, you've just advanced a Hunter level.<col=000000><br><br>Your Hunter level is now 2.");

		assertEquals("Hunter(2)", screenshotPlugin.parseLevelUpWidget(DIALOG_SPRITE_TEXT));

		WidgetLoaded event = new WidgetLoaded();
		event.setGroupId(DIALOG_SPRITE_GROUP_ID);
		screenshotPlugin.onWidgetLoaded(event);

		GameTick tick = new GameTick();
		screenshotPlugin.onGameTick(tick);

<<<<<<< HEAD
		verify(drawManager).requestNextFrameListener(any(Consumer.class));
=======
		verify(drawManager).requestNextFrameListener(Matchers.any(Consumer.class));
>>>>>>> initial import of runelite
	}
}
