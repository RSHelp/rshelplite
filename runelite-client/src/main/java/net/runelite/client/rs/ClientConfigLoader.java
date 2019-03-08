/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.rs;

<<<<<<< HEAD
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import net.runelite.http.api.RuneLiteAPI;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

class ClientConfigLoader
{
	private ClientConfigLoader()
	{
	}

	private static final String CONFIG_URL = "http://oldschool.runescape.com/jav_config.ws";

	static RSConfig fetch(String host) throws IOException
	{
		HttpUrl url = HttpUrl.parse(CONFIG_URL);
		if (host != null)
		{
			url = url.newBuilder().host(host).build();
		}

		final Request request = new Request.Builder()
			.url(url)
=======
import com.google.common.annotations.VisibleForTesting;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.inject.Inject;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Singleton
class ClientConfigLoader
{
	private static final String CONFIG_URL = "http://oldschool.runescape.com/jav_config.ws";
	private final OkHttpClient httpClient;

	@Inject
	@VisibleForTesting
	ClientConfigLoader(final OkHttpClient httpClient)
	{
		this.httpClient = httpClient;
	}

	RSConfig fetch() throws IOException
	{
		final Request request = new Request.Builder()
			.url(CONFIG_URL)
>>>>>>> initial import of runelite
			.build();

		final RSConfig config = new RSConfig();

<<<<<<< HEAD
		try (final Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
		{
			if (!response.isSuccessful())
			{
				throw new IOException("Unsuccessful response: " + response.message());
			}

			String str;
			final BufferedReader in = new BufferedReader(new InputStreamReader(response.body().byteStream()));
=======
		try (final Response response = httpClient.newCall(request).execute(); final BufferedReader in = new BufferedReader(
			new InputStreamReader(response.body().byteStream())))
		{
			String str;

>>>>>>> initial import of runelite
			while ((str = in.readLine()) != null)
			{
				int idx = str.indexOf('=');

				if (idx == -1)
				{
					continue;
				}

				String s = str.substring(0, idx);

				switch (s)
				{
					case "param":
						str = str.substring(idx + 1);
						idx = str.indexOf('=');
						s = str.substring(0, idx);

						config.getAppletProperties().put(s, str.substring(idx + 1));
						break;
					case "msg":
						// ignore
						break;
					default:
						config.getClassLoaderProperties().put(s, str.substring(idx + 1));
						break;
				}
			}
		}

		return config;
	}
}
