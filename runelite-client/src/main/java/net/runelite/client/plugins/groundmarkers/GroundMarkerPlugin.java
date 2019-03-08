/*
 * Copyright (c) 2018, TheLonelyDev <https://github.com/TheLonelyDev>
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
package net.runelite.client.plugins.groundmarkers;

import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Provides;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.Tile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@Slf4j
@PluginDescriptor(
	name = "Ground Markers",
	description = "Enable marking of tiles using the Shift key",
	tags = {"overlay", "tiles"}
)
public class GroundMarkerPlugin extends Plugin
{
	private static final String CONFIG_GROUP = "groundMarker";
	private static final String MARK = "Mark tile";
<<<<<<< HEAD
	private static final String UNMARK = "Unmark tile";
	private static final String WALK_HERE = "Walk here";
	private static final String REGION_PREFIX = "region_";

	private static final Gson GSON = new Gson();
=======
	private static final String WALK_HERE = "Walk here";

	private static final Gson gson = new Gson();
>>>>>>> initial import of runelite

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private boolean hotKeyPressed;

	@Getter(AccessLevel.PACKAGE)
<<<<<<< HEAD
	private final List<ColorTileMarker> points = new ArrayList<>();
=======
	private final List<WorldPoint> points = new ArrayList<>();
>>>>>>> initial import of runelite

	@Inject
	private Client client;

	@Inject
<<<<<<< HEAD
	private GroundMarkerConfig config;

	@Inject
=======
>>>>>>> initial import of runelite
	private GroundMarkerInputListener inputListener;

	@Inject
	private ConfigManager configManager;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private GroundMarkerOverlay overlay;

	@Inject
<<<<<<< HEAD
	private GroundMarkerMinimapOverlay minimapOverlay;

	@Inject
=======
>>>>>>> initial import of runelite
	private KeyManager keyManager;

	private void savePoints(int regionId, Collection<GroundMarkerPoint> points)
	{
		if (points == null || points.isEmpty())
		{
<<<<<<< HEAD
			configManager.unsetConfiguration(CONFIG_GROUP, REGION_PREFIX + regionId);
			return;
		}

		String json = GSON.toJson(points);
		configManager.setConfiguration(CONFIG_GROUP, REGION_PREFIX + regionId, json);
=======
			configManager.unsetConfiguration(CONFIG_GROUP, "region_" + regionId);
			return;
		}

		String json = gson.toJson(points);
		configManager.setConfiguration(CONFIG_GROUP, "region_" + regionId, json);
>>>>>>> initial import of runelite
	}

	private Collection<GroundMarkerPoint> getPoints(int regionId)
	{
<<<<<<< HEAD
		String json = configManager.getConfiguration(CONFIG_GROUP, REGION_PREFIX + regionId);
		if (Strings.isNullOrEmpty(json))
		{
			return Collections.emptyList();
		}

		// CHECKSTYLE:OFF
		return GSON.fromJson(json, new TypeToken<List<GroundMarkerPoint>>(){}.getType());
		// CHECKSTYLE:ON
=======
		String json = configManager.getConfiguration(CONFIG_GROUP, "region_" + regionId);
		if (Strings.isNullOrEmpty(json))
		{
			return Collections.EMPTY_LIST;
		}
		return gson.fromJson(json, new TypeToken<List<GroundMarkerPoint>>()
		{
		}.getType());
>>>>>>> initial import of runelite
	}

	@Provides
	GroundMarkerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(GroundMarkerConfig.class);
	}

	private void loadPoints()
	{
		points.clear();

		int[] regions = client.getMapRegions();
<<<<<<< HEAD

		if (regions == null)
		{
			return;
		}

=======
>>>>>>> initial import of runelite
		for (int regionId : regions)
		{
			// load points for region
			log.debug("Loading points for region {}", regionId);
			Collection<GroundMarkerPoint> regionPoints = getPoints(regionId);
<<<<<<< HEAD
			Collection<ColorTileMarker> colorTileMarkers = translateToColorTileMarker(regionPoints);
			points.addAll(colorTileMarkers);
=======
			Collection<WorldPoint> worldPoints = translateToWorld(regionPoints);
			points.addAll(worldPoints);
>>>>>>> initial import of runelite
		}
	}

	/**
<<<<<<< HEAD
	 * Translate a collection of ground marker points to color tile markers, accounting for instances
	 *
	 * @param points {@link GroundMarkerPoint}s to be converted to {@link ColorTileMarker}s
	 * @return A collection of color tile markers, converted from the passed ground marker points, accounting for local
	 *         instance points. See {@link WorldPoint#toLocalInstance(Client, WorldPoint)}
	 */
	private Collection<ColorTileMarker> translateToColorTileMarker(Collection<GroundMarkerPoint> points)
	{
		if (points.isEmpty())
		{
			return Collections.emptyList();
		}

		return points.stream()
			.map(point -> new ColorTileMarker(
				WorldPoint.fromRegion(point.getRegionId(), point.getRegionX(), point.getRegionY(), point.getZ()),
				point.getColor()))
			.flatMap(colorTile ->
			{
				final Collection<WorldPoint> localWorldPoints = WorldPoint.toLocalInstance(client, colorTile.getWorldPoint());
				return localWorldPoints.stream().map(wp -> new ColorTileMarker(wp, colorTile.getColor()));
			})
=======
	 * Translate a collection of ground marker points to world points, accounting for instances
	 *
	 * @param points
	 * @return
	 */
	private Collection<WorldPoint> translateToWorld(Collection<GroundMarkerPoint> points)
	{
		if (points.isEmpty())
		{
			return Collections.EMPTY_LIST;
		}

		return points.stream()
			.map(point ->
			{
				int regionId = point.getRegionId();
				int regionX = point.getRegionX();
				int regionY = point.getRegionY();
				int z = point.getZ();

				// world point of the tile marker
				return new WorldPoint(
					((regionId >>> 8) << 6) + regionX,
					((regionId & 0xff) << 6) + regionY,
					z
				);
			})
			.flatMap(wp -> WorldPoint.toLocalInstance(client, wp).stream())
>>>>>>> initial import of runelite
			.collect(Collectors.toList());
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		// map region has just been updated
		loadPoints();
	}

	@Subscribe
	public void onFocusChanged(FocusChanged focusChanged)
	{
		if (!focusChanged.isFocused())
		{
			hotKeyPressed = false;
		}
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (hotKeyPressed && event.getOption().equals(WALK_HERE))
		{
<<<<<<< HEAD
			final Tile selectedSceneTile = client.getSelectedSceneTile();

			if (selectedSceneTile == null)
			{
				return;
			}

			MenuEntry[] menuEntries = client.getMenuEntries();
			menuEntries = Arrays.copyOf(menuEntries, menuEntries.length + 1);
			MenuEntry menuEntry = menuEntries[menuEntries.length - 1] = new MenuEntry();

			final WorldPoint worldPoint = WorldPoint.fromLocalInstance(client, selectedSceneTile.getLocalLocation());
			final int regionId = worldPoint.getRegionID();
			final GroundMarkerPoint point = new GroundMarkerPoint(regionId, worldPoint.getRegionX(), worldPoint.getRegionY(), client.getPlane(), config.markerColor());

			menuEntry.setOption(getPoints(regionId).contains(point) ? UNMARK : MARK);
			menuEntry.setTarget(event.getTarget());
			menuEntry.setType(MenuAction.RUNELITE.getId());
=======
			MenuEntry[] menuEntries = client.getMenuEntries();
			menuEntries = Arrays.copyOf(menuEntries, menuEntries.length + 1);

			MenuEntry menuEntry = menuEntries[menuEntries.length - 1] = new MenuEntry();

			menuEntry.setOption(MARK);
			menuEntry.setTarget(event.getTarget());
			menuEntry.setType(MenuAction.CANCEL.getId());
>>>>>>> initial import of runelite

			client.setMenuEntries(menuEntries);
		}
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
<<<<<<< HEAD
		if (event.getMenuAction().getId() != MenuAction.RUNELITE.getId() ||
			!(event.getMenuOption().equals(MARK) || event.getMenuOption().equals(UNMARK)))
=======
		if (!event.getMenuOption().equals(MARK))
>>>>>>> initial import of runelite
		{
			return;
		}

		Tile target = client.getSelectedSceneTile();
		if (target == null)
		{
			return;
		}
		markTile(target.getLocalLocation());
	}

	@Override
	protected void startUp()
	{
		overlayManager.add(overlay);
<<<<<<< HEAD
		overlayManager.add(minimapOverlay);
		keyManager.registerKeyListener(inputListener);
		loadPoints();
=======
		keyManager.registerKeyListener(inputListener);
>>>>>>> initial import of runelite
	}

	@Override
	protected void shutDown()
	{
		overlayManager.remove(overlay);
<<<<<<< HEAD
		overlayManager.remove(minimapOverlay);
		keyManager.unregisterKeyListener(inputListener);
		points.clear();
	}

	private void markTile(LocalPoint localPoint)
=======
		keyManager.unregisterKeyListener(inputListener);
	}


	protected void markTile(LocalPoint localPoint)
>>>>>>> initial import of runelite
	{
		if (localPoint == null)
		{
			return;
		}

		WorldPoint worldPoint = WorldPoint.fromLocalInstance(client, localPoint);

		int regionId = worldPoint.getRegionID();
<<<<<<< HEAD
		GroundMarkerPoint point = new GroundMarkerPoint(regionId, worldPoint.getRegionX(), worldPoint.getRegionY(), client.getPlane(), config.markerColor());
		log.debug("Updating point: {} - {}", point, worldPoint);

		List<GroundMarkerPoint> groundMarkerPoints = new ArrayList<>(getPoints(regionId));
		if (groundMarkerPoints.contains(point))
		{
			groundMarkerPoints.remove(point);
		}
		else
		{
			groundMarkerPoints.add(point);
		}

		savePoints(regionId, groundMarkerPoints);

		loadPoints();
	}
}
=======
		GroundMarkerPoint point = new GroundMarkerPoint(regionId, worldPoint.getX() & 0x3f, worldPoint.getY() & 0x3f, client.getPlane());
		log.debug("Updating point: {} - {}", point, worldPoint);

		List<GroundMarkerPoint> points = new ArrayList<>(getPoints(regionId));
		if (points.contains(point))
		{
			points.remove(point);
		}
		else
		{
			points.add(point);
		}

		savePoints(regionId, points);

		loadPoints();
	}
}
>>>>>>> initial import of runelite
