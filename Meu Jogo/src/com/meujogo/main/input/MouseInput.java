package com.meujogo.main.input;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter{
	
	private static final int numKeys = 10;
	private static boolean[] buttons = new boolean[numKeys];
	private static boolean[] lastButtons = new boolean[numKeys];
	private static boolean moving;
	private static int y;
	private static int x;
	private static int lastY;
	private static int lastX;
	
	@Override
	public void mousePressed(MouseEvent e) {
		buttons[e.getButton()]=true;
		System.out.println("Mouse Pressed");
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		buttons[e.getButton()]=false;
	}

	public static int getY() {
		return y;
	}

	public static int getX() {
		return x;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		moving = true;
	}

	public static  void update(){
		for (int i=0; i<numKeys; i++){
			lastButtons[i]=buttons[i];
		}
		
		if (x == lastX && y == lastY)moving=false;
		lastX =x;
		lastY =y;
	}
	
	public static boolean wasPressed(int key){
		return isDown(key) && !lastButtons[key];
	}

	private static boolean isDown(int key) {
		return buttons[key];
	}
	
	public static boolean wasRelease(int key){
		return !isDown(key) && lastButtons[key];
	}
}
