package com.meujogo.main.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{

	private static final int numKeys = 256;
	private static final boolean [] lastKeys = new boolean[numKeys];
	private static final boolean [] keys = new boolean[numKeys];
	
	@Override
	public void keyPressed(KeyEvent ev) {
		keys[ev.getKeyCode()]=true;
	}
	
	@Override
	public void keyReleased(KeyEvent ev) {
		keys[ev.getKeyCode()]=false;
	}
	
	public static boolean isKeyDown(int key){
		return keys[key];
	}
	
	public static boolean wasPressed(int key){
		return isKeyDown(key)&&!lastKeys[key];
	}
	
	public static void update(){
		for (int i=0; i<numKeys;i++){
			lastKeys[i]=keys[i];
		}
	}
}
