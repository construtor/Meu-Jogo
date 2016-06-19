package com.meujogo.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.meujogo.main.utils.Fontes;

public class Menu {
	
	private final String[] options = {
			"PLAY","OPTIONS", "EXIT"
	};
	private int currentSelection;
	
	public void render(Graphics g){
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, Game.width,Game.height);
		Fontes.drawString(g, new Font("Arial",Font.BOLD,40), Color.ORANGE, Game.TITLE, 80);
	}

}
