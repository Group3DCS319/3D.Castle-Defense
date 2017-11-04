import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class KeyHandler implements KeyListener{
  
  private Play screen;
  private Play.KeyTyped keyTyped;
  
  public KeyHandler(Play screen){
    this.screen = screen;
    
    this.keyTyped = this.screen.new KeyTyped();
    
  }
  
  public void keyPressed(KeyEvent e){
    int keyCode = e.getKeyCode();
    System.out.println(keyCode);
    
    if (keyCode == 27){
      this.keyTyped.keyESC();
      System.exit(0);
    }
  }
  public void keyReleased(KeyEvent e){}
  public void keyTyped(KeyEvent e){}

}