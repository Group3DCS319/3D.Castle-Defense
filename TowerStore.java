import javax.swing.*; 
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class TowerStore extends JPanel implements Runnable{
  
  public Thread thread = new Thread(this);
  public Menu frame;
  
  private int fps = 0;
  public boolean running = false;
  
  public TowerStore (Menu frame){ 
    this.frame = frame;
    
    thread.start();
  }
  
  @Override
  public void paintComponent(Graphics g){
    g.clearRect(0,0,this.frame.getWidth(), this.frame.getHeight());
    
    g.drawString(fps+"", 10, 10);
    g.drawString("This is Tower Store", 600, 600);
  }
  
  public void run(){
    System.out.println("Success");
    
    long lastFrame = System.currentTimeMillis();
    int frames = 0;
     
    running = true;
    
    while (running){
      repaint();
      
      frames++;
      
      if (System.currentTimeMillis() - 1000 >= lastFrame){
        fps = frames;
        frames = 0;   
        lastFrame = System.currentTimeMillis();
      }
      
      try {
        Thread.sleep(2);
      }catch(InterruptedException e){
        e.printStackTrace();
      }
    }System.exit(0);
  }
 
  public class KeyTyped{
    public void keyESC(){
      running =  false;
    }
  }
}