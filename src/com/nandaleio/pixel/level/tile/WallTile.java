package com.nandaleio.pixel.level.tile;

import com.nandaleio.pixel.graphics.Screen;
import com.nandaleio.pixel.graphics.Sprite;

public class WallTile extends Tile{

	public WallTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
	
	public boolean solid() {
		return false;
	}

}
