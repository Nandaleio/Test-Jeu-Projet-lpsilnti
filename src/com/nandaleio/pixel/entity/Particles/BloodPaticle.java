package com.nandaleio.pixel.entity.Particles;

import java.util.Random;

import com.nandaleio.pixel.graphics.Sprite;

public class BloodPaticle extends Particle{

	public BloodPaticle(int x, int y, int life) {
		super(x, y, life);
		Random rand = new Random();
		if(rand.nextBoolean()) sprite = Sprite.particle_blood1;
		else sprite = Sprite.particle_blood2;
	}

}
