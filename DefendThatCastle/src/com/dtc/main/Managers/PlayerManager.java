package com.dtc.main.Managers;

public class PlayerManager {
	
	protected int gold, HP_current = 0, HP_max = 5;
	
	public PlayerManager() {
		gold = 150;
		HP_current = 5;
		HP_max = 5;
	}
	
	public Boolean hasEnoughGold(int towerType) {
		switch(towerType) {
		case(1) : return gold >= 50;
		case(2) : return gold >= 100;
		case(3) : return gold >= 100;
		default : return gold >= 50; 
		}
	}
	
	public void earnGold(int gold) {
		this.gold += gold; 
	}
	
	public void spendGold(int towerType) { 
		switch(towerType) {
		case(1) : gold -= 50; break;
		case(2) : gold -= 100; break;
		case(3) : gold -= 100; break;
		default : gold -= 50; break;
		}
	}
	
	public int getGold() {
		return this.gold;
	}
	
	public void getDamage() {
		HP_current--;
	}
	
	public Boolean hasLost() {
		return HP_current<=0;
	}
}
