package com.nandaleio.pixel.entity;

import com.nandaleio.pixel.entity.Particles.Particle;
import com.nandaleio.pixel.entity.mob.Mob;
import com.nandaleio.pixel.entity.mob.Player;
import com.nandaleio.pixel.graphics.Screen;
import com.nandaleio.pixel.graphics.Sprite;

public class Projectile extends Entity {

	protected double angle;
	protected boolean hitOnce = false;
	protected double nx, ny;
	protected double speed, rateOfFire, range, damage;
	protected Sprite sprite;
	protected double x, y ;
	
	protected final int xOrigine, yOrigine;
	
	public Projectile(int x,int y, double dir) {
		 xOrigine = x;
		 yOrigine = y;
		 angle = dir;
		 speed = 40;
		 range = 500;
		 this.x = x;
		 this.y = y;
		 
		 nx = speed * Math.cos(angle);
		 ny = speed * Math.sin(angle);
		 
		 sprite = Sprite.particle_normal2;
		 
	}
		
	private int abs(double value) {
		if(value < 0) return -1;
		return 1;
	}
	
	private double calculeDistance() {
		double dist = 0;
		dist = Math.sqrt(Math.abs((xOrigine - x) * (xOrigine - x) + (yOrigine - y) * (yOrigine - y)));
		return dist;
		
	}
	
	protected boolean collision(double xa, double ya) {
		boolean solid = false;
		for(int c = 0 ; c < 4 ; c++) {
								   //SIZE + DECALLAGE
			double xt = ((x+xa) - c % 2 * 16) /16 ;
			double yt = ((y+ya) - c / 2 * 16) /16 ;
			int ix = (int) Math.ceil(xt);
			int iy = (int) Math.ceil(yt);
			if(c % 2 == 0 ) ix = (int) Math.floor(xt);
			if(c / 2 == 0 ) iy = (int) Math.floor(yt);
			if(level.getTile(ix, iy).solid()) solid = true;
		}
		return solid;
	}
	
	private void hit() {
		if(!hitOnce) {
			for(int i = 0 ; i < level.getMob().size() ; i++) {
				Mob m = level.getMob().get(i);
				if(x < m.getX() + m.getSprite().getWidth()) {
					if(m.getX() < x + sprite.getWidth()) {
						if(y < m.getY() + m.getSprite().getHeight()) {
							if(m.getY() < y + sprite.getHeight()) {
								hitOnce = false;
								remove();
								level.getMob().get(i).bleed(9999999);
								break;
								
							}
						}
					}
				}
			}
			
			for(int i = 0 ; i < level.getPlayers().size() ; i++) {
				Player p = level.getPlayerAt(i);
				if(x < p.getX() + p.getSprite().getWidth()) {
					if(p.getX() < x + sprite.getWidth()) {
						if(y < p.getY() + p.getSprite().getHeight()) {
							if(p.getY() < y + sprite.getHeight()) {
								hitOnce = false;
								remove();
								level.getPlayers().get(i).bleed(10);
								break;
							}
						}
					}
				}
			}
		}
	}
	
	
	protected void move() {
		for(int m = 0 ; m < Math.abs(ny) ; m++) {
			if(!collision(0, abs(ny))) {
				this.x += abs(ny);
				hit();
			}
			else {
				remove();
			}
		}
		
		for(int j = 0 ; j < Math.abs(nx) ; j++) {
			if(!collision(abs(nx), 0)) {
				this.x += abs(nx);
				hit();
			}
			else{
				Particle p = new Particle((int)x,(int)y,50);
				p.init(level);
				level.add(p);
				remove();
				
			}
		}
		
		if(calculeDistance() > range) remove();
		}
	
	public void render(Screen screen) {
		screen.renderSprite((int)x, (int)y, sprite, true);
	}

	public void update() {
		move();
	}
	
}
