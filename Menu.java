import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame{
  
  private KeyHandler keyhandler;
  private JButton playButton;
  private JButton resumeButton;
  private JButton scoresButton;
  private JButton storeButton;
  private JButton optionsButton;
  private JButton creditsButton;
  
  public static void main(String [] args){
    new Menu();
  }
  
  public Menu(){
    //JFrame frame =
    new JFrame();
    
    this.setExtendedState(MAXIMIZED_BOTH);
    this.setUndecorated(true);
    this.setTitle("Castle Defense");
    this.setResizable(false);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setVisible(true);
    this.setLocationRelativeTo(null);
    
    JLabel background=new JLabel(new ImageIcon(("C:\\Users\\Xhoana Aliu\\Desktop\\New Folder\\castle.jpg")));

    this.add(background);

    background.setLayout(new FlowLayout());

    
    Play screen = new Play(this);
    Scores scores = new Scores(this);
    TowerStore store = new TowerStore(this);
    Options options = new Options(this);
    Credits credits = new Credits(this);
    
    keyhandler = new KeyHandler(screen);
    
    playButton = new JButton("Play");
    resumeButton = new JButton("Resume");
    scoresButton = new JButton("High Scores");
    storeButton = new JButton("Tower Store");
    optionsButton = new JButton("Options");
    creditsButton = new JButton("Credits");
    setButtonsVisibileInTheStart();
    
    playButton.setBounds(575,170,200,70);
    resumeButton.setBounds(575,250,200,70);
    scoresButton.setBounds(575,330,200,70);
    storeButton.setBounds(575,420,200,70);
    optionsButton.setBounds(575,500,200,70);
    creditsButton.setBounds(575,580,200,70);
    
    //this.setLayout(new FlowLayout());
    
    //this.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Xhoana Aliu\\Desktop\\User Interface Subsystem\\castle.jpg")));
    
    this.add(playButton);
    this.add(resumeButton);
    this.add(scoresButton);
    this.add(storeButton);
    this.add(optionsButton);
    this.add(creditsButton);
    
    playButton.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent event)
      {       
        Menu.this.setButtonsVisibility();
        
        Menu.this.add(screen);
      }
    });
    
    resumeButton.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent event)
      {
        Menu.this.setButtonsVisibility();
        
        Menu.this.add(screen);
      }
    });
    
    scoresButton.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent event)
      {
        Menu.this.setButtonsVisibility();
        
        Menu.this.add(scores);
      }
    });
    
    storeButton.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent event)
      {
        Menu.this.setButtonsVisibility();
        
        Menu.this.add(store);
      }
    });
    
    optionsButton.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent event)
      {
        Menu.this.setButtonsVisibility();
        
        Menu.this.add(options);
      }
    });
    
    creditsButton.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent event)
      {
        Menu.this.setButtonsVisibility();
        
        Menu.this.add(credits);
      }
    });
  }
  
  public void setButtonsVisibility(){
    playButton.setVisible(false);
    resumeButton.setVisible(false);
    scoresButton.setVisible(false);
    storeButton.setVisible(false);
    optionsButton.setVisible(false);
    creditsButton.setVisible(false);
  }
  
   public void setButtonsVisibileInTheStart(){
    playButton.setVisible(true);
    resumeButton.setVisible(true);
    scoresButton.setVisible(true);
    storeButton.setVisible(true);
    optionsButton.setVisible(true);
    creditsButton.setVisible(true);
  }
}