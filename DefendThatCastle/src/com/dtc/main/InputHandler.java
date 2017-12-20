package com.dtc.main;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InputHandler extends MouseAdapter {
	
	int mx = 0, my = 0;
	
	public InputHandler() {
		
	}
	
	public void mousePressed(MouseEvent e) {
		
		mx = e.getX();
		my = e.getY();
		System.out.println("X: " + (int) (1+mx/64) + ", Y: " + (int)(1+my/64));
		
	}
	
	public Point getCoord() {
		return new Point((int) (mx/64), (int)(my/64));
	}
	
}
