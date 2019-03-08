/*
 * Copyright (c) 2018, Eadgars Ruse <https://github.com/Eadgars-Ruse>
<<<<<<< HEAD
 * Copyright (c) 2019, Jordan Atwood <nightfirecat@protonmail.com>
=======
>>>>>>> initial import of runelite
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
package net.runelite.client.plugins.cluescrolls.clues;

<<<<<<< HEAD
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
=======
import com.google.common.collect.Lists;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
>>>>>>> initial import of runelite
import net.runelite.api.NPC;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import static net.runelite.client.plugins.cluescrolls.ClueScrollOverlay.TITLED_CONTENT_COLOR;
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import static net.runelite.client.plugins.cluescrolls.ClueScrollWorldOverlay.IMAGE_Z_OFFSET;
import net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdArea;
import net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdLocation;
<<<<<<< HEAD
import net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdSolver;
import net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdTemperature;
import net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdTemperatureChange;
=======
>>>>>>> initial import of runelite
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

<<<<<<< HEAD
@EqualsAndHashCode(callSuper = false, exclude = { "hotColdSolver", "location" })
@Getter
@Slf4j
public class HotColdClue extends ClueScroll implements LocationClueScroll, LocationsClueScroll, TextClueScroll, NpcClueScroll
{
	private static final int HOT_COLD_PANEL_WIDTH = 200;
	private static final HotColdClue BEGINNER_CLUE = new HotColdClue("Buried beneath the ground, who knows where it's found. Lucky for you, A man called Reldo may have a clue.",
		"Reldo",
		"Speak to Reldo to receive a strange device.",
		new WorldPoint(3211, 3494, 0));
	private static final HotColdClue MASTER_CLUE = new HotColdClue("Buried beneath the ground, who knows where it's found. Lucky for you, A man called Jorral may have a clue.",
		"Jorral",
		"Speak to Jorral to receive a strange device.",
		new WorldPoint(2436, 3347, 0));

	private final String text;
	private final String npc;
	private final String solution;
	private final WorldPoint npcLocation;
	@Nullable
	private HotColdSolver hotColdSolver;
	private WorldPoint location;

	public static HotColdClue forText(String text)
	{
		if (BEGINNER_CLUE.text.equalsIgnoreCase(text))
		{
			BEGINNER_CLUE.reset();
			return BEGINNER_CLUE;
		}
		else if (MASTER_CLUE.text.equalsIgnoreCase(text))
		{
			MASTER_CLUE.reset();
			return MASTER_CLUE;
=======
@Getter
@RequiredArgsConstructor
public class HotColdClue extends ClueScroll implements LocationClueScroll, LocationsClueScroll, TextClueScroll, NpcClueScroll
{
	private static final Pattern INITIAL_STRANGE_DEVICE_MESSAGE = Pattern.compile("The device is (.*)");
	private static final Pattern STRANGE_DEVICE_MESSAGE = Pattern.compile("The device is (.*), (.*) last time\\.");
	private static final Pattern FINAL_STRANGE_DEVICE_MESSAGE = Pattern.compile("The device is visibly shaking.*");
	private static final HotColdClue CLUE =
		new HotColdClue("Buried beneath the ground, who knows where it's found. Lucky for you, A man called Jorral may have a clue.",
			"Jorral",
			"Speak to Jorral to receive a strange device.");

	// list of potential places to dig
	private List<HotColdLocation> digLocations = new ArrayList<>();
	private final String text;
	private final String npc;
	private final String solution;
	private WorldPoint location;
	private WorldPoint lastWorldPoint;

	public static HotColdClue forText(String text)
	{
		if (CLUE.text.equalsIgnoreCase(text))
		{
			return CLUE;
>>>>>>> initial import of runelite
		}

		return null;
	}

<<<<<<< HEAD
	private HotColdClue(String text, String npc, String solution, WorldPoint npcLocation)
	{
		this.text = text;
		this.npc = npc;
		this.solution = solution;
		this.npcLocation = npcLocation;
		setRequiresSpade(true);
		initializeSolver();
	}

	@Override
	public WorldPoint[] getLocations()
	{
		if (hotColdSolver == null)
		{
			return new WorldPoint[0];
		}

		if (hotColdSolver.getLastWorldPoint() == null)
		{
			return new WorldPoint[] {npcLocation};
		}
		else
		{
			return hotColdSolver.getPossibleLocations().stream().map(HotColdLocation::getWorldPoint).toArray(WorldPoint[]::new);
		}
=======
	@Override
	public WorldPoint[] getLocations()
	{
		return Lists.transform(digLocations, HotColdLocation::getWorldPoint).toArray(new WorldPoint[0]);
>>>>>>> initial import of runelite
	}

	@Override
	public void makeOverlayHint(PanelComponent panelComponent, ClueScrollPlugin plugin)
	{
<<<<<<< HEAD
		if (hotColdSolver == null)
		{
			return;
		}

		panelComponent.getChildren().add(TitleComponent.builder()
			.text("Hot/Cold Clue")
			.build());
		panelComponent.setPreferredSize(new Dimension(HOT_COLD_PANEL_WIDTH, 0));

		// strange device has not been tested yet, show how to get it
		if (hotColdSolver.getLastWorldPoint() == null && location == null)
=======
		panelComponent.getChildren().add(TitleComponent.builder()
			.text("Hot/Cold Clue")
			.build());
		panelComponent.setPreferredSize(new Dimension(200, 0));

		// strange device has not been tested yet, show how to get it
		if (lastWorldPoint == null && location == null)
>>>>>>> initial import of runelite
		{
			if (getNpc() != null)
			{
				panelComponent.getChildren().add(LineComponent.builder()
					.left("NPC:")
					.build());
				panelComponent.getChildren().add(LineComponent.builder()
					.left(getNpc())
					.leftColor(TITLED_CONTENT_COLOR)
					.build());
			}

			panelComponent.getChildren().add(LineComponent.builder()
				.left("Solution:")
				.build());
			panelComponent.getChildren().add(LineComponent.builder()
				.left(getSolution())
				.leftColor(TITLED_CONTENT_COLOR)
				.build());
		}
		// strange device has been tested, show possible locations for final dig spot
		else
		{
			panelComponent.getChildren().add(LineComponent.builder()
<<<<<<< HEAD
				.left("Possible locations:")
				.build());

			final Map<HotColdArea, Integer> locationCounts = new EnumMap<>(HotColdArea.class);
			final Collection<HotColdLocation> digLocations = hotColdSolver.getPossibleLocations();
=======
				.left("Possible areas:")
				.build());
			Map<HotColdArea, Integer> locationCounts = new HashMap<>();
>>>>>>> initial import of runelite

			for (HotColdLocation hotColdLocation : digLocations)
			{
				HotColdArea hotColdArea = hotColdLocation.getHotColdArea();

				if (locationCounts.containsKey(hotColdArea))
				{
					locationCounts.put(hotColdArea, locationCounts.get(hotColdArea) + 1);
				}
				else
				{
					locationCounts.put(hotColdArea, 1);
				}
			}

			if (digLocations.size() > 10)
			{
				for (HotColdArea area : locationCounts.keySet())
				{
					panelComponent.getChildren().add(LineComponent.builder()
						.left(area.getName())
						.right(Integer.toString(locationCounts.get(area)))
						.build());
				}
			}
			else
			{
<<<<<<< HEAD
				for (HotColdArea area : locationCounts.keySet())
				{
					panelComponent.getChildren().add(LineComponent.builder()
						.left(area.getName() + ':')
=======
				for (HotColdArea s : locationCounts.keySet())
				{
					panelComponent.getChildren().add(LineComponent.builder()
						.left(s.getName() + ":")
>>>>>>> initial import of runelite
						.build());

					for (HotColdLocation hotColdLocation : digLocations)
					{
<<<<<<< HEAD
						if (hotColdLocation.getHotColdArea() == area)
						{
=======
						if (hotColdLocation.getHotColdArea() == s)
						{
							Rectangle2D r = hotColdLocation.getRect();
>>>>>>> initial import of runelite
							panelComponent.getChildren().add(LineComponent.builder()
								.left("- " + hotColdLocation.getArea())
								.leftColor(Color.LIGHT_GRAY)
								.build());
						}
					}
				}
			}
		}
	}

	@Override
	public void makeWorldOverlayHint(Graphics2D graphics, ClueScrollPlugin plugin)
	{
<<<<<<< HEAD
		if (hotColdSolver == null)
		{
			return;
		}

		// when final location has been found
		if (location != null)
=======
		// when final location has been found
		if (this.location != null)
>>>>>>> initial import of runelite
		{
			LocalPoint localLocation = LocalPoint.fromWorld(plugin.getClient(), getLocation());

			if (localLocation != null)
			{
				OverlayUtil.renderTileOverlay(plugin.getClient(), graphics, localLocation, plugin.getSpadeImage(), Color.ORANGE);
			}

			return;
		}

<<<<<<< HEAD
		// when strange device hasn't been activated yet, show npc who gives you the strange device
		if (hotColdSolver.getLastWorldPoint() == null && plugin.getNpcsToMark() != null)
		{
			for (NPC npcToMark : plugin.getNpcsToMark())
			{
				OverlayUtil.renderActorOverlayImage(graphics, npcToMark, plugin.getClueScrollImage(), Color.ORANGE, IMAGE_Z_OFFSET);
=======
		// when strange device hasn't been activated yet, show Jorral
		if (lastWorldPoint == null)
		{
			// Mark NPC
			if (plugin.getNpcsToMark() != null)
			{
				for (NPC npc : plugin.getNpcsToMark())
				{
					OverlayUtil.renderActorOverlayImage(graphics, npc, plugin.getClueScrollImage(), Color.ORANGE, IMAGE_Z_OFFSET);
				}
>>>>>>> initial import of runelite
			}
		}

		// once the number of possible dig locations is below 10, show the dig spots
<<<<<<< HEAD
		final Collection<HotColdLocation> digLocations = hotColdSolver.getPossibleLocations();
=======
>>>>>>> initial import of runelite
		if (digLocations.size() < 10)
		{
			// Mark potential dig locations
			for (HotColdLocation hotColdLocation : digLocations)
			{
				WorldPoint wp = hotColdLocation.getWorldPoint();
				LocalPoint localLocation = LocalPoint.fromWorld(plugin.getClient(), wp.getX(), wp.getY());

				if (localLocation == null)
				{
					return;
				}

				OverlayUtil.renderTileOverlay(plugin.getClient(), graphics, localLocation, plugin.getSpadeImage(), Color.ORANGE);
			}
		}
	}

	public boolean update(final String message, final ClueScrollPlugin plugin)
	{
<<<<<<< HEAD
		if (hotColdSolver == null)
=======
		if (!message.startsWith("The device is"))
>>>>>>> initial import of runelite
		{
			return false;
		}

<<<<<<< HEAD
		final Set<HotColdTemperature> temperatureSet;

		if (this.equals(BEGINNER_CLUE))
		{
			temperatureSet = HotColdTemperature.BEGINNER_HOT_COLD_TEMPERATURES;
		}
		else if (this.equals(MASTER_CLUE))
		{
			temperatureSet = HotColdTemperature.MASTER_HOT_COLD_TEMPERATURES;
		}
		else
		{
			temperatureSet = null;
		}

		final HotColdTemperature temperature = HotColdTemperature.getFromTemperatureSet(temperatureSet, message);

		if (temperature == null)
		{
			return false;
		}

		// Convert from real to overworld
		final WorldPoint localWorld = ClueScrollPlugin.getMirrorPoint(plugin.getClient().getLocalPlayer().getWorldLocation(), true);

		if (localWorld == null)
		{
			return false;
		}

		if ((this.equals(BEGINNER_CLUE) && temperature == HotColdTemperature.BEGINNER_VISIBLY_SHAKING)
			|| (this.equals(MASTER_CLUE) && temperature == HotColdTemperature.MASTER_VISIBLY_SHAKING))
		{
			markFinalSpot(localWorld);
		}
		else
		{
			location = null;
		}

		final HotColdTemperatureChange temperatureChange = HotColdTemperatureChange.of(message);
		hotColdSolver.signal(localWorld, temperature, temperatureChange);

		return true;
	}

	@Override
	public void reset()
	{
		location = null;
		initializeSolver();
	}

	private void initializeSolver()
	{
		final boolean isBeginner;

		if (this.equals(BEGINNER_CLUE))
		{
			isBeginner = true;
		}
		else if (this.equals(MASTER_CLUE))
		{
			isBeginner = false;
		}
		else
		{
			log.warn("Hot cold solver could not be initialized, clue type is unknown; text: {}, npc: {}, solution: {}",
				text, npc, solution);
			hotColdSolver = null;
			return;
		}

		final Set<HotColdLocation> locations = Arrays.stream(HotColdLocation.values())
			.filter(l -> l.isBeginnerClue() == isBeginner)
			.collect(Collectors.toSet());
		hotColdSolver = new HotColdSolver(locations);
=======
		Matcher m1 = FINAL_STRANGE_DEVICE_MESSAGE.matcher(message);
		Matcher m2 = STRANGE_DEVICE_MESSAGE.matcher(message);
		Matcher m3 = INITIAL_STRANGE_DEVICE_MESSAGE.matcher(message);

		// the order that these pattern matchers are checked is important
		if (m1.find())
		{
			// final location for hot cold clue has been found
			WorldPoint localWorld = plugin.getClient().getLocalPlayer().getWorldLocation();

			if (localWorld != null)
			{
				markFinalSpot(localWorld);
				return true;
			}
		}
		else if (m2.find())
		{
			String temperature = m2.group(1);
			String difference = m2.group(2);
			WorldPoint localWorld = plugin.getClient().getLocalPlayer().getWorldLocation();

			if (localWorld != null)
			{
				updatePossibleArea(localWorld, temperature, difference);
				return true;
			}
		}
		else if (m3.find())
		{
			String temperature = m3.group(1);
			WorldPoint localWorld = plugin.getClient().getLocalPlayer().getWorldLocation();

			if (localWorld != null)
			{
				updatePossibleArea(localWorld, temperature, "");
				return true;
			}
		}

		return false;
	}

	@Override
	public void reset()
	{
		this.lastWorldPoint = null;
		digLocations.clear();
	}

	private void updatePossibleArea(WorldPoint currentWp, String temperature, String difference)
	{
		this.location = null;

		if (digLocations.isEmpty())
		{
			digLocations.addAll(Arrays.asList(HotColdLocation.values()));
		}

		int maxSquaresAway = 5000;
		int minSquaresAway = 0;

		switch (temperature)
		{
			// when the strange device reads a temperature, that means that the center of the final dig location
			// is a range of squares away from the player's current location (Chebyshev AKA Chess-board distance)
			case "ice cold":
				maxSquaresAway = 5000;
				minSquaresAway = 500;
				break;
			case "very cold":
				maxSquaresAway = 499;
				minSquaresAway = 200;
				break;
			case "cold":
				maxSquaresAway = 199;
				minSquaresAway = 150;
				break;
			case "warm":
				maxSquaresAway = 149;
				minSquaresAway = 100;
				break;
			case "hot":
				maxSquaresAway = 99;
				minSquaresAway = 70;
				break;
			case "very hot":
				maxSquaresAway = 69;
				minSquaresAway = 30;
				break;
			case "incredibly hot":
				maxSquaresAway = 29;
				minSquaresAway = 5;
				break;
		}

		// rectangle r1 encompasses all of the points that are within the max possible distance from the player
		Point p1 = new Point(currentWp.getX() - maxSquaresAway, currentWp.getY() - maxSquaresAway);
		Rectangle r1 = new Rectangle((int) p1.getX(), (int) p1.getY(), 2 * maxSquaresAway + 1, 2 * maxSquaresAway + 1);
		// rectangle r2 encompasses all of the points that are within the min possible distance from the player
		Point p2 = new Point(currentWp.getX() - minSquaresAway, currentWp.getY() - minSquaresAway);
		Rectangle r2 = new Rectangle((int) p2.getX(), (int) p2.getY(), 2 * minSquaresAway + 1, 2 * minSquaresAway + 1);

		// eliminate from consideration dig spots that lie entirely within the min range or entirely outside of the max range
		digLocations.removeIf(entry -> r2.contains(entry.getRect()) || !r1.intersects(entry.getRect()));

		// if a previous world point has been recorded, we can consider the warmer/colder result from the strange device
		if (lastWorldPoint != null)
		{
			switch (difference)
			{
				case "but colder than":
					// eliminate spots that are absolutely warmer
					digLocations.removeIf(entry -> isFirstPointCloserRect(currentWp, lastWorldPoint, entry.getRect()));
					break;
				case "and warmer than":
					// eliminate spots that are absolutely colder
					digLocations.removeIf(entry -> isFirstPointCloserRect(lastWorldPoint, currentWp, entry.getRect()));
					break;
				case "and the same temperature as":
					// I couldn't figure out a clean implementation for this case
					// not necessary for quickly determining final location
			}
		}

		lastWorldPoint = currentWp;
	}

	private boolean isFirstPointCloserRect(WorldPoint firstWp, WorldPoint secondWp, Rectangle2D r)
	{
		WorldPoint p1 = new WorldPoint((int) r.getMaxX(), (int) r.getMaxY(), 0);

		if (!isFirstPointCloser(firstWp, secondWp, p1))
		{
			return false;
		}

		WorldPoint p2 = new WorldPoint((int) r.getMaxX(), (int) r.getMinY(), 0);

		if (!isFirstPointCloser(firstWp, secondWp, p2))
		{
			return false;
		}

		WorldPoint p3 = new WorldPoint((int) r.getMinX(), (int)r.getMaxY(), 0);

		if (!isFirstPointCloser(firstWp, secondWp, p3))
		{
			return false;
		}

		WorldPoint p4 = new WorldPoint((int) r.getMinX(), (int) r.getMinY(), 0);
		return (isFirstPointCloser(firstWp, secondWp, p4));
	}

	private boolean isFirstPointCloser(WorldPoint firstWp, WorldPoint secondWp, WorldPoint wp)
	{
		int firstDistance = firstWp.distanceTo2D(wp);
		int secondDistance = secondWp.distanceTo2D(wp);
		return (firstDistance < secondDistance);
>>>>>>> initial import of runelite
	}

	private void markFinalSpot(WorldPoint wp)
	{
		this.location = wp;
<<<<<<< HEAD
=======
		reset();
>>>>>>> initial import of runelite
	}

	public String[] getNpcs()
	{
		return new String[] {npc};
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> initial import of runelite
