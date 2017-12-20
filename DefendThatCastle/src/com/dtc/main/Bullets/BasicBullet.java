package com.dtc.main.Bullets;

import java.awt.Graphics;
import java.awt.Point;

import com.dtc.main.BasicCreep;
import com.dtc.main.GameObject;
import com.dtc.main.ID;
import com.dtc.main.Spritesheet;

public abstract class BasicBullet extends GameObject {
	
	private BasicCreep target;
	protected int power;
	
	public BasicBullet(float x, float y, ID id, Spritesheet ss, BasicCreep tempCreep) {
		super(x, y, id, ss);
		setX((int) (x + 32));
		setY((int) (y + 32));
		setTarget(tempCreep);
	}
	

	public void tick() {
		
		x += velX;
		y += velY;
		float tX = getTarget().getX() + 32;
		float tY = getTarget().getY() + 32;
		
		float diffX = x - tX ;
		float diffY = y - tY ;
		float distance = (float) Point.distance(x, y, tX, tY);
		
		velX = (float) ((-5.0)/distance * diffX);
		velY = (float) ((-5.0)/distance * diffY);
		
	}

	public abstract void render(Graphics g);


	public int getPower() {
		return power;
	}


	public BasicCreep getTarget() {
		return target;
	}


	public void setTarget(BasicCreep target) {
		this.target = target;
	}


	public abstract int getType();
}
