package com.dtc.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import com.dtc.main.Bullets.BasicBullet;
import com.dtc.main.Bullets.PoisonBullet;

public class BasicCreep extends GameObject {
	
	protected ArrayList<Point> destinations;
	protected int destinationIndex = 0, hitPoint, maxHitPoint = 100; 
	protected Rectangle hitbox;
	protected float speed, minSpeed = 0.3f, maxSpeed = 2f;
	protected int slowTimer = 0, poisonTimer = 0;
	protected float poisonPower = 0;
	
	public BasicCreep(int x, int y, ID id, Spritesheet ss, ArrayList<Point> dest) {
		super(x, y, id, ss);
		
		hitbox = new Rectangle(0,0,1,1);
		destinations = dest;
		hitPoint = maxHitPoint;
		speed = maxSpeed;
		
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void tick() {

		x+= velX;
		y+= velY;
		
		if(slowTimer <= 0) {
			speed = maxSpeed;
			slowTimer = 0;
		}
		else if(slowTimer > 0)
			slowTimer--;
		
		if(poisonTimer <= 0) {
			
		} else {
			poisonTimer--;
			hitPoint -= poisonPower;
		}
		
		float destX = (int) destinations.get(destinationIndex).getX();
		float destY = (int) destinations.get(destinationIndex).getY();
		
		if( Math.abs(destX - x) < 1 && Math.abs(destY - y) < 1 && destinationIndex < destinations.size() - 1) { 
			destinationIndex++;
			
			destX = (int) destinations.get(destinationIndex).getX();
			destY = (int) destinations.get(destinationIndex).getY();
		
		}
		
		float diffX = x - destX;
		float diffY = y - destY;
		float distance = (float) Point.distance(x, y, destX, destY);
		
		velX = (float) ((-speed)/distance * diffX);
		velY = (float) ((-speed)/distance * diffY);
				
		
	}
	
	public boolean bulletHit(BasicBullet bullet) {
		if(bullet == null) 
			return false;
		
		hitbox = new Rectangle((int) x + 16, (int) y + 16, 32, 32);
		if(hitbox.contains(bullet.getX(), bullet.getY())) {
			
			switch(bullet.getType()) {
			case(1):
				break;
			case(2):
				speed = Math.max(minSpeed, speed * 0.5f);
				slowTimer = 120;
				break;
			case(3):
				poisonTimer = 60;
				poisonPower = ((PoisonBullet) bullet).getPoisonPower();
				break;
				
			}
			
			hitPoint -= bullet.getPower();
			return true;
		}
		
		return false;

	}

	public void render(Graphics g) {
		
		
		g.drawImage(ss.grabImage(0, 0, 64, 64), (int) x, (int) y, null);
		
		g.setColor(Color.WHITE);
		g.drawRect((int)x+12, (int)y, 40, 3);
		
		g.setColor(Color.RED);
		g.drawLine((int)x+12, (int)y, (int) x +12  + 40*hitPoint/maxHitPoint, (int)y);

	}

	public int getHitPoint() {
		
		return hitPoint;
	}

}
