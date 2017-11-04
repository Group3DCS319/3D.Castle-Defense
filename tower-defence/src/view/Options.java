import javax.swing.*; 
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Options extends JPanel{
  JFrame frame ;
  private static final int WIDTH = 300;
  private static final int HEIGHT = 400;
  public Options (){ 
    frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel label = new JLabel();
    label.setBackground(Color.YELLOW);
    JTextArea text = new JTextArea("        You can change the level here!      ");
    JButton testButton = new JButton("Choose");
    JComboBox combo = new JComboBox(new String[]{"Easy","Normal","Hard"});
    testButton.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent evt){
                  //todo
             }
    });              
    combo.setVisible(true);
    text.setEditable(false);
    panel.add(text);
    panel.add(testButton);
    panel.add(combo);
    panel.add(this, BorderLayout.CENTER);
    //repaint();
    frame.add(panel);
    configure();
    System.out.println("panel addi te creditsi");
  }
  
  private void configure() {
    frame.setSize(WIDTH, HEIGHT);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationByPlatform(true);
    frame.setVisible(true);
  }
}