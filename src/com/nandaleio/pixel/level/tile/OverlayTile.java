package com.nandaleio.pixel.level.tile;

import com.nandaleio.pixel.graphics.Screen;
import com.nandaleio.pixel.graphics.Sprite;

public class OverlayTile extends Tile{

	public static OverlayTile fleur1 = new OverlayTile(Sprite.fleur1);
	
		public static OverlayTile fleur2 = new OverlayTile(Sprite.fleur2);
		public static OverlayTile fleur3 = new OverlayTile(Sprite.fleur3);
		//vegetation
		public static OverlayTile herbe1 = new OverlayTile(Sprite.herbe1);
		public static OverlayTile herbe2 = new OverlayTile(Sprite.herbe2);
		public static OverlayTile overvoid = new OverlayTile(Sprite.overvoid);
		//Overlay
		public static OverlayTile pierre1 = new OverlayTile(Sprite.pierre1);
		public static OverlayTile pierre2 = new OverlayTile(Sprite.pierre2);
	
	public OverlayTile(Sprite sprite) {
		super(sprite);
		overlay = true;
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderOverlayTile(x << 4, y << 4, this);
	}
	
	public boolean solid() {
		return false;
	}

}
