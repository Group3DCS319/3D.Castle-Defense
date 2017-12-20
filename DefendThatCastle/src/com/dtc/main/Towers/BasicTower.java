package com.dtc.main.Towers;

import java.awt.Graphics;

import com.dtc.main.BasicCreep;
import com.dtc.main.GameObject;
import com.dtc.main.ID;
import com.dtc.main.Spritesheet;
import com.dtc.main.Bullets.BasicBullet;

public abstract class BasicTower extends GameObject {
	
	protected Boolean enabled = true;
	private int radius;  
	protected int attackRate;
	protected int attackTimer;
	protected BasicBullet bulletType;
	
	public BasicTower(int x, int y, ID id, Spritesheet ss, int radius) {
		super(x, y, id, ss);
		
		this.x = 64 * ((int) x/64) ;
		this.y = 64 * ((int) y/64) ;
		this.setRadius(radius);
		
		attackTimer = 0;
		
		
	}

	public void tick() {
		
		attackTimer++;
		attackTimer = Math.min(attackTimer, attackRate);
	}

	public abstract void render(Graphics g);
	
	public boolean attackCreep(BasicCreep tempCreep) {
		
		if(!enabled) 
			return false;
		
		if(attackTimer >= attackRate) {
			attackTimer = 0;
			
			return true;
		}
		return false;
		
	}

	public abstract int getTowerType();

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
}
