package com.nandaleio.pixel.entity.mob;


import java.util.List;
import java.util.Random;

import com.nandaleio.pixel.graphics.Screen;
import com.nandaleio.pixel.graphics.Sprite;
import com.nandaleio.pixel.utils.Debug;

public class Chasseur extends Dummy{
	

	public Chasseur(int x, int y) {
		super(x, y);
		sprite = Sprite.mob2;
	}

	protected void hit() {
		for(int i = 0 ; i < level.getPlayers().size() ; i++) {
			Player p = level.getPlayers().get(i);
			if(x < p.getX() + p.getSprite().getWidth()) {
				if(p.getX() < x + sprite.getWidth()) {
					if(y < p.getY() + p.getSprite().getHeight()) {
						if(p.getY() < y + sprite.getHeight()) {
							level.getPlayers().get(i).bleed(50);
							break;
						}
					}
				}
			}
		}
	}
	
	public void move() {
		time++;
		List<Player> players = level.getPlayers(this, 175);
		if(players.size() > 0) {
			Player player = players.get(0);
			if(!player.isDead()) {
				if(x < player.getX()) xa = 1;
				else if(x > player.getX()) xa = -1;
				else xa = 0;
			}
		}
		else {
			Random rand = new Random();
			if(time % (rand.nextInt(50) + 30) == 0) {
				xa = rand.nextInt(3) - 1;
			}
		}
			if(!collision(xa, 0)) x += xa;
			if(!collision(0, ya)) {
				y += ya;
				onGround = false;
			}
			else {
				onGround = true;
				ya = 0;
			}
	}
	
	public void render (Screen screen) {
		Debug.drawnRect(screen, 7*16, 50*16, 100, 100, false);
		screen.renderMob(x-8, y-1, sprite, flip);
	}
	
	public void update() {
		walk.update();
		if(!canBeHit) {
			recovery++;
		}
		if(recovery % 50 == 0) {
			canBeHit = true;
			recovery = 0;
		}
		
		if(xa < 0) flip = true;
		if(xa > 0) flip = false;
		if (xa != 0) sprite = walk.getSprite();
		if(collision(xa, 0)) {
			jump(7);
		}
		if(collision(0,ya)) {
			canjump = true;
		}
		hit();
		move();
		fall(1);
	}
	
	/*private double calculeDistance() {
		double dist = 0;
		dist = Math.sqrt(Math.abs(x * player.x) + (y * player.y));
		return dist;
		
	}*/

}
