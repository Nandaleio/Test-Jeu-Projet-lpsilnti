package com.nandaleio.pixel.level;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.nandaleio.pixel.entity.Entity;
import com.nandaleio.pixel.entity.Projectile;
import com.nandaleio.pixel.entity.Particles.Particle;
import com.nandaleio.pixel.entity.Particles.ParticleSpawner;
import com.nandaleio.pixel.entity.mob.Chasseur;
import com.nandaleio.pixel.entity.mob.Mob;
import com.nandaleio.pixel.entity.mob.Player;
import com.nandaleio.pixel.graphics.Screen;
import com.nandaleio.pixel.level.tile.OverlayTile;
import com.nandaleio.pixel.level.tile.Tile;

public class Level {
	
	private List<Entity> entities = new ArrayList<Entity>();
	private List<Mob> mobs = new ArrayList<Mob>();
	protected int[] overlayTiles;
	private List<Player> players = new ArrayList<Player>();
	
	private List<Projectile> projectiles = new ArrayList<Projectile>();
	
	private List<ParticleSpawner> spawners = new ArrayList<ParticleSpawner>();
	protected int spawnX = 48;
	
	protected int spawnY = 2608;
	protected Tile[] tiles;
	
	protected int[] tilesInt;
	protected int time = 0;
	protected int width, height;
	
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		overlayTiles = new int[width * height];
		generateLevel();
		generateOverlayLevel();
	}

	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}

	public void add(Entity e) {
		if (e instanceof Player) {
			e.init(this);
			players.add((Player) e);
			System.out.println("Adding Player : " + players.size());
		}
		
		else if(e instanceof Mob) {
			e.init(this);
			mobs.add((Mob) e);
			System.out.println("Adding Mob : " + mobs.size());
		}
		else if (e instanceof Particle) {
			e.init(this);
			entities.add((Particle) e);
		}
		else if (e instanceof Projectile) {
			e.init(this);
			projectiles.add((Projectile) e);
		}
		else if (e instanceof ParticleSpawner) {
			e.init(this);
			spawners.add((ParticleSpawner) e);
			System.out.println("Adding Spawner : " + spawners.size());
		}
	}
	
	protected void generateLevel() { 
		
	}
	
	protected void generateOverlayLevel() {
		
	}
	
	public List<Entity> getEntities(Entity e, int radius){
		List<Entity> result = new ArrayList<Entity>();
		int ex = e.getX();
		int ey = e.getY();
		for(int i = 0 ; i < mobs.size() ; i++) {
			Entity entity = mobs.get(i);
			int x = entity.getX();
			int y = entity.getY();
			
			int dx = Math.abs(x - ex);
			int dy = Math.abs(y - ey);
			
			double distance = Math.sqrt((dx*dx)+(dy*dy));
			if(distance <= radius) result.add(entity);
		}
		return result;
	}
	
	public List<Mob> getMob() {
		return mobs;
	}
	
	public OverlayTile getOverTile(int x,int y) {
		if(x < 0 || y < 0 || x >= width || y >= height)	return OverlayTile.overvoid;
		if(tilesInt[x+y*width] == 0xff4F6F61) return OverlayTile.herbe2;
		if(tilesInt[x+y*width] == 0xff8C6FF0) return OverlayTile.fleur1;
		if(tilesInt[x+y*width] == 0xff778CC9) return OverlayTile.pierre1;
		if(tilesInt[x+y*width] == 0xffE58075) return OverlayTile.fleur2;
		if(tilesInt[x+y*width] == 0xffC96F65) return OverlayTile.fleur3;
		if(tilesInt[x+y*width] == 0xff4F6FC6) return OverlayTile.pierre2;
		if(tilesInt[x+y*width] == 0xff478267) return OverlayTile.herbe1;
		else return OverlayTile.overvoid;
	}
	
	public Player getPlayer1() {
		return players.get(0);
	}

	public Player getPlayerAt(int i) {
		return players.get(i);
	}
	
	public List<Player> getPlayers() {
		return players;
	}

	public List<Player> getPlayers(Entity e, int radius) {
		List<Player> result = new ArrayList<Player>();
		int ex = e.getX();
		int ey = e.getY();
		for(int i = 0 ; i < players.size() ; i++) {
			Entity entity = players.get(i);
			int x = entity.getX();
			int y = entity.getY();
			
			int dx = Math.abs(x - ex);
			int dy = Math.abs(y - ey);
			
			double distance = Math.sqrt((dx*dx)+(dy*dy));
			if(distance <= radius) result.add((Player)players.get(i));
		}
		return result;
	}
	
	public int getSpawnX() {
		return spawnX;
	}
	
	public int getSpawnY() {
		return spawnY;
	}
	
	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || x >= width || y >= height)	return Tile.voidtile;
		
		//TERRAIN
		//orange
		if(tilesInt[x+y*width] == 0xFF7F0000) return Tile.O1;
		if(tilesInt[x+y*width] == 0xFFFF0000) return Tile.O2;
		if(tilesInt[x+y*width] == 0xff7F007C) return Tile.O3;
		if(tilesInt[x+y*width] == 0xff784040) return Tile.OB;
		if(tilesInt[x+y*width] == 0xffBC5656) return Tile.OTG;
		if(tilesInt[x+y*width] == 0xffFF4F4F) return Tile.OTD;
		if(tilesInt[x+y*width] == 0xffFFCB54) return Tile.ODW;
		if(tilesInt[x+y*width] == 0xffA05B4E) return Tile.ONH1;
		if(tilesInt[x+y*width] == 0xffFF7A32) return Tile.ONH2;
		if(tilesInt[x+y*width] == 0xffFF7A61) return Tile.ONH3;
		if(tilesInt[x+y*width] == 0xffFF0455) return Tile.OWG;
		if(tilesInt[x+y*width] == 0xffFF5555) return Tile.OWD;
		if(tilesInt[x+y*width] == 0xffA05BAE) return Tile.OS;
		if(tilesInt[x+y*width] == 0xff952DAD) return Tile.ODW;
		
		if(tilesInt[x+y*width] == 0xffFF3A33) return Tile.OW;
		
		//Gris
		if(tilesInt[x+y*width] == 0xffA1CCA1) return Tile.V1;
		if(tilesInt[x+y*width] == 0xff80AA80) return Tile.V2;
		if(tilesInt[x+y*width] == 0xff59A859) return Tile.V3;
		if(tilesInt[x+y*width] == 0xff404040) return Tile.VB;
		if(tilesInt[x+y*width] == 0xff9E5656) return Tile.VTG;
		if(tilesInt[x+y*width] == 0xff6B3A6D) return Tile.VTD;
		if(tilesInt[x+y*width] == 0xffFFCB54) return Tile.VDW;
		if(tilesInt[x+y*width] == 0xffADADAD) return Tile.VNH1;
		if(tilesInt[x+y*width] == 0xff909090) return Tile.VNH2;
		if(tilesInt[x+y*width] == 0xff606060) return Tile.VNH3;
		if(tilesInt[x+y*width] == 0xffAA4EAA) return Tile.VWG;
		if(tilesInt[x+y*width] == 0xffAD74AD) return Tile.VWD;
		if(tilesInt[x+y*width] == 0xff424A6B) return Tile.VS;
		if(tilesInt[x+y*width] == 0xff67226B) return Tile.VDW;
		if(tilesInt[x+y*width] == 0xff909090) return Tile.VNH2;
		if(tilesInt[x+y*width] == 0xff606060) return Tile.VNH3;
		if(tilesInt[x+y*width] == 0xffAA4EAA) return Tile.VWG;
		if(tilesInt[x+y*width] == 0xffAD74AD) return Tile.VWD;
		if(tilesInt[x+y*width] == 0xff424A6B) return Tile.VS;
		if(tilesInt[x+y*width] == 0xff67226B) return Tile.VDW;
		
		//grass
		if(tilesInt[x+y*width] == 0x5D7C23) return Tile.GDW;
		if(tilesInt[x+y*width] == 0x5D5B23) return Tile.GDW;
		if(tilesInt[x+y*width] == 0x5D7C23) return Tile.GDW;
		if(tilesInt[x+y*width] == 0x698217) return Tile.GDW;
		if(tilesInt[x+y*width] == 0x5D7C23) return Tile.GDW;
		if(tilesInt[x+y*width] == 0x5D7C23) return Tile.GDW;
		if(tilesInt[x+y*width] == 0x5D7C23) return Tile.GDW;
		
		//Wall
		if(tilesInt[x+y*width] == 0xff7F3300) return Tile.wall;
		if(tilesInt[x+y*width] == 0xff7C553A) return Tile.wall01;
		
		//Special
		if(tilesInt[x+y*width] == 0xffFF00FA) return Tile.echelle_top;
		if(tilesInt[x+y*width] == 0xffFF3DFF) return Tile.echelle_middle;
		if(tilesInt[x+y*width] == 0xffBC2DBC) return Tile.echelle_bottom;
		if(tilesInt[x+y*width] == 0xffFF87FF) return Tile.caisse;
		
		//OVERLAY
		//Vegetation
		if(tilesInt[x+y*width] == 0xffF6FF5E) return Tile.tree;
		
		
		else return Tile.voidtile;
	}
	
	protected void loadLevel(String path) {
		
	}
	public void render(int xScroll, int yScroll, Screen screen) {
		screen.renderBackground(0xff3E3E6D);
		screen.setOffset(xScroll, yScroll);
		renderTile(xScroll,yScroll,screen);
		renderOverlay(xScroll,yScroll,screen);
	}
	public void renderEntities(Screen screen) {
		for(int i = 0 ; i < players.size() ; i++) {
			players.get(i).render(screen);
		}
		for(int i = 0 ; i < mobs.size() ; i++) {
			mobs.get(i).render(screen);
		}
		for(int i = 0 ; i < entities.size() ; i++) {
			entities.get(i).render(screen);
		}
		for(int i = 0 ; i < projectiles.size() ; i++) {
			projectiles.get(i).render(screen);
		}
		
		
	}
	
	public void renderOverlay(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;
		
		for (int y = y0; y < y1; y++) {
			for (int x =x0; x < x1; x++) {
			    OverlayTile overtile = getOverTile(x,y);
			    if(overtile.equals(OverlayTile.overvoid)) {			    	
			    	continue;
			  }
			  else {
				  overtile.render(x,y,screen);
			  }
			}
		
		}
	}
	
	public void renderTile(int xScroll, int yScroll, Screen screen) {
		
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;
		
		for (int y = y0; y < y1; y++) {
			  for (int x =x0; x < x1; x++) {
			    Tile tile = getTile(x,y);
			    tile.render(x,y,screen);
			  }
		}
		renderEntities(screen);
		
	}
	
	public boolean tileCollision(double x, double y, int size, int xoffset, int yoffset) {
		boolean solid = false;
 		for(int c = 0 ; c < 4 ; c++) {
			double xt = (x - c % 2 * size + xoffset) /16;
			double yt = (y - c / 2 * 16 ) /16;
			if(getTile((int)xt , (int)yt).solid()) solid = true;
			else solid = false;
		}
		return solid;
	}

	public void update() {
		Random rand = new Random();
		time++;
		if(time % 1000 == 0) {
			int xs=rand.nextInt(width)+1;
			int ys=rand.nextInt(height)+1;
			if(!getTile(xs,ys).solid()) {
				System.out.println("Ennemy spawn");
				add(new Chasseur(xs, ys));
			}
			else {
				System.out.println("Wrong spawn");
			}
			time = 0;
		}
		for(int i = 0 ; i < projectiles.size() ; i++) {
			projectiles.get(i).update();
			if(projectiles.get(i).isRemoved()) {
				projectiles.remove(i);
			}
			if(projectiles.size() > 100) {
				System.out.println("Limite projectile (100) atteint !");
				projectiles.remove(0);
			}
		}
		for(int i = 0 ; i < mobs.size() ; i++) {
			mobs.get(i).update();
			if(mobs.get(i).isRemoved()) {
				System.out.println("remove mob");
				mobs.remove(i);
			}
			if(mobs.size() > 50) 
			{
				System.out.println("Limite mob (50) atteint");
				mobs.remove(0);
			}
		}
		for(int i = 0 ; i < entities.size() ; i++) {
			entities.get(i).update();
			if(entities.get(i).isRemoved()) {
				entities.remove(i);
			}
		}
		
		for(int i = 0 ; i < players.size() ; i++) {
			players.get(i).update();
			if(players.get(i).isRemoved()) {
				players.remove(i);
				System.out.println("suppression jouer");
			}
		}
		if(players.size() > 20) {
			System.out.println("Limite joueur (20) atteint");
			players.remove(0);
		}
		for(int i = 0 ; i < spawners.size() ; i++) {
			spawners.get(i).update();
			if(spawners.get(i).isRemoved()) {
				System.out.println("remove spawner");
				spawners.remove(i);
			}
		}
		if(spawners.size() > 20) {
			System.out.println("Limite spawners (20) atteint");
			spawners.remove(0);
		}
	}

	
}
