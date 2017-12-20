package com.dtc.main.Managers;

import java.awt.Point;
import java.util.ArrayList;

import com.dtc.main.BasicCreep;
import com.dtc.main.Handler;

public class CreepManager {
	
	protected Handler handler;
	protected ArrayList<BasicCreep> creepList = null, waveList = null;
	protected int spawnTimer = 0, creepListIndex = 0;
	protected Point spawnPoint;
	protected boolean waveCommencing = false;
	protected PlayerManager playerManager;
	
	public CreepManager(Handler handler, Point point ) {
		this.handler = handler;
		this.creepList = new ArrayList<BasicCreep>();
		this.waveList = new ArrayList<BasicCreep>();
		this.spawnPoint = point;
		this.waveCommencing = false;
	}
	
	public void addToWave( BasicCreep creep ) {
		
		creep.setX( (int) spawnPoint.getX());
		creep.setY( (int) spawnPoint.getY());
		creepList.add(creep);
		
	}
	
	public void startWave() {

		waveCommencing = true;
		creepListIndex = 0;
			
	}
	
	public void tick() {
		
		if(creepList.size() == 0) {
			waveCommencing = false;
			creepListIndex = 0;
		}
		
		if(waveCommencing) {
			
			if(spawnTimer > 60) {
				BasicCreep b = creepList.get(0);
				waveList.add(b);
				handler.addObject(b);
				creepList.remove(0);
				spawnTimer = 0;
			
			}
			else 
				spawnTimer++;
			
		}

	}
	
	public BasicCreep closestCreep( float x, float y, float dist) {
		
		BasicCreep b = null;
		float closestCreepDistance = dist;
		for( BasicCreep tempCreep : waveList ) {
			
			if(Point.distance(tempCreep.getX(), tempCreep.getY(), x, y) <= closestCreepDistance) {
				
				closestCreepDistance = (float) Point.distance(tempCreep.getX(), tempCreep.getY(), x, y);
				b = tempCreep;
				
			}
		}
		
		return b;
		
	}
	
	public void remove( BasicCreep creep) {
		
		waveList.remove(creep);
		playerManager.earnGold(25);
		
	}
	
	public void setPlayerManager(PlayerManager playerManager) {
		this.playerManager = playerManager;
	}

	public void HPCheck() {
		
		for( int i = 0; i < waveList.size(); i++) {
			
			if( waveList.get(i).getHitPoint() <= 0) {
				handler.removeObject(waveList.get(i));
				remove(waveList.get(i));
				i--;
			}
			else if(!isInsideBoundaries(waveList.get(i).getX(), waveList.get(i).getY(), 960, 640) ) {
				handler.removeObject(waveList.get(i));
				remove(waveList.get(i));
				i--;
				playerManager.getDamage();
			}
		}
	}
	
	public Boolean isInsideBoundaries(float x, float y, float xx, float yy) {
		return (x >= 0 && x <= xx && y >= 0 && y <= yy);
	}
	
}
