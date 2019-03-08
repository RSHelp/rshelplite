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
package net.runelite.api;

/**
<<<<<<< HEAD
 * Information about a specific {@link NpcID}
=======
 * Represents the template of a specific NPC type.
>>>>>>> initial import of runelite
 */
public interface NPCComposition
{
	/**
	 * Gets the name of the NPC.
<<<<<<< HEAD
=======
	 *
	 * @return the name
>>>>>>> initial import of runelite
	 */
	String getName();

	/**
	 * Gets the model IDs that compose this NPC.
<<<<<<< HEAD
=======
	 *
	 * @return the NPCs model IDs
>>>>>>> initial import of runelite
	 */
	int[] getModels();

	/**
<<<<<<< HEAD
	 * The 5 menuops this NPC has when in world. Index 0 corresponds to
	 * {@link MenuAction#NPC_FIRST_OPTION}, Index 2 to
	 * {@link MenuAction#NPC_SECOND_OPTION} and so on.
	 */
	String[] getActions();

=======
	 * Gets an array of possible right-click menu actions that can be
	 * performed on the NPC.
	 *
	 * @return the menu actions
	 */
	String[] getActions();

	/**
	 * Gets whether the NPC can be clicked.
	 *
	 * @return true if the NPC can be clicked, false otherwise
	 */
>>>>>>> initial import of runelite
	boolean isClickable();

	/**
	 * Gets whether the NPC is visible on the mini-map.
<<<<<<< HEAD
	 */
	boolean isMinimapVisible();

=======
	 *
	 * @return the mini-map visible state
	 */
	boolean isMinimapVisible();

	/**
	 * Gets whether the NPC is visible.
	 *
	 * @return the visible state
	 */
>>>>>>> initial import of runelite
	boolean isVisible();

	/**
	 * Gets the ID of the NPC.
	 *
<<<<<<< HEAD
=======
	 * @return the ID of the NPC
>>>>>>> initial import of runelite
	 * @see NpcID
	 */
	int getId();

	/**
<<<<<<< HEAD
=======
	 * Gets the combat level of the NPC.
	 *
>>>>>>> initial import of runelite
	 * @return the combat level, -1 if none
	 */
	int getCombatLevel();

	/**
<<<<<<< HEAD
	 * Get the {@link NpcID}s of NPCs this can transform into, depending
	 * on a {@link Varbits} or {@link VarPlayer}
=======
	 * Gets the configuration data for the NPC.
	 *
	 * @return the configuration data
>>>>>>> initial import of runelite
	 */
	int[] getConfigs();

	/**
<<<<<<< HEAD
	 * Get the NPC composition the player's state says this NPC should
	 * transmogrify into.
	 *
	 * @throws NullPointerException if {@link #getConfigs()} is null
=======
	 * Transforms this NPC into a new state, which may have a different ID.
	 *
	 * @return the transformed composition
>>>>>>> initial import of runelite
	 */
	NPCComposition transform();

	/**
<<<<<<< HEAD
	 * How many tiles wide this NPC is
=======
	 * Gets the size of the NPC.
	 *
	 * @return the NPCs size
>>>>>>> initial import of runelite
	 */
	int getSize();

	/**
	 * Gets the displayed overhead icon of the NPC.
<<<<<<< HEAD
=======
	 *
	 * @return the overhead icon
>>>>>>> initial import of runelite
	 */
	HeadIcon getOverheadIcon();
}
