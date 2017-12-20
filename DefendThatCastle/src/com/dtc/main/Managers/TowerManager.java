package com.dtc.main.Managers;

import java.util.ArrayList;

import com.dtc.main.Handler;
import com.dtc.main.ID;
import com.dtc.main.Spritesheet;
import com.dtc.main.Towers.BasicTower;
import com.dtc.main.Towers.NormalTower;
import com.dtc.main.Towers.PoisonTower;
import com.dtc.main.Towers.SlowPokeTower;

public class TowerManager {
	
	protected ArrayList<BasicTower> towerList;
	protected Handler handler;
	protected Spritesheet ss;
	
	public TowerManager(Handler handler, Spritesheet ss) {
		this.towerList = new ArrayList<BasicTower>();
		this.handler = handler;
		this.ss = ss;
	}
	
	public void addTower( int x, int y, int type) {
		
		for(int i = 0 ; i < towerList.size(); i++) {
			if(towerList.get(i).getX() == x && towerList.get(i).getY() == y)
				return;
		}
		BasicTower t = null;	
		
		switch(type) {
		case(1): t = new NormalTower  (x, y, ID.Tower, new Spritesheet(ss, 7, 22, 64, 64), 100); break;
		case(2): t = new PoisonTower  (x, y, ID.Tower, new Spritesheet(ss, 7, 21, 64, 64), 100); break;
		case(3): t = new SlowPokeTower(x, y, ID.Tower, new Spritesheet(ss, 7, 20, 64, 64), 100); break;
		}
		
		towerList.add(t);
		handler.addObject(t);;
	}
}
