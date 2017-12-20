package com.dtc.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import com.dtc.main.Towers.BasicTower;
import com.dtc.main.Towers.NormalTower;
import com.dtc.main.Towers.PoisonTower;
import com.dtc.main.Towers.SlowPokeTower;

public class HUD {
	
	ArrayList<BasicTower> showcase;
	
	protected int choice = -1;

	private InputHandler inputHandler;

	private int wave = 0;

	private int gold = 0;
	
	private int hp = 5;

	public HUD(Spritesheet ss, InputHandler inputHandler) {
		
		this.inputHandler = inputHandler;		
		showcase = new ArrayList<BasicTower>();
		
		BasicTower t = new NormalTower(64*16, 64*3, ID.Tower, new Spritesheet(ss, 7, 22, 64, 64), 100);
		t.setEnabled(false);
		
		showcase.add(t);

		t = new PoisonTower(64*16, 64*4, ID.Tower, new Spritesheet(ss, 7, 21, 64, 64), 100);
		t.setEnabled(false);
		
		showcase.add(t);
		
		t = new SlowPokeTower(64*16, 64*5, ID.Tower, new Spritesheet(ss, 7, 20, 64, 64), 100);
		t.setEnabled(false);
		
		showcase.add(t);
		
		
	}
	public void tick() {
		if(inputHandler.getCoord().getX() == 16 && inputHandler.getCoord().getY() <=5 && inputHandler.getCoord().getY() >= 3) {
			choice = (int) (inputHandler.getCoord().getY() - 3);
		}
		
	}
	
	public void setChoice(int choice) {
		this.choice = choice;
	}
	
	public int getChoice() {
		return choice;
	}
	
	public void setGold( int gold ) {
		this.gold = gold;
	}
	
	public void setHP( int HP ) {
		this.hp = HP;
	}
	public void render(Graphics g) {
		
		
		
		g.setColor(Color.ORANGE);
		g.fillRect(1280-320, 0 , 320, 640 );
		
		
		for(BasicTower t : showcase)
			t.render(g);
		
		g.setColor(Color.BLACK);
		g.drawString("50 G", 64*17, 64*4-35 );
		g.drawString("100 G", 64*17, 64*5-35 );
		g.drawString("100 G", 64*17, 64*6-35 );
		g.setColor(Color.black);
		g.drawString("Wave: " + getWave(),960, 110);
		g.drawString("Gold: " + gold, 960, 130);
		g.drawString("HP: "   + hp , 960, 150);
		
		if(choice != -1) {
			g.drawRect(64*16, 64*3 + 64*choice, 64, 64);
		}
	}
	
	public int getWave() {
		return wave;
		
	}
	
	public void setWave(int wave) {
		this.wave = wave;
	}
}
