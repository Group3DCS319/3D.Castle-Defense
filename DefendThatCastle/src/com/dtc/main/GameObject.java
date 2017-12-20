package com.dtc.main;

import java.awt.Graphics;

public abstract class GameObject {
	
	protected float x, y;
	protected ID id;
	protected float velX, velY;
	protected Spritesheet ss;
	
	public GameObject( float x, float y, ID id, Spritesheet ss) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.ss = ss;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public float getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public float getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}
}
