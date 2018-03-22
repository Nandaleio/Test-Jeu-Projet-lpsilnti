package com.nandaleio.pixel.graphics;

public class AnimatedSprite extends Sprite{

	
	public static AnimatedSprite sniper_die = new AnimatedSprite(SpriteSheet.sniper_die, 16, 16, 5);
	public static AnimatedSprite sniper_fire = new AnimatedSprite(SpriteSheet.sniper_fire, 48, 48, 5);
	public static AnimatedSprite sniper_idle = new AnimatedSprite(SpriteSheet.sniper_idle, 16, 16, 2);
	public static AnimatedSprite sniper_reload = new AnimatedSprite(SpriteSheet.sniper_reload, 16, 16, 9);
	public static AnimatedSprite sniper_roll = new AnimatedSprite(SpriteSheet.sniper_roll, 16, 16, 9);
	
	public static AnimatedSprite sniper_walk = new AnimatedSprite(SpriteSheet.sniper_walk, 16, 16, 8); 
	private int frame = 0; 
	private int length = 0; 
	private int rate = 5; 
	private Sprite sprite; 
	private int time = 1; 
	
	public AnimatedSprite(SpriteSheet sheet, int width, int height, int animationSize) {
		super(sheet, width, height);
		this.length = animationSize;
		if(length > sheet.getSprite().length) System.out.println("Erreur : animation trop long a ce qu'attendu");
		this.sprite = sheet.getSprite()[0];
		
	}
	
	public int getLenght() {
		return length;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public Sprite getSprite(int i) {
		return sheet.getSprite()[i];
	}
	
	public void setFrameRate(int rate) {
		this.rate = rate;
	}
	
	public void setSprite(int i) {
		this.sprite = sheet.getSprite()[i];
	}
	
	public void setTime(int t) {
		time = t;
	}

	public void update() {
		
		time++;
		if(time % rate == 0) {
			if(frame >= length-1) frame = 0;
			else frame++;
			this.sprite = sheet.getSprite()[frame];
		}
	}


}
