package com.nandaleio.pixel.entity.mob;

import java.util.Random;

import com.nandaleio.pixel.graphics.AnimatedSprite;
import com.nandaleio.pixel.graphics.Screen;
import com.nandaleio.pixel.graphics.Sprite;
import com.nandaleio.pixel.graphics.SpriteSheet;

public class Dummy extends Mob{

	
	
	
	protected AnimatedSprite walk;
	
	public Dummy(int x, int y) {
		this.x = x << 4;
		this.y = y << 4;
		walk = new AnimatedSprite(SpriteSheet.mob_walk,16,16,2);
		sprite = Sprite.mob1;
		walk.setFrameRate(10);
	}

	public void render (Screen screen) {
		screen.renderMob(x-8, y-1, sprite, flip);
	}
	
	public void update() {
		if(!canBeHit) {
			recovery++;
		}
		if(recovery % 180 == 0) {
			canBeHit = true;
			recovery = 0;
		}
		walk.update();
		time++;
		Random rand = new Random();
		if(time % (rand.nextInt(50) + 30) == 0) {
			xa = rand.nextInt(3) - 1;
		}
		if(xa < 0) {
			flip = true;
		}
		if(xa > 0) {
			flip = false;
		}
		if (xa != 0) sprite = walk.getSprite();
		if(collision(xa, 0)) jump(7);
		if(collision(0,ya)) canjump = true;
		move();
		fall(1);
	}
	
}
