package com.dtc.main.Bullets;

import java.awt.Color;
import java.awt.Graphics;

import com.dtc.main.BasicCreep;
import com.dtc.main.ID;
import com.dtc.main.Spritesheet;

public class SlowBullet extends BasicBullet {

	public SlowBullet(float x, float y, ID id, Spritesheet ss, BasicCreep tempCreep) {
		super(x, y, id, ss, tempCreep);

		
		this.power=25;
	}


	@Override
	public void render(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillOval((int) x - 3, (int) y - 3, 6, 6);
	}


	@Override
	public int getType() {
		return 2;
	}

}
