package com.nandaleio.pixel.entity.Particles;

import java.util.Random;

import com.nandaleio.pixel.graphics.Sprite;

public class GrassParticle extends Particle{

	public GrassParticle(int x, int y, int life) {
		super(x, y, life);
		this.ya = random.nextGaussian() - 1;
		Random rand = new Random();
		if(rand.nextBoolean()) sprite = Sprite.particle_grass1;
		else sprite = Sprite.particle_grass2;
	}

}
