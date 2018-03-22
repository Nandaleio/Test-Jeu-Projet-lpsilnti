package com.nandaleio.pixel;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.nandaleio.pixel.entity.mob.Player;
import com.nandaleio.pixel.graphics.Font;
import com.nandaleio.pixel.graphics.Screen;
import com.nandaleio.pixel.input.Keyboard;
import com.nandaleio.pixel.input.Mouse;
import com.nandaleio.pixel.level.Level;
import com.nandaleio.pixel.level.SpawnLevel;

public class Game extends Canvas implements Runnable {

	
	private static int scale = 3;
	private static final long serialVersionUID = 1L;
	private static int width = 750;
	
	private static int height = width / 16 * 9 ;
	
	public static int getScale() {
		return scale;
	}
	public static int getWindowHeight() {
		return height * scale;
	}
	public static int getWindowWidth() {
		return width * scale;
	}
	/***************MAIN*****************/
	
	public static void main(String[] arg) {
		Game game = new Game();
		game.frame.setResizable(true);
		game.frame.setTitle("PixelTest");
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		
		game.start();
	}
	private Font font;
	private JFrame frame;
	
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private Keyboard key;
	
	private Level level;
	
	private Mouse mouse;
	
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	private boolean running = false;
	
	private Screen screen;
	
	private Thread thread;
	
	public Game() {
		
		Dimension size = new Dimension(width*scale, height*scale);
		setPreferredSize(size);
		
		screen = new Screen(width, height);
		frame = new JFrame();
		key = new Keyboard();
		frame.addKeyListener(key);
		level = new SpawnLevel("/levelP.png");
		level.add(new Player(7,50,key));
		mouse = new Mouse();
		font = new Font();
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
	}
	
	/*************RENDER****************/
	
	public void render() {		
		
		BufferStrategy bs = getBufferStrategy();
		
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		
		
		int xScroll = level.getPlayer1().getX() - screen.width/2;
		if(xScroll < 0) xScroll = 0;
		if(xScroll > 850) xScroll = 850;
		
		int yScroll = level.getPlayer1().getY() - screen.height/2;
		if(yScroll < 0) yScroll = 0;
		if(yScroll > 1186) yScroll = 1186;
		
		level.render(xScroll, yScroll, screen);
		
		//INFO JOUEUR
		font.render(5,10,-1,"X:" + level.getPlayer1().getX()/16 + " ,Y:" + level.getPlayer1().getY() /16,screen, 0xc7c7cc);
		font.render(5,25,-1,level.getMob().size() + " left",screen, 0xc7c7c7);
		font.render(630, 10, -1, "HP:"+level.getPlayer1().getLife(), screen, 0xc7c7c7);
		
		
		if(level.getPlayer1().isDead()) {
			restart();
			level = new SpawnLevel("/levelP.png");
			level.add(new Player(7,50,key));
		}
		else {
			for(int i = 0; i < pixels.length ; i++) {
				pixels[i] = screen.pixels[i];
			}
		}
		
		/*for(int y = 0; y < height-1 ; y++) {
			for(int x = 1; x < width-1 ; x++) {
				int i = x+y*width;
				
				int oldPix = pixels[i];
				pixels[i] = coPlusProche(oldPix);
			}
		}*/
		
		//post process here 
		
		Graphics g = bs.getDrawGraphics();
		
		
		g.drawImage(image,0,0, getWidth(), getHeight(), null);
		
		//******
		
		g.dispose();
		bs.show();
	}
	
	private void restart() {
		long deb = System.currentTimeMillis();
		while((System.currentTimeMillis() - deb ) < 5000) {
		}
		
	}
	private int coPlusProche(int ancPix) {
		int r = (ancPix >> 16) & 0xFF;
		int g = (ancPix >> 8) & 0xFF;
		int b = ancPix & 0xFF;
		
		int res = 8;
		r = Math.round(res * r /255) * (255/res);
		g = Math.round(res * g /255) * (255/res);
		b = Math.round(res * b /255) * (255/res);
		
		int rgb = r;
		rgb = (rgb << 8) + g;
		rgb = (rgb << 8) + b;
		
		return rgb;
	}
	public void run() {
		
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		
		while(running) {
			
			frame.requestFocus();
			
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			if((System.currentTimeMillis() - timer) > 1000) {
				timer+=1000;
				frame.setTitle("Pixel  |  update : " + updates + "  FPS : " + frames);
				frames = 0;
				updates = 0;
			}
		}
		stop();
	}
	
	public synchronized void start() {
		
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}
	
	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} 
		catch (InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public void update() {
		key.update();
		level.update();
	}
	
}
