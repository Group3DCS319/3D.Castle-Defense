//package model;

//import map.TileMap;

import java.io.Serializable;

/**
 * A product of mehmetcc (Mehmet Can Altuntas)
 */
public class Game implements Serializable {
  
  // game components
  private TileMap map;
  private static final int MAP_SIZE = 32; // 32*32, can be changed
  
  private int currentCash;
  private int startingCash;
  
  private static final int MAX_LEVELS = 3; // ToDo : change this after deciding the final game logic
  private int currentLevel; // ToDo : change this after deciding the final game logic
  
  private static final int MAX_LIVES = 5; // ToDo : change this after deciding the final game logic
  
  private int currentPoints;
  
  // ToDo : uncomment these after writing the unfinished classes
  // private TowerManager towerManager;
  // private WaveManager waveManager;
  // private ConsumableManager consumableManager;
  
  
  public Game() {
    map = new TileMap(MAP_SIZE); // to access the two-dimensional Tile array,
    // call the getter method for the map
    
    // ToDo : initialize everything else
    
  }
  
  public static int getMAP_SIZE() { return MAP_SIZE; }
}
