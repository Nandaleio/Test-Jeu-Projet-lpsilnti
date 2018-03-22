package com.nandaleio.pixel.entity.Particles;

import java.util.ArrayList;
import java.util.List;

import com.nandaleio.pixel.entity.Entity;
import com.nandaleio.pixel.level.Level;

public class ParticleSpawner extends Entity{

	private int life, nbPart;
	List<Particle> particles = new ArrayList<Particle>();
	private int type;
	
	public ParticleSpawner(int nbPart, int type,int x, int y, int life) {
		this.x = x<<4;
		this.y = y<<4;
		this.type = type;
		this.life = life;
		this.nbPart = nbPart;
	}
	
	public void init(Level level) {
		this.level = level;
	}
	
	public void update() {
		if(type == 1) {
			for(int i = 0 ; i < nbPart ;i++) {
				particles.add(new WaterParticle(x,y,life));
			}
		}
		else if(type == 2) {
			for(int i = 0 ; i < nbPart ;i++) {
				particles.add(new BloodPaticle(x,y,life));
			}
		}
		else if(type == 3) {
			for(int i = 0 ; i < nbPart ;i++) {
				particles.add(new GrassParticle(x,y,life));
			}
		}
		else {
			for(int i = 0 ; i < nbPart ;i++) {
				particles.add(new Particle(x,y,life));
			}
		}
		
		for(int i = 0 ; i < particles.size() ; i++) {
			particles.get(i).init(level);
			particles.get(i).update();
			if(!particles.get(i).isRemoved()) level.add(particles.get(i));
		}
	}
}
