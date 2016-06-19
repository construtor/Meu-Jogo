package com.meujogo.sprite;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Sprite {

	private BufferedImage image;
	private int xis=0;
	private int yps=0;
	private int width  = 0;
	private int height = 0;
	SpriteSheet spriteSheet;
	
	public Sprite(SpriteSheet spriteSheet, int x, int y){
		xis=x;
		yps=y;
		width=spriteSheet.getWidth();
		height=spriteSheet.getHeight();
		this.spriteSheet = spriteSheet;
		
		/*this.image = spriteSheet.getTexture().getImage().getSubimage(
				(x*spriteSheet.getWidth())-spriteSheet.getWidth()
				, (y*spriteSheet.getHeight())-spriteSheet.getHeight()
				, spriteSheet.getWidth(), spriteSheet.getHeight());*/
	}
	
	public void render(Graphics g , double x, double y){
		
		image = spriteSheet.getTexture().getImage().getSubimage((xis*width)-width, (yps*height)-height, width, height);
		g.drawImage(image, (int) x, (int) y	, null);
	}

	public void setXis(int xis) {
		this.xis = xis;
	}

	public void setYps(int yps) {
		this.yps = yps;
	}
	int count=0;
	public void update(){
		count++;
		if (count>3){
			count=0;
			if (xis>4)
				xis=0;
			xis++;
		}
	}
	
}
