package com.dtc.main.Towers;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.dtc.main.ID;
import com.dtc.main.Spritesheet;

public class PoisonTower extends BasicTower {
	
	BufferedImage sprite;
	
	public PoisonTower(int x, int y, ID id, Spritesheet ss, int radius) {
		super(x, y, id, ss, radius);
		this.attackRate = 60;
		
		sprite = ss.grabImage(0, 0, 64, 64);
	}

	@Override
	public int getTowerType() {
		return 3;
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(sprite, (int) x, (int) y, null);
		
	}
	

}
