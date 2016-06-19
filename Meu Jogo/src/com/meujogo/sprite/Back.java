package com.meujogo.sprite;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.meujogo.main.Texture;

public class Back {

	private Texture texture;
	private BufferedImage background;
	private int width, height;
	
	public Back(Texture texture,int size){
		this(texture,size,size);
	}

	public Back(Texture texture, int width, int height) {
		this.texture = texture;
		this.width = width;
		this.height = height;
		
		background = this.texture.getImage();
	}
	
	public void render(Graphics g , double x, double y){
			g.drawImage(background, 0, 0, width, height, null, null);	
	}
}
