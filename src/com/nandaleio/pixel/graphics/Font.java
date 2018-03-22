package com.nandaleio.pixel.graphics;

public class Font {
	
	private static SpriteSheet font = new SpriteSheet("/font3.png", 8);
	
	
	//todo extract sprite from sheet
	private static Sprite[] characters = Sprite.split(font);
	private static String charIndex = "ABCDEFGHIJKLM" + //
										"NOPQRSTUVWXYZ" + //
										"abcdefghijklm" + //
										"nopqrstuvwxyz" + //
										"1234567890.,'" + //
										":";
	
	
	
	public Font() {
		
	}
	
	public void render(int x, int y , int spacing, String text, Screen screen ,int color) {
		int xOffset = 0;
		int line = 0;
		for(int i = 0 ; i < text.length() ; i++) {
			xOffset += 16 + spacing;
			int yOffset = 0;
			char currentChar = text.charAt(i);
			if(currentChar == 'g' || currentChar == 'y' || currentChar == 'p' || currentChar == 'j' || currentChar == 'q' || currentChar == ',') yOffset = 4;
			if(currentChar == '\n') {
				xOffset = 0;
				line++;
			}
			int index = charIndex.indexOf(currentChar);
			if(index == -1) continue;
			screen.renderSprite(x + xOffset, y +line * 20+ yOffset, characters[index], false, color);
		}
	}
	
	public void render(int x, int y , String text, Screen screen) {
		render(x,y,0,text,screen,0);
	}
}
