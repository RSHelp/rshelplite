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
package net.runelite.client.plugins.itemcharges;

<<<<<<< HEAD
import com.google.common.collect.ImmutableMap;
=======
import java.util.HashMap;
>>>>>>> initial import of runelite
import java.util.Map;
import javax.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import static net.runelite.api.ItemID.*;
import static net.runelite.client.plugins.itemcharges.ItemChargeType.*;

@AllArgsConstructor
@Getter
enum ItemWithCharge
{
	ABRACE1(ABYSSAL_BRACELET, ABYSSAL_BRACELET1, 1),
	ABRACE2(ABYSSAL_BRACELET, ABYSSAL_BRACELET2, 2),
	ABRACE3(ABYSSAL_BRACELET, ABYSSAL_BRACELET3, 3),
	ABRACE4(ABYSSAL_BRACELET, ABYSSAL_BRACELET4, 4),
	ABRACE5(ABYSSAL_BRACELET, ABYSSAL_BRACELET5, 5),
<<<<<<< HEAD
	BASKET_APPLES1(FRUIT_BASKET, APPLES1, 1),
	BASKET_APPLES2(FRUIT_BASKET, APPLES2, 2),
	BASKET_APPLES3(FRUIT_BASKET, APPLES3, 3),
	BASKET_APPLES4(FRUIT_BASKET, APPLES4, 4),
	BASKET_APPLES5(FRUIT_BASKET, APPLES5, 5),
	BASKET_BANANAS1(FRUIT_BASKET, BANANAS1, 1),
	BASKET_BANANAS2(FRUIT_BASKET, BANANAS2, 2),
	BASKET_BANANAS3(FRUIT_BASKET, BANANAS3, 3),
	BASKET_BANANAS4(FRUIT_BASKET, BANANAS4, 4),
	BASKET_BANANAS5(FRUIT_BASKET, BANANAS5, 5),
	BASKET_ORANGES1(FRUIT_BASKET, ORANGES1, 1),
	BASKET_ORANGES2(FRUIT_BASKET, ORANGES2, 2),
	BASKET_ORANGES3(FRUIT_BASKET, ORANGES3, 3),
	BASKET_ORANGES4(FRUIT_BASKET, ORANGES4, 4),
	BASKET_ORANGES5(FRUIT_BASKET, ORANGES5, 5),
	BASKET_STRAWBERRIES1(FRUIT_BASKET, STRAWBERRIES1, 1),
	BASKET_STRAWBERRIES2(FRUIT_BASKET, STRAWBERRIES2, 2),
	BASKET_STRAWBERRIES3(FRUIT_BASKET, STRAWBERRIES3, 3),
	BASKET_STRAWBERRIES4(FRUIT_BASKET, STRAWBERRIES4, 4),
	BASKET_STRAWBERRIES5(FRUIT_BASKET, STRAWBERRIES5, 5),
	BASKET_TOMATOES1(FRUIT_BASKET, TOMATOES1, 1),
	BASKET_TOMATOES2(FRUIT_BASKET, TOMATOES2, 2),
	BASKET_TOMATOES3(FRUIT_BASKET, TOMATOES3, 3),
	BASKET_TOMATOES4(FRUIT_BASKET, TOMATOES4, 4),
	BASKET_TOMATOES5(FRUIT_BASKET, TOMATOES5, 5),
=======
>>>>>>> initial import of runelite
	BELLOWS0(BELLOWS, OGRE_BELLOWS, 0),
	BELLOWS1(BELLOWS, OGRE_BELLOWS_1, 1),
	BELLOWS2(BELLOWS, OGRE_BELLOWS_2, 2),
	BELLOWS3(BELLOWS, OGRE_BELLOWS_3, 3),
	BURNING1(TELEPORT, BURNING_AMULET1, 1),
	BURNING2(TELEPORT, BURNING_AMULET2, 2),
	BURNING3(TELEPORT, BURNING_AMULET3, 3),
	BURNING4(TELEPORT, BURNING_AMULET4, 4),
	BURNING5(TELEPORT, BURNING_AMULET5, 5),
	CBRACE1(TELEPORT, COMBAT_BRACELET1, 1),
	CBRACE2(TELEPORT, COMBAT_BRACELET2, 2),
	CBRACE3(TELEPORT, COMBAT_BRACELET3, 3),
	CBRACE4(TELEPORT, COMBAT_BRACELET4, 4),
	CBRACE5(TELEPORT, COMBAT_BRACELET5, 5),
	CBRACE6(TELEPORT, COMBAT_BRACELET6, 6),
	DIGSITE1(TELEPORT, DIGSITE_PENDANT_1, 1),
	DIGSITE2(TELEPORT, DIGSITE_PENDANT_2, 2),
	DIGSITE3(TELEPORT, DIGSITE_PENDANT_3, 3),
	DIGSITE4(TELEPORT, DIGSITE_PENDANT_4, 4),
	DIGSITE5(TELEPORT, DIGSITE_PENDANT_5, 5),
	ELYRE1(TELEPORT, ENCHANTED_LYRE1, 1),
	ELYRE2(TELEPORT, ENCHANTED_LYRE2, 2),
	ELYRE3(TELEPORT, ENCHANTED_LYRE3, 3),
	ELYRE4(TELEPORT, ENCHANTED_LYRE4, 4),
	ELYRE5(TELEPORT, ENCHANTED_LYRE5, 5),
	FUNGICIDE0(FUNGICIDE_SPRAY, FUNGICIDE_SPRAY_0, 0),
	FUNGICIDE1(FUNGICIDE_SPRAY, FUNGICIDE_SPRAY_1, 1),
	FUNGICIDE2(FUNGICIDE_SPRAY, FUNGICIDE_SPRAY_2, 2),
	FUNGICIDE3(FUNGICIDE_SPRAY, FUNGICIDE_SPRAY_3, 3),
	FUNGICIDE4(FUNGICIDE_SPRAY, FUNGICIDE_SPRAY_4, 4),
	FUNGICIDE5(FUNGICIDE_SPRAY, FUNGICIDE_SPRAY_5, 5),
	FUNGICIDE6(FUNGICIDE_SPRAY, FUNGICIDE_SPRAY_6, 6),
	FUNGICIDE7(FUNGICIDE_SPRAY, FUNGICIDE_SPRAY_7, 7),
	FUNGICIDE8(FUNGICIDE_SPRAY, FUNGICIDE_SPRAY_8, 8),
	FUNGICIDE9(FUNGICIDE_SPRAY, FUNGICIDE_SPRAY_9, 9),
	FUNGICIDE10(FUNGICIDE_SPRAY, FUNGICIDE_SPRAY_10, 10),
	GAMES1(TELEPORT, GAMES_NECKLACE1, 1),
	GAMES2(TELEPORT, GAMES_NECKLACE2, 2),
	GAMES3(TELEPORT, GAMES_NECKLACE3, 3),
	GAMES4(TELEPORT, GAMES_NECKLACE4, 4),
	GAMES5(TELEPORT, GAMES_NECKLACE5, 5),
	GAMES6(TELEPORT, GAMES_NECKLACE6, 6),
	GAMES7(TELEPORT, GAMES_NECKLACE7, 7),
	GAMES8(TELEPORT, GAMES_NECKLACE8, 8),
	GLORY1(TELEPORT, AMULET_OF_GLORY1, 1),
	GLORY2(TELEPORT, AMULET_OF_GLORY2, 2),
	GLORY3(TELEPORT, AMULET_OF_GLORY3, 3),
	GLORY4(TELEPORT, AMULET_OF_GLORY4, 4),
	GLORY5(TELEPORT, AMULET_OF_GLORY5, 5),
	GLORY6(TELEPORT, AMULET_OF_GLORY6, 6),
	GLORYT1(TELEPORT, AMULET_OF_GLORY_T1, 1),
	GLORYT2(TELEPORT, AMULET_OF_GLORY_T2, 2),
	GLORYT3(TELEPORT, AMULET_OF_GLORY_T3, 3),
	GLORYT4(TELEPORT, AMULET_OF_GLORY_T4, 4),
	GLORYT5(TELEPORT, AMULET_OF_GLORY_T5, 5),
	GLORYT6(TELEPORT, AMULET_OF_GLORY_T6, 6),
	IMP_IN_A_BOX1(IMPBOX, IMPINABOX1, 1),
	IMP_IN_A_BOX2(IMPBOX, IMPINABOX2, 2),
	PASSAGE1(TELEPORT, NECKLACE_OF_PASSAGE1, 1),
	PASSAGE2(TELEPORT, NECKLACE_OF_PASSAGE2, 2),
	PASSAGE3(TELEPORT, NECKLACE_OF_PASSAGE3, 3),
	PASSAGE4(TELEPORT, NECKLACE_OF_PASSAGE4, 4),
	PASSAGE5(TELEPORT, NECKLACE_OF_PASSAGE5, 5),
	PHARAO1(TELEPORT, PHARAOHS_SCEPTRE_1, 1),
	PHARAO2(TELEPORT, PHARAOHS_SCEPTRE_2, 2),
	PHARAO3(TELEPORT, PHARAOHS_SCEPTRE_3, 3),
	PHARAO4(TELEPORT, PHARAOHS_SCEPTRE_4, 4),
	PHARAO5(TELEPORT, PHARAOHS_SCEPTRE_5, 5),
	PHARAO6(TELEPORT, PHARAOHS_SCEPTRE_6, 6),
	PHARAO7(TELEPORT, PHARAOHS_SCEPTRE_7, 7),
	PHARAO8(TELEPORT, PHARAOHS_SCEPTRE_8, 8),
	RETURNING1(TELEPORT, RING_OF_RETURNING1, 1),
	RETURNING2(TELEPORT, RING_OF_RETURNING2, 2),
	RETURNING3(TELEPORT, RING_OF_RETURNING3, 3),
	RETURNING4(TELEPORT, RING_OF_RETURNING4, 4),
	RETURNING5(TELEPORT, RING_OF_RETURNING5, 5),
	ROD1(TELEPORT, RING_OF_DUELING1, 1),
	ROD2(TELEPORT, RING_OF_DUELING2, 2),
	ROD3(TELEPORT, RING_OF_DUELING3, 3),
	ROD4(TELEPORT, RING_OF_DUELING4, 4),
	ROD5(TELEPORT, RING_OF_DUELING5, 5),
	ROD6(TELEPORT, RING_OF_DUELING6, 6),
	ROD7(TELEPORT, RING_OF_DUELING7, 7),
	ROD8(TELEPORT, RING_OF_DUELING8, 8),
	ROS1(TELEPORT, SLAYER_RING_1, 1),
	ROS2(TELEPORT, SLAYER_RING_2, 2),
	ROS3(TELEPORT, SLAYER_RING_3, 3),
	ROS4(TELEPORT, SLAYER_RING_4, 4),
	ROS5(TELEPORT, SLAYER_RING_5, 5),
	ROS6(TELEPORT, SLAYER_RING_6, 6),
	ROS7(TELEPORT, SLAYER_RING_7, 7),
	ROS8(TELEPORT, SLAYER_RING_8, 8),
	ROW1(TELEPORT, RING_OF_WEALTH_1, 1),
	ROW2(TELEPORT, RING_OF_WEALTH_2, 2),
	ROW3(TELEPORT, RING_OF_WEALTH_3, 3),
	ROW4(TELEPORT, RING_OF_WEALTH_4, 4),
	ROW5(TELEPORT, RING_OF_WEALTH_5, 5),
<<<<<<< HEAD
	SACK_CABBAGES1(SACK, CABBAGES1, 1),
	SACK_CABBAGES2(SACK, CABBAGES2, 2),
	SACK_CABBAGES3(SACK, CABBAGES3, 3),
	SACK_CABBAGES4(SACK, CABBAGES4, 4),
	SACK_CABBAGES5(SACK, CABBAGES5, 5),
	SACK_CABBAGES6(SACK, CABBAGES6, 6),
	SACK_CABBAGES7(SACK, CABBAGES7, 7),
	SACK_CABBAGES8(SACK, CABBAGES8, 8),
	SACK_CABBAGES9(SACK, CABBAGES9, 9),
	SACK_CABBAGES10(SACK, CABBAGES10, 10),
	SACK_ONIONS1(SACK, ONIONS1, 1),
	SACK_ONIONS2(SACK, ONIONS2, 2),
	SACK_ONIONS3(SACK, ONIONS3, 3),
	SACK_ONIONS4(SACK, ONIONS4, 4),
	SACK_ONIONS5(SACK, ONIONS5, 5),
	SACK_ONIONS6(SACK, ONIONS6, 6),
	SACK_ONIONS7(SACK, ONIONS7, 7),
	SACK_ONIONS8(SACK, ONIONS8, 8),
	SACK_ONIONS9(SACK, ONIONS9, 9),
	SACK_ONIONS10(SACK, ONIONS10, 10),
	SACK_POTATOES1(SACK, POTATOES1, 1),
	SACK_POTATOES2(SACK, POTATOES2, 2),
	SACK_POTATOES3(SACK, POTATOES3, 3),
	SACK_POTATOES4(SACK, POTATOES4, 4),
	SACK_POTATOES5(SACK, POTATOES5, 5),
	SACK_POTATOES6(SACK, POTATOES6, 6),
	SACK_POTATOES7(SACK, POTATOES7, 7),
	SACK_POTATOES8(SACK, POTATOES8, 8),
	SACK_POTATOES9(SACK, POTATOES9, 9),
	SACK_POTATOES10(SACK, POTATOES10, 10),
=======
>>>>>>> initial import of runelite
	SKILLS1(TELEPORT, SKILLS_NECKLACE1, 1),
	SKILLS2(TELEPORT, SKILLS_NECKLACE2, 2),
	SKILLS3(TELEPORT, SKILLS_NECKLACE3, 3),
	SKILLS4(TELEPORT, SKILLS_NECKLACE4, 4),
	SKILLS5(TELEPORT, SKILLS_NECKLACE5, 5),
	SKILLS6(TELEPORT, SKILLS_NECKLACE6, 6),
	TCRYSTAL1(TELEPORT, TELEPORT_CRYSTAL_1, 1),
	TCRYSTAL2(TELEPORT, TELEPORT_CRYSTAL_2, 2),
	TCRYSTAL3(TELEPORT, TELEPORT_CRYSTAL_3, 3),
	TCRYSTAL4(TELEPORT, TELEPORT_CRYSTAL_4, 4),
	TCRYSTAL5(TELEPORT, TELEPORT_CRYSTAL_5, 5),
	WCAN0(WATERCAN, WATERING_CAN, 0),
	WCAN1(WATERCAN, WATERING_CAN1, 1),
	WCAN2(WATERCAN, WATERING_CAN2, 2),
	WCAN3(WATERCAN, WATERING_CAN3, 3),
	WCAN4(WATERCAN, WATERING_CAN4, 4),
	WCAN5(WATERCAN, WATERING_CAN5, 5),
	WCAN6(WATERCAN, WATERING_CAN6, 6),
	WCAN7(WATERCAN, WATERING_CAN7, 7),
	WCAN8(WATERCAN, WATERING_CAN8, 8),
	WSKIN0(WATERSKIN, WATERSKIN0, 0),
	WSKIN1(WATERSKIN, WATERSKIN1, 1),
	WSKIN2(WATERSKIN, WATERSKIN2, 2),
	WSKIN3(WATERSKIN, WATERSKIN3, 3),
<<<<<<< HEAD
	WSKIN4(WATERSKIN, WATERSKIN4, 4),
	GREST1(GUTHIX_REST, GUTHIX_REST1, 1),
	GREST2(GUTHIX_REST, GUTHIX_REST2, 2),
	GREST3(GUTHIX_REST, GUTHIX_REST3, 3),
	GREST4(GUTHIX_REST, GUTHIX_REST4, 4);
=======
	WSKIN4(WATERSKIN, WATERSKIN4, 4);
>>>>>>> initial import of runelite

	private final ItemChargeType type;
	private final int id;
	private final int charges;

<<<<<<< HEAD
	private static final Map<Integer, ItemWithCharge> ID_MAP;

	static
	{
		ImmutableMap.Builder<Integer, ItemWithCharge> builder = new ImmutableMap.Builder<>();

		for (ItemWithCharge itemCharge : values())
		{
			builder.put(itemCharge.getId(), itemCharge);
		}

		ID_MAP = builder.build();
=======
	private static final Map<Integer, ItemWithCharge> ID_MAP = new HashMap<>();

	static
	{
		for (ItemWithCharge itemCharge : values())
		{
			ID_MAP.put(itemCharge.getId(), itemCharge);
		}
>>>>>>> initial import of runelite
	}

	@Nullable
	static ItemWithCharge findItem(int itemId)
	{
		return ID_MAP.get(itemId);
	}

}
