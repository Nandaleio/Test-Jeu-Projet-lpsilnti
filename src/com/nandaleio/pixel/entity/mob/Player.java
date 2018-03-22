package com.nandaleio.pixel.entity.mob;

import com.nandaleio.pixel.entity.Particles.BloodPaticle;
import com.nandaleio.pixel.entity.Particles.LightParticle;
import com.nandaleio.pixel.entity.Particles.Particle;
import com.nandaleio.pixel.graphics.AnimatedSprite;
import com.nandaleio.pixel.graphics.Screen;
import com.nandaleio.pixel.graphics.Sprite;
import com.nandaleio.pixel.input.Keyboard;

public class Player extends Mob{
	
	private AnimatedSprite animSprite = AnimatedSprite.sniper_walk;
	private boolean canMove = true;
	
	private boolean dead = false;
	private boolean die = false;
	private int fireRate = 120;
	private boolean flip;
	
	private Keyboard input;
	private boolean reloading = false;
	
	private int renderXOffset = 8;
	
	private int renderYOffset = 1;
	
	private boolean roll = false;
	private boolean shoot = false;
	
	
	
	public Player(int x,int y) {
		this.x = x << 4;
		this.y = y << 4;
		
		sprite = Sprite.sniper_idle;
	}
	
	public Player(int x,int y, Keyboard input) {
		this.x = x << 4;
		this.y = y << 4;
		this.input = input;
		
		sprite = Sprite.sniper_idle;
	}
	
	private void changeSprite() {
		renderYOffset = 1;
		renderXOffset = 8;
		if(die) {
			dead = true;
			animSprite.setFrameRate(5);
			setAnimSprite(AnimatedSprite.sniper_die);
			sprite = animSprite.getSprite();
			if(sprite.equals(AnimatedSprite.sniper_die.getSprite(AnimatedSprite.sniper_die.getLenght() - 1))) {
				sprite = Sprite.sniper_dead;
				
				die = false;
			}
		}
		else if(roll && !dead) {
			canMove = true;
			animSprite.setFrameRate(5);
			setAnimSprite(AnimatedSprite.sniper_roll);
			sprite = animSprite.getSprite();
			if(sprite.equals(AnimatedSprite.sniper_roll.getSprite(AnimatedSprite.sniper_roll.getLenght() - 1))) {
				roll = false;
			}
		}
		else if(shoot && !dead) {
			
			animSprite.setFrameRate(3);
			setAnimSprite(AnimatedSprite.sniper_fire);
			sprite = animSprite.getSprite();
			if(sprite.equals(AnimatedSprite.sniper_fire.getSprite(AnimatedSprite.sniper_fire.getLenght() - 1))) {
				reloading = true;
				shoot = false;
				AnimatedSprite.sniper_reload.setSprite(0);
				AnimatedSprite.sniper_reload.setTime(0);
			}
			
			renderYOffset = 33;
			
			if(flip) renderXOffset = 40;
			else renderXOffset = 8;
		}
		else if(reloading && !dead) {
			animSprite.setFrameRate(5);
			setAnimSprite(AnimatedSprite.sniper_reload);
			sprite = animSprite.getSprite();
			if(sprite.equals(AnimatedSprite.sniper_reload.getSprite(AnimatedSprite.sniper_reload.getLenght() - 1))) {
				reloading = false;
				canMove = true;
				shoot = false;
			}
			
		}
		else if(!onGround && !dead) {
			sprite = Sprite.sniper_jump;
		}
		
		else if(xa != 0 && !dead) {
			setAnimSprite(AnimatedSprite.sniper_walk);
			sprite = animSprite.getSprite();
		}
		else if (!dead){
			setAnimSprite(AnimatedSprite.sniper_idle);
			AnimatedSprite.sniper_idle.setFrameRate(60);
			sprite = animSprite.getSprite();
		}
	}
	
	public void die() {
		canMove=true;
		canjump= false;
		if(!dead)for(int i = 0 ; i < 30 ; i ++) {
			Particle p = new BloodPaticle(x,y,50);
			p.init(level);
			level.add(p);
		}
		if(!dead)die = true;
	}
	
	public boolean isDead() {
		return dead;
	}
	
	public void render(Screen screen) {
		screen.renderMob((x-renderXOffset), (y-renderYOffset), sprite,flip);
	} 
	
	private void setAnimSprite(AnimatedSprite anim) {
		this.animSprite = anim;
	}

	public void sparkle() {
		for(int i = 0 ; i < 7 ; i++) {
			LightParticle p = new LightParticle(x,y,50);
			p.init(level);
			level.add(p);
		}
	}
	
	public void update() {
		recovery();
		sparkle();
		animSprite.update();
		if(fireRate > 0) fireRate--;
		updateMove();
		updateShoot();
	}
	
	private void updateMove() {
		
		if(xa < -1) xa = -1;
		if(xa > 1) xa = 1;
		if(xa > 0)xa -= 1 ; 	//enleve l'inertie
		if(xa < 0)xa += 1 ;		//enleve l'inertie
		
		int vitesse = 3;
		
		if(input.space) {
			jump(12);
		}
		if(!input.space && onGround && !dead) {
			canjump = true;
		}
		if(input.left && !roll && !dead)  {
				xa -= vitesse;
				flip = true;
		}
		if(input.C && !roll && !dead && !die) {
			jump(8);
			roll = true;
			AnimatedSprite.sniper_roll.setSprite(0);
			AnimatedSprite.sniper_roll.setTime(0);
		}
		if(input.right && !roll && !dead)  {
			xa += vitesse;
			flip = false;
		}
		if(input.up && !roll && !dead)  {
			ya -= 1;
		}
		if(input.down && !roll && !dead)  {
			ya += 1;
		}
		if(!canMove) {
			xa = 0;
		} 
		else if(roll) {
			if(flip) xa = 5;
			else xa = -5;
		}
		move();
		fall(1);
		changeSprite();
	}
	
	private void updateShoot() {
		if(input.W  && !reloading && !shoot && !roll  && !dead && !die) {
			if(flip) {
				shoot(x,y+8,-3.14);
			}
			else {
				shoot(x+16,y+8,0.0);
			}
			shoot = true;
			canMove = false;
			AnimatedSprite.sniper_fire.setSprite(0);
			
		}
	}
	
}
