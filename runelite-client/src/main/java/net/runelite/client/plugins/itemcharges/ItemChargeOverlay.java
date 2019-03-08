/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
<<<<<<< HEAD
 * Copyright (c) 2019, Aleios <https://github.com/aleios>
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
package net.runelite.client.plugins.itemcharges;

<<<<<<< HEAD
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import javax.inject.Inject;
import net.runelite.api.ItemID;
import net.runelite.api.widgets.WidgetItem;
import static net.runelite.client.plugins.itemcharges.ItemChargeType.ABYSSAL_BRACELET;
import static net.runelite.client.plugins.itemcharges.ItemChargeType.BELLOWS;
import static net.runelite.client.plugins.itemcharges.ItemChargeType.FUNGICIDE_SPRAY;
import static net.runelite.client.plugins.itemcharges.ItemChargeType.IMPBOX;
import static net.runelite.client.plugins.itemcharges.ItemChargeType.TELEPORT;
import static net.runelite.client.plugins.itemcharges.ItemChargeType.WATERCAN;
import static net.runelite.client.plugins.itemcharges.ItemChargeType.WATERSKIN;
import static net.runelite.client.plugins.itemcharges.ItemChargeType.FRUIT_BASKET;
import static net.runelite.client.plugins.itemcharges.ItemChargeType.SACK;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.WidgetItemOverlay;
import net.runelite.client.ui.overlay.components.TextComponent;

class ItemChargeOverlay extends WidgetItemOverlay
{
=======
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import javax.inject.Inject;
import net.runelite.api.ItemID;
import net.runelite.api.Query;
import net.runelite.api.queries.EquipmentItemQuery;
import net.runelite.api.queries.InventoryWidgetItemQuery;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import static net.runelite.client.plugins.itemcharges.ItemChargeType.*;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.TextComponent;
import net.runelite.client.util.QueryRunner;

class ItemChargeOverlay extends Overlay
{
	private final QueryRunner queryRunner;
>>>>>>> initial import of runelite
	private final ItemChargePlugin itemChargePlugin;
	private final ItemChargeConfig config;

	@Inject
<<<<<<< HEAD
	ItemChargeOverlay(ItemChargePlugin itemChargePlugin, ItemChargeConfig config)
	{
		this.itemChargePlugin = itemChargePlugin;
		this.config = config;
		showOnInventory();
		showOnEquipment();
	}

	@Override
	public void renderItemOverlay(Graphics2D graphics, int itemId, WidgetItem itemWidget)
	{
		if (!displayOverlay())
		{
			return;
=======
	ItemChargeOverlay(QueryRunner queryRunner, ItemChargePlugin itemChargePlugin, ItemChargeConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.queryRunner = queryRunner;
		this.itemChargePlugin = itemChargePlugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!displayOverlay())
		{
			return null;
>>>>>>> initial import of runelite
		}

		graphics.setFont(FontManager.getRunescapeSmallFont());

<<<<<<< HEAD
		int charges;
		if (itemId == ItemID.DODGY_NECKLACE)
		{
			if (!config.showDodgyCount())
			{
				return;
			}

			charges = config.dodgyNecklace();
		}
		else if (itemId == ItemID.BINDING_NECKLACE)
		{
			if (!config.showBindingNecklaceCharges())
			{
				return;
			}

			charges = config.bindingNecklace();
		}
		else if (itemId >= ItemID.EXPLORERS_RING_1 && itemId <= ItemID.EXPLORERS_RING_4)
		{
			if (!config.showExplorerRingCharges())
			{
				return;
			}

			charges = config.explorerRing();
		}
		else if (itemId == ItemID.RING_OF_FORGING)
		{
			if (!config.showRingOfForgingCount())
			{
				return;
			}

			charges = config.ringOfForging();
		}
		else
		{
			ItemWithCharge chargeItem = ItemWithCharge.findItem(itemId);
			if (chargeItem == null)
			{
				return;
			}

			ItemChargeType type = chargeItem.getType();
			if ((type == TELEPORT && !config.showTeleportCharges())
				|| (type == FUNGICIDE_SPRAY && !config.showFungicideCharges())
				|| (type == IMPBOX && !config.showImpCharges())
				|| (type == WATERCAN && !config.showWateringCanCharges())
				|| (type == WATERSKIN && !config.showWaterskinCharges())
				|| (type == BELLOWS && !config.showBellowCharges())
				|| (type == FRUIT_BASKET && !config.showBasketCharges())
				|| (type == SACK && !config.showSackCharges())
				|| (type == ABYSSAL_BRACELET && !config.showAbyssalBraceletCharges()))
			{
				return;
			}

			charges = chargeItem.getCharges();
		}

		final Rectangle bounds = itemWidget.getCanvasBounds();
		final TextComponent textComponent = new TextComponent();
		textComponent.setPosition(new Point(bounds.x - 1, bounds.y + 15));
		textComponent.setText(charges < 0 ? "?" : String.valueOf(charges));
		textComponent.setColor(itemChargePlugin.getColor(charges));
		textComponent.render(graphics);
=======
		for (WidgetItem item : getChargeWidgetItems())
		{
			int charges;
			if (item.getId() == ItemID.DODGY_NECKLACE)
			{
				if (!config.showDodgyCount())
				{
					continue;
				}

				charges = config.dodgyNecklace();
			}
			else
			{
				ItemWithCharge chargeItem = ItemWithCharge.findItem(item.getId());
				if (chargeItem == null)
				{
					continue;
				}

				ItemChargeType type = chargeItem.getType();
				if ((type == TELEPORT && !config.showTeleportCharges())
					|| (type == FUNGICIDE_SPRAY && !config.showFungicideCharges())
					|| (type == IMPBOX && !config.showImpCharges())
					|| (type == WATERCAN && !config.showWateringCanCharges())
					|| (type == WATERSKIN && !config.showWaterskinCharges())
					|| (type == BELLOWS && !config.showBellowCharges())
					|| (type == ABYSSAL_BRACELET && !config.showAbyssalBraceletCharges()))
				{
					continue;
				}

				charges = chargeItem.getCharges();
			}

			final Rectangle bounds = item.getCanvasBounds();
			final TextComponent textComponent = new TextComponent();
			textComponent.setPosition(new Point(bounds.x, bounds.y + 16));
			textComponent.setText(charges < 0 ? "?" : String.valueOf(charges));
			textComponent.setColor(itemChargePlugin.getColor(charges));
			textComponent.render(graphics);
		}
		return null;
	}

	private Collection<WidgetItem> getChargeWidgetItems()
	{
		Query inventoryQuery = new InventoryWidgetItemQuery();
		WidgetItem[] inventoryWidgetItems = queryRunner.runQuery(inventoryQuery);

		Query equipmentQuery = new EquipmentItemQuery().slotEquals(
			WidgetInfo.EQUIPMENT_AMULET,
			WidgetInfo.EQUIPMENT_RING,
			WidgetInfo.EQUIPMENT_GLOVES,
			WidgetInfo.EQUIPMENT_WEAPON
		);
		WidgetItem[] equipmentWidgetItems = queryRunner.runQuery(equipmentQuery);

		Collection<WidgetItem> jewellery = new ArrayList<>();
		jewellery.addAll(Arrays.asList(inventoryWidgetItems));
		jewellery.addAll(Arrays.asList(equipmentWidgetItems));
		return jewellery;
>>>>>>> initial import of runelite
	}

	private boolean displayOverlay()
	{
		return config.showTeleportCharges() || config.showDodgyCount() || config.showFungicideCharges()
			|| config.showImpCharges() || config.showWateringCanCharges() || config.showWaterskinCharges()
<<<<<<< HEAD
			|| config.showBellowCharges() || config.showBasketCharges() || config.showSackCharges()
			|| config.showAbyssalBraceletCharges() || config.showExplorerRingCharges() || config.showRingOfForgingCount();
=======
			|| config.showBellowCharges() || config.showAbyssalBraceletCharges();
>>>>>>> initial import of runelite
	}
}
