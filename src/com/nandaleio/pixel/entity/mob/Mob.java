package com.nandaleio.pixel.entity.mob;

import java.util.ArrayList;
import java.util.List;

import com.nandaleio.pixel.entity.Entity;
import com.nandaleio.pixel.entity.Projectile;
import com.nandaleio.pixel.entity.Particles.BloodPaticle;
import com.nandaleio.pixel.entity.Particles.GrassParticle;
import com.nandaleio.pixel.entity.Particles.Particle;
import com.nandaleio.pixel.graphics.Screen;
import com.nandaleio.pixel.graphics.Sprite;
import com.nandaleio.pixel.level.tile.Tile;

public abstract class Mob extends Entity{
	
	protected boolean canBeHit = true;
	
	protected boolean canjump = false;
	
	protected boolean flip = false;
	protected int life = 100;
	protected int maxY = 10;
	protected boolean onGround = false;
	protected List<Projectile> projectiles = new ArrayList<Projectile>();
	
	protected int recovery = 0;
	protected Sprite sprite;
	protected int time = 0 ;
	protected int xa = 0, ya = 0;
	
	private int abs(double value) {
		if(value < 0) return -1;
		return 1;
	}
	
	public void bleed(int damage) {
		if(canBeHit && !removed) {
			for(int i = 0 ; i < 5 ; i++) {
				Particle p = new BloodPaticle(x,y,100);
				p.init(level);
				level.add(p);
			}
			life -= damage;
			canBeHit = false;
		}
		if(life <= 0) {
			die();
			life = 0;
		}
	}
	
	protected boolean collision(double xa, double ya) {
		boolean solid = false;
		for(int c = 0 ; c < 4 ; c++) {
								   //SIZE + DECALLAGE
			double xt = ((x+xa) - c % 2 * 16) /16 ;
			double yt = ((y+ya) - c / 2 * 16 + 14) /16 ;
			int ix = (int) Math.ceil(xt);
			int iy = (int) Math.ceil(yt);
			if(c % 2 == 0 ) ix = (int) Math.floor(xt);
			if(c / 2 == 0 ) iy = (int) Math.floor(yt);
			if(level.getTile(ix, iy).solid()) solid = true;
		}
		return solid;
	}
	
	public void die() {
		removed = true;
		for(int i = 0 ; i < 20 ; i++) {
			Particle p = new BloodPaticle((int)x,(int)y,50);
			p.init(level);
			level.add(p);
		}
	}
	
	protected void fall(int gravity) {
		if(level.getTile(x, y) != Tile.echelle_middle)
		ya += gravity;
		if(ya >= maxY) ya = maxY;
	}
	
	public int getLife() {
		return life;
	}

	public Sprite getSprite() {
		return sprite;
	}
		
	public int getXa() {
		return xa;
	}
	
	
	protected void jump(int jumpheight) {
		if(canjump) {
			ya -= jumpheight;
			canjump = false;
			for(int i = 0 ; i < 10 ; i ++) {
				Particle p = new GrassParticle(x,y,50);
				p.init(level);
				level.add(p);
			}
		}
		
	}
	
	public void move() {
		for(int y = 0 ; y < Math.abs(ya) ; y++) {
			if(!collision(0, abs(ya))) {
				this.y += abs(ya);
				onGround = false;
			}
			else {
				onGround = true;
				ya = 0;
			}
		}
		
		for(int x = 0 ; x < Math.abs(xa) ; x++) {
			if(!collision(abs(xa), 0)) {
				this.x += abs(xa);
			}
			
		}
	}

	protected void recovery() {
		if(!canBeHit) {
			recovery++;
		}
		if(recovery % 100 == 0) {
			canBeHit = true;
			recovery = 0;
		}
	}
	
	public void render(Screen screen) {
		screen.renderMob(x-8, y, sprite, flip);
	}

	
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	protected void shoot(int x, int y, double dir) {
		Projectile p = new Projectile(x,y, dir);
		p.init(level);
		projectiles.add(p);
		level.add(p);
	}
	
	public void update() {
		recovery();
		if(xa < 0) flip = true;
		if(xa > 0) flip = false;
		move();
		fall(1);
	}
	
}
