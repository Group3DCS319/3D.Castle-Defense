package view;

import javax.swing.*;
import java.awt.*;

import map.*;
import model.Game;

/**
 * A product of mecha
 */
public class MapPanel extends JPanel {
    // constants
    private static final int MAPSIZE   = Game.getMAP_SIZE();
    private static final int PIXELSIZE = 16;
    private static final int WIDTH     = MAPSIZE * PIXELSIZE;
    private static final int HEIGHT    = MAPSIZE * PIXELSIZE;

    // variables
    private TileMap  map;
    private Tile[][] arrayMap;

    // constructor(s)
    public MapPanel() {
        map = new TileMap(MAPSIZE);
        arrayMap = map.getMap();


        this.setSize(WIDTH, HEIGHT);
    }

    // methods
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int x = 0; x < MAPSIZE; x++) {
            for (int y = 0; y < MAPSIZE; y++) {
                if      (arrayMap[x][y].getType().equals(TileType.GROUND))    g.setColor(Color.ORANGE);
                else if (arrayMap[x][y].getType().equals(TileType.LAKETILE))  g.setColor(Color.BLUE);
                else if (arrayMap[x][y].getType().equals(TileType.GRASSLAND)) g.setColor(Color.GREEN);
                else if (arrayMap[x][y].getType().equals(TileType.ROAD))      g.setColor(Color.BLACK);
                else if (arrayMap[x][y].getType().equals(TileType.BRIDGE))    g.setColor(Color.DARK_GRAY);

                g.fillRect(x * PIXELSIZE, y * PIXELSIZE, PIXELSIZE, PIXELSIZE);
            }
        }
    }

    public TileMap getMap() { return map; }

}
