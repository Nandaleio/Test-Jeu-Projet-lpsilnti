package com.nandaleio.pixel.entity;

import java.util.Random;

import com.nandaleio.pixel.graphics.Screen;
import com.nandaleio.pixel.level.Level;

public abstract class Entity {
	
	protected Level level;
	protected final Random random = new Random();
	protected boolean removed = false;
	protected int x, y;
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	
	public void init(Level level) {
		this.level = level;
	}
	
	public boolean isRemoved() {
		return removed;
	}
	
	protected void remove() {
		removed = true;
	}

	public void render(Screen screen) {
		
	}

	public void update() {
	}
}
