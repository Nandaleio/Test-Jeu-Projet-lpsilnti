package com.nandaleio.pixel.level.tile;

import com.nandaleio.pixel.graphics.Screen;
import com.nandaleio.pixel.graphics.Sprite;

public class Tile {
	public static Tile caisse = new GrassTile(Sprite.caisse);
	public static Tile echelle_bottom = new WallTile(Sprite.echelle_bottom);
	public static Tile echelle_middle = new WallTile(Sprite.echelle_middle);
	
	//Special
	public static Tile echelle_top = new WallTile(Sprite.echelle_top);
	
	public static Tile GDW = new GrassTile(Sprite.GDW);
	public static Tile GG = new GrassTile(Sprite.GG);
	public static Tile GNH1 = new GrassTile(Sprite.GNH1);
	public static Tile GNH2 = new GrassTile(Sprite.GNH2);
	public static Tile GNH3 = new GrassTile(Sprite.GNH3);
	public static Tile GS = new GrassTile(Sprite.GS);
	//grass
	public static Tile GTG = new GrassTile(Sprite.GTG);
	public static Tile GW = new GrassTile(Sprite.GW);
	public static Tile GWD = new GrassTile(Sprite.GWD);
	public static Tile GWG = new GrassTile(Sprite.GWG);
	//Classic orange
	public static Tile O1 = new GrassTile(Sprite.O1);
	public static Tile O2 = new GrassTile(Sprite.O2);
	public static Tile O3 = new GrassTile(Sprite.O3);
	public static Tile OB = new GrassTile(Sprite.OB);
		
	public static Tile ODW = new GrassTile(Sprite.ODW);
	public static Tile ONH1 = new GrassTile(Sprite.ONH1);
	public static Tile ONH2 = new GrassTile(Sprite.ONH2);
	public static Tile ONH3 = new GrassTile(Sprite.ONH3);
	public static Tile OS = new GrassTile(Sprite.OS);
	public static Tile OTD = new GrassTile(Sprite.OTD);
	public static Tile OTG = new GrassTile(Sprite.OTG);
	public static Tile OW = new GrassTile(Sprite.OW);
	public static Tile OWD = new GrassTile(Sprite.OWD);
	public static Tile OWG = new GrassTile(Sprite.OWG);
	public static Tile tree = new WallTile(Sprite.tree);
	//Classic gris
	public static Tile V1 = new GrassTile(Sprite.V1);
	public static Tile V2 = new GrassTile(Sprite.V2);
	public static Tile V3 = new GrassTile(Sprite.V3);
	
	public static Tile VB = new GrassTile(Sprite.VB);
	public static Tile VDW = new GrassTile(Sprite.VDW);
	public static Tile VNH1 = new GrassTile(Sprite.VNH1);
	public static Tile VNH2 = new GrassTile(Sprite.VNH2);
	public static Tile VNH3 = new GrassTile(Sprite.VNH3);
	//VOID
	public static Tile voidtile = new VoidTile(Sprite.voidsprite);
	public static Tile VS = new GrassTile(Sprite.VS);
	public static Tile VTD = new GrassTile(Sprite.VTD);
	public static Tile VTG = new GrassTile(Sprite.VTG);
	public static Tile VW = new GrassTile(Sprite.VW);
	
	public static Tile VWD = new GrassTile(Sprite.VWD);
	public static Tile VWG = new GrassTile(Sprite.VWG);
	
	//Wall
	public static Tile wall = new WallTile(Sprite.wall);
	public static Tile wall01 = new WallTile(Sprite.wall01);
	public boolean overlay = false;
	public Sprite sprite;
	
	public int x, y;
	
	
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void changeSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen) {
		
	}
	
	public boolean solid() {
		return false;
	}

}
