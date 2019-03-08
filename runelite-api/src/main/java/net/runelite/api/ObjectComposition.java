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

/**
<<<<<<< HEAD
 * Information about a specific {@link ObjectID}
=======
 * Represents the template of a specific object.
>>>>>>> initial import of runelite
 */
public interface ObjectComposition
{
	/**
	 * Gets ID for the object.
	 *
<<<<<<< HEAD
	 * @see ObjectID
=======
	 * @return the object ID
>>>>>>> initial import of runelite
	 */
	int getId();

	/**
	 * Gets the name of the object.
<<<<<<< HEAD
=======
	 *
	 * @return the object name
>>>>>>> initial import of runelite
	 */
	String getName();

	/**
<<<<<<< HEAD
	 * The 5 menuops this object has when in world. Index 0 corresponds to
	 * {@link MenuAction#GAME_OBJECT_FIRST_OPTION}, Index 2 to
	 * {@link MenuAction#GAME_OBJECT_SECOND_OPTION} and so on.
=======
	 * Gets an array of possible right-click menu actions that can be
	 * performed on the object.
	 *
	 * @return the menu actions
>>>>>>> initial import of runelite
	 */
	String[] getActions();

	/**
<<<<<<< HEAD
	 * Gets the index of this object in the {@link Client#getMapScene()}
	 * array, or -1 if it has no map scene icon
=======
	 * Gets the map scene ID for the object.
	 *
	 * @return the scene ID
>>>>>>> initial import of runelite
	 */
	int getMapSceneId();

	/**
<<<<<<< HEAD
	 * Gets the index of this object in the {@link Client#getMapIcons()}
	 * array, or -1 if it has no full map icon
=======
	 * Gets the map icon ID for the object.
	 *
	 * @return the map icon ID
>>>>>>> initial import of runelite
	 */
	int getMapIconId();

	/**
<<<<<<< HEAD
	 * Get the {@link ObjectID}s of objects this can transform into, depending
	 * on a {@link Varbits} or {@link VarPlayer}
=======
	 * Gets IDs for objects that are considered fakes of this object,
	 * such as barrows walls.
	 *
	 * @return the impostor IDs
>>>>>>> initial import of runelite
	 */
	int[] getImpostorIds();

	/**
<<<<<<< HEAD
	 * Get the object composition the player's state says this object should
	 * transmogrify into.
	 *
	 * @throws NullPointerException if {@link #getImpostorIds()} is null
=======
	 * Gets the impostor composition for this object.
	 *
	 * @return the impostor
>>>>>>> initial import of runelite
	 */
	ObjectComposition getImpostor();
}
