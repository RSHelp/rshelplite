/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.api;

import java.awt.Graphics2D;
import java.awt.Polygon;
<<<<<<< HEAD
import java.awt.Shape;
=======
import java.awt.geom.Area;
>>>>>>> initial import of runelite
import javax.annotation.Nullable;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;

/**
<<<<<<< HEAD
 * Represents an object on a Tile
 */
public interface TileObject
{
=======
 * Represents an object that a tile holds.
 */
public interface TileObject
{
	/**
	 * Gets the hashed value of this object.
	 *
	 * @return the object hash
	 */
>>>>>>> initial import of runelite
	long getHash();

	/**
	 * Gets the x-axis coordinate of the object in local context.
	 *
<<<<<<< HEAD
	 * @see LocalPoint
=======
	 * @return the x-axis coordinate
>>>>>>> initial import of runelite
	 */
	int getX();

	/**
	 * Gets the y-axis coordinate of the object in local context.
	 *
<<<<<<< HEAD
	 * @see LocalPoint
=======
	 * @return the y-axis coordinate
>>>>>>> initial import of runelite
	 */
	int getY();

	/**
	 * Gets the plane of the tile that the object is on.
<<<<<<< HEAD
=======
	 *
	 * @return the tile plane
>>>>>>> initial import of runelite
	 */
	int getPlane();

	/**
	 * Gets the ID of the object.
	 *
<<<<<<< HEAD
	 * @see ObjectID
	 * @see NullObjectID
	 */
	int getId();

	WorldPoint getWorldLocation();

	LocalPoint getLocalLocation();

	/**
	 * Calculates the position of the center of this tile on the canvas
=======
	 * @return the object ID
	 */
	int getId();

	/**
	 * Gets the location coordinate of the object in the world.
	 *
	 * @return the world location
	 */
	WorldPoint getWorldLocation();

	/**
	 * Gets the local location of the object.
	 *
	 * @return the local location
	 */
	LocalPoint getLocalLocation();

	/**
	 * Gets the upper-left canvas point where this object is drawn.
	 *
	 * @return the canvas location
>>>>>>> initial import of runelite
	 */
	Point getCanvasLocation();

	/**
<<<<<<< HEAD
	 * Calculates the position of the center of this tile on the canvas
	 *
	 * @param zOffset Vertical offset to apply before projection
=======
	 * Gets the upper-left canvas point where this object is drawn,
	 * offset by the passed value.
	 *
	 * @param zOffset the z-axis offset
	 * @return the canvas location
>>>>>>> initial import of runelite
	 */
	Point getCanvasLocation(int zOffset);

	/**
<<<<<<< HEAD
	 * Creates a polygon outlining the tile this object is on
=======
	 * Gets the polygon of the objects model as drawn on the canvas.
	 *
	 * @return the canvas polygon
>>>>>>> initial import of runelite
	 */
	Polygon getCanvasTilePoly();

	/**
<<<<<<< HEAD
	 * Calculates the canvas point to center {@code text} above the tile this object is on.
	 *
	 * @param graphics the graphics to use for font size calculation
	 * @param zOffset Vertical offset to apply before projection
=======
	 * Gets the text position on the canvas.
	 *
	 * @param graphics the client graphics
	 * @param text the text to draw
	 * @param zOffset the offset from ground plane
>>>>>>> initial import of runelite
	 * @return the canvas point to draw the text at
	 */
	Point getCanvasTextLocation(Graphics2D graphics, String text, int zOffset);

	/**
	 * Gets a point on the canvas of where this objects mini-map indicator
	 * should appear.
	 *
	 * @return mini-map location on canvas
	 */
	Point getMinimapLocation();

	/**
<<<<<<< HEAD
	 * Calculate the on-screen clickable area of the object.
	 */
	@Nullable
	Shape getClickbox();
=======
	 * Get the on-screen clickable area of the object.
	 *
	 * @return the clickable area
	 */
	@Nullable
	Area getClickbox();
>>>>>>> initial import of runelite
}
