package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * A product of mecha
 */
public class OpeningView extends JFrame {
    // variables
    private static final int WIDTH = 300;
    private static final int HEIGHT = 400;
    private JButton newGame;
    private JButton openGame;
    private BorderLayout layout;
    private JPanel buttonPanel;

    // constructor
    public OpeningView() {
        super("Castle Defence");
        initializeGUI();
        configure();

    }

    // methods
    private void configure() {
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationByPlatform(true);
        this.setVisible(true);
    }

    private void initializeGUI() {
        layout = new BorderLayout();
        buttonPanel = new JPanel(new GridLayout(1, 2));
        newGame = new JButton("New Game");
        newGame.addActionListener(new NewGameListener());
        buttonPanel.add(newGame, BorderLayout.CENTER);
        openGame = new JButton("Open Game");
        openGame.addActionListener(new OpenGameListener());
        buttonPanel.add(openGame, BorderLayout.CENTER);

        this.add(buttonPanel);
    }


    // listener classes

    // new game listener
    private class NewGameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            OpeningView.this.setVisible(false);
            new GameScreen();
            OpeningView.this.dispose();
        }
    }

    // open game listener
    private class OpenGameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // ToDo
        }
    }

}
