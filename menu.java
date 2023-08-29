package guessnumber;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu {

    private static JButton b1, b2, b3;
    private static JLabel l1;

    private static JFrame f; // Declare the JFrame here

    public static void run() {
        f = new JFrame();
        f.setSize(400, 300);
        f.setVisible(true);
        l1 = new JLabel("GUESS THE GAME ");
        b1 = new JButton("Play Game");
        b2 = new JButton("Select Mode");
        b3 = new JButton("Exit");
        l1.setBounds(130, 0, 150, 40);
        b1.setBounds(110, 50, 150, 40);
        b2.setBounds(110, 100, 150, 40);
        b3.setBounds(110, 150, 150, 40);
        f.getContentPane().setBackground(new Color(129,122,198));

        f.add(l1);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mode modeInstance = new mode(); 
                modeInstance.mode(); 
            }
        });
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        l1.setForeground(new Color(255, 255, 255)); 
     b1.setBackground(new Color(87, 59, 105)); 
     b1.setForeground(new Color(255, 255, 255)); 
     b2.setBackground(new Color(87, 59, 105)); 
      b2.setForeground(new Color(255, 255, 255)); 
      b3.setBackground(new Color(87, 59, 105)); 
        b3.setForeground(new Color(255, 255, 255)); 

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
              
            	guess.startGuessingGame(10);
            }
        });
    }

    public static void main(String[] args) {
        run();
    }
}
