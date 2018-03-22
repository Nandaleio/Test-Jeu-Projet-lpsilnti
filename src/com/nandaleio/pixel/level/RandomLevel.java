package com.nandaleio.pixel.level;

import java.util.Random;

public class RandomLevel extends Level{
	
	private static final Random random = new Random();
	private int rand;

	public RandomLevel(int width, int height) {
		super(width, height);
	}
	
	/*random:
	 * 1 = grass
	 * 2 = grass_top
	 * 3 = ground
	 * 4 = water
	 */

	protected void generateLevel() { //Creation du level
		for(int y = 0 ; y < height ; y++) {
			for(int x = 0 ; x < width ; x++) {
				if(y == 2 ) tilesInt[x+y*width] = 0xffff00ff;
				else if(y > 2 ) {
					tilesInt[x+y*width] = 1;
				}
				else tilesInt[x+y*width] = -1 ;
				tilesInt[5+1*width] = 0xffff00ff;
			}
		}
	}
	
	protected void generateOverlayLevel() {
		for(int y = 0 ; y < height ; y++) {
			for(int x = 0 ; x < width ; x++) {
				if(y == 1)  {
					rand = random.nextInt(10);
					if(rand == 3) overlayTiles[x+y*width] = 5;
					else if(rand == 2) overlayTiles[x+y*width] = 3;
				}
				
				else overlayTiles[x+y*width] = 0;
			}
		}
	}
	
}
