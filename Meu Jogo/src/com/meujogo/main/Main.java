package com.meujogo.main;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Main extends JFrame{
	
	Game game;
	private static int WIDTH = 800;
	private static int HEIGHT = 600;
	public static Main INSTANCE;
	
	public Main(){
		INSTANCE = this;
		setSize(WIDTH,HEIGHT);
		setResizable(false);
		setLocation(600,400);
		game = new Game(WIDTH,HEIGHT);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent ev){
				gameStop();
			}
		});
		
		add(game);
		setVisible(true);
		setFocusable(true);
		setAutoRequestFocus(true);
	}
	
	protected void gameStop() {
		System.out.println("/////////////////\ngameStop acionado!\n/////////////////");
		game.encerra();
		System.exit(1);
	}
	
	public void gameStart(){
		game.inicia();
	}

	public static void main(String args[]){
		Main app = new Main();
		app.gameStart();
	}

}
