package com.nandaleio.pixel.graphics;

public class Sprite {
	
	public static Sprite caisse = new Sprite(16,1,4,SpriteSheet.tiles);
	public static Sprite echelle_bottom = new Sprite(16,0,6,SpriteSheet.tiles);
	public static Sprite echelle_middle = new Sprite(16,0,5,SpriteSheet.tiles);
	//SPECIAL
	public static Sprite echelle_top = new Sprite(16,0,4,SpriteSheet.tiles); 
	public static Sprite fleur1 = new Sprite(16,8,5,SpriteSheet.tiles);
	
	public static Sprite fleur2 = new Sprite(16,7,6,SpriteSheet.tiles);
	
	public static Sprite fleur3 = new Sprite(16,8,6,SpriteSheet.tiles);
	public static Sprite GDW = new Sprite(16,6,3,SpriteSheet.tiles);
	public static Sprite GG = new Sprite(16,6,3,SpriteSheet.tiles);
	public static Sprite GNH1 = new Sprite(16,3,2,SpriteSheet.tiles);
	public static Sprite GNH2 = new Sprite(16,4,2,SpriteSheet.tiles);
	public static Sprite GNH3 = new Sprite(16,5,2,SpriteSheet.tiles);
	public static Sprite GS = new Sprite(16,6,2,SpriteSheet.tiles);
	//grass
	public static Sprite GTG = new Sprite(16,2,3,SpriteSheet.tiles);
	public static Sprite GW = new Sprite(16,4,3,SpriteSheet.tiles);
	public static Sprite GWD = new Sprite(16,5,3,SpriteSheet.tiles);
	public static Sprite GWG = new Sprite(16,3,3,SpriteSheet.tiles);
	//vegetation
	public static Sprite herbe1 = new Sprite(16,4,3,SpriteSheet.tiles);
	public static Sprite herbe2 = new Sprite(16,7,5,SpriteSheet.tiles);
	//Mob
	public static Sprite mob1 = new Sprite(16,1,0,SpriteSheet.player);
	
	public static Sprite mob2 = new Sprite(16,2,0,SpriteSheet.player);
	//TERRAIN
	//Classic orange
	public static Sprite O1 = new Sprite(16,0,0,SpriteSheet.tiles);
	public static Sprite O2 = new Sprite(16,1,0,SpriteSheet.tiles);
	public static Sprite O3 = new Sprite(16,2,0,SpriteSheet.tiles);
	public static Sprite OB = new Sprite(16,0,1,SpriteSheet.tiles);
	public static Sprite ODW = new Sprite(16,6,1,SpriteSheet.tiles);
	public static Sprite ONH1 = new Sprite(16,3,0,SpriteSheet.tiles);
	public static Sprite ONH2 = new Sprite(16,4,0,SpriteSheet.tiles);
	public static Sprite ONH3 = new Sprite(16,5,0,SpriteSheet.tiles);
	public static Sprite OS = new Sprite(16,6,0,SpriteSheet.tiles);
	public static Sprite OTD = new Sprite(16,1,1,SpriteSheet.tiles);
	public static Sprite OTG = new Sprite(16,2,1,SpriteSheet.tiles);
	//OVERLAY
	public static Sprite overvoid = new Sprite(16,0xffff00ff);
	public static Sprite OW = new Sprite(16,4,1,SpriteSheet.tiles);

	public static Sprite OWD = new Sprite(16,5,1,SpriteSheet.tiles);
	public static Sprite OWG = new Sprite(16,3,1,SpriteSheet.tiles);
	public static Sprite particle_blood1 = new Sprite(1,0x990000);
	public static Sprite particle_blood2 = new Sprite(1,0x660000);
	public static Sprite particle_grass1 = new Sprite(1,0x2d8636);
	public static Sprite particle_grass2 = new Sprite(1,0x40bf4d);
	//PARTICULES
	public static Sprite particle_normal1 = new Sprite(1,0x737373);
	public static Sprite particle_normal2 = new Sprite(1,0xaaaaaa);
	public static Sprite particle_water1 = new Sprite(1,0x33ccff);
	public static Sprite particle_water2 = new Sprite(1,0x80dfff);
	
	//Wall
	
	
	public static Sprite particle_white = new Sprite(1,0xffffff);
	public static Sprite pierre1 = new Sprite(16,9,5,SpriteSheet.tiles);
	public static Sprite pierre2 = new Sprite(16,9,6,SpriteSheet.tiles);
	//JOUEUR
	public static Sprite player = new Sprite(32,0,6,SpriteSheet.player);
	
	//animation joueur
	public static Sprite player_1 = new Sprite(32,2,7,SpriteSheet.player);
	public static Sprite player_2 = new Sprite(32,3,7,SpriteSheet.player);
	public static Sprite player_3 = new Sprite(32,4,7,SpriteSheet.player);
	public static Sprite player_4 = new Sprite(32,1,7,SpriteSheet.player);
	public static Sprite player_5 = new Sprite(32,0,7,SpriteSheet.player);
	public static Sprite player_crouch = new Sprite(32,2,6,SpriteSheet.player);
	public static Sprite player_jump = new Sprite(32,1,6,SpriteSheet.player);
	//PROJECTILES
	public static Sprite projectile = new Sprite(16,0,3,SpriteSheet.player);
	
	
	
	public static Sprite sniper_dead = new Sprite(16,4,6,SpriteSheet.sniper);
	//sniper
	public static Sprite sniper_idle = new Sprite(16,0,0,SpriteSheet.sniper);
		public static Sprite sniper_jump = new Sprite(16,1,0,SpriteSheet.sniper);
	
	
	//UNICOLOR
	//0x3E3E6D = blue nuit
	
	//tree
	public static Sprite tree = new Sprite(SpriteSheet.tree.pixels,64,128);
		//Classic gris
		public static Sprite V1 = new Sprite(16,0,2,SpriteSheet.tiles);
		public static Sprite V2 = new Sprite(16,1,2,SpriteSheet.tiles);
		public static Sprite V3 = new Sprite(16,2,2,SpriteSheet.tiles);
	public static Sprite VB = new Sprite(16,0,3,SpriteSheet.tiles);
	public static Sprite VDW = new Sprite(16,6,3,SpriteSheet.tiles);
	
	public static Sprite VNH1 = new Sprite(16,3,2,SpriteSheet.tiles);
	public static Sprite VNH2 = new Sprite(16,4,2,SpriteSheet.tiles);
	public static Sprite VNH3 = new Sprite(16,5,2,SpriteSheet.tiles);
	//VOID
	public static Sprite voidsprite = new Sprite(0,0x000000);
	public static Sprite VS = new Sprite(16,6,2,SpriteSheet.tiles);
	public static Sprite VTD = new Sprite(16,1,3,SpriteSheet.tiles);
	public static Sprite VTG = new Sprite(16,2,3,SpriteSheet.tiles);
	
	public static Sprite VW = new Sprite(16,4,3,SpriteSheet.tiles);
	
	public static Sprite VWD = new Sprite(16,5,3,SpriteSheet.tiles);
	public static Sprite VWG = new Sprite(16,3,3,SpriteSheet.tiles);
	//WALL
	public static Sprite wall = new Sprite(16,10,0,SpriteSheet.tiles);
	public static Sprite wall01 = new Sprite(16,10,2,SpriteSheet.tiles);
	public static Sprite[] split(SpriteSheet sheet) {
		int amount = (sheet.getWidth() * sheet.getHeight()) / (sheet.sprite_Width * sheet.sprite_Height);
		Sprite[] sprites = new Sprite[amount];
		int[] pixels = new int[sheet.sprite_Height * sheet.sprite_Width];
		
		int i = 0;
		
		for(int yp = 0 ; yp < sheet.getHeight() / sheet.sprite_Height ; yp++) {
			for(int xp = 0 ; xp < sheet.getWidth() / sheet.sprite_Width ; xp++) {
			
				for(int y = 0 ; y < sheet.sprite_Height ; y++) {
					for(int x = 0 ; x < sheet.sprite_Width ; x++) {
						
						int xo = x + xp * sheet.sprite_Width;
						int yo = y + yp * sheet.sprite_Height;
						
						pixels[x+y*sheet.sprite_Width] = sheet.pixels[xo + yo * sheet.getWidth()];
						
					}
				}
				
				sprites[i++] = new Sprite(pixels, sheet.sprite_Width, sheet.sprite_Height);
			}
		}
		
		return sprites;
	}
	public int[] pixels;
	protected SpriteSheet sheet;
	public final int SIZE;
	private int width, height;
	
	
	private int x, y ;
	
	public Sprite(int size, int color) {
		this.SIZE = size;
		this.width = this.height = size;
		pixels = new int [SIZE*SIZE];
		setColor(color);
		
	}
	
	public Sprite(int width, int height, int color) {
		SIZE = -1;
		this.width = width;
		this.height = height;
		pixels = new int [width*height];
		setColor(color);
	}
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		this.width = this.height = size;
		pixels = new int[SIZE*SIZE];
		this.x = x*size;
		this.y = y* size;
		this.sheet = sheet;
		load();
	}
	
	public Sprite(int[] pixels, int width, int height) {
		if(width == height) SIZE = width;
		else SIZE = -1;
		
		this.width = width;
		this.height = height;
		
		this.pixels = new int[pixels.length];
		System.arraycopy(pixels, 0, this.pixels, 0, pixels.length);
	}
	
	public Sprite(SpriteSheet sheet, int width, int height) {
		if(width == height) SIZE = width;
		else SIZE = -1;
		
		this.width = width;
		this.height = height;
		this.sheet = sheet;
		pixels = new int[width * height];
		//load();
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}

	private void load() {
		for(int y = 0 ; y < height; y++) {
			for(int x = 0 ; x < width ; x++) {
				pixels[x + y  *width] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.sprite_Width];
			}
		}
	}

	private void setColor(int color) {
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = color;
		}
	}
	
}
