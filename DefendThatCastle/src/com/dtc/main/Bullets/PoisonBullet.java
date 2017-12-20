package com.dtc.main.Bullets;

import java.awt.Color;
import java.awt.Graphics;

import com.dtc.main.BasicCreep;
import com.dtc.main.ID;
import com.dtc.main.Spritesheet;

public class PoisonBullet extends BasicBullet {
	
	protected float poisonPower;
	
	public PoisonBullet(float x, float y, ID id, Spritesheet ss, BasicCreep tempCreep) {
		super(x, y, id, ss, tempCreep);
		this.power = 20;
		this.poisonPower = 0.05f; 
	}
	
	public float getPoisonPower() {
		return poisonPower;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillOval((int) x - 3, (int) y - 3, 6, 6);
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 3;
	}
	
}
