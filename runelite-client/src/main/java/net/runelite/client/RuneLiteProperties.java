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
package net.runelite.client;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.annotation.Nullable;
<<<<<<< HEAD

=======
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Singleton
@Slf4j
>>>>>>> initial import of runelite
public class RuneLiteProperties
{
	private static final String RUNELITE_TITLE = "runelite.title";
	private static final String RUNELITE_VERSION = "runelite.version";
	private static final String RUNESCAPE_VERSION = "runescape.version";
	private static final String DISCORD_APP_ID = "runelite.discord.appid";
	private static final String DISCORD_INVITE = "runelite.discord.invite";
	private static final String GITHUB_LINK = "runelite.github.link";
	private static final String WIKI_LINK = "runelite.wiki.link";
	private static final String PATREON_LINK = "runelite.patreon.link";
	private static final String LAUNCHER_VERSION_PROPERTY = "runelite.launcher.version";
<<<<<<< HEAD
	private static final String TROUBLESHOOTING_LINK = "runelite.wiki.troubleshooting.link";
	private static final String BUILDING_LINK = "runelite.wiki.building.link";
	private static final String DNS_CHANGE_LINK = "runelite.dnschange.link";

	private static final Properties properties = new Properties();

	static
	{
		try (InputStream in = RuneLiteProperties.class.getResourceAsStream("runelite.properties"))
=======

	private final Properties properties = new Properties();

	@Inject
	public RuneLiteProperties()
	{
		try (InputStream in = getClass().getResourceAsStream("runelite.properties"))
>>>>>>> initial import of runelite
		{
			properties.load(in);
		}
		catch (IOException ex)
		{
<<<<<<< HEAD
			throw new RuntimeException(ex);
		}
	}

	public static String getTitle()
=======
			log.warn("unable to load propertries", ex);
		}
	}

	public String getTitle()
>>>>>>> initial import of runelite
	{
		return properties.getProperty(RUNELITE_TITLE);
	}

<<<<<<< HEAD
	public static String getVersion()
=======
	public String getVersion()
>>>>>>> initial import of runelite
	{
		return properties.getProperty(RUNELITE_VERSION);
	}

<<<<<<< HEAD
	public static String getRunescapeVersion()
=======
	public String getRunescapeVersion()
>>>>>>> initial import of runelite
	{
		return properties.getProperty(RUNESCAPE_VERSION);
	}

<<<<<<< HEAD
	public static String getDiscordAppId()
=======
	public String getDiscordAppId()
>>>>>>> initial import of runelite
	{
		return properties.getProperty(DISCORD_APP_ID);
	}

<<<<<<< HEAD
	public static String getDiscordInvite()
=======
	public String getDiscordInvite()
>>>>>>> initial import of runelite
	{
		return properties.getProperty(DISCORD_INVITE);
	}

<<<<<<< HEAD
	public static String getGithubLink()
=======
	public String getGithubLink()
>>>>>>> initial import of runelite
	{
		return properties.getProperty(GITHUB_LINK);
	}

<<<<<<< HEAD
	public static String getWikiLink()
=======
	public String getWikiLink()
>>>>>>> initial import of runelite
	{
		return properties.getProperty(WIKI_LINK);
	}

<<<<<<< HEAD
	public static String getPatreonLink()
=======
	public String getPatreonLink()
>>>>>>> initial import of runelite
	{
		return properties.getProperty(PATREON_LINK);
	}

	@Nullable
	public static String getLauncherVersion()
	{
		return System.getProperty(LAUNCHER_VERSION_PROPERTY);
	}
<<<<<<< HEAD

	public static String getTroubleshootingLink()
	{
		return properties.getProperty(TROUBLESHOOTING_LINK);
	}

	public static String getBuildingLink()
	{
		return properties.getProperty(BUILDING_LINK);
	}

	public static String getDNSChangeLink()
	{
		return properties.getProperty(DNS_CHANGE_LINK);
	}
=======
>>>>>>> initial import of runelite
}