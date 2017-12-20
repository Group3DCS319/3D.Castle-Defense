package com.dtc.main.Bullets;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import com.dtc.main.BasicCreep;
import com.dtc.main.GameObject;
import com.dtc.main.ID;
import com.dtc.main.Spritesheet;

public class NormalBullet extends BasicBullet {

	public NormalBullet(float x, float y, ID id, Spritesheet ss, BasicCreep tempCreep) {
		super(x, y, id, ss, tempCreep);
		// TODO Auto-generated constructor stub
		this.power = 50;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval((int) x - 3, (int) y - 3, 6, 6);
	}

	@Override
	public int getType() {
		return 1;
	}
	
}