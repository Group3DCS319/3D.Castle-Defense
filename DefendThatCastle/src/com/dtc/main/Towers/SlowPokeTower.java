package com.dtc.main.Towers;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.dtc.main.Handler;
import com.dtc.main.ID;
import com.dtc.main.Spritesheet;

public class SlowPokeTower extends BasicTower {
	
	protected BufferedImage sprite;
	
	public SlowPokeTower(int x, int y, ID id, Spritesheet ss, int radius) {
		super(x, y, id, ss, radius);
		
		this.setRadius(100);
		
		this.attackRate = 60;
		sprite = ss.grabImage(0, 0, 64, 64);
	}

	@Override
	public int getTowerType() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(sprite, (int) x, (int) y, null);
		g.drawRect((int) x, (int) y, 64, 64);
		// TODO Auto-generated method stub
		
	}
	

}
