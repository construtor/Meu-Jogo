package com.meujogo.main.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import com.meujogo.main.Game;
import com.meujogo.main.Main;
import com.meujogo.main.input.MouseInput;
import com.meujogo.main.ui.Button;
import com.meujogo.main.utils.Fontes;

public class MenuState implements State{
	private int currentSelection;
	private Button[] options;
	
	
	
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
	
	public void select(ManagerState sm){
		switch(currentSelection){
		case 0:
			sm.setState("Level1");
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

	@Override
	public void init() {
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

	@Override
	public void enter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tick(ManagerState managerState) {
		boolean clicked=false;
		for(int i =0; i<options.length; i++){
			if (options[i].intersects(new Rectangle(MouseInput.getX(),MouseInput.getY(),1,1))){
				currentSelection = i;
				clicked = MouseInput.wasPressed(MouseEvent.BUTTON1);
			}
		}
		if (clicked) select(managerState);
		
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Menu";
	}
}
