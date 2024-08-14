package guessnumber;
//this is triyank

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Graphics;
public class guess extends JFrame {
   private JFrame f;
	private int randomNumber;
    private int attempts;
    private int maxAttempts;

    private JTextField tf;
    private JButton b1,b2;
    private JButton playAgain;
    private JLabel resultLabel;

    public guess(int maxAttempts) {
        super("Number Guessing Game");
       
        this.maxAttempts = maxAttempts;
        randomNumber = (int) (Math.random() * 100) + 1;
        attempts = 0;
        f=new JFrame();
        tf = new JTextField(20);
        b1 = new JButton("Guess");
        b2 = new JButton("Exit");
        playAgain = new JButton("Play Again");
        resultLabel = new JLabel("Guess a number between 1 and 100");

     
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String guessText = tf.getText();
                
                if (guessText.isEmpty()) {
                    JOptionPane.showMessageDialog(rootPane, "Please enter a guess.", "Empty Guess", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                int guess = Integer.parseInt(guessText);
                attempts++;

                if (guess == randomNumber) {
                	 resultLabel.setBounds(130,50,350,20);
                    resultLabel.setText("Congratulations! You guessed the number in " + attempts + " attempts.");
                   b1.setVisible(false);
                    playAgain.setVisible(true);
                } else if (attempts >= maxAttempts) {
                    JOptionPane.showMessageDialog(rootPane, "Game Over\nGuess No is :" +  randomNumber);
                    b1.setVisible(false);
                    playAgain.setVisible(true);
                    
                } else if (guess < randomNumber) {
                	resultLabel.setBounds(190,50,350,20);
                    resultLabel.setText("Too low. Attempts: " + attempts);
                } else if (guess > randomNumber) {
                	resultLabel.setBounds(190,50,350,20);
                	resultLabel.setText("Too high. Attempts: " + attempts);
                    
                }
            }
        });

        playAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	resultLabel.setBounds(140,50,350,20);
            	b1.setVisible(true);
                resetGame();
            }
        });
       b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });
       f.getContentPane().setBackground(new Color(0, 187, 148)); 

        b1.setBounds(140,130,100,30);
        playAgain.setBounds(140,130,100,30);
        b2.setBounds(260,130,80,30);
        tf.setBounds(180, 20, 120, 20);
        resultLabel.setBounds(130,50,350,20);
        b1.setBackground(new Color(50, 50, 50)); 
        b1.setForeground(new Color(255, 255, 255)); 
        b2.setBackground(new Color(50, 50, 50)); 
        b2.setForeground(new Color(255, 255, 255)); 
        playAgain.setBackground(new Color(50, 50, 50)); 
        playAgain.setForeground(new Color(255, 255, 255)); 
        f.setBackground(new Color(118, 53, 147));
        f.setLayout(null);
        f.add(tf);
        f.add(b1);
        f.add(resultLabel);
        f.add(playAgain);
        f.add(b2);
        playAgain.setVisible(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500, 300);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public void resetGame() {
        attempts = 0;
        randomNumber = (int) (Math.random() * 100) + 1;
        resultLabel.setText("Guess a number between 1 and 100");
        b1.setEnabled(true);
        playAgain.setVisible(false);
    }

    public static void startGuessingGame(int maxAttempts) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new guess(maxAttempts);
            }
        });
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                mode modeInstance = new mode();
                modeInstance.mode();
                int maxAttempts = modeInstance.getSelectedModeChances();
                startGuessingGame(11); 
            }
        });
    }
}
