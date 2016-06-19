package com.meujogo.main;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Texture {
	
	private BufferedImage image;
	private String fileName;
	
	public Texture(String fileName){
		this.fileName = fileName;
		try {
			image = ImageIO.read(new File("./Resources/"+this.fileName+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getImage(){
		return image;
	}
	
	public void render(Graphics g, double x, double y){
		g.drawImage(image, (int)x, (int)y, null);
	}
}
