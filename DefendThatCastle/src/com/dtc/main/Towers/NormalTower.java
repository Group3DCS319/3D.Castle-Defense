package com.dtc.main.Towers;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.dtc.main.ID;
import com.dtc.main.Spritesheet;

public class NormalTower extends BasicTower {
	
	protected BufferedImage sprite;

	public NormalTower(int x, int y, ID id, Spritesheet ss, int radius) {
		super(x, y, id, ss, radius);
		
		this.setRadius(100);
		this.attackRate = 60;
		this.sprite = ss.grabImage(0, 0, 64, 64);
	}
	
	@Override
	public int getTowerType() {
		return 1;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(sprite, (int) x, (int) y, null);
		
	}
}
