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
package net.runelite.client.game;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
<<<<<<< HEAD
=======
import java.awt.image.ColorModel;
import java.awt.image.DataBufferByte;
import java.awt.image.IndexColorModel;
import java.awt.image.WritableRaster;
>>>>>>> initial import of runelite
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nonnull;
<<<<<<< HEAD
import javax.annotation.Nullable;
=======
>>>>>>> initial import of runelite
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.ClanMember;
import net.runelite.api.ClanMemberRank;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.IndexedSprite;
import net.runelite.api.SpriteID;
import net.runelite.api.events.ClanChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.Text;

@Singleton
public class ClanManager
{
	private static final int[] CLANCHAT_IMAGES =
		{
			SpriteID.CLAN_CHAT_RANK_SMILEY_FRIEND,
			SpriteID.CLAN_CHAT_RANK_SINGLE_CHEVRON_RECRUIT,
			SpriteID.CLAN_CHAT_RANK_DOUBLE_CHEVRON_CORPORAL,
			SpriteID.CLAN_CHAT_RANK_TRIPLE_CHEVRON_SERGEANT,
			SpriteID.CLAN_CHAT_RANK_BRONZE_STAR_LIEUTENANT,
			SpriteID.CLAN_CHAT_RANK_SILVER_STAR_CAPTAIN,
			SpriteID.CLAN_CHAT_RANK_GOLD_STAR_GENERAL,
			SpriteID.CLAN_CHAT_RANK_KEY_CHANNEL_OWNER,
			SpriteID.CLAN_CHAT_RANK_CROWN_JAGEX_MODERATOR,
		};
	private static final Dimension CLANCHAT_IMAGE_DIMENSION = new Dimension(11, 11);
	private static final Color CLANCHAT_IMAGE_OUTLINE_COLOR = new Color(33, 33, 33);

	private final Client client;
	private final SpriteManager spriteManager;
	private final BufferedImage[] clanChatImages = new BufferedImage[CLANCHAT_IMAGES.length];

	private final LoadingCache<String, ClanMemberRank> clanRanksCache = CacheBuilder.newBuilder()
		.maximumSize(100)
		.expireAfterWrite(1, TimeUnit.MINUTES)
		.build(new CacheLoader<String, ClanMemberRank>()
		{
			@Override
			public ClanMemberRank load(@Nonnull String key)
			{
				final ClanMember[] clanMembersArr = client.getClanMembers();

				if (clanMembersArr == null || clanMembersArr.length == 0)
				{
					return ClanMemberRank.UNRANKED;
				}

				return Arrays.stream(clanMembersArr)
					.filter(Objects::nonNull)
					.filter(clanMember -> sanitize(clanMember.getUsername()).equals(sanitize(key)))
					.map(ClanMember::getRank)
					.findAny()
					.orElse(ClanMemberRank.UNRANKED);
			}
		});

<<<<<<< HEAD
	private int offset;
=======
	private int modIconsLength;
>>>>>>> initial import of runelite

	@Inject
	private ClanManager(Client client, SpriteManager spriteManager)
	{
		this.client = client;
		this.spriteManager = spriteManager;
	}

	public ClanMemberRank getRank(String playerName)
	{
		return clanRanksCache.getUnchecked(playerName);
	}

<<<<<<< HEAD
	@Nullable
=======
>>>>>>> initial import of runelite
	public BufferedImage getClanImage(final ClanMemberRank clanMemberRank)
	{
		if (clanMemberRank == ClanMemberRank.UNRANKED)
		{
			return null;
		}

		return clanChatImages[clanMemberRank.ordinal() - 1];
	}

	public int getIconNumber(final ClanMemberRank clanMemberRank)
	{
<<<<<<< HEAD
		return offset + clanMemberRank.ordinal() - 1;
=======
		return modIconsLength - CLANCHAT_IMAGES.length + clanMemberRank.ordinal() - 1;
>>>>>>> initial import of runelite
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
<<<<<<< HEAD
		if (gameStateChanged.getGameState() == GameState.LOGIN_SCREEN && offset == 0)
=======
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN
			&& modIconsLength == 0)
>>>>>>> initial import of runelite
		{
			loadClanChatIcons();
		}
	}

	@Subscribe
	public void onClanChanged(ClanChanged clanChanged)
	{
		clanRanksCache.invalidateAll();
	}

	private void loadClanChatIcons()
	{
<<<<<<< HEAD
		{
			IndexedSprite[] modIcons = client.getModIcons();
			offset = modIcons.length;

			IndexedSprite blank = ImageUtil.getImageIndexedSprite(
				new BufferedImage(modIcons[0].getWidth(), modIcons[0].getHeight(), BufferedImage.TYPE_INT_ARGB),
				client);

			modIcons = Arrays.copyOf(modIcons, offset + CLANCHAT_IMAGES.length);
			Arrays.fill(modIcons, offset, modIcons.length, blank);

			client.setModIcons(modIcons);
		}

		for (int i = 0; i < CLANCHAT_IMAGES.length; i++)
		{
			final int fi = i;

			spriteManager.getSpriteAsync(CLANCHAT_IMAGES[i], 0, sprite ->
			{
				IndexedSprite[] modIcons = client.getModIcons();
				clanChatImages[fi] = clanChatImageFromSprite(sprite);
				modIcons[offset + fi] = ImageUtil.getImageIndexedSprite(clanChatImages[fi], client);
			});
		}
=======
		final IndexedSprite[] modIcons = client.getModIcons();
		final IndexedSprite[] newModIcons = Arrays.copyOf(modIcons, modIcons.length + CLANCHAT_IMAGES.length);
		int curPosition = newModIcons.length - CLANCHAT_IMAGES.length;

		for (int i = 0; i < CLANCHAT_IMAGES.length; i++, curPosition++)
		{
			final int resource = CLANCHAT_IMAGES[i];
			clanChatImages[i] = rgbaToIndexedBufferedImage(clanChatImageFromSprite(spriteManager.getSprite(resource, 0)));
			newModIcons[curPosition] = createIndexedSprite(client, clanChatImages[i]);
		}

		client.setModIcons(newModIcons);
		modIconsLength = newModIcons.length;
>>>>>>> initial import of runelite
	}

	private static String sanitize(String lookup)
	{
		final String cleaned = Text.removeTags(lookup);
		return cleaned.replace('\u00A0', ' ');
	}

<<<<<<< HEAD
=======
	private static IndexedSprite createIndexedSprite(final Client client, final BufferedImage bufferedImage)
	{
		final IndexColorModel indexedCM = (IndexColorModel) bufferedImage.getColorModel();

		final int width = bufferedImage.getWidth();
		final int height = bufferedImage.getHeight();
		final byte[] pixels = ((DataBufferByte) bufferedImage.getRaster().getDataBuffer()).getData();
		final int[] palette = new int[indexedCM.getMapSize()];
		indexedCM.getRGBs(palette);

		final IndexedSprite newIndexedSprite = client.createIndexedSprite();
		newIndexedSprite.setPixels(pixels);
		newIndexedSprite.setPalette(palette);
		newIndexedSprite.setWidth(width);
		newIndexedSprite.setHeight(height);
		newIndexedSprite.setOriginalWidth(width);
		newIndexedSprite.setOriginalHeight(height);
		newIndexedSprite.setOffsetX(0);
		newIndexedSprite.setOffsetY(0);
		return newIndexedSprite;
	}

	private static BufferedImage rgbaToIndexedBufferedImage(final BufferedImage sourceBufferedImage)
	{
		final BufferedImage indexedImage = new BufferedImage(
			sourceBufferedImage.getWidth(),
			sourceBufferedImage.getHeight(),
			BufferedImage.TYPE_BYTE_INDEXED);

		final ColorModel cm = indexedImage.getColorModel();
		final IndexColorModel icm = (IndexColorModel) cm;

		final int size = icm.getMapSize();
		final byte[] reds = new byte[size];
		final byte[] greens = new byte[size];
		final byte[] blues = new byte[size];
		icm.getReds(reds);
		icm.getGreens(greens);
		icm.getBlues(blues);

		final WritableRaster raster = indexedImage.getRaster();
		final int pixel = raster.getSample(0, 0, 0);
		final IndexColorModel resultIcm = new IndexColorModel(8, size, reds, greens, blues, pixel);
		final BufferedImage resultIndexedImage = new BufferedImage(resultIcm, raster, sourceBufferedImage.isAlphaPremultiplied(), null);
		resultIndexedImage.getGraphics().drawImage(sourceBufferedImage, 0, 0, null);
		return resultIndexedImage;
	}

>>>>>>> initial import of runelite
	private static BufferedImage clanChatImageFromSprite(final BufferedImage clanSprite)
	{
		final BufferedImage clanChatCanvas = ImageUtil.resizeCanvas(clanSprite, CLANCHAT_IMAGE_DIMENSION.width, CLANCHAT_IMAGE_DIMENSION.height);
		return ImageUtil.outlineImage(clanChatCanvas, CLANCHAT_IMAGE_OUTLINE_COLOR);
	}
}
