package com.meujogo.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import com.meujogo.main.input.MouseInput;
import com.meujogo.main.ui.Button;
import com.meujogo.main.utils.Fontes;

public class Menu {
	private int currentSelection;
	private final Button[] options;
	
	public Menu(){
		options = new Button[3];
		options[0] = new Button("Play",	200+0*80,
				new Font("Arial",Font.PLAIN,32),new Font("Arial",Font.BOLD,48),
				Color.WHITE,Color.YELLOW);
		options[1] = new Button("Options",200+1*80,
				new Font("Arial",Font.PLAIN,32),new Font("Arial",Font.BOLD,48),
				Color.WHITE,Color.YELLOW);
		options[2] = new Button("Exit",200+2*80,
				new Font("Arial",Font.PLAIN,32),new Font("Arial",Font.BOLD,48),
				Color.WHITE,Color.YELLOW);
	}
	
	public void render(Graphics g){
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, Game.width,Game.height);
		Fontes.drawString(g, new Font("Arial",Font.BOLD,72), Color.ORANGE, Game.TITLE, 80);
		
		for(int i=0; i<options.length; i++){
			if (i==currentSelection){
				options[i].setSelected(true);
			}else
				options[i].setSelected(false);
			
			options[i].render(g);
		}
	}
	
	public void select(){
		switch(currentSelection){
		case 0:
			System.out.println("Play");
			break;
		case 1:
			System.out.println("Options");
			break;
		case 2:
			System.out.println("Exit");
			Main.INSTANCE.gameStop();
			break;
		}
	}
	
	public void tick(){
		boolean clicked=false;
		for(int i =0; i<options.length; i++){
			if (options[i].intersects(new Rectangle(MouseInput.getX(),MouseInput.getY(),1,1))){
				currentSelection = i;
				clicked = MouseInput.wasPressed(MouseEvent.BUTTON1);
			}
		}
		if (clicked) select();
	}
}
