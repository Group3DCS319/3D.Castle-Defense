package com.dtc.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.dtc.main.Bullets.BasicBullet;
import com.dtc.main.Managers.CreepManager;
import com.dtc.main.Managers.GameManager;
import com.dtc.main.Managers.PlayerManager;
import com.dtc.main.Managers.TileManager;
import com.dtc.main.Managers.TowerManager;

public class Game extends Canvas implements Runnable {
	
	public static final int WIDTH = 1280, HEIGHT = 670;
	
	private static final long serialVersionUID = -7095744903645814474L;
	
	private Thread thread;
	private boolean running = true;
	
	protected ArrayList<Point> route;
	protected ArrayList<BasicBullet> bulletList;
	protected TileManager tileManager;
	
	private BufferedImage spritesheet = null;
	private Spritesheet ss;
	
	private Handler handler;
	private HUD hud;
	protected Menu menu;
	
	protected InputHandler inputHandler;
	private CreepManager creepManager;
	private GameManager gameManager;
	protected TowerManager towerManager;
	private PlayerManager playerManager;
	protected SpawnPoint spawnPoint;
	
	public enum STATE {
		MENU,
		GAME,
		ENDSCREEN
	};
	
	public STATE gameState = STATE.MENU;
	
	public Game() {
		
		
		
		handler = new Handler();
		
		route  = new ArrayList<Point>();
		bulletList = new ArrayList<BasicBullet>();
		inputHandler = new InputHandler();
		spawnPoint = new SpawnPoint(100, 100, ID.SpawnPoint, null);
		
		BufferedImageLoader loader = new BufferedImageLoader();
		
		spritesheet = loader.loadImage("/tilesheet.png");
		ss = new Spritesheet(spritesheet);
		

		new Window(WIDTH, HEIGHT, "Defend that Castle!", this);
		
		menu = new Menu(this);
		this.addMouseListener(menu);		
		this.addMouseListener(inputHandler);
		
		
		towerManager = new TowerManager(handler, ss);
		tileManager = new TileManager(ss);
		creepManager = new CreepManager(handler, tileManager.getRoute().get(0));
		playerManager = new PlayerManager();
		
		hud = new HUD(ss, inputHandler);
		
		gameManager = new GameManager( creepManager , towerManager, bulletList, handler, inputHandler, hud, tileManager, ss, playerManager);
		

	}
	public synchronized void start() {
		
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		
		long lastTime = System.nanoTime();
	    double amountOfTicks = 60.0;
	    double ns = 1000000000 / amountOfTicks;
	    double delta = 0;
	    long timer = System.currentTimeMillis();
	    int frames = 0;
	    while(running)
	    {
	    	long now = System.nanoTime();
	        delta += (now - lastTime) / ns;
	        lastTime = now;
	        while(delta >=1) {
	        	tick();
	            delta--;
	        }
	        
	        if(running)
	        	render();
	        
	        frames++;
	                            
	        if(System.currentTimeMillis() - timer > 1000)
	        {
	        	timer += 1000;
	            System.out.println("FPS: "+ frames);
	            frames = 0;
	        }
	    }
	    
	    stop();
	    
	}
	
	private void tick() {
		
		if(gameState == STATE.GAME) {
			handler.tick();
			hud.tick();
			gameManager.tick();
		}
		else if(gameState == STATE.MENU) {
			menu.tick();
		}
	}
	
	private void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		//repaint();
		
		
		
		if(gameState == STATE.GAME) {
			tileManager.render(g);
			handler.render(g);
			hud.render(g);
		}
		else if(gameState == STATE.MENU) {
			menu.render(g);
		}
		g.dispose();
		bs.show();
		
		
	}
	public static void main(String args[]) {
		new Game();
	}
}
