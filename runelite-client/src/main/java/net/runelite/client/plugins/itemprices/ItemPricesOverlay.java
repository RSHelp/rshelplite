/*
 * Copyright (c) 2018, Charlie Waters
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
package net.runelite.client.plugins.itemprices;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
<<<<<<< HEAD
import net.runelite.api.Constants;
=======
>>>>>>> initial import of runelite
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;
import net.runelite.client.util.ColorUtil;
<<<<<<< HEAD
import net.runelite.client.util.QuantityFormatter;

class ItemPricesOverlay extends Overlay
{
	private static final int INVENTORY_ITEM_WIDGETID = WidgetInfo.INVENTORY.getPackedId();
	private static final int BANK_INVENTORY_ITEM_WIDGETID = WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER.getPackedId();
	private static final int BANK_ITEM_WIDGETID = WidgetInfo.BANK_ITEM_CONTAINER.getPackedId();
	private static final int EXPLORERS_RING_ITEM_WIDGETID = WidgetInfo.EXPLORERS_RING_ALCH_INVENTORY.getPackedId();
=======
import net.runelite.client.util.StackFormatter;

class ItemPricesOverlay extends Overlay
{
	// Used when getting High Alchemy value - multiplied by general store price.
	private static final float HIGH_ALCHEMY_CONSTANT = 0.6f;

	private static final int INVENTORY_ITEM_WIDGETID = WidgetInfo.INVENTORY.getPackedId();
	private static final int BANK_INVENTORY_ITEM_WIDGETID = WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER.getPackedId();
	private static final int BANK_ITEM_WIDGETID = WidgetInfo.BANK_ITEM_CONTAINER.getPackedId();
>>>>>>> initial import of runelite

	private final Client client;
	private final ItemPricesConfig config;
	private final TooltipManager tooltipManager;
	private final StringBuilder itemStringBuilder = new StringBuilder();

	@Inject
	ItemManager itemManager;

	@Inject
	ItemPricesOverlay(Client client, ItemPricesConfig config, TooltipManager tooltipManager)
	{
		setPosition(OverlayPosition.DYNAMIC);
		this.client = client;
		this.config = config;
		this.tooltipManager = tooltipManager;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (client.isMenuOpen())
		{
			return null;
		}

		final MenuEntry[] menuEntries = client.getMenuEntries();
		final int last = menuEntries.length - 1;

		if (last < 0)
		{
			return null;
		}

		final MenuEntry menuEntry = menuEntries[last];
		final MenuAction action = MenuAction.of(menuEntry.getType());
		final int widgetId = menuEntry.getParam1();
		final int groupId = WidgetInfo.TO_GROUP(widgetId);

		// Tooltip action type handling
		switch (action)
		{
<<<<<<< HEAD
			case ITEM_USE_ON_WIDGET:
				if (!config.showWhileAlching() || !menuEntry.getOption().equals("Cast") || !menuEntry.getTarget().contains("High Level Alchemy"))
				{
					break;
				}
=======
>>>>>>> initial import of runelite
			case WIDGET_DEFAULT:
			case ITEM_USE:
			case ITEM_FIRST_OPTION:
			case ITEM_SECOND_OPTION:
			case ITEM_THIRD_OPTION:
			case ITEM_FOURTH_OPTION:
			case ITEM_FIFTH_OPTION:
				// Item tooltip values
				switch (groupId)
				{
<<<<<<< HEAD
					case WidgetID.EXPLORERS_RING_ALCH_GROUP_ID:
						if (!config.showWhileAlching())
						{
							return null;
						}
=======
>>>>>>> initial import of runelite
					case WidgetID.INVENTORY_GROUP_ID:
						if (config.hideInventory())
						{
							return null;
						}
						// intentional fallthrough
					case WidgetID.BANK_GROUP_ID:
					case WidgetID.BANK_INVENTORY_GROUP_ID:
						// Make tooltip
						final String text = makeValueTooltip(menuEntry);
						if (text != null)
						{
							tooltipManager.add(new Tooltip(ColorUtil.prependColorTag(text, new Color(238, 238, 238))));
						}
						break;
				}
				break;
		}
		return null;
	}

	private String makeValueTooltip(MenuEntry menuEntry)
	{
		// Disabling both disables all value tooltips
		if (!config.showGEPrice() && !config.showHAValue())
		{
			return null;
		}

		final int widgetId = menuEntry.getParam1();
		ItemContainer container = null;

		// Inventory item
<<<<<<< HEAD
		if (widgetId == INVENTORY_ITEM_WIDGETID || widgetId == BANK_INVENTORY_ITEM_WIDGETID || widgetId == EXPLORERS_RING_ITEM_WIDGETID)
=======
		if (widgetId == INVENTORY_ITEM_WIDGETID || widgetId == BANK_INVENTORY_ITEM_WIDGETID)
>>>>>>> initial import of runelite
		{
			container = client.getItemContainer(InventoryID.INVENTORY);
		}
		// Bank item
		else if (widgetId == BANK_ITEM_WIDGETID)
		{
			container = client.getItemContainer(InventoryID.BANK);
		}

		if (container == null)
		{
			return null;
		}

		// Find the item in the container to get stack size
		final Item[] items = container.getItems();
		final int index = menuEntry.getParam0();
		if (index < items.length)
		{
			final Item item = items[index];
			return getItemStackValueText(item);
		}

		return null;
	}

	private String getItemStackValueText(Item item)
	{
		int id = item.getId();
		int qty = item.getQuantity();

		// Special case for coins and platinum tokens
		if (id == ItemID.COINS_995)
		{
<<<<<<< HEAD
			return QuantityFormatter.formatNumber(qty) + " gp";
		}
		else if (id == ItemID.PLATINUM_TOKEN)
		{
			return QuantityFormatter.formatNumber(qty * 1000) + " gp";
=======
			return StackFormatter.formatNumber(qty) + " gp";
		}
		else if (id == ItemID.PLATINUM_TOKEN)
		{
			return StackFormatter.formatNumber(qty * 1000) + " gp";
>>>>>>> initial import of runelite
		}

		ItemComposition itemDef = itemManager.getItemComposition(id);
		if (itemDef.getNote() != -1)
		{
			id = itemDef.getLinkedNoteId();
			itemDef = itemManager.getItemComposition(id);
		}

		// Only check prices for things with store prices
		if (itemDef.getPrice() <= 0)
		{
			return null;
		}

		int gePrice = 0;
		int haPrice = 0;
		int haProfit = 0;
<<<<<<< HEAD
		final int itemHaPrice = Math.round(itemDef.getPrice() * Constants.HIGH_ALCHEMY_MULTIPLIER);
=======
>>>>>>> initial import of runelite

		if (config.showGEPrice())
		{
			gePrice = itemManager.getItemPrice(id);
		}
		if (config.showHAValue())
		{
<<<<<<< HEAD
			haPrice = itemHaPrice;
		}
		if (gePrice > 0 && itemHaPrice > 0 && config.showAlchProfit())
		{
			haProfit = calculateHAProfit(itemHaPrice, gePrice);
=======
			haPrice = Math.round(itemDef.getPrice() * HIGH_ALCHEMY_CONSTANT);
		}
		if (gePrice > 0 && haPrice > 0 && config.showAlchProfit())
		{
			haProfit = calculateHAProfit(haPrice, gePrice);
>>>>>>> initial import of runelite
		}

		if (gePrice > 0 || haPrice > 0)
		{
			return stackValueText(qty, gePrice, haPrice, haProfit);
		}

		return null;
	}

	private String stackValueText(int qty, int gePrice, int haValue, int haProfit)
	{
		if (gePrice > 0)
		{
			itemStringBuilder.append("EX: ")
<<<<<<< HEAD
				.append(QuantityFormatter.quantityToStackSize(gePrice * qty))
=======
				.append(StackFormatter.quantityToStackSize(gePrice * qty))
>>>>>>> initial import of runelite
				.append(" gp");
			if (config.showEA() && qty > 1)
			{
				itemStringBuilder.append(" (")
<<<<<<< HEAD
					.append(QuantityFormatter.quantityToStackSize(gePrice))
=======
					.append(StackFormatter.quantityToStackSize(gePrice))
>>>>>>> initial import of runelite
					.append(" ea)");
			}
		}
		if (haValue > 0)
		{
			if (gePrice > 0)
			{
				itemStringBuilder.append("</br>");
			}

			itemStringBuilder.append("HA: ")
<<<<<<< HEAD
				.append(QuantityFormatter.quantityToStackSize(haValue * qty))
=======
				.append(StackFormatter.quantityToStackSize(haValue * qty))
>>>>>>> initial import of runelite
				.append(" gp");
			if (config.showEA() && qty > 1)
			{
				itemStringBuilder.append(" (")
<<<<<<< HEAD
					.append(QuantityFormatter.quantityToStackSize(haValue))
=======
					.append(StackFormatter.quantityToStackSize(haValue))
>>>>>>> initial import of runelite
					.append(" ea)");
			}
		}

		if (haProfit != 0)
		{
			Color haColor = haProfitColor(haProfit);

			itemStringBuilder.append("</br>");
			itemStringBuilder.append("HA Profit: ")
				.append(ColorUtil.wrapWithColorTag(String.valueOf(haProfit * qty), haColor))
				.append(" gp");
			if (config.showEA() && qty > 1)
			{
				itemStringBuilder.append(" (")
					.append(ColorUtil.wrapWithColorTag(String.valueOf(haProfit), haColor))
					.append(" ea)");
			}
		}

		// Build string and reset builder
		final String text = itemStringBuilder.toString();
		itemStringBuilder.setLength(0);
		return text;
	}

	private int calculateHAProfit(int haPrice, int gePrice)
	{
		int natureRunePrice = itemManager.getItemPrice(ItemID.NATURE_RUNE);
		return haPrice - gePrice - natureRunePrice;
	}

	private static Color haProfitColor(int haProfit)
	{
		return haProfit >= 0 ? Color.GREEN : Color.RED;
	}
}
