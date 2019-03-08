/*
 * Copyright (c) 2017, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.chat;

import com.google.common.base.MoreObjects;
import com.google.common.base.Strings;
import com.google.common.collect.HashMultimap;
<<<<<<< HEAD
import com.google.common.collect.ImmutableSet;
=======
>>>>>>> initial import of runelite
import com.google.common.collect.Multimap;
import java.awt.Color;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Queue;
<<<<<<< HEAD
import java.util.Set;
=======
>>>>>>> initial import of runelite
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.ChatLineBuffer;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.MessageNode;
<<<<<<< HEAD
import net.runelite.api.Player;
=======
>>>>>>> initial import of runelite
import net.runelite.api.Varbits;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.ResizeableChanged;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ChatColorConfig;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.ui.JagexColors;
import net.runelite.client.util.ColorUtil;

@Singleton
public class ChatMessageManager
{
<<<<<<< HEAD
	private static final Set<Integer> TUTORIAL_ISLAND_REGIONS = ImmutableSet.of(12336, 12335, 12592, 12080, 12079, 12436);

=======
>>>>>>> initial import of runelite
	private final Multimap<ChatMessageType, ChatColor> colorCache = HashMultimap.create();
	private final Client client;
	private final ChatColorConfig chatColorConfig;
	private final ClientThread clientThread;
	private int transparencyVarbit = -1;
	private final Queue<QueuedMessage> queuedMessages = new ConcurrentLinkedQueue<>();

	@Inject
	private ChatMessageManager(
		Client client,
		ChatColorConfig chatColorConfig,
		ClientThread clientThread)
	{
		this.client = client;
		this.chatColorConfig = chatColorConfig;
		this.clientThread = clientThread;
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		int setting = client.getVar(Varbits.TRANSPARENT_CHATBOX);

		if (transparencyVarbit != setting)
		{
			transparencyVarbit = setting;
			refreshAll();
		}
	}

	@Subscribe
	public void onResizeableChanged(ResizeableChanged event)
	{
		refreshAll();
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("textrecolor"))
		{
			loadColors();
			clientThread.invokeLater(this::refreshAll);
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage chatMessage)
	{
		MessageNode messageNode = chatMessage.getMessageNode();
		ChatMessageType chatMessageType = chatMessage.getType();

		boolean isChatboxTransparent = client.isResized() && client.getVar(Varbits.TRANSPARENT_CHATBOX) == 1;
		Color usernameColor = null;
		Color senderColor = null;

		switch (chatMessageType)
		{
<<<<<<< HEAD
			// username recoloring for MODPRIVATECHAT, PRIVATECHAT and PRIVATECHATOUT
			// ChatMessageTypes is handled in the script callback event
			case TRADEREQ:
			case AUTOTYPER:
			case PUBLICCHAT:
			case MODCHAT:
=======
			case PRIVATE_MESSAGE_RECEIVED_MOD:
			case PRIVATE_MESSAGE_RECEIVED:
			case PRIVATE_MESSAGE_SENT:
				usernameColor = isChatboxTransparent ? chatColorConfig.transparentPrivateUsernames() : chatColorConfig.opaquePrivateUsernames();
				break;

			case TRADE:
			case AUTOCHAT:
			case PUBLIC:
			case PUBLIC_MOD:
>>>>>>> initial import of runelite
			{
				boolean isFriend = client.isFriended(chatMessage.getName(), true) && !client.getLocalPlayer().getName().equals(chatMessage.getName());

				if (isFriend)
				{
					usernameColor = isChatboxTransparent ? chatColorConfig.transparentPublicFriendUsernames() : chatColorConfig.opaquePublicFriendUsernames();
				}
				if (usernameColor == null)
				{
					usernameColor = isChatboxTransparent ? chatColorConfig.transparentUsername() : chatColorConfig.opaqueUsername();
				}
				break;
			}
<<<<<<< HEAD
			case FRIENDSCHAT:
=======
			case CLANCHAT:
>>>>>>> initial import of runelite
				usernameColor = isChatboxTransparent ? chatColorConfig.transparentClanUsernames() : chatColorConfig.opaqueClanUsernames();
				break;
		}

		senderColor = isChatboxTransparent ? chatColorConfig.transparentClanChannelName() : chatColorConfig.opaqueClanChannelName();

		if (usernameColor != null)
		{
			messageNode.setName(ColorUtil.wrapWithColorTag(messageNode.getName(), usernameColor));
		}

		String sender = chatMessage.getSender();
		if (senderColor != null && !Strings.isNullOrEmpty(sender))
		{
			messageNode.setSender(ColorUtil.wrapWithColorTag(sender, senderColor));
		}

		final Collection<ChatColor> chatColors = colorCache.get(chatMessageType);
		for (ChatColor chatColor : chatColors)
		{
			if (chatColor.isTransparent() != isChatboxTransparent || chatColor.getType() != ChatColorType.NORMAL || chatColor.isDefault())
			{
				continue;
			}

<<<<<<< HEAD
			// Replace </col> tags in the message with the new color so embedded </col> won't reset the color
			final Color color = chatColor.getColor();
			messageNode.setValue(ColorUtil.wrapWithColorTag(
				messageNode.getValue().replace(ColorUtil.CLOSING_COLOR_TAG, ColorUtil.colorTag(color)),
				color));
=======
			messageNode.setValue(ColorUtil.wrapWithColorTag(messageNode.getValue(), chatColor.getColor()));
>>>>>>> initial import of runelite
			break;
		}
	}

	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent scriptCallbackEvent)
	{
		final String eventName = scriptCallbackEvent.getEventName();

		switch (eventName)
		{
			case "privateChatFrom":
			case "privateChatTo":
			case "privateChatSplitFrom":
			case "privateChatSplitTo":
				break;
			default:
				return;
		}

		boolean isChatboxTransparent = client.isResized() && client.getVar(Varbits.TRANSPARENT_CHATBOX) == 1;
		Color usernameColor = isChatboxTransparent ? chatColorConfig.transparentPrivateUsernames() : chatColorConfig.opaquePrivateUsernames();
		if (usernameColor == null)
		{
			return;
		}

		final String[] stringStack = client.getStringStack();
		final int stringStackSize = client.getStringStackSize();

		// Stack is: To/From playername :
		String toFrom = stringStack[stringStackSize - 3];
		stringStack[stringStackSize - 3] = ColorUtil.prependColorTag(toFrom, usernameColor);
	}

	private static Color getDefaultColor(ChatMessageType type, boolean transparent)
	{
		if (!transparent)
		{
			switch (type)
			{
<<<<<<< HEAD
				case PUBLICCHAT:
				case MODCHAT:
					return JagexColors.CHAT_PUBLIC_TEXT_OPAQUE_BACKGROUND;
				case PRIVATECHATOUT:
				case MODPRIVATECHAT:
				case PRIVATECHAT:
					return JagexColors.CHAT_PRIVATE_MESSAGE_TEXT_OPAQUE_BACKGROUND;
				case FRIENDSCHAT:
					return JagexColors.CHAT_CLAN_TEXT_OPAQUE_BACKGROUND;
				case ITEM_EXAMINE:
				case OBJECT_EXAMINE:
				case NPC_EXAMINE:
				case CONSOLE:
=======
				case PUBLIC:
				case PUBLIC_MOD:
					return JagexColors.CHAT_PUBLIC_TEXT_OPAQUE_BACKGROUND;
				case PRIVATE_MESSAGE_SENT:
				case PRIVATE_MESSAGE_RECEIVED_MOD:
				case PRIVATE_MESSAGE_RECEIVED:
					return JagexColors.CHAT_PRIVATE_MESSAGE_TEXT_OPAQUE_BACKGROUND;
				case CLANCHAT:
					return JagexColors.CHAT_CLAN_TEXT_OPAQUE_BACKGROUND;
				case EXAMINE_ITEM:
				case EXAMINE_OBJECT:
				case EXAMINE_NPC:
				case GAME:
>>>>>>> initial import of runelite
					return JagexColors.CHAT_GAME_EXAMINE_TEXT_OPAQUE_BACKGROUND;
			}
		}
		else
		{
			switch (type)
			{
<<<<<<< HEAD
				case PUBLICCHAT:
				case MODCHAT:
					return JagexColors.CHAT_PUBLIC_TEXT_TRANSPARENT_BACKGROUND;
				case PRIVATECHATOUT:
				case MODPRIVATECHAT:
				case PRIVATECHAT:
					return JagexColors.CHAT_PRIVATE_MESSAGE_TEXT_TRANSPARENT_BACKGROUND;
				case FRIENDSCHAT:
					return JagexColors.CHAT_CLAN_TEXT_TRANSPARENT_BACKGROUND;
				case ITEM_EXAMINE:
				case OBJECT_EXAMINE:
				case NPC_EXAMINE:
				case CONSOLE:
=======
				case PUBLIC:
				case PUBLIC_MOD:
					return JagexColors.CHAT_PUBLIC_TEXT_TRANSPARENT_BACKGROUND;
				case PRIVATE_MESSAGE_SENT:
				case PRIVATE_MESSAGE_RECEIVED_MOD:
				case PRIVATE_MESSAGE_RECEIVED:
					return JagexColors.CHAT_PRIVATE_MESSAGE_TEXT_TRANSPARENT_BACKGROUND;
				case CLANCHAT:
					return JagexColors.CHAT_CLAN_TEXT_TRANSPARENT_BACKGROUND;
				case EXAMINE_ITEM:
				case EXAMINE_OBJECT:
				case EXAMINE_NPC:
				case GAME:
>>>>>>> initial import of runelite
					return JagexColors.CHAT_GAME_EXAMINE_TEXT_TRANSPARENT_BACKGROUND;
			}
		}

		return null;
	}

	/**
	 * Load all configured colors
	 */
	public void loadColors()
	{
		colorCache.clear();

		// Apply defaults
		for (ChatMessageType chatMessageType : ChatMessageType.values())
		{
			Color defaultTransparent = getDefaultColor(chatMessageType, true);
			if (defaultTransparent != null)
			{
				cacheColor(new ChatColor(ChatColorType.NORMAL, defaultTransparent, true, true), chatMessageType);
			}

			Color defaultOpaque = getDefaultColor(chatMessageType, false);
			if (defaultOpaque != null)
			{
				cacheColor(new ChatColor(ChatColorType.NORMAL, defaultOpaque, false, true), chatMessageType);
			}
		}

		if (chatColorConfig.opaquePublicChat() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaquePublicChat(), false),
<<<<<<< HEAD
				ChatMessageType.PUBLICCHAT);
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaquePublicChat(), false),
				ChatMessageType.MODCHAT);
=======
				ChatMessageType.PUBLIC);
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaquePublicChat(), false),
				ChatMessageType.PUBLIC_MOD);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.opaquePublicChatHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaquePublicChatHighlight(), false),
<<<<<<< HEAD
				ChatMessageType.PUBLICCHAT);
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaquePublicChatHighlight(), false),
				ChatMessageType.MODCHAT);
=======
				ChatMessageType.PUBLIC);
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaquePublicChatHighlight(), false),
				ChatMessageType.PUBLIC_MOD);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.opaquePrivateMessageSent() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaquePrivateMessageSent(), false),
<<<<<<< HEAD
				ChatMessageType.PRIVATECHATOUT);
=======
				ChatMessageType.PRIVATE_MESSAGE_SENT);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.opaquePrivateMessageSentHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaquePrivateMessageSentHighlight(), false),
<<<<<<< HEAD
				ChatMessageType.PRIVATECHATOUT);
=======
				ChatMessageType.PRIVATE_MESSAGE_SENT);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.opaquePrivateMessageReceived() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaquePrivateMessageReceived(), false),
<<<<<<< HEAD
				ChatMessageType.PRIVATECHAT);
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaquePrivateMessageReceived(), false),
				ChatMessageType.MODPRIVATECHAT);
=======
				ChatMessageType.PRIVATE_MESSAGE_RECEIVED);
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaquePrivateMessageReceived(), false),
				ChatMessageType.PRIVATE_MESSAGE_RECEIVED_MOD);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.opaquePrivateMessageReceivedHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaquePrivateMessageReceivedHighlight(), false),
<<<<<<< HEAD
				ChatMessageType.PRIVATECHAT);
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaquePrivateMessageReceivedHighlight(), false),
				ChatMessageType.MODPRIVATECHAT);
=======
				ChatMessageType.PRIVATE_MESSAGE_RECEIVED);
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaquePrivateMessageReceivedHighlight(), false),
				ChatMessageType.PRIVATE_MESSAGE_RECEIVED_MOD);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.opaqueClanChatInfo() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueClanChatInfo(), false),
<<<<<<< HEAD
				ChatMessageType.FRIENDSCHATNOTIFICATION);
=======
				ChatMessageType.CLANCHAT_INFO);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.opaqueClanChatInfoHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaqueClanChatInfoHighlight(), false),
<<<<<<< HEAD
				ChatMessageType.FRIENDSCHATNOTIFICATION);
=======
				ChatMessageType.CLANCHAT_INFO);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.opaqueClanChatMessage() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueClanChatMessage(), false),
<<<<<<< HEAD
				ChatMessageType.FRIENDSCHAT);
=======
				ChatMessageType.CLANCHAT);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.opaqueClanChatMessageHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaqueClanChatMessageHighlight(), false),
<<<<<<< HEAD
				ChatMessageType.FRIENDSCHAT);
=======
				ChatMessageType.CLANCHAT);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.opaqueAutochatMessage() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueAutochatMessage(), false),
<<<<<<< HEAD
				ChatMessageType.AUTOTYPER);
=======
				ChatMessageType.AUTOCHAT);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.opaqueAutochatMessageHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaqueAutochatMessageHighlight(), false),
<<<<<<< HEAD
				ChatMessageType.AUTOTYPER);
=======
				ChatMessageType.AUTOCHAT);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.opaqueTradeChatMessage() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueTradeChatMessage(), false),
<<<<<<< HEAD
				ChatMessageType.TRADEREQ);
=======
				ChatMessageType.TRADE);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.opaqueTradeChatMessageHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaqueTradeChatMessageHighlight(), false),
<<<<<<< HEAD
				ChatMessageType.TRADEREQ);
=======
				ChatMessageType.TRADE);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.opaqueServerMessage() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueServerMessage(), false),
<<<<<<< HEAD
				ChatMessageType.GAMEMESSAGE);
=======
				ChatMessageType.SERVER);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.opaqueServerMessageHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaqueServerMessageHighlight(), false),
<<<<<<< HEAD
				ChatMessageType.GAMEMESSAGE);
=======
				ChatMessageType.SERVER);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.opaqueGameMessage() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueGameMessage(), false),
<<<<<<< HEAD
				ChatMessageType.CONSOLE);
=======
				ChatMessageType.GAME);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.opaqueGameMessageHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaqueGameMessageHighlight(), false),
<<<<<<< HEAD
				ChatMessageType.CONSOLE);
=======
				ChatMessageType.GAME);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.opaqueExamine() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueExamine(), false),
<<<<<<< HEAD
				ChatMessageType.OBJECT_EXAMINE);
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueExamine(), false),
				ChatMessageType.NPC_EXAMINE);
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueExamine(), false),
				ChatMessageType.ITEM_EXAMINE);
=======
				ChatMessageType.EXAMINE_OBJECT);
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueExamine(), false),
				ChatMessageType.EXAMINE_NPC);
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueExamine(), false),
				ChatMessageType.EXAMINE_ITEM);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.opaqueExamineHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaqueExamineHighlight(), false),
<<<<<<< HEAD
				ChatMessageType.OBJECT_EXAMINE);
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaqueExamineHighlight(), false),
				ChatMessageType.NPC_EXAMINE);
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaqueExamineHighlight(), false),
				ChatMessageType.ITEM_EXAMINE);
=======
				ChatMessageType.EXAMINE_OBJECT);
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaqueExamineHighlight(), false),
				ChatMessageType.EXAMINE_NPC);
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaqueExamineHighlight(), false),
				ChatMessageType.EXAMINE_ITEM);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.opaqueFiltered() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueFiltered(), false),
<<<<<<< HEAD
				ChatMessageType.SPAM);
=======
				ChatMessageType.FILTERED);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.opaqueFilteredHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaqueFilteredHighlight(), false),
<<<<<<< HEAD
				ChatMessageType.SPAM);
		}
		if (chatColorConfig.opaquePrivateUsernames() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaquePrivateUsernames(), false),
				ChatMessageType.LOGINLOGOUTNOTIFICATION);
=======
				ChatMessageType.FILTERED);
>>>>>>> initial import of runelite
		}

		//Transparent Chat Colours
		if (chatColorConfig.transparentPublicChat() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentPublicChat(), true),
<<<<<<< HEAD
				ChatMessageType.PUBLICCHAT);
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentPublicChat(), true),
				ChatMessageType.MODCHAT);
=======
				ChatMessageType.PUBLIC);
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentPublicChat(), true),
				ChatMessageType.PUBLIC_MOD);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.transparentPublicChatHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentPublicChatHighlight(), true),
<<<<<<< HEAD
				ChatMessageType.PUBLICCHAT);
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentPublicChatHighlight(), true),
				ChatMessageType.MODCHAT);
=======
				ChatMessageType.PUBLIC);
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentPublicChatHighlight(), true),
				ChatMessageType.PUBLIC_MOD);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.transparentPrivateMessageSent() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentPrivateMessageSent(), true),
<<<<<<< HEAD
				ChatMessageType.PRIVATECHATOUT);
=======
				ChatMessageType.PRIVATE_MESSAGE_SENT);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.transparentPrivateMessageSentHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentPrivateMessageSentHighlight(), true),
<<<<<<< HEAD
				ChatMessageType.PRIVATECHATOUT);
=======
				ChatMessageType.PRIVATE_MESSAGE_SENT);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.transparentPrivateMessageReceived() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentPrivateMessageReceived(), true),
<<<<<<< HEAD
				ChatMessageType.PRIVATECHAT);
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentPrivateMessageReceived(), true),
				ChatMessageType.MODPRIVATECHAT);
=======
				ChatMessageType.PRIVATE_MESSAGE_RECEIVED);
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentPrivateMessageReceived(), true),
				ChatMessageType.PRIVATE_MESSAGE_RECEIVED_MOD);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.transparentPrivateMessageReceivedHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentPrivateMessageReceivedHighlight(), true),
<<<<<<< HEAD
				ChatMessageType.PRIVATECHAT);
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentPrivateMessageReceivedHighlight(), true),
				ChatMessageType.MODPRIVATECHAT);
=======
				ChatMessageType.PRIVATE_MESSAGE_RECEIVED);
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentPrivateMessageReceivedHighlight(), true),
				ChatMessageType.PRIVATE_MESSAGE_RECEIVED_MOD);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.transparentClanChatInfo() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentClanChatInfo(), true),
<<<<<<< HEAD
				ChatMessageType.FRIENDSCHATNOTIFICATION);
=======
				ChatMessageType.CLANCHAT_INFO);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.transparentClanChatInfoHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentClanChatInfoHighlight(), true),
<<<<<<< HEAD
				ChatMessageType.FRIENDSCHATNOTIFICATION);
=======
				ChatMessageType.CLANCHAT_INFO);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.transparentClanChatMessage() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentClanChatMessage(), true),
<<<<<<< HEAD
				ChatMessageType.FRIENDSCHAT);
=======
				ChatMessageType.CLANCHAT);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.transparentClanChatMessageHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentClanChatMessageHighlight(), true),
<<<<<<< HEAD
				ChatMessageType.FRIENDSCHAT);
=======
				ChatMessageType.CLANCHAT);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.transparentAutochatMessage() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentAutochatMessage(), true),
<<<<<<< HEAD
				ChatMessageType.AUTOTYPER);
=======
				ChatMessageType.AUTOCHAT);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.transparentAutochatMessageHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentAutochatMessageHighlight(), true),
<<<<<<< HEAD
				ChatMessageType.AUTOTYPER);
=======
				ChatMessageType.AUTOCHAT);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.transparentTradeChatMessage() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentTradeChatMessage(), true),
<<<<<<< HEAD
				ChatMessageType.TRADEREQ);
=======
				ChatMessageType.TRADE);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.transparentTradeChatMessageHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentTradeChatMessageHighlight(), true),
<<<<<<< HEAD
				ChatMessageType.TRADEREQ);
=======
				ChatMessageType.TRADE);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.transparentServerMessage() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentServerMessage(), true),
<<<<<<< HEAD
				ChatMessageType.GAMEMESSAGE);
=======
				ChatMessageType.SERVER);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.transparentServerMessageHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentServerMessageHighlight(), true),
<<<<<<< HEAD
				ChatMessageType.GAMEMESSAGE);
=======
				ChatMessageType.SERVER);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.transparentGameMessage() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentGameMessage(), true),
<<<<<<< HEAD
				ChatMessageType.CONSOLE);
=======
				ChatMessageType.GAME);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.transparentGameMessageHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentGameMessageHighlight(), true),
<<<<<<< HEAD
				ChatMessageType.CONSOLE);
=======
				ChatMessageType.GAME);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.transparentExamine() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentExamine(), true),
<<<<<<< HEAD
				ChatMessageType.OBJECT_EXAMINE);
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentExamine(), true),
				ChatMessageType.NPC_EXAMINE);
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentExamine(), true),
				ChatMessageType.ITEM_EXAMINE);
=======
				ChatMessageType.EXAMINE_OBJECT);
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentExamine(), true),
				ChatMessageType.EXAMINE_NPC);
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentExamine(), true),
				ChatMessageType.EXAMINE_ITEM);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.transparentExamineHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentExamineHighlight(), true),
<<<<<<< HEAD
				ChatMessageType.OBJECT_EXAMINE);
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentExamineHighlight(), true),
				ChatMessageType.NPC_EXAMINE);
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentExamineHighlight(), true),
				ChatMessageType.ITEM_EXAMINE);
=======
				ChatMessageType.EXAMINE_OBJECT);
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentExamineHighlight(), true),
				ChatMessageType.EXAMINE_NPC);
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentExamineHighlight(), true),
				ChatMessageType.EXAMINE_ITEM);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.transparentFiltered() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentFiltered(), true),
<<<<<<< HEAD
				ChatMessageType.SPAM);
=======
				ChatMessageType.FILTERED);
>>>>>>> initial import of runelite
		}
		if (chatColorConfig.transparentFilteredHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentFilteredHighlight(), true),
<<<<<<< HEAD
				ChatMessageType.SPAM);
		}
		if (chatColorConfig.transparentPrivateUsernames() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentPrivateUsernames(), true),
				ChatMessageType.LOGINLOGOUTNOTIFICATION);
=======
				ChatMessageType.FILTERED);
>>>>>>> initial import of runelite
		}
	}

	private void cacheColor(final ChatColor chatColor, final ChatMessageType... types)
	{
		for (ChatMessageType chatMessageType : types)
		{
			// color is excluded from equals/hashCode on ChatColor
			colorCache.remove(chatMessageType, chatColor);
			colorCache.put(chatMessageType, chatColor);
		}
	}

	public void queue(QueuedMessage message)
	{
		queuedMessages.add(message);
	}

	public void process()
	{
		if (!queuedMessages.isEmpty())
		{
<<<<<<< HEAD
			try
			{
				queuedMessages.forEach(this::add);
			}
			finally
			{
				queuedMessages.clear();
			}
=======
			queuedMessages.forEach(this::add);
			queuedMessages.clear();
>>>>>>> initial import of runelite
		}
	}

	private void add(QueuedMessage message)
	{
<<<<<<< HEAD
		// Do not send message if the player is on tutorial island
		final Player player = client.getLocalPlayer();
		if (player != null && TUTORIAL_ISLAND_REGIONS.contains(player.getWorldLocation().getRegionID()))
		{
			return;
		}

=======
>>>>>>> initial import of runelite
		// this updates chat cycle
		client.addChatMessage(
			message.getType(),
			MoreObjects.firstNonNull(message.getName(), ""),
			MoreObjects.firstNonNull(message.getValue(), message.getRuneLiteFormattedMessage()),
			message.getSender());

		// Get last message from line buffer (the one we just added)
		final ChatLineBuffer chatLineBuffer = client.getChatLineMap().get(message.getType().getType());
		final MessageNode[] lines = chatLineBuffer.getLines();
		final MessageNode line = lines[0];

		// Update the message with RuneLite additions
		line.setRuneLiteFormatMessage(message.getRuneLiteFormattedMessage());
		line.setTimestamp(message.getTimestamp());

		update(line);
	}

	public void update(final MessageNode target)
	{
		if (Strings.isNullOrEmpty(target.getRuneLiteFormatMessage()))
		{
			return;
		}

		final boolean transparent = client.isResized() && transparencyVarbit != 0;
		final Collection<ChatColor> chatColors = colorCache.get(target.getType());

		// If we do not have any colors cached, simply set clean message
		if (chatColors == null || chatColors.isEmpty())
		{
			target.setValue(target.getRuneLiteFormatMessage());
			return;
		}

		target.setValue(recolorMessage(transparent, target.getRuneLiteFormatMessage(), target.getType()));
	}

	private String recolorMessage(boolean transparent, String message, ChatMessageType messageType)
	{
		final Collection<ChatColor> chatColors = colorCache.get(messageType);
		final AtomicReference<String> resultMessage = new AtomicReference<>(message);

		// Replace custom formatting with actual colors
		chatColors.stream()
			.filter(chatColor -> chatColor.isTransparent() == transparent)
			.forEach(chatColor ->
				resultMessage.getAndUpdate(oldMessage -> oldMessage.replaceAll(
					"<col" + chatColor.getType().name() + ">",
					ColorUtil.colorTag(chatColor.getColor()))));

		return resultMessage.get();
	}

	private void refreshAll()
	{
		client.getChatLineMap().values().stream()
			.filter(Objects::nonNull)
			.flatMap(clb -> Arrays.stream(clb.getLines()))
			.filter(Objects::nonNull)
			.forEach(this::update);

		client.refreshChat();
	}
}
