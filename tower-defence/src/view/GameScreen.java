//package view;

//import filemodule.*;
//import model.Game;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * A product of mecha
 */
public class GameScreen extends JFrame {
  
  private static final int WIDTH = 600;
  private static final int HEIGHT = 800;
  
  
  // game logic
  private Game game = new Game();
  
  // swing components
  private JPanel mapPanel;
  private BorderLayout layout;
  
  // constructor
  public GameScreen() {
    initializeGUI();
    configure();
  }
  
  // methods
  
  private void initializeGUI() {
    createMenuBar();
    
    layout = new BorderLayout();
    
    mapPanel = new MapPanel();
    this.add(mapPanel, BorderLayout.CENTER);
    
  }
  
  private void configure() {
    this.setSize(WIDTH, HEIGHT);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationByPlatform(true);
    this.setVisible(true);
  }
  
  private void createMenuBar() {
    JMenuBar bar = new JMenuBar();
    
    JMenu file = new JMenu("File");
    
    JMenuItem newGame = new JMenuItem("New Game");
    newGame.addActionListener(new NewGameListener());
    
    JMenuItem openGame = new JMenuItem("Open Game");
    openGame.addActionListener(new OpenGameListener());
    
    JMenuItem saveGame = new JMenuItem("Save Game");
    saveGame.addActionListener(new SaveGameListener());
    
    file.add(newGame);
    file.add(openGame);
    file.add(saveGame);
    
    bar.add(file);
    
    this.setJMenuBar(bar);
  }
  
  
  // listeners
  private class OpenGameListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
      int val = chooser.showOpenDialog(null);
      
      if (val == JFileChooser.APPROVE_OPTION) {
        File selected = chooser.getSelectedFile();
        In in = new In(selected);
        // ToDo : what happens after opening a new game
      }
      else if (val == JFileChooser.ERROR_OPTION) {
        JOptionPane.showMessageDialog(GameScreen.this , "Cannot resolve the file");
      }
    }
  }
  
  private class NewGameListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      // ToDo
    }
  }
  
  private class SaveGameListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
      chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
      
      int val = chooser.showSaveDialog(null);
      
      if (val == JFileChooser.APPROVE_OPTION) {
        File saveFile = chooser.getSelectedFile();
        Out out = new Out(saveFile, GameScreen.this.game);
      }
    }
  }
}
