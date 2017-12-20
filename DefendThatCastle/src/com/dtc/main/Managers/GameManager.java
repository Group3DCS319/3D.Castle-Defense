package com.dtc.main.Managers;

import java.util.ArrayList;

import com.dtc.main.BasicCreep;
import com.dtc.main.HUD;
import com.dtc.main.Handler;
import com.dtc.main.ID;
import com.dtc.main.InputHandler;
import com.dtc.main.Spritesheet;
import com.dtc.main.Bullets.BasicBullet;
import com.dtc.main.Bullets.NormalBullet;
import com.dtc.main.Bullets.PoisonBullet;
import com.dtc.main.Bullets.SlowBullet;
import com.dtc.main.Towers.BasicTower;

public class GameManager {
	
	protected ArrayList<BasicCreep> creepList;
	protected ArrayList<BasicTower> towerList;
	protected Handler handler;
	protected HUD hud;
	protected ArrayList<BasicBullet> bulletList;
	protected CreepManager creepManager;
	protected TowerManager towerManager;
	protected InputHandler inputHandler;
	protected TileManager tileManager;
	protected Spritesheet ss;
	protected LevelManager levelManager;
	protected PlayerManager playerManager;

	public GameManager( CreepManager creepManager, TowerManager towerManager, ArrayList<BasicBullet> bulletList, Handler handler, InputHandler inputHandler, HUD hud, TileManager tileManager, Spritesheet ss, PlayerManager playerManager ) {
		this.creepManager = creepManager;
		this.bulletList = bulletList;
		this.handler = handler;
		this.towerManager = towerManager;
		this.inputHandler = inputHandler;
		this.hud = hud;
		this.tileManager = tileManager;
		this.ss = ss;
		this.levelManager = new LevelManager(this);
		this.playerManager = playerManager;
		this.creepManager.setPlayerManager(playerManager);
		
	}
	
	public void addTower(int gridX, int gridY, int type) {
		
		if(!tileManager.isBuildableTile(gridX, gridY) || !playerManager.hasEnoughGold(type))	
			return;
		
		towerManager.addTower(gridX*64, gridY*64, type);
		playerManager.spendGold(type);
	}
	
	public void addCreep(int type) {
		
		creepManager.addToWave( new BasicCreep((int)tileManager.getRoute().get(0).getX(), (int) tileManager.getRoute().get(0).getY(), ID.Creep, new Spritesheet(ss, 5, 16, 64, 64), tileManager.getRoute()));
		
	}
	
	public void tick() {
		
		hud.setWave(levelManager.currentWave);
		hud.setGold(playerManager.getGold());
		hud.setHP(playerManager.HP_current);
		
		if(creepManager.waveList.size() == 0) {
			levelManager.commenceWave();
		}
		
		creepManager.tick();
		
		
		
		
		if( hud.getChoice() != -1 && inputHandler.getCoord().getX() < 15) {
			
			addTower((int) inputHandler.getCoord().getX(), (int)inputHandler.getCoord().getY(), hud.getChoice()+1);
			hud.setChoice(-1);
		}
		
		for( BasicTower i : towerManager.towerList ) {

			BasicCreep closestCreep = creepManager.closestCreep(i.getX(), i.getY(), i.getRadius() + 32);
			
			if(closestCreep != null) {
					
					if(i.attackCreep(closestCreep)) {
						
						BasicBullet b;

						switch(i.getTowerType()) {
							case(1):
								b = new NormalBullet(i.getX(), i.getY(), ID.Bullet, null, closestCreep); break;
							case(2):
								b = new SlowBullet(i.getX(), i.getY(), ID.Bullet, null, closestCreep); break;
							case(3):
								b = new PoisonBullet(i.getX(), i.getY(), ID.Bullet, null, closestCreep); break;
							default:
								b = new NormalBullet(i.getX(), i.getY(), ID.Bullet, null, closestCreep); break;
						}
										
								
						bulletList.add(b);
						handler.addObject(b);
						
					}
				}
			
		}
		
		for(int i = 0 ; i < bulletList.size(); i++) {
			
			BasicBullet b = bulletList.get(i);
			
			if(b.getTarget().bulletHit(b)) {
				
				System.out.println("Bullet Hit, health left: " + b.getTarget().getHitPoint());
				
				bulletList.remove(b);
				handler.removeObject(b);
				
			}
		}
		
		creepManager.HPCheck();
		
	}
	
}
