package com.dtc.main.Managers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.dtc.main.Spritesheet;

public class TileManager {
	
	Spritesheet ss;
	ArrayList<Point> p;
	BufferedImage tile, grass;
	
	
	int level[][] = { 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0} };
	
	public TileManager(Spritesheet ss) {
		this.ss = ss;
		
		tile  = ss.grabImage(1, 4, 64, 64);
		grass = ss.grabImage(1, 1, 64, 64);
		
		p = new ArrayList<Point>();
		p.add(new Point(0, 64*2));
		p.add(new Point(64*6,64*2));
		p.add(new Point(64*6,64*9));
		p.add(new Point(64*10,64*9));
		p.add(new Point(64*10,64*5));
		p.add(new Point(64*16,64*5));
	}
	
	public ArrayList<Point> getRoute() {
		
		return p;
	}
	
	public void render(Graphics g) {
	
		
		for(int i = 0; i < 20; i++) {
			for(int j = 0; j < 10 ; j++) {
				
				switch(level[j][i]) {
				
				case(0): g.drawImage( grass, i*64, j*64, null); break;
				case(1): g.drawImage( tile, i*64, j*64,  null); break;
				
				}
				g.setColor(Color.black);
				
				g.drawRect(i*64, j*64, 64, 64);
			}
		}
		
	}
	
	public Boolean isBuildableTile(int x, int y) {
		return (level[y][x] == 0); 
	}
	

}
