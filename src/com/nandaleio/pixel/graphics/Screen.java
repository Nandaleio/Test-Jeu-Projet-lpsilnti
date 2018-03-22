package com.nandaleio.pixel.graphics;


import com.nandaleio.pixel.level.tile.Tile;

public class Screen {

	public final int MAP_SIZE = 2048;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;
	
	public int[] pixels; 
	public int width, height;
	
	public int xOffset, yOffset;
	
	//public int[] tiles = new int [MAP_SIZE * MAP_SIZE];
	
	
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}
	
	public void clear() {
		for(int y = 0 ; y < height ; y++) {
			for(int x = 0 ; x < width ; x++) {
				pixels[x + y * width] = 0x000000 ;
			}
		}
	}
	
	public void drawnRect(int xp, int yp, int width, int height, boolean fixed) {
		if(fixed) {
			xp -= xOffset;
			yp -= yOffset;
		}
		for(int y = yp ; y < yp+height ; y++) {
			if(xp >= this.width || 	y < 0 || y >= this.height) continue;
			if(xp > 0)pixels[xp + y * this.width] = 0xff0000;
			pixels[xp+width + y * this.width] = 0xff0000;
		}
		for(int x = xp ; x < xp+width ; x++) {
			if(x < 0 || x >=this.width || yp >= this.height) continue;
			if(yp > 0) pixels[x + yp * this.width] = 0xff0000;
			pixels[x + (yp+height) * this.width] = 0xff0000;
		}
	}
	
	public void drawnRect(int xp, int yp, int width, int height, int col, boolean fixed) {
		if(fixed) {
			xp -= xOffset;
			yp -= yOffset;
		}
		for(int y = yp ; y < yp+height ; y++) {
			if(xp >= this.width || 	y < 0 || y >= this.height) continue;
			if(xp > 0)pixels[xp + y * this.width] = col;
			if(yp + height >= this.height) continue;
			pixels[xp+width + y * this.width] = col;
		}
		for(int x = xp ; x < xp+width ; x++) {
			if(x < 0 || x >=this.width || yp >= this.height) continue;
			if(yp > 0) pixels[x + yp * this.width] = col;
			if(xp + width >= this.width) continue;
			pixels[x + (yp+height) * this.width] = col;
		}
	}
	
	public void renderBackground(int color) {
		for(int y = 0 ; y < height ; y++) {
			for(int x = 0 ; x < width ; x++) {
				pixels[x + y * width] = color;
			}
			
		}
	}
	
	public void renderMob(int xp, int yp, Sprite sprite, boolean flip) {
		xp -= xOffset;
		yp -= yOffset;
		for(int y = 0 ; y < sprite.SIZE ; y++) {
			int ya = y + yp;
			
			for(int x = 0 ; x < sprite.SIZE  ; x++) {
			int xa = x + xp;
			
			int xs = (sprite.SIZE-1)-x;
			
				if(xa < -sprite.SIZE || xa >= width ||ya <0|| ya >= height) break;
				if (xa < 0) xa = 0;
				int col;
				if(flip) col = sprite.pixels[xs+y*sprite.SIZE];
				else col = sprite.pixels[x+y*sprite.SIZE];
				if(col != 0xffff00ff) pixels[xa+ya*width] = col;
			}
		}
	}
	public void renderOverlayTile(int xp, int yp, Tile tile) {
		xp -= xOffset;
		yp -= yOffset;
		for(int y = 0 ; y < tile.sprite.SIZE ; y++) {
			int ya = y + yp;
			for(int x = 0 ; x < tile.sprite.SIZE ; x++) {
				int col;
			int xa = x + xp;
				if(xa < -tile.sprite.SIZE || xa >= width ||ya <0|| ya >= height) break;
				if (xa < 0) xa = 0;
				col = tile.sprite.pixels[x+y*tile.sprite.SIZE];
				if(col == 0xffff00ff) continue;
				else pixels[xa + ya * width] = col	;
			}
		}
			
	}
	
	public void renderSprite(int xp, int yp, Sprite sprite, boolean fixed) {
		if(fixed) {
			xp -= xOffset;
			yp -= yOffset;
		}
		for(int y = 0 ; y < sprite.getHeight() ; y++) {
			int ya = y + yp;
			for(int x = 0 ; x < sprite.getWidth() ; x++) {
				int xa = x + xp;
				if(xa < 0 || xa >= width || ya < 0 || ya >= height) continue;
				if(sprite.pixels[x+y*sprite.getWidth()] == 0xffff00ff) continue;
				pixels[xa+ya*width] = sprite.pixels[x+y*sprite.getWidth()];
			}
		}
	}
	
	public void renderSprite(int xp, int yp, Sprite sprite, boolean fixed , int color) {
		if(fixed) {
			xp -= xOffset;
			yp -= yOffset;
		}
		for(int y = 0 ; y < sprite.getHeight() ; y++) {
			int ya = y + yp;
			for(int x = 0 ; x < sprite.getWidth() ; x++) {
				int xa = x + xp;
				if(xa < 0 || xa >= width || ya < 0 || ya >= height) continue;
				if(sprite.pixels[x+y*sprite.getWidth()] == 0xffff00ff) continue;
				else pixels[xa+ya*width] = color;
			}
		}
	}
	
	public void renderSpriteSheet(int xp, int yp, SpriteSheet sheet, boolean fixed) {
		if(fixed) {
			xp -= xOffset;
			yp -= yOffset;
		}
		for(int y = 0 ; y < sheet.sprite_Height ; y++) {
			int ya = y + yp;
			for(int x = 0 ; x < sheet.sprite_Width ; x++) {
				int xa = x + xp;
				if(xa < 0 || xa >= width || ya < 0 || ya >= height) continue;
				if(sheet.pixels[x+y*sheet.sprite_Width] != 0xffff00ff)
				pixels[xa+ya*width] = sheet.pixels[x+y*sheet.sprite_Width];
			}
		}
	}

	
	public void renderTile(int xp, int yp, Tile tile) {
		xp -= xOffset;
		yp -= yOffset;
		for(int y = 0 ; y < tile.sprite.SIZE ; y++) {
			int ya = y + yp;
			for(int x = 0 ; x < tile.sprite.SIZE ; x++) {
				int col;
			int xa = x + xp;
				if(xa < -tile.sprite.SIZE || xa >= width ||ya <0|| ya >= height) break;
				if (xa < 0) xa = 0;
				col = tile.sprite.pixels[x+y*tile.sprite.SIZE];
				if(col != 0xffff00ff) pixels[xa + ya * width] = col;
				else  continue;
			}
		}
			
	}
	
	public void rendergrid(int size) {
		for(int y = 0 ; y < height ; y++) {
			for(int x = 0 ; x < width ; x++) {
				if(x%size ==0 || y%size == 0) pixels[x+y*width] = 0xffffff;
			}
		}
	}
	
	public void setOffset(int xoff, int yoff) {
		this.xOffset = xoff;
		this.yOffset = yoff;
	}

	
}
