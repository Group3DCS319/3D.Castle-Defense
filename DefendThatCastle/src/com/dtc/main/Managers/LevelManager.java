package com.dtc.main.Managers;


public class LevelManager {
	
	int currentWave = 0, maxWave;
	private GameManager gameManager;
	int waveTimer;
	
	public LevelManager(GameManager gameManager) {
		currentWave = 0;
		waveTimer = 0;
		this.gameManager = gameManager;
	}
	
	public void commenceWave() {
		
		
		waveTimer++;
		
		if(waveTimer < 60)
			return;
		
		if(!gameManager.creepManager.creepList.isEmpty())
			return;
			
		for(int i = 0 ; i < currentWave*10 + 5; i++)
			gameManager.addCreep(1);
		
		gameManager.creepManager.startWave();	
		
		currentWave++;
		
		waveTimer = 0;
	}
}
