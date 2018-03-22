package com.nandaleio.pixel.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
	
	private boolean[] keys = new boolean[120];
	public boolean up, down,left,right,X,W,C,V,space,Q,D;
	
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}
	
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}
	
	public void keyTyped(KeyEvent e) {
		
	}

	public void update () {
		
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		W = keys[KeyEvent.VK_W];
		X = keys[KeyEvent.VK_X];
		C = keys[KeyEvent.VK_C];
		V = keys[KeyEvent.VK_V];
		space = keys[KeyEvent.VK_SPACE];
		D = keys[KeyEvent.VK_D];
		Q = keys[KeyEvent.VK_Q];

	}


}
