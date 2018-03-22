package com.nandaleio.pixel.entity.Particles;

import java.util.Random;

import com.nandaleio.pixel.entity.Entity;
import com.nandaleio.pixel.graphics.Screen;
import com.nandaleio.pixel.graphics.Sprite;

public class Particle extends Entity{
	private int life;
	
	public Sprite sprite;
	private int time = 0;
	
	protected double xa , ya ,za;
	protected double xx , yy ,zz;
	
	
	public Particle(double x, double y, int life) {
		this.x = (int)x;
		this.y = (int)y;
		this.xx = x;
		this.yy = y;
		
		this.life = life;
		this.life += random.nextInt(20);
		
		Random rand = new Random();
		if(rand.nextBoolean()) sprite = Sprite.particle_normal1;
		else sprite = Sprite.particle_normal2;
		
		this.xa = random.nextGaussian();
		this.ya = random.nextGaussian();
		
		this.zz = random.nextFloat();
	}
	
	public Particle(int x, int y, int life) {
		this.x = x;
		this.y = y;
		this.xx = x;
		this.yy = y;
		
		this.life = life;
		this.life += random.nextInt(20);
		
		Random rand = new Random();
		if(rand.nextBoolean()) sprite = Sprite.particle_normal1;
		else sprite = Sprite.particle_normal2;
		
		this.xa = random.nextGaussian();
		this.ya = random.nextGaussian();
		
		this.zz = random.nextFloat();
	}
	
	public boolean collision(double x, double y) {
		boolean solid = false;
		for(int c = 0 ; c < 4 ; c++) {
			double xt = (x - c % 2 * 15 - 1) /16;
			double yt = (y - c / 2 * 13) /16;
			int ix = (int) Math.ceil(xt);
			int iy = (int) Math.ceil(yt);
			if(c % 2 == 0 ) ix = (int) Math.floor(xt);
			if(c / 2 == 0 ) iy = (int) Math.floor(yt);
			if(level.getTile(ix, iy).solid()) solid = true;
			else solid = false;
		}
		return solid;
	}
	
	
	
	private void fall() {
		yy++;
	}
	
	
	private void move(double x, double y) {
		if(collision(x,y)) {
			this.xa *= -0.5;
			this.ya *= -0.5;
			this.za *= -0.5;
		}
		else {
			this.xx += xa;
			this.yy += ya;
			this.zz += za;
			fall();
		}
	}
	
	public void render(Screen screen) {
		screen.renderSprite((int)xx, (int)yy - (int)zz, sprite, true);
	}

	public void update() {
		time++;
		if(time >= Integer.MAX_VALUE - 1) life = 0;
		if(time >= life) remove();
		
		za -= 0.1;
		
		if(zz < 0) {
			zz = 0;
			za *= -0.8;
			xa *= 0.5;
			ya *= 0.6 ;
		}
		
		move(xx+xa , (yy + ya) + (zz + za));
		
		
	}

}
