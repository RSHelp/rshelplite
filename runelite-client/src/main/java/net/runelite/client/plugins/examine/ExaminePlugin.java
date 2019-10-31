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
package net.runelite.client.plugins.examine;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.time.Instant;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.regex.Pattern;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
<<<<<<< HEAD
import net.runelite.api.Constants;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemID;
=======
import net.runelite.api.ItemComposition;
>>>>>>> initial import of runelite
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.widgets.Widget;
<<<<<<< HEAD
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import static net.runelite.api.widgets.WidgetInfo.SEED_VAULT_ITEM_CONTAINER;
=======
import net.runelite.api.widgets.WidgetInfo;
>>>>>>> initial import of runelite
import static net.runelite.api.widgets.WidgetInfo.TO_CHILD;
import static net.runelite.api.widgets.WidgetInfo.TO_GROUP;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
<<<<<<< HEAD
import net.runelite.client.util.QuantityFormatter;
import net.runelite.client.util.Text;
=======
import net.runelite.client.util.StackFormatter;
>>>>>>> initial import of runelite
import net.runelite.http.api.examine.ExamineClient;

/**
 * Submits examine info to the api
 *
 * @author Adam
 */
@PluginDescriptor(
	name = "Examine",
	description = "Send examine information to the API",
	tags = {"npcs", "items", "inventory", "objects"}
)
@Slf4j
public class ExaminePlugin extends Plugin
{
<<<<<<< HEAD
=======
	private static final float HIGH_ALCHEMY_CONSTANT = 0.6f;
>>>>>>> initial import of runelite
	private static final Pattern X_PATTERN = Pattern.compile("^\\d+ x ");

	private final Deque<PendingExamine> pending = new ArrayDeque<>();
	private final Cache<CacheKey, Boolean> cache = CacheBuilder.newBuilder()
		.maximumSize(128L)
		.build();

	@Inject
	private ExamineClient examineClient;

	@Inject
	private Client client;

	@Inject
	private ItemManager itemManager;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private ScheduledExecutorService executor;

<<<<<<< HEAD
=======

>>>>>>> initial import of runelite
	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		pending.clear();
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
<<<<<<< HEAD
		if (!Text.removeTags(event.getMenuOption()).equals("Examine"))
=======
		if (!event.getMenuOption().equals("Examine"))
>>>>>>> initial import of runelite
		{
			return;
		}

		ExamineType type;
		int id, quantity = -1;
		switch (event.getMenuAction())
		{
			case EXAMINE_ITEM:
			{
				type = ExamineType.ITEM;
				id = event.getId();

				int widgetId = event.getWidgetId();
				int widgetGroup = TO_GROUP(widgetId);
				int widgetChild = TO_CHILD(widgetId);
				Widget widget = client.getWidget(widgetGroup, widgetChild);
				WidgetItem widgetItem = widget.getWidgetItem(event.getActionParam());
<<<<<<< HEAD
				quantity = widgetItem != null && widgetItem.getId() >= 0 ? widgetItem.getQuantity() : 1;
=======
				quantity = widgetItem != null ? widgetItem.getQuantity() : 1;
>>>>>>> initial import of runelite
				break;
			}
			case EXAMINE_ITEM_BANK_EQ:
			{
				type = ExamineType.ITEM_BANK_EQ;
				int[] qi = findItemFromWidget(event.getWidgetId(), event.getActionParam());
				if (qi == null)
				{
					log.debug("Examine for item with unknown widget: {}", event);
					return;
				}
				quantity = qi[0];
				id = qi[1];
				break;
			}
			case EXAMINE_OBJECT:
				type = ExamineType.OBJECT;
				id = event.getId();
				break;
			case EXAMINE_NPC:
				type = ExamineType.NPC;
				id = event.getId();
				break;
			default:
				return;
		}

		PendingExamine pendingExamine = new PendingExamine();
		pendingExamine.setType(type);
		pendingExamine.setId(id);
		pendingExamine.setQuantity(quantity);
		pendingExamine.setCreated(Instant.now());
		pending.push(pendingExamine);
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		ExamineType type;
		switch (event.getType())
		{
<<<<<<< HEAD
			case ITEM_EXAMINE:
				type = ExamineType.ITEM;
				break;
			case OBJECT_EXAMINE:
				type = ExamineType.OBJECT;
				break;
			case NPC_EXAMINE:
				type = ExamineType.NPC;
				break;
			case GAMEMESSAGE:
=======
			case EXAMINE_ITEM:
				type = ExamineType.ITEM;
				break;
			case EXAMINE_OBJECT:
				type = ExamineType.OBJECT;
				break;
			case EXAMINE_NPC:
				type = ExamineType.NPC;
				break;
			case SERVER:
>>>>>>> initial import of runelite
				type = ExamineType.ITEM_BANK_EQ;
				break;
			default:
				return;
		}

		if (pending.isEmpty())
		{
			log.debug("Got examine without a pending examine?");
			return;
		}

		PendingExamine pendingExamine = pending.pop();

		if (pendingExamine.getType() != type)
		{
			log.debug("Type mismatch for pending examine: {} != {}", pendingExamine.getType(), type);
			pending.clear(); // eh
			return;
		}

		log.debug("Got examine for {} {}: {}", pendingExamine.getType(), pendingExamine.getId(), event.getMessage());

		// If it is an item, show the price of it
		final ItemComposition itemComposition;
		if (pendingExamine.getType() == ExamineType.ITEM || pendingExamine.getType() == ExamineType.ITEM_BANK_EQ)
		{
			final int itemId = pendingExamine.getId();
			final int itemQuantity = pendingExamine.getQuantity();
<<<<<<< HEAD

			if (itemId == ItemID.COINS_995)
			{
				return;
			}

=======
>>>>>>> initial import of runelite
			itemComposition = itemManager.getItemComposition(itemId);

			if (itemComposition != null)
			{
				final int id = itemManager.canonicalize(itemComposition.getId());
				executor.submit(() -> getItemPrice(id, itemComposition, itemQuantity));
			}
		}
		else
		{
			itemComposition = null;
		}

		// Don't submit examine info for tradeable items, which we already have from the RS item api
		if (itemComposition != null && itemComposition.isTradeable())
		{
			return;
		}

		// Large quantities of items show eg. 100000 x Coins
		if (type == ExamineType.ITEM && X_PATTERN.matcher(event.getMessage()).lookingAt())
		{
			return;
		}

		CacheKey key = new CacheKey(type, pendingExamine.getId());
		Boolean cached = cache.getIfPresent(key);
		if (cached != null)
		{
			return;
		}

		cache.put(key, Boolean.TRUE);
		submitExamine(pendingExamine, event.getMessage());
	}

	private int[] findItemFromWidget(int widgetId, int actionParam)
	{
		int widgetGroup = TO_GROUP(widgetId);
		int widgetChild = TO_CHILD(widgetId);
		Widget widget = client.getWidget(widgetGroup, widgetChild);

		if (widget == null)
		{
			return null;
		}

		if (WidgetInfo.EQUIPMENT.getGroupId() == widgetGroup)
		{
			Widget widgetItem = widget.getChild(1);
			if (widgetItem != null)
			{
				return new int[]{widgetItem.getItemQuantity(), widgetItem.getItemId()};
			}
		}
		else if (WidgetInfo.SMITHING_INVENTORY_ITEMS_CONTAINER.getGroupId() == widgetGroup)
		{
			Widget widgetItem = widget.getChild(2);
			if (widgetItem != null)
			{
				return new int[]{widgetItem.getItemQuantity(), widgetItem.getItemId()};
			}
		}
		else if (WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER.getGroupId() == widgetGroup
			|| WidgetInfo.RUNE_POUCH_ITEM_CONTAINER.getGroupId() == widgetGroup)
		{
			Widget widgetItem = widget.getChild(actionParam);
			if (widgetItem != null)
			{
				return new int[]{widgetItem.getItemQuantity(), widgetItem.getItemId()};
			}
		}
<<<<<<< HEAD
		else if (WidgetInfo.BANK_ITEM_CONTAINER.getGroupId() == widgetGroup
			|| WidgetInfo.CLUE_SCROLL_REWARD_ITEM_CONTAINER.getGroupId() == widgetGroup
			|| WidgetInfo.LOOTING_BAG_CONTAINER.getGroupId() == widgetGroup
			|| WidgetID.SEED_VAULT_INVENTORY_GROUP_ID == widgetGroup
			|| WidgetID.SEED_BOX_GROUP_ID == widgetGroup
			|| WidgetID.PLAYER_TRADE_SCREEN_GROUP_ID == widgetGroup
			|| WidgetID.PLAYER_TRADE_INVENTORY_GROUP_ID == widgetGroup)
=======
		else if (WidgetInfo.BANK_ITEM_CONTAINER.getGroupId() == widgetGroup)
>>>>>>> initial import of runelite
		{
			Widget[] children = widget.getDynamicChildren();
			if (actionParam < children.length)
			{
				Widget widgetItem = children[actionParam];
				return new int[]{widgetItem.getItemQuantity(), widgetItem.getItemId()};
			}
		}
		else if (WidgetInfo.SHOP_ITEMS_CONTAINER.getGroupId() == widgetGroup)
		{
			Widget[] children = widget.getDynamicChildren();
			if (actionParam < children.length)
			{
				Widget widgetItem = children[actionParam];
				return new int[]{1, widgetItem.getItemId()};
			}
		}
<<<<<<< HEAD
		else if (WidgetID.SEED_VAULT_GROUP_ID == widgetGroup)
		{
			Widget[] children = client.getWidget(SEED_VAULT_ITEM_CONTAINER).getDynamicChildren();
=======
		else if (WidgetInfo.CLUE_SCROLL_REWARD_ITEM_CONTAINER.getGroupId() == widgetGroup)
		{
			Widget[] children = widget.getDynamicChildren();
			if (actionParam < children.length)
			{
				Widget widgetItem = children[actionParam];
				return new int[]{widgetItem.getItemQuantity(), widgetItem.getItemId()};
			}
		}
		else if (WidgetInfo.LOOTING_BAG_CONTAINER.getGroupId() == widgetGroup)
		{
			Widget[] children = widget.getDynamicChildren();
>>>>>>> initial import of runelite
			if (actionParam < children.length)
			{
				Widget widgetItem = children[actionParam];
				return new int[]{widgetItem.getItemQuantity(), widgetItem.getItemId()};
			}
		}

		return null;
	}

	private void getItemPrice(int id, ItemComposition itemComposition, int quantity)
	{
		// quantity is at least 1
		quantity = Math.max(1, quantity);
		int itemCompositionPrice = itemComposition.getPrice();
		final int gePrice = itemManager.getItemPrice(id);
<<<<<<< HEAD
		final int alchPrice = itemCompositionPrice <= 0 ? 0 : Math.round(itemCompositionPrice * Constants.HIGH_ALCHEMY_MULTIPLIER);
=======
		final int alchPrice = itemCompositionPrice <= 0 ? 0 : Math.round(itemCompositionPrice * HIGH_ALCHEMY_CONSTANT);
>>>>>>> initial import of runelite

		if (gePrice > 0 || alchPrice > 0)
		{
			final ChatMessageBuilder message = new ChatMessageBuilder()
				.append(ChatColorType.NORMAL)
				.append("Price of ")
				.append(ChatColorType.HIGHLIGHT);

			if (quantity > 1)
			{
				message
<<<<<<< HEAD
					.append(QuantityFormatter.formatNumber(quantity))
=======
					.append(StackFormatter.formatNumber(quantity))
>>>>>>> initial import of runelite
					.append(" x ");
			}

			message
				.append(itemComposition.getName())
				.append(ChatColorType.NORMAL)
				.append(":");

			if (gePrice > 0)
			{
				message
					.append(ChatColorType.NORMAL)
					.append(" GE average ")
					.append(ChatColorType.HIGHLIGHT)
<<<<<<< HEAD
					.append(QuantityFormatter.formatNumber(gePrice * quantity));
=======
					.append(StackFormatter.formatNumber(gePrice * quantity));
>>>>>>> initial import of runelite

				if (quantity > 1)
				{
					message
						.append(ChatColorType.NORMAL)
						.append(" (")
						.append(ChatColorType.HIGHLIGHT)
<<<<<<< HEAD
						.append(QuantityFormatter.formatNumber(gePrice))
=======
						.append(StackFormatter.formatNumber(gePrice))
>>>>>>> initial import of runelite
						.append(ChatColorType.NORMAL)
						.append("ea)");
				}
			}

			if (alchPrice > 0)
			{
				message
					.append(ChatColorType.NORMAL)
					.append(" HA value ")
					.append(ChatColorType.HIGHLIGHT)
<<<<<<< HEAD
					.append(QuantityFormatter.formatNumber(alchPrice * quantity));
=======
					.append(StackFormatter.formatNumber(alchPrice * quantity));
>>>>>>> initial import of runelite

				if (quantity > 1)
				{
					message
						.append(ChatColorType.NORMAL)
						.append(" (")
						.append(ChatColorType.HIGHLIGHT)
<<<<<<< HEAD
						.append(QuantityFormatter.formatNumber(alchPrice))
=======
						.append(StackFormatter.formatNumber(alchPrice))
>>>>>>> initial import of runelite
						.append(ChatColorType.NORMAL)
						.append("ea)");
				}
			}

			chatMessageManager.queue(QueuedMessage.builder()
<<<<<<< HEAD
				.type(ChatMessageType.ITEM_EXAMINE)
=======
				.type(ChatMessageType.EXAMINE_ITEM)
>>>>>>> initial import of runelite
				.runeLiteFormattedMessage(message.build())
				.build());
		}
	}

	private void submitExamine(PendingExamine examine, String text)
	{
		int id = examine.getId();

		switch (examine.getType())
		{
			case ITEM:
				examineClient.submitItem(id, text);
				break;
			case OBJECT:
				examineClient.submitObject(id, text);
				break;
			case NPC:
				examineClient.submitNpc(id, text);
				break;
		}
	}

}
