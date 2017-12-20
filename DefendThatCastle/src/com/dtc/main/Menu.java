package com.dtc.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.dtc.main.Game.STATE;

public class Menu extends MouseAdapter {
	
	private Game game;
	
	public Menu( Game game ) {
		this.game = game;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		if(mouseOver(mx, my, 500, 200, 200,50))
			game.gameState = STATE.GAME;
		
		if(mouseOver(mx, my, 500, 320, 200,50))
			System.exit(0);
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width && my > y && my < y + height) {
			return true;
		}
		return false;
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	public void tick() {
		
	}
	public void render(Graphics g) {
		
		Font fnt = new Font("arial", 1, 30);
		Font fnt2 = new Font("arial", 1, 20);
		
		
		g.setFont(fnt);
		g.drawString("Quick, Defend That Castle!", 450, 150);
		
		g.setFont(fnt2);
		g.setColor(Color.black);		
		g.drawString("Start Game", 540, 230);
		g.drawRect(500, 200, 200, 50);
		
		g.drawString("Unfinished Options", 540, 290);
		g.drawRect(500, 260, 200, 50);
		
		g.drawString("Exit", 540, 350);
		g.drawRect(500, 320, 200, 50);
	}
	

}
