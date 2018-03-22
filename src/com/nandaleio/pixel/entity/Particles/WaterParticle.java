package com.nandaleio.pixel.entity.Particles;

import java.util.Random;

import com.nandaleio.pixel.graphics.Sprite;

public class WaterParticle extends Particle{

	public WaterParticle(int x, int y, int life) {
		super(x, y, life);
		Random rand = new Random();
		if(rand.nextBoolean()) sprite = Sprite.particle_water1;
		else sprite = Sprite.particle_water2;
	}
}
