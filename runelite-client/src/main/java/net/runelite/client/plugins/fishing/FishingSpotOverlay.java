/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.fishing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.time.Duration;
import java.time.Instant;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.api.GraphicID;
import net.runelite.api.NPC;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
<<<<<<< HEAD
import net.runelite.api.coords.WorldPoint;
=======
>>>>>>> initial import of runelite
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.ProgressPieComponent;
<<<<<<< HEAD
import net.runelite.client.util.ImageUtil;
=======
>>>>>>> initial import of runelite

class FishingSpotOverlay extends Overlay
{
	private static final Duration MINNOW_MOVE = Duration.ofSeconds(15);
	private static final Duration MINNOW_WARN = Duration.ofSeconds(3);
<<<<<<< HEAD
	private static final int ONE_TICK_AERIAL_FISHING = 3;
=======
>>>>>>> initial import of runelite

	private final FishingPlugin plugin;
	private final FishingConfig config;
	private final Client client;
	private final ItemManager itemManager;

	@Setter(AccessLevel.PACKAGE)
	private boolean hidden;

	@Inject
	private FishingSpotOverlay(FishingPlugin plugin, FishingConfig config, Client client, ItemManager itemManager)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.plugin = plugin;
		this.config = config;
		this.client = client;
		this.itemManager = itemManager;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (hidden)
		{
			return null;
		}

<<<<<<< HEAD
		FishingSpot previousSpot = null;
		WorldPoint previousLocation = null;
		for (NPC npc : plugin.getFishingSpots())
		{
			FishingSpot spot = FishingSpot.findSpot(npc.getId());
=======
		for (NPC npc : plugin.getFishingSpots())
		{
			FishingSpot spot = FishingSpot.getSPOTS().get(npc.getId());
>>>>>>> initial import of runelite

			if (spot == null)
			{
				continue;
			}

			if (config.onlyCurrentSpot() && plugin.getCurrentSpot() != null && plugin.getCurrentSpot() != spot)
			{
				continue;
			}

<<<<<<< HEAD
			// This relies on the sort order to keep identical npcs on the same tile adjacent to each other
			if (previousSpot == spot && previousLocation.equals(npc.getWorldLocation()))
			{
				continue;
			}

			Color color;
			if (npc.getGraphic() == GraphicID.FLYING_FISH)
			{
				color = config.getMinnowsOverlayColor();
			}
			else if (spot == FishingSpot.COMMON_TENCH && npc.getWorldLocation().distanceTo2D(client.getLocalPlayer().getWorldLocation()) <= ONE_TICK_AERIAL_FISHING)
			{
				color = config.getAerialOverlayColor();
			}
			else
			{
				color = config.getOverlayColor();
			}
=======
			Color color = npc.getGraphic() == GraphicID.FLYING_FISH ? Color.RED : Color.CYAN;
>>>>>>> initial import of runelite

			if (spot == FishingSpot.MINNOW && config.showMinnowOverlay())
			{
				MinnowSpot minnowSpot = plugin.getMinnowSpots().get(npc.getIndex());
				if (minnowSpot != null)
				{
					long millisLeft = MINNOW_MOVE.toMillis() - Duration.between(minnowSpot.getTime(), Instant.now()).toMillis();
					if (millisLeft < MINNOW_WARN.toMillis())
					{
						color = Color.ORANGE;
					}

					LocalPoint localPoint = npc.getLocalLocation();
					Point location = Perspective.localToCanvas(client, localPoint, client.getPlane());

					if (location != null)
					{
						ProgressPieComponent pie = new ProgressPieComponent();
						pie.setFill(color);
						pie.setBorderColor(color);
						pie.setPosition(location);
						pie.setProgress((float) millisLeft / MINNOW_MOVE.toMillis());
						pie.render(graphics);
					}
				}
			}

			if (config.showSpotTiles())
			{
				Polygon poly = npc.getCanvasTilePoly();
<<<<<<< HEAD

=======
>>>>>>> initial import of runelite
				if (poly != null)
				{
					OverlayUtil.renderPolygon(graphics, poly, color.darker());
				}
			}

			if (config.showSpotIcons())
			{
<<<<<<< HEAD
				BufferedImage fishImage = itemManager.getImage(spot.getFishSpriteId());

				if (spot == FishingSpot.COMMON_TENCH
					&& npc.getWorldLocation().distanceTo2D(client.getLocalPlayer().getWorldLocation()) <= ONE_TICK_AERIAL_FISHING)
				{
					fishImage = ImageUtil.outlineImage(itemManager.getImage(spot.getFishSpriteId()), color);
				}

=======
				BufferedImage fishImage = itemManager.getImage(spot.getFishSpriteId());;
>>>>>>> initial import of runelite
				if (fishImage != null)
				{
					Point imageLocation = npc.getCanvasImageLocation(fishImage, npc.getLogicalHeight());
					if (imageLocation != null)
					{
						OverlayUtil.renderImageLocation(graphics, imageLocation, fishImage);
					}
				}
			}

			if (config.showSpotNames())
			{
				String text = spot.getName();
				Point textLocation = npc.getCanvasTextLocation(graphics, text, npc.getLogicalHeight() + 40);
<<<<<<< HEAD

=======
>>>>>>> initial import of runelite
				if (textLocation != null)
				{
					OverlayUtil.renderTextLocation(graphics, textLocation, text, color.darker());
				}
			}
<<<<<<< HEAD

			previousSpot = spot;
			previousLocation = npc.getWorldLocation();
=======
>>>>>>> initial import of runelite
		}

		return null;
	}
}
