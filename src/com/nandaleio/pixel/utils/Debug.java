package com.nandaleio.pixel.utils;

import com.nandaleio.pixel.graphics.Screen;

public class Debug {

	public static void drawnRect(Screen screen, int x, int y, int width,int height,  boolean fixed) {
		screen.drawnRect(x,y,width,height,fixed);
	}
	
	public static void drawnRect(Screen screen, int x, int y, int width,int height, int col,  boolean fixed) {
		screen.drawnRect(x,y,width,height,col,fixed);
	}
	private Debug() {
		
	}
	
}
