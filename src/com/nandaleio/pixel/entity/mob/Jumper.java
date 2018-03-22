package com.nandaleio.pixel.entity.mob;

public class Jumper extends Chasseur {

	public Jumper(int x, int y) {
		super(x, y);
	}
	
	public void update() {
		walk.update();
		time++;
		
		
		if(xa < 0) flip = true;
		if(xa > 0) flip = false;
		if (xa != 0) sprite = walk.getSprite();
		if(collision(xa, 0)) {
			//jump(7);
		}
		if(collision(0,ya)) {
			canjump = true;
		}
		jump(16);
		hit();
		move();
		fall(1);
	}

}
