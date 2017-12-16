import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Button.*;

public class Store extends JFrame implements ActionListener {
  
  //variables
  int width = 1;
  int height = 4;
  int size = height*width;
  JButton [] towerTypes;
  JButton mainMenuButton; 
  ImageIcon basicTower = new ImageIcon(new ImageIcon("BasicTower.jpg").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
  ImageIcon explosiveTower = new ImageIcon(new ImageIcon("ExplosiveTower.jpg").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
  ImageIcon iceTower = new ImageIcon(new ImageIcon("IceTower.jpg").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
  ImageIcon poisonTower = new ImageIcon(new ImageIcon("PoisonTower.jpg").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
  JLabel storeTitle;
  JPanel buttonPanel, forLabel, mainMenu;
  private static final int WIDTH = 300;
  private static final int HEIGHT = 400;
  
  //constructor
  public Store() 
  {
    setLayout( new BorderLayout ());
    setPreferredSize( new Dimension(500, 500));
    
    //create the panel for displaying the attempts
    forLabel = new JPanel();
    storeTitle = new JLabel ( "Store");
    
    forLabel.add(storeTitle);
    add(forLabel, "North");
    
    mainMenuButton = new JButton("Return to Menu");
    mainMenu = new JPanel();
    mainMenu.setPreferredSize(new Dimension (100,100));
    mainMenu.add(mainMenuButton);
    mainMenuButton.addActionListener(this);
    
    //initialize the array 
    buttonPanel = new JPanel(new GridLayout(5, 5, 10, 10));
    towerTypes = new JButton[size];
    towerTypes[0] = new JButton(basicTower);
    towerTypes[1] = new JButton(explosiveTower);
    towerTypes[2] = new JButton(iceTower);
    towerTypes[3] = new JButton(poisonTower);
    for ( int x = 0; x < towerTypes.length; x++)
    {
      towerTypes[x].setPreferredSize( new Dimension ( 100, 100) );
      buttonPanel.add(towerTypes[x]);
      towerTypes[x].addActionListener(this);  
      x++;
    }
    //added all the buttons to the panel
    mainMenuButton.addActionListener(this);
    add(mainMenuButton, "South");
    add(buttonPanel, "Center");
    configure();
  }

  private void configure() {
     this.setSize(WIDTH, HEIGHT);
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     this.setLocationByPlatform(true);
     this.setVisible(true);
  }

  //when pressing a button
  public void actionPerformed( ActionEvent e)
  {
    if(e.getSource()== mainMenuButton)
    {
      Store.this.dispose(); 
      new OpeningView();
      Store.this.dispose(); 
    }
    //when the user finds the correct button
    else if (e.getSource() == towerTypes[0]) 
    {
      JOptionPane.showMessageDialog(this,
                                  "You have selected to buy the basic tower. This tower will "+
                                  "\n help you destroy the creeps that want to invade your castle.\n", "Basic Tower",
                                  JOptionPane.INFORMATION_MESSAGE, null);
    }
    /*else
    {
    counter = counter + 1;    
    toPrint.setText("Attempts:        " + counter+ "  "); 
    ((JButton)e.getSource()).setEnabled(false);
    }*/
  }
}


