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
 * Represents an paletted sprite.
=======
 * Represents an indexed sprite.
>>>>>>> initial import of runelite
 */
public interface IndexedSprite
{
	/**
<<<<<<< HEAD
	 * The bitmap of this sprite. Each value is an index into {@link #getPalette()}.
	 * 0 is transparent
	 */
	byte[] getPixels();
	void setPixels(byte[] pixels);

	/**
	 * The color palette in RGB. The zero index is unused.
	 */
	int[] getPalette();
	void setPalette(int[] palette);

	int getOffsetX();
	void setOffsetX(int offsetX);

	int getOffsetY();
	void setOffsetY(int offsetY);

	int getWidth();
	void setWidth(int width);


	int getHeight();
	void setHeight(int height);
	
	int getOriginalWidth();
	void setOriginalWidth(int originalWidth);

	int getOriginalHeight();
=======
	 * Gets the pixels contained by the sprite.
	 *
	 * @return the sprite pixels
	 */
	byte[] getPixels();

	/**
	 * Sets the pixels contained by the sprite.
	 *
	 * @param pixels the new sprite pixels
	 */
	void setPixels(byte[] pixels);

	/**
	 * Gets the color palette for the sprites pixels.
	 *
	 * @return the color palette
	 */
	int[] getPalette();

	/**
	 * Sets the color palette for the sprites pixels.
	 *
	 * @param palette the new color palette
	 */
	void setPalette(int[] palette);

	/**
	 * Gets the offset of the sprite along the x-axis.
	 *
	 * @return the x-axis offset
	 */
	int getOffsetX();

	/**
	 * Sets the offset of the sprite along the x-axis.
	 *
	 * @param offsetX new x-axis offset
	 */
	void setOffsetX(int offsetX);

	/**
	 * Gets the offset of the sprite along the y-axis.
	 *
	 * @return the y-axis offset
	 */
	int getOffsetY();

	/**
	 * Sets the offset of the sprite along the y-axis.
	 *
	 * @param offsetY new y-axis offset
	 */
	void setOffsetY(int offsetY);

	/**
	 * Gets the width of the sprite.
	 *
	 * @return the width
	 */
	int getWidth();

	/**
	 * Sets the width of the sprite.
	 *
	 * @param width the new width
	 */
	void setWidth(int width);

	/**
	 * Gets the original width of the sprite.
	 *
	 * @return the width
	 */
	int getOriginalWidth();

	/**
	 * Sets the original width of the sprite.
	 *
	 * @param originalWidth the width
	 */
	void setOriginalWidth(int originalWidth);

	/**
	 * Gets the height of the sprite.
	 *
	 * @return the height
	 */
	int getHeight();

	/**
	 * Sets the height of the sprite.
	 *
	 * @param height the height
	 */
	void setHeight(int height);

	/**
	 * Gets the original height of the sprite.
	 *
	 * @return the height
	 */
	int getOriginalHeight();

	/**
	 * Sets the original height of the sprite.
	 *
	 * @param originalHeight the height
	 */
>>>>>>> initial import of runelite
	void setOriginalHeight(int originalHeight);
}
