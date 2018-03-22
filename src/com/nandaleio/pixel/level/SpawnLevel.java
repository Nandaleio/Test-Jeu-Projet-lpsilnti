package com.nandaleio.pixel.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.nandaleio.pixel.entity.mob.Chasseur;


public class SpawnLevel extends Level{
	
	private int w , h;
	

	public SpawnLevel(String path) {
		super(path);
	}
	
	public void addPixel(int x,int y,int color) {
		tilesInt[x+y*width] = color;
	}
	
	protected void generateLevel() { 
	}
	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			w = width = image.getWidth();
			h = height = image.getHeight();
			tilesInt = new int[w*h];
			overlayTiles = new int[w * h];
			image.getRGB(0, 0, w, h, tilesInt, 0, w);
			SeparationMap();
			
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("Exception ! cant load level  from : " + path);
		}
		for(int i = 0 ; i < 5 ; i++) {
			add(new Chasseur(50,91));
			add(new Chasseur(50,26));
			add(new Chasseur(50,80));
		}
		//add(new ParticleSpawner(5,1,42,37,50));
	}
	
	public void reloadLevel() {
		
	}
	
	
	
	
	private void SeparationMap() {
		for(int y = 0 ; y < h ; y++) {
			for(int x = 0 ; x < w ; x++) {
				
				if(tilesInt[x+y*w] == 0xffB6FF00) {
					overlayTiles[x+y*w] = 0xffB6FF00;
					tilesInt[x+y*w] = -1;
				}
				if(tilesInt[x+y*w] == 0xff808080) {
					overlayTiles[x+y*w] = 0xff808080;
					tilesInt[x+y*w] = -1;
				}
			}
		}
	}

}
