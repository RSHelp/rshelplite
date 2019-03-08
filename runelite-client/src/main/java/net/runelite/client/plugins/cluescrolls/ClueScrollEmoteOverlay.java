/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
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
package net.runelite.client.plugins.cluescrolls;

<<<<<<< HEAD
import java.awt.Dimension;
import java.awt.Graphics2D;
=======
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Area;
>>>>>>> initial import of runelite
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.cluescrolls.clues.ClueScroll;
import net.runelite.client.plugins.cluescrolls.clues.EmoteClue;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
<<<<<<< HEAD

class ClueScrollEmoteOverlay extends Overlay
{
	private final ClueScrollPlugin plugin;
	private final Client client;

	private boolean hasScrolled;

	@Inject
	private ClueScrollEmoteOverlay(ClueScrollPlugin plugin, Client client)
=======
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.TextComponent;

public class ClueScrollEmoteOverlay extends Overlay
{
	private static final Color HIGHLIGHT_BORDER_COLOR = Color.ORANGE;
	private static final Color HIGHLIGHT_HOVER_BORDER_COLOR = HIGHLIGHT_BORDER_COLOR.darker();
	private static final Color HIGHLIGHT_FILL_COLOR = new Color(0, 255, 0, 20);

	private final ClueScrollPlugin plugin;
	private final Client client;
	private final TextComponent textComponent = new TextComponent();

	@Inject
	public ClueScrollEmoteOverlay(ClueScrollPlugin plugin, Client client)
>>>>>>> initial import of runelite
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.plugin = plugin;
		this.client = client;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		ClueScroll clue = plugin.getClue();

<<<<<<< HEAD
		if (!(clue instanceof EmoteClue))
		{
			hasScrolled = false;
=======
		if (clue == null || !(clue instanceof EmoteClue))
		{
>>>>>>> initial import of runelite
			return null;
		}

		EmoteClue emoteClue = (EmoteClue) clue;

		if (!emoteClue.getFirstEmote().hasSprite())
		{
			return null;
		}

		Widget emoteContainer = client.getWidget(WidgetInfo.EMOTE_CONTAINER);

		if (emoteContainer == null || emoteContainer.isHidden())
		{
			return null;
		}

		Widget emoteWindow = client.getWidget(WidgetInfo.EMOTE_WINDOW);

		if (emoteWindow == null)
		{
			return null;
		}

<<<<<<< HEAD
		Widget firstEmoteWidget = null;
		Widget secondEmoteWidget = null;

=======
>>>>>>> initial import of runelite
		for (Widget emoteWidget : emoteContainer.getDynamicChildren())
		{
			if (emoteWidget.getSpriteId() == emoteClue.getFirstEmote().getSpriteId())
			{
<<<<<<< HEAD
				firstEmoteWidget = emoteWidget;
				plugin.highlightWidget(graphics, emoteWidget, emoteWindow, null,
					emoteClue.getSecondEmote() != null ? "1st" : null);
=======
				highlightWidget(graphics, emoteWindow, emoteWidget,
					emoteClue.getSecondEmote() != null ? "1st" : "");
>>>>>>> initial import of runelite
			}
			else if (emoteClue.getSecondEmote() != null
				&& emoteWidget.getSpriteId() == emoteClue.getSecondEmote().getSpriteId())
			{
<<<<<<< HEAD
				secondEmoteWidget = emoteWidget;
				plugin.highlightWidget(graphics, emoteWidget, emoteWindow, null, "2nd");
			}
		}
		if (!hasScrolled)
		{
			hasScrolled = true;
			plugin.scrollToWidget(WidgetInfo.EMOTE_CONTAINER, WidgetInfo.EMOTE_SCROLLBAR, firstEmoteWidget, secondEmoteWidget);
		}

		return null;
=======
				highlightWidget(graphics, emoteWindow, emoteWidget, "2nd");
			}
		}

		return null;
	}

	private void highlightWidget(Graphics2D graphics, Widget window, Widget widget, String text)
	{
		net.runelite.api.Point canvasLocation = widget.getCanvasLocation();

		if (canvasLocation == null)
		{
			return;
		}

		// Don't draw outside the emotes window
		net.runelite.api.Point windowLocation = window.getCanvasLocation();

		if (windowLocation.getY() > canvasLocation.getY() + widget.getHeight()
			|| windowLocation.getY() + window.getHeight() < canvasLocation.getY())
		{
			return;
		}

		// Visible area of emote widget
		Area widgetArea = new Area(
			new Rectangle(
				canvasLocation.getX(),
				Math.max(canvasLocation.getY(), windowLocation.getY()),
				widget.getWidth(),
				Math.min(
					Math.min(windowLocation.getY() + window.getHeight() - canvasLocation.getY(), widget.getHeight()),
					Math.min(canvasLocation.getY() + widget.getHeight() - windowLocation.getY(), widget.getHeight()))));

		OverlayUtil.renderHoverableArea(graphics, widgetArea, client.getMouseCanvasPosition(),
				HIGHLIGHT_FILL_COLOR, HIGHLIGHT_BORDER_COLOR, HIGHLIGHT_HOVER_BORDER_COLOR);

		FontMetrics fontMetrics = graphics.getFontMetrics();

		textComponent.setPosition(new Point(
			canvasLocation.getX() + widget.getWidth() / 2 - fontMetrics.stringWidth(text) / 2,
			canvasLocation.getY() + fontMetrics.getHeight()));
		textComponent.setText(text);
		textComponent.render(graphics);
>>>>>>> initial import of runelite
	}
}
