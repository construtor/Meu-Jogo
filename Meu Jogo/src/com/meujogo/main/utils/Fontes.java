package com.meujogo.main.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import com.meujogo.main.Game;

public class Fontes {

	public static void drawString(Graphics g, Font f, Color c, String s, int x, int y){
		g.setFont(f);
		g.setColor(c);
		g.drawString(s, x, y);
	}
	
	public static void drawString(Graphics g, Font f, Color c, String s){
		FontMetrics fs = g.getFontMetrics(f);
		int x = (Game.WIDTH - fs.stringWidth(s))/2;
		int y = ((Game.HEIGHT - fs.getHeight())/2)+fs.getAscent();
		drawString(g,f,c,s,x,y);
	}
	
	public static void drawString(Graphics g, Font f, Color c, String s, double x){
		FontMetrics fs = g.getFontMetrics(f);
		
		int y = ((Game.height - fs.getHeight())/2)+fs.getAscent();
		drawString(g,f,c,s,(int)x,y);
	}
	
	public static void drawString(Graphics g, Font f, Color c, String s, int y){
		FontMetrics fs = g.getFontMetrics(f);
		int x = (Game.width - fs.stringWidth(s))/2;
		
		drawString(g,f,c,s,x,y);
	}
}
