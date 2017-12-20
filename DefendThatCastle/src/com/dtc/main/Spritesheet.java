package com.dtc.main;
import java.awt.image.BufferedImage;

public class Spritesheet {
	
	protected BufferedImage image;
	
	public Spritesheet( BufferedImage image ) {
		this.image = image;
	}
	
	public Spritesheet( Spritesheet ss, int row, int col, int width, int height) {
		this.image = ss.image.getSubimage(col*64, row*64, width, height);
	}
	public BufferedImage grabImage(int col, int row, int width, int height) {
		return image.getSubimage(col*64, row*64, width, height);
	}

}
