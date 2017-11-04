import javax.swing.*; 
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Credits extends JFrame{
  //JFrame frame ;
  private static final int WIDTH = 300;
  private static final int HEIGHT = 400;
  public Credits (){ 
    //frame = new JFrame();
    JOptionPane.showMessageDialog(this,
                "This game was created by Team 3D.\n If you have any suggestions on how "+
                "to\n improve the game please feel free\n to contact us :)\n \n castledefenseTeam3d@gmail.com", "Credits",
                JOptionPane.INFORMATION_MESSAGE, null);
    configure();
  }
  private void configure() {
    /*this.setSize(WIDTH, HEIGHT);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationByPlatform(true);
    this.setVisible(true);*/
  }
}